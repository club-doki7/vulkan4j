package club.doki7.babel.extract.gles2

import club.doki7.babel.cdecl.parseType
import club.doki7.babel.cdecl.toType
import club.doki7.sennaar.registry.*
import club.doki7.babel.util.asSequence
import club.doki7.babel.util.getAttributeText
import club.doki7.babel.util.getElementSeq
import club.doki7.babel.util.parseXML
import club.doki7.babel.util.putEntityIfAbsent
import club.doki7.babel.util.query
import club.doki7.sennaar.Identifier
import club.doki7.sennaar.cpl.CIntLiteralExpr
import club.doki7.sennaar.interned
import org.w3c.dom.Element
import java.util.logging.Logger
import kotlin.io.path.Path

private val inputDir = Path("codegen-v2/input")
internal val log = Logger.getLogger("c.d.b.extract.gles2")

fun extractGLES2Registry(): Registry {
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

    val featureElement = e.query("feature[@api='gles2' and @number='2.0']").first()
    for (require in featureElement.getElementSeq(TAG_REQUIRE)) {
        for (commandRequire in require.getElementSeq(TAG_COMMAND)) {
            val name = commandRequire.getAttributeText(ATTR_NAME)!!
            val command = allCommands[name.interned()]!!
            commands.putEntityIfAbsent(command)
        }

        for (enumRequire in require.getElementSeq(TAG_ENUM)) {
            val name = enumRequire.getAttributeText(ATTR_NAME)!!
            val constant = allConstants[name.interned()]!!
            constants.putEntityIfAbsent(constant)
        }
    }

    val ret = Registry("gles2")
    ret.commands = commands
    ret.constants = constants
    return ret
}

private const val ATTR_VALUE = "value"
private const val ATTR_NAME = "name"
private const val TAG_PROTO = "proto"
private const val TAG_NAME = "name"
private const val TAG_PARAM = "param"
private const val TAG_ENUM = "enum"
private const val TAG_COMMAND = "command"
private const val TAG_REQUIRE = "require"

/// region constant

/**
 * @param e in form of `<enum value="..." name="...">`
 */
private fun extractEnumConstant(e: Element, constants: MutableMap<Identifier, Constant>) {
    val name = e.getAttributeText(ATTR_NAME)!!
    val value = e.getAttributeText(ATTR_VALUE)!!

    constants.putEntityIfAbsent(Constant(
        name = name,
        ty = IdentifierType("GLenum"),
        expr = CIntLiteralExpr(value)
    ))
}

/// endregion constant

/// region command

/**
 * Extract the text of given element without `<name>` tag.
 */
private fun getElementTextWithoutName(e: Element): String {
    return e.childNodes.asSequence()
        .filter { !(it is Element && it.tagName == TAG_NAME) }
        .joinToString(separator = " ") { it.textContent.trim() }
}

/**
 * Extract type and name from element of form `some_type <name>some_name</name>`
 */
private fun extractTypeJudgement(e: Element): Pair<String, Type> {
    val name = e.getElementsByTagName(TAG_NAME).item(0).textContent.trim()
    val rawType = getElementTextWithoutName(e)
    val type = parseType(rawType).toType()
    return name to type
}

private fun extractCommand(e: Element): Command {
    // a proto is supposed to be: `<proto>return_type <name>command_name</name></proto>`
    val rawProto = e.getElementsByTagName(TAG_PROTO).item(0) as Element
    val (name, type) = extractTypeJudgement(rawProto)

    val params = e.getElementSeq(TAG_PARAM)
        .map(::extractParam)
        .toMutableList()

    return Command(
        name = name,
        params = params,
        result = type,
        successCodes = mutableListOf(),
        errorCodes = mutableListOf()
    )
}

/**
 * @param e in form of `<param someAttr>some_type <name>some_name</name></param>`
 */
private fun extractParam(e: Element): Param {
    val (name, type) = extractTypeJudgement(e)
    return Param(
        name = name,
        ty = type,
        optional = true,
        len = null
    )
}

/// endregion command
