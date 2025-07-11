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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPipelineExecutableStatisticValueKHR.html"><code>VkPipelineExecutableStatisticValueKHR</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef union VkPipelineExecutableStatisticValueKHR {
///     VkBool32 b32; // @link substring="b32" target="#b32"
///     int64_t i64; // @link substring="i64" target="#i64"
///     uint64_t u64; // @link substring="u64" target="#u64"
///     double f64; // @link substring="f64" target="#f64"
/// } VkPipelineExecutableStatisticValueKHR;
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPipelineExecutableStatisticValueKHR.html"><code>VkPipelineExecutableStatisticValueKHR</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkPipelineExecutableStatisticValueKHR(@NotNull MemorySegment segment) implements IVkPipelineExecutableStatisticValueKHR {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPipelineExecutableStatisticValueKHR.html"><code>VkPipelineExecutableStatisticValueKHR</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkPipelineExecutableStatisticValueKHR}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkPipelineExecutableStatisticValueKHR to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkPipelineExecutableStatisticValueKHR.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkPipelineExecutableStatisticValueKHR, Iterable<VkPipelineExecutableStatisticValueKHR> {
        public long size() {
            return segment.byteSize() / VkPipelineExecutableStatisticValueKHR.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkPipelineExecutableStatisticValueKHR at(long index) {
            return new VkPipelineExecutableStatisticValueKHR(segment.asSlice(index * VkPipelineExecutableStatisticValueKHR.BYTES, VkPipelineExecutableStatisticValueKHR.BYTES));
        }

        public VkPipelineExecutableStatisticValueKHR.Ptr at(long index, @NotNull Consumer<@NotNull VkPipelineExecutableStatisticValueKHR> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkPipelineExecutableStatisticValueKHR value) {
            MemorySegment s = segment.asSlice(index * VkPipelineExecutableStatisticValueKHR.BYTES, VkPipelineExecutableStatisticValueKHR.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkPipelineExecutableStatisticValueKHR.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkPipelineExecutableStatisticValueKHR.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkPipelineExecutableStatisticValueKHR.BYTES,
                (end - start) * VkPipelineExecutableStatisticValueKHR.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkPipelineExecutableStatisticValueKHR.BYTES));
        }

        public VkPipelineExecutableStatisticValueKHR[] toArray() {
            VkPipelineExecutableStatisticValueKHR[] ret = new VkPipelineExecutableStatisticValueKHR[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkPipelineExecutableStatisticValueKHR> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkPipelineExecutableStatisticValueKHR> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkPipelineExecutableStatisticValueKHR.BYTES;
            }

            @Override
            public VkPipelineExecutableStatisticValueKHR next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkPipelineExecutableStatisticValueKHR ret = new VkPipelineExecutableStatisticValueKHR(segment.asSlice(0, VkPipelineExecutableStatisticValueKHR.BYTES));
                segment = segment.asSlice(VkPipelineExecutableStatisticValueKHR.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkPipelineExecutableStatisticValueKHR allocate(Arena arena) {
        return new VkPipelineExecutableStatisticValueKHR(arena.allocate(LAYOUT));
    }

    public static VkPipelineExecutableStatisticValueKHR.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        return new VkPipelineExecutableStatisticValueKHR.Ptr(segment);
    }

    public static VkPipelineExecutableStatisticValueKHR clone(Arena arena, VkPipelineExecutableStatisticValueKHR src) {
        VkPipelineExecutableStatisticValueKHR ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public @NativeType("VkBool32") @Unsigned int b32() {
        return segment.get(LAYOUT$b32, OFFSET$b32);
    }

    public VkPipelineExecutableStatisticValueKHR b32(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$b32, OFFSET$b32, value);
        return this;
    }

    public long i64() {
        return segment.get(LAYOUT$i64, OFFSET$i64);
    }

    public VkPipelineExecutableStatisticValueKHR i64(long value) {
        segment.set(LAYOUT$i64, OFFSET$i64, value);
        return this;
    }

    public @Unsigned long u64() {
        return segment.get(LAYOUT$u64, OFFSET$u64);
    }

    public VkPipelineExecutableStatisticValueKHR u64(@Unsigned long value) {
        segment.set(LAYOUT$u64, OFFSET$u64, value);
        return this;
    }

    public double f64() {
        return segment.get(LAYOUT$f64, OFFSET$f64);
    }

    public VkPipelineExecutableStatisticValueKHR f64(double value) {
        segment.set(LAYOUT$f64, OFFSET$f64, value);
        return this;
    }

    public static final UnionLayout LAYOUT = NativeLayout.unionLayout(
        ValueLayout.JAVA_INT.withName("b32"),
        ValueLayout.JAVA_LONG.withName("i64"),
        ValueLayout.JAVA_LONG.withName("u64"),
        ValueLayout.JAVA_DOUBLE.withName("f64")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$b32 = PathElement.groupElement("b32");
    public static final PathElement PATH$i64 = PathElement.groupElement("i64");
    public static final PathElement PATH$u64 = PathElement.groupElement("u64");
    public static final PathElement PATH$f64 = PathElement.groupElement("f64");

    public static final OfInt LAYOUT$b32 = (OfInt) LAYOUT.select(PATH$b32);
    public static final OfLong LAYOUT$i64 = (OfLong) LAYOUT.select(PATH$i64);
    public static final OfLong LAYOUT$u64 = (OfLong) LAYOUT.select(PATH$u64);
    public static final OfDouble LAYOUT$f64 = (OfDouble) LAYOUT.select(PATH$f64);

    public static final long SIZE$b32 = LAYOUT$b32.byteSize();
    public static final long SIZE$i64 = LAYOUT$i64.byteSize();
    public static final long SIZE$u64 = LAYOUT$u64.byteSize();
    public static final long SIZE$f64 = LAYOUT$f64.byteSize();

    public static final long OFFSET$b32 = LAYOUT.byteOffset(PATH$b32);
    public static final long OFFSET$i64 = LAYOUT.byteOffset(PATH$i64);
    public static final long OFFSET$u64 = LAYOUT.byteOffset(PATH$u64);
    public static final long OFFSET$f64 = LAYOUT.byteOffset(PATH$f64);
}
