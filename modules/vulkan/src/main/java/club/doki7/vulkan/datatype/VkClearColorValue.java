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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkClearColorValue.html"><code>VkClearColorValue</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef union VkClearColorValue {
///     float[4] float32; // @link substring="float32" target="#float32"
///     int32_t[4] int32; // @link substring="int32" target="#int32"
///     uint32_t[4] uint32; // @link substring="uint32" target="#uint32"
/// } VkClearColorValue;
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkClearColorValue.html"><code>VkClearColorValue</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkClearColorValue(@NotNull MemorySegment segment) implements IVkClearColorValue {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkClearColorValue.html"><code>VkClearColorValue</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkClearColorValue}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkClearColorValue to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkClearColorValue.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkClearColorValue, Iterable<VkClearColorValue> {
        public long size() {
            return segment.byteSize() / VkClearColorValue.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkClearColorValue at(long index) {
            return new VkClearColorValue(segment.asSlice(index * VkClearColorValue.BYTES, VkClearColorValue.BYTES));
        }

        public VkClearColorValue.Ptr at(long index, @NotNull Consumer<@NotNull VkClearColorValue> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkClearColorValue value) {
            MemorySegment s = segment.asSlice(index * VkClearColorValue.BYTES, VkClearColorValue.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkClearColorValue.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkClearColorValue.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkClearColorValue.BYTES,
                (end - start) * VkClearColorValue.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkClearColorValue.BYTES));
        }

        public VkClearColorValue[] toArray() {
            VkClearColorValue[] ret = new VkClearColorValue[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkClearColorValue> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkClearColorValue> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkClearColorValue.BYTES;
            }

            @Override
            public VkClearColorValue next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkClearColorValue ret = new VkClearColorValue(segment.asSlice(0, VkClearColorValue.BYTES));
                segment = segment.asSlice(VkClearColorValue.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkClearColorValue allocate(Arena arena) {
        return new VkClearColorValue(arena.allocate(LAYOUT));
    }

    public static VkClearColorValue.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        return new VkClearColorValue.Ptr(segment);
    }

    public static VkClearColorValue clone(Arena arena, VkClearColorValue src) {
        VkClearColorValue ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public FloatPtr float32() {
        return new FloatPtr(float32Raw());
    }

    public VkClearColorValue float32(@NotNull Consumer<FloatPtr> consumer) {
        FloatPtr ptr = float32();
        consumer.accept(ptr);
        return this;
    }

    public VkClearColorValue float32(FloatPtr value) {
        MemorySegment s = float32Raw();
        s.copyFrom(value.segment());
        return this;
    }

    public @NotNull MemorySegment float32Raw() {
        return segment.asSlice(OFFSET$float32, SIZE$float32);
    }

    public IntPtr int32() {
        return new IntPtr(int32Raw());
    }

    public VkClearColorValue int32(@NotNull Consumer<IntPtr> consumer) {
        IntPtr ptr = int32();
        consumer.accept(ptr);
        return this;
    }

    public VkClearColorValue int32(IntPtr value) {
        MemorySegment s = int32Raw();
        s.copyFrom(value.segment());
        return this;
    }

    public @NotNull MemorySegment int32Raw() {
        return segment.asSlice(OFFSET$int32, SIZE$int32);
    }

    public @Unsigned IntPtr uint32() {
        return new IntPtr(uint32Raw());
    }

    public VkClearColorValue uint32(@NotNull Consumer<IntPtr> consumer) {
        @Unsigned IntPtr ptr = uint32();
        consumer.accept(ptr);
        return this;
    }

    public VkClearColorValue uint32(@Unsigned IntPtr value) {
        MemorySegment s = uint32Raw();
        s.copyFrom(value.segment());
        return this;
    }

    public @NotNull MemorySegment uint32Raw() {
        return segment.asSlice(OFFSET$uint32, SIZE$uint32);
    }

    public static final UnionLayout LAYOUT = NativeLayout.unionLayout(
        MemoryLayout.sequenceLayout(4, ValueLayout.JAVA_FLOAT).withName("float32"),
        MemoryLayout.sequenceLayout(4, ValueLayout.JAVA_INT).withName("int32"),
        MemoryLayout.sequenceLayout(4, ValueLayout.JAVA_INT).withName("uint32")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$float32 = PathElement.groupElement("float32");
    public static final PathElement PATH$int32 = PathElement.groupElement("int32");
    public static final PathElement PATH$uint32 = PathElement.groupElement("uint32");

    public static final SequenceLayout LAYOUT$float32 = (SequenceLayout) LAYOUT.select(PATH$float32);
    public static final SequenceLayout LAYOUT$int32 = (SequenceLayout) LAYOUT.select(PATH$int32);
    public static final SequenceLayout LAYOUT$uint32 = (SequenceLayout) LAYOUT.select(PATH$uint32);

    public static final long SIZE$float32 = LAYOUT$float32.byteSize();
    public static final long SIZE$int32 = LAYOUT$int32.byteSize();
    public static final long SIZE$uint32 = LAYOUT$uint32.byteSize();

    public static final long OFFSET$float32 = LAYOUT.byteOffset(PATH$float32);
    public static final long OFFSET$int32 = LAYOUT.byteOffset(PATH$int32);
    public static final long OFFSET$uint32 = LAYOUT.byteOffset(PATH$uint32);
}
