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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPerformanceCounterResultKHR.html"><code>VkPerformanceCounterResultKHR</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef union VkPerformanceCounterResultKHR {
///     int32_t int32; // @link substring="int32" target="#int32"
///     int64_t int64; // @link substring="int64" target="#int64"
///     uint32_t uint32; // @link substring="uint32" target="#uint32"
///     uint64_t uint64; // @link substring="uint64" target="#uint64"
///     float float32; // @link substring="float32" target="#float32"
///     double float64; // @link substring="float64" target="#float64"
/// } VkPerformanceCounterResultKHR;
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPerformanceCounterResultKHR.html"><code>VkPerformanceCounterResultKHR</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkPerformanceCounterResultKHR(@NotNull MemorySegment segment) implements IVkPerformanceCounterResultKHR {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPerformanceCounterResultKHR.html"><code>VkPerformanceCounterResultKHR</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkPerformanceCounterResultKHR}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkPerformanceCounterResultKHR to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkPerformanceCounterResultKHR.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkPerformanceCounterResultKHR, Iterable<VkPerformanceCounterResultKHR> {
        public long size() {
            return segment.byteSize() / VkPerformanceCounterResultKHR.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkPerformanceCounterResultKHR at(long index) {
            return new VkPerformanceCounterResultKHR(segment.asSlice(index * VkPerformanceCounterResultKHR.BYTES, VkPerformanceCounterResultKHR.BYTES));
        }

        public VkPerformanceCounterResultKHR.Ptr at(long index, @NotNull Consumer<@NotNull VkPerformanceCounterResultKHR> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkPerformanceCounterResultKHR value) {
            MemorySegment s = segment.asSlice(index * VkPerformanceCounterResultKHR.BYTES, VkPerformanceCounterResultKHR.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkPerformanceCounterResultKHR.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkPerformanceCounterResultKHR.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkPerformanceCounterResultKHR.BYTES,
                (end - start) * VkPerformanceCounterResultKHR.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkPerformanceCounterResultKHR.BYTES));
        }

        public VkPerformanceCounterResultKHR[] toArray() {
            VkPerformanceCounterResultKHR[] ret = new VkPerformanceCounterResultKHR[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkPerformanceCounterResultKHR> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkPerformanceCounterResultKHR> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkPerformanceCounterResultKHR.BYTES;
            }

            @Override
            public VkPerformanceCounterResultKHR next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkPerformanceCounterResultKHR ret = new VkPerformanceCounterResultKHR(segment.asSlice(0, VkPerformanceCounterResultKHR.BYTES));
                segment = segment.asSlice(VkPerformanceCounterResultKHR.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkPerformanceCounterResultKHR allocate(Arena arena) {
        return new VkPerformanceCounterResultKHR(arena.allocate(LAYOUT));
    }

    public static VkPerformanceCounterResultKHR.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        return new VkPerformanceCounterResultKHR.Ptr(segment);
    }

    public static VkPerformanceCounterResultKHR clone(Arena arena, VkPerformanceCounterResultKHR src) {
        VkPerformanceCounterResultKHR ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public int int32() {
        return segment.get(LAYOUT$int32, OFFSET$int32);
    }

    public VkPerformanceCounterResultKHR int32(int value) {
        segment.set(LAYOUT$int32, OFFSET$int32, value);
        return this;
    }

    public long int64() {
        return segment.get(LAYOUT$int64, OFFSET$int64);
    }

    public VkPerformanceCounterResultKHR int64(long value) {
        segment.set(LAYOUT$int64, OFFSET$int64, value);
        return this;
    }

    public @Unsigned int uint32() {
        return segment.get(LAYOUT$uint32, OFFSET$uint32);
    }

    public VkPerformanceCounterResultKHR uint32(@Unsigned int value) {
        segment.set(LAYOUT$uint32, OFFSET$uint32, value);
        return this;
    }

    public @Unsigned long uint64() {
        return segment.get(LAYOUT$uint64, OFFSET$uint64);
    }

    public VkPerformanceCounterResultKHR uint64(@Unsigned long value) {
        segment.set(LAYOUT$uint64, OFFSET$uint64, value);
        return this;
    }

    public float float32() {
        return segment.get(LAYOUT$float32, OFFSET$float32);
    }

    public VkPerformanceCounterResultKHR float32(float value) {
        segment.set(LAYOUT$float32, OFFSET$float32, value);
        return this;
    }

    public double float64() {
        return segment.get(LAYOUT$float64, OFFSET$float64);
    }

    public VkPerformanceCounterResultKHR float64(double value) {
        segment.set(LAYOUT$float64, OFFSET$float64, value);
        return this;
    }

    public static final UnionLayout LAYOUT = NativeLayout.unionLayout(
        ValueLayout.JAVA_INT.withName("int32"),
        ValueLayout.JAVA_LONG.withName("int64"),
        ValueLayout.JAVA_INT.withName("uint32"),
        ValueLayout.JAVA_LONG.withName("uint64"),
        ValueLayout.JAVA_FLOAT.withName("float32"),
        ValueLayout.JAVA_DOUBLE.withName("float64")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$int32 = PathElement.groupElement("int32");
    public static final PathElement PATH$int64 = PathElement.groupElement("int64");
    public static final PathElement PATH$uint32 = PathElement.groupElement("uint32");
    public static final PathElement PATH$uint64 = PathElement.groupElement("uint64");
    public static final PathElement PATH$float32 = PathElement.groupElement("float32");
    public static final PathElement PATH$float64 = PathElement.groupElement("float64");

    public static final OfInt LAYOUT$int32 = (OfInt) LAYOUT.select(PATH$int32);
    public static final OfLong LAYOUT$int64 = (OfLong) LAYOUT.select(PATH$int64);
    public static final OfInt LAYOUT$uint32 = (OfInt) LAYOUT.select(PATH$uint32);
    public static final OfLong LAYOUT$uint64 = (OfLong) LAYOUT.select(PATH$uint64);
    public static final OfFloat LAYOUT$float32 = (OfFloat) LAYOUT.select(PATH$float32);
    public static final OfDouble LAYOUT$float64 = (OfDouble) LAYOUT.select(PATH$float64);

    public static final long SIZE$int32 = LAYOUT$int32.byteSize();
    public static final long SIZE$int64 = LAYOUT$int64.byteSize();
    public static final long SIZE$uint32 = LAYOUT$uint32.byteSize();
    public static final long SIZE$uint64 = LAYOUT$uint64.byteSize();
    public static final long SIZE$float32 = LAYOUT$float32.byteSize();
    public static final long SIZE$float64 = LAYOUT$float64.byteSize();

    public static final long OFFSET$int32 = LAYOUT.byteOffset(PATH$int32);
    public static final long OFFSET$int64 = LAYOUT.byteOffset(PATH$int64);
    public static final long OFFSET$uint32 = LAYOUT.byteOffset(PATH$uint32);
    public static final long OFFSET$uint64 = LAYOUT.byteOffset(PATH$uint64);
    public static final long OFFSET$float32 = LAYOUT.byteOffset(PATH$float32);
    public static final long OFFSET$float64 = LAYOUT.byteOffset(PATH$float64);
}
