package club.doki7.babel.extract.opengl

import club.doki7.babel.cdecl.RawFunctionType
import club.doki7.babel.cdecl.TypedefDecl
import club.doki7.babel.cdecl.parseType
import club.doki7.babel.cdecl.parseTypedefDecl
import club.doki7.babel.cdecl.toType
import club.doki7.sennaar.registry.*
import club.doki7.babel.util.asSequence
import club.doki7.babel.util.getAttributeText
import club.doki7.babel.util.getElementSeq
import club.doki7.babel.util.parseXML
import club.doki7.babel.util.query
import org.w3c.dom.Element
import java.util.logging.Logger
import kotlin.io.path.Path

private val inputDir = Path("codegen-v2/input")
internal val log = Logger.getLogger("c.d.b.extract.opengl")

fun extractOpenGLRegistry(): Registry {
    val r = inputDir.resolve("gl.xml")
        .toFile()
        .readText()
        .parseXML()
        .extractEntities()
    r.renameEntities()
    return r
}

private fun Element.extractEntities(): Registry {
    val e = this

    val allCommands = e.query("commands/command")
        .map(::extractCommand)
        .associateByTo(mutableMapOf()) { it.name }

    val allConstants = mutableMapOf<Identifier, Constant>()
    e.query("enums/enum").forEach { extractEnumConstant(it, allConstants) }

    val commands = mutableMapOf<Identifier, Command>()
    val constants = mutableMapOf<Identifier, Constant>()

    val featureElements = e.query("feature[@api='gl']")
    for (featureElement in featureElements) {
        for (require in featureElement.getElementSeq("require")) {
            val profile = require.getAttributeText("profile")
            val isCompatibility = profile == "compatibility"

            for (commandRequire in require.getElementSeq("command")) {
                val name = commandRequire.getAttributeText("name")!!
                val command = allCommands[name.interned()]!!
                command.setExt(GLCommandMetadata(isCompatibility, isExtension = false))
                commands.putEntityIfAbsent(command)
            }

            for (enumRequire in require.getElementSeq("enum")) {
                val name = enumRequire.getAttributeText("name")!!
                val constant = allConstants[name.interned()]!!
                constant.setExt(GLBaseMetadata(isExtension = false))
                constants.putEntityIfAbsent(constant)
            }
        }

        for (remove in featureElement.getElementSeq("remove")) {
            val profile = remove.getAttributeText("profile")
            assert(profile == "core") {
                "unexpected profile '$profile' in remove element, expected 'core'."
            }

            for (commandRemove in remove.getElementSeq("command")) {
                val name = commandRemove.getAttributeText("name")!!
                val command = allCommands[name.interned()]!!
                command.ext<GLCommandMetadata>().isCompatibility = true
            }
        }
    }

    val extensionElements = e.query("extensions/extension")
    for (extensionElement in extensionElements) {
        val name = extensionElement.getAttributeText("name")!!
        if (!keptOpenGLExtensions.contains(name.removePrefix("GL_"))) {
            continue
        }

        val supported = (extensionElement.getAttributeText("supported") ?: continue).split("|")
        if ("gl" !in supported && "glcore" !in supported) {
            continue
        }

        val extensionIsCompatibility = "gl" in supported && "glcore" !in supported
        for (require in extensionElement.getElementSeq("require")) {
            val requireIsCompatibility = require.getAttributeText("profile") == "compatibility"
            val isCompatibility = requireIsCompatibility || extensionIsCompatibility

            for (commandRequire in require.getElementSeq("command")) {
                val name = commandRequire.getAttributeText("name")!!
                val command = allCommands[name.interned()]!!
                if (command.hasExt()) {
                    val ext = command.ext<GLMetadata>()
                    if (ext.isExtension == null) {
                        ext.isExtension = true
                    }
                } else {
                    command.setExt(GLCommandMetadata(isCompatibility, isExtension = true))
                }
                commands.putEntityIfAbsent(command)
            }

            for (enumRequire in require.getElementSeq("enum")) {
                val name = enumRequire.getAttributeText("name")!!
                val constant = allConstants[name.interned()]!!
                if (constant.hasExt()) {
                    val ext = constant.ext<GLMetadata>()
                    if (ext.isExtension == null) {
                        ext.isExtension = true
                    }
                } else {
                    constant.setExt(GLBaseMetadata(isExtension = true))
                }
                constants.putEntityIfAbsent(constant)
            }
        }
    }

    val functionTypedefs = mutableMapOf<Identifier, FunctionTypedef>()
    for (apiEntryElement in e.query("types/type/apientry")) {
        val typedefElement = apiEntryElement.parentNode as Element
        val typedef = typedefElement.textContent
        val rawTypedefDecl = parseTypedefDecl(listOf(typedef), 0).first
        functionTypedefs.putEntityIfAbsent(morphFunctionTypedef(rawTypedefDecl))
    }

    val opaqueTypedefs = mutableMapOf<Identifier, OpaqueTypedef>()
    opaqueTypedefs.putEntityIfAbsent(OpaqueTypedef("_cl_context"))
    opaqueTypedefs.putEntityIfAbsent(OpaqueTypedef("_cl_event"));

    val handles = mutableMapOf<Identifier, OpaqueHandleTypedef>()
    handles.putEntityIfAbsent(OpaqueHandleTypedef("GLeglClientBufferEXT"))
    handles.putEntityIfAbsent(OpaqueHandleTypedef("GLeglImageOES"))
    handles.putEntityIfAbsent(OpaqueHandleTypedef("GLsync"))

    val aliases = mutableMapOf<Identifier, Typedef>()
    aliases.putEntityIfAbsent(Typedef("GLcharARB", "GLchar"))
    aliases.putEntityIfAbsent(Typedef("GLhalfARB", "GLhalf"))
    aliases.putEntityIfAbsent(Typedef("GLintptrARB", "GLintptr"))
    aliases.putEntityIfAbsent(Typedef("GLsizeiptrARB", "GLsizeiptr"))
    aliases.putEntityIfAbsent(Typedef("GLint64EXT", "GLint64"))
    aliases.putEntityIfAbsent(Typedef("GLuint64EXT", "GLuint64"))
    aliases.putEntityIfAbsent(Typedef("GLhalfNV", "GLushort"))
    aliases.putEntityIfAbsent(Typedef("GLvdpauSurfaceNV", "GLintptr"))

    // On most platforms, GLhandleARB is an alias for GLuint. However, on macOS, it is defined as
    // void*. LWJGL did this so we also do this. What's more, the ARB extensions requiring
    // GLhandleARB types already have modern OpenGL replacements, so users won't use them
    // so this should not cause issues under common circumstances.
    aliases.putEntityIfAbsent(Typedef("GLhandleARB", "GLuint"))

    return Registry(
        aliases = aliases,
        bitmasks = mutableMapOf(),
        constants = constants,
        commands = commands,
        enumerations = mutableMapOf(),
        functionTypedefs = functionTypedefs,
        opaqueHandleTypedefs = handles,
        opaqueTypedefs = opaqueTypedefs,
        structures = mutableMapOf(),
        unions = mutableMapOf(),
        ext = EmptyMergeable()
    )
}

