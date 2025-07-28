package club.doki7.babel.codegen

import club.doki7.babel.ctype.CArrayType
import club.doki7.babel.ctype.CFunctionPointerType
import club.doki7.babel.ctype.CHandleType
import club.doki7.babel.ctype.CLongType
import club.doki7.babel.ctype.CNonRefType
import club.doki7.babel.ctype.CPlatformDependentIntType
import club.doki7.babel.ctype.CPointerType
import club.doki7.babel.ctype.CSizeType
import club.doki7.babel.ctype.CStructType
import club.doki7.babel.ctype.CType
import club.doki7.babel.ctype.CVoidType
import club.doki7.babel.ctype.CWCharType
import club.doki7.babel.ctype.lowerType
import club.doki7.sennaar.registry.Command
import club.doki7.sennaar.registry.Param
import club.doki7.sennaar.registry.IRegistry
import club.doki7.babel.util.Doc
import club.doki7.babel.util.buildDoc
import club.doki7.babel.util.interfaceName

fun generateCommandFile(
    registry: IRegistry,
    className: String,
    commands: List<Command>,
    codegenOptions: CodegenOptions,
    implConstantClass: Boolean,
    subpackage: String?,
    javaDoc: Doc? = null,
) = buildDoc {
    val packageName = codegenOptions.packageName

    // region imports
    if (subpackage != null) {
        +"package $packageName.$subpackage;"
    } else {
        +"package $packageName;"
    }
    +""
    imports("java.lang.foreign.*")
    imports("java.lang.invoke.MethodHandle")
    imports("java.util.Objects")
    +""
    imports("org.jetbrains.annotations.Nullable")
    imports("org.jetbrains.annotations.NotNull")
    imports("club.doki7.ffm.NativeLayout")
    imports("club.doki7.ffm.RawFunctionLoader")
    imports("club.doki7.ffm.annotation.*")
    imports("club.doki7.ffm.ptr.*")
    if (registry.bitmasks.isNotEmpty()) {
        imports("$packageName.bitmask.*")
    }
    if (registry.structs.isNotEmpty()) {
        imports("$packageName.datatype.*")
    }
    if (registry.enumerations.isNotEmpty()) {
        imports("$packageName.enumtype.*")
    }
    if (registry.opaqueHandleTypedefs.isNotEmpty() || registry.opaqueTypedefs.isNotEmpty()) {
        imports("$packageName.handle.*")
    }
    if (registry.functionTypedefs.isNotEmpty()) {
        imports("$packageName.${codegenOptions.functionTypeClassName}.*", static = true)
    }
    if (implConstantClass && subpackage != null) {
        imports("$packageName.${codegenOptions.constantClassName}")
    }

    codegenOptions.extraImport.forEach {
        imports(it)
    }
    +""
    // endregion

    if (javaDoc != null) {
        +javaDoc
    }
    if (implConstantClass) {
        +"public final class $className implements ${codegenOptions.constantClassName} {"
    } else {
        +"public final class $className {"
    }
    indent {
        val locallySuppliedCommands = commands.map { it.name.original }.toSet()
        val loweredCommand = commands.map { lowerCommand(it, registry, codegenOptions) }.toList()

        +"public $className(RawFunctionLoader loader) {"
        indent {
            loweredCommand.forEach {
                val funcOriginalName = it.command.name.original
                val descriptorFuncName = if (it.command.aliasTo != null && locallySuppliedCommands.contains(it.command.aliasTo!!.original)) {
                    it.command.aliasTo!!.original
                } else {
                    funcOriginalName
                }

                val segmentName = "SEGMENT$$funcOriginalName"
                val handleName = "HANDLE$$funcOriginalName"
                val descriptorName = "Descriptors.DESCRIPTOR$$descriptorFuncName"

                +"$segmentName = loader.apply(\"$funcOriginalName\");"
                +"$handleName = RawFunctionLoader.link($segmentName, $descriptorName);"
            }
        }
        +"}"
        +""

        +"// region command wrappers"
        +""
        loweredCommand.forEachIndexed { idx, it ->
            +generateCommandWrapper(it, codegenOptions)
            if (idx != loweredCommand.size - 1) {
                +""
            }
        }
        +"// endregion"
        +""

        +"// region segments and handles"
        loweredCommand.forEach {
            +"public final @Nullable MemorySegment SEGMENT$${it.command.name.original};"
        }

        loweredCommand.forEach {
            +"public final @Nullable MethodHandle HANDLE$${it.command.name.original};"
        }
        +"// endregion"
        +""

        +"public static final class Descriptors {"
        indent {
            loweredCommand
                .filter { it.command.aliasTo == null || !locallySuppliedCommands.contains(it.command.aliasTo!!.original) }
                .forEach {
                    +generateFunctionDescriptor(it)
                    +""
                }
            +prohibitUserConstruct("Descriptors")
        }
        +"}"
    }
    +"}"
}

data class LoweredCommand(
    val paramCType: List<CType>,
    val result: CType,
    val command: Command
)

private fun arrayToPointerDecay(type: CType): CType {
    return if (type is CArrayType) {
        CPointerType(type.element, const=false, pointerToOne=false, comment="${type.element.cType}[]")
    } else type
}

private fun lowerCommand(
    command: Command,
    registry: IRegistry,
    codegenOptions: CodegenOptions
) = LoweredCommand(
    paramCType = command.params.map {
        arrayToPointerDecay(lowerType(registry, codegenOptions.refRegistries, it.ty))
    }.toList(),
    result = lowerType(registry, codegenOptions.refRegistries, command.result),
    command = command
)

private fun generateCommandWrapper(
    loweredCommand: LoweredCommand,
    codegenOptions: CodegenOptions
) = buildDoc {
    val hasPlatformDependentReturnType =
        loweredCommand.result is CPlatformDependentIntType && loweredCommand.result !is CSizeType
    val hasPlatformDependentParam = loweredCommand.paramCType.any {
        it is CPlatformDependentIntType && it !is CSizeType
    }
    val hasFunctionPointerParam = loweredCommand.paramCType.any {
        it is CFunctionPointerType && !it.functionTypedef.isNativeAPI
    }

    val paramIOTypes = mutableListOf<String>()
    val callArgs = mutableListOf<String>()

    for ((index, paramCType) in loweredCommand.paramCType.withIndex()) {
        val param = loweredCommand.command.params[index]
        val type = generateInputOutputType(paramCType, param.optional)

        paramIOTypes.add(type)
        callArgs.add(generateInputConvert(paramCType, param))
    }

    val retIOType = generateInputOutputType(loweredCommand.result, true)

    val callArgsDoc = buildDoc {
        callArgs.forEachIndexed { idx, it -> +if (idx != callArgs.size - 1) "$it, " else it }
    }

    loweredCommand.command.doc.forEach { +"/// $it" }

    val seeLink = codegenOptions.seeLinkProvider(loweredCommand.command)
    if (seeLink != null) {
        +"/// @see $seeLink"
    }

    if (paramIOTypes.isNotEmpty()) {
        +"public $retIOType ${loweredCommand.command.name}("
        indent {
            if (loweredCommand.result is CStructType) {
                +"SegmentAllocator allocator,"
            }
            for ((index, param) in loweredCommand.command.params.withIndex()) {
                val paramIOType = paramIOTypes[index]
                val comma = if (index != paramIOTypes.size - 1) "," else ""
                +"$paramIOType ${param.name}${comma}"
            }
        }
        +") {"
    } else {
        +"public $retIOType ${loweredCommand.command.name}() {"
    }

    indent {
        +"MethodHandle hFunction = Objects.requireNonNull(HANDLE$${loweredCommand.command.name.original});"
        +"try {"
        indent {
            val invokeMethod = if (hasPlatformDependentReturnType || hasPlatformDependentParam) {
                "invoke"
            } else {
                "invokeExact"
            }

            if (loweredCommand.result is CVoidType) {
                +"hFunction.${invokeMethod}("
                indent { +callArgsDoc }
                +");"
            } else {
                val (beforeCall, afterCall, nextStmt) = generateResultConvert(loweredCommand.result)
                +"${beforeCall}hFunction.${invokeMethod}("
                indent {
                    if (loweredCommand.result is CStructType) {
                        +"allocator,"
                    }
                    +callArgsDoc
                }
                +")$afterCall;"
                if (nextStmt != null) {
                    +nextStmt
                }
            }
        }
        +"} catch (Throwable e) {"
        indent {
            +"throw new RuntimeException(e);"
        }
        +"}"
        indent {

        }
    }

    +"}"

    if (!hasFunctionPointerParam) {
        return@buildDoc
    }

    +""

    val paramsDoc = buildDoc {
        if (loweredCommand.result is CStructType) {
            +"SegmentAllocator allocator,"
        }
        for ((index, param) in loweredCommand.command.params.withIndex()) {
            val paramCType = loweredCommand.paramCType[index]
            val paramIOType = paramIOTypes[index]
            val comma = if (index != paramIOTypes.size - 1) "," else ""

            if (paramCType is CFunctionPointerType && !paramCType.functionTypedef.isNativeAPI) {
                +"${paramCType.functionTypedef.interfaceName} ${param.name}${comma}"
            } else {
                +"$paramIOType ${param.name}${comma}"
            }
        }
    }

    +"public $retIOType ${loweredCommand.command.name}("
    indent {
        +"Arena arena,"
        +paramsDoc
    }
    +") {"
    indent {
        if (loweredCommand.result is CVoidType) {
            +"${loweredCommand.command.name}("
        } else {
            +"return ${loweredCommand.command.name}("
        }

        indent {
            if (loweredCommand.result is CStructType) {
                +"allocator,"
            }

            for ((index, param) in loweredCommand.command.params.withIndex()) {
                val paramCType = loweredCommand.paramCType[index]
                val comma = if (index != loweredCommand.command.params.size - 1) "," else ""
                if (paramCType is CFunctionPointerType && !paramCType.functionTypedef.isNativeAPI) {
                    +"${paramCType.functionTypedef.interfaceName}.ofNative(arena, ${param.name})${comma}"
                } else {
                    +"${param.name}${comma}"
                }
            }
        }
        +");"
    }
    +"}"

    +""

    +"public $retIOType ${loweredCommand.command.name}("
    indent {
        +paramsDoc
    }
    +") {"
    indent {
        if (loweredCommand.result is CVoidType) {
            +"${loweredCommand.command.name}("
        } else {
            +"return ${loweredCommand.command.name}("
        }

        indent {
            +"Arena.global(),"
            if (loweredCommand.result is CStructType) {
                +"allocator,"
            }

            for ((index, param) in loweredCommand.command.params.withIndex()) {
                val comma = if (index != loweredCommand.command.params.size - 1) "," else ""
                +"${param.name}${comma}"
            }
        }
        +");"
    }
    +"}"
}

