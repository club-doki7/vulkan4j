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
import club.doki7.ffm.bits.BitfieldUtil;
import club.doki7.ffm.annotation.*;
import club.doki7.ffm.ptr.*;
import club.doki7.vulkan.bitmask.*;
import club.doki7.vulkan.handle.*;
import club.doki7.vulkan.enumtype.*;
import static club.doki7.vulkan.VkConstants.*;
import club.doki7.vulkan.VkFunctionTypes.*;

/// Represents a pointer to a {@code StdVideoEncodeH265SliceSegmentHeaderFlags} structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct StdVideoEncodeH265SliceSegmentHeaderFlags {
///     uint32_t first_slice_segment_in_pic_flag : 1; // @link substring="first_slice_segment_in_pic_flag" target="#first_slice_segment_in_pic_flag"
///     uint32_t dependent_slice_segment_flag : 1; // @link substring="dependent_slice_segment_flag" target="#dependent_slice_segment_flag"
///     uint32_t slice_sao_luma_flag : 1; // @link substring="slice_sao_luma_flag" target="#slice_sao_luma_flag"
///     uint32_t slice_sao_chroma_flag : 1; // @link substring="slice_sao_chroma_flag" target="#slice_sao_chroma_flag"
///     uint32_t num_ref_idx_active_override_flag : 1; // @link substring="num_ref_idx_active_override_flag" target="#num_ref_idx_active_override_flag"
///     uint32_t mvd_l1_zero_flag : 1; // @link substring="mvd_l1_zero_flag" target="#mvd_l1_zero_flag"
///     uint32_t cabac_init_flag : 1; // @link substring="cabac_init_flag" target="#cabac_init_flag"
///     uint32_t cu_chroma_qp_offset_enabled_flag : 1; // @link substring="cu_chroma_qp_offset_enabled_flag" target="#cu_chroma_qp_offset_enabled_flag"
///     uint32_t deblocking_filter_override_flag : 1; // @link substring="deblocking_filter_override_flag" target="#deblocking_filter_override_flag"
///     uint32_t slice_deblocking_filter_disabled_flag : 1; // @link substring="slice_deblocking_filter_disabled_flag" target="#slice_deblocking_filter_disabled_flag"
///     uint32_t collocated_from_l0_flag : 1; // @link substring="collocated_from_l0_flag" target="#collocated_from_l0_flag"
///     uint32_t slice_loop_filter_across_slices_enabled_flag : 1; // @link substring="slice_loop_filter_across_slices_enabled_flag" target="#slice_loop_filter_across_slices_enabled_flag"
///     uint32_t reserved : 20;
/// } StdVideoEncodeH265SliceSegmentHeaderFlags;
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
public record StdVideoEncodeH265SliceSegmentHeaderFlags(@NotNull MemorySegment segment) implements IStdVideoEncodeH265SliceSegmentHeaderFlags {
    /// Represents a pointer to / an array of null structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link StdVideoEncodeH265SliceSegmentHeaderFlags}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IStdVideoEncodeH265SliceSegmentHeaderFlags to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code StdVideoEncodeH265SliceSegmentHeaderFlags.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IStdVideoEncodeH265SliceSegmentHeaderFlags, Iterable<StdVideoEncodeH265SliceSegmentHeaderFlags> {
        public long size() {
            return segment.byteSize() / StdVideoEncodeH265SliceSegmentHeaderFlags.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull StdVideoEncodeH265SliceSegmentHeaderFlags at(long index) {
            return new StdVideoEncodeH265SliceSegmentHeaderFlags(segment.asSlice(index * StdVideoEncodeH265SliceSegmentHeaderFlags.BYTES, StdVideoEncodeH265SliceSegmentHeaderFlags.BYTES));
        }

        public StdVideoEncodeH265SliceSegmentHeaderFlags.Ptr at(long index, @NotNull Consumer<@NotNull StdVideoEncodeH265SliceSegmentHeaderFlags> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull StdVideoEncodeH265SliceSegmentHeaderFlags value) {
            MemorySegment s = segment.asSlice(index * StdVideoEncodeH265SliceSegmentHeaderFlags.BYTES, StdVideoEncodeH265SliceSegmentHeaderFlags.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * StdVideoEncodeH265SliceSegmentHeaderFlags.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * StdVideoEncodeH265SliceSegmentHeaderFlags.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * StdVideoEncodeH265SliceSegmentHeaderFlags.BYTES,
                (end - start) * StdVideoEncodeH265SliceSegmentHeaderFlags.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * StdVideoEncodeH265SliceSegmentHeaderFlags.BYTES));
        }

