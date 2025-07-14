package club.doki7.babel.extract

internal fun String.ensureLowerCamelCase(): String {
    val firstChar = this[0]
    if (this.length >= 2) {
        val secondChar = this[1]
        if (firstChar.isUpperCase() && secondChar.isUpperCase()) {
            return this
        }
    }

    return firstChar.lowercaseChar() + this.substring(1)
}

internal fun String.toSnakeCase(): String {
    val result = StringBuilder()
    for (i in indices) {
        val c = this[i]
        if (c.isUpperCase()) {
            if (i > 0 && this[i - 1].isLowerCase()) {
                result.append('_')
            }
            result.append(c.lowercaseChar())
        } else {
            result.append(c)
        }
    }
    return result.toString()
}

/**
 * @receiver the string must be either snake_case or c/CamlCase
 */
internal fun String.parseName(): List<String> {
    if (this.contains('_')) return split('_')

    val parts = mutableListOf<String>()
    var buffer = StringBuilder()

    for (c in this) {
        // We don't commit the buffer if:
        // * c is uppercase and buffer is a uppercase string, for example, `buffer = "KH"` and `c = 'R'`
        // * c is uppercase and buffer is empty, for example, `buffer = ""` and `c = 'K'`
        // we commit the buffer if:
        // * c is lowercase and buffer is a uppercase string with length `> 1`, for example, `buffer = URLE` and `c = n`
        // (the whole string is "URLEncoder")
        // otherwise, we commit the buffer, for example, `buffer = "Space"` and `c = 'K'`
        // (the whole string is "VkColorSpaceKHR")
        if (c.isUpperCase()) {
            if (buffer.isNotEmpty() && !buffer.last().isUpperCase()) {
                parts.add(buffer.toString())
                buffer = StringBuilder()
            }
        } else {
            // c is lower case
            if (buffer.length > 1 && buffer.last().isUpperCase()) {
                // in this case, the last uppercase character in buffer belongs to the next part
                val prev = buffer.last()
                // this is why buffer.length > 1, otherwise we will commit an empty string
                parts.add(buffer.dropLast(1).toString())
                buffer = StringBuilder()
                buffer.append(prev)
            }
        }

        buffer.append(c)
    }

    if (buffer.isNotEmpty()) parts.add(buffer.toString())
    return parts
}

internal fun renameVariantOrBitflag(
    name: String,
    parent: String,
    bitflag: Boolean = false,
): String {
    // Find the extension author suffix in the parent name, if any.
    // E.g., `EXT` in `DebugReportObjectTypeEXT`.
    val extension =
        // TODO: use takeLastWhile
        parent
            .reversed()
            .takeWhile { it.isUpperCase() }
            .reversed()

    // Determine the prefix to strip from the value name (parent name).
    // E.g., `DEBUG_REPORT_OBJECT_TYPE_` for `DebugReportObjectTypeEXT` (variant).
    // E.g., `DEBUG_REPORT_` for `DebugReportFlagsEXT` (bitflag).
    var prefix =
        parent
            .substring(0, parent.length - extension.length)
            .toSnakeCase()
            .uppercase()
    if (bitflag) prefix = prefix.replace(Regex("FLAGS(\\d*)"), "$1")
    if (!prefix.endsWith('_')) prefix = "${prefix}_"

    // Determine the suffix to strip from the value name (parent extension author).
    // E.g., `_EXT` for `DebugReportObjectTypeEXT`
    val suffix = "_$extension".trimEnd('_')

    val renamed =
        name
            .removePrefix(prefix)
            .removeSuffix(suffix)
            // Some value names start with digits after the prefixes have been
            // stripped which would make them invalid identifiers.
            .replace(Regex("^([0-9])"), "_$1")
            // Some value names include lowercase characters that need to be
            // capitalized (e.g., `VK_FORMAT_ASTC_4x4_SFLOAT_BLOCK_EXT`).
            .uppercase()

    // Remove `BIT` component from bitflag name even when followed by extension author.
    return if (bitflag) {
        renamed.replace(Regex("_BIT(_[A-Z]+)?$"), "$1")
    } else {
        renamed
    }
}

internal fun String.toPascalCase(): String {
    return this
        .split('_')
        .filter { it.isNotEmpty() }
        .joinToString("") { part ->
            if (part.length <= 1) part.uppercase()
            else part.lowercase().replaceFirstChar { it.uppercaseChar() }
        }
}