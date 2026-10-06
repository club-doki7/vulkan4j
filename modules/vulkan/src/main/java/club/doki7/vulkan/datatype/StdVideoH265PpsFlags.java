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

/// Represents a pointer to a {@code StdVideoH265PpsFlags} structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct StdVideoH265PpsFlags {
///     uint32_t dependent_slice_segments_enabled_flag : 1; // @link substring="dependent_slice_segments_enabled_flag" target="#dependent_slice_segments_enabled_flag"
///     uint32_t output_flag_present_flag : 1; // @link substring="output_flag_present_flag" target="#output_flag_present_flag"
///     uint32_t sign_data_hiding_enabled_flag : 1; // @link substring="sign_data_hiding_enabled_flag" target="#sign_data_hiding_enabled_flag"
///     uint32_t cabac_init_present_flag : 1; // @link substring="cabac_init_present_flag" target="#cabac_init_present_flag"
///     uint32_t constrained_intra_pred_flag : 1; // @link substring="constrained_intra_pred_flag" target="#constrained_intra_pred_flag"
///     uint32_t transform_skip_enabled_flag : 1; // @link substring="transform_skip_enabled_flag" target="#transform_skip_enabled_flag"
///     uint32_t cu_qp_delta_enabled_flag : 1; // @link substring="cu_qp_delta_enabled_flag" target="#cu_qp_delta_enabled_flag"
///     uint32_t pps_slice_chroma_qp_offsets_present_flag : 1; // @link substring="pps_slice_chroma_qp_offsets_present_flag" target="#pps_slice_chroma_qp_offsets_present_flag"
///     uint32_t weighted_pred_flag : 1; // @link substring="weighted_pred_flag" target="#weighted_pred_flag"
///     uint32_t weighted_bipred_flag : 1; // @link substring="weighted_bipred_flag" target="#weighted_bipred_flag"
///     uint32_t transquant_bypass_enabled_flag : 1; // @link substring="transquant_bypass_enabled_flag" target="#transquant_bypass_enabled_flag"
///     uint32_t tiles_enabled_flag : 1; // @link substring="tiles_enabled_flag" target="#tiles_enabled_flag"
///     uint32_t entropy_coding_sync_enabled_flag : 1; // @link substring="entropy_coding_sync_enabled_flag" target="#entropy_coding_sync_enabled_flag"
///     uint32_t uniform_spacing_flag : 1; // @link substring="uniform_spacing_flag" target="#uniform_spacing_flag"
///     uint32_t loop_filter_across_tiles_enabled_flag : 1; // @link substring="loop_filter_across_tiles_enabled_flag" target="#loop_filter_across_tiles_enabled_flag"
///     uint32_t pps_loop_filter_across_slices_enabled_flag : 1; // @link substring="pps_loop_filter_across_slices_enabled_flag" target="#pps_loop_filter_across_slices_enabled_flag"
///     uint32_t deblocking_filter_control_present_flag : 1; // @link substring="deblocking_filter_control_present_flag" target="#deblocking_filter_control_present_flag"
///     uint32_t deblocking_filter_override_enabled_flag : 1; // @link substring="deblocking_filter_override_enabled_flag" target="#deblocking_filter_override_enabled_flag"
///     uint32_t pps_deblocking_filter_disabled_flag : 1; // @link substring="pps_deblocking_filter_disabled_flag" target="#pps_deblocking_filter_disabled_flag"
///     uint32_t pps_scaling_list_data_present_flag : 1; // @link substring="pps_scaling_list_data_present_flag" target="#pps_scaling_list_data_present_flag"
///     uint32_t lists_modification_present_flag : 1; // @link substring="lists_modification_present_flag" target="#lists_modification_present_flag"
///     uint32_t slice_segment_header_extension_present_flag : 1; // @link substring="slice_segment_header_extension_present_flag" target="#slice_segment_header_extension_present_flag"
///     uint32_t pps_extension_present_flag : 1; // @link substring="pps_extension_present_flag" target="#pps_extension_present_flag"
///     uint32_t cross_component_prediction_enabled_flag : 1; // @link substring="cross_component_prediction_enabled_flag" target="#cross_component_prediction_enabled_flag"
///     uint32_t chroma_qp_offset_list_enabled_flag : 1; // @link substring="chroma_qp_offset_list_enabled_flag" target="#chroma_qp_offset_list_enabled_flag"
///     uint32_t pps_curr_pic_ref_enabled_flag : 1; // @link substring="pps_curr_pic_ref_enabled_flag" target="#pps_curr_pic_ref_enabled_flag"
///     uint32_t residual_adaptive_colour_transform_enabled_flag : 1; // @link substring="residual_adaptive_colour_transform_enabled_flag" target="#residual_adaptive_colour_transform_enabled_flag"
///     uint32_t pps_slice_act_qp_offsets_present_flag : 1; // @link substring="pps_slice_act_qp_offsets_present_flag" target="#pps_slice_act_qp_offsets_present_flag"
///     uint32_t pps_palette_predictor_initializers_present_flag : 1; // @link substring="pps_palette_predictor_initializers_present_flag" target="#pps_palette_predictor_initializers_present_flag"
///     uint32_t monochrome_palette_flag : 1; // @link substring="monochrome_palette_flag" target="#monochrome_palette_flag"
///     uint32_t pps_range_extension_flag : 1; // @link substring="pps_range_extension_flag" target="#pps_range_extension_flag"
/// } StdVideoH265PpsFlags;
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
public record StdVideoH265PpsFlags(@NotNull MemorySegment segment) implements IStdVideoH265PpsFlags {
    /// Represents a pointer to / an array of null structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link StdVideoH265PpsFlags}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IStdVideoH265PpsFlags to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code StdVideoH265PpsFlags.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IStdVideoH265PpsFlags, Iterable<StdVideoH265PpsFlags> {
        public long size() {
            return segment.byteSize() / StdVideoH265PpsFlags.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull StdVideoH265PpsFlags at(long index) {
            return new StdVideoH265PpsFlags(segment.asSlice(index * StdVideoH265PpsFlags.BYTES, StdVideoH265PpsFlags.BYTES));
        }

        public StdVideoH265PpsFlags.Ptr at(long index, @NotNull Consumer<@NotNull StdVideoH265PpsFlags> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull StdVideoH265PpsFlags value) {
            MemorySegment s = segment.asSlice(index * StdVideoH265PpsFlags.BYTES, StdVideoH265PpsFlags.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * StdVideoH265PpsFlags.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * StdVideoH265PpsFlags.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * StdVideoH265PpsFlags.BYTES,
                (end - start) * StdVideoH265PpsFlags.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * StdVideoH265PpsFlags.BYTES));
        }

