package club.doki7.babel.registry

sealed interface Type {
    val cDisplay: String
}

data class IdentifierType(val ident: Identifier) : Type {
    constructor(ident: String) : this(ident.intern())

    override val cDisplay = ident.original
}

data class ArrayType(val element: Type, val length: Identifier) : Type {
    override val cDisplay = "${element.cDisplay}[${length.original}]"
}

data class PointerType(
    val pointee: Type,
    val const: Boolean = false,
    var pointerToOne: Boolean = false
) : Type {
    override val cDisplay = "${pointee.cDisplay}${if (const) " const" else ""}*"
}

fun tryFindIdentifierType(type: Type): String? = when (type) {
    is ArrayType -> tryFindIdentifierType(type.element)
    is PointerType -> tryFindIdentifierType(type.pointee)
    is IdentifierType -> type.ident.toString()
}

object IdentifierTypes {
    val uint32_t: IdentifierType = IdentifierType("uint32_t")
    val uint64_t: IdentifierType = IdentifierType("uint64_t")
}