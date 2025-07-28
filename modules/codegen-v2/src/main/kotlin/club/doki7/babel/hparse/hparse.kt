package club.doki7.babel.hparse

import club.doki7.babel.cdecl.FunctionDecl
import club.doki7.babel.cdecl.TypedefDecl
import club.doki7.babel.cdecl.isIdentChar
import club.doki7.babel.cdecl.parseBlockDoxygen
import club.doki7.babel.cdecl.parseFunctionDecl
import club.doki7.babel.cdecl.parseTriSlashDoxygen
import club.doki7.babel.cdecl.parseTypedefDecl
import club.doki7.babel.cdecl.toType
import club.doki7.babel.util.putEntityIfAbsent
import club.doki7.sennaar.registry.Command
import club.doki7.sennaar.registry.Param
import club.doki7.sennaar.registry.Registry
import club.doki7.sennaar.registry.Typedef
import java.util.logging.Logger

enum class ControlFlow {
    ACCEPT, NEXT, RETURN
}

typealias InitContext = (MutableMap<String, Any>) -> Unit
typealias LineMatcher = (List<String>, Int) -> ControlFlow
typealias SingleLineMatcher = (String) -> ControlFlow
typealias LineAction = (Registry, MutableMap<String, Any>, List<String>, Int) -> Int

internal val log = Logger.getLogger("c.d.b.hparse")

internal class LineHandler(
    val priority: Int,
    val matcher: LineMatcher,
    val action: LineAction
)

class ParseConfig internal constructor(
    internal val initSet: MutableSet<InitContext>,
    internal val handlerSet: MutableSet<LineHandler>
) {
    constructor() : this(mutableSetOf(), mutableSetOf())

    fun addInit(init: InitContext) {
        initSet.add(init)
    }

    fun addRule(priority: Int, matcher: LineMatcher, action: LineAction) {
        handlerSet.add(LineHandler(priority, matcher, action))
    }
    fun addRule(priority: Int, matcher: SingleLineMatcher, action: LineAction) {
        val matcher: LineMatcher = { lines, index -> matcher(lines[index]) }
        addRule(priority, matcher, action)
    }
}

fun hparse(
    config: ParseConfig,
    registry: Registry,
    cx: MutableMap<String, Any>,
    lines: List<String>,
    index: Int
): Int {
    config.initSet.forEach { it(cx) }

    var index = index
    var prevIndex: Int? = null
    outer@ while (index < lines.size) {
        if (prevIndex == index) {
            log.warning("${index+1}: dead loop detected, forcing progress: ${lines[index]}")
            index++
        }
        prevIndex = index

        if (lines[index].isBlank()) {
            index++
            continue
        }

        for (handler in config.handlerSet.sortedBy { it.priority }) {
            when (handler.matcher(lines, index)) {
                ControlFlow.ACCEPT -> {
                    index = handler.action(registry, cx, lines, index)
                    continue@outer
                }
                ControlFlow.NEXT -> continue
                ControlFlow.RETURN -> return index
            }
        }

        log.warning("${index+1}: unknown line: ${lines[index]}")
        index++
    }

    return index
}

fun detectTriSlashDoxygen(line: String) =
    if (line.startsWith("///")) {
        ControlFlow.ACCEPT
    } else {
        ControlFlow.NEXT
    }

fun parseAndSaveTriSlashDoxygen(
    @Suppress("unused") registry: Registry,
    cx: MutableMap<String, Any>,
    lines: List<String>,
    index: Int
): Int {
    val result = parseTriSlashDoxygen(lines, index)
    if (result.first != null) {
        cx["doxygen"] = result.first!!
    } else {
        cx.remove("doxygen")
    }
    return result.second
}

fun detectBlockDoxygen(line: String) =
    if (line.startsWith("/*!")
        || line.startsWith("/**")) {
        ControlFlow.ACCEPT
    } else {
        ControlFlow.NEXT
    }

fun parseAndSaveBlockDoxygen(
    @Suppress("unused") registry: Registry,
    cx: MutableMap<String, Any>,
    lines: List<String>,
    index: Int
): Int {
    val result = parseBlockDoxygen(lines, index)
    if (result.first != null) {
        cx["doxygen"] = result.first!!
    } else {
        cx.remove("doxygen")
    }
    return result.second
}

fun detectLineComment(line: String) =
    if (line.startsWith("//")) {
        ControlFlow.ACCEPT
    } else {
        ControlFlow.NEXT
    }

fun detectPreprocessor(line: String) =
    if (line.startsWith("#")) {
        ControlFlow.ACCEPT
    } else {
        ControlFlow.NEXT
    }

