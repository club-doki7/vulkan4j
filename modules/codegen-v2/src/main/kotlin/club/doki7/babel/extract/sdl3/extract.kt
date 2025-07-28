@file:Suppress("UNCHECKED_CAST")

package club.doki7.babel.extract.sdl3

import club.doki7.babel.cdecl.*
import club.doki7.babel.hparse.ControlFlow
import club.doki7.babel.hparse.ParseConfig
import club.doki7.babel.hparse.detectBlockComment
import club.doki7.babel.hparse.detectBlockDoxygen
import club.doki7.babel.hparse.detectFunctionAlikeMacro
import club.doki7.babel.hparse.detectIfdefCplusplus
import club.doki7.babel.hparse.detectLineComment
import club.doki7.babel.hparse.detectPreprocessor
import club.doki7.babel.hparse.detectTriSlashDoxygen
import club.doki7.babel.hparse.dummyAction
import club.doki7.babel.hparse.hparse
import club.doki7.babel.hparse.log
import club.doki7.babel.hparse.nextLine
import club.doki7.babel.hparse.parseAndSaveBlockDoxygen
import club.doki7.babel.hparse.parseAndSaveTriSlashDoxygen
import club.doki7.babel.hparse.skipBlockComment
import club.doki7.babel.hparse.skipIfdefCplusplusExternC
import club.doki7.babel.hparse.skipPreprocessor
import club.doki7.sennaar.registry.*
import club.doki7.babel.util.parseDecOrHex
import java.util.logging.Logger
import kotlin.io.path.Path

private val inputDir = Path("codegen-v2/input")
internal val log = Logger.getLogger("c.d.b.extract.sdl3")

fun extractSDLRegistry(): Registry {
    val indexFileContent = inputDir.resolve("SDL3-3.2.14/include/SDL3/SDL.h")
        .toFile()
        .readText()
        .splitToSequence('\n')
        .map(String::trim)

    val filesToParse = indexFileContent.filter { it.startsWith("#include") }
        .map { it.removePrefix("#include <SDL3/").removeSuffix(">") }
        .toMutableSet()

    filesToParse.remove("SDL_assert.h")
    filesToParse.remove("SDL_bits.h")
    filesToParse.remove("SDL_config.h")
    filesToParse.remove("SDL_oldnames.h")

    val registry = Registry(ext = EmptyMergeable())
    for (fileName in filesToParse) {
        val headerRegistry = extractOneSDL3Header(fileName)
        registry += headerRegistry
    }
    registry.enumerations.values.forEach(::postprocessEnumeration)

    addSDLGamepadBindings(registry)

    while (registry.constants.values.any { it.type.ident.original == "INDETERMINATE" }) {
        val postprocessedConstants = registry.constants.values.map { postprocessConstant(registry, it) }
        registry.constants.clear()
        for (constant in postprocessedConstants) {
            registry.constants.putEntityIfAbsent(constant)
        }
    }

    registry.constants.putEntityIfAbsent(Constant(
        name = "SDL_MESSAGEBOX_COLOR_COUNT",
        type = IdentifierType("uint32_t"),
        expr = registry.enumerations["SDL_MessageBoxColorType".interned()]!!.variants.size.toString(),
    ))

    registry.renameEntities()
    postprocessDoc(registry)
    return registry
}

private fun extractOneSDL3Header(fileName: String): Registry {
    val lines = inputDir.resolve("SDL3-3.2.14/include/SDL3/$fileName")
        .toFile()
        .readText()
        .splitToSequence('\n')
        .map(String::trim)
        .toList()

    val registry = Registry(ext = EmptyMergeable())
    hparse(
        config = headerParseConfig,
        registry = registry,
        cx = mutableMapOf("doxygen" to mutableListOf<String>()),
        lines = lines,
        index = 0
    )

    return registry
}

