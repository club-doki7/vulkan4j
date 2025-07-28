package club.doki7.babel.drv

import club.doki7.babel.codegen.CodegenOptions
import club.doki7.babel.codegen.generateCommandFile
import club.doki7.babel.codegen.generateConstants
import club.doki7.babel.codegen.generateFunctionTypedefs
import club.doki7.babel.codegen.generateHandle
import club.doki7.babel.extract.openal.extractOpenALHeader
import club.doki7.sennaar.registry.OpaqueHandleTypedef
import club.doki7.babel.util.buildDoc
import club.doki7.babel.util.render
import java.io.File

private const val packageDir = "openal/src/main/java/club/doki7/openal"

fun openalMain() {
    val registry = extractOpenALHeader()

    val codegenOptions = CodegenOptions(
        packageName = "club.doki7.openal",
        extraImport = emptyList(),
        constantClassName = "ALConstants",
        functionTypeClassName = "ALFunctionTypes",
        refRegistries = emptyList(),
    )

    val alcCodegenOptions = codegenOptions.copy(constantClassName = "ALCConstants")

    val (alcConstants, alConstants) = registry
        .constants
        .values
        .partition { it.name.original.startsWith("ALC_") }

    val alcConstantsDoc = generateConstants(registry, alcCodegenOptions, alcConstants)
    File("$packageDir/ALCConstants.java").writeText(render(alcConstantsDoc))
    val alConstantsDoc = generateConstants(registry, codegenOptions, alConstants)
    File("$packageDir/ALConstants.java").writeText(render(alConstantsDoc))

    val functionTypeDoc = generateFunctionTypedefs(registry, codegenOptions)
    File("$packageDir/${codegenOptions.functionTypeClassName}.java")
        .writeText(render(functionTypeDoc))

    for (opaqueTypedef in registry.opaqueTypedefs.values) {
        val handleTypedef = OpaqueHandleTypedef(opaqueTypedef.name)
        handleTypedef.doc = opaqueTypedef.doc
        val handleDoc = generateHandle(handleTypedef, codegenOptions)
        File("$packageDir/handle/${opaqueTypedef.name}.java")
            .writeText(render(handleDoc))
    }

    val (alcCommands, alCommands) = registry
        .commands
        .values
        .partition { it.name.original.startsWith("alc") }
    val alcCommandFile = generateCommandFile(
        registry,
        "AL",
        alCommands,
        codegenOptions,
        implConstantClass = true,
        subpackage = null
    )
    File("$packageDir/AL.java").writeText(render(alcCommandFile))
    val alCommandFile = generateCommandFile(
        registry,
        "ALC",
        alcCommands,
        alcCodegenOptions,
        implConstantClass = true,
        subpackage = null
    )
    File("$packageDir/ALC.java").writeText(render(alCommandFile))

    val efxPresets = extractEFXEAXPresets()
    File("$packageDir/EFXReverbPresets.java").writeText(render(buildDoc {
        +"package club.doki7.openal;"
        +""
        +"public interface EFXReverbPresets {"
        indent {
            for ((name, value) in efxPresets) {
                +"EFXEAXReverbProperties $name = new EFXEAXReverbProperties($value);"
            }
        }
        +"}"
    }))
}

private fun extractEFXEAXPresets(): List<Pair<String, String>> {
    val presets = File("codegen-v2/input/efx-presets.h").readText()

    val ret = mutableListOf<Pair<String, String>>()
    val lines = presets.splitToSequence("\n").map(String::trim).toList()
    var index = 0
    while (index < lines.size) {
        val line = lines[index]
        if (line.startsWith("#define") && line.endsWith('\\')) {
            val presetName = line
                .removePrefix("#define")
                .removeSuffix("\\")
                .trim()
                .removePrefix("EFX_REVERB_PRESET_")
            val presetValue = lines[index + 1]
                .removePrefix("{")
                .removeSuffix("}")
                .trim()
                .replace("{", "new float[] {")
            ret.add(presetName to presetValue)
            index += 2
        } else {
            index++
        }
    }

    return ret
}
