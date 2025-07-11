package club.doki7.babel.ctype

import club.doki7.babel.registry.ArrayType
import club.doki7.babel.registry.FunctionTypedef
import club.doki7.babel.registry.Identifier
import club.doki7.babel.registry.IdentifierType
import club.doki7.babel.registry.OpaqueTypedef
import club.doki7.babel.registry.PointerType
import club.doki7.babel.registry.RegistryBase
import club.doki7.babel.registry.Structure
import club.doki7.babel.registry.Type
import kotlin.collections.contains

sealed interface CType {
    val jType: String
    val jRawType: String
    val jLayout: String
    val jLayoutType: String
    val cType: String

    val jDescriptorParamLayout: String get() = jLayout
}

interface ICommentable<SELF: CType> {
    val comment: String?

    fun copyWithComment(comment: String?): SELF
}

data class CVoidType(override val cType: String = "void") : CType {
    override val jType: String = "void"
    override val jRawType: String = "void"
    override val jLayout: String get() = error("should not call `jLayout` on `void`")
    override val jLayoutType: String get() = error("should not call `jLayoutType` on `void`")
}

val voidType = CVoidType()

data class CPointerType(
    val pointee: CType,
    val const: Boolean,
    val pointerToOne: Boolean,
    override val comment: String?,
) : CType, ICommentable<CPointerType> {
    override val jType: String = if (comment != null) {
        """@Pointer(comment="$comment") @NotNull MemorySegment"""
    }
    else {
        """@Pointer(comment="void*") @NotNull MemorySegment"""
    }

    override val jRawType = jType

    override val jLayout: String = if (pointee is CVoidType) {
        "ValueLayout.ADDRESS"
    }
    else {
        """ValueLayout.ADDRESS.withTargetLayout(${pointee.jLayout})"""
    }

    override val jLayoutType: String = "AddressLayout"

    override val cType: String = buildString {
        if (pointee is ICommentable<*> && pointee.comment != null) {
            append(pointee.comment)
        } else {
            append(pointee.cType)
        }
        if (const) {
            append(" const")
        }
        append("*")
    }

    override fun copyWithComment(comment: String?): CPointerType {
        return this.copy(comment = comment)
    }
}

data class CFunctionPointerType(val functionTypedef: FunctionTypedef) : CType {
    override val cType: String = buildString {
        append(functionTypedef.name)
        if (!functionTypedef.isPointer) {
            append("*")
        }
    }

    override val jType: String = """@Pointer(comment="$cType") @NotNull MemorySegment"""
    override val jRawType: String = jType
    override val jLayout: String = "ValueLayout.ADDRESS"
    override val jLayoutType: String = "AddressLayout"
}

data class CHandleType(val name: String) : CType {
    override val jType: String = name
    override val jRawType: String = """@NativeType("$name") MemorySegment"""
    override val jLayout: String = "ValueLayout.ADDRESS"
    override val jLayoutType: String = "AddressLayout"
    override val cType: String = name
}

data class CArrayType(val element: CType, val length: String) : CType {
    override val jType: String get() = error("should not call `jType` on `array`")
    override val jRawType: String get() = error("should not call `jRawType` on `array`")
    override val jLayout: String = "MemoryLayout.sequenceLayout($length, ${element.jLayout})"
    override val jLayoutType: String = "SequenceLayout"
    override val cType: String = "${element.cType}[$length]"

    override val jDescriptorParamLayout: String = "ValueLayout.ADDRESS.withTargetLayout(${element.jLayout})"

    val flattened: CArrayType get() {
        if (element !is CArrayType) {
            return this
        }

        val newElement = element.flattened
        val newLength = "$length * ${element.length}"
        return CArrayType(newElement.element, newLength)
    }
}

sealed interface CNonRefType : CType {
    val jTypeNoAnnotation: String
    val jPtrType: String
    val jPtrTypeNoAnnotation: String
}

sealed interface CFixedSizeType : CNonRefType {
    val byteSize: Int
}

