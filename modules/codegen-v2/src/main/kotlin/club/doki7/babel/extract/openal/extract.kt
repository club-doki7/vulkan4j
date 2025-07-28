@file:Suppress("UNCHECKED_CAST")

package club.doki7.babel.extract.openal

import club.doki7.babel.cdecl.FunctionDecl
import club.doki7.babel.cdecl.RawFunctionType
import club.doki7.babel.cdecl.TypedefDecl
import club.doki7.babel.cdecl.parseFunctionDecl
import club.doki7.babel.cdecl.parseTypedefDecl
import club.doki7.babel.cdecl.toType
import club.doki7.babel.hparse.*
import club.doki7.babel.util.putEntityIfAbsent
import club.doki7.sennaar.registry.*
import java.util.logging.Logger
import kotlin.io.path.Path

private val inputDir = Path("codegen-v2/input")
internal val log = Logger.getLogger("c.d.b.extract.openal")

fun extractOpenALHeader(): Registry {
    val headerFileContent = buildString {
        for (headerFilename in listOf("al.h", "alc.h", "alext.h", "efx.h")) {
            append(inputDir.resolve(headerFilename).toFile().readText())
            append("\n")
        }
    }

    val headerFile = headerFileContent
        .splitToSequence("\n")
        .map(String::trim)
        .toList()

    val registry = Registry("openal")

    hparse(
        headerParseConfig,
        registry,
        mutableMapOf(),
        headerFile,
        0
    )

    registry.opaqueHandleTypedefs.putEntityIfAbsent(OpaqueHandleTypedef("__Placeholder"))
    registry.renameEntities()

    return registry
}

private val headerParseConfig = ParseConfig().apply {
    addRule(0, ::detectBlockDoxygen, ::parseAndSaveBlockDoxygen)
    addRule(0, ::detectTriSlashDoxygen, ::parseAndSaveTriSlashDoxygen)
    addRule(
        0, { line: String ->
            if (line.replace(" ", "") in listOf(
                    "}/*extern\"C\"*/",
                    "(defined(__cplusplus)&&__cplusplus>=201103L)",
                    "extern\"C\"{",
                    "}"
            ))
                ControlFlow.ACCEPT
            else ControlFlow.NEXT
        },
        ::nextLine
    )

    addRule(10, ::detectLineComment, ::nextLine)
    addRule(10, ::detectBlockComment, ::skipBlockComment)

    addRule(20, ::detectOpaqueTypedefStruct,  ::parseOpaqueTypedefStruct)
    addRule(20, ::detectConstant, ::parseConstant)
    addRule(20, ::detectFunctionTypeDecl, ::parseFunctionTypeDecl)
    addRule(20, ::detectFunctionDecl, ::parseFunctionDecl)
    addRule(21, ::detectTypeAlias, ::parseTypeAlias)

    addRule(30, ::detectPreprocessor, ::nextLine)
}

private fun detectConstant(line: String): ControlFlow {
    return if ((line.startsWith("#define AL_") || line.startsWith("#define ALC_"))
        && line.split(Regex("\\s+"))
            .last()
            .let {
                it matches Regex("-?\\d+[fF]?") ||
                it matches Regex("\\(-?\\d+[fF]?\\)") ||
                it matches Regex("-?(\\d+)?\\.\\d+[fF]?") ||
                it matches Regex("\\(-?(\\d+)?\\.\\d+[fF]?\\)") ||
                it matches Regex("0x[a-fA-F0-9]+") ||
                it matches Regex("\\(0x[a-fA-F0-9]+\\)") ||
                it matches Regex("\\w+") ||
                it matches Regex("\\(\\w+\\)")
            }
    ) ControlFlow.ACCEPT else ControlFlow.NEXT
}

