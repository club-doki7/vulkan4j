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

/// Represents a pointer to a {@code StdVideoEncodeH264WeightTableFlags} structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct StdVideoEncodeH264WeightTableFlags {
///     uint32_t luma_weight_l0_flag; // @link substring="luma_weight_l0_flag" target="#luma_weight_l0_flag"
///     uint32_t chroma_weight_l0_flag; // @link substring="chroma_weight_l0_flag" target="#chroma_weight_l0_flag"
///     uint32_t luma_weight_l1_flag; // @link substring="luma_weight_l1_flag" target="#luma_weight_l1_flag"
///     uint32_t chroma_weight_l1_flag; // @link substring="chroma_weight_l1_flag" target="#chroma_weight_l1_flag"
/// } StdVideoEncodeH264WeightTableFlags;
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
@ValueBasedCandidate
@UnsafeConstructor
public record StdVideoEncodeH264WeightTableFlags(@NotNull MemorySegment segment) implements IStdVideoEncodeH264WeightTableFlags {
    /// Represents a pointer to / an array of null structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link StdVideoEncodeH264WeightTableFlags}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IStdVideoEncodeH264WeightTableFlags to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code StdVideoEncodeH264WeightTableFlags.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IStdVideoEncodeH264WeightTableFlags, Iterable<StdVideoEncodeH264WeightTableFlags> {
        public long size() {
            return segment.byteSize() / StdVideoEncodeH264WeightTableFlags.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull StdVideoEncodeH264WeightTableFlags at(long index) {
            return new StdVideoEncodeH264WeightTableFlags(segment.asSlice(index * StdVideoEncodeH264WeightTableFlags.BYTES, StdVideoEncodeH264WeightTableFlags.BYTES));
        }

        public StdVideoEncodeH264WeightTableFlags.Ptr at(long index, @NotNull Consumer<@NotNull StdVideoEncodeH264WeightTableFlags> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull StdVideoEncodeH264WeightTableFlags value) {
            MemorySegment s = segment.asSlice(index * StdVideoEncodeH264WeightTableFlags.BYTES, StdVideoEncodeH264WeightTableFlags.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * StdVideoEncodeH264WeightTableFlags.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * StdVideoEncodeH264WeightTableFlags.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * StdVideoEncodeH264WeightTableFlags.BYTES,
                (end - start) * StdVideoEncodeH264WeightTableFlags.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * StdVideoEncodeH264WeightTableFlags.BYTES));
        }