data class CBoolType(
    override val cType: String = "bool",
    override val comment: String? = null
) : CNonRefType, ICommentable<CBoolType> {
    override val jType: String get() = buildString {
        if (comment != null) {
            append("@NativeType(\"$comment\") ")
        }
        append("boolean")
    }
    override val jRawType: String = "bool"
    override val jLayout: String = "ValueLayout.JAVA_BOOLEAN"
    override val jLayoutType: String = "OfBoolean"
    override val jTypeNoAnnotation: String = "boolean"
    override val jPtrType: String get() = buildString {
        if (comment != null) {
            append("@Pointer(comment=\"$comment\") ")
        }
        append("BytePtr")
    }
    override val jPtrTypeNoAnnotation: String = "BytePtr"

    override fun copyWithComment(comment: String?): CBoolType {
        return this.copy(comment = comment)
    }
}

data class CFixedIntType(
    override val cType: String,
    override val byteSize: Int,
    val unsigned: Boolean,
    override val comment: String? = null
) : CFixedSizeType, ICommentable<CFixedIntType> {
    override val jType: String get() = buildString {
        if (comment != null) {
            append("@NativeType(\"$comment\") ")
        }
        if (unsigned) {
            append("@Unsigned ")
        }
        append(jTypeNoAnnotation)
    }

    override val jRawType = jType

    override val jLayout: String get() = when (byteSize) {
        1 -> "ValueLayout.JAVA_BYTE"
        2 -> "ValueLayout.JAVA_SHORT"
        4 -> "ValueLayout.JAVA_INT"
        8 -> "ValueLayout.JAVA_LONG"
        else -> error("unsupported byte size: $byteSize")
    }
    override val jLayoutType: String get() = when (byteSize) {
        1 -> "OfByte"
        2 -> "OfShort"
        4 -> "OfInt"
        8 -> "OfLong"
        else -> error("unsupported byte size: $byteSize")
    }
    override val jTypeNoAnnotation: String get() = when (byteSize) {
        1 -> "byte"
        2 -> "short"
        4 -> "int"
        8 -> "long"
        else -> error("unsupported byte size: $byteSize")
    }
    override val jPtrType: String get() = buildString {
        if (comment != null) {
            append("@Pointer(comment=\"$comment\") ")
        }
        if (unsigned) {
            append("@Unsigned ")
        }
        append(jPtrTypeNoAnnotation)
    }

    override val jPtrTypeNoAnnotation: String get() = when (byteSize) {
        1 -> "BytePtr"
        2 -> "ShortPtr"
        4 -> "IntPtr"
        8 -> "LongPtr"
        else -> error("unsupported byte size: $byteSize")
    }

    override fun copyWithComment(comment: String?): CFixedIntType {
        return this.copy(comment = comment)
    }
}

sealed interface CPlatformDependentIntType : CNonRefType, ICommentable<CPlatformDependentIntType> {
    override val cType: String
    override val jTypeNoAnnotation: String
    override val jLayout: String
    override val jPtrTypeNoAnnotation: String
    override val comment: String?

    override val jLayoutType: String get() = error("should not call `jLayoutType` on `CPlatformDependentIntType`")

    override val jType: String get() = buildString {
        if (comment != null) {
            append("@NativeType(\"$comment\") ")
        }
        append(jTypeNoAnnotation)
    }

    override val jRawType: String get() =
        error("should not call `jRawType` on `CPlatformDependentIntType`")

    override val jPtrType: String get() = buildString {
        if (comment != null) {
            append("@Pointer(comment=\"$comment\") ")
        }
        append(jPtrTypeNoAnnotation)
    }
}

data class CLongType(
    override val cType: String = "long",
    override val jTypeNoAnnotation: String = "long",
    override val jLayout: String = "NativeLayout.C_LONG",
    override val jPtrTypeNoAnnotation: String = "CLongPtr",
    override val comment: String? = null
) : CPlatformDependentIntType {
    override fun copyWithComment(comment: String?): CLongType = copy(comment = comment)
}

data class CSizeType(
    override val cType: String = "size_t",
    override val jTypeNoAnnotation: String = "long",
    override val jLayout: String = "NativeLayout.C_SIZE_T",
    override val jPtrTypeNoAnnotation: String = "PointerPtr",
    override val comment: String? = null
) : CPlatformDependentIntType {
    override fun copyWithComment(comment: String?): CSizeType = copy(comment = comment)
    override val jRawType: String = "@NativeType(\"$cType\") MemorySegment"
}

