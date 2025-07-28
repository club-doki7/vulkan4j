package club.doki7.babel.extract.shaderc

import club.doki7.sennaar.registry.EnumVariant
import club.doki7.sennaar.registry.Enumeration
import club.doki7.babel.util.Either

internal fun postprocessEnumeration(enumeration: Enumeration) {
    var lastEnumValue: Long? = null
    for (index in enumeration.variants.indices) {
        val variant = enumeration.variants[index]

        if (variant.value is Either.Left) {
            val left = variant.value as Either.Left<Long, List<String>>
            lastEnumValue = left.value + 1
        } else if (variant.value is Either.Right) {
            val right = variant.value as Either.Right<Long, List<String>>
            if (right.value.isEmpty()) {
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
            } else if (right.value.size == 1) {
                val referencedValue = findReferencedValue(enumeration.variants, index, right.value[0])
                enumeration.variants[index] = EnumVariant(
                    name = variant.name,
                    value = Either.Right(listOf(referencedValue.name.value))
                )
                lastEnumValue = (referencedValue.value as Either.Left<Long, List<String>>).value + 1
            } else {
                lastEnumValue = null
            }
        }
    }
}

fun findReferencedValue(variants: MutableList<EnumVariant>, index: Int, string: String): EnumVariant {
    for (i in index - 1 downTo 0) {
        val variant = variants[i]
        if (variant.name.original == string) {
            return variant
        }
    }

    error("Referenced value '$string' not found in enumeration variants before index $index.")
}
