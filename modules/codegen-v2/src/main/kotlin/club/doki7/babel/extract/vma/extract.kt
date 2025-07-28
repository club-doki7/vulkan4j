@file:Suppress("UNCHECKED_CAST")

package club.doki7.babel.extract.vma

import club.doki7.babel.cdecl.*
import club.doki7.babel.hparse.*
import club.doki7.sennaar.registry.*
import club.doki7.babel.util.isDecOrHexNumber
import club.doki7.babel.util.parseDecOrHex
import java.util.logging.Logger
import kotlin.io.path.Path
import kotlin.io.path.useLines

internal val inputDir = Path("codegen-v2/input")
internal val log = Logger.getLogger("c.d.b.extract.vma")

fun extractVMAHeader(): Registry {
    val headerFile = inputDir.resolve("vk_mem_alloc.h")
        .useLines { it.map(String::trim).toList() }

    val registry = Registry(ext = EmptyMergeable())

    hparse(
        headerParseConfig,
        registry,
        mutableMapOf(),
        headerFile,
        0
    )

    val reservedMember = Member(
        name = "reserved",
        type = ArrayType(
            element = PointerType(
                pointee = IdentifierType("void")
            ),
            length = "8".interned()
        ),
        values = null,
        len = null,
        altLen = null,
        optional = false,
        bits = null
    )

    val vmaVulkanFunctions = registry.structs["VmaVulkanFunctions".interned()]!!
    vmaVulkanFunctions.members.add(reservedMember)

    val vmaAllocatorCreateInfo = registry.structs["VmaAllocatorCreateInfo".interned()]!!
    vmaAllocatorCreateInfo.members.add(reservedMember)

    postprocessDoc(registry)
    registry.renameEntities()
    return registry
}

private val headerParseConfig = ParseConfig().apply {
    addRule(0, ::detectBlockDoxygen, ::parseAndSaveBlockDoxygen)
    addRule(0, ::detectTriSlashDoxygen, ::parseAndSaveTriSlashDoxygen)
    addRule(0, {
        if (it.startsWith("#ifdef VMA_IMPLEMENTATION")) {
            ControlFlow.RETURN
        } else {
            ControlFlow.NEXT
        }
    }, ::dummyAction)

    addRule(10, ::detectLineComment, ::nextLine)
    addRule(10, ::detectPreprocessor, ::nextLine)
    addRule(10, ::detectBlockComment, ::skipBlockComment)

    addRule(20, {
        if (it.startsWith("VK_DEFINE_HANDLE(") || it.startsWith("VK_DEFINE_NON_DISPATCHABLE_HANDLE(")) {
            ControlFlow.ACCEPT
        } else {
            ControlFlow.NEXT
        }
    }, ::parseOpaqueHandleTypedef)
    addRule(20, {
        if (it.startsWith("typedef") && it.contains("VKAPI_PTR") && it.contains("PFN_")) {
            ControlFlow.ACCEPT
        } else {
            ControlFlow.NEXT
        }
    }, ::parsePFNTypedef)
    addRule(20, ::detectNonOpaqueStructTypedef, ::parseAndSaveStructure)
    addRule(20, ::detectEnumTypedef, ::parseAndSaveEnumeration)
    addRule(20, {
        if (it.startsWith("VMA_CALL_PRE") && it.contains("VMA_CALL_POST")) {
            ControlFlow.ACCEPT
        } else {
            ControlFlow.NEXT
        }
    }, ::parseAndSaveFunctionDecl)
}

private fun parseOpaqueHandleTypedef(
    @Suppress("unused") registry: Registry,
    cx: MutableMap<String, Any>,
    lines: List<String>,
    index: Int
): Int {
    val line = lines[index]
    val handle = if (line.startsWith("VK_DEFINE_HANDLE(")) {
        val handleName = line.removePrefix("VK_DEFINE_HANDLE(").removeSuffix(")").trim()
        OpaqueHandleTypedef(name = handleName)
    } else /* if (line.startsWith("VK_DEFINE_NON_DISPATCHABLE_HANDLE(")) */ {
        val handleName = line.removePrefix("VK_DEFINE_NON_DISPATCHABLE_HANDLE(").removeSuffix(")").trim()
        OpaqueHandleTypedef(name = handleName)
    }

    if ("doxygen" in cx) {
        handle.doc = cx["doxygen"] as List<String>
        cx.remove("doxygen")
    }

    registry.opaqueHandleTypedefs.putEntityIfAbsent(handle)
    return index + 1
}

