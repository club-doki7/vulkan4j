package club.doki7.babel.codegen

import club.doki7.sennaar.registry.Registry
import club.doki7.babel.util.DocList
import org.intellij.lang.annotations.Language

internal fun DocList.imports(
    @Language("Java", prefix = "import ", suffix = ";") path: String,
    static: Boolean = false
) {
    +"import ${if (static) "static " else ""}$path;"
}

private fun DocList.importSomething(codegenOptions: CodegenOptions, something: String) {
    imports("${codegenOptions.packageName}.$something.*")
}

internal fun DocList.importDatatypes(registry: Registry, codegenOptions: CodegenOptions) {
    if (registry.structs.isNotEmpty() || registry.unions.isNotEmpty()) {
        importSomething(codegenOptions, "datatype")
    }
}

internal fun DocList.importEnumtypes(registry: Registry, codegenOptions: CodegenOptions) {
    if (registry.enumerations.isNotEmpty()) {
        importSomething(codegenOptions, "enumtype")
    }
}

internal fun DocList.importBitmasks(registry: Registry, codegenOptions: CodegenOptions) {
    if (registry.bitmasks.isNotEmpty()) {
        importSomething(codegenOptions, "bitmask")
    }
}

internal fun DocList.importHandles(registry: Registry, codegenOptions: CodegenOptions) {
    if (registry.opaqueHandleTypedefs.isNotEmpty() || registry.opaqueTypedefs.isNotEmpty()) {
        importSomething(codegenOptions, "handle")
    }
}

internal fun DocList.importFunctionTypedefs(registry: Registry, codegenOptions: CodegenOptions) {
    if (registry.functionTypedefs.isNotEmpty()) {
        importSomething(codegenOptions, codegenOptions.functionTypeClassName)
    }
}

internal fun DocList.importExtras(codegenOptions: CodegenOptions) {
    for (extra in codegenOptions.extraImport) {
        imports(extra)
    }
}

internal fun DocList.defConst(type: String, name: String, value: String) {
    +"public static final $type $name = $value;"
}

internal inline fun DocList.defun(
    @Language("Java", suffix = " void foo() {}") modifiers: String,
    @Language("Java", suffix = " foo() {}") returnType: String,
    @Language("Java", prefix = "void ", suffix = "() {}") name: String,
    @Language("Java", prefix = "void foo(", suffix = ") {}") vararg parameters: String,
    builder: DocList.() -> Unit
) {
    "$modifiers $returnType $name(${parameters.joinToString()})"(builder)
}
