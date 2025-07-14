package club.doki7.babel.extract.opencl

import club.doki7.babel.registry.ArrayType
import club.doki7.babel.registry.Identifier
import club.doki7.babel.registry.IdentifierTypes
import club.doki7.babel.registry.Member
import club.doki7.babel.registry.Registry
import club.doki7.babel.registry.Structure
import club.doki7.babel.registry.intern
import club.doki7.babel.registry.putEntityIfAbsent

internal fun Registry<OpenCLRegistryExt>.addDependencies() {
    log.info("手动添加类型 VAImageFormat")
    val VAImageFormat = "VAImageFormat".intern()
    VAImageFormat.rename("VAImageFormatCLREF")
    structures.putEntityIfAbsent(
        Structure(
            VAImageFormat,
            mutableListOf(
                Member("fourcc", IdentifierTypes.uint32_t, null, null, null, false, null),
                Member("byte_order", IdentifierTypes.uint32_t, null, null, null, false, null),
                Member("bits_per_pixel", IdentifierTypes.uint32_t, null, null, null, false, null),
                Member("depth", IdentifierTypes.uint32_t, null, null, null, false, null),
                Member("red_mask", IdentifierTypes.uint32_t, null, null, null, false, null),
                Member("green_mask", IdentifierTypes.uint32_t, null, null, null, false, null),
                Member("blue_mask", IdentifierTypes.uint32_t, null, null, null, false, null),
                Member("alpha_mask", IdentifierTypes.uint32_t, null, null, null, false, null),
                // #define VA_PADDING_LOW   4
                Member(
                    "va_reserved",
                    ArrayType(IdentifierTypes.uint32_t, Identifier("4")),
                    null,
                    null,
                    null,
                    false,
                    null
                )
            )
        )
    )
}