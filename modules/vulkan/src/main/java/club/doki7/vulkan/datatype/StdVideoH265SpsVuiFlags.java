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

/// Represents a pointer to a {@code StdVideoH265SpsVuiFlags} structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct StdVideoH265SpsVuiFlags {
///     uint32_t aspect_ratio_info_present_flag : 1; // @link substring="aspect_ratio_info_present_flag" target="#aspect_ratio_info_present_flag"
///     uint32_t overscan_info_present_flag : 1; // @link substring="overscan_info_present_flag" target="#overscan_info_present_flag"
///     uint32_t overscan_appropriate_flag : 1; // @link substring="overscan_appropriate_flag" target="#overscan_appropriate_flag"
///     uint32_t video_signal_type_present_flag : 1; // @link substring="video_signal_type_present_flag" target="#video_signal_type_present_flag"
///     uint32_t video_full_range_flag : 1; // @link substring="video_full_range_flag" target="#video_full_range_flag"
///     uint32_t colour_description_present_flag : 1; // @link substring="colour_description_present_flag" target="#colour_description_present_flag"
///     uint32_t chroma_loc_info_present_flag : 1; // @link substring="chroma_loc_info_present_flag" target="#chroma_loc_info_present_flag"
///     uint32_t neutral_chroma_indication_flag : 1; // @link substring="neutral_chroma_indication_flag" target="#neutral_chroma_indication_flag"
///     uint32_t field_seq_flag : 1; // @link substring="field_seq_flag" target="#field_seq_flag"
///     uint32_t frame_field_info_present_flag : 1; // @link substring="frame_field_info_present_flag" target="#frame_field_info_present_flag"
///     uint32_t default_display_window_flag : 1; // @link substring="default_display_window_flag" target="#default_display_window_flag"
///     uint32_t vui_timing_info_present_flag : 1; // @link substring="vui_timing_info_present_flag" target="#vui_timing_info_present_flag"
///     uint32_t vui_poc_proportional_to_timing_flag : 1; // @link substring="vui_poc_proportional_to_timing_flag" target="#vui_poc_proportional_to_timing_flag"
///     uint32_t vui_hrd_parameters_present_flag : 1; // @link substring="vui_hrd_parameters_present_flag" target="#vui_hrd_parameters_present_flag"
///     uint32_t bitstream_restriction_flag : 1; // @link substring="bitstream_restriction_flag" target="#bitstream_restriction_flag"
///     uint32_t tiles_fixed_structure_flag : 1; // @link substring="tiles_fixed_structure_flag" target="#tiles_fixed_structure_flag"
///     uint32_t motion_vectors_over_pic_boundaries_flag : 1; // @link substring="motion_vectors_over_pic_boundaries_flag" target="#motion_vectors_over_pic_boundaries_flag"
///     uint32_t restricted_ref_pic_lists_flag : 1; // @link substring="restricted_ref_pic_lists_flag" target="#restricted_ref_pic_lists_flag"
/// } StdVideoH265SpsVuiFlags;
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
public record StdVideoH265SpsVuiFlags(@NotNull MemorySegment segment) implements IStdVideoH265SpsVuiFlags {
    /// Represents a pointer to / an array of null structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link StdVideoH265SpsVuiFlags}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IStdVideoH265SpsVuiFlags to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code StdVideoH265SpsVuiFlags.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IStdVideoH265SpsVuiFlags, Iterable<StdVideoH265SpsVuiFlags> {
        public long size() {
            return segment.byteSize() / StdVideoH265SpsVuiFlags.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull StdVideoH265SpsVuiFlags at(long index) {
            return new StdVideoH265SpsVuiFlags(segment.asSlice(index * StdVideoH265SpsVuiFlags.BYTES, StdVideoH265SpsVuiFlags.BYTES));
        }

        public StdVideoH265SpsVuiFlags.Ptr at(long index, @NotNull Consumer<@NotNull StdVideoH265SpsVuiFlags> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull StdVideoH265SpsVuiFlags value) {
            MemorySegment s = segment.asSlice(index * StdVideoH265SpsVuiFlags.BYTES, StdVideoH265SpsVuiFlags.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * StdVideoH265SpsVuiFlags.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * StdVideoH265SpsVuiFlags.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * StdVideoH265SpsVuiFlags.BYTES,
                (end - start) * StdVideoH265SpsVuiFlags.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * StdVideoH265SpsVuiFlags.BYTES));
        }

        public StdVideoH265SpsVuiFlags[] toArray() {
            StdVideoH265SpsVuiFlags[] ret = new StdVideoH265SpsVuiFlags[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<StdVideoH265SpsVuiFlags> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<StdVideoH265SpsVuiFlags> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= StdVideoH265SpsVuiFlags.BYTES;
            }

            @Override
            public StdVideoH265SpsVuiFlags next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                StdVideoH265SpsVuiFlags ret = new StdVideoH265SpsVuiFlags(segment.asSlice(0, StdVideoH265SpsVuiFlags.BYTES));
                segment = segment.asSlice(StdVideoH265SpsVuiFlags.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static StdVideoH265SpsVuiFlags allocate(Arena arena) {
        return new StdVideoH265SpsVuiFlags(arena.allocate(LAYOUT));
    }

    public static StdVideoH265SpsVuiFlags.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        return new StdVideoH265SpsVuiFlags.Ptr(segment);
    }

    public static StdVideoH265SpsVuiFlags clone(Arena arena, StdVideoH265SpsVuiFlags src) {
        StdVideoH265SpsVuiFlags ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public boolean aspect_ratio_info_present_flag() {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$aspect_ratio_info_present_flag$restricted_ref_pic_lists_flag, LAYOUT$bitfield$aspect_ratio_info_present_flag$restricted_ref_pic_lists_flag);
        return BitfieldUtil.readBit(s, 0);
    }

    public StdVideoH265SpsVuiFlags aspect_ratio_info_present_flag(boolean value) {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$aspect_ratio_info_present_flag$restricted_ref_pic_lists_flag, LAYOUT$bitfield$aspect_ratio_info_present_flag$restricted_ref_pic_lists_flag);
        BitfieldUtil.writeBit(s, 0, value);
        return this;
    }

    public boolean overscan_info_present_flag() {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$aspect_ratio_info_present_flag$restricted_ref_pic_lists_flag, LAYOUT$bitfield$aspect_ratio_info_present_flag$restricted_ref_pic_lists_flag);
        return BitfieldUtil.readBit(s, 1);
    }

    public StdVideoH265SpsVuiFlags overscan_info_present_flag(boolean value) {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$aspect_ratio_info_present_flag$restricted_ref_pic_lists_flag, LAYOUT$bitfield$aspect_ratio_info_present_flag$restricted_ref_pic_lists_flag);
        BitfieldUtil.writeBit(s, 1, value);
        return this;
    }

    public boolean overscan_appropriate_flag() {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$aspect_ratio_info_present_flag$restricted_ref_pic_lists_flag, LAYOUT$bitfield$aspect_ratio_info_present_flag$restricted_ref_pic_lists_flag);
        return BitfieldUtil.readBit(s, 2);
    }

    public StdVideoH265SpsVuiFlags overscan_appropriate_flag(boolean value) {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$aspect_ratio_info_present_flag$restricted_ref_pic_lists_flag, LAYOUT$bitfield$aspect_ratio_info_present_flag$restricted_ref_pic_lists_flag);
        BitfieldUtil.writeBit(s, 2, value);
        return this;
    }

    public boolean video_signal_type_present_flag() {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$aspect_ratio_info_present_flag$restricted_ref_pic_lists_flag, LAYOUT$bitfield$aspect_ratio_info_present_flag$restricted_ref_pic_lists_flag);
        return BitfieldUtil.readBit(s, 3);
    }

    public StdVideoH265SpsVuiFlags video_signal_type_present_flag(boolean value) {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$aspect_ratio_info_present_flag$restricted_ref_pic_lists_flag, LAYOUT$bitfield$aspect_ratio_info_present_flag$restricted_ref_pic_lists_flag);
        BitfieldUtil.writeBit(s, 3, value);
        return this;
    }

    public boolean video_full_range_flag() {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$aspect_ratio_info_present_flag$restricted_ref_pic_lists_flag, LAYOUT$bitfield$aspect_ratio_info_present_flag$restricted_ref_pic_lists_flag);
        return BitfieldUtil.readBit(s, 4);
    }

    public StdVideoH265SpsVuiFlags video_full_range_flag(boolean value) {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$aspect_ratio_info_present_flag$restricted_ref_pic_lists_flag, LAYOUT$bitfield$aspect_ratio_info_present_flag$restricted_ref_pic_lists_flag);
        BitfieldUtil.writeBit(s, 4, value);
        return this;
    }

    public boolean colour_description_present_flag() {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$aspect_ratio_info_present_flag$restricted_ref_pic_lists_flag, LAYOUT$bitfield$aspect_ratio_info_present_flag$restricted_ref_pic_lists_flag);
        return BitfieldUtil.readBit(s, 5);
    }

    public StdVideoH265SpsVuiFlags colour_description_present_flag(boolean value) {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$aspect_ratio_info_present_flag$restricted_ref_pic_lists_flag, LAYOUT$bitfield$aspect_ratio_info_present_flag$restricted_ref_pic_lists_flag);
        BitfieldUtil.writeBit(s, 5, value);
        return this;
    }

    public boolean chroma_loc_info_present_flag() {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$aspect_ratio_info_present_flag$restricted_ref_pic_lists_flag, LAYOUT$bitfield$aspect_ratio_info_present_flag$restricted_ref_pic_lists_flag);
        return BitfieldUtil.readBit(s, 6);
    }

    public StdVideoH265SpsVuiFlags chroma_loc_info_present_flag(boolean value) {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$aspect_ratio_info_present_flag$restricted_ref_pic_lists_flag, LAYOUT$bitfield$aspect_ratio_info_present_flag$restricted_ref_pic_lists_flag);
        BitfieldUtil.writeBit(s, 6, value);
        return this;
    }

    public boolean neutral_chroma_indication_flag() {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$aspect_ratio_info_present_flag$restricted_ref_pic_lists_flag, LAYOUT$bitfield$aspect_ratio_info_present_flag$restricted_ref_pic_lists_flag);
        return BitfieldUtil.readBit(s, 7);
    }

    public StdVideoH265SpsVuiFlags neutral_chroma_indication_flag(boolean value) {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$aspect_ratio_info_present_flag$restricted_ref_pic_lists_flag, LAYOUT$bitfield$aspect_ratio_info_present_flag$restricted_ref_pic_lists_flag);
        BitfieldUtil.writeBit(s, 7, value);
        return this;
    }

    public boolean field_seq_flag() {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$aspect_ratio_info_present_flag$restricted_ref_pic_lists_flag, LAYOUT$bitfield$aspect_ratio_info_present_flag$restricted_ref_pic_lists_flag);
        return BitfieldUtil.readBit(s, 8);
    }

    public StdVideoH265SpsVuiFlags field_seq_flag(boolean value) {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$aspect_ratio_info_present_flag$restricted_ref_pic_lists_flag, LAYOUT$bitfield$aspect_ratio_info_present_flag$restricted_ref_pic_lists_flag);
        BitfieldUtil.writeBit(s, 8, value);
        return this;
    }

    public boolean frame_field_info_present_flag() {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$aspect_ratio_info_present_flag$restricted_ref_pic_lists_flag, LAYOUT$bitfield$aspect_ratio_info_present_flag$restricted_ref_pic_lists_flag);
        return BitfieldUtil.readBit(s, 9);
    }

    public StdVideoH265SpsVuiFlags frame_field_info_present_flag(boolean value) {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$aspect_ratio_info_present_flag$restricted_ref_pic_lists_flag, LAYOUT$bitfield$aspect_ratio_info_present_flag$restricted_ref_pic_lists_flag);
        BitfieldUtil.writeBit(s, 9, value);
        return this;
    }

    public boolean default_display_window_flag() {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$aspect_ratio_info_present_flag$restricted_ref_pic_lists_flag, LAYOUT$bitfield$aspect_ratio_info_present_flag$restricted_ref_pic_lists_flag);
        return BitfieldUtil.readBit(s, 10);
    }

    public StdVideoH265SpsVuiFlags default_display_window_flag(boolean value) {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$aspect_ratio_info_present_flag$restricted_ref_pic_lists_flag, LAYOUT$bitfield$aspect_ratio_info_present_flag$restricted_ref_pic_lists_flag);
        BitfieldUtil.writeBit(s, 10, value);
        return this;
    }

    public boolean vui_timing_info_present_flag() {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$aspect_ratio_info_present_flag$restricted_ref_pic_lists_flag, LAYOUT$bitfield$aspect_ratio_info_present_flag$restricted_ref_pic_lists_flag);
        return BitfieldUtil.readBit(s, 11);
    }

    public StdVideoH265SpsVuiFlags vui_timing_info_present_flag(boolean value) {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$aspect_ratio_info_present_flag$restricted_ref_pic_lists_flag, LAYOUT$bitfield$aspect_ratio_info_present_flag$restricted_ref_pic_lists_flag);
        BitfieldUtil.writeBit(s, 11, value);
        return this;
    }

    public boolean vui_poc_proportional_to_timing_flag() {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$aspect_ratio_info_present_flag$restricted_ref_pic_lists_flag, LAYOUT$bitfield$aspect_ratio_info_present_flag$restricted_ref_pic_lists_flag);
        return BitfieldUtil.readBit(s, 12);
    }

    public StdVideoH265SpsVuiFlags vui_poc_proportional_to_timing_flag(boolean value) {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$aspect_ratio_info_present_flag$restricted_ref_pic_lists_flag, LAYOUT$bitfield$aspect_ratio_info_present_flag$restricted_ref_pic_lists_flag);
        BitfieldUtil.writeBit(s, 12, value);
        return this;
    }

    public boolean vui_hrd_parameters_present_flag() {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$aspect_ratio_info_present_flag$restricted_ref_pic_lists_flag, LAYOUT$bitfield$aspect_ratio_info_present_flag$restricted_ref_pic_lists_flag);
        return BitfieldUtil.readBit(s, 13);
    }

    public StdVideoH265SpsVuiFlags vui_hrd_parameters_present_flag(boolean value) {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$aspect_ratio_info_present_flag$restricted_ref_pic_lists_flag, LAYOUT$bitfield$aspect_ratio_info_present_flag$restricted_ref_pic_lists_flag);
        BitfieldUtil.writeBit(s, 13, value);
        return this;
    }

    public boolean bitstream_restriction_flag() {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$aspect_ratio_info_present_flag$restricted_ref_pic_lists_flag, LAYOUT$bitfield$aspect_ratio_info_present_flag$restricted_ref_pic_lists_flag);
        return BitfieldUtil.readBit(s, 14);
    }

    public StdVideoH265SpsVuiFlags bitstream_restriction_flag(boolean value) {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$aspect_ratio_info_present_flag$restricted_ref_pic_lists_flag, LAYOUT$bitfield$aspect_ratio_info_present_flag$restricted_ref_pic_lists_flag);
        BitfieldUtil.writeBit(s, 14, value);
        return this;
    }

    public boolean tiles_fixed_structure_flag() {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$aspect_ratio_info_present_flag$restricted_ref_pic_lists_flag, LAYOUT$bitfield$aspect_ratio_info_present_flag$restricted_ref_pic_lists_flag);
        return BitfieldUtil.readBit(s, 15);
    }

    public StdVideoH265SpsVuiFlags tiles_fixed_structure_flag(boolean value) {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$aspect_ratio_info_present_flag$restricted_ref_pic_lists_flag, LAYOUT$bitfield$aspect_ratio_info_present_flag$restricted_ref_pic_lists_flag);
        BitfieldUtil.writeBit(s, 15, value);
        return this;
    }

    public boolean motion_vectors_over_pic_boundaries_flag() {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$aspect_ratio_info_present_flag$restricted_ref_pic_lists_flag, LAYOUT$bitfield$aspect_ratio_info_present_flag$restricted_ref_pic_lists_flag);
        return BitfieldUtil.readBit(s, 16);
    }

    public StdVideoH265SpsVuiFlags motion_vectors_over_pic_boundaries_flag(boolean value) {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$aspect_ratio_info_present_flag$restricted_ref_pic_lists_flag, LAYOUT$bitfield$aspect_ratio_info_present_flag$restricted_ref_pic_lists_flag);
        BitfieldUtil.writeBit(s, 16, value);
        return this;
    }

    public boolean restricted_ref_pic_lists_flag() {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$aspect_ratio_info_present_flag$restricted_ref_pic_lists_flag, LAYOUT$bitfield$aspect_ratio_info_present_flag$restricted_ref_pic_lists_flag);
        return BitfieldUtil.readBit(s, 17);
    }

    public StdVideoH265SpsVuiFlags restricted_ref_pic_lists_flag(boolean value) {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$aspect_ratio_info_present_flag$restricted_ref_pic_lists_flag, LAYOUT$bitfield$aspect_ratio_info_present_flag$restricted_ref_pic_lists_flag);
        BitfieldUtil.writeBit(s, 17, value);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("bitfield$aspect_ratio_info_present_flag$restricted_ref_pic_lists_flag")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$bitfield$aspect_ratio_info_present_flag$restricted_ref_pic_lists_flag = PathElement.groupElement("aspect_ratio_info_present_flag$restricted_ref_pic_lists_flag");

    public static final OfInt LAYOUT$bitfield$aspect_ratio_info_present_flag$restricted_ref_pic_lists_flag = (OfInt) LAYOUT.select(PATH$bitfield$aspect_ratio_info_present_flag$restricted_ref_pic_lists_flag);


    public static final long OFFSET$bitfield$aspect_ratio_info_present_flag$restricted_ref_pic_lists_flag = LAYOUT.byteOffset(PATH$bitfield$aspect_ratio_info_present_flag$restricted_ref_pic_lists_flag);
}
