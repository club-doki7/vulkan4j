package club.doki7.babel.codegen

import club.doki7.sennaar.registry.Enumeration
import club.doki7.sennaar.registry.Registry
import club.doki7.babel.util.Either
import club.doki7.babel.util.buildDoc

fun generateEnumeration(
    registry: Registry,
    enumeration: Enumeration,
    codegenOptions: CodegenOptions
) = buildDoc {
    val docLink = codegenOptions.seeLinkProvider(enumeration)
    val variants = enumeration.variants.sortedBy { it.name }

    +"package ${codegenOptions.packageName}.enumtype;"
    +""

    if (variants.isNotEmpty()) {
        +"import club.doki7.ffm.annotation.*;"
        +""
    }

    if (enumeration.doc.isNotEmpty()) {
        for (line in enumeration.doc) {
            +"/// $line"
        }
        +"///"
    }

    if (docLink != null) {
        +"/// @see $docLink"
    }
    +"public final class ${enumeration.name} {"
    indent {
        for ((idx, variant) in enumeration.variants.withIndex()) {
            if (variant.doc.isNotEmpty()) {
                if (idx != 0) {
                    +""
                }
                variant.doc.forEach { +"/// $it" }
            }

            val docLink = codegenOptions.seeLinkProvider(variant)
            if (docLink != null) {
                +"/// @see $docLink"
            }

            val value = when (variant.value) {
                is Either.Left -> {
                    val hexValue = (variant.value as Either.Left<Long, List<String>>).value.toUInt().toString(16)
                    "0x$hexValue"
                }
                is Either.Right -> {
                    val value = (variant.value as Either.Right<Long, List<String>>).value
                    if (value.isEmpty()) {
                        "0"
                    } else {
                        value.joinToString(" | ")
                    }
                }
            }

            +"public static final int ${variant.name} = ${value};"
        }

        if (variants.isNotEmpty()) {
            +""
            +"public static String explain(@EnumType(${enumeration.name}.class) int value) {"
            indent {
                +"return switch (value) {"
                indent {
                    for (variant in variants) {
                        if (variant.value is Either.Right) {
                            continue
                        }
                        +"case ${enumeration.name}.${variant.name} -> \"${variant.name.original}\";"
                    }
                    +"default -> \"UNKNOWN(\" + value + \")\";"
                }
                +"};"
            }
            +"}"
            +""
        }

        +prohibitUserConstruct(enumeration.name)
    }
    +"}"
}