        public StdVideoEncodeH265SliceSegmentHeaderFlags[] toArray() {
            StdVideoEncodeH265SliceSegmentHeaderFlags[] ret = new StdVideoEncodeH265SliceSegmentHeaderFlags[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<StdVideoEncodeH265SliceSegmentHeaderFlags> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<StdVideoEncodeH265SliceSegmentHeaderFlags> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= StdVideoEncodeH265SliceSegmentHeaderFlags.BYTES;
            }

            @Override
            public StdVideoEncodeH265SliceSegmentHeaderFlags next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                StdVideoEncodeH265SliceSegmentHeaderFlags ret = new StdVideoEncodeH265SliceSegmentHeaderFlags(segment.asSlice(0, StdVideoEncodeH265SliceSegmentHeaderFlags.BYTES));
                segment = segment.asSlice(StdVideoEncodeH265SliceSegmentHeaderFlags.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static StdVideoEncodeH265SliceSegmentHeaderFlags allocate(Arena arena) {
        return new StdVideoEncodeH265SliceSegmentHeaderFlags(arena.allocate(LAYOUT));
    }

    public static StdVideoEncodeH265SliceSegmentHeaderFlags.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        return new StdVideoEncodeH265SliceSegmentHeaderFlags.Ptr(segment);
    }

    public static StdVideoEncodeH265SliceSegmentHeaderFlags clone(Arena arena, StdVideoEncodeH265SliceSegmentHeaderFlags src) {
        StdVideoEncodeH265SliceSegmentHeaderFlags ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public boolean first_slice_segment_in_pic_flag() {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$first_slice_segment_in_pic_flag$reserved, LAYOUT$bitfield$first_slice_segment_in_pic_flag$reserved);
        return BitfieldUtil.readBit(s, 0);
    }

    public StdVideoEncodeH265SliceSegmentHeaderFlags first_slice_segment_in_pic_flag(boolean value) {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$first_slice_segment_in_pic_flag$reserved, LAYOUT$bitfield$first_slice_segment_in_pic_flag$reserved);
        BitfieldUtil.writeBit(s, 0, value);
        return this;
    }

