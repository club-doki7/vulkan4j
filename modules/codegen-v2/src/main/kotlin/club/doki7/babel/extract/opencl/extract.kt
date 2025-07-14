package club.doki7.babel.extract.opencl

import club.doki7.babel.cdecl.RawFunctionType
import club.doki7.babel.cdecl.parseInlineFunctionPointerField
import club.doki7.babel.cdecl.parseStructFieldDecl
import club.doki7.babel.cdecl.toType
import club.doki7.babel.registry.*
import club.doki7.babel.util.*
import org.w3c.dom.Element
import org.w3c.dom.Node
import java.math.BigInteger
import java.util.logging.Logger
import kotlin.io.path.Path

internal val log = Logger.getLogger("c.d.b.extract.openxr")
private val inputDir = Path("codegen-v2/input")

fun main() {
    val reg = extractOpenCLRegistry()
}

fun extractOpenCLRegistry(): Registry<OpenCLRegistryExt> {
    val reg = inputDir.resolve("cl.xml")
        .toFile()
        .readText()
        .parseXML()
        .extractEntities()

    reg.renameEntities()
    reg.addDependencies()
    return reg
}

private fun <T : Entity> Sequence<T>.associate(): MutableMap<Identifier, T> {
    return associateByTo(mutableMapOf(), Entity::name)
}

private fun Element.extractEntities(): Registry<OpenCLRegistryExt> {
    val e = this
    val typedefs = e.query("types/type[@category='define']")
        .filter(::isTypedefDefine)
        .mapNotNull(::extractTypedef)
        .associate()

    val opaqueHandleTypedefs = mutableMapOf<Identifier, OpaqueHandleTypedef>()
    val opaqueTypedefs = mutableMapOf<Identifier, OpaqueTypedef>()

    e.query("types/type[@category='define']")
        .filter(::isTypedefDefine)
        .mapNotNull(::extractHandleTypedef)
        .forEach {
            when (it) {
                is Either.Left<OpaqueHandleTypedef, *> -> opaqueHandleTypedefs.putEntityIfAbsent(it.value)
                is Either.Right<*, OpaqueTypedef> -> opaqueTypedefs.putEntityIfAbsent(it.value)
            }
        }

    val structuresAndUnions = e.query("types/type[@category='struct']")
        .map(::extractStruct)

    val structures = structuresAndUnions
        .map { it.first }
        .associate()

    val unions = structuresAndUnions
        .map { it.second }
        .flatMap { it }
        .associate()

    val constants = e.query("enums/enum")
        .map(::extractConstants)
        .associate()

    val counter = mutableMapOf<String, Int>()
    val funcTypedefs = mutableMapOf<Identifier, FunctionTypedef>()
    val commands = e.query("commands/command")
        .toList()       // so that we can use side effect in .map
        .map {
            extractCommand(it) { name, params, ret ->
                val idx = counter.getOrPut(name) { 0 }
                counter.put(name, idx + 1)
                val value = FunctionTypedef(name + "_$idx", params, ret)
                funcTypedefs.put(value.name, value)
                value
            }
        }.asSequence()
        .associate()

    // extract features/extensions

    val features = e.query("feature")
        .map(::extractFeatures)
        .associate()

    val extensions = e.query("extensions/extension")
        .map(::extractExtensions)
        .associate()

    return Registry(
        aliases = typedefs,
        constants = constants,
        commands = commands,
        functionTypedefs = funcTypedefs,
        opaqueHandleTypedefs = opaqueHandleTypedefs,
        opaqueTypedefs = opaqueTypedefs,
        structures = structures,
        unions = unions,
        ext = OpenCLRegistryExt(features, extensions)
    )
}

private fun String.sanitizeFlagBits() = replace("FlagBits", "Flags")