fun detectFunctionAlikeMacro(line: String): ControlFlow {
    if (!line.startsWith("#define")) {
        return ControlFlow.NEXT
    }

    val trimmed = line.removePrefix("#define").trimStart()
    var index = 0
    while (index < trimmed.length && trimmed[index].isIdentChar()) {
        index++
    }

    return if (index < trimmed.length && trimmed[index] == '(') {
        ControlFlow.ACCEPT
    } else {
        ControlFlow.NEXT
    }
}

fun skipPreprocessor(
    @Suppress("unused") registry: Registry,
    @Suppress("unused") cx: MutableMap<String, Any>,
    lines: List<String>,
    index: Int
): Int {
    assert(lines[index].startsWith("#")) { "Expected preprocessor directive at line $index" }
    if (!lines[index].endsWith("\\")) {
        return index + 1
    }

    var index1 = index
    while (index1 < lines.size && lines[index1].endsWith("\\")) {
        index1++
    }
    return index1 + 1
}

fun nextLine(
    @Suppress("unused") registry: Registry,
    @Suppress("unused") cx: MutableMap<String, Any>,
    @Suppress("unused") lines: List<String>,
    index: Int
) = index + 1

fun detectBlockComment(line: String) =
    if (line.startsWith("/*")) {
        ControlFlow.ACCEPT
    } else {
        ControlFlow.NEXT
    }

fun skipBlockComment(
    @Suppress("unused") registry: Registry,
    @Suppress("unused") cx: MutableMap<String, Any>,
    lines: List<String>,
    index: Int
): Int {
    assert(lines[index].startsWith("/*")) { "Expected block comment start at line $index" }
    var i = index
    while (i < lines.size && !lines[i].contains("*/")) {
        i++
    }
    if (i >= lines.size) {
        log.warning("Unterminated block comment starting at line $index")
    }
    return i + 1
}

fun dummyAction(
    @Suppress("unused") registry: Registry,
    @Suppress("unused") cx: MutableMap<String, Any>,
    @Suppress("unused") lines: List<String>,
    index: Int
): Int {
    log.warning("dummy operation at line $index called, did you correctly set ControlFlow.RETURN?")
    return index + 1
}

fun detectIfdefCplusplus(line: String) =
    if (line.startsWith("#ifdef __cplusplus")) {
        ControlFlow.ACCEPT
    } else {
        ControlFlow.NEXT
    }

fun skipIfdefCplusplusExternC(
    @Suppress("unused") registry: Registry,
    @Suppress("unused") cx: MutableMap<String, Any>,
    lines: List<String>,
    index: Int
): Int {
    assert(lines[index].startsWith("#ifdef __cplusplus")) { "Expected #ifdef __cplusplus at line $index" }
    var i = index + 1
    while (i < lines.size && !lines[i].startsWith("#endif")) {
        i++
    }
    if (i >= lines.size) {
        log.warning("Unterminated #ifdef __cplusplus starting at line $index")
    }
    return i + 1
}

fun detectEnumTypedef(line: String): ControlFlow =
    if (line.startsWith("typedef") && line.contains("enum")) {
        ControlFlow.ACCEPT
    } else {
        ControlFlow.NEXT
    }

fun detectNonOpaqueStructTypedef(line: String): ControlFlow =
    if (line.startsWith("typedef") && line.contains("struct") && !line.endsWith(";")) {
        ControlFlow.ACCEPT
    } else {
        ControlFlow.NEXT
    }

fun parseAndSaveSimpleFuncDecl(
    registry: Registry,
    @Suppress("unused") cx: MutableMap<String, Any>,
    lines: List<String>,
    index: Int
): Int {
    val (typedef, nextIndex) = parseFunctionDecl(lines, index)
    registry.commands.putEntityIfAbsent(morphSimpleFuncDecl(typedef))
    return nextIndex
}

private fun morphSimpleFuncDecl(functionDecl: FunctionDecl) = Command(
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

fun parseAndSaveSimpleTypeAlias(
    registry: Registry,
    @Suppress("unused") cx: MutableMap<String, Any>,
    lines: List<String>,
    index: Int
): Int {
    val parseResult = parseTypedefDecl(lines, index)
    val (typedef, nextIndex) = parseResult
    val alias = morphSimpleTypedefAlias(typedef)
    registry.aliases.putEntityIfAbsent(alias)

    return nextIndex
}

private fun morphSimpleTypedefAlias(typedef: TypedefDecl) = Typedef(
    name = typedef.name,
    target = typedef.aliasedType.toType()
)
