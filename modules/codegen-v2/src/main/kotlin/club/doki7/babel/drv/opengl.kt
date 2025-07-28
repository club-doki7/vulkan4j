package club.doki7.babel.drv

import club.doki7.babel.codegen.CodegenOptions
import club.doki7.babel.codegen.generateConstants
import club.doki7.babel.codegen.generateFunctionTypedefs
import club.doki7.babel.codegen.generateHandle
import club.doki7.babel.extract.opengl.OPENGL_IS_COMPATIBILITY
import club.doki7.babel.extract.opengl.extractOpenGLRegistry
import club.doki7.babel.util.render
import club.doki7.babel.util.setupLog
import java.io.File

private const val packageDir = "opengl/src/main/java/club/doki7/opengl"

fun openglMain() {
    val openglRegistry = extractOpenGLRegistry()

    val codegenOptions = CodegenOptions(
        packageName = "club.doki7.opengl",
        extraImport = listOf(),
        constantClassName = "GLConstants",
        functionTypeClassName = "GLFunctionTypes",
        refRegistries = emptyList()
    )

    val constantsDoc = generateConstants(openglRegistry, codegenOptions)
    File("$packageDir/${codegenOptions.constantClassName}.java")
        .writeText(render(constantsDoc))

    for (handle in openglRegistry.opaqueHandleTypedefs.values) {
        val handleDoc = generateHandle(handle, codegenOptions)
        File("$packageDir/handle/${handle.name.value}.java")
            .writeText(render(handleDoc))
    }

    val functionTypedefsDoc = generateFunctionTypedefs(
        openglRegistry,
        codegenOptions
    )
    File("$packageDir/${codegenOptions.functionTypeClassName}.java")
        .writeText(render(functionTypedefsDoc))

    val (compatibilityCommands, coreCommands) = openglRegistry.commands.values
        .sortedBy { it.name }
        .partition { it.hasMetadata(OPENGL_IS_COMPATIBILITY) }

    val coreCommandsDoc = club.doki7.babel.codegen.generateCommandFile(
        openglRegistry,
        "GL",
        coreCommands,
        codegenOptions,
        implConstantClass = false,
        subpackage = null
    )
    val coreCommandsDocText = render(coreCommandsDoc)
        .replace(
            "public final class GL {",
            "public sealed class GL implements GLConstants permits GLCompatibility {"
        )
    File("$packageDir/GL.java").writeText(coreCommandsDocText)

    val compatibilityDoc = club.doki7.babel.codegen.generateCommandFile(
        openglRegistry,
        "GLCompatibility",
        compatibilityCommands,
        codegenOptions,
        implConstantClass = false,
        subpackage = null
    )
    val compatibilityDocText = render(compatibilityDoc)
        .replace(
            "public final class GLCompatibility {",
            "public final class GLCompatibility extends GL {"
        ).replace(
            "public GLCompatibility(RawFunctionLoader loader) {",
            """public GLCompatibility(RawFunctionLoader loader) {
    super(loader);""")
    File("$packageDir/GLCompatibility.java").writeText(compatibilityDocText)
}

fun main() {
    setupLog()
    openglMain()
}