private fun parsePFNTypedef(
    registry: Registry,
    cx: MutableMap<String, Any>,
    lines: List<String>,
    index: Int
): Int {
    val parseResult = parseTypedefDecl(lines, index)
    val typedef = parseResult.first
    val nextIndex = parseResult.second

    val functionTypedef = morphFunctionTypedef(typedef)
    if ("doxygen" in cx) {
        functionTypedef.doc = cx["doxygen"] as List<String>
        cx.remove("doxygen")
    }
    registry.functionTypedefs.putEntityIfAbsent(functionTypedef)
    return nextIndex
}

private fun parseAndSaveStructure(
    registry: Registry,
    cx: MutableMap<String, Any>,
    lines: List<String>,
    index: Int
): Int {
    if ("doxygen" in cx) {
        cx["structureDoc"] = cx["doxygen"]!!
        cx.remove("doxygen")
    }

    val structureName = lines[index].removePrefix("typedef struct").trim()
    val next = hparse(structureParseConfig, registry, cx, lines, index + 2)
    val fields = cx["fields"] as MutableList<Member>
    cx.remove("fields")

    val structure = Structure(
        name = structureName,
        members = fields
    )
    if ("structureDoc" in cx) {
        structure.doc = cx["structureDoc"] as List<String>
        cx.remove("structureDoc")
    }
    registry.structs.putEntityIfAbsent(structure)

    assert(lines[next].startsWith("}") && lines[next].endsWith(";"))
    return next + 1
}

private val structureParseConfig = ParseConfig().apply {
    addInit { it["fields"] = mutableListOf<Member>() }

    addRule(
        -5,
        { if (it.startsWith("#else")) ControlFlow.ACCEPT else ControlFlow.NEXT },
        { _, _, _, index -> index + 3 }
    )
    addRule(0, { line -> if (line.startsWith("}")) ControlFlow.RETURN else ControlFlow.NEXT }, ::dummyAction)
    addRule(0, ::detectBlockDoxygen, ::parseAndSaveBlockDoxygen)
    addRule(0, ::detectTriSlashDoxygen, ::parseAndSaveTriSlashDoxygen)
    addRule(10, ::detectLineComment, ::nextLine)
    addRule(10, ::detectPreprocessor, ::nextLine)
    addRule(10, ::detectBlockComment, ::skipBlockComment)
    addRule(99, { _ -> ControlFlow.ACCEPT }, ::parseStructField)
}

private fun parseStructField(
    @Suppress("unused") registry: Registry,
    cx: MutableMap<String, Any>,
    lines: List<String>,
    index: Int
): Int {
    val (declList, nextIndex) = parseStructFieldDecl(lines, index)
    assert(declList.size == 1)
    val decl = declList[0]

    val member = Member(
        name = decl.name,
        type = decl.type.toType(),
        values = null,
        len = null,
        altLen = null,
        optional = decl.type.trivia.any { trivia -> trivia.startsWith("VMA_NULLABLE") },
        bits = null
    )
    if ("doxygen" in cx) {
        member.doc = cx["doxygen"] as List<String>
        cx.remove("doxygen")
    }

    (cx["fields"] as MutableList<Member>).add(member)
    return nextIndex
}