        public StdVideoH265PpsFlags[] toArray() {
            StdVideoH265PpsFlags[] ret = new StdVideoH265PpsFlags[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<StdVideoH265PpsFlags> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<StdVideoH265PpsFlags> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= StdVideoH265PpsFlags.BYTES;
            }

            @Override
            public StdVideoH265PpsFlags next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                StdVideoH265PpsFlags ret = new StdVideoH265PpsFlags(segment.asSlice(0, StdVideoH265PpsFlags.BYTES));
                segment = segment.asSlice(StdVideoH265PpsFlags.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static StdVideoH265PpsFlags allocate(Arena arena) {
        return new StdVideoH265PpsFlags(arena.allocate(LAYOUT));
    }

    public static StdVideoH265PpsFlags.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        return new StdVideoH265PpsFlags.Ptr(segment);
    }

    public static StdVideoH265PpsFlags clone(Arena arena, StdVideoH265PpsFlags src) {
        StdVideoH265PpsFlags ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public boolean dependent_slice_segments_enabled_flag() {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$dependent_slice_segments_enabled_flag$pps_range_extension_flag, LAYOUT$bitfield$dependent_slice_segments_enabled_flag$pps_range_extension_flag);
        return BitfieldUtil.readBit(s, 0);
    }

    public StdVideoH265PpsFlags dependent_slice_segments_enabled_flag(boolean value) {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$dependent_slice_segments_enabled_flag$pps_range_extension_flag, LAYOUT$bitfield$dependent_slice_segments_enabled_flag$pps_range_extension_flag);
        BitfieldUtil.writeBit(s, 0, value);
        return this;
    }

