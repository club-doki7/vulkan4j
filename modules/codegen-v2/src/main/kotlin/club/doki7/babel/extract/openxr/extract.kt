package club.doki7.babel.extract.openxr

import club.doki7.babel.cdecl.*
import club.doki7.sennaar.registry.*
import club.doki7.babel.util.*
import org.w3c.dom.Element
import org.w3c.dom.Node
import java.math.BigInteger
import java.util.logging.Logger
import kotlin.io.path.Path

internal val log = Logger.getLogger("c.d.b.extract.openxr")
private val inputDir = Path("codegen-v2/input")

fun main() {
    extractRawOpenXRRegistry()
}

fun extractRawOpenXRRegistry(): Registry<OpenXRRegistryExt> {
    val ret = inputDir.resolve("xr.xml")
        .toFile()
        .readText()
        .parseXML()
        .extractEntities()
        .filterEntities()
    ret.extendEntities()
    return ret
}

private fun <T: Entity> Sequence<T>.associate(): MutableMap<Identifier, T> {
    return associateByTo(mutableMapOf(), Entity::name)
}

private fun Element.extractEntities(): Registry<OpenXRRegistryExt> {
    val e = this

    val opaqueHandles: MutableMap<Identifier, OpaqueHandleTypedef> = mutableMapOf()
    val typedefs: MutableMap<Identifier, Typedef> = mutableMapOf()
    val constants: MutableMap<Identifier, Constant> = mutableMapOf()

    e.query("types/type[@category='define']")
        .mapNotNull(::extractMacroConstant)
        .associateByTo(constants, Entity::name)

    e.query("types/type[@category='basetype']")
        .map(::extractBasetype)
        .forEach {
            when (it) {
                is Either.Left<OpaqueHandleTypedef, Typedef> -> opaqueHandles.putEntityIfAbsent(it.value)
                is Either.Right<OpaqueHandleTypedef, Typedef> -> typedefs.putEntityIfAbsent(it.value)
            }
        }

    e.query("types/type[@category='handle']")
        .map(::extractHandle)
        .associateByTo(opaqueHandles, Entity::name)

    val structs = e.query("types/type[@category='struct' and not(@alias)]")
        .map(::extractStruct)
        .associate()

    e.query("types/type[@category='struct' and @alias]")
        .map(::extractAlias)
        .forEach { (name, rawAlias) ->
            val aliasTo = rawAlias.interned()
            val origin = structs[aliasTo] ?: error("Missing aliased structure: $aliasTo")
            val alias = Structure(name, origin.members)
            structs.putEntityIfAbsent(alias)
        }

    e.query("enums[@name='API Constants']/enum")
        .map(::extractConstant)
        .associateByTo(constants, Entity::name)

    val enums = e.query("enums[@type='enum']")
        .map(::extractEnumeration)
        .associate()

    val bitmasks = e.query("enums[@type='bitmask']")
        .map(::extractBitmask)
        .associate()

    val commands = e.query("commands/command[not(@alias)]")
        .map(::extractCommand)
        .associate()
        .toMutableMap()

    val funcs = e.query("types/type[@category='funcpointer']")
        .map(::extractFunctionTypedef)
        .associate()

    e.query("commands/command[@alias]")
        .map(::extractAlias)
        .forEach { (name, rawAlias) ->
            val aliasTo = rawAlias.interned()
            val origin = commands[aliasTo] ?: error("Missing aliased command: $aliasTo")
            val alias = origin.aliasBy(name.interned())
            commands.putEntityIfAbsent(alias)
        }

    val features = e.query("feature[@api]")
        .map(::extractFeature)
        .associate()

    val extensions = e.query("extensions/extension")
        .map(::extractExtension)
        .filter { it.supported != "disabled" }
        .associate()

    return Registry(
        aliases = typedefs,
        bitmasks = bitmasks,
        constants = constants,
        commands = commands,
        enumerations = enums,
        functionTypedefs = funcs,
        opaqueHandleTypedefs = opaqueHandles,
        structures = structs,
        ext = OpenXRRegistryExt(features, extensions)
    )
}

private const val XR_DEFINE_ATOM = "XR_DEFINE_ATOM"
private const val XR_DEFINE_OPAQUE_64 = "XR_DEFINE_OPAQUE_64"

private typealias OpaqueDefine = Either<OpaqueHandleTypedef, Typedef>

private fun XR_DEFINE_ATOM(value: String): Typedef {
    return Typedef(value, IdentifierType("uint64_t"))
}