    public boolean dependent_slice_segment_flag() {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$first_slice_segment_in_pic_flag$reserved, LAYOUT$bitfield$first_slice_segment_in_pic_flag$reserved);
        return BitfieldUtil.readBit(s, 1);
    }

    public StdVideoEncodeH265SliceSegmentHeaderFlags dependent_slice_segment_flag(boolean value) {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$first_slice_segment_in_pic_flag$reserved, LAYOUT$bitfield$first_slice_segment_in_pic_flag$reserved);
        BitfieldUtil.writeBit(s, 1, value);
        return this;
    }

    public boolean slice_sao_luma_flag() {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$first_slice_segment_in_pic_flag$reserved, LAYOUT$bitfield$first_slice_segment_in_pic_flag$reserved);
        return BitfieldUtil.readBit(s, 2);
    }

    public StdVideoEncodeH265SliceSegmentHeaderFlags slice_sao_luma_flag(boolean value) {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$first_slice_segment_in_pic_flag$reserved, LAYOUT$bitfield$first_slice_segment_in_pic_flag$reserved);
        BitfieldUtil.writeBit(s, 2, value);
        return this;
    }

    public boolean slice_sao_chroma_flag() {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$first_slice_segment_in_pic_flag$reserved, LAYOUT$bitfield$first_slice_segment_in_pic_flag$reserved);
        return BitfieldUtil.readBit(s, 3);
    }

    public StdVideoEncodeH265SliceSegmentHeaderFlags slice_sao_chroma_flag(boolean value) {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$first_slice_segment_in_pic_flag$reserved, LAYOUT$bitfield$first_slice_segment_in_pic_flag$reserved);
        BitfieldUtil.writeBit(s, 3, value);
        return this;
    }

    public boolean num_ref_idx_active_override_flag() {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$first_slice_segment_in_pic_flag$reserved, LAYOUT$bitfield$first_slice_segment_in_pic_flag$reserved);
        return BitfieldUtil.readBit(s, 4);
    }

    public StdVideoEncodeH265SliceSegmentHeaderFlags num_ref_idx_active_override_flag(boolean value) {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$first_slice_segment_in_pic_flag$reserved, LAYOUT$bitfield$first_slice_segment_in_pic_flag$reserved);
        BitfieldUtil.writeBit(s, 4, value);
        return this;
    }

    public boolean mvd_l1_zero_flag() {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$first_slice_segment_in_pic_flag$reserved, LAYOUT$bitfield$first_slice_segment_in_pic_flag$reserved);
        return BitfieldUtil.readBit(s, 5);
    }

    public StdVideoEncodeH265SliceSegmentHeaderFlags mvd_l1_zero_flag(boolean value) {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$first_slice_segment_in_pic_flag$reserved, LAYOUT$bitfield$first_slice_segment_in_pic_flag$reserved);
        BitfieldUtil.writeBit(s, 5, value);
        return this;
    }

    public boolean cabac_init_flag() {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$first_slice_segment_in_pic_flag$reserved, LAYOUT$bitfield$first_slice_segment_in_pic_flag$reserved);
        return BitfieldUtil.readBit(s, 6);
    }

    public StdVideoEncodeH265SliceSegmentHeaderFlags cabac_init_flag(boolean value) {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$first_slice_segment_in_pic_flag$reserved, LAYOUT$bitfield$first_slice_segment_in_pic_flag$reserved);
        BitfieldUtil.writeBit(s, 6, value);
        return this;
    }

    public boolean cu_chroma_qp_offset_enabled_flag() {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$first_slice_segment_in_pic_flag$reserved, LAYOUT$bitfield$first_slice_segment_in_pic_flag$reserved);
        return BitfieldUtil.readBit(s, 7);
    }

    public StdVideoEncodeH265SliceSegmentHeaderFlags cu_chroma_qp_offset_enabled_flag(boolean value) {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$first_slice_segment_in_pic_flag$reserved, LAYOUT$bitfield$first_slice_segment_in_pic_flag$reserved);
        BitfieldUtil.writeBit(s, 7, value);
        return this;
    }

    public boolean deblocking_filter_override_flag() {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$first_slice_segment_in_pic_flag$reserved, LAYOUT$bitfield$first_slice_segment_in_pic_flag$reserved);
        return BitfieldUtil.readBit(s, 8);
    }

    public StdVideoEncodeH265SliceSegmentHeaderFlags deblocking_filter_override_flag(boolean value) {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$first_slice_segment_in_pic_flag$reserved, LAYOUT$bitfield$first_slice_segment_in_pic_flag$reserved);
        BitfieldUtil.writeBit(s, 8, value);
        return this;
    }

    public boolean slice_deblocking_filter_disabled_flag() {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$first_slice_segment_in_pic_flag$reserved, LAYOUT$bitfield$first_slice_segment_in_pic_flag$reserved);
        return BitfieldUtil.readBit(s, 9);
    }

    public StdVideoEncodeH265SliceSegmentHeaderFlags slice_deblocking_filter_disabled_flag(boolean value) {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$first_slice_segment_in_pic_flag$reserved, LAYOUT$bitfield$first_slice_segment_in_pic_flag$reserved);
        BitfieldUtil.writeBit(s, 9, value);
        return this;
    }

    public boolean collocated_from_l0_flag() {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$first_slice_segment_in_pic_flag$reserved, LAYOUT$bitfield$first_slice_segment_in_pic_flag$reserved);
        return BitfieldUtil.readBit(s, 10);
    }

    public StdVideoEncodeH265SliceSegmentHeaderFlags collocated_from_l0_flag(boolean value) {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$first_slice_segment_in_pic_flag$reserved, LAYOUT$bitfield$first_slice_segment_in_pic_flag$reserved);
        BitfieldUtil.writeBit(s, 10, value);
        return this;
    }

    public boolean slice_loop_filter_across_slices_enabled_flag() {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$first_slice_segment_in_pic_flag$reserved, LAYOUT$bitfield$first_slice_segment_in_pic_flag$reserved);
        return BitfieldUtil.readBit(s, 11);
    }

    public StdVideoEncodeH265SliceSegmentHeaderFlags slice_loop_filter_across_slices_enabled_flag(boolean value) {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$first_slice_segment_in_pic_flag$reserved, LAYOUT$bitfield$first_slice_segment_in_pic_flag$reserved);
        BitfieldUtil.writeBit(s, 11, value);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("bitfield$first_slice_segment_in_pic_flag$reserved")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$bitfield$first_slice_segment_in_pic_flag$reserved = PathElement.groupElement("first_slice_segment_in_pic_flag$reserved");

    public static final OfInt LAYOUT$bitfield$first_slice_segment_in_pic_flag$reserved = (OfInt) LAYOUT.select(PATH$bitfield$first_slice_segment_in_pic_flag$reserved);


    public static final long OFFSET$bitfield$first_slice_segment_in_pic_flag$reserved = LAYOUT.byteOffset(PATH$bitfield$first_slice_segment_in_pic_flag$reserved);
}