private val headerParseConfig = ParseConfig().apply {
    addRule(0, ::detectBlockDoxygen, ::parseAndSaveBlockDoxygen)
    addRule(0, ::detectTriSlashDoxygen, ::parseAndSaveTriSlashDoxygen)

    addRule(10, ::detectLineComment, ::nextLine)
    addRule(10, ::detectBlockComment, ::skipBlockComment)
    addRule(10, ::detectFunctionAlikeMacro, ::reportAndSkipPreprocessor)

    addRule(
        20,
        { if (it.startsWith("#define")) ControlFlow.ACCEPT else ControlFlow.NEXT },
        ::parseConstDef
    )
    addRule(
        20,
        { if (it.startsWith("typedef struct") && it.endsWith(";") && !it.contains("{") && !it.contains("}")) ControlFlow.ACCEPT else ControlFlow.NEXT },
        ::parseOpaqueTypedef
    )
    addRule(
        20,
        { if (it.startsWith("typedef struct") && it.endsWith(";") && it.contains("{") && it.contains("}")) ControlFlow.ACCEPT else ControlFlow.NEXT },
        ::nextLine
    )
    addRule(
        20,
        { if (it.startsWith("SDL_FORCE_INLINE")) ControlFlow.ACCEPT else ControlFlow.NEXT },
        ::skipInlineFunction
    )
    addRule(
        20,
        { if (it.startsWith("typedef") && (it.contains("SDLCALL") || it.contains("(*SDL_"))) ControlFlow.ACCEPT else ControlFlow.NEXT },
        ::parseCallbackTypedef
    )
    addRule(
        20,
        { if (it.startsWith("extern SDL_DECLSPEC")) ControlFlow.ACCEPT else ControlFlow.NEXT },
        ::parseAndSaveFunctionDecl
    )
    addRule(
        20,
        { if (it == "typedef union _XEvent XEvent;") ControlFlow.ACCEPT else ControlFlow.NEXT },
        ::nextLine
    )

    addRule(
        30,
        { if (it.startsWith("typedef struct")) ControlFlow.ACCEPT else ControlFlow.NEXT },
        { registry, cx, lines, index -> parseAndSaveStructure(registry, cx, lines, index, isUnion = false) }
    )
    addRule(
        30,
        { if (it.startsWith("typedef union")) ControlFlow.ACCEPT else ControlFlow.NEXT },
        { registry, cx, lines, index -> parseAndSaveStructure(registry, cx, lines, index, isUnion = true) }
    )
    addRule(
        30,
        { if (it.startsWith("typedef enum")) ControlFlow.ACCEPT else ControlFlow.NEXT },
        ::parseAndSaveEnumeration
    )

    addRule(
        40,
        { if (it.startsWith("typedef") && it.endsWith(";")) ControlFlow.ACCEPT else ControlFlow.NEXT },
        ::parseAndSaveTypedef
    )

    addRule(50, ::detectIfdefCplusplus, ::skipIfdefCplusplusExternC)
    addRule(
        50,
        { if (it.startsWith("struct") && !it.endsWith(";")) ControlFlow.ACCEPT else ControlFlow.NEXT},
        ::skipStructBody
    )
    addRule(99, ::detectPreprocessor, ::skipPreprocessor)
}

private fun reportAndSkipPreprocessor(
    registry: Registry,
    cx: MutableMap<String, Any>,
    lines: List<String>,
    index: Int
): Int {
    log.info("[FUNC-MACRO] skipping function-alike directive at line ${index + 1}: ${lines[index]}")
    return skipPreprocessor(registry, cx, lines, index)
}

