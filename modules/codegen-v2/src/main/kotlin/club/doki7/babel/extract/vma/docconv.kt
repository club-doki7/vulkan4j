package club.doki7.babel.extract.vma

import club.doki7.babel.cdecl.isIdentChar
import club.doki7.sennaar.registry.Command
import club.doki7.sennaar.registry.Entity
import club.doki7.sennaar.registry.Registry

internal fun postprocessDoc(registry: Registry) {
    registry.constants.values.forEach(::postprocessEntityDoc)
    registry.opaqueHandleTypedefs.values.forEach(::postprocessStructOrHandleDoc)
    registry.functionTypedefs.values.forEach(::postprocessEntityDoc)
    registry.structs.values.forEach {
        postprocessStructOrHandleDoc(it)
        it.members.forEach(::postprocessEntityDoc)
    }
    registry.bitmasks.values.forEach {
        postprocessEntityDoc(it)
        it.bitflags.forEach(::postprocessEntityDoc)
    }
    registry.enumerations.values.forEach {
        postprocessEntityDoc(it)
        it.variants.forEach(::postprocessEntityDoc)
    }

    registry.commands.values.forEach(::postprocessCommandDoc)
}

private fun postprocessStructOrHandleDoc(entity: Entity) {
    if (entity.doc.isNotEmpty()) {
        entity.doc = postprocessDoxygen(entity.doc).filter { !it.startsWith("\\struct") }.toMutableList()
    }
}

private fun postprocessEntityDoc(entity: Entity) {
    if (entity.doc.isNotEmpty()) {
        entity.doc = postprocessDoxygen(entity.doc)
    }
}

private fun postprocessCommandDoc(entity: Command) {
    if (entity.doc.isNotEmpty()) {
        entity.doc = postprocessCommandDoxygen(entity.doc).toMutableList()
    }

    entity.params.forEach {
        if (it.doc.isNotEmpty()) {
            it.doc = postprocessDoxygen(it.doc)
        }
    }
}

private fun postprocessDoxygen(doxygen: List<String>): MutableList<String> {
    val ret = mutableListOf<String>()
    for (line in doxygen) {
        ret.add(lineConvert(line).trim())
    }

    while (ret.isNotEmpty() && ret.first().isBlank()) {
        ret.removeFirst()
    }

    while (ret.isNotEmpty() && ret.last().isBlank()) {
        ret.removeLast()
    }

    return ret
}

private fun postprocessCommandDoxygen(doxygen: List<String>): List<String> {
    val tmp = postprocessDoxygen(doxygen)

    val nonAtLines = mutableListOf<String>()
    val atLines = mutableListOf<String>()

    var lastLineWasEmpty = false
    var index = 0
    while (index < tmp.size) {
        val line = tmp[index++]
        if (line.startsWith("@")) {
            atLines.add(line)
            if (line == "@return") {
                while (true) {
                    val returnLine = tmp[index++].trim()
                    if (returnLine.startsWith("- ")) {
                        atLines.add(returnLine)
                    } else {
                        break
                    }
                }
            }
        } else if (line.isBlank()) {
            if (!lastLineWasEmpty) {
                nonAtLines.add("")
                lastLineWasEmpty = true
            }
        } else {
            nonAtLines.add(line)
            lastLineWasEmpty = false
        }
    }

    while (nonAtLines.isNotEmpty() && nonAtLines.first().isBlank()) {
        nonAtLines.removeFirst()
    }

    while (nonAtLines.isNotEmpty() && nonAtLines.last().isBlank()) {
        nonAtLines.removeLast()
    }

    val ret = mutableListOf<String>()

    if (nonAtLines.isNotEmpty()) {
        for (line in nonAtLines) {
            ret.add(line)
        }
        ret.add("")
    }

    if (atLines.isNotEmpty()) {
        for (line in atLines) {
            if (line.startsWith("- ")) {
                ret.add("<li>${line.substring(2)}</li>")
            } else {
                ret.add(line)
            }
        }
    }

    return ret
}

private fun lineConvert(doxygen: String): String {
    var tmp = doxygen
    while (true) {
        val index = tmp.indexOf("#")
        if (index == -1) {
            break
        }

        var end = index + 1
        while (end < tmp.length && (tmp[end].isIdentChar())) {
            end++
        }

        if (end == index + 1) {
            break
        }

        val name = tmp.substring(index + 1, end)
        tmp = tmp.replace("#$name", "{@code $name}")
    }

    return tmp
        .replace("<", "&lt;")
        .replace(">", "&gt;")
        .replace("&", "&amp;")
        .replace("\\brief", "")
        .replace("\\ref", "")
        .replace("\\note", "@apiNode")
        .replace("\\param[out]", "@param")
        .replace("\\param", "@param")
        .replace("\\returns", "@return")
        .replace("\\return", "@return")
        .replace("\\deprecated", "@deprecated")
        .replace("\\section", "###")
        .replace("\\warning", "<b>Warning: </b>")
        .replace("\\code", "{@snippet lang=c:")
        .replace("\\endcode", "}")
        .replace("[DEPRECATED]", "(deprecated)")
}
