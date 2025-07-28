package club.doki7.babel.extract.sdl3

import club.doki7.sennaar.registry.EnumVariant
import club.doki7.sennaar.registry.Enumeration
import club.doki7.babel.util.Either

internal fun postprocessEnumeration(enumeration: Enumeration) {
    var lastEnumValue: Long? = null
    for (index in enumeration.variants.indices) {
        val variant = enumeration.variants[index]

        if (variant.value is Either.Left) {
            lastEnumValue = (variant.value as Either.Left<Long, List<String>>).value + 1
        } else if (variant.value is Either.Right) {
            if ((variant.value as Either.Right<Long, List<String>>).value.isEmpty()) {
                if (lastEnumValue == null) {
                    if (index == 0) {
                        lastEnumValue = -1
                    } else {
                        error("Enumeration variant '${variant.name}' has no value and no previous value to increment from.")
                    }
                }
                lastEnumValue += 1
                enumeration.variants[index] = EnumVariant(
                    name = variant.name,
                    value = Either.Left(lastEnumValue)
                )
            } else {
                lastEnumValue = null
            }
        }
    }
}