// OpenXR uses uint64_t for opaque handles on 32-bit platforms. However, Java 22+ supports
// 64-bit platforms only, so we don't need to handle the "compatibility" here.
private fun XR_DEFINE_HANDLE(name: String) = OpaqueHandleTypedef(name)

private fun XR_DEFINE_OPAQUE_64(name: String) = XR_DEFINE_HANDLE(name)

/**
 * @param e in form `<type category="define">MACRO</type>`.
 *          `#if`, `#define` and function `#define` are acceptable, but only constant `#define` will be extracted.
 */
private fun extractMacroConstant(e: Element): Constant? {
    val defineText = e.firstChild!!.textContent.trim()
    // `#if`
    if (!defineText.startsWith("#define")) return null

    val name = e.getFirstElement("name")!!
    val nameString = name.textContent.trim()
    val definedAs = name.nextSibling!!.textContent.trim()

    if (ignoredDefineConstants.contains(nameString)) {
        return null
    }

    // function `#define`
    if (definedAs.startsWith('(')) return null

    val (type, value) = when {
        definedAs.endsWith("LL") -> Pair("int64_t", definedAs.replace("LL", "L"))
        definedAs.endsWith("u") -> Pair("uint32_t", definedAs.removeSuffix("u"))
        else -> Pair("uint32_t", definedAs)
    }

    return Constant(nameString, IdentifierType(type), value)
}

private val ignoredDefineConstants = setOf(
    "XR_FACE_EXPRESSSION_SET_DEFAULT_FB",
    "XR_MAX_EVENT_DATA_SIZE",
)

/**
 * @param e in form `<type>typedef <type>TYPE</type> <name>NAME</name></type>`
 */
private fun extractTrivialTypedef(e: Element): Typedef {
    val type = e.getFirstElement("type")!!.textContent
    val name = e.getFirstElement("name")!!.textContent
    return Typedef(name, parseType(type).toType())
}

/**
 * @param e in form `<type category="basetype">...<type>TYPE_OR_MACRO</type>...<name>NAME</name>...</type>`
 */
private fun extractBasetype(e: Element): OpaqueDefine {
    val typeOrMacro = e.getFirstElement("type")!!.textContent
    val name = getName(e)

    return when (typeOrMacro) {
        XR_DEFINE_ATOM -> Either.Right(XR_DEFINE_ATOM(name))
        XR_DEFINE_OPAQUE_64 -> Either.Left(XR_DEFINE_OPAQUE_64(name))
        else -> {
            Either.Right(extractTrivialTypedef(e))
        }
    }
}

/**
 * @param e in form `<type category="handle" parent="MAY_OR_MAY_NOT_SET"><type>XR_DEFINE_HANDLE</type>(<name>NAME</name>)</type>`
 */
private fun extractHandle(e: Element): OpaqueHandleTypedef {
    val name = getName(e)
    return XR_DEFINE_HANDLE(name)
}

/**
 * @param e in form `<type category="struct" name="NAME" structextends="MAYBE_SET" parentstruct="MAYBE_SET" protect="MAYBE_SET" returnonly="MAYBE_SET" mayalias="MAYBE_SET">MEMBER+</type>`
 */
private fun extractStruct(e: Element): Structure {
    val name by e.attrs
    val structextends by e.attrs
    val parentstruct by e.attrs
    val protect by e.attrs
    val returnonly by e.attrs
    val mayalias by e.attrs
    val members = e.getElementSeq("member")
        .map(::extractMember)
        .toMutableList()

    for (member in members) {
        if (member.len != null && member.len.isNotEmpty()) {
            val lenPath0 = member.len[0]
            if (lenPath0.original == "null-terminated") {
                continue
            }
            val lenMember = members.find { it.name == lenPath0 }
            if (lenMember == null) {
                continue
            }
            member.optional = lenMember.optional
        }
    }

    return Structure(name!!, members).apply {
        setExt(
            XrStructMetadata(
                structextends,
                parentstruct,
                protect,
                returnonly == "true",
                mayalias == "true"
            )
        )
    }
}

/**
 * Extract the text of given element without `<name>` tag.
 */
private fun getElementTextWithoutName(e: Element): String {
    return e.childNodes.asSequence()
        .filter { !(it is Element && it.tagName == "name") }
        .joinToString(separator = " ") { it.textContent.trim() }
}

/**
 * Extract the name child of given element
 */
private fun getName(e: Element): String {
    return e.getFirstElement("name")!!.textContent.trim()
}