private fun generateFunctionDescriptor(loweredCommand: LoweredCommand) = buildDoc {
    val descriptorName = "DESCRIPTOR$${loweredCommand.command.name.original}"

    if (loweredCommand.result is CVoidType) {
        +"public static final FunctionDescriptor $descriptorName = FunctionDescriptor.ofVoid("
    } else {
        +"public static final FunctionDescriptor $descriptorName = FunctionDescriptor.of("
    }
    indent {
        if (loweredCommand.result !is CVoidType) {
            val hasComma = loweredCommand.paramCType.isNotEmpty()
            +"${loweredCommand.result.jLayout}${if (hasComma) "," else ""}"
        }

        loweredCommand.paramCType.forEachIndexed { idx, it ->
            if (idx != loweredCommand.paramCType.size - 1) {
                +"${it.jLayout}, "
            } else {
                +it.jLayout
            }
        }
    }
    +");"
}

private fun generateInputOutputType(type: CType, optional: Boolean): String {
    val nullablePrefix = if (optional) "@Nullable " else ""

    return when (type) {
        is CVoidType -> "void"
        is CPointerType -> when (type.pointee) {
            is CNonRefType -> "${nullablePrefix}${type.pointee.jPtrType}"
            is CStructType -> if (type.pointerToOne) {
                "$nullablePrefix@Pointer ${type.pointee.name}"
            } else {
                "$nullablePrefix@Pointer ${type.pointee.jType}"
            }
            is CHandleType -> "${nullablePrefix}@Pointer ${type.pointee.name}.Ptr"
            is CPointerType -> "${nullablePrefix}PointerPtr"
            is CFunctionPointerType -> "${nullablePrefix}@Pointer(comment=\"${type.cType}\") PointerPtr"
            is CVoidType -> type.jType
            else -> error("unsupported pointer type: $type")
        }
        is CFunctionPointerType -> type.jType
        is CHandleType -> "${nullablePrefix}${type.name}"
        is CArrayType -> {
            val flattened = type.flattened
            when (flattened.element) {
                is CNonRefType -> flattened.element.jPtrType
                is CStructType -> flattened.element.jType
                else -> error("unsupported array type: $type")
            }
        }
        is CStructType -> type.name
        is CNonRefType -> type.jType
    }
}

