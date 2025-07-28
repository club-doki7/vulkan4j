package club.doki7.babel.cdecl

import club.doki7.sennaar.cpl.CIdentifierExpr
import club.doki7.sennaar.registry.ArrayType
import club.doki7.sennaar.registry.IdentifierType
import club.doki7.sennaar.registry.PointerType
import club.doki7.sennaar.registry.Type
import club.doki7.sennaar.interned

sealed interface Decl { val trivia: List<String> }

data class VarDecl(
    val name: String,
    val type: RawType,
    override val trivia: List<String>
) : Decl

data class FunctionDecl(
    val name: String,
    val returnType: RawType,
    val params: List<VarDecl>,
    override val trivia: List<String>
) : Decl

data class TypedefDecl(
    val name: String,
    val aliasedType: RawType,
    override val trivia: List<String>
) : Decl

data class EnumeratorDecl(
    val name: String,
    val value: String,
    override val trivia: List<String>
) : Decl

fun parseStructFieldDecl(lines: List<String>, startLine: Int): Pair<List<VarDecl>, Int> {
    val tokenizer = Tokenizer(lines, startLine)
    val decl = parseStructFieldDecl(tokenizer)
    tokenizer.maybeSkipToLineEnd()
    return Pair(decl, tokenizer.curLine)
}

fun parseFunctionDecl(lines: List<String>, startLine: Int): Pair<FunctionDecl, Int> {
    val tokenizer = Tokenizer(lines, startLine)
    val decl = parseFunctionDecl(tokenizer)
    tokenizer.maybeSkipToLineEnd()
    return Pair(decl, tokenizer.curLine)
}

fun parseEnumeratorDecl(lines: List<String>, startLine: Int): Pair<EnumeratorDecl, Int> {
    val tokenizer = Tokenizer(lines, startLine)
    val decl = parseEnumeratorDecl(tokenizer)
    tokenizer.maybeSkipToLineEnd()
    return Pair(decl, tokenizer.curLine)
}

fun parseTypedefDecl(lines: List<String>, startLine: Int): Pair<TypedefDecl, Int> {
    val tokenizer = Tokenizer(lines, startLine)
    val decl = parseTypedefDecl(tokenizer)
    tokenizer.maybeSkipToLineEnd()
    return Pair(decl, tokenizer.curLine)
}

fun parseNonPointerFunctionTypedefDecl(
    lines: List<String>,
    startLine: Int
): Pair<TypedefDecl, Int> {
    val tokenizer = Tokenizer(lines, startLine)
    val decl = parseNonPointerFunctionTypedefDecl(tokenizer)
    tokenizer.maybeSkipToLineEnd()
    return Pair(decl, tokenizer.curLine)
}

fun parseInlineFunctionPointerField(lines: List<String>, startLine: Int): Pair<VarDecl, Int> {
    val tokenizer = Tokenizer(lines, startLine)
    val decl = parseInlineFunctionPointerField(tokenizer)
    tokenizer.maybeSkipToLineEnd()
    return Pair(decl, tokenizer.curLine)
}

sealed interface RawType { val trivia: MutableList<String> }

data class RawIdentifierType(
    val ident: String,
    val unsigned: Boolean,
    val signed: Boolean,
    override val trivia: MutableList<String>
) : RawType

data class RawPointerType(
    var pointee: RawType,
    var const: Boolean,
    override val trivia: MutableList<String>
) : RawType

data class RawArrayType(
    var element: RawType,
    val size: String,
    override val trivia: MutableList<String>
) : RawType

data class RawFunctionType(
    var returnType: RawType,
    val params: List<Pair<String, RawType>>,
    override val trivia: MutableList<String>
) : RawType

fun parseType(s: String): RawType {
    val tokenizer = Tokenizer(s.split("\n"), 0)
    return parseType(tokenizer)
}

/// Only call this function when you're sure that you DO NOT need to retain trivia
fun RawType.toType(): Type = when (this) {
    is RawIdentifierType -> IdentifierType(ident.interned())
    is RawArrayType -> if (size.isBlank()) {
        PointerType(
            pointee = element.toType(),
            isConst = false,
            pointerToOne = false,
            nullable = true
        )
    } else {
        ArrayType(
            element = element.toType(),
            length = CIdentifierExpr(size.interned())
        )
    }
    is RawPointerType -> PointerType(
        pointee = pointee.toType(),
        isConst = const,
        pointerToOne = false,
        nullable = true
    )
    is RawFunctionType -> error("function type cannot be converted to Type")
}
