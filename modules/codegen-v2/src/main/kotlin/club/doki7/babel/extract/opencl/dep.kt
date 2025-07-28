package club.doki7.babel.extract.opencl

import club.doki7.babel.util.IdentifierTypes
import club.doki7.babel.util.putEntityIfAbsent
import club.doki7.sennaar.registry.ArrayType
import club.doki7.sennaar.cpl.CIntLiteralExpr
import club.doki7.sennaar.registry.Member
import club.doki7.sennaar.registry.Registry
import club.doki7.sennaar.registry.Structure
import club.doki7.sennaar.interned

internal fun Registry.addDependencies() {
    log.info("手动添加类型 VAImageFormat")
    val VAImageFormat = "VAImageFormat".interned()
    VAImageFormat.rename("VAImageFormatCLREF")
    structs.putEntityIfAbsent(
        Structure(
            VAImageFormat,
            mutableListOf(
                Member(name = "fourcc", ty = IdentifierTypes.uint32_t, bits = null, init = null, optional = false, len = null),
                Member(name = "byte_order", ty = IdentifierTypes.uint32_t, bits = null, init = null, optional = false, len = null),
                Member(name = "bits_per_pixel", ty = IdentifierTypes.uint32_t, bits = null, init = null, optional = false, len = null),
                Member(name = "depth", ty = IdentifierTypes.uint32_t, bits = null, init = null, optional = false, len = null),
                Member(name = "red_mask", ty = IdentifierTypes.uint32_t, bits = null, init = null, optional = false, len = null),
                Member(name = "green_mask", ty = IdentifierTypes.uint32_t, bits = null, init = null, optional = false, len = null),
                Member(name = "blue_mask", ty = IdentifierTypes.uint32_t, bits = null, init = null, optional = false, len = null),
                Member(name = "alpha_mask", ty = IdentifierTypes.uint32_t, bits = null, init = null, optional = false, len = null),
                // #define VA_PADDING_LOW   4
                Member(
                    name = "va_reserved",
                    ty = ArrayType(IdentifierTypes.uint32_t, CIntLiteralExpr("4")),
                    bits = null,
                    init = null,
                    optional = false,
                    len = null
                )
            )
        )
    )
}