private fun generateInputConvert(type: CType, param: Param) = when (type) {
    is CPointerType -> when (type.pointee) {
        is CNonRefType, is CStructType, is CHandleType, is CPointerType, is CFunctionPointerType -> if (param.optional) {
            "(MemorySegment) (${param.name} != null ? ${param.name}.segment() : MemorySegment.NULL)"
        }
        else {
            "${param.name}.segment()"
        }
        is CVoidType -> param.name.toString()
        else -> throw Exception("unsupported pointer type: $type")
    }
    is CHandleType -> if (param.optional) {
        "(MemorySegment) (${param.name} != null ? ${param.name}.segment() : MemorySegment.NULL)"
    } else {
        "${param.name}.segment()"
    }
    is CStructType -> "${param.name}.segment()"
    is CArrayType -> {
        val flattened = type.flattened
        when (flattened.element) {
            is CNonRefType -> "${param.name}.segment()"
            is CStructType, is CHandleType -> "(${param.name} != null && ${param.name}.length != 0) ? ${param.name}.segment() : MemorySegment.NULL"
            else -> throw Exception("unsupported array type: $type")
        }
    }
    is CPlatformDependentIntType -> when (type) {
        is CSizeType -> {
            "MemorySegment.ofAddress(${param.name})"
        }
        is CWCharType -> {
            "(NativeLayout.WCHAR_SIZE == 2) ? ((Object)(short) ${param.name}) : ((Object)(int) ${param.name})"
        }
        is CLongType -> {
            "(NativeLayout.C_LONG_SIZE == 4) ? ((Object)(int) ${param.name}) : ((Object)(long) ${param.name})"
        }
    }
    is CNonRefType, is CFunctionPointerType -> param.name.toString()
    is CVoidType -> error("void type cannot be used as a parameter type")
}

private fun generateResultConvert(retType: CType): Triple<String, String, String?> = when (retType) {
    is CPointerType -> when (retType.pointee) {
        is CNonRefType -> Triple(
            "MemorySegment s = (MemorySegment) ",
            "",
            "return s.equals(MemorySegment.NULL) ? null : new ${retType.pointee.jPtrTypeNoAnnotation}(s);"
        )
        is CStructType -> Triple(
            "MemorySegment s = (MemorySegment) ",
            "",
            "return s.equals(MemorySegment.NULL) ? null : new ${retType.pointee.name}(s);"
        )
        is CHandleType -> Triple(
            "MemorySegment s = (MemorySegment) ",
            "",
            "return s.equals(MemorySegment.NULL) ? null : new ${retType.pointee.name}.Ptr(s);"
        )
        is CPointerType, is CFunctionPointerType -> Triple(
            "MemorySegment s = (MemorySegment) ",
            "",
            "return s.equals(MemorySegment.NULL) ? null : new PointerPtr(s);"
        )
        is CVoidType -> Triple(
            "return (MemorySegment) ",
            "",
            null
        )
        else -> error("unsupported pointer type: $retType")
    }
    is CHandleType -> Triple(
        "MemorySegment s = (MemorySegment) ",
        "",
        "return s.equals(MemorySegment.NULL) ? null : new ${retType.name}(s);"
    )
    is CPlatformDependentIntType -> when (retType) {
        is CSizeType -> {
            Triple(
                "MemorySegment s = (MemorySegment) ",
                "",
                "return s.address();"
            )
        }
        is CWCharType -> {
            Triple(
                "Object t = ",
                "",
                "return (NativeLayout.WCHAR_SIZE == 2) ? (short) t : (int) t;"
            )
        }
        is CLongType -> {
            Triple(
                "Object t = ",
                "",
                "return (NativeLayout.C_LONG_SIZE == 4) ? (int) t : (long) t;"
            )
        }
    }
    is CNonRefType -> Triple(
        "return (${retType.jTypeNoAnnotation}) ",
        "",
        null
    )
    is CStructType -> Triple(
        "return new ${retType.name}((MemorySegment) ",
        ")",
        null
    )
    is CFunctionPointerType -> Triple(
        "return (MemorySegment) ",
        "",
        null
    )
    is CArrayType -> error("array type cannot be used as a return type")
    is CVoidType -> error("void return type should not be handed by `generateResultConvert` function")
}
