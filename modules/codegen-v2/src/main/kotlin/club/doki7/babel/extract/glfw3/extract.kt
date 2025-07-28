package club.doki7.babel.extract.glfw3

import club.doki7.babel.cdecl.*
import club.doki7.babel.extract.*
import club.doki7.sennaar.Identifier
import club.doki7.sennaar.registry.*
import kotlinx.serialization.json.JsonNull
import java.util.logging.Logger
import kotlin.io.path.Path

private val inputDir = Path("codegen-v2/input")
internal val log = Logger.getLogger("c.d.b.extract.glfw3")

fun extractGLFWHeader(): Registry {
    val fileContent = inputDir.resolve("glfw3.h").toFile().readText() +
            "\n" +
            inputDir.resolve("glfw3native.h").toFile().readText()

    val lines = fileContent.splitToSequence('\n').map(String::trim)
        .toList()
    val registry = Glfw3HeaderParser(lines).parse().collect()
    registry.renameEntities()

    return registry
}

/**
 * one use parser
 */
abstract class HeaderParser<T>(val lines: List<String>) {
    /**
     * Line iterator, the value indicates the next line index, or how many lines are consumed.
     */
    var lineIndex = 0

    protected fun nextLine(): String? {
        val line = lines.getOrNull(lineIndex)
        if (line != null) {
            lineIndex += 1
            return line.trim()
        }

        return null
    }

    protected fun peekLine(): String? {
        return lines.getOrNull(lineIndex)
    }

    open fun parse(): HeaderParser<T> {
        var lastIndex = -1

        while (true) {
            if (lastIndex == lineIndex) {
                log.warning("glfw3.h: infinite loop detected at line $lineIndex: ${lines[lineIndex]}, forcing process")
                lineIndex += 1
            }

            val currentLine = peekLine() ?: break
            if (currentLine.isBlank()) {
                nextLine()
                continue
            }

            lastIndex = lineIndex

            if (! parseOne())
                break
        }

        return this
    }

    abstract fun collect(): T

    /**
     * Assumption: [peekLine] is never null and blank
     * @return if continue
     */
    protected abstract fun parseOne(): Boolean
}

/**
 * After [parse]: [lineIndex] is the line below the last comment, or `lineIndex == 0` if no comment is met.
 */
class Glfw3CommentParser<T, P : HeaderParser<T>>(delegate: P) :
    HeaderParser<MutableList<String>>(delegate.lines.subList(delegate.lineIndex, delegate.lines.size)) {
    private var savedDoc: MutableList<String> = mutableListOf()

    override fun collect(): MutableList<String> {
        return savedDoc
    }

    override fun parseOne(): Boolean {
        val line = peekLine()!!

        when {
            isBlockCommentIndicator(line) -> {
                val (doc, newIdx) = parseBlockDoxygen(lines, lineIndex)     // not yet consume, so lineIndex is correct
                savedDoc = doc
                lineIndex = newIdx      // do consume
            }

            isTriSlashIndicator(line) -> {
                val (doc, newIdx) = parseTriSlashDoxygen(lines, lineIndex)
                savedDoc = doc
                lineIndex = newIdx
            }

            isLineCommentIndicator(line) -> {
                nextLine()      // ignore and consume
            }

            else -> return false
        }

        // now, we already consume at least one line
        return true
    }
}


/**
 * Assumption: `delegate.lineIndex` is the line below `{`
 * After [parse]: [lineIndex] is the line below `} STRUCT_NAME;`
 */
class Glfw3StructParser<P : HeaderParser<*>>(delegate: P) :
    HeaderParser<Glfw3StructParser.ParsedStruct>(delegate.lines.subList(delegate.lineIndex, delegate.lines.size)) {
    private var name: String? = null
    private val members: MutableList<Member> = mutableListOf()
    private var savedDoc: MutableList<String> = mutableListOf()

    fun getDocument(): MutableList<String> {
        val savedDoc = savedDoc
        this.savedDoc = mutableListOf()
        return savedDoc
    }

    class ParsedStruct(val name: String, val members: MutableList<Member>)

    override fun collect(): ParsedStruct {
        assert(name != null)
        return ParsedStruct(name!!, members)
    }

    override fun parseOne(): Boolean {
        val commentParser = Glfw3CommentParser(this)
            .parse()
        val savedDoc = commentParser.collect()
        if (savedDoc.isNotEmpty()) this.savedDoc = savedDoc
        lineIndex = lineIndex + commentParser.lineIndex

        val currentLine = peekLine() ?: return false

        when {
            currentLine.startsWith('}') -> {
                assert(currentLine.endsWith(';'))
                val structName = currentLine.substring(1, currentLine.length - 1).trim()
                this.name = structName
                nextLine()      // consume
                return false
            }

            currentLine.endsWith(';') -> {
                val (declList, newIdx) = parseStructFieldDecl(lines, lineIndex)
                lineIndex = newIdx
                assert(declList.size == 1)

                val decl = declList[0]

                val member = Member(
                    name = decl.name,
                    ty = decl.type.toType(),
                    bits = null,
                    init = null,
                    optional = false,
                    len = null,
                )
                member.doc = getDocument()
                members.add(member)
            }

            else -> {
                log.warning("glfw3.h: unknown line: $currentLine")
                nextLine()      // consume
            }
        }

        return true
    }
}

