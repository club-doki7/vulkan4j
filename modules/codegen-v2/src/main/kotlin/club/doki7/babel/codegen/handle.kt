package club.doki7.babel.codegen

import club.doki7.sennaar.registry.OpaqueHandleTypedef
import club.doki7.babel.util.Doc
import club.doki7.babel.util.buildDoc

fun generateHandle(
    handle: OpaqueHandleTypedef,
    codegenOptions: CodegenOptions
): Doc = buildDoc {
    val packageName = codegenOptions.packageName
    val className = handle.name.toString()
    val originalTypeName = handle.name.original

    /// region import
    +"package $packageName.handle;"
    +""
    imports("java.lang.foreign.*")
    imports("java.util.Collection")
    imports("java.util.List")
    imports("java.util.Iterator")
    imports("java.util.NoSuchElementException")
    +""
    imports("org.jetbrains.annotations.Nullable")
    imports("org.jetbrains.annotations.NotNull")
    imports("club.doki7.ffm.IPointer")
    imports("club.doki7.ffm.annotation.*")
    +""
    /// endregion import

    val seeLink = codegenOptions.seeLinkProvider(handle)

    if (handle.doc.isNotEmpty()) {
        handle.doc.forEach { +"/// $it" }
    } else if (seeLink != null) {
        +"/// Represents an opaque handle type $seeLink."
    } else {
        +"/// Represents an opaque handle type {@code $originalTypeName}."
    }
    +"///"
    +"/// ## Contracts"
    +"///"
    +"/// The property {@link #segment()} should always be not-null"
    +"/// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to"
    +"/// {@link AddressLayout#byteAlignment()} bytes. To represent null pointer, you may use a Java"
    +"/// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details."
    +"///"
    +"/// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not"
    +"/// perform any runtime check. The constructor can be useful for automatic code generators."

    if (seeLink != null) {
        +"///"
        +"/// @see $seeLink"
    }

    +"@ValueBasedCandidate"
    +"@UnsafeConstructor"
    +"public record $className(@NotNull MemorySegment segment) implements IPointer {"
    indent {
        if (seeLink != null) {
            +"/// Represents a pointer to $seeLink handle(s) in native memory."
        } else {
            +"/// Represents a pointer to {@code $originalTypeName} handle(s) in native memory."
        }
        +"///"
        +"/// ## Contracts"
        +"///"
        +"/// The property {@link #segment()} should always be not-null"
        +"/// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to"
        +"/// {@link AddressLayout#byteAlignment()} bytes. To represent null pointer, you may use a Java"
        +"/// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details."
        +"///"
        +"/// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not"
        +"/// perform any runtime check. The constructor can be useful for automatic code generators."

        +"@ValueBasedCandidate"
        +"@UnsafeConstructor"
        +"public record Ptr(@NotNull MemorySegment segment) implements IPointer, Iterable<$className> {"
        indent {
            defun("public", "long", "size") {
                +"return segment.byteSize() / ValueLayout.ADDRESS.byteSize();"
            }
            +""

            defun("public @Nullable", className, "read") {
                +"MemorySegment s = readRaw();"
                +"if (s.equals(MemorySegment.NULL)) {"
                indent {
                    +"return null;"
                }
                +"}"
                +"return new $className(s);"
            }
            +""

            defun("public", "void", "write", "@Nullable $className value") {
                +"writeRaw(value == null ? MemorySegment.NULL : value.segment());"
            }
            +""

            defun("public @Nullable", className, "read", "long index") {
                +"MemorySegment s = readRaw(index);"
                +"if (s.equals(MemorySegment.NULL)) {"
                indent {
                    +"return null;"
                }
                +"}"
                +"return new $className(s);"
            }
            +""

            defun("public", "void", "write", "long index", "@Nullable $className value") {
                +"writeRaw(index, value == null ? MemorySegment.NULL : value.segment());"
            }
            +""

            defun("public", "void", "write", "@Nullable $className[] values") {
                +"for (int i = 0; i < values.length; i++) {"
                indent {
                    +"write(i, values[i]);"
                }
                +"}"
            }
            +""

            defun("public", "void", "writeV", "@Nullable $className value0", "@Nullable $className ...values") {
                +"write(value0);"
                +"for (int i = 0; i < values.length; i++) {"
                indent {
                    +"write(i + 1, values[i]);"
                }
                +"}"
            }
            +""

            defun("public", "@NotNull MemorySegment", "readRaw") {
                +"return segment.get(ValueLayout.ADDRESS, 0);"
            }
            +""

            defun("public", "@NotNull MemorySegment", "readRaw", "long index") {
                +"return segment.get(ValueLayout.ADDRESS, index * ValueLayout.ADDRESS.byteSize());"
            }
            +""

            defun("public", "void", "writeRaw", "@NotNull MemorySegment value") {
                +"segment.set(ValueLayout.ADDRESS, 0, value);"
            }
            +""

            defun("public", "void", "writeRaw", "long index", "@NotNull MemorySegment value") {
                +"segment.set(ValueLayout.ADDRESS, index * ValueLayout.ADDRESS.byteSize(), value);"
            }
            +""

            +"/// Assume the {@link Ptr} is capable of holding at least {@code newSize} handles,"
            +"/// create a new view {@link Ptr} that uses the same backing storage as this"
            +"/// {@link Ptr}, but with the new size. Since there is actually no way to really check"
            +"/// whether the new size is valid, while buffer overflow is undefined behavior, this method is"
            +"/// marked as {@link Unsafe}."
            +"///"
            +"/// This method could be useful when handling data returned from some C API, where the size of"
            +"/// the data is not known in advance."
            +"///"
            +"/// If the size of the underlying segment is actually known in advance and correctly set, and"
            +"/// you want to create a shrunk view, you may use {@link #slice(long)} (with validation)"
            +"/// instead."
            +"@Unsafe"
            defun("public", "Ptr", "reinterpret", "long newSize") {
                +"return new Ptr(segment.reinterpret(newSize * ValueLayout.ADDRESS.byteSize()));"
            }
            +""

            defun("public", "Ptr", "offset", "long offset") {
                +"return new Ptr(segment.asSlice(offset * ValueLayout.ADDRESS.byteSize()));"
            }
            +""

            +"/// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,"
            +"/// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics"
            +"/// (offset + newSize). Be careful with the difference"
            defun("public", "Ptr", "slice", "long start", "long end") {
                +"return new Ptr(segment.asSlice("
                indent {
                    +"start * ValueLayout.ADDRESS.byteSize(),"
                    +"(end - start) * ValueLayout.ADDRESS.byteSize()"
                }
                +"));"
            }
            +""

            defun("public", "Ptr", "slice", "long end") {
                +"return new Ptr(segment.asSlice(0, end * ValueLayout.ADDRESS.byteSize()));"
            }
            +""

            defun("public static", "Ptr", "allocate", "Arena arena") {
                +"return new Ptr(arena.allocate(ValueLayout.ADDRESS));"
            }
            +""

            defun("public static", "Ptr", "allocate", "Arena arena", "long size") {
                +"return new Ptr(arena.allocate(ValueLayout.ADDRESS, size));"
            }
            +""

            defun("public static", "Ptr", "allocate", "Arena arena", "@Nullable $className @NotNull [] values") {
                +"Ptr ret = allocate(arena, values.length);"
                +"for (int i = 0; i < values.length; i++) {"
                indent {
                    +"ret.write(i, values[i]);"
                }
                +"}"
                +"return ret;"
            }
            +""

            defun("public static", "Ptr", "allocate", "Arena arena", "@NotNull Collection<@Nullable $className> values") {
                +"Ptr ret = allocate(arena, values.size());"
                +"int i = 0;"
                +"for (@Nullable $className value : values) {"
                indent {
                    +"ret.write(i, value);"
                    +"i += 1;"
                }
                +"}"
                +"return ret;"
            }
            +""

            defun(
                "public static",
                "Ptr",
                "allocateV",
                "Arena arena",
                "@Nullable $className value0",
                "@Nullable $className ...values"
            ) {
                +"Ptr ret = allocate(arena, values.length + 1);"
                +"ret.write(0, value0);"
                +"for (int i = 0; i < values.length; i++) {"
                indent {
                    +"ret.write(i + 1, values[i]);"
                }
                +"}"
                +"return ret;"
            }
            +""

            +"@Override"
            defun("public", "@NotNull Iterator<$className>", "iterator") {
                +"return new Iter(this.segment());"
            }
            +""

            +"/// An iterator over the handles."
            +"private static class Iter implements Iterator<$className> {"
            indent {
                +"Iter(@NotNull MemorySegment segment) {"
                indent {
                    +"this.segment = segment;"
                }
                +"}"
                +""

                +"@Override"
                defun("public", "boolean", "hasNext") {
                    +"return segment.byteSize() >= ValueLayout.ADDRESS.byteSize();"
                }
                +""

                +"@Override"
                defun("public", "@Nullable $className", "next") {
                    +"if (!hasNext()) {"
                    indent {
                        +"throw new NoSuchElementException();"
                    }
                    +"}"
                    +"MemorySegment s = segment.get(ValueLayout.ADDRESS, 0);"
                    +"segment = segment.asSlice(ValueLayout.ADDRESS.byteSize());"
                    +"return s.equals(MemorySegment.NULL) ? null : new $className(s);"
                }
                +""

                +"private @NotNull MemorySegment segment;"
            }
            +"}"
        }
        +"}"
    }
    +"}"
}