// copy from vulkan
private fun extractType(e: Element): Type {
    val identifier = IdentifierType(e.textContent.trim().sanitizeFlagBits().intern())

    // Array types, e.g.:
    // `<type>float</type> <name>matrix</name>[3][4]`
    // `<type>uint8_t</type> <name>deviceUUID</name>[<enum>VK_UUID_SIZE</enum>]`
    if (e.parentNode is Element) {
        val contents =
            e.parentNode.childNodes
                .toList()
                .filter { it.nodeType == Node.TEXT_NODE || (it is Element && it.tagName == "enum") }
                .joinToString("") { it.textContent }
                .trim()

        if (contents.startsWith('[') && contents.endsWith(']')) {
            val lengths = contents
                .removePrefix("[")
                .removeSuffix("]")
                .split("][")
                .map { it.trim().intern() }
                .reversed()

            var array = ArrayType(identifier, lengths[0])
            lengths.subList(1, lengths.size).forEach { array = ArrayType(array, it) }
            return array
        }
    }

    // Pointer types, e.g.:
    // `<type>void</type>*`
    // `const <type>char</type>* const*`
    val next = e.nextSibling?.textContent?.trim()
    if (next != null && next.startsWith("*")) {
        val previous = e.previousSibling ?: e.parentNode
        val const = previous?.textContent?.contains("const") ?: false
        val pointer = PointerType(identifier, const)
        return when {
            next.startsWith("* const*") -> PointerType(pointer, true)
            next.startsWith("**") -> PointerType(pointer, const)
            else -> pointer
        }
    }

    return identifier
}

/**
 * @param e in form `<some_tag>TYPE <name>NAME</name></some_tag>`
 */
private fun extractTypeJudgement(e: Element): Pair<String, Type> {
    val name = getName(e)
    val type = extractType(e.getFirstElement("type")!!)
    return name to type
}

/**
 * Extract the name child of given element
 */
private fun getName(e: Element): String {
    return e.getFirstElement("name")!!.textContent.trim()
}

fun isTypedefDefine(e: Element): Boolean {
    return e.textContent.trimStart().startsWith("typedef")
}

/**
 * @param e in form `<type category="define">typedef MAYBE_TYPE <name>NAME</name> </type>`
 */
fun extractTypedef(e: Element): Typedef? {
    val type = e.getFirstElement("type")
    val name = getName(e)
    if (type == null) return null

    return Typedef(name, extractType(type))
}

/**
 * @param e in form `<type category="define">typedef MAYBE_TYPE <name>NAME</name> </type>`
 */
fun extractHandleTypedef(e: Element): Either<OpaqueHandleTypedef, OpaqueTypedef>? {
    val type by e.children
    val nameNode = e.getFirstElement("name")!!
    val name = nameNode.textContent.trim()
    if (type != null) return null

    val isHandle = nameNode.previousSibling.textContent.trim().endsWith('*')
    return if (isHandle) {
        Either.Left(OpaqueHandleTypedef(name))
    } else {
        Either.Right(OpaqueTypedef(name, isHandle = true))
    }
}

/**
 * @param e in form `<type category="struct" name="NAME">MEMBER+</type>`
 */
fun extractStruct(e: Element): Pair<Structure, List<Structure>> {
    val name = e.getAttributeText("name")!!
    val membersAndUnions = e.getElementSeq("member")
        .map { extractMember(it, name) }

    val members = membersAndUnions.map { it.first }
    val unions = membersAndUnions.mapNotNull { it.second }

    return Structure(name, members.toMutableList()) to unions.toList()
}

/**
 * @param e in form `<member>TYPE <name>NAME</name></member>`
 */
fun extractMember(e: Element, structName: String): Pair<Member, Structure?> {
    val nameNode = e.getFirstElement("name")
    val typeNode = e.getFirstElement("type")

    if (nameNode != null && typeNode != null) {
        val name = nameNode.textContent.trim()
        val type = extractType(typeNode)
        return Member(name, type, null, null, null, false, null) to null
    } else {
        val content = e.textContent.trim()
        assert(content.startsWith("union"))
        val members = extractUnion(content.lines())
        val name = members.joinToString("_or_") { it.name.value }
        val union = Structure(structName + "_" + name, members)
        return Member(
            name,
            IdentifierType(union.name),
            null, null, null, false, null
        ) to union
    }
}

fun extractUnion(lines: List<String>): MutableList<Member> {
    val members = mutableListOf<Member>()
    var idx = 0
    while (idx < lines.size) {
        val line = lines[idx]
        if (line.startsWith("union")) {
            idx++
            continue
        }

        if (line.endsWith("}")) break

        val (decl, newIdx) = parseStructFieldDecl(lines, idx)
        decl.forEach {
            members.add(Member(it.name, it.type.toType(), null, null, null, false, null))
        }

        idx = newIdx
    }

    return members
}

/**
 * @param e in form `<enum value="MAYBE_SET" bitpos="MAYBE_SET" name="..." />`
 */