class Glfw3HeaderParser(lines: List<String>) : HeaderParser<Registry>(lines) {
    companion object {
        // `typedef struct `
        const val OFFSET_TYPEDEF_STRUCT = 8 + 7
    }

    private val functionTypedefs: MutableMap<Identifier, FunctionTypedef> = mutableMapOf()
    private val structs: MutableMap<Identifier, Structure> = mutableMapOf()
    private val opaqueTypedefs: MutableMap<Identifier, OpaqueTypedef> = mutableMapOf()
    private val constants: MutableMap<Identifier, Constant> = mutableMapOf()
    private val commands: MutableMap<Identifier, Command> = mutableMapOf()
    private var savedDoc: MutableList<String> = mutableListOf()

    fun getDocument(): MutableList<String> {
        val savedDoc = savedDoc
        this.savedDoc = mutableListOf()
        return savedDoc
    }

    override fun collect(): Registry {
        return Registry(
            "glfw3",
            imports = mutableSetOf(),
            aliases = mutableMapOf(),
            bitmasks = mutableMapOf(),
            commands = commands,
            constants = constants,
            enumerations = mutableMapOf(),
            functionTypedefs = functionTypedefs,
            opaqueTypedefs = opaqueTypedefs,
            opaqueHandleTypedefs = mutableMapOf(),
            structs = structs,
            unions = mutableMapOf(),
            ext = JsonNull
        )
    }

    override fun parseOne(): Boolean {
        val commentParser = Glfw3CommentParser(this)
            .parse()
        val doc = commentParser.collect()
        if (doc.isNotEmpty()) savedDoc = doc
        lineIndex = lineIndex + commentParser.lineIndex

        val currentLine = nextLine() ?: return false

        when {
            currentLine.startsWith("#define GLFW_") -> {
                val parts = currentLine.split(' ', limit = 3)
                if (parts.size < 3) return true

                val name = parts[1].trim()
                val value = parts[2].trim()
                val constant = Constant(
                    name = name,
                    ty = IdentifierType("int32_t"),
                    expr = TODO("need to implement general expression parsing")
                )
                constants[constant.name] = constant
            }

            currentLine.startsWith("GLFWAPI ") -> {
                // TODO: this may not work well with multi-line declaration, lucky there isn't for now.
                // This is going to be fixed in a further `babel` release. Now we can just use the GLFW3 header as
                // it is.
                val (decl, _) = parseFunctionDecl(listOf(currentLine), 0)
                val cmd = morphFunctionDecl(decl)
                cmd.doc = getDocument()
                commands[cmd.name] = cmd
            }

            else -> {
                val typedefKind = isTypedef(currentLine)
                when (typedefKind) {
                    TypedefKind.Normal -> {
                        if (currentLine.contains("proc") || currentLine.contains("fun")) {
                            parseNormalTypedef()
                        }
                    }
                    // we don't have `typedef enum`
                    TypedefKind.Enum -> assert(false) { "unreachable" }
                    TypedefKind.Struct -> {
                        parseStruct(currentLine)
                    }

                    null -> {
                        // ignored
                    }
                }
            }
        }

        return true
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
        params = (typedef.aliasedType as RawFunctionType).params.map { Param(
            name = it.first,
            ty = it.second.toType(),
            len = null,
            optional = true
        ) }.toMutableList(),
        result = typedef.aliasedType.returnType.toType(),
        isPointer = true,
        isNativeAPI = false
    )

    /**
     * Assumption: [lineIndex - 1] is the `typedef` line
     */
    fun parseNormalTypedef() {
        val (typedef, newIdx) = parseTypedefDecl(lines, lineIndex - 1)
        this.lineIndex = newIdx
        val functionTypedef = morphFunctionTypedef(typedef)
        functionTypedef.doc = getDocument()
        functionTypedefs[functionTypedef.name] = functionTypedef
    }

    /**
     * Assumption: [lineIndex] is the line below `typedef struct` (which is [typedefLine])
     * After call: [lineIndex] is the line below the whole `typedef struct`
     */
    fun parseStruct(typedefLine: String) {
        // we have two kinds of typedef struct:
        // * `typedef struct SOME_NAME ANOTHER_NAME;`
        // * ```
        //   typedef struct SOME_NAME
        //   {
        //   ...
        //   } ANOTHER_NAME;
        //   ```

        if (typedefLine.endsWith(';')) {
            // first kind
            // `SOME_NAME ANOTHER_NAME`
            val headless = typedefLine.substring(OFFSET_TYPEDEF_STRUCT, typedefLine.length - 1).trim()
            val names = headless.split(' ')
            assert(names.size == 2)

            val name = names[1]
            val typedef = OpaqueTypedef(name)
            typedef.doc = getDocument()
            opaqueTypedefs[typedef.name] = typedef

            // no need to consume due to the call assumption
            // after call holes
            return
        }

        // second kind
        val nextLine = nextLine()           // consume the `{` line, now [lineIndex] is the line below `{`
        assert(nextLine != null && nextLine.startsWith('{'))
        val structParser = Glfw3StructParser(this)
            .parse()
        val parsedStruct = structParser.collect()
        lineIndex = lineIndex + structParser.lineIndex
        // now, [lineIndex] is the line below `} STRUCT_NAME;`
        val struct = Structure(parsedStruct.name, parsedStruct.members)
        struct.doc = getDocument()
        structs[struct.name] = struct
        // after call holes
    }
}