data class CWCharType(
    override val cType: String = "wchar_t",
    override val jTypeNoAnnotation: String = "int",
    override val jLayout: String = "NativeLayout.WCHAR_T",
    override val jPtrTypeNoAnnotation: String = "WCharPtr",
    override val comment: String? = null
) : CPlatformDependentIntType {
    override fun copyWithComment(comment: String?): CWCharType = copy(comment = comment)
}

data class CFloatType(
    override val byteSize: Int,
    override val comment: String? = null
) : CFixedSizeType, ICommentable<CFloatType> {
    override val jType: String get() = buildString {
        if (comment != null) {
            append("@NativeType(\"$comment\") ")
        }
        append(jTypeNoAnnotation)
    }
    override val jRawType: String = jType
    override val jLayout: String get() = when (byteSize) {
        4 -> "ValueLayout.JAVA_FLOAT"
        8 -> "ValueLayout.JAVA_DOUBLE"
        else -> error("unsupported byte size: $byteSize")
    }
    override val jLayoutType: String = when (byteSize) {
        4 -> "OfFloat"
        8 -> "OfDouble"
        else -> error("unsupported byte size: $byteSize")
    }
    override val cType: String = comment
        ?: when (byteSize) {
            4 -> "float"
            8 -> "double"
            else -> error("unsupported byte size: $byteSize")
        }
    override val jTypeNoAnnotation: String get() = when (byteSize) {
        4 -> "float"
        8 -> "double"
        else -> error("unsupported byte size: $byteSize")
    }
    override val jPtrType: String get() = buildString {
        if (comment != null) {
            append("@Pointer(comment=\"$comment\") ")
        }
        append(jPtrTypeNoAnnotation)
    }
    override val jPtrTypeNoAnnotation: String get() = when (byteSize) {
        4 -> "FloatPtr"
        8 -> "DoublePtr"
        else -> error("unsupported byte size: $byteSize")
    }

    override fun copyWithComment(comment: String?): CFloatType {
        return this.copy(comment = comment)
    }
}

data class CStructType(val name: String, val isUnion: Boolean, val structureRef: Structure): CType {
    override val jType: String = "I$name"
    override val jRawType: String = "@NativeType(\"$name\") MemorySegment"
    override val jLayout: String = "$name.LAYOUT"
    override val jLayoutType: String = if (isUnion) "UnionLayout" else "StructLayout"
    override val cType: String = name
}

data class CEnumType(
    val name: String,
    val isBitmask: Boolean,
    val bitwidth: Int? = null
): CFixedSizeType {
    private val annotationClassName = if (isBitmask) "Bitmask" else "EnumType"

    override val jType: String get() = when (bitwidth) {
        null, 32 -> "@$annotationClassName($name.class) int"
        8 -> "@$annotationClassName($name.class) byte"
        64 -> "@$annotationClassName($name.class) long"
        else -> error("unsupported bitwidth: $bitwidth")
    }

    override val jRawType: String = jType

    override val byteSize: Int get() = when (bitwidth) {
        null, 32 -> 4
        64 -> 8
        else -> error("unsupported bitwidth: $bitwidth")
    }

    override val jLayout: String get() = when (bitwidth) {
        null, 32 -> "ValueLayout.JAVA_INT"
        8 -> "ValueLayout.JAVA_BYTE"
        64 -> "ValueLayout.JAVA_LONG"
        else -> error("unsupported bitwidth: $bitwidth")
    }

    override val jLayoutType: String = when (bitwidth) {
        null, 32 -> "OfInt"
        8 -> "OfByte"
        64 -> "OfLong"
        else -> error("unsupported bitwidth: $bitwidth")
    }

    override val cType: String = "enum $name"

    override val jTypeNoAnnotation: String get() = when (bitwidth) {
        null, 32 -> "int"
        8 -> "byte"
        64 -> "long"
        else -> error("unsupported bitwidth: $bitwidth")
    }

    override val jPtrType: String = when (bitwidth) {
        null, 32 -> "@$annotationClassName($name.class) IntPtr"
        8 -> "@$annotationClassName($name.class) BytePtr"
        64 -> "@$annotationClassName($name.class) LongPtr"
        else -> error("unsupported bitwidth: $bitwidth")
    }

    override val jPtrTypeNoAnnotation: String = when (bitwidth) {
        null, 32 -> "IntPtr"
        8 -> "BytePtr"
        64 -> "LongPtr"
        else -> error("unsupported bitwidth: $bitwidth")
    }
}

private val boolType = CBoolType("bool", "boolean")
private val int8Type = CFixedIntType("int8_t", 1, false)
private val uint8Type = CFixedIntType("uint8_t", 1, true)
private val int16Type = CFixedIntType("int16_t", 2, false)
private val uint16Type = CFixedIntType("uint16_t", 2, true)
private val int32Type = CFixedIntType("int32_t", 4, false)
private val uint32Type = CFixedIntType("uint32_t", 4, true)
private val int64Type = CFixedIntType("int64_t", 8, false)
private val uint64Type = CFixedIntType("uint64_t", 8, true)
private val floatType = CFloatType(4)
private val doubleType = CFloatType(8)

private val cIntType = int32Type
private val cUIntType = uint32Type
private val cLongType = CLongType()
private val cSizeType = CSizeType()
private val cIntPtrType = cSizeType.copyWithComment("intptr_t")
private val wCharType = CWCharType()

private fun pvoidType(comment: String) = CPointerType(voidType, const = false, pointerToOne = false, comment = comment)

private val knownTypes = mapOf(
    // Fundamental types
    "bool" to boolType,
    "void" to voidType,
    "int8_t" to int8Type,
    "uint8_t" to uint8Type,
    "int16_t" to int16Type,
    "uint16_t" to uint16Type,
    "int32_t" to int32Type,
    "uint32_t" to uint32Type,
    "int64_t" to int64Type,
    "uint64_t" to uint64Type,
    "float" to floatType,
    "double" to doubleType,
    "int" to cIntType,
    "unsigned" to cUIntType,
    "unsigned int" to cUIntType,
    "long long" to int64Type,
    "__int64" to int64Type,

    "long" to cLongType,
    "size_t" to cSizeType,
    "intptr_t" to cIntPtrType,
    "wchar_t" to wCharType,

    "char" to int8Type,
    "unsigned char" to uint8Type,
    "short" to int16Type,
    "unsigned short" to uint16Type,

    // libc types
    "timespec" to voidType.copy(cType = "timespec"), // used as a pointer

    // OpenGL base types
    "GLbyte" to int8Type.copyWithComment(comment = "GLbyte"),
    "GLubyte" to uint8Type.copyWithComment(comment = "GLubyte"),
    "GLchar" to int8Type.copyWithComment(comment = "GLchar"),
    "GLuchar" to uint8Type.copyWithComment(comment = "GLuchar"),
    "GLclampf" to floatType.copy(comment = "GLclampf"),
    "GLclampd" to doubleType.copy(comment = "GLclampd"),
    "GLclampx" to int32Type.copyWithComment(comment = "GLclampx"),
    "GLfixed" to int32Type.copyWithComment(comment = "GLfixed"),
    "GLint" to int32Type.copyWithComment(comment = "GLint"),
    "GLint64" to int64Type.copyWithComment(comment = "GLint64"),
    "GLuint" to uint32Type.copyWithComment(comment = "GLuint"),
    "GLuint64" to uint64Type.copyWithComment(comment = "GLuint64"),
    "GLshort" to int16Type.copyWithComment(comment = "GLshort"),
    "GLushort" to uint16Type.copyWithComment(comment = "GLushort"),
    "GLfloat" to floatType.copy(comment = "GLfloat"),
    "GLdouble" to doubleType.copy(comment = "GLdouble"),
    "GLvoid" to voidType.copy(cType = "GLvoid"),
    "GLenum" to int32Type.copyWithComment(comment = "GLenum"),
    "GLsizei" to int32Type.copyWithComment(comment = "GLsizei"),
    "GLsizeiptr" to cSizeType.copyWithComment(comment = "GLsizeiptr"),
    "GLintptr" to cSizeType.copyWithComment(comment = "GLintptr"),
    "GLbitfield" to uint32Type.copyWithComment(comment = "GLbitfield"),
    "GLboolean" to uint8Type.copyWithComment(comment = "GLboolean"),

    // Vulkan base types
    "VkSampleMask" to uint32Type.copyWithComment(comment = "VkSampleMask"),
    "VkBool32" to uint32Type.copyWithComment(comment = "VkBool32"),
    "VkFlags" to uint32Type.copyWithComment(comment = "VkFlags"),
    "VkFlags64" to uint64Type.copyWithComment(comment = "VkFlags64"),
    "VkDeviceSize" to uint64Type.copyWithComment(comment = "VkDeviceSize"),
    "VkDeviceAddress" to uint64Type.copyWithComment(comment = "VkDeviceAddress"),
    "VkRemoteAddressNV" to pvoidType("VkRemoteAddressNV"),

    // Android
    "ANativeWindow" to pvoidType("ANativeWindow"),
    "AHardwareBuffer" to pvoidType("AHardwareBuffer"),

    // DirectFB
    "IDirectFB" to pvoidType("IDirectFB"),
    "IDirectFBSurface" to pvoidType("IDirectFBSurface"),

    // iOS or macOS
    "id" to pvoidType("id"),
    "CAMetalLayer" to pvoidType("CAMetalLayer"),
    "GgpFrameToken" to uint32Type.copyWithComment(comment = "GgpFrameToken"),
    "GgpStreamDescriptor" to uint32Type.copyWithComment(comment = "GgpStreamDescriptor"),
    "IOSurfaceRef" to pvoidType("IOSurfaceRef"),
    "MTLBuffer_id" to pvoidType("MTLBuffer_id"),
    "MTLCommandQueue_id" to pvoidType("MTLCommandQueue_id"),
    "MTLDevice_id" to pvoidType("MTLDevice_id"),
    "MTLSharedEvent_id" to pvoidType("MTLSharedEvent_id"),
    "MTLTexture_id" to pvoidType("MTLTexture_id"),
    "CGDirectDisplayID" to uint32Type.copyWithComment(comment = "CGDirectDisplayID"),

    // QNX
    "_screen_buffer" to pvoidType("_screen_buffer"),
    "_screen_context" to pvoidType("_screen_context"),
    "_screen_window" to pvoidType("_screen_window"),

    // Wayland
    "wl_display" to pvoidType("wl_display"),
    "wl_surface" to pvoidType("wl_surface"),
    "wl_output" to voidType.copy(cType = "wl_output"),

    // Windows
    "DWORD" to uint32Type.copyWithComment(comment = "DWORD"),
    "LONG" to int32Type.copyWithComment("LONG"),
    "HANDLE" to pvoidType("HANDLE"),
    "HINSTANCE" to pvoidType("HINSTANCE"),
    "HMONITOR" to pvoidType("HMONITOR"),
    "HWND" to pvoidType("HWND"),
    "HDC" to pvoidType("HDC"),
    "LARGE_INTEGER" to voidType, // used as a pointer
    "LPCWSTR" to CPointerType(uint16Type, const = true, pointerToOne = false, comment = "LPCWSTR"),
    "HGLRC" to pvoidType("HGLRC"),
    "SECURITY_ATTRIBUTES" to voidType.copy(cType = "SECURITY_ATTRIBUTES"),

    // X11 Xlib
    "Display" to pvoidType("Display"),
    "RROutput" to cLongType.copyWithComment(comment = "RROutput"),
    "RRCrtc" to cLongType.copyWithComment(comment = "RRCrtc"),
    "VisualID" to cLongType.copyWithComment(comment = "VisualID"),
    "Window" to cLongType.copyWithComment(comment = "Window"),
    "GLXFBConfig" to pvoidType("GLXFBConfig"),
    "GLXDrawable" to cLongType.copyWithComment("GLXDrawable"),
    "GLXContext" to pvoidType("GLXContext"),
    "GLXWindow" to cLongType.copyWithComment(comment = "GLXWindow"),
    "XEvent" to voidType.copy(cType = "XEvent"),

    // X11 XCB
    "xcb_connection_t" to voidType.copy(cType = "xcb_connection_t"),
    "xcb_visualid_t" to uint32Type.copyWithComment(comment = "xcb_visualid_t"),
    "xcb_window_t" to uint32Type.copyWithComment(comment = "xcb_window_t"),
    "xcb_handle_t" to uint32Type.copyWithComment(comment = "xcb_handle_t"),
    "xcb_glx_fbconfig_t" to uint32Type.copyWithComment("xcb_glx_fbconfig_t"),
    "xcb_glx_drawable_t" to uint32Type.copyWithComment("xcb_glx_drawable_t"),
    "xcb_glx_context_t" to uint32Type.copyWithComment("xcb_glx_context_t"),

    // EGL
    "EGLDisplay" to pvoidType("EGLDisplay"),
    "EGLContext" to pvoidType("EGLContext"),
    "EGLSurface" to pvoidType("EGLSurface"),
    "EGLConfig" to pvoidType("EGLConfig"),
    "EGLenum" to uint32Type.copyWithComment("EGLenum"),

    // MESA
    "OSMesaContext" to pvoidType("OSMesaContext"),

    // NvSciBuf / NvSciSync
    "NvSciBufAttrList" to pvoidType("NvSciBufAttrList"),
    "NvSciBufObj" to pvoidType("NvSciBufObj"),
    "NvSciSyncAttrList" to pvoidType("NvSciSyncAttrList"),
    "NvSciSyncObj" to pvoidType("NvSciSyncObj"),

    // FUCHSIA
    "zx_handle_t" to uint32Type.copyWithComment(comment = "zx_handle_t"),

    // Microsoft Windows COM and Direct3D
    "IUnknown" to pvoidType("IUnknown"),
    "ID3D11Device" to pvoidType("ID3D11Device"),
    "ID3D11Texture2D" to pvoidType("ID3D11Texture2D"),
    "ID3D12CommandQueue" to pvoidType("ID3D12CommandQueue"),
    "ID3D12Device" to pvoidType("ID3D12Device"),
    "ID3D12Resource" to pvoidType("ID3D12Resource"),
    "D3D_FEATURE_LEVEL" to uint32Type.copyWithComment("D3D_FEATURE_LEVEL"),

    // JNI
    "jobject" to pvoidType("jobject")
)