/// region constant
/**
 * @param e in form of `<enum value="..." name="...">`
 */
private fun extractEnumConstant(e: Element, constants: MutableMap<Identifier, Constant>) {
    val name = e.getAttributeText("name")!!
    var value = e.getAttributeText("value")!!

    val type = e.getAttributeText("type")
    val constantType = when (type) {
        "ull" -> {
            value = "${value}L"
            IdentifierType("GLuint64")
        }
        "u" -> IdentifierType("GLuint")
        null -> IdentifierType("GLenum")
        else -> throw IllegalArgumentException("Unknown enum type '$type' for constant '$name'.")
    }

    constants.putEntityIfAbsent(Constant(name, constantType, value))
}

/// endregion constant

/// region command

/**
 * Extract the text of given element without `<name>` tag.
 */
private fun getElementTextWithoutName(e: Element): String {
    return e.childNodes.asSequence()
        .filter { !(it is Element && it.tagName == "name") }
        .joinToString(separator = " ") { it.textContent.trim() }
}

/**
 * Extract type and name from element of form `some_type <name>some_name</name>`
 */
private fun extractTypeJudgement(e: Element): Pair<String, Type> {
    val name = e.getElementsByTagName("name").item(0).textContent.trim()
    val rawType = getElementTextWithoutName(e)
    val type = parseType(rawType).toType()
    return name to type
}

private fun extractCommand(e: Element): Command {
    // a proto is supposed to be: `<proto>return_type <name>command_name</name></proto>`
    val rawProto = e.getElementsByTagName("proto").item(0) as Element
    val (name, type) = extractTypeJudgement(rawProto)

    val params = e.getElementSeq("param")
        .map(::extractParam)
        .toMutableList()

    return Command(
        name = name,
        params = params,
        result = type,
        successCodes = null,
        errorCodes = null,
    )
}

/**
 * @param e in form of `<param someAttr>some_type <name>some_name</name></param>`
 */
private fun extractParam(e: Element): Param {
    val (name, type) = extractTypeJudgement(e)
    return Param(name, type, null, null, true)
}

/// endregion command

private fun morphFunctionTypedef(typedef: TypedefDecl) = FunctionTypedef(
    name = typedef.name,
    params = (typedef.aliasedType as RawFunctionType).params.map { it.second.toType() },
    result = typedef.aliasedType.returnType.toType()
)
