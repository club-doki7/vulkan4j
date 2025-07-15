package club.doki7.babel.cdecl

fun Char.isIdentChar(): Boolean = this.isLetterOrDigit() || this == '_'

fun Char.isIdentStartingChar(): Boolean = this.isLetter() || this == '_'

fun Char.isSymbolChar(): Boolean = this in symbolChars

fun String.isIdentifier(): Boolean {
    if (this.isEmpty()) return false
    if (!this[0].isIdentStartingChar()) return false
    for (c in this) {
        if (!c.isIdentChar()) return false
    }
    return true
}

private val symbolChars = setOf(
    '{', '}', '[', ']', '(', ')', ',', ';', '=', '*', '|', '-', '+'
)
