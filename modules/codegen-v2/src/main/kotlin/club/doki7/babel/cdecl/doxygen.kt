package club.doki7.babel.cdecl

fun parseBlockDoxygen(lines: List<String>, startLine: Int): Pair<MutableList<String>, Int> {
    val doxygen = mutableListOf<String>()

    var line = startLine
    while (line < lines.size) {
        val curLine = lines[line].trim()
        if (curLine.endsWith("*/")) {
            val lineDoc = if (curLine.startsWith("/**") || curLine.startsWith("/*!")) {
                    curLine.substring(3, curLine.length - 2)
            } else if (curLine == "*" || curLine.startsWith("* ")) {
                curLine.substring(2, curLine.length - 2)
            } else {
                curLine.substring(0, curLine.length - 2)
            }
            doxygen.add(lineDoc)
            line++
            break
        }

        val lineDoc = if (curLine.startsWith("/**") || curLine.startsWith("/*!")) {
            curLine.substring(3)
        } else if (curLine == "*") {
            ""
        } else if (curLine.startsWith("* ")) {
            curLine.substring(2)
        } else {
            curLine
        }

        lineDoc.split("\\n").forEachIndexed { i, it ->
            doxygen.add(it)
        }
        line++
    }

    while (doxygen.isNotEmpty() && doxygen.first().isBlank()) {
        doxygen.removeFirst()
    }

    while (doxygen.isNotEmpty() && doxygen.last().isBlank()) {
        doxygen.removeLast()
    }

    return Pair(doxygen, line)
}

fun parseTriSlashDoxygen(lines: List<String>, startLine: Int): Pair<MutableList<String>, Int> {
    val doxygen = mutableListOf<String>()

    var line = startLine
    while (line < lines.size) {
        val curLine = lines[line]
        if (!curLine.startsWith("///")) {
            break
        }

        curLine.substring(3).split("\\n").forEachIndexed { i, it ->
            doxygen.add(it.trim())
        }
        line++
    }

    while (doxygen.isNotEmpty() && doxygen.first().isBlank()) {
        doxygen.removeFirst()
    }

    while (doxygen.isNotEmpty() && doxygen.last().isBlank()) {
        doxygen.removeLast()
    }

    return Pair(doxygen, line)
}
