package club.doki7.babel.cdecl

import club.doki7.babel.util.isHexDigit

internal enum class TokenKind {
    IDENT,
    SYMBOL,
    INTEGER,
    STRING,

    TRIVIA,

    EOI
}

internal data class Token(val kind: TokenKind, val value: String, val line: Int, val col: Int) {
    override fun toString(): String {
        return "$kind $value"
    }
}

internal class Tokenizer(private val source: List<String>, var curLine: Int) {
    private var curCol = 0

    private val curChar: Char inline get() = source[curLine][curCol]

    private var savedToken: Token? = null

    fun next(): Token {
        if (savedToken != null) {
            val token = savedToken!!
            savedToken = null
            return token
        }

        return nextTokenImpl()
    }

    fun peek(): Token {
        if (savedToken != null) {
            return savedToken!!
        }

        savedToken = nextTokenImpl()
        return savedToken!!
    }

    fun maybeSkipToLineEnd() {
        if (savedToken != null) {
            this.curCol = savedToken!!.col
            this.savedToken = null
        }

        while (curCol < source[curLine].length && source[curLine][curCol].isWhitespace()) {
            curCol++
        }

        if (curCol + 1 < source[curLine].length
            && source[curLine][curCol] == '/'
            && source[curLine][curCol + 1] == '*') {
            while (curLine < source.size && !source[curLine].endsWith("*/")) {
                curLine++
                curCol = 0
            }
            curLine++
            curCol = 0
            return
        }

        if (curCol + 1 < source[curLine].length && source[curLine][curCol] == '/' && source[curLine][curCol + 1] == '/') {
            curCol = source[curLine].length
        }

        if (curCol == source[curLine].length) {
            curLine++
            curCol = 0
        }
    }

    private fun nextTokenImpl(): Token {
        skipWhitespace()
        if (curLine >= source.size) {
            return Token(TokenKind.EOI, "", curLine, curCol)
        }

        val line = source[curLine]
        val c = line[curCol]

        return if (c == '/') {
            if (curCol + 1 < line.length && line[curCol + 1] == '/') {
                readLineComment()
            } else if (curCol + 1 < line.length && line[curCol + 1] == '*') {
                readBlockComment()
            } else {
                syntaxError("Unexpected character: $c", curLine, curCol)
            }
        } else if (c == '.') {
            if (curCol + 2 < line.length && line[curCol + 1] == '.' && line[curCol + 2] == '.') {
                curCol += 3
                Token(TokenKind.SYMBOL, "...", curLine, curCol - 3)
            } else {
                val token = Token(TokenKind.SYMBOL, c.toString(), curLine, curCol)
                curCol++
                token
            }
        } else if (c.isSymbolChar()) {
            val token = Token(TokenKind.SYMBOL, c.toString(), curLine, curCol)
            curCol++
            token
        } else if (c.isDigit()) {
            readInteger()
        } else if (c == '"') {
            readString()
        } else if (c.isIdentStartingChar()) {
            readIdent().let { token ->
                when (token.value) {
                    in knownTriviaCallLikeMacros -> {
                        val internalTokens = mutableListOf<Token>()
                        var internalToken = next()
                        if (internalToken.kind != TokenKind.SYMBOL || internalToken.value != "(") {
                            syntaxError("Expected '(', found: ${internalToken.value}", curLine, curCol)
                        }
                        internalTokens.add(internalToken)
                        while (true) {
                            internalToken = next()
                            if (internalToken.kind == TokenKind.EOI) {
                                syntaxError("Unterminated macro call", curLine, curCol)
                            }

                            internalTokens.add(internalToken)
                            if (internalToken.kind == TokenKind.SYMBOL && internalToken.value == ")") {
                                break
                            }
                        }
                        Token(
                            TokenKind.TRIVIA,
                            token.value + internalTokens.joinToString(" ") { it.value },
                            token.line,
                            token.col
                        )
                    }
                    in knownTriviaMacros -> token.copy(kind = TokenKind.TRIVIA)
                    else -> token
                }
            }
        } else {
            syntaxError("Unexpected character: $c", curLine, curCol)
        }
    }

    private fun readInteger(): Token {
        val start = curCol
        while (curCol < source[curLine].length && (curChar.isHexDigit() || curChar == '_' || curChar == 'x')) {
            curCol++
        }
        return Token(TokenKind.INTEGER, source[curLine].substring(start, curCol), curLine, start)
    }

