package club.doki7.vulkan.datatype;

import java.lang.foreign.*;
import static java.lang.foreign.ValueLayout.*;
import java.util.List;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.Consumer;

import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.NotNull;
import club.doki7.ffm.IPointer;
import club.doki7.ffm.NativeLayout;
import club.doki7.ffm.annotation.*;
import club.doki7.ffm.ptr.*;
import club.doki7.vulkan.bitmask.*;
import club.doki7.vulkan.handle.*;
import club.doki7.vulkan.enumtype.*;
import static club.doki7.vulkan.VkConstants.*;
import club.doki7.vulkan.VkFunctionTypes.*;

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPerformanceValueDataINTEL.html"><code>VkPerformanceValueDataINTEL</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef union VkPerformanceValueDataINTEL {
///     uint32_t value32; // @link substring="value32" target="#value32"
///     uint64_t value64; // @link substring="value64" target="#value64"
///     float valueFloat; // @link substring="valueFloat" target="#valueFloat"
///     VkBool32 valueBool; // @link substring="valueBool" target="#valueBool"
///     char const* valueString; // @link substring="valueString" target="#valueString"
/// } VkPerformanceValueDataINTEL;
/// }
///
/// ## Contracts
///
/// The property {@link #segment()} should always be not-null
/// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
/// {@code LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
/// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
///
/// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
/// perform any runtime check. The constructor can be useful for automatic code generators.
///
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPerformanceValueDataINTEL.html"><code>VkPerformanceValueDataINTEL</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkPerformanceValueDataINTEL(@NotNull MemorySegment segment) implements IVkPerformanceValueDataINTEL {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPerformanceValueDataINTEL.html"><code>VkPerformanceValueDataINTEL</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkPerformanceValueDataINTEL}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkPerformanceValueDataINTEL to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkPerformanceValueDataINTEL.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkPerformanceValueDataINTEL, Iterable<VkPerformanceValueDataINTEL> {
        public long size() {
            return segment.byteSize() / VkPerformanceValueDataINTEL.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkPerformanceValueDataINTEL at(long index) {
            return new VkPerformanceValueDataINTEL(segment.asSlice(index * VkPerformanceValueDataINTEL.BYTES, VkPerformanceValueDataINTEL.BYTES));
        }

        public VkPerformanceValueDataINTEL.Ptr at(long index, @NotNull Consumer<@NotNull VkPerformanceValueDataINTEL> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkPerformanceValueDataINTEL value) {
            MemorySegment s = segment.asSlice(index * VkPerformanceValueDataINTEL.BYTES, VkPerformanceValueDataINTEL.BYTES);
            s.copyFrom(value.segment);
        }

        /// Assume the {@link Ptr} is capable of holding at least {@code newSize} structures,
        /// create a new view {@link Ptr} that uses the same backing storage as this
        /// {@link Ptr}, but with the new size. Since there is actually no way to really check
        /// whether the new size is valid, while buffer overflow is undefined behavior, this method is
        /// marked as {@link Unsafe}.
        ///
        /// This method could be useful when handling data returned from some C API, where the size of
        /// the data is not known in advance.
        ///
        /// If the size of the underlying segment is actually known in advance and correctly set, and
        /// you want to create a shrunk view, you may use {@link #slice(long)} (with validation)
        /// instead.
        @Unsafe
        public @NotNull Ptr reinterpret(long newSize) {
            return new Ptr(segment.reinterpret(newSize * VkPerformanceValueDataINTEL.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkPerformanceValueDataINTEL.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkPerformanceValueDataINTEL.BYTES,
                (end - start) * VkPerformanceValueDataINTEL.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkPerformanceValueDataINTEL.BYTES));
        }

        public VkPerformanceValueDataINTEL[] toArray() {
            VkPerformanceValueDataINTEL[] ret = new VkPerformanceValueDataINTEL[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkPerformanceValueDataINTEL> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkPerformanceValueDataINTEL> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkPerformanceValueDataINTEL.BYTES;
            }

            @Override
            public VkPerformanceValueDataINTEL next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkPerformanceValueDataINTEL ret = new VkPerformanceValueDataINTEL(segment.asSlice(0, VkPerformanceValueDataINTEL.BYTES));
                segment = segment.asSlice(VkPerformanceValueDataINTEL.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkPerformanceValueDataINTEL allocate(Arena arena) {
        return new VkPerformanceValueDataINTEL(arena.allocate(LAYOUT));
    }

    public static VkPerformanceValueDataINTEL.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        return new VkPerformanceValueDataINTEL.Ptr(segment);
    }

    public static VkPerformanceValueDataINTEL clone(Arena arena, VkPerformanceValueDataINTEL src) {
        VkPerformanceValueDataINTEL ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public @Unsigned int value32() {
        return segment.get(LAYOUT$value32, OFFSET$value32);
    }

    public VkPerformanceValueDataINTEL value32(@Unsigned int value) {
        segment.set(LAYOUT$value32, OFFSET$value32, value);
        return this;
    }

    public @Unsigned long value64() {
        return segment.get(LAYOUT$value64, OFFSET$value64);
    }

    public VkPerformanceValueDataINTEL value64(@Unsigned long value) {
        segment.set(LAYOUT$value64, OFFSET$value64, value);
        return this;
    }

    public float valueFloat() {
        return segment.get(LAYOUT$valueFloat, OFFSET$valueFloat);
    }

    public VkPerformanceValueDataINTEL valueFloat(float value) {
        segment.set(LAYOUT$valueFloat, OFFSET$valueFloat, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int valueBool() {
        return segment.get(LAYOUT$valueBool, OFFSET$valueBool);
    }

    public VkPerformanceValueDataINTEL valueBool(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$valueBool, OFFSET$valueBool, value);
        return this;
    }

    /// Note: the returned {@link BytePtr} does not have correct
    /// {@link BytePtr#size} property. It's up to user to track the size of the buffer,
    /// and use {@link BytePtr#reinterpret} to set the size before actually reading from or
    /// writing to the buffer.
    public @Nullable BytePtr valueString() {
        MemorySegment s = valueStringRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new BytePtr(s);
    }

    public VkPerformanceValueDataINTEL valueString(@Nullable BytePtr value) {
        MemorySegment s = value == null ? MemorySegment.NULL : value.segment();
        valueStringRaw(s);
        return this;
    }

    public @Pointer(comment="int8_t*") @NotNull MemorySegment valueStringRaw() {
        return segment.get(LAYOUT$valueString, OFFSET$valueString);
    }

    public void valueStringRaw(@Pointer(comment="int8_t*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$valueString, OFFSET$valueString, value);
    }

    public static final UnionLayout LAYOUT = NativeLayout.unionLayout(
        ValueLayout.JAVA_INT.withName("value32"),
        ValueLayout.JAVA_LONG.withName("value64"),
        ValueLayout.JAVA_FLOAT.withName("valueFloat"),
        ValueLayout.JAVA_INT.withName("valueBool"),
        ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_BYTE).withName("valueString")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$value32 = PathElement.groupElement("value32");
    public static final PathElement PATH$value64 = PathElement.groupElement("value64");
    public static final PathElement PATH$valueFloat = PathElement.groupElement("valueFloat");
    public static final PathElement PATH$valueBool = PathElement.groupElement("valueBool");
    public static final PathElement PATH$valueString = PathElement.groupElement("valueString");

    public static final OfInt LAYOUT$value32 = (OfInt) LAYOUT.select(PATH$value32);
    public static final OfLong LAYOUT$value64 = (OfLong) LAYOUT.select(PATH$value64);
    public static final OfFloat LAYOUT$valueFloat = (OfFloat) LAYOUT.select(PATH$valueFloat);
    public static final OfInt LAYOUT$valueBool = (OfInt) LAYOUT.select(PATH$valueBool);
    public static final AddressLayout LAYOUT$valueString = (AddressLayout) LAYOUT.select(PATH$valueString);

    public static final long SIZE$value32 = LAYOUT$value32.byteSize();
    public static final long SIZE$value64 = LAYOUT$value64.byteSize();
    public static final long SIZE$valueFloat = LAYOUT$valueFloat.byteSize();
    public static final long SIZE$valueBool = LAYOUT$valueBool.byteSize();
    public static final long SIZE$valueString = LAYOUT$valueString.byteSize();

    public static final long OFFSET$value32 = LAYOUT.byteOffset(PATH$value32);
    public static final long OFFSET$value64 = LAYOUT.byteOffset(PATH$value64);
    public static final long OFFSET$valueFloat = LAYOUT.byteOffset(PATH$valueFloat);
    public static final long OFFSET$valueBool = LAYOUT.byteOffset(PATH$valueBool);
    public static final long OFFSET$valueString = LAYOUT.byteOffset(PATH$valueString);
}
