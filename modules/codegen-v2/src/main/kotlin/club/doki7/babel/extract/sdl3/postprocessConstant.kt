package club.doki7.babel.extract.sdl3

import club.doki7.sennaar.registry.Constant
import club.doki7.sennaar.registry.IdentifierType
import club.doki7.sennaar.registry.Registry
import club.doki7.sennaar.interned
import club.doki7.babel.util.parseDecOrHex

internal fun postprocessConstant(registry: Registry, constant: Constant): Constant {
    val constantValue = constant.expr
    val (type, finalValue) = if (constantValue.startsWith('"') && constantValue.endsWith('"')) {
        // It's a string constant
        Pair(IdentifierType("CONSTANTS_JavaString"), constantValue)
    } else if (constantValue.startsWith("(SDL_")) {
        // (SDL_TypeName) value, extract the `SDL_TypeName` part, most likely it's an enum or bitmask type
        val parts = constantValue.removePrefix("(")
            .split(")", limit = 2)
            .map(String::trim)
        val typeName = parts[0]
        val actualValue = parts[1]

        when (typeName.interned()) {
            in registry.enumerations -> {
                Pair(IdentifierType("uint32_t"), actualValue)
            }
            in registry.bitmasks -> {
                val bitmaskType = registry.bitmasks[typeName.interned()]!!
                Pair(
                    IdentifierType(when (bitmaskType.bitwidth) {
                        8 -> "uint8_t"
                        16 -> "uint16_t"
                        32 -> "uint32_t"
                        64 -> "uint64_t"
                        else -> error("Unknown bitmask bitwidth: ${bitmaskType.bitwidth}")
                    }),
                    actualValue
                )
            }
            in registry.aliases -> {
                val aliasedType = registry.aliases[typeName.interned()]!!.type as IdentifierType
                Pair(aliasedType, actualValue)
            }
            else -> error("Unknown type in constant definition: $typeName")
        }
    } else if (constantValue.contains("SDL_")) {
        val constants = constantValue
            .removePrefix("(")
            .removeSuffix(")")
            .split("|")
            .map(String::trim)
            .toMutableList()
        val firstConstant = constants.first()
        val linkedConstant = registry.constants[firstConstant.interned()]!!

        if (linkedConstant.type.ident.original == "INDETERMINATE") {
            // don't change and wait for next turn
            Pair(IdentifierType("INDETERMINATE"), constantValue)
        } else {
            if (constants.size == 1 && linkedConstant.type.ident.original == "CONSTANTS_JavaString") {
                Pair(linkedConstant.type, linkedConstant.expr)
            } else {
                Pair(
                    linkedConstant.type,
                    constants.joinToString(" | ") { it.removePrefix("SDL_") }
                )
            }
        }
    } else if (constantValue.endsWith("f") && !constantValue.startsWith("0x")) {
        Pair(IdentifierType("float"), constantValue)
    } else if (constantValue.endsWith("u")) {
        // Unsigned integer constant
        Pair(IdentifierType("uint32_t"), constantValue.removeSuffix("u").trim())
    } else if (constantValue.endsWith("U")) {
        Pair(IdentifierType("uint32_t"), constantValue.removeSuffix("U").trim())
    } else if (constantValue.endsWith("LL")) {
        // Long integer constant
        Pair(IdentifierType("int64_t"), constantValue.removeSuffix("L").trim())
    } else if (constantValue.endsWith("L")) {
        Pair(IdentifierType("int64_t"), constantValue)
    } else {
        try {
            val parsedValue = constantValue.parseDecOrHex()
            if (parsedValue < 0) {
                Pair(IdentifierType("int32_t"), parsedValue.toString())
            } else  {
                Pair(IdentifierType("uint32_t"), "0x" + parsedValue.toString(16))
            }
        } catch (_: NumberFormatException) {
            Pair(IdentifierType("uint32_t"), constantValue)
        }
    }

    return Constant(
        name = constant.name,
        type = type,
        expr = finalValue
    )
}