    private fun readIdent(): Token {
        val start = curCol
        while (curCol < source[curLine].length && curChar.isIdentChar()) {
            curCol++
        }
        return Token(TokenKind.IDENT, source[curLine].substring(start, curCol), curLine, start)
    }

    private fun readString(): Token {
        curCol++
        val start = curCol
        while (curCol < source[curLine].length && source[curLine][curCol] != '"') {
            curCol++
        }
        if (curCol >= source[curLine].length && source[curLine][curCol] != '"') {
            syntaxError("Unterminated string literal", curLine, start)
        }
        curCol++
        return Token(TokenKind.STRING, source[curLine].substring(start, curCol - 1), curLine, start)
    }

    private fun readLineComment(): Token {
        curCol += 2
        val startCol = curCol
        val commentContent = source[curLine].substring(startCol)
        curLine++
        curCol = 0
        return Token(TokenKind.TRIVIA, commentContent, curLine - 1, startCol)
    }

    private fun readBlockComment(): Token {
        curCol += 2
        val content = StringBuilder()
        val startLine = curLine
        val startCol = curCol
        while (curLine < source.size) {
            while (curCol < source[curLine].length) {
                if (source[curLine][curCol] == '*' && curCol + 1 < source[curLine].length && source[curLine][curCol + 1] == '/') {
                    curCol += 2
                    return Token(TokenKind.TRIVIA, content.toString(), startLine, startCol)
                }
                content.append(source[curLine][curCol])
                curCol++
            }
            curLine++
            curCol = 0
        }
        syntaxError("Unterminated block comment", startLine, startCol)
    }

    private fun skipWhitespace() {
        while (curLine < source.size) {
            while (curCol < source[curLine].length && source[curLine][curCol].isWhitespace()) {
                curCol++
            }

            if (curCol >= source[curLine].length) {
                curLine++
                curCol = 0
            } else {
                break
            }
        }
    }
}

internal val knownTriviaMacros = setOf(
    "VMA_CALL_PRE",
    "VMA_CALL_POST",
    "VMA_EXTENDS_VK_STRUCT",
    "VMA_NULLABLE",
    "VMA_NOT_NULL",
    "VMA_NOT_NULL_NON_DISPATCHABLE",
    "VMA_NULLABLE_NON_DISPATCHABLE",

    "VKAPI_PTR",
    "GLFWAPI",

    "AL_APIENTRY",
    "AL_API_NOEXCEPT17",
    "AL_API",
    "AL_API_NOEXCEPT",
    "ALC_APIENTRY",
    "ALC_API_NOEXCEPT17",
    "ALC_API",
    "ALC_API_NOEXCEPT",

    "SDL_DECLSPEC",
    "SDLCALL",
    "SDL_PRINTF_FORMAT_STRING",
    "SDL_SCANF_FORMAT_STRING",
    "SDL_MALLOC",

    "SHADERC_EXPORT",
    "XRAPI_PTR",

    "STBIDEF",
    "STBTT_DEF",
    "STBIRDEF",
    "STBIWDEF",

    "WGPU_NULLABLE",

    "CL_CALLBACK",

    "extern"
)

private val knownTriviaCallLikeMacros = setOf(
    "VMA_LEN_IF_NOT_NULL",
    "VMA_EXTENDS_VK_STRUCT",

    "SDL_PRINTF_VARARG_FUNC",
    "SDL_PRINTF_VARARG_FUNCV",
    "SDL_SCANF_VARARG_FUNC",
    "SDL_SCANF_VARARG_FUNCV",
    "SDL_WPRINTF_VARARG_FUNC",
    "SDL_WPRINTF_VARARG_FUNCV",
    "SDL_ACQUIRE",
    "SDL_RELEASE",
    "SDL_TRY_ACQUIRE",
    "SDL_ACQUIRE_SHARED",
    "SDL_TRY_ACQUIRE_SHARED",
    "SDL_RELEASE_GENERIC",
    "SDL_ALLOC_SIZE",
    "SDL_ALLOC_SIZE2",
    "SDL_OUT_BYTECAP",
    "SDL_IN_BYTECAP",
    "SDL_OUT_Z_CAP",
    "SDL_INOUT_Z_CAP"
)