        public StdVideoEncodeH264WeightTableFlags[] toArray() {
            StdVideoEncodeH264WeightTableFlags[] ret = new StdVideoEncodeH264WeightTableFlags[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<StdVideoEncodeH264WeightTableFlags> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<StdVideoEncodeH264WeightTableFlags> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= StdVideoEncodeH264WeightTableFlags.BYTES;
            }

            @Override
            public StdVideoEncodeH264WeightTableFlags next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                StdVideoEncodeH264WeightTableFlags ret = new StdVideoEncodeH264WeightTableFlags(segment.asSlice(0, StdVideoEncodeH264WeightTableFlags.BYTES));
                segment = segment.asSlice(StdVideoEncodeH264WeightTableFlags.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static StdVideoEncodeH264WeightTableFlags allocate(Arena arena) {
        return new StdVideoEncodeH264WeightTableFlags(arena.allocate(LAYOUT));
    }

    public static StdVideoEncodeH264WeightTableFlags.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        return new StdVideoEncodeH264WeightTableFlags.Ptr(segment);
    }

    public static StdVideoEncodeH264WeightTableFlags clone(Arena arena, StdVideoEncodeH264WeightTableFlags src) {
        StdVideoEncodeH264WeightTableFlags ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public @Unsigned int luma_weight_l0_flag() {
        return segment.get(LAYOUT$luma_weight_l0_flag, OFFSET$luma_weight_l0_flag);
    }

    public StdVideoEncodeH264WeightTableFlags luma_weight_l0_flag(@Unsigned int value) {
        segment.set(LAYOUT$luma_weight_l0_flag, OFFSET$luma_weight_l0_flag, value);
        return this;
    }

    public @Unsigned int chroma_weight_l0_flag() {
        return segment.get(LAYOUT$chroma_weight_l0_flag, OFFSET$chroma_weight_l0_flag);
    }

    public StdVideoEncodeH264WeightTableFlags chroma_weight_l0_flag(@Unsigned int value) {
        segment.set(LAYOUT$chroma_weight_l0_flag, OFFSET$chroma_weight_l0_flag, value);
        return this;
    }

    public @Unsigned int luma_weight_l1_flag() {
        return segment.get(LAYOUT$luma_weight_l1_flag, OFFSET$luma_weight_l1_flag);
    }

    public StdVideoEncodeH264WeightTableFlags luma_weight_l1_flag(@Unsigned int value) {
        segment.set(LAYOUT$luma_weight_l1_flag, OFFSET$luma_weight_l1_flag, value);
        return this;
    }

    public @Unsigned int chroma_weight_l1_flag() {
        return segment.get(LAYOUT$chroma_weight_l1_flag, OFFSET$chroma_weight_l1_flag);
    }

    public StdVideoEncodeH264WeightTableFlags chroma_weight_l1_flag(@Unsigned int value) {
        segment.set(LAYOUT$chroma_weight_l1_flag, OFFSET$chroma_weight_l1_flag, value);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("luma_weight_l0_flag"),
        ValueLayout.JAVA_INT.withName("chroma_weight_l0_flag"),
        ValueLayout.JAVA_INT.withName("luma_weight_l1_flag"),
        ValueLayout.JAVA_INT.withName("chroma_weight_l1_flag")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$luma_weight_l0_flag = PathElement.groupElement("luma_weight_l0_flag");
    public static final PathElement PATH$chroma_weight_l0_flag = PathElement.groupElement("chroma_weight_l0_flag");
    public static final PathElement PATH$luma_weight_l1_flag = PathElement.groupElement("luma_weight_l1_flag");
    public static final PathElement PATH$chroma_weight_l1_flag = PathElement.groupElement("chroma_weight_l1_flag");

    public static final OfInt LAYOUT$luma_weight_l0_flag = (OfInt) LAYOUT.select(PATH$luma_weight_l0_flag);
    public static final OfInt LAYOUT$chroma_weight_l0_flag = (OfInt) LAYOUT.select(PATH$chroma_weight_l0_flag);
    public static final OfInt LAYOUT$luma_weight_l1_flag = (OfInt) LAYOUT.select(PATH$luma_weight_l1_flag);
    public static final OfInt LAYOUT$chroma_weight_l1_flag = (OfInt) LAYOUT.select(PATH$chroma_weight_l1_flag);

    public static final long SIZE$luma_weight_l0_flag = LAYOUT$luma_weight_l0_flag.byteSize();
    public static final long SIZE$chroma_weight_l0_flag = LAYOUT$chroma_weight_l0_flag.byteSize();
    public static final long SIZE$luma_weight_l1_flag = LAYOUT$luma_weight_l1_flag.byteSize();
    public static final long SIZE$chroma_weight_l1_flag = LAYOUT$chroma_weight_l1_flag.byteSize();

    public static final long OFFSET$luma_weight_l0_flag = LAYOUT.byteOffset(PATH$luma_weight_l0_flag);
    public static final long OFFSET$chroma_weight_l0_flag = LAYOUT.byteOffset(PATH$chroma_weight_l0_flag);
    public static final long OFFSET$luma_weight_l1_flag = LAYOUT.byteOffset(PATH$luma_weight_l1_flag);
    public static final long OFFSET$chroma_weight_l1_flag = LAYOUT.byteOffset(PATH$chroma_weight_l1_flag);
}
