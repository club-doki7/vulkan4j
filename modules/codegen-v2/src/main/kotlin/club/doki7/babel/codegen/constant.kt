package club.doki7.babel.codegen

import club.doki7.babel.ctype.lowerIdentifierType
import club.doki7.babel.ctype.lowerType
import club.doki7.sennaar.registry.Constant
import club.doki7.sennaar.registry.Registry
import club.doki7.babel.util.buildDoc
import club.doki7.babel.util.isDecOrHexNumber
import club.doki7.sennaar.cpl.CBinaryExpr
import club.doki7.sennaar.cpl.CCallExpr
import club.doki7.sennaar.cpl.CCastExpr
import club.doki7.sennaar.cpl.CCharLiteralExpr
import club.doki7.sennaar.cpl.CConditionalExpr
import club.doki7.sennaar.cpl.CExpr
import club.doki7.sennaar.cpl.CFloatLiteralExpr
import club.doki7.sennaar.cpl.CIdentifierExpr
import club.doki7.sennaar.cpl.CIndexExpr
import club.doki7.sennaar.cpl.CIntLiteralExpr
import club.doki7.sennaar.cpl.CMemberExpr
import club.doki7.sennaar.cpl.CPostfixIncDecExpr
import club.doki7.sennaar.cpl.CPtrMemberExpr
import club.doki7.sennaar.cpl.CStringLiteralExpr
import club.doki7.sennaar.cpl.CUnaryExpr
import club.doki7.sennaar.registry.IdentifierType
import club.doki7.sennaar.registry.PointerType

private fun isCStyleNullTerminatedString(constant: Constant): Boolean {
    return constant.ty is PointerType
            && (constant.ty as PointerType).pointee is IdentifierType
            && ((constant.ty as PointerType).pointee as IdentifierType).ident.original == "char"
}

private fun isAliasConstant(expr: CExpr): Boolean = when (expr) {
    is CCharLiteralExpr, is CIntLiteralExpr, is CFloatLiteralExpr, is CStringLiteralExpr -> false
    is CIdentifierExpr -> true
    is CBinaryExpr -> isAliasConstant(expr.lhs) || isAliasConstant(expr.rhs)
    is CCastExpr -> isAliasConstant(expr.expr)
    is CConditionalExpr -> isAliasConstant(expr.cond) || isAliasConstant(expr.then) || isAliasConstant(expr.otherwise)
    is CUnaryExpr -> isAliasConstant(expr.expr)
    is CCallExpr, is CIndexExpr, is CMemberExpr, is CPtrMemberExpr, is CPostfixIncDecExpr -> error("invalid constant expression: $expr")
}

fun generateConstants(
    registry: Registry,
    codegenOptions: CodegenOptions,
    constants: List<Constant> = registry.constants.values.toList()
) = buildDoc {
    +"package ${codegenOptions.packageName};"
    +""

    +"import club.doki7.ffm.annotation.*;"
    if (codegenOptions.extraImport.isNotEmpty()) {
        for (import in codegenOptions.extraImport) {
            +"import $import;"
        }
    }
    +""

    +"public interface ${codegenOptions.constantClassName} {"
    indent {
        val (stringConstants, nonStringConstants) = constants
            .partition { isCStyleNullTerminatedString(it) }

        val (nonAliasConstants, aliasConstants) = nonStringConstants
            .partition { isAliasConstant(it.expr) }

        for (constant in nonAliasConstants.sortedBy { it.name }) {
            val docLink = codegenOptions.seeLinkProvider(constant)
            if (docLink != null) {
                +"/// @see $docLink"
            }

            val ctype = lowerType(registry, codegenOptions.refRegistries, constant.ty)
            +"${ctype.jType} ${constant.name} = ${constant.expr};"
        }

        for (constant in aliasConstants.sortedBy { it.name }) {
            val docLink = codegenOptions.seeLinkProvider(constant)
            if (docLink != null) {
                +"/// @see $docLink"
            }

            val ctype = lowerType(registry, codegenOptions.refRegistries, constant.ty)
            +"${ctype.jType} ${constant.name} = ${constant.expr};"
        }

        if (stringConstants.isNotEmpty() && nonStringConstants.isNotEmpty()) {
            +""
        }

        for (constant in stringConstants.sortedBy { it.name }) {
            val docLink = codegenOptions.seeLinkProvider(constant)
            if (docLink != null) {
                +"/// @see $docLink"
            }

            +"String ${constant.name} = ${constant.expr};"
        }
    }
    +"}"
}