    public boolean output_flag_present_flag() {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$dependent_slice_segments_enabled_flag$pps_range_extension_flag, LAYOUT$bitfield$dependent_slice_segments_enabled_flag$pps_range_extension_flag);
        return BitfieldUtil.readBit(s, 1);
    }

    public StdVideoH265PpsFlags output_flag_present_flag(boolean value) {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$dependent_slice_segments_enabled_flag$pps_range_extension_flag, LAYOUT$bitfield$dependent_slice_segments_enabled_flag$pps_range_extension_flag);
        BitfieldUtil.writeBit(s, 1, value);
        return this;
    }

    public boolean sign_data_hiding_enabled_flag() {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$dependent_slice_segments_enabled_flag$pps_range_extension_flag, LAYOUT$bitfield$dependent_slice_segments_enabled_flag$pps_range_extension_flag);
        return BitfieldUtil.readBit(s, 2);
    }

    public StdVideoH265PpsFlags sign_data_hiding_enabled_flag(boolean value) {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$dependent_slice_segments_enabled_flag$pps_range_extension_flag, LAYOUT$bitfield$dependent_slice_segments_enabled_flag$pps_range_extension_flag);
        BitfieldUtil.writeBit(s, 2, value);
        return this;
    }

    public boolean cabac_init_present_flag() {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$dependent_slice_segments_enabled_flag$pps_range_extension_flag, LAYOUT$bitfield$dependent_slice_segments_enabled_flag$pps_range_extension_flag);
        return BitfieldUtil.readBit(s, 3);
    }

    public StdVideoH265PpsFlags cabac_init_present_flag(boolean value) {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$dependent_slice_segments_enabled_flag$pps_range_extension_flag, LAYOUT$bitfield$dependent_slice_segments_enabled_flag$pps_range_extension_flag);
        BitfieldUtil.writeBit(s, 3, value);
        return this;
    }

    public boolean constrained_intra_pred_flag() {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$dependent_slice_segments_enabled_flag$pps_range_extension_flag, LAYOUT$bitfield$dependent_slice_segments_enabled_flag$pps_range_extension_flag);
        return BitfieldUtil.readBit(s, 4);
    }

    public StdVideoH265PpsFlags constrained_intra_pred_flag(boolean value) {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$dependent_slice_segments_enabled_flag$pps_range_extension_flag, LAYOUT$bitfield$dependent_slice_segments_enabled_flag$pps_range_extension_flag);
        BitfieldUtil.writeBit(s, 4, value);
        return this;
    }

    public boolean transform_skip_enabled_flag() {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$dependent_slice_segments_enabled_flag$pps_range_extension_flag, LAYOUT$bitfield$dependent_slice_segments_enabled_flag$pps_range_extension_flag);
        return BitfieldUtil.readBit(s, 5);
    }

    public StdVideoH265PpsFlags transform_skip_enabled_flag(boolean value) {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$dependent_slice_segments_enabled_flag$pps_range_extension_flag, LAYOUT$bitfield$dependent_slice_segments_enabled_flag$pps_range_extension_flag);
        BitfieldUtil.writeBit(s, 5, value);
        return this;
    }

    public boolean cu_qp_delta_enabled_flag() {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$dependent_slice_segments_enabled_flag$pps_range_extension_flag, LAYOUT$bitfield$dependent_slice_segments_enabled_flag$pps_range_extension_flag);
        return BitfieldUtil.readBit(s, 6);
    }

    public StdVideoH265PpsFlags cu_qp_delta_enabled_flag(boolean value) {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$dependent_slice_segments_enabled_flag$pps_range_extension_flag, LAYOUT$bitfield$dependent_slice_segments_enabled_flag$pps_range_extension_flag);
        BitfieldUtil.writeBit(s, 6, value);
        return this;
    }

    public boolean pps_slice_chroma_qp_offsets_present_flag() {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$dependent_slice_segments_enabled_flag$pps_range_extension_flag, LAYOUT$bitfield$dependent_slice_segments_enabled_flag$pps_range_extension_flag);
        return BitfieldUtil.readBit(s, 7);
    }

    public StdVideoH265PpsFlags pps_slice_chroma_qp_offsets_present_flag(boolean value) {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$dependent_slice_segments_enabled_flag$pps_range_extension_flag, LAYOUT$bitfield$dependent_slice_segments_enabled_flag$pps_range_extension_flag);
        BitfieldUtil.writeBit(s, 7, value);
        return this;
    }

    public boolean weighted_pred_flag() {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$dependent_slice_segments_enabled_flag$pps_range_extension_flag, LAYOUT$bitfield$dependent_slice_segments_enabled_flag$pps_range_extension_flag);
        return BitfieldUtil.readBit(s, 8);
    }

    public StdVideoH265PpsFlags weighted_pred_flag(boolean value) {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$dependent_slice_segments_enabled_flag$pps_range_extension_flag, LAYOUT$bitfield$dependent_slice_segments_enabled_flag$pps_range_extension_flag);
        BitfieldUtil.writeBit(s, 8, value);
        return this;
    }

    public boolean weighted_bipred_flag() {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$dependent_slice_segments_enabled_flag$pps_range_extension_flag, LAYOUT$bitfield$dependent_slice_segments_enabled_flag$pps_range_extension_flag);
        return BitfieldUtil.readBit(s, 9);
    }

    public StdVideoH265PpsFlags weighted_bipred_flag(boolean value) {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$dependent_slice_segments_enabled_flag$pps_range_extension_flag, LAYOUT$bitfield$dependent_slice_segments_enabled_flag$pps_range_extension_flag);
        BitfieldUtil.writeBit(s, 9, value);
        return this;
    }

    public boolean transquant_bypass_enabled_flag() {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$dependent_slice_segments_enabled_flag$pps_range_extension_flag, LAYOUT$bitfield$dependent_slice_segments_enabled_flag$pps_range_extension_flag);
        return BitfieldUtil.readBit(s, 10);
    }

    public StdVideoH265PpsFlags transquant_bypass_enabled_flag(boolean value) {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$dependent_slice_segments_enabled_flag$pps_range_extension_flag, LAYOUT$bitfield$dependent_slice_segments_enabled_flag$pps_range_extension_flag);
        BitfieldUtil.writeBit(s, 10, value);
        return this;
    }

    public boolean tiles_enabled_flag() {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$dependent_slice_segments_enabled_flag$pps_range_extension_flag, LAYOUT$bitfield$dependent_slice_segments_enabled_flag$pps_range_extension_flag);
        return BitfieldUtil.readBit(s, 11);
    }

    public StdVideoH265PpsFlags tiles_enabled_flag(boolean value) {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$dependent_slice_segments_enabled_flag$pps_range_extension_flag, LAYOUT$bitfield$dependent_slice_segments_enabled_flag$pps_range_extension_flag);
        BitfieldUtil.writeBit(s, 11, value);
        return this;
    }

    public boolean entropy_coding_sync_enabled_flag() {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$dependent_slice_segments_enabled_flag$pps_range_extension_flag, LAYOUT$bitfield$dependent_slice_segments_enabled_flag$pps_range_extension_flag);
        return BitfieldUtil.readBit(s, 12);
    }

    public StdVideoH265PpsFlags entropy_coding_sync_enabled_flag(boolean value) {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$dependent_slice_segments_enabled_flag$pps_range_extension_flag, LAYOUT$bitfield$dependent_slice_segments_enabled_flag$pps_range_extension_flag);
        BitfieldUtil.writeBit(s, 12, value);
        return this;
    }

    public boolean uniform_spacing_flag() {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$dependent_slice_segments_enabled_flag$pps_range_extension_flag, LAYOUT$bitfield$dependent_slice_segments_enabled_flag$pps_range_extension_flag);
        return BitfieldUtil.readBit(s, 13);
    }

    public StdVideoH265PpsFlags uniform_spacing_flag(boolean value) {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$dependent_slice_segments_enabled_flag$pps_range_extension_flag, LAYOUT$bitfield$dependent_slice_segments_enabled_flag$pps_range_extension_flag);
        BitfieldUtil.writeBit(s, 13, value);
        return this;
    }

    public boolean loop_filter_across_tiles_enabled_flag() {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$dependent_slice_segments_enabled_flag$pps_range_extension_flag, LAYOUT$bitfield$dependent_slice_segments_enabled_flag$pps_range_extension_flag);
        return BitfieldUtil.readBit(s, 14);
    }

    public StdVideoH265PpsFlags loop_filter_across_tiles_enabled_flag(boolean value) {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$dependent_slice_segments_enabled_flag$pps_range_extension_flag, LAYOUT$bitfield$dependent_slice_segments_enabled_flag$pps_range_extension_flag);
        BitfieldUtil.writeBit(s, 14, value);
        return this;
    }

    public boolean pps_loop_filter_across_slices_enabled_flag() {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$dependent_slice_segments_enabled_flag$pps_range_extension_flag, LAYOUT$bitfield$dependent_slice_segments_enabled_flag$pps_range_extension_flag);
        return BitfieldUtil.readBit(s, 15);
    }

    public StdVideoH265PpsFlags pps_loop_filter_across_slices_enabled_flag(boolean value) {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$dependent_slice_segments_enabled_flag$pps_range_extension_flag, LAYOUT$bitfield$dependent_slice_segments_enabled_flag$pps_range_extension_flag);
        BitfieldUtil.writeBit(s, 15, value);
        return this;
    }

    public boolean deblocking_filter_control_present_flag() {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$dependent_slice_segments_enabled_flag$pps_range_extension_flag, LAYOUT$bitfield$dependent_slice_segments_enabled_flag$pps_range_extension_flag);
        return BitfieldUtil.readBit(s, 16);
    }

    public StdVideoH265PpsFlags deblocking_filter_control_present_flag(boolean value) {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$dependent_slice_segments_enabled_flag$pps_range_extension_flag, LAYOUT$bitfield$dependent_slice_segments_enabled_flag$pps_range_extension_flag);
        BitfieldUtil.writeBit(s, 16, value);
        return this;
    }

    public boolean deblocking_filter_override_enabled_flag() {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$dependent_slice_segments_enabled_flag$pps_range_extension_flag, LAYOUT$bitfield$dependent_slice_segments_enabled_flag$pps_range_extension_flag);
        return BitfieldUtil.readBit(s, 17);
    }

    public StdVideoH265PpsFlags deblocking_filter_override_enabled_flag(boolean value) {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$dependent_slice_segments_enabled_flag$pps_range_extension_flag, LAYOUT$bitfield$dependent_slice_segments_enabled_flag$pps_range_extension_flag);
        BitfieldUtil.writeBit(s, 17, value);
        return this;
    }

    public boolean pps_deblocking_filter_disabled_flag() {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$dependent_slice_segments_enabled_flag$pps_range_extension_flag, LAYOUT$bitfield$dependent_slice_segments_enabled_flag$pps_range_extension_flag);
        return BitfieldUtil.readBit(s, 18);
    }

    public StdVideoH265PpsFlags pps_deblocking_filter_disabled_flag(boolean value) {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$dependent_slice_segments_enabled_flag$pps_range_extension_flag, LAYOUT$bitfield$dependent_slice_segments_enabled_flag$pps_range_extension_flag);
        BitfieldUtil.writeBit(s, 18, value);
        return this;
    }

    public boolean pps_scaling_list_data_present_flag() {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$dependent_slice_segments_enabled_flag$pps_range_extension_flag, LAYOUT$bitfield$dependent_slice_segments_enabled_flag$pps_range_extension_flag);
        return BitfieldUtil.readBit(s, 19);
    }

    public StdVideoH265PpsFlags pps_scaling_list_data_present_flag(boolean value) {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$dependent_slice_segments_enabled_flag$pps_range_extension_flag, LAYOUT$bitfield$dependent_slice_segments_enabled_flag$pps_range_extension_flag);
        BitfieldUtil.writeBit(s, 19, value);
        return this;
    }

    public boolean lists_modification_present_flag() {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$dependent_slice_segments_enabled_flag$pps_range_extension_flag, LAYOUT$bitfield$dependent_slice_segments_enabled_flag$pps_range_extension_flag);
        return BitfieldUtil.readBit(s, 20);
    }

    public StdVideoH265PpsFlags lists_modification_present_flag(boolean value) {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$dependent_slice_segments_enabled_flag$pps_range_extension_flag, LAYOUT$bitfield$dependent_slice_segments_enabled_flag$pps_range_extension_flag);
        BitfieldUtil.writeBit(s, 20, value);
        return this;
    }

    public boolean slice_segment_header_extension_present_flag() {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$dependent_slice_segments_enabled_flag$pps_range_extension_flag, LAYOUT$bitfield$dependent_slice_segments_enabled_flag$pps_range_extension_flag);
        return BitfieldUtil.readBit(s, 21);
    }

    public StdVideoH265PpsFlags slice_segment_header_extension_present_flag(boolean value) {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$dependent_slice_segments_enabled_flag$pps_range_extension_flag, LAYOUT$bitfield$dependent_slice_segments_enabled_flag$pps_range_extension_flag);
        BitfieldUtil.writeBit(s, 21, value);
        return this;
    }

    public boolean pps_extension_present_flag() {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$dependent_slice_segments_enabled_flag$pps_range_extension_flag, LAYOUT$bitfield$dependent_slice_segments_enabled_flag$pps_range_extension_flag);
        return BitfieldUtil.readBit(s, 22);
    }

    public StdVideoH265PpsFlags pps_extension_present_flag(boolean value) {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$dependent_slice_segments_enabled_flag$pps_range_extension_flag, LAYOUT$bitfield$dependent_slice_segments_enabled_flag$pps_range_extension_flag);
        BitfieldUtil.writeBit(s, 22, value);
        return this;
    }

    public boolean cross_component_prediction_enabled_flag() {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$dependent_slice_segments_enabled_flag$pps_range_extension_flag, LAYOUT$bitfield$dependent_slice_segments_enabled_flag$pps_range_extension_flag);
        return BitfieldUtil.readBit(s, 23);
    }

    public StdVideoH265PpsFlags cross_component_prediction_enabled_flag(boolean value) {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$dependent_slice_segments_enabled_flag$pps_range_extension_flag, LAYOUT$bitfield$dependent_slice_segments_enabled_flag$pps_range_extension_flag);
        BitfieldUtil.writeBit(s, 23, value);
        return this;
    }

    public boolean chroma_qp_offset_list_enabled_flag() {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$dependent_slice_segments_enabled_flag$pps_range_extension_flag, LAYOUT$bitfield$dependent_slice_segments_enabled_flag$pps_range_extension_flag);
        return BitfieldUtil.readBit(s, 24);
    }

    public StdVideoH265PpsFlags chroma_qp_offset_list_enabled_flag(boolean value) {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$dependent_slice_segments_enabled_flag$pps_range_extension_flag, LAYOUT$bitfield$dependent_slice_segments_enabled_flag$pps_range_extension_flag);
        BitfieldUtil.writeBit(s, 24, value);
        return this;
    }

    public boolean pps_curr_pic_ref_enabled_flag() {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$dependent_slice_segments_enabled_flag$pps_range_extension_flag, LAYOUT$bitfield$dependent_slice_segments_enabled_flag$pps_range_extension_flag);
        return BitfieldUtil.readBit(s, 25);
    }

    public StdVideoH265PpsFlags pps_curr_pic_ref_enabled_flag(boolean value) {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$dependent_slice_segments_enabled_flag$pps_range_extension_flag, LAYOUT$bitfield$dependent_slice_segments_enabled_flag$pps_range_extension_flag);
        BitfieldUtil.writeBit(s, 25, value);
        return this;
    }

    public boolean residual_adaptive_colour_transform_enabled_flag() {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$dependent_slice_segments_enabled_flag$pps_range_extension_flag, LAYOUT$bitfield$dependent_slice_segments_enabled_flag$pps_range_extension_flag);
        return BitfieldUtil.readBit(s, 26);
    }

    public StdVideoH265PpsFlags residual_adaptive_colour_transform_enabled_flag(boolean value) {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$dependent_slice_segments_enabled_flag$pps_range_extension_flag, LAYOUT$bitfield$dependent_slice_segments_enabled_flag$pps_range_extension_flag);
        BitfieldUtil.writeBit(s, 26, value);
        return this;
    }

    public boolean pps_slice_act_qp_offsets_present_flag() {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$dependent_slice_segments_enabled_flag$pps_range_extension_flag, LAYOUT$bitfield$dependent_slice_segments_enabled_flag$pps_range_extension_flag);
        return BitfieldUtil.readBit(s, 27);
    }

    public StdVideoH265PpsFlags pps_slice_act_qp_offsets_present_flag(boolean value) {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$dependent_slice_segments_enabled_flag$pps_range_extension_flag, LAYOUT$bitfield$dependent_slice_segments_enabled_flag$pps_range_extension_flag);
        BitfieldUtil.writeBit(s, 27, value);
        return this;
    }

    public boolean pps_palette_predictor_initializers_present_flag() {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$dependent_slice_segments_enabled_flag$pps_range_extension_flag, LAYOUT$bitfield$dependent_slice_segments_enabled_flag$pps_range_extension_flag);
        return BitfieldUtil.readBit(s, 28);
    }

    public StdVideoH265PpsFlags pps_palette_predictor_initializers_present_flag(boolean value) {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$dependent_slice_segments_enabled_flag$pps_range_extension_flag, LAYOUT$bitfield$dependent_slice_segments_enabled_flag$pps_range_extension_flag);
        BitfieldUtil.writeBit(s, 28, value);
        return this;
    }

    public boolean monochrome_palette_flag() {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$dependent_slice_segments_enabled_flag$pps_range_extension_flag, LAYOUT$bitfield$dependent_slice_segments_enabled_flag$pps_range_extension_flag);
        return BitfieldUtil.readBit(s, 29);
    }

    public StdVideoH265PpsFlags monochrome_palette_flag(boolean value) {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$dependent_slice_segments_enabled_flag$pps_range_extension_flag, LAYOUT$bitfield$dependent_slice_segments_enabled_flag$pps_range_extension_flag);
        BitfieldUtil.writeBit(s, 29, value);
        return this;
    }

    public boolean pps_range_extension_flag() {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$dependent_slice_segments_enabled_flag$pps_range_extension_flag, LAYOUT$bitfield$dependent_slice_segments_enabled_flag$pps_range_extension_flag);
        return BitfieldUtil.readBit(s, 30);
    }

    public StdVideoH265PpsFlags pps_range_extension_flag(boolean value) {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$dependent_slice_segments_enabled_flag$pps_range_extension_flag, LAYOUT$bitfield$dependent_slice_segments_enabled_flag$pps_range_extension_flag);
        BitfieldUtil.writeBit(s, 30, value);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("bitfield$dependent_slice_segments_enabled_flag$pps_range_extension_flag")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$bitfield$dependent_slice_segments_enabled_flag$pps_range_extension_flag = PathElement.groupElement("dependent_slice_segments_enabled_flag$pps_range_extension_flag");

    public static final OfInt LAYOUT$bitfield$dependent_slice_segments_enabled_flag$pps_range_extension_flag = (OfInt) LAYOUT.select(PATH$bitfield$dependent_slice_segments_enabled_flag$pps_range_extension_flag);


    public static final long OFFSET$bitfield$dependent_slice_segments_enabled_flag$pps_range_extension_flag = LAYOUT.byteOffset(PATH$bitfield$dependent_slice_segments_enabled_flag$pps_range_extension_flag);
}