private fun parseConstant(
    registry: Registry,
    cx: MutableMap<String, Any>,
    lines: List<String>,
    index: Int
): Int {
    val rawLine = lines[index]
    val codeAndComment = rawLine.split("/*", limit = 2)
    val codePart = codeAndComment[0]
    val commentPart = if (codeAndComment.size > 1) codeAndComment[1].removeSuffix("*/").trim() else null

    val parts = codePart
        .removePrefix("#define")
        .trim()
        .split(Regex("\\s+"))

    if (parts.size != 2) {
        log.warning("unhandled constant definition at line $index: ${lines[index]}")
        return index + 1
    }

    val name = parts[0]
    var value = parts[1]

    if (name in setOf(
            "AL_API",
            "AL_APIENTRY",
            "AL_API_NOEXCEPT",
            "AL_API_NOEXCEPT17",
            "AL_APIENTRY",
            "AL_CPLUSPLUS",
            "ALC_API",
            "ALC_APIENTRY",
            "ALC_API_NOEXCEPT",
            "ALC_API_NOEXCEPT17",
            "ALC_CPLUSPLUS"
    )) {
        cx.remove("doxygen")
        return index + 1
    }

    val type = IdentifierType(when {
        value in setOf("FLT_MIN", "FLT_MAX") -> "float"
        value in setOf("AL_TRUE", "AL_FALSE") -> "int8_t"
        value.contains("ULL") -> "uint64_t"
        value.contains("U") -> "uint32_t"
        value.endsWith("f") || value.endsWith("f)") -> "float"
        value.contains(".") && !value.contains("f") -> "double"
        else -> "int32_t"
    })

    if (value.startsWith("AL_") || value.startsWith("ALC_")) {
        value = value.removePrefix("AL_").removePrefix("ALC_")
    } else if (value == "FLT_MIN") {
        value = "Float.MIN_VALUE"
    } else if (value == "FLT_MAX") {
        value = "Float.MAX_VALUE"
    }

    val constant = Constant(name = name, ty = type, expr = TODO())

    // 合并 doc 注释
    val doc = mutableListOf<String>()
    if ("doxygen" in cx) {
        doc += cx["doxygen"] as List<String>
        cx.remove("doxygen")
    }
    if (commentPart != null) {
        doc += commentPart
    }
    if (doc.isNotEmpty()) {
        constant.doc = doc
    }

    registry.constants.putEntityIfAbsent(constant)

    return index + 1
}

private fun detectTypeAlias(line: String): ControlFlow =
    if (line.startsWith("typedef") && "struct" !in line && line matches Regex("""^typedef\s+([_a-zA-Z][_a-zA-Z0-9]*\*?\s+)+\w+;$""")) {
        ControlFlow.ACCEPT
    } else {
        ControlFlow.NEXT
    }

private fun parseTypeAlias(
    registry: Registry,
    cx: MutableMap<String, Any>,
    lines: List<String>,
    index: Int
): Int {
    val parseResult = parseTypedefDecl(lines, index)
    val (typedef, nextIndex) = parseResult
    val alias = morphTypedefAlias(typedef)
    if ("doxygen" in cx) {
        alias.doc = cx["doxygen"] as MutableList<String>
        cx.remove("doxygen")
    }
    registry.aliases.putEntityIfAbsent(alias)

    return nextIndex
}

private fun detectOpaqueTypedefStruct(line: String): ControlFlow =
    if (((line.startsWith("struct") || line.startsWith("typedef struct"))
                && line.endsWith(";")
                && !line.contains("{")
                && !line.contains("}")
            )) {
        ControlFlow.ACCEPT
    } else {
        ControlFlow.NEXT
    }