private fun parseConstDef(
    registry: Registry,
    cx: MutableMap<String, Any>,
    lines: List<String>,
    index: Int
): Int {
    val doc = cx["doxygen"] as? List<String>
    cx.remove("doxygen")

    val line = lines[index]
    val (constantName: String, constantValue: String, nextLine: Int) = if (line.endsWith("\\")) {
        val name = line.removePrefix("#define").removeSuffix("\\").trim()
        Triple(name, lines[index + 1], index + 2)
    } else {
        val parts = line.removePrefix("#define").trim().split(" ", limit = 2)
        if (parts.size < 2) {
            if (!parts[0].lowercase().endsWith("_h") && !parts[0].lowercase().endsWith("_h_")) {
                log.warning("skipping empty constant definition at line ${index + 1}: $line")
            }
            return index + 1
        }
        Triple(parts[0].trim(), parts[1].trim(), index + 1)
    }

    if (constantName in skippedMacroConstants) {
        return nextLine
    }

    if (constantName.startsWith("SDL_PRI")) {
        return nextLine
    }

    val actualConstValue = maybeExpandConstValue(constantValue)

    val enumTypeName = tryFindKnownEnumType(constantName)
    if (enumTypeName != null) {
        val enumType = registry.enumerations[enumTypeName.interned()]!!
        val variant = try {
            EnumVariant(
                name = constantName,
                value = actualConstValue.parseDecOrHex()
            )
        } catch (_: NumberFormatException) {
            EnumVariant(
                name = constantName,
                value = actualConstValue.split("|").map(String::trim)
            )
        }
        variant.doc = doc
        enumType.variants.add(variant)
        return nextLine
    }

    val bitmaskTypeName = tryFindKnownBitmaskType(constantName)
    if (bitmaskTypeName != null) {
        val bitmask = registry.bitmasks[bitmaskTypeName.interned()]!!
        val bitflag = try {
            Bitflag(
                name = constantName,
                value = actualConstValue.parseDecOrHex().toBigInteger()
            )
        } catch (_: NumberFormatException) {
            Bitflag(
                name = constantName,
                value = actualConstValue.split("|").map(String::trim).toMutableList()
            )
        }
        bitmask.doc = doc
        bitmask.bitflags.add(bitflag)
        registry.bitmasks[bitmaskTypeName.interned()] = bitmask
        return nextLine
    }

    val constant = Constant(
        name = constantName,
        type = IdentifierType("INDETERMINATE"),
        expr = actualConstValue
    )
    constant.doc = doc
    registry.constants.putEntityIfAbsent(constant)
    return nextLine
}

private fun parseOpaqueTypedef(
    registry: Registry,
    cx: MutableMap<String, Any>,
    lines: List<String>,
    index: Int
): Int {
    assert(lines[index].startsWith("typedef struct") && lines[index].endsWith(";")) {
        "Expected opaque typedef at line $index"
    }

    val doc = cx["doxygen"] as? List<String>
    cx.remove("doxygen")

    val parts = lines[index].removePrefix("typedef struct").removeSuffix(";").trim().split(" ", limit = 2)
    val aliasName = parts[1].trim()

    if (aliasName.startsWith("*")) {
        val handleTypedef = OpaqueHandleTypedef(name = aliasName.removePrefix("*"))
        handleTypedef.doc = doc
        registry.opaqueHandleTypedefs.putEntityIfAbsent(handleTypedef)
    } else {
        val typedef = OpaqueTypedef(aliasName, isHandle = true)
        typedef.doc = doc
        registry.opaqueTypedefs.putEntityIfAbsent(typedef)
    }
    return index + 1
}

private fun skipInlineFunction(
    @Suppress("unused") registry: Registry,
    @Suppress("unused") cx: MutableMap<String, Any>,
    lines: List<String>,
    index: Int
): Int {
    assert(lines[index].startsWith("SDL_FORCE_INLINE")) { "Expected inline function at line $index" }

    log.info("[INLINE-FUNC] skipping inline function at line ${index + 1}: ${lines[index]}")

    var index1 = index + 2
    while (index1 < lines.size && lines[index1] != "}") {
        index1++
    }
    if (index1 >= lines.size) {
        error("Unterminated inline function at line $index")
    }
    return index1 + 1
}

