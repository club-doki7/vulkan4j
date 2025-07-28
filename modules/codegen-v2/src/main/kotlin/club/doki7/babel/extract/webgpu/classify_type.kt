package club.doki7.babel.extract.webgpu

import club.doki7.sennaar.registry.IdentifierType
import club.doki7.sennaar.registry.Type
import club.doki7.sennaar.registry.PointerType

internal fun classifyType(type: String, pointer: String?): Type {
    val baseType = classifyBaseType(type)
    return if (pointer != null) {
        if (baseType is PointerType) {
            baseType.copy(isConst = pointer == "immutable")
        } else {
            PointerType(
                baseType,
                isConst = pointer == "immutable",
                pointerToOne = false,
                nullable = true
            )
        }
    } else {
        baseType
    }
}

private fun classifyBaseType(type: String): Type {
    return when {
        // object.*
        type.startsWith("object.") -> {
            val innerType = type.removePrefix("object.")
            IdentifierType(renameWGPUType(innerType))
        }
        // bitflag.*
        type.startsWith("bitflag.") ->{
            val innerType = type.removePrefix("bitflag.")
            IdentifierType(renameWGPUType(innerType))
        }
        // struct.*
        type.startsWith("struct.") ->{
            val innerType = type.removePrefix("struct.")
            IdentifierType(renameWGPUType(innerType))
        }
        // enum.*
        type.startsWith("enum.") ->{
            val innerType = type.removePrefix("enum.")
            IdentifierType(renameWGPUType(innerType))
        }
        // callback.
        type.startsWith("callback.") ->{
            val innerType = type.removePrefix("callback.")
            IdentifierType(renameWGPUFunctionPointer(innerType))
        }
        // primitive
        primitiveTypeMap.containsKey(type) ->{
            primitiveTypeMap[type]!!
        }
        // specialTypes
        specialTypeMap.containsKey(type) ->{
            specialTypeMap[type]!!
        }
        // array<...>
        isIDLTypeArray(type) -> error("should not process array type with classifyType")
        else -> {
            error("unable to classify type: $type")
        }
    }
}

val primitiveTypeMap = mapOf(
    // Unsigned integers
    "uint64" to IdentifierType("uint64_t"),
    "uint32" to IdentifierType("uint32_t"),
    "uint16" to IdentifierType("uint16_t"),
    "uint8"  to IdentifierType("uint8_t"),

    // Signed integers
    "int64" to IdentifierType("int64_t"),
    "int32" to IdentifierType("int32_t"),
    "int16" to IdentifierType("int16_t"),
    "int8"  to IdentifierType("int8_t"),

    // Floating-point numbers
    "float64" to IdentifierType("double"),
    "float32" to IdentifierType("float"),

    // Booleans and characters
    "bool" to IdentifierType("WGPUBool"),
    "char" to IdentifierType("char"),

    // Platform-dependent types
    "usize" to IdentifierType("size_t"),
)

val specialTypeMap = mapOf(
    "string_with_default_empty" to IdentifierType("WGPUStringView"),
    "out_string" to IdentifierType("WGPUStringView"),
    "nullable_string" to IdentifierType("WGPUStringView"),

    "float64_supertype" to IdentifierType("double"),
    "nullable_float32" to IdentifierType("float"),

    "c_void" to PointerType(IdentifierType("void"), isConst = false, pointerToOne = false, nullable = true)
)