private fun parseOpaqueTypedefStruct(
    registry: Registry,
    cx: MutableMap<String, Any>,
    lines: List<String>,
    index: Int
): Int {
    val struct = OpaqueTypedef(if (lines[index].startsWith("typedef struct")) {
        val parts = lines[index]
            .removePrefix("typedef struct")
            .trim()
            .removeSuffix(";")
            .trim()
            .split(Regex("\\s+"))

        if (parts.size != 2) return index + 1
        if (parts[0] != parts[1]) return index + 1

        parts[0]
    } else if (lines[index].startsWith("struct")) {
        lines[index]
            .removePrefix("struct")
            .trim()
            .removeSuffix(";")
            .trim()
    } else error("should not reach here"))

    if ("doxygen" in cx) {
        struct.doc = cx["doxygen"] as MutableList<String>
        cx.remove("doxygen")
    }
    registry.opaqueTypedefs.putEntityIfAbsent(struct)

    return index + 1
}

private fun detectFunctionTypeDecl(line: String): ControlFlow =
    if (isTypedefApiNoexcept17(line)) {
        ControlFlow.ACCEPT
    } else {
        ControlFlow.NEXT
    }

private fun parseFunctionTypeDecl(
    registry: Registry,
    cx: MutableMap<String, Any>,
    lines: List<String>,
    index: Int
): Int {
    val (typedef, nextIndex) = parseTypedefDecl(lines, index)
    val functionTypedef = morphFunctionTypedef(typedef)
    if ("doxygen" in cx) {
        functionTypedef.doc = cx["doxygen"] as MutableList<String>
        cx.remove("doxygen")
    }
    registry.functionTypedefs.putEntityIfAbsent(functionTypedef)
    return nextIndex
}

private fun detectFunctionDecl(line: String): ControlFlow =
    if (isApiFunctionDecl(line)) {
        ControlFlow.ACCEPT
    } else {
        ControlFlow.NEXT
    }

private fun isApiFunctionDecl(line: String): Boolean {
    return ((line.contains("AL_APIENTRY") || line.contains("ALC_APIENTRY")) &&
            line.contains("(") && line.contains(")") &&
            !line.contains("typedef") &&
            (line.endsWith("AL_API_NOEXCEPT;") || line.endsWith("ALC_API_NOEXCEPT;")))
            || (line matches Regex("ALC?\\w+\\s+ALC?_APIENTRY\\s+alc?\\w+\\(.+"))
}

private fun isTypedefApiNoexcept17(line: String): Boolean {
    return (line.startsWith("typedef") &&
            line.contains("(") && line.contains(")") &&
            (line.contains("AL_APIENTRY") || line.contains("ALC_APIENTRY")) &&
            line.contains("*") &&
            (line.endsWith("AL_API_NOEXCEPT17;") || line.endsWith("ALC_API_NOEXCEPT17;")))
            || (line.startsWith("typedef") && line matches Regex("typedef\\s+\\w+\\s*\\(ALC?_APIENTRY\\s*\\*.+"))
}

private fun parseFunctionDecl(
    registry: Registry,
    cx: MutableMap<String, Any>,
    lines: List<String>,
    index: Int
): Int {
    val parseResult = parseFunctionDecl(lines, index)
    val (functionDecl, nextIndex) = parseResult
    val command = morphFunctionDecl(functionDecl)
    if ("doxygen" in cx) {
        command.doc = cx["doxygen"] as MutableList<String>
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
            ty = it.type.toType(),
            len = null,
            optional = true,
        )
    }.toMutableList(),
    result = functionDecl.returnType.toType(),
    successCodes = mutableListOf(),
    errorCodes = mutableListOf()
)

private fun morphFunctionTypedef(typedef: TypedefDecl) = FunctionTypedef(
    name = typedef.name,
    params = (typedef.aliasedType as RawFunctionType).params.map {
        Param(
            name = it.first,
            ty = it.second.toType(),
            len = null,
            optional = true
        )
    }.toMutableList(),
    result = typedef.aliasedType.returnType.toType(),
    isPointer = true,
    isNativeAPI = false
)

private fun morphTypedefAlias(typedef: TypedefDecl) = Typedef(
    name = typedef.name,
    target = typedef.aliasedType.toType()
)