private fun commaList(s: String?): List<Identifier>? {
    return s?.split(',')?.map { it.interned() }
}

/**
 * @param e in form `<member values="..." optional="..." len="...">... <name>NAME</name></member>`
 */
private fun extractMember(e: Element): Member {
    val values by e.attrs
    val optional by e.attrs
    val len by e.attrs
    val (name, type) = extractTypeJudgement(e)

    // len is a comma separated (identifier | "null-terminated") list
    val lenList = commaList(len)

    return Member(
        name,
        type,
        values?.interned(),
        lenList,
        null,
        optional == "true",
        null
    )
}

// copy from vulkan
private fun extractType(e: Element): Type {
    val identifier = IdentifierType(e.textContent.trim().sanitizeFlagBits().interned())

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
                .map { it.trim().interned() }
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

private data class EnumLike(val name: String, val value: String)

private fun extractEnumLike(e: Element): EnumLike {
    val value by e.attrs
    val name by e.attrs

    return EnumLike(name!!, value!!)
}

private fun extractConstant(e: Element): Constant {
    return extractEnumLike(e).run {
        Constant(
            name,
            IdentifierType("uint32_t"),
            value
        )
    }
}

/**
 * @param e in form `<enum value="INTEGER" name="NAME" comment="..." />`
 */
private fun extractEnumVariant(e: Element): EnumVariant {
    return extractEnumLike(e).let {
        EnumVariant(it.name, it.value.parseDecOrHex())
    }
}

/**
 * @param e in form `<enums name="NAME" type="enum" comment="...">ENUM*</enums>`
 */
private fun extractEnumeration(e: Element): Enumeration {
    val name by e.attrs
    val enums = e.getElementSeq("enum")
        .map(::extractEnumVariant)
        .toMutableList()

    return Enumeration(name!!, enums)
}

private fun String.sanitizeFlagBits() = replace("FlagBits", "Flags")

/**
 * @param e in form `<enum bitpos="INTEGER" name="NAME" comment="..." />`
 */
private fun extractBitflag(e: Element): Bitflag {
    val bitpos by e.attrs
    val name by e.attrs

    val bitposNum = bitpos!!.parseDecOrHex()
    return Bitflag(name!!, BigInteger.ONE.shiftLeft(bitposNum.toInt()))
}

/**
 * @param e in form `<enums name="NAME" type="bitmask" comment="...">BITFLAG*</enums>`
 */
private fun extractBitmask(e: Element): Bitmask {
    val name by e.attrs
    val flags = e.getElementSeq("enum")
        .map(::extractBitflag)
        .toMutableList()

    return Bitmask(name!!.sanitizeFlagBits(), 64, flags)
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
 * @param e in form `<param len="MAYBE_SET" externsync="MAYBE_SET" optional="MAYBE_SET">TYPE <name>NAME</name></param>`
 */
private fun extractParam(e: Element): Param {
    val (name, type) = extractTypeJudgement(e)
    val len by e.attrs
    val externsync by e.attrs
    val optional by e.attrs

    return Param(name, type, len?.interned(), null, optional == "true").apply {
        if (len == null && type is PointerType) {
            type.pointerToOne = true
        }
        setExt(XrParamMetadata(externsync))
    }
}

/**
 * @param e in form `<command successcodes="SUCC_CODE*" errorcodes="ERROR_CODE*">PROTO PARAM*</command>`
 */
private fun extractCommand(e: Element): Command {
    val successcodes by e.attrs
    val errorcodes by e.attrs
    val (name, retType) = extractTypeJudgement(e.getFirstElement("proto")!!)

    val params = e.query("param")
        .map(::extractParam)
        .toList()

    return Command(
        name,
        params,
        retType,
        commaList(successcodes),
        commaList(errorcodes)
    )
}

private data class Aliasing(val name: String, val aliasTo: String)

/**
 * @param e in form `<some_tag name="NAME" alias="ALIAS"></some_tag>`
 */
private fun extractAlias(e: Element): Aliasing {
    val name by e.attrs
    val alias by e.attrs
    return Aliasing(name!!, alias!!)
}

private fun morphFunctionTypedef(typedef: TypedefDecl) = FunctionTypedef(
    name = typedef.name,
    params = (typedef.aliasedType as RawFunctionType).params.map { it.second.toType() },
    result = typedef.aliasedType.returnType.toType()
)

/**
 * @param e in form `<type category="funcpointer" requires="MAYBE_SET">RAW_C_TYPEDEF+</type>`
 */
private fun extractFunctionTypedef(e: Element): FunctionTypedef {
    val requires by e.attrs
    val content = e.textContent.trim()
    val typedefs = content.split(';')
    val typedef = typedefs[typedefs.size - 2] + ';'
    val (rawTypedef, _) = parseTypedefDecl(typedef.lines(), 0)
    return morphFunctionTypedef(rawTypedef)
}

/**
 * @param e in form `<feature api="openxr" name="NAME" number="NUMBER">REQUIRE*</feature>`
 */
private fun extractFeature(e: Element): OpenXRVersion {
    val name by e.attrs
    val number by e.attrs
    val requires = e.getElementSeq("require")
        .map(::extractRequire)
        .toList()

    return OpenXRVersion(name!!, number!!.toFloat(), requires)
}

/**
 * @param e in form `<require comment="MAYBE_SET" depends="MAYBE_SET">ENTITY*</require>`
 *          where `ENTITY` can be: `type`, `enum`, `command`, `interaction_profile`, `extend`
 */
private fun extractRequire(e: Element): Require {
    val comment by e.attrs
    val extend by e.attrs

    val types = e.getElementSeq("type").map { it.getAttributeText("name")!! }.toList()
    val values = e.getElementSeq("enum").map(::extractRequireValue).toList()
    val commands = e.getElementSeq("command").map { it.getAttributeText("name")!!.interned() }.toList()
    val interactionProfiles = e.getElementSeq("interaction_profile").map { it.getAttributeText("name")!! }.toList()
    val extends = e.getElementSeq("extend").map(::extractExtends).toList()

    return Require(comment, extend, types, values, commands, interactionProfiles, extends)
}

/**
 * TODO: fix this stupid thing:
 *             <extend interaction_profile_predicate="true">
 *                 <condition>
 *                     <user_path path="/user/hand/left"/>
 *                     <component subpath="/input/grip/pose" type="XR_ACTION_TYPE_POSE_INPUT"/>
 *                 </condition>
 *                 <user_path path="/user/detached_controller_meta/left" inherit="/user/hand/left"/>
 *             </extend>
 *
 * @param e in form `<extend interaction_profile_path="...">COMPONENT*</extend>`
 */
private fun extractExtends(e: Element): Extend {
    val interaction_profile_path by e.attrs
    val components = e.getElementSeq("component")
        .map(::extractComponent)
        .toList()

    return Extend(interaction_profile_path, components)
}

/**
 * @param e in form `<component subpath="..." type="..." />`
 */
private fun extractComponent(e: Element): Extend.Component {
    val subpath by e.attrs
    val type by e.attrs
    return Extend.Component(subpath!!, type!!.interned())
}

/**
 * @param e in form `<enum name="..." extends="..." value="..." bitpos="..." offset="..." dir="..." alias="..." comment="..." />`
 */
private fun extractRequireValue(e: Element): RequireValue {
    val name by e.attrs
    val extends by e.attrs
    val value by e.attrs
    val bitpos by e.attrs
    val offset by e.attrs
    val dir by e.attrs
    val alias by e.attrs
    val extnumber by e.attrs

    return RequireValue(
        name!!,
        extends,
        value,
        bitpos?.parseDecOrHex(),
        offset?.parseDecOrHex(),
        dir == "-",
        alias,
        extnumber?.parseDecOrHex()
    )
}

/**
 * @param e in form
 *          ```
 *          <extension name="..."
 *                     number="INTEGER"
 *                     type="..."
 *                     supported="..."
 *                     depends="?"
 *                     provisional="BOOLEAN?"
 *                     ratified="?"
 *                     promotedto="VERSION_NAME?"
 *                     deprecatedBy="?">
 *              REQUIRE*
 *          </extension>`
 */
private fun extractExtension(e: Element): OpenXRExtension {
    val name by e.attrs
    val number by e.attrs
    val type by e.attrs
    val supported by e.attrs
    // optional
    val depends by e.attrs
    val provisional by e.attrs
    val ratified by e.attrs
    val promotedto by e.attrs
    val deprecatedBy by e.attrs

    val requires = e.getElementSeq("require").map(::extractRequire).toList()

    return OpenXRExtension(
        name!!,
        number!!.parseDecOrHex(),
        type!!,
        supported!!,
        depends,
        provisional == "true",
        ratified,
        promotedto?.interned(),
        deprecatedBy,
        requires
    )
}