fun lowerType(
    registry: RegistryBase,
    refRegistries: List<RegistryBase>,
    type: Type,
    importEnumerations: MutableSet<Pair<Identifier, Identifier>>? = null
): CType {
    return when(type) {
        is ArrayType -> {
            if (!type.length.value.isNumeric()) {
                if (!registry.constants.contains(type.length)
                    && !registry.enumConstantToEnumerationLookupAccel.contains(type.length.original)
                    && !refRegistries.any {
                        it.constants.contains(type.length)
                        || it.enumConstantToEnumerationLookupAccel.contains(type.length.original)
                    }) {
                    error("array type referred to an unknown constant ${type.length}")
                }

                if (registry.enumConstantToEnumerationLookupAccel.contains(type.length.original)) {
                    val enum = registry.enumConstantToEnumerationLookupAccel[type.length.original]!!
                    if (importEnumerations == null) {
                        error("array type referred to an enumeration constant ${type.length}, but no importEnumerations set, caller will be unable to set the import")
                    }
                    importEnumerations.add(Pair(enum, type.length))
                }

                refRegistries.forEach {
                    if (it.enumConstantToEnumerationLookupAccel.contains(type.length.original)) {
                        val enum = it.enumConstantToEnumerationLookupAccel[type.length.original]!!
                        if (importEnumerations == null) {
                            error("array type referred to an enumeration constant ${type.length}, but no importEnumerations set, caller will be unable to set the import")
                        }
                        importEnumerations.add(Pair(enum, type.length))
                    }
                }
            }

            val elementType = lowerType(registry, refRegistries, type.element)
            CArrayType(elementType, type.length.value)
        }
        is PointerType -> {
            if (type.pointee is IdentifierType) {
                val functionTypedef = lookupFunctionTypedef(registry, refRegistries, type.pointee)
                if (functionTypedef != null && !functionTypedef.isPointer) {
                    return CPointerType(voidType, false, pointerToOne = true, comment="${type.pointee.ident.value}*")
                }

                val opaqueTypedef = lookupOpaqueTypedef(registry, refRegistries, type.pointee)
                if (opaqueTypedef != null) {
                    return if (opaqueTypedef.isHandle) {
                        CHandleType(opaqueTypedef.name.value)
                    } else {
                        CPointerType(
                            pointee = CVoidType(),
                            const = true,
                            pointerToOne = true,
                            comment = "${type.pointee.ident.original}*"
                        )
                    }
                }
            }

            val pointee = lowerType(registry, refRegistries, type.pointee)
            CPointerType(pointee, type.const, type.pointerToOne, comment=null)
        }
        is IdentifierType -> lowerIdentifierType(registry, refRegistries, type)
    }
}