private fun parseCallbackTypedef(
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
            optional = true,
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
    addRule(50, { if (it.contains("SDLCALL")) ControlFlow.ACCEPT else ControlFlow.NEXT }, ::parseFunctionPointerStructField)
    addRule(99, { _ -> ControlFlow.ACCEPT }, ::parseStructField)
}

private fun parseAndSaveStructure(
    registry: Registry,
    cx: MutableMap<String, Any>,
    lines: List<String>,
    index: Int,
    isUnion: Boolean
): Int {
    if ("doxygen" in cx) {
        cx["structureDoc"] = cx["doxygen"]!!
        cx.remove("doxygen")
    }

    val structureName = lines[index]
        .removePrefix("typedef struct")
        .removePrefix("typedef union")
        .removeSuffix("{")
        .trim()

    if (structureName in knownTroublesomeStructures) {
        // directly skip to the `}` + ';' line
        var index1 = index + 1
        while (index1 < lines.size
            && !(lines[index1].startsWith("}")
                    && lines[index1].endsWith(";")
                    && lines[index1].contains(structureName))
        ) {
            index1++
        }
        return index1 + 1
    }

    cx["structureName"] = structureName
    val next = hparse(structureParseConfig, registry, cx, lines, index + 2)
    val fields = cx["fields"] as MutableList<Member>
    cx.remove("fields")

    val structure = Structure(name = structureName, members = fields)
    if ("structureDoc" in cx) {
        structure.doc = cx["structureDoc"] as List<String>
        cx.remove("structureDoc")
    }
    if (isUnion) {
        registry.unions.putEntityIfAbsent(structure)
    } else {
        registry.structs.putEntityIfAbsent(structure)
    }

    assert(lines[next].startsWith("}") && lines[next].endsWith(";"))
    cx.remove("structureName")
    return next + 1
}

private fun parseFunctionPointerStructField(
    registry: Registry,
    cx: MutableMap<String, Any>,
    lines: List<String>,
    index: Int
): Int {
    val (varDecl, nextIndex) = parseInlineFunctionPointerField(lines, index)
    val structureName = cx["structureName"] as String

    val typeName = "PFN_${structureName}_${varDecl.name}"
    registry.functionTypedefs.putEntityIfAbsent(FunctionTypedef(
        name = typeName,
        params = (varDecl.type as RawFunctionType).params.map { it.second.toType() },
        result = varDecl.type.returnType.toType()
    ))

    val member = Member(
        name = varDecl.name,
        type = IdentifierType(typeName),
        values = null,
        len = null,
        altLen = null,
        optional = true,
        bits = null
    )
    if ("doxygen" in cx) {
        member.doc = cx["doxygen"] as List<String>
        cx.remove("doxygen")
    }
    (cx["fields"] as MutableList<Member>).add(member)

    return nextIndex
}