private fun parseAndSaveEnumeration(
    registry: Registry,
    cx: MutableMap<String, Any>,
    lines: List<String>,
    index: Int
): Int {
    if ("doxygen" in cx) {
        cx["enumerationDoxygen"] = cx["doxygen"]!!
        cx.remove("doxygen")
    }

    val enumName = lines[index].removePrefix("typedef enum").trim()
    val next = hparse(enumerationParseConfig, registry, cx, lines, index + 2)
    val enumerators = cx["enumerators"] as MutableList<Pair<EnumeratorDecl, List<String>?>>
    cx.remove("enumerators")

    val entity = if (enumName.endsWith("FlagBits")) {
        val actualName = enumName.replace("FlagBits", "Flags")
        val bitmask = Bitmask(
            name = actualName,
            bitwidth = 32,
            bitflags = enumerators.map { (enumDecl, doc) ->
                val bitflag = if (enumDecl.value.isDecOrHexNumber()) {
                    Bitflag(
                        name = enumDecl.name,
                        value = enumDecl.value.parseDecOrHex().toBigInteger()
                    )
                } else {
                    Bitflag(
                        name = enumDecl.name,
                        value = enumDecl.value.split("|").map(String::trim).toMutableList()
                    )
                }
                bitflag.doc = doc
                bitflag
            }.toMutableList()
        )
        registry.bitmasks.putEntityIfAbsent(bitmask)
        bitmask
    } else {
        val enumeration = Enumeration(
            name = enumName,
            variants = enumerators.map { (enumDecl, doc) ->
                val variant = try {
                    EnumVariant(
                        name = enumDecl.name,
                        value = enumDecl.value.parseDecOrHex()
                    )
                } catch (_: NumberFormatException) {
                    EnumVariant(
                        name = enumDecl.name,
                        value = enumDecl.value.split("|").map(String::trim)
                    )
                }
                variant.doc = doc
                variant
            }.toMutableList()
        )
        registry.enumerations.putEntityIfAbsent(enumeration)
        enumeration
    }

    if ("enumerationDoxygen" in cx) {
        entity.doc = cx["enumerationDoxygen"] as List<String>
        cx.remove("enumerationDoxygen")
    }

    assert(lines[next].startsWith("}") && lines[next].endsWith(";"))
    return next + 1
}

val enumerationParseConfig = ParseConfig().apply {
    addInit { it["enumerators"] = mutableListOf<Pair<EnumeratorDecl, List<String>?>>() }

    addRule(0, { line -> if (line.startsWith("}")) ControlFlow.RETURN else ControlFlow.NEXT }, ::dummyAction)
    addRule(0, ::detectBlockDoxygen, ::parseAndSaveBlockDoxygen)
    addRule(0, ::detectTriSlashDoxygen, ::parseAndSaveTriSlashDoxygen)
    addRule(10, ::detectLineComment, ::nextLine)
    addRule(10, ::detectPreprocessor, ::nextLine)
    addRule(10, ::detectBlockComment, ::skipBlockComment)
    addRule(99, { _ -> ControlFlow.ACCEPT }, ::parseEnumerator)
}

fun parseEnumerator(
    @Suppress("unused") registry: Registry,
    cx: MutableMap<String, Any>,
    lines: List<String>,
    index: Int
): Int {
    val parseResult = parseEnumeratorDecl(lines, index)
    val enumDecl = parseResult.first
    val nextIndex = parseResult.second

    var enumeratorDoc: List<String>? = null
    if ("doxygen" in cx) {
        enumeratorDoc = cx["doxygen"] as List<String>
        cx.remove("doxygen")
    }

    (cx["enumerators"] as MutableList<Pair<EnumeratorDecl, List<String>?>>).add(Pair(enumDecl, enumeratorDoc))
    return nextIndex
}

private fun parseAndSaveFunctionDecl(
    registry: Registry,
    cx: MutableMap<String, Any>,
    lines: List<String>,
    index: Int
): Int {
    val parseResult = parseFunctionDecl(lines, index)
    val functionDecl = parseResult.first
    val nextIndex = parseResult.second

    val command = morphFunctionDecl(functionDecl)
    if ("doxygen" in cx) {
        command.doc = cx["doxygen"] as List<String>
        cx.remove("doxygen")
    }
    registry.commands.putEntityIfAbsent(command)

    return nextIndex
}

private fun morphFunctionDecl(functionDecl: FunctionDecl) = Command(
    name = functionDecl.name,
    params = functionDecl.params.map {
        Param(
            name = it.name,
            type = it.type.toType(),
            len = null,
            argLen = null,
            optional = it.type.trivia.any { trivia -> trivia.startsWith("VMA_NULLABLE") },
        )
    },
    result = functionDecl.returnType.toType(),
    successCodes = null,
    errorCodes = null
)

private fun morphFunctionTypedef(typedef: TypedefDecl) = FunctionTypedef(
    name = typedef.name,
    params = (typedef.aliasedType as RawFunctionType).params.map { it.second.toType() },
    result = typedef.aliasedType.returnType.toType()
)