fun lookupOpaqueTypedef(
    registry: RegistryBase,
    refRegistries: List<RegistryBase>,
    type: IdentifierType
): OpaqueTypedef? {
    if (registry.opaqueTypedefs.contains(type.ident)) {
        return registry.opaqueTypedefs[type.ident]!!
    }

    for (refRegistry in refRegistries) {
        if (refRegistry.opaqueTypedefs.contains(type.ident)) {
            return refRegistry.opaqueTypedefs[type.ident]!!
        }
    }

    return null
}

fun lookupFunctionTypedef(
    registry: RegistryBase,
    refRegistries: List<RegistryBase>,
    type: IdentifierType
): FunctionTypedef? {
    if (registry.functionTypedefs.contains(type.ident)) {
        return registry.functionTypedefs[type.ident]
    }

    for (refRegistry in refRegistries) {
        if (refRegistry.functionTypedefs.contains(type.ident)) {
            return refRegistry.functionTypedefs[type.ident]
        }
    }

    return null
}

fun lowerIdentifierType(
    registry: RegistryBase,
    refRegistries: List<RegistryBase>,
    type: IdentifierType
): CType {
    val lookupResult = identifierTypeLookup(registry, refRegistries, type)
    if (lookupResult != null) {
        return lookupResult
    }

    for (refRegistry in refRegistries) {
        val lookupResult = identifierTypeLookup(refRegistry, refRegistries, type)
        if (lookupResult != null) {
            return lookupResult
        }
    }

    return if (knownTypes.containsKey(type.ident.value)) {
        knownTypes[type.ident.value]!!
    } else {
        error("unknown type ${type.ident.value}")
    }
}

