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

/// Represents a pointer to a {@code StdVideoH265DecPicBufMgr} structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct StdVideoH265DecPicBufMgr {
///     uint32_t[STD_VIDEO_H265_SUBLAYERS_LIST_SIZE] max_latency_increase_plus1; // @link substring="max_latency_increase_plus1" target="#max_latency_increase_plus1"
///     uint8_t[STD_VIDEO_H265_SUBLAYERS_LIST_SIZE] max_dec_pic_buffering_minus1; // @link substring="max_dec_pic_buffering_minus1" target="#max_dec_pic_buffering_minus1"
///     uint8_t[STD_VIDEO_H265_SUBLAYERS_LIST_SIZE] max_num_reorder_pics; // @link substring="max_num_reorder_pics" target="#max_num_reorder_pics"
/// } StdVideoH265DecPicBufMgr;
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
public record StdVideoH265DecPicBufMgr(@NotNull MemorySegment segment) implements IStdVideoH265DecPicBufMgr {
    /// Represents a pointer to / an array of null structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link StdVideoH265DecPicBufMgr}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IStdVideoH265DecPicBufMgr to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code StdVideoH265DecPicBufMgr.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IStdVideoH265DecPicBufMgr, Iterable<StdVideoH265DecPicBufMgr> {
        public long size() {
            return segment.byteSize() / StdVideoH265DecPicBufMgr.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull StdVideoH265DecPicBufMgr at(long index) {
            return new StdVideoH265DecPicBufMgr(segment.asSlice(index * StdVideoH265DecPicBufMgr.BYTES, StdVideoH265DecPicBufMgr.BYTES));
        }

        public StdVideoH265DecPicBufMgr.Ptr at(long index, @NotNull Consumer<@NotNull StdVideoH265DecPicBufMgr> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull StdVideoH265DecPicBufMgr value) {
            MemorySegment s = segment.asSlice(index * StdVideoH265DecPicBufMgr.BYTES, StdVideoH265DecPicBufMgr.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * StdVideoH265DecPicBufMgr.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * StdVideoH265DecPicBufMgr.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * StdVideoH265DecPicBufMgr.BYTES,
                (end - start) * StdVideoH265DecPicBufMgr.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * StdVideoH265DecPicBufMgr.BYTES));
        }

