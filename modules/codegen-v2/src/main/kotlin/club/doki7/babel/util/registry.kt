package club.doki7.babel.util

import club.doki7.sennaar.Identifier
import club.doki7.sennaar.interned
import club.doki7.sennaar.registry.ArrayType
import club.doki7.sennaar.registry.Entity
import club.doki7.sennaar.registry.FunctionTypedef
import club.doki7.sennaar.registry.IdentifierType
import club.doki7.sennaar.registry.PointerType
import club.doki7.sennaar.registry.Type

fun tryFindIdentifierType(type: Type): String? = when (type) {
    is ArrayType -> tryFindIdentifierType(type.element)
    is PointerType -> tryFindIdentifierType(type.pointee)
    is IdentifierType -> type.ident.toString()
}

object IdentifierTypes {
    val uint32_t: IdentifierType = IdentifierType("uint32_t".interned())
    val uint64_t: IdentifierType = IdentifierType("uint64_t".interned())
}

fun <E: Entity> MutableMap<Identifier, E>.putEntityIfAbsent(e: E) = putIfAbsent(e.name, e)

val FunctionTypedef.interfaceName: String get() = "I${this.name}"
