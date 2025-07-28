package club.doki7.babel.codegen

import club.doki7.babel.ctype.lowerType
import club.doki7.sennaar.registry.IdentifierType
import club.doki7.sennaar.registry.Registry
import club.doki7.babel.util.buildDoc
import club.doki7.babel.util.interfaceName

fun generateFunctionTypedefs(
    registry: Registry,
    codegenOptions: CodegenOptions
) = buildDoc {
    val packageName = codegenOptions.packageName

    +"package $packageName;"
    +""
    imports("java.lang.foreign.*")
    imports("java.lang.invoke.*")
    imports("club.doki7.ffm.annotation.*")
    imports("club.doki7.ffm.NativeLayout")
    imports("org.jetbrains.annotations.NotNull")
    importDatatypes(registry, codegenOptions)
    importBitmasks(registry, codegenOptions)
    importEnumtypes(registry, codegenOptions)
    importHandles(registry, codegenOptions)
    importExtras(codegenOptions)

    +""
    +"public final class ${codegenOptions.functionTypeClassName} {"

    indent {
        val defs = registry.functionTypedefs.values.sortedBy { it.name }

        defs.forEachIndexed { idx, it ->
            val seeLink = codegenOptions.seeLinkProvider(it)
            if (seeLink != null) {
                +"/// @see $seeLink"
            }

            if (it.result is IdentifierType && (it.result as IdentifierType).ident.original == "void") {
                if (it.params.isEmpty()) {
                    +"public static final FunctionDescriptor ${it.name} = FunctionDescriptor.ofVoid();"
                } else {
                    +"public static final FunctionDescriptor ${it.name} = FunctionDescriptor.ofVoid("
                    indent {
                        it.params.forEachIndexed { index, param ->
                            val cType = lowerType(registry, codegenOptions.refRegistries, param.ty)
                            +"${cType.jLayout}${if (index == it.params.size - 1) "" else ","}"
                        }
                    }
                    +");"
                }
            } else {
                +"public static final FunctionDescriptor ${it.name} = FunctionDescriptor.of("
                indent {
                    val retCType = lowerType(registry, codegenOptions.refRegistries, it.result)
                    +"${retCType.jLayout}${if (it.params.isEmpty()) "" else ","}"
                    it.params.forEachIndexed { index, param ->
                        val cType = lowerType(registry, codegenOptions.refRegistries, param.ty)
                        +"${cType.jLayout}${if (index == it.params.size - 1) "" else ","}"
                    }
                }
                +");"
            }
            +""
        }

        // generating function interfaces
        defs.forEach { def ->
            +"@FunctionalInterface"
            "public interface ${def.interfaceName}" {
                val retCType = lowerType(registry, codegenOptions.refRegistries, def.result)
                +"${retCType.jRawType} invoke("
                indent {
                    def.params.forEachIndexed { idx, param ->
                        val last = idx == def.params.size - 1
                        val suffix = if (last) "" else ","
                        val loweredType = lowerType(registry, codegenOptions.refRegistries, param.ty)
                        +"${loweredType.jRawType} p$idx$suffix"
                    }
                }
                +");"

                +""

                defun("static", "MethodHandle", "of", "@NotNull ${def.interfaceName} lambda") {
                    "try" {
                        +"return MethodHandles.lookup().findVirtual(${def.interfaceName}.class, \"invoke\", ${def.name}.toMethodType()).bindTo(lambda);"
                    }
                    "catch (NoSuchMethodException | IllegalAccessException e)" {
                        +"throw new RuntimeException(e);"
                    }
                }

                +""

                defun("static", "MemorySegment", "ofNative", "@NotNull ${def.interfaceName} lambda") {
                    +"return ofNative(Arena.global(), lambda);"
                }

                +""

                defun("static", "MemorySegment", "ofNative", "@NotNull Arena arena", "@NotNull ${def.interfaceName} lambda") {
                    +"return Linker.nativeLinker().upcallStub(of(lambda), ${def.name}, arena);"
                }
            }

            +""
        }

        +prohibitUserConstruct(codegenOptions.functionTypeClassName)
    }
    +"}"
}
