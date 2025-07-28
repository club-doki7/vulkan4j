package club.doki7.babel.codegen.accessor

import club.doki7.babel.codegen.LayoutField
import club.doki7.babel.codegen.defun
import club.doki7.babel.ctype.CFunctionPointerType
import club.doki7.babel.util.buildDoc
import club.doki7.babel.util.interfaceName

fun generatePFNAccessor(
    className: String,
    type: CFunctionPointerType,
    member: LayoutField.Typed
) = buildDoc {
    defun("public", type.jType, member.name) {
        +"return segment.get(${member.layoutName}, ${member.offsetName});"
    }
    +""

    defun("public", className, member.name, "${type.jType} value") {
        +"segment.set(${member.layoutName}, ${member.offsetName}, value);"
        +"return this;"
    }
    +""

    if (!type.functionTypedef.isNativeAPI) {
        val interfaceName = type.functionTypedef.interfaceName

        defun("public", className, member.name, "@NotNull $interfaceName value") {
            +"return ${member.name}($interfaceName.ofNative(value));"
        }
        +""

        defun("public", className, member.name, "@NotNull Arena arena", "@NotNull $interfaceName value") {
            +"return ${member.name}($interfaceName.ofNative(arena, value));"
        }
        +""
    }

    defun("public", className, member.name, "@Nullable IPointer pointer") {
        +"${member.name}(pointer != null ? pointer.segment() : MemorySegment.NULL);"
        +"return this;"
    }
}