fun identifierTypeLookup(registry: RegistryBase, refRegistries: List<RegistryBase>, type: IdentifierType) =
    if (registry.structures.contains(type.ident)) {
        CStructType(type.ident.value, false, registry.structures[type.ident]!!)
    }
    else if (registry.unions.contains(type.ident)) {
        CStructType(type.ident.value, true, registry.unions[type.ident]!!)
    }
    else if (registry.enumerations.contains(type.ident)) {
        CEnumType(type.ident.value, isBitmask = false)
    }
    else if (registry.bitmasks.contains(type.ident)) {
        CEnumType(type.ident.value, isBitmask = true, bitwidth=registry.bitmasks[type.ident]!!.bitwidth)
    }
    else if (registry.opaqueHandleTypedefs.contains(type.ident)) {
        CHandleType(type.ident.value)
    }
    else if (registry.functionTypedefs.contains(type.ident)) {
        val functionTypedef = registry.functionTypedefs[type.ident]!!
        if (!functionTypedef.isPointer) {
            error("function typedef ${type.ident.value} is not a pointer type, should not be used individually")
        }
        CFunctionPointerType(functionTypedef)
    }
    else if (registry.aliases.contains(type.ident)) {
        val alias = registry.aliases[type.ident]!!
        val ret = lowerType(registry, refRegistries, alias.type)
        if (ret is ICommentable<*>) {
            ret.copyWithComment(type.ident.original)
        } else {
            ret
        }
    }
    else if (knownTypes.containsKey(type.ident.value)) {
        knownTypes[type.ident.value]!!
    } else {
        null
    }

private fun String.isNumeric() = all { it.isDigit() }