        public StdVideoH265DecPicBufMgr[] toArray() {
            StdVideoH265DecPicBufMgr[] ret = new StdVideoH265DecPicBufMgr[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<StdVideoH265DecPicBufMgr> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<StdVideoH265DecPicBufMgr> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= StdVideoH265DecPicBufMgr.BYTES;
            }

            @Override
            public StdVideoH265DecPicBufMgr next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                StdVideoH265DecPicBufMgr ret = new StdVideoH265DecPicBufMgr(segment.asSlice(0, StdVideoH265DecPicBufMgr.BYTES));
                segment = segment.asSlice(StdVideoH265DecPicBufMgr.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static StdVideoH265DecPicBufMgr allocate(Arena arena) {
        return new StdVideoH265DecPicBufMgr(arena.allocate(LAYOUT));
    }

    public static StdVideoH265DecPicBufMgr.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        return new StdVideoH265DecPicBufMgr.Ptr(segment);
    }

    public static StdVideoH265DecPicBufMgr clone(Arena arena, StdVideoH265DecPicBufMgr src) {
        StdVideoH265DecPicBufMgr ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public @Unsigned IntPtr max_latency_increase_plus1() {
        return new IntPtr(max_latency_increase_plus1Raw());
    }

    public StdVideoH265DecPicBufMgr max_latency_increase_plus1(@NotNull Consumer<IntPtr> consumer) {
        @Unsigned IntPtr ptr = max_latency_increase_plus1();
        consumer.accept(ptr);
        return this;
    }

    public StdVideoH265DecPicBufMgr max_latency_increase_plus1(@Unsigned IntPtr value) {
        MemorySegment s = max_latency_increase_plus1Raw();
        s.copyFrom(value.segment());
        return this;
    }

    public @NotNull MemorySegment max_latency_increase_plus1Raw() {
        return segment.asSlice(OFFSET$max_latency_increase_plus1, SIZE$max_latency_increase_plus1);
    }

    public @Unsigned BytePtr max_dec_pic_buffering_minus1() {
        return new BytePtr(max_dec_pic_buffering_minus1Raw());
    }

    public StdVideoH265DecPicBufMgr max_dec_pic_buffering_minus1(@NotNull Consumer<BytePtr> consumer) {
        @Unsigned BytePtr ptr = max_dec_pic_buffering_minus1();
        consumer.accept(ptr);
        return this;
    }

    public StdVideoH265DecPicBufMgr max_dec_pic_buffering_minus1(@Unsigned BytePtr value) {
        MemorySegment s = max_dec_pic_buffering_minus1Raw();
        s.copyFrom(value.segment());
        return this;
    }

    public @NotNull MemorySegment max_dec_pic_buffering_minus1Raw() {
        return segment.asSlice(OFFSET$max_dec_pic_buffering_minus1, SIZE$max_dec_pic_buffering_minus1);
    }

    public @Unsigned BytePtr max_num_reorder_pics() {
        return new BytePtr(max_num_reorder_picsRaw());
    }

    public StdVideoH265DecPicBufMgr max_num_reorder_pics(@NotNull Consumer<BytePtr> consumer) {
        @Unsigned BytePtr ptr = max_num_reorder_pics();
        consumer.accept(ptr);
        return this;
    }

    public StdVideoH265DecPicBufMgr max_num_reorder_pics(@Unsigned BytePtr value) {
        MemorySegment s = max_num_reorder_picsRaw();
        s.copyFrom(value.segment());
        return this;
    }

    public @NotNull MemorySegment max_num_reorder_picsRaw() {
        return segment.asSlice(OFFSET$max_num_reorder_pics, SIZE$max_num_reorder_pics);
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        MemoryLayout.sequenceLayout(H265_SUBLAYERS_LIST_SIZE, ValueLayout.JAVA_INT).withName("max_latency_increase_plus1"),
        MemoryLayout.sequenceLayout(H265_SUBLAYERS_LIST_SIZE, ValueLayout.JAVA_BYTE).withName("max_dec_pic_buffering_minus1"),
        MemoryLayout.sequenceLayout(H265_SUBLAYERS_LIST_SIZE, ValueLayout.JAVA_BYTE).withName("max_num_reorder_pics")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$max_latency_increase_plus1 = PathElement.groupElement("max_latency_increase_plus1");
    public static final PathElement PATH$max_dec_pic_buffering_minus1 = PathElement.groupElement("max_dec_pic_buffering_minus1");
    public static final PathElement PATH$max_num_reorder_pics = PathElement.groupElement("max_num_reorder_pics");

    public static final SequenceLayout LAYOUT$max_latency_increase_plus1 = (SequenceLayout) LAYOUT.select(PATH$max_latency_increase_plus1);
    public static final SequenceLayout LAYOUT$max_dec_pic_buffering_minus1 = (SequenceLayout) LAYOUT.select(PATH$max_dec_pic_buffering_minus1);
    public static final SequenceLayout LAYOUT$max_num_reorder_pics = (SequenceLayout) LAYOUT.select(PATH$max_num_reorder_pics);

    public static final long SIZE$max_latency_increase_plus1 = LAYOUT$max_latency_increase_plus1.byteSize();
    public static final long SIZE$max_dec_pic_buffering_minus1 = LAYOUT$max_dec_pic_buffering_minus1.byteSize();
    public static final long SIZE$max_num_reorder_pics = LAYOUT$max_num_reorder_pics.byteSize();

    public static final long OFFSET$max_latency_increase_plus1 = LAYOUT.byteOffset(PATH$max_latency_increase_plus1);
    public static final long OFFSET$max_dec_pic_buffering_minus1 = LAYOUT.byteOffset(PATH$max_dec_pic_buffering_minus1);
    public static final long OFFSET$max_num_reorder_pics = LAYOUT.byteOffset(PATH$max_num_reorder_pics);
}