private fun parseStructField(
    @Suppress("unused") registry: Registry,
    cx: MutableMap<String, Any>,
    lines: List<String>,
    index: Int
): Int {
    val (declList, nextIndex) = parseStructFieldDecl(lines, index)

    for (decl in declList) {
        val type = decl.type.toType()
        val member = Member(
            name = decl.name,
            type = type,
            values = null,
            len = null,
            altLen = null,
            optional = false,
            bits = null
        )

        if ("doxygen" in cx) {
            member.doc = cx["doxygen"] as List<String>
            cx.remove("doxygen")
        }

        (cx["fields"] as MutableList<Member>).add(member)
    }
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

    val enumName = lines[index].removePrefix("typedef enum").removeSuffix("{").trim()
    val next = hparse(enumerationParseConfig, registry, cx, lines, if (lines[index].endsWith("{")) index + 1 else index + 2)
    val enumerators = cx["enumerators"] as MutableList<Pair<EnumeratorDecl, List<String>?>>
    cx.remove("enumerators")

    val enumeration = Enumeration(
        name = enumName,
        variants = enumerators.map { (enumDecl, doc) ->
            val variant = if (enumDecl.value.isEmpty()) {
                EnumVariant(
                    name = enumDecl.name,
                    value = emptyList()
                )
            } else {
                try {
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
            }
            variant.doc = doc
            variant
        }.toMutableList()
    )
    registry.enumerations.putEntityIfAbsent(enumeration)
    enumeration

    if ("enumerationDoxygen" in cx) {
        enumeration.doc = cx["enumerationDoxygen"] as List<String>
        cx.remove("enumerationDoxygen")
    }

    assert(lines[next].startsWith("}") && lines[next].endsWith(";"))
    return next + 1
}

private val enumerationParseConfig = ParseConfig().apply {
    addInit { it["enumerators"] = mutableListOf<Pair<EnumeratorDecl, List<String>?>>() }

    addRule(10, {
        if (it.startsWith("#if") && it.contains("SDL_BYTEORDER")) ControlFlow.ACCEPT else ControlFlow.NEXT
    }, ::skipEndiannessSpecific)
    addRule(0, { line -> if (line.startsWith("}")) ControlFlow.RETURN else ControlFlow.NEXT }, ::dummyAction)
    addRule(0, ::detectBlockDoxygen, ::parseAndSaveBlockDoxygen)
    addRule(0, ::detectTriSlashDoxygen, ::parseAndSaveTriSlashDoxygen)
    addRule(20, ::detectLineComment, ::nextLine)
    addRule(20, ::detectPreprocessor, ::nextLine)
    addRule(20, ::detectBlockComment, ::skipBlockComment)
    addRule(99, { _ -> ControlFlow.ACCEPT }, ::parseEnumerator)
}

private fun parseEnumerator(
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

private fun skipEndiannessSpecific(
    @Suppress("unused") registry: Registry,
    @Suppress("unused") cx: MutableMap<String, Any>,
    lines: List<String>,
    index: Int
): Int {
    var index1 = index + 1
    while (index1 < lines.size && !lines[index1].startsWith("#endif")) {
        log.warning("skipping endianness-specific line at ${index1 + 1}: ${lines[index1]}, remember to check it later")
        index1++
    }
    return index1 + 1
}

private fun parseAndSaveTypedef(
    registry: Registry,
    cx: MutableMap<String, Any>,
    lines: List<String>,
    index: Int
): Int {
    val parseResult = parseTypedefDecl(lines, index)
    val typedef = parseResult.first
    val nextIndex = parseResult.second

    val entity = when (typedef.name) {
        in knownEnumTypes -> {
            val enumeration = Enumeration(
                name = typedef.name,
                variants = mutableListOf()
            )
            registry.enumerations.putEntityIfAbsent(enumeration)
            enumeration
        }
        in knownBitmaskTypes -> {
            val bitmask = Bitmask(
                name = typedef.name,
                bitwidth = when ((typedef.aliasedType as RawIdentifierType).ident.lowercase()) {
                    "uint8" -> 8
                    "uint16" -> 16
                    "uint32" -> 32
                    "uint64" -> 64
                    else -> error("Unknown bitmask type: ${typedef.aliasedType}")
                },
                bitflags = mutableListOf()
            )
            registry.bitmasks.putEntityIfAbsent(bitmask)
            bitmask
        }
        else -> {
            val typedef = Typedef(
                name = typedef.name,
                type = typedef.aliasedType.toType()
            )
            registry.aliases.putEntityIfAbsent(typedef)
            typedef
        }
    }

    if ("doxygen" in cx) {
        entity.doc = cx["doxygen"] as List<String>
        cx.remove("doxygen")
    }

    return nextIndex
}

private fun skipStructBody(
    @Suppress("unused") registry: Registry,
    @Suppress("unused") cx: MutableMap<String, Any>,
    lines: List<String>,
    index: Int
): Int {
    var index1 = index + 1
    while (index1 < lines.size && !(lines[index1].startsWith("}") && lines[index1].endsWith(";"))) {
        index1++
    }
    if (index1 >= lines.size) {
        error("Unterminated struct body at line $index")
    }
    return index1 + 1
}