fun extractConstants(e: Element): Constant {
    val value = e.getAttributeText("value")
    val bitpos = e.getAttributeText("bitpos")
    val name = e.getAttributeText("name")!!
    val type: Type
    val finalValue: String

    if (value == null) {
        assert(bitpos != null)
        val pos = bitpos!!.parseDecOrHex().toInt()
        type = if (pos < 32) IdentifierTypes.uint32_t else IdentifierTypes.uint64_t
        val postfix = if (pos < 32) "" else "L"
        finalValue = "0x" + BigInteger.ONE.shiftLeft(pos).toString(16) + postfix
    } else {
        finalValue = value
        type = when {
            value[0] == '+' || value[0] == '-' -> "int32_t"
            value.contains('.') -> if (value.endsWith('f')) "float" else "double"
            name == "CL_LONG_MAX" || name == "CL_LONG_MIN" -> "int64_t"
            name == "CL_ULONG_MAX" -> "uint64_t"
            name == "CL_HUGE_VALF" -> "float"
            name == "CL_HUGE_VAL" -> "double"
            name == "CL_MAXFLOAT" -> "float"
            name == "CL_NAN" -> "float"      // TODO
            name == "CL_INFINITY" -> "float"     // TODO
            else -> "uint32_t"
        }.let(::IdentifierType)
    }

    return Constant(name, type, finalValue)
}

/**
 * @param e in form `<param>TYPE <name>NAME</name></param>`
 */
private fun extractParam(e: Element, funcTypedefRegister: (String, List<Type>, Type) -> FunctionTypedef): Param {
    val name = getName(e)
    val typeNode = e.getFirstElement("type")
    val type = if (typeNode == null) {
        val content = e.textContent
        assert(content.contains("CL_CALLBACK"))
        val (decl, _) = parseInlineFunctionPointerField(listOf("$content;"), 0)
        val funcType = decl.type as RawFunctionType
        val typedef =
            funcTypedefRegister(decl.name, funcType.params.map { it.second.toType() }, funcType.returnType.toType())
        IdentifierType(typedef.name)
    } else {
        extractType(typeNode)
    }

    return Param(name, type, null, null, true).apply {
        if (type is PointerType) {
            type.pointerToOne = true
        }
    }
}

/**
 * @param e in form `<command>PROTO PARAM*</command>`
 */
private fun extractCommand(e: Element, funcTypedefRegister: (String, List<Type>, Type) -> FunctionTypedef): Command {
    val (name, retType) = extractTypeJudgement(e.getFirstElement("proto")!!)

    val params = e.query("param")
        .map { extractParam(it, funcTypedefRegister) }
        .toList()

    return Command(
        name,
        params,
        retType,
        null, null
    )
}

/**
 * @param e in form `<require>TYPE_OR_ENUM_OR_COMMAND</require>`
 */
private fun extractRequire(e: Element): OpenCLRequire {
    val (headers, types) = e.getElementSeq("type")
        .map { it.getAttributeText("name")!! }
        .partition { it.endsWith(".h") }

    val enums = e.getElementSeq("enum")
        .map { it.getAttributeText("name")!!.intern() }
        .toList()

    val commands = e.getElementSeq("command")
        .map { it.getAttributeText("name")!!.intern() }
        .toList()

    return OpenCLRequire(types, enums, commands, headers)
}

/**
 * @param e in form `<feature api="opencl" name="NAME" number="FLOAT" comment="...">REQUIRE*</feature>`
 */
private fun extractFeatures(e: Element): OpenCLVersion {
    val name by e.attrs
    val number by e.attrs
    val requires = e.getElementSeq("require")
        .map(::extractRequire)
        .toList()

    return OpenCLVersion(name!!, number!!.toFloat(), requires)
}

private fun extractExtensions(e: Element): OpenCLExtension {
    val name by e.attrs
    val supported by e.attrs
    val revision by e.attrs
    val experimental by e.attrs
    val depends by e.attrs
    val ratified by e.attrs
    val promotedto by e.attrs
    val obsoletedby by e.attrs
    val condition by e.attrs
    val requires = e.getElementSeq("require")
        .map(::extractRequire)
        .toList()

    return OpenCLExtension(
        name!!,
        supported!!,
        revision!!,
        experimental == "true",
        depends, ratified, promotedto, obsoletedby, condition, requires
    )
}