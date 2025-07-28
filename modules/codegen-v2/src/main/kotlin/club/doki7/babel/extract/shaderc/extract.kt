@file:Suppress("UNCHECKED_CAST")

package club.doki7.babel.extract.shaderc

import club.doki7.babel.cdecl.EnumeratorDecl
import club.doki7.babel.cdecl.FunctionDecl
import club.doki7.babel.cdecl.RawFunctionType
import club.doki7.babel.cdecl.TypedefDecl
import club.doki7.babel.cdecl.parseEnumeratorDecl
import club.doki7.babel.cdecl.parseFunctionDecl
import club.doki7.babel.cdecl.parseStructFieldDecl
import club.doki7.babel.cdecl.parseTypedefDecl
import club.doki7.babel.cdecl.toType
import club.doki7.babel.hparse.ControlFlow
import club.doki7.babel.hparse.ParseConfig
import club.doki7.babel.hparse.detectBlockComment
import club.doki7.babel.hparse.detectBlockDoxygen
import club.doki7.babel.hparse.detectIfdefCplusplus
import club.doki7.babel.hparse.detectLineComment
import club.doki7.babel.hparse.detectPreprocessor
import club.doki7.babel.hparse.detectTriSlashDoxygen
import club.doki7.babel.hparse.dummyAction
import club.doki7.babel.hparse.hparse
import club.doki7.babel.hparse.nextLine
import club.doki7.babel.hparse.parseAndSaveBlockDoxygen
import club.doki7.babel.hparse.parseAndSaveTriSlashDoxygen
import club.doki7.babel.hparse.skipBlockComment
import club.doki7.babel.hparse.skipIfdefCplusplusExternC
import club.doki7.babel.hparse.skipPreprocessor
import club.doki7.sennaar.registry.Command
import club.doki7.sennaar.registry.EmptyMergeable
import club.doki7.sennaar.registry.EnumVariant
import club.doki7.sennaar.registry.Enumeration
import club.doki7.sennaar.registry.FunctionTypedef
import club.doki7.sennaar.registry.Member
import club.doki7.sennaar.registry.OpaqueHandleTypedef
import club.doki7.sennaar.registry.OpaqueTypedef
import club.doki7.sennaar.registry.Param
import club.doki7.sennaar.registry.Registry
import club.doki7.sennaar.registry.Structure
import club.doki7.sennaar.registry.putEntityIfAbsent
import club.doki7.babel.util.parseDecOrHex
import java.io.File

private const val inputDir = "codegen-v2/input"

fun extractShadercRegistry(): Registry {
    val fileContent = File("$inputDir/shaderc.h").readText() + "\n" +
            File("$inputDir/status.h").readText()
    val file = fileContent.lines().map(String::trim)

    val registry = Registry(ext = EmptyMergeable())
    hparse(headerParseConfig, registry, mutableMapOf(), file, 0)
    addEnvHeaderItems(registry)
    registry.renameEntities()
    registry.enumerations.values.forEach(::postprocessEnumeration)
    return registry
}

private val headerParseConfig: ParseConfig = ParseConfig().apply {
    addRule(20, {
        if (it.startsWith("typedef enum")) {
            ControlFlow.ACCEPT
        } else ControlFlow.NEXT
    }, ::parseAndSaveEnumeration)

    addRule(20, {
        if (it.startsWith("enum") && it.endsWith("{")) {
            ControlFlow.ACCEPT
        } else ControlFlow.NEXT
    }, ::parseAndSaveEnumeration2)

    addRule(20, {
        if (it.startsWith("typedef struct") && it.endsWith(";")) {
            ControlFlow.ACCEPT
        } else ControlFlow.NEXT
    }, ::parseOpaqueStructure)

    addRule(20, {
        if (it.startsWith("typedef struct") && it.endsWith("{")) {
            ControlFlow.ACCEPT
        } else ControlFlow.NEXT
    }, ::parseAndSaveStructure)

    addRule(20, {
        if (it.startsWith("SHADERC_EXPORT")) {
            ControlFlow.ACCEPT
        } else ControlFlow.NEXT
    }, ::parseAndSaveFunctionDecl)

    addRule(30, {
        if (it.startsWith("typedef")) {
            ControlFlow.ACCEPT
        } else ControlFlow.NEXT
    }, ::parseFunctionTypedef)

    addRule(98, ::detectIfdefCplusplus, ::skipIfdefCplusplusExternC)
    addRule(99, ::detectPreprocessor, ::skipPreprocessor)
    addRule(99, ::detectLineComment, ::nextLine)
}

private fun parseOpaqueStructure(
    registry: Registry,
    cx: MutableMap<String, Any>,
    lines: List<String>,
    index: Int
): Int {
    val line = lines[index]
    val headless = line.substring(15, line.length - 1).trim()
    val names = headless.split(' ')
    assert(names.size == 2)

    val aliasedTo = names[0]
    val name = names[1]
    val entity = if (aliasedTo.endsWith('*')) {
        OpaqueHandleTypedef(name).apply {
            registry.opaqueHandleTypedefs.putEntityIfAbsent(this)
        }
    } else {
        // this case is kinda impossible, as all opaque typedef are handle typedef for now.
        OpaqueTypedef(name, true).apply {
            registry.opaqueTypedefs.putEntityIfAbsent(this)
        }
    }

    entity.doc = cx.steal(Doxygen)
    return index + 1
}

private val structureParseConfig = ParseConfig().apply {
    addInit { it[Fields] = mutableListOf() }
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
        optional = false,
        bits = null
    )

    member.doc = cx.steal(Doxygen)
    cx[Fields]!!.add(member)
    return nextIndex
}

private fun parseAndSaveStructure(
    registry: Registry,
    cx: MutableMap<String, Any>,
    lines: List<String>,
    index: Int
): Int {
    cx.steal(Doxygen)?.let {
        cx[StructureDoc] = it
    }

    val structureName = lines[index].removeSurrounding("typedef struct", "{").trim()
    val next = hparse(structureParseConfig, registry, cx, lines, index + 2)
    val fields = cx.rob(Fields)

    val structure = Structure(
        name = structureName,
        members = fields
    )

    cx.steal(StructureDoc)?.let {
        structure.doc = it
    }

    registry.structs.putEntityIfAbsent(structure)

    assert(lines[next].startsWith("}") && lines[next].endsWith(";"))
    return next + 1
}

private fun parseAndSaveEnumeration(
    registry: Registry,
    cx: MutableMap<String, Any>,
    lines: List<String>,
    index: Int,
): Int {
    cx.steal(Doxygen)?.let {
        cx[EnumerationDoxygen] = it
    }

    val next = hparse(enumerationParseConfig, registry, cx, lines, index + 1)
    // next is at the line `} ENUM_NAME;`
    val enumName = lines[next].removeSurrounding("}", ";").trim()
    val enumerators = cx.rob(Enumerators)

    val enumeration = Enumeration(
        name = enumName,
        variants = enumerators.map { (enumDecl, doc) ->
            val variant = try {
                val value = enumDecl.value.removeSuffix("u").parseDecOrHex()
                EnumVariant(name = enumDecl.name, value = value)
            } catch (_: NumberFormatException) {
                EnumVariant(
                    name = enumDecl.name,
                    value = if (enumDecl.value.isBlank()) emptyList() else listOf(enumDecl.value)
                )
            }
            variant.doc = doc
            variant
        }.toMutableList()
    )

    registry.enumerations.putEntityIfAbsent(enumeration)
    enumeration.doc = cx.steal(EnumerationDoxygen)

    assert(lines[next].startsWith("}") && lines[next].endsWith(";"))
    return next + 1
}

private fun parseAndSaveEnumeration2(
    registry: Registry,
    cx: MutableMap<String, Any>,
    lines: List<String>,
    index: Int,
): Int {
    cx.steal(Doxygen)?.let {
        cx[EnumerationDoxygen] = it
    }

    val enumName = lines[index].removeSurrounding("enum", "{").trim()
    val next = hparse(enumerationParseConfig, registry, cx, lines, index + 1)
    val enumerators = cx.rob(Enumerators)

    val enumeration = Enumeration(
        name = enumName,
        variants = enumerators.map { (enumDecl, doc) ->
            val variant = try {
                val value = enumDecl.value.removeSuffix("u").parseDecOrHex()
                EnumVariant(name = enumDecl.name, value = value)
            } catch (_: NumberFormatException) {
                EnumVariant(
                    name = enumDecl.name,
                    value = if (enumDecl.value.isBlank()) emptyList() else listOf(enumDecl.value)
                )
            }
            variant.doc = doc
            variant
        }.toMutableList()
    )

    registry.enumerations.putEntityIfAbsent(enumeration)
    enumeration.doc = cx.steal(EnumerationDoxygen)

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

private fun parseFunctionTypedef(
    registry: Registry,
    cx: MutableMap<String, Any>,
    lines: List<String>,
    index: Int,
): Int {
    val parseResult = parseTypedefDecl(lines, index)
    val typedef = parseResult.first
    val nextIndex = parseResult.second

    val functionTypedef = morphFunctionTypedef(typedef)
    functionTypedef.doc = cx.steal(Doxygen)
    registry.functionTypedefs.putEntityIfAbsent(functionTypedef)
    return nextIndex
}

private fun parseAndSaveFunctionDecl(
    registry: Registry,
    cx: MutableMap<String, Any>,
    lines: List<String>,
    index: Int,
): Int {
    val parseResult = parseFunctionDecl(lines, index)
    val functionDecl = parseResult.first
    val nextIndex = parseResult.second

    val command = morphFunctionDecl(functionDecl)
    command.doc = cx.steal(Doxygen)
    registry.commands.putEntityIfAbsent(command)

    return nextIndex
}

private fun morphFunctionDecl(functionDecl: FunctionDecl) = Command(
    name = functionDecl.name,
    params = functionDecl.params.mapIndexed { index, it ->
        Param(
            name = it.name.ifEmpty { "param$index" },
            type = it.type.toType(),
            len = null,
            argLen = null,
            optional = true
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
