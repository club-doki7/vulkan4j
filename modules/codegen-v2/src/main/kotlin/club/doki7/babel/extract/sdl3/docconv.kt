package club.doki7.babel.extract.sdl3

import club.doki7.babel.cdecl.isIdentChar
import club.doki7.sennaar.registry.Command
import club.doki7.sennaar.registry.Entity
import club.doki7.sennaar.registry.Registry
import club.doki7.sennaar.interned

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
        entity.doc = postprocessDoxygen(entity.doc!!).filter { !it.startsWith("\\struct") }
    }
}

private fun postprocessEntityDoc(entity: Entity) {
    if (entity.doc.isNotEmpty()) {
        entity.doc = postprocessDoxygen(entity.doc!!)
    }
}

private fun postprocessCommandDoc(entity: Command) {
    if (entity.doc.isNotEmpty()) {
        val newDoc = mutableListOf<String>()
        for (line in entity.doc!!) {
            if (line.startsWith("\\sa ")) {
                val content = line.substring(4).trim().interned()
                if (content.renamed) {
                    newDoc.add("@see #${content.value}")
                } else {
                    newDoc.add("@see `${content.value}`")
                }
            } else if (line.startsWith("\\since " )) {
                val content = line.removePrefix("\\since ").trim()
                if (content.isNotEmpty()) {
                    newDoc.add("@since $content")
                }
            } else {
                newDoc.add(lineConvert(line).trim())
            }
        }

        entity.doc = newDoc
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

    val firstSaIndex = ret.indexOfFirst { it.startsWith("\\sa") }

    if (firstSaIndex != -1) {
        val processedRet = mutableListOf<String>()
        for (i in ret.indices) {
            val currentLine = ret[i]
            if (i == firstSaIndex) {
                processedRet.add("See also:")
            }

            if (currentLine.startsWith("\\sa")) {
                var content = currentLine.substring(3)
                content = content.trim()

                if (content.isNotEmpty()) {
                    processedRet.add("- `${content}`")
                }
            } else {
                processedRet.add(currentLine)
            }
        }
        ret.clear()
        ret.addAll(processedRet)
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
        .replace("\\threadsafety", "@threadsafety")
        .replace("\\section", "###")
        .replace("\\warning", "<b>Warning: </b>")
        .replace("\\since", "Since:")
        .replace("\\endcode", "}")
        .replace("[DEPRECATED]", "(deprecated)")
}
