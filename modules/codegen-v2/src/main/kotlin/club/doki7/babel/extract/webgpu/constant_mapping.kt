package club.doki7.babel.extract.webgpu

import club.doki7.sennaar.cpl.CExpr
import club.doki7.sennaar.cpl.CIntLiteralExpr
import club.doki7.sennaar.registry.IdentifierType

data class ConstantTypeMapping(val identType: IdentifierType, val expr: CExpr)

val constantTypeMappings = mapOf(
    "uint32_max" to ConstantTypeMapping(IdentifierType("uint32_t"), CIntLiteralExpr("0xFFFFFFFF", "")),
    "uint64_max" to ConstantTypeMapping(IdentifierType("uint64_t"), CIntLiteralExpr("0xFFFFFFFF_FFFFFFFF", "ULL")),
    "usize_max" to ConstantTypeMapping(IdentifierType("size_t"), CIntLiteralExpr("0xFFFFFFFF_FFFFFFFF", "ULL"))
)
