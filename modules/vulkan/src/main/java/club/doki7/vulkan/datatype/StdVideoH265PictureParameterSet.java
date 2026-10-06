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

/// Represents a pointer to a {@code StdVideoH265PictureParameterSet} structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct StdVideoH265PictureParameterSet {
///     StdVideoH265PpsFlags flags; // @link substring="StdVideoH265PpsFlags" target="StdVideoH265PpsFlags" @link substring="flags" target="#flags"
///     uint8_t pps_pic_parameter_set_id; // @link substring="pps_pic_parameter_set_id" target="#pps_pic_parameter_set_id"
///     uint8_t pps_seq_parameter_set_id; // @link substring="pps_seq_parameter_set_id" target="#pps_seq_parameter_set_id"
///     uint8_t sps_video_parameter_set_id; // @link substring="sps_video_parameter_set_id" target="#sps_video_parameter_set_id"
///     uint8_t num_extra_slice_header_bits; // @link substring="num_extra_slice_header_bits" target="#num_extra_slice_header_bits"
///     uint8_t num_ref_idx_l0_default_active_minus1; // @link substring="num_ref_idx_l0_default_active_minus1" target="#num_ref_idx_l0_default_active_minus1"
///     uint8_t num_ref_idx_l1_default_active_minus1; // @link substring="num_ref_idx_l1_default_active_minus1" target="#num_ref_idx_l1_default_active_minus1"
///     int8_t init_qp_minus26; // @link substring="init_qp_minus26" target="#init_qp_minus26"
///     uint8_t diff_cu_qp_delta_depth; // @link substring="diff_cu_qp_delta_depth" target="#diff_cu_qp_delta_depth"
///     int8_t pps_cb_qp_offset; // @link substring="pps_cb_qp_offset" target="#pps_cb_qp_offset"
///     int8_t pps_cr_qp_offset; // @link substring="pps_cr_qp_offset" target="#pps_cr_qp_offset"
///     int8_t pps_beta_offset_div2; // @link substring="pps_beta_offset_div2" target="#pps_beta_offset_div2"
///     int8_t pps_tc_offset_div2; // @link substring="pps_tc_offset_div2" target="#pps_tc_offset_div2"
///     uint8_t log2_parallel_merge_level_minus2; // @link substring="log2_parallel_merge_level_minus2" target="#log2_parallel_merge_level_minus2"
///     uint8_t log2_max_transform_skip_block_size_minus2; // @link substring="log2_max_transform_skip_block_size_minus2" target="#log2_max_transform_skip_block_size_minus2"
///     uint8_t diff_cu_chroma_qp_offset_depth; // @link substring="diff_cu_chroma_qp_offset_depth" target="#diff_cu_chroma_qp_offset_depth"
///     uint8_t chroma_qp_offset_list_len_minus1; // @link substring="chroma_qp_offset_list_len_minus1" target="#chroma_qp_offset_list_len_minus1"
///     int8_t[STD_VIDEO_H265_CHROMA_QP_OFFSET_LIST_SIZE] cb_qp_offset_list; // @link substring="cb_qp_offset_list" target="#cb_qp_offset_list"
///     int8_t[STD_VIDEO_H265_CHROMA_QP_OFFSET_LIST_SIZE] cr_qp_offset_list; // @link substring="cr_qp_offset_list" target="#cr_qp_offset_list"
///     uint8_t log2_sao_offset_scale_luma; // @link substring="log2_sao_offset_scale_luma" target="#log2_sao_offset_scale_luma"
///     uint8_t log2_sao_offset_scale_chroma; // @link substring="log2_sao_offset_scale_chroma" target="#log2_sao_offset_scale_chroma"
///     int8_t pps_act_y_qp_offset_plus5; // @link substring="pps_act_y_qp_offset_plus5" target="#pps_act_y_qp_offset_plus5"
///     int8_t pps_act_cb_qp_offset_plus5; // @link substring="pps_act_cb_qp_offset_plus5" target="#pps_act_cb_qp_offset_plus5"
///     int8_t pps_act_cr_qp_offset_plus3; // @link substring="pps_act_cr_qp_offset_plus3" target="#pps_act_cr_qp_offset_plus3"
///     uint8_t pps_num_palette_predictor_initializers; // @link substring="pps_num_palette_predictor_initializers" target="#pps_num_palette_predictor_initializers"
///     uint8_t luma_bit_depth_entry_minus8; // @link substring="luma_bit_depth_entry_minus8" target="#luma_bit_depth_entry_minus8"
///     uint8_t chroma_bit_depth_entry_minus8; // @link substring="chroma_bit_depth_entry_minus8" target="#chroma_bit_depth_entry_minus8"
///     uint8_t num_tile_columns_minus1; // @link substring="num_tile_columns_minus1" target="#num_tile_columns_minus1"
///     uint8_t num_tile_rows_minus1; // @link substring="num_tile_rows_minus1" target="#num_tile_rows_minus1"
///     uint8_t reserved1;
///     uint8_t reserved2;
///     uint16_t[STD_VIDEO_H265_CHROMA_QP_OFFSET_TILE_COLS_LIST_SIZE] column_width_minus1; // @link substring="column_width_minus1" target="#column_width_minus1"
///     uint16_t[STD_VIDEO_H265_CHROMA_QP_OFFSET_TILE_ROWS_LIST_SIZE] row_height_minus1; // @link substring="row_height_minus1" target="#row_height_minus1"
///     uint32_t reserved3;
///     StdVideoH265ScalingLists const* pScalingLists; // optional // @link substring="StdVideoH265ScalingLists" target="StdVideoH265ScalingLists" @link substring="pScalingLists" target="#pScalingLists"
///     StdVideoH265PredictorPaletteEntries const* pPredictorPaletteEntries; // optional // @link substring="StdVideoH265PredictorPaletteEntries" target="StdVideoH265PredictorPaletteEntries" @link substring="pPredictorPaletteEntries" target="#pPredictorPaletteEntries"
/// } StdVideoH265PictureParameterSet;
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
public record StdVideoH265PictureParameterSet(@NotNull MemorySegment segment) implements IStdVideoH265PictureParameterSet {
    /// Represents a pointer to / an array of null structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link StdVideoH265PictureParameterSet}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IStdVideoH265PictureParameterSet to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code StdVideoH265PictureParameterSet.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IStdVideoH265PictureParameterSet, Iterable<StdVideoH265PictureParameterSet> {
        public long size() {
            return segment.byteSize() / StdVideoH265PictureParameterSet.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull StdVideoH265PictureParameterSet at(long index) {
            return new StdVideoH265PictureParameterSet(segment.asSlice(index * StdVideoH265PictureParameterSet.BYTES, StdVideoH265PictureParameterSet.BYTES));
        }

        public StdVideoH265PictureParameterSet.Ptr at(long index, @NotNull Consumer<@NotNull StdVideoH265PictureParameterSet> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull StdVideoH265PictureParameterSet value) {
            MemorySegment s = segment.asSlice(index * StdVideoH265PictureParameterSet.BYTES, StdVideoH265PictureParameterSet.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * StdVideoH265PictureParameterSet.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * StdVideoH265PictureParameterSet.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * StdVideoH265PictureParameterSet.BYTES,
                (end - start) * StdVideoH265PictureParameterSet.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * StdVideoH265PictureParameterSet.BYTES));
        }

        public StdVideoH265PictureParameterSet[] toArray() {
            StdVideoH265PictureParameterSet[] ret = new StdVideoH265PictureParameterSet[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<StdVideoH265PictureParameterSet> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<StdVideoH265PictureParameterSet> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= StdVideoH265PictureParameterSet.BYTES;
            }

            @Override
            public StdVideoH265PictureParameterSet next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                StdVideoH265PictureParameterSet ret = new StdVideoH265PictureParameterSet(segment.asSlice(0, StdVideoH265PictureParameterSet.BYTES));
                segment = segment.asSlice(StdVideoH265PictureParameterSet.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static StdVideoH265PictureParameterSet allocate(Arena arena) {
        return new StdVideoH265PictureParameterSet(arena.allocate(LAYOUT));
    }

    public static StdVideoH265PictureParameterSet.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        return new StdVideoH265PictureParameterSet.Ptr(segment);
    }

    public static StdVideoH265PictureParameterSet clone(Arena arena, StdVideoH265PictureParameterSet src) {
        StdVideoH265PictureParameterSet ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public @NotNull StdVideoH265PpsFlags flags() {
        return new StdVideoH265PpsFlags(segment.asSlice(OFFSET$flags, LAYOUT$flags));
    }

    public StdVideoH265PictureParameterSet flags(@NotNull StdVideoH265PpsFlags value) {
        MemorySegment.copy(value.segment(), 0, segment, OFFSET$flags, SIZE$flags);
        return this;
    }

    public StdVideoH265PictureParameterSet flags(Consumer<@NotNull StdVideoH265PpsFlags> consumer) {
        consumer.accept(flags());
        return this;
    }

    public @Unsigned byte pps_pic_parameter_set_id() {
        return segment.get(LAYOUT$pps_pic_parameter_set_id, OFFSET$pps_pic_parameter_set_id);
    }

    public StdVideoH265PictureParameterSet pps_pic_parameter_set_id(@Unsigned byte value) {
        segment.set(LAYOUT$pps_pic_parameter_set_id, OFFSET$pps_pic_parameter_set_id, value);
        return this;
    }

    public @Unsigned byte pps_seq_parameter_set_id() {
        return segment.get(LAYOUT$pps_seq_parameter_set_id, OFFSET$pps_seq_parameter_set_id);
    }

    public StdVideoH265PictureParameterSet pps_seq_parameter_set_id(@Unsigned byte value) {
        segment.set(LAYOUT$pps_seq_parameter_set_id, OFFSET$pps_seq_parameter_set_id, value);
        return this;
    }

    public @Unsigned byte sps_video_parameter_set_id() {
        return segment.get(LAYOUT$sps_video_parameter_set_id, OFFSET$sps_video_parameter_set_id);
    }

    public StdVideoH265PictureParameterSet sps_video_parameter_set_id(@Unsigned byte value) {
        segment.set(LAYOUT$sps_video_parameter_set_id, OFFSET$sps_video_parameter_set_id, value);
        return this;
    }

    public @Unsigned byte num_extra_slice_header_bits() {
        return segment.get(LAYOUT$num_extra_slice_header_bits, OFFSET$num_extra_slice_header_bits);
    }

    public StdVideoH265PictureParameterSet num_extra_slice_header_bits(@Unsigned byte value) {
        segment.set(LAYOUT$num_extra_slice_header_bits, OFFSET$num_extra_slice_header_bits, value);
        return this;
    }

    public @Unsigned byte num_ref_idx_l0_default_active_minus1() {
        return segment.get(LAYOUT$num_ref_idx_l0_default_active_minus1, OFFSET$num_ref_idx_l0_default_active_minus1);
    }

    public StdVideoH265PictureParameterSet num_ref_idx_l0_default_active_minus1(@Unsigned byte value) {
        segment.set(LAYOUT$num_ref_idx_l0_default_active_minus1, OFFSET$num_ref_idx_l0_default_active_minus1, value);
        return this;
    }

    public @Unsigned byte num_ref_idx_l1_default_active_minus1() {
        return segment.get(LAYOUT$num_ref_idx_l1_default_active_minus1, OFFSET$num_ref_idx_l1_default_active_minus1);
    }

    public StdVideoH265PictureParameterSet num_ref_idx_l1_default_active_minus1(@Unsigned byte value) {
        segment.set(LAYOUT$num_ref_idx_l1_default_active_minus1, OFFSET$num_ref_idx_l1_default_active_minus1, value);
        return this;
    }

    public byte init_qp_minus26() {
        return segment.get(LAYOUT$init_qp_minus26, OFFSET$init_qp_minus26);
    }

    public StdVideoH265PictureParameterSet init_qp_minus26(byte value) {
        segment.set(LAYOUT$init_qp_minus26, OFFSET$init_qp_minus26, value);
        return this;
    }

    public @Unsigned byte diff_cu_qp_delta_depth() {
        return segment.get(LAYOUT$diff_cu_qp_delta_depth, OFFSET$diff_cu_qp_delta_depth);
    }

    public StdVideoH265PictureParameterSet diff_cu_qp_delta_depth(@Unsigned byte value) {
        segment.set(LAYOUT$diff_cu_qp_delta_depth, OFFSET$diff_cu_qp_delta_depth, value);
        return this;
    }

    public byte pps_cb_qp_offset() {
        return segment.get(LAYOUT$pps_cb_qp_offset, OFFSET$pps_cb_qp_offset);
    }

    public StdVideoH265PictureParameterSet pps_cb_qp_offset(byte value) {
        segment.set(LAYOUT$pps_cb_qp_offset, OFFSET$pps_cb_qp_offset, value);
        return this;
    }

    public byte pps_cr_qp_offset() {
        return segment.get(LAYOUT$pps_cr_qp_offset, OFFSET$pps_cr_qp_offset);
    }

    public StdVideoH265PictureParameterSet pps_cr_qp_offset(byte value) {
        segment.set(LAYOUT$pps_cr_qp_offset, OFFSET$pps_cr_qp_offset, value);
        return this;
    }

    public byte pps_beta_offset_div2() {
        return segment.get(LAYOUT$pps_beta_offset_div2, OFFSET$pps_beta_offset_div2);
    }

    public StdVideoH265PictureParameterSet pps_beta_offset_div2(byte value) {
        segment.set(LAYOUT$pps_beta_offset_div2, OFFSET$pps_beta_offset_div2, value);
        return this;
    }

    public byte pps_tc_offset_div2() {
        return segment.get(LAYOUT$pps_tc_offset_div2, OFFSET$pps_tc_offset_div2);
    }

    public StdVideoH265PictureParameterSet pps_tc_offset_div2(byte value) {
        segment.set(LAYOUT$pps_tc_offset_div2, OFFSET$pps_tc_offset_div2, value);
        return this;
    }

    public @Unsigned byte log2_parallel_merge_level_minus2() {
        return segment.get(LAYOUT$log2_parallel_merge_level_minus2, OFFSET$log2_parallel_merge_level_minus2);
    }

    public StdVideoH265PictureParameterSet log2_parallel_merge_level_minus2(@Unsigned byte value) {
        segment.set(LAYOUT$log2_parallel_merge_level_minus2, OFFSET$log2_parallel_merge_level_minus2, value);
        return this;
    }

    public @Unsigned byte log2_max_transform_skip_block_size_minus2() {
        return segment.get(LAYOUT$log2_max_transform_skip_block_size_minus2, OFFSET$log2_max_transform_skip_block_size_minus2);
    }

    public StdVideoH265PictureParameterSet log2_max_transform_skip_block_size_minus2(@Unsigned byte value) {
        segment.set(LAYOUT$log2_max_transform_skip_block_size_minus2, OFFSET$log2_max_transform_skip_block_size_minus2, value);
        return this;
    }

    public @Unsigned byte diff_cu_chroma_qp_offset_depth() {
        return segment.get(LAYOUT$diff_cu_chroma_qp_offset_depth, OFFSET$diff_cu_chroma_qp_offset_depth);
    }

    public StdVideoH265PictureParameterSet diff_cu_chroma_qp_offset_depth(@Unsigned byte value) {
        segment.set(LAYOUT$diff_cu_chroma_qp_offset_depth, OFFSET$diff_cu_chroma_qp_offset_depth, value);
        return this;
    }

    public @Unsigned byte chroma_qp_offset_list_len_minus1() {
        return segment.get(LAYOUT$chroma_qp_offset_list_len_minus1, OFFSET$chroma_qp_offset_list_len_minus1);
    }

    public StdVideoH265PictureParameterSet chroma_qp_offset_list_len_minus1(@Unsigned byte value) {
        segment.set(LAYOUT$chroma_qp_offset_list_len_minus1, OFFSET$chroma_qp_offset_list_len_minus1, value);
        return this;
    }

    public BytePtr cb_qp_offset_list() {
        return new BytePtr(cb_qp_offset_listRaw());
    }

    public StdVideoH265PictureParameterSet cb_qp_offset_list(@NotNull Consumer<BytePtr> consumer) {
        BytePtr ptr = cb_qp_offset_list();
        consumer.accept(ptr);
        return this;
    }

    public StdVideoH265PictureParameterSet cb_qp_offset_list(BytePtr value) {
        MemorySegment s = cb_qp_offset_listRaw();
        s.copyFrom(value.segment());
        return this;
    }

    public @NotNull MemorySegment cb_qp_offset_listRaw() {
        return segment.asSlice(OFFSET$cb_qp_offset_list, SIZE$cb_qp_offset_list);
    }

    public BytePtr cr_qp_offset_list() {
        return new BytePtr(cr_qp_offset_listRaw());
    }

    public StdVideoH265PictureParameterSet cr_qp_offset_list(@NotNull Consumer<BytePtr> consumer) {
        BytePtr ptr = cr_qp_offset_list();
        consumer.accept(ptr);
        return this;
    }

    public StdVideoH265PictureParameterSet cr_qp_offset_list(BytePtr value) {
        MemorySegment s = cr_qp_offset_listRaw();
        s.copyFrom(value.segment());
        return this;
    }

    public @NotNull MemorySegment cr_qp_offset_listRaw() {
        return segment.asSlice(OFFSET$cr_qp_offset_list, SIZE$cr_qp_offset_list);
    }

    public @Unsigned byte log2_sao_offset_scale_luma() {
        return segment.get(LAYOUT$log2_sao_offset_scale_luma, OFFSET$log2_sao_offset_scale_luma);
    }

    public StdVideoH265PictureParameterSet log2_sao_offset_scale_luma(@Unsigned byte value) {
        segment.set(LAYOUT$log2_sao_offset_scale_luma, OFFSET$log2_sao_offset_scale_luma, value);
        return this;
    }

    public @Unsigned byte log2_sao_offset_scale_chroma() {
        return segment.get(LAYOUT$log2_sao_offset_scale_chroma, OFFSET$log2_sao_offset_scale_chroma);
    }

    public StdVideoH265PictureParameterSet log2_sao_offset_scale_chroma(@Unsigned byte value) {
        segment.set(LAYOUT$log2_sao_offset_scale_chroma, OFFSET$log2_sao_offset_scale_chroma, value);
        return this;
    }

    public byte pps_act_y_qp_offset_plus5() {
        return segment.get(LAYOUT$pps_act_y_qp_offset_plus5, OFFSET$pps_act_y_qp_offset_plus5);
    }

    public StdVideoH265PictureParameterSet pps_act_y_qp_offset_plus5(byte value) {
        segment.set(LAYOUT$pps_act_y_qp_offset_plus5, OFFSET$pps_act_y_qp_offset_plus5, value);
        return this;
    }

    public byte pps_act_cb_qp_offset_plus5() {
        return segment.get(LAYOUT$pps_act_cb_qp_offset_plus5, OFFSET$pps_act_cb_qp_offset_plus5);
    }

    public StdVideoH265PictureParameterSet pps_act_cb_qp_offset_plus5(byte value) {
        segment.set(LAYOUT$pps_act_cb_qp_offset_plus5, OFFSET$pps_act_cb_qp_offset_plus5, value);
        return this;
    }

    public byte pps_act_cr_qp_offset_plus3() {
        return segment.get(LAYOUT$pps_act_cr_qp_offset_plus3, OFFSET$pps_act_cr_qp_offset_plus3);
    }

    public StdVideoH265PictureParameterSet pps_act_cr_qp_offset_plus3(byte value) {
        segment.set(LAYOUT$pps_act_cr_qp_offset_plus3, OFFSET$pps_act_cr_qp_offset_plus3, value);
        return this;
    }

    public @Unsigned byte pps_num_palette_predictor_initializers() {
        return segment.get(LAYOUT$pps_num_palette_predictor_initializers, OFFSET$pps_num_palette_predictor_initializers);
    }

    public StdVideoH265PictureParameterSet pps_num_palette_predictor_initializers(@Unsigned byte value) {
        segment.set(LAYOUT$pps_num_palette_predictor_initializers, OFFSET$pps_num_palette_predictor_initializers, value);
        return this;
    }

    public @Unsigned byte luma_bit_depth_entry_minus8() {
        return segment.get(LAYOUT$luma_bit_depth_entry_minus8, OFFSET$luma_bit_depth_entry_minus8);
    }

    public StdVideoH265PictureParameterSet luma_bit_depth_entry_minus8(@Unsigned byte value) {
        segment.set(LAYOUT$luma_bit_depth_entry_minus8, OFFSET$luma_bit_depth_entry_minus8, value);
        return this;
    }

    public @Unsigned byte chroma_bit_depth_entry_minus8() {
        return segment.get(LAYOUT$chroma_bit_depth_entry_minus8, OFFSET$chroma_bit_depth_entry_minus8);
    }

    public StdVideoH265PictureParameterSet chroma_bit_depth_entry_minus8(@Unsigned byte value) {
        segment.set(LAYOUT$chroma_bit_depth_entry_minus8, OFFSET$chroma_bit_depth_entry_minus8, value);
        return this;
    }

    public @Unsigned byte num_tile_columns_minus1() {
        return segment.get(LAYOUT$num_tile_columns_minus1, OFFSET$num_tile_columns_minus1);
    }

    public StdVideoH265PictureParameterSet num_tile_columns_minus1(@Unsigned byte value) {
        segment.set(LAYOUT$num_tile_columns_minus1, OFFSET$num_tile_columns_minus1, value);
        return this;
    }

    public @Unsigned byte num_tile_rows_minus1() {
        return segment.get(LAYOUT$num_tile_rows_minus1, OFFSET$num_tile_rows_minus1);
    }

    public StdVideoH265PictureParameterSet num_tile_rows_minus1(@Unsigned byte value) {
        segment.set(LAYOUT$num_tile_rows_minus1, OFFSET$num_tile_rows_minus1, value);
        return this;
    }



    public @Unsigned ShortPtr column_width_minus1() {
        return new ShortPtr(column_width_minus1Raw());
    }

    public StdVideoH265PictureParameterSet column_width_minus1(@NotNull Consumer<ShortPtr> consumer) {
        @Unsigned ShortPtr ptr = column_width_minus1();
        consumer.accept(ptr);
        return this;
    }

    public StdVideoH265PictureParameterSet column_width_minus1(@Unsigned ShortPtr value) {
        MemorySegment s = column_width_minus1Raw();
        s.copyFrom(value.segment());
        return this;
    }

    public @NotNull MemorySegment column_width_minus1Raw() {
        return segment.asSlice(OFFSET$column_width_minus1, SIZE$column_width_minus1);
    }

    public @Unsigned ShortPtr row_height_minus1() {
        return new ShortPtr(row_height_minus1Raw());
    }

    public StdVideoH265PictureParameterSet row_height_minus1(@NotNull Consumer<ShortPtr> consumer) {
        @Unsigned ShortPtr ptr = row_height_minus1();
        consumer.accept(ptr);
        return this;
    }

    public StdVideoH265PictureParameterSet row_height_minus1(@Unsigned ShortPtr value) {
        MemorySegment s = row_height_minus1Raw();
        s.copyFrom(value.segment());
        return this;
    }

    public @NotNull MemorySegment row_height_minus1Raw() {
        return segment.asSlice(OFFSET$row_height_minus1, SIZE$row_height_minus1);
    }


    public StdVideoH265PictureParameterSet pScalingLists(@Nullable IStdVideoH265ScalingLists value) {
        MemorySegment s = value == null ? MemorySegment.NULL : value.segment();
        pScalingListsRaw(s);
        return this;
    }

    @Unsafe public @Nullable StdVideoH265ScalingLists.Ptr pScalingLists(int assumedCount) {
        MemorySegment s = pScalingListsRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }

        s = s.reinterpret(assumedCount * StdVideoH265ScalingLists.BYTES);
        return new StdVideoH265ScalingLists.Ptr(s);
    }

    public @Nullable StdVideoH265ScalingLists pScalingLists() {
        MemorySegment s = pScalingListsRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new StdVideoH265ScalingLists(s);
    }

    public @Pointer(target=StdVideoH265ScalingLists.class) @NotNull MemorySegment pScalingListsRaw() {
        return segment.get(LAYOUT$pScalingLists, OFFSET$pScalingLists);
    }

    public void pScalingListsRaw(@Pointer(target=StdVideoH265ScalingLists.class) @NotNull MemorySegment value) {
        segment.set(LAYOUT$pScalingLists, OFFSET$pScalingLists, value);
    }

    public StdVideoH265PictureParameterSet pPredictorPaletteEntries(@Nullable IStdVideoH265PredictorPaletteEntries value) {
        MemorySegment s = value == null ? MemorySegment.NULL : value.segment();
        pPredictorPaletteEntriesRaw(s);
        return this;
    }

    @Unsafe public @Nullable StdVideoH265PredictorPaletteEntries.Ptr pPredictorPaletteEntries(int assumedCount) {
        MemorySegment s = pPredictorPaletteEntriesRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }

        s = s.reinterpret(assumedCount * StdVideoH265PredictorPaletteEntries.BYTES);
        return new StdVideoH265PredictorPaletteEntries.Ptr(s);
    }

    public @Nullable StdVideoH265PredictorPaletteEntries pPredictorPaletteEntries() {
        MemorySegment s = pPredictorPaletteEntriesRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new StdVideoH265PredictorPaletteEntries(s);
    }

    public @Pointer(target=StdVideoH265PredictorPaletteEntries.class) @NotNull MemorySegment pPredictorPaletteEntriesRaw() {
        return segment.get(LAYOUT$pPredictorPaletteEntries, OFFSET$pPredictorPaletteEntries);
    }

    public void pPredictorPaletteEntriesRaw(@Pointer(target=StdVideoH265PredictorPaletteEntries.class) @NotNull MemorySegment value) {
        segment.set(LAYOUT$pPredictorPaletteEntries, OFFSET$pPredictorPaletteEntries, value);
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        StdVideoH265PpsFlags.LAYOUT.withName("flags"),
        ValueLayout.JAVA_BYTE.withName("pps_pic_parameter_set_id"),
        ValueLayout.JAVA_BYTE.withName("pps_seq_parameter_set_id"),
        ValueLayout.JAVA_BYTE.withName("sps_video_parameter_set_id"),
        ValueLayout.JAVA_BYTE.withName("num_extra_slice_header_bits"),
        ValueLayout.JAVA_BYTE.withName("num_ref_idx_l0_default_active_minus1"),
        ValueLayout.JAVA_BYTE.withName("num_ref_idx_l1_default_active_minus1"),
        ValueLayout.JAVA_BYTE.withName("init_qp_minus26"),
        ValueLayout.JAVA_BYTE.withName("diff_cu_qp_delta_depth"),
        ValueLayout.JAVA_BYTE.withName("pps_cb_qp_offset"),
        ValueLayout.JAVA_BYTE.withName("pps_cr_qp_offset"),
        ValueLayout.JAVA_BYTE.withName("pps_beta_offset_div2"),
        ValueLayout.JAVA_BYTE.withName("pps_tc_offset_div2"),
        ValueLayout.JAVA_BYTE.withName("log2_parallel_merge_level_minus2"),
        ValueLayout.JAVA_BYTE.withName("log2_max_transform_skip_block_size_minus2"),
        ValueLayout.JAVA_BYTE.withName("diff_cu_chroma_qp_offset_depth"),
        ValueLayout.JAVA_BYTE.withName("chroma_qp_offset_list_len_minus1"),
        MemoryLayout.sequenceLayout(H265_CHROMA_QP_OFFSET_LIST_SIZE, ValueLayout.JAVA_BYTE).withName("cb_qp_offset_list"),
        MemoryLayout.sequenceLayout(H265_CHROMA_QP_OFFSET_LIST_SIZE, ValueLayout.JAVA_BYTE).withName("cr_qp_offset_list"),
        ValueLayout.JAVA_BYTE.withName("log2_sao_offset_scale_luma"),
        ValueLayout.JAVA_BYTE.withName("log2_sao_offset_scale_chroma"),
        ValueLayout.JAVA_BYTE.withName("pps_act_y_qp_offset_plus5"),
        ValueLayout.JAVA_BYTE.withName("pps_act_cb_qp_offset_plus5"),
        ValueLayout.JAVA_BYTE.withName("pps_act_cr_qp_offset_plus3"),
        ValueLayout.JAVA_BYTE.withName("pps_num_palette_predictor_initializers"),
        ValueLayout.JAVA_BYTE.withName("luma_bit_depth_entry_minus8"),
        ValueLayout.JAVA_BYTE.withName("chroma_bit_depth_entry_minus8"),
        ValueLayout.JAVA_BYTE.withName("num_tile_columns_minus1"),
        ValueLayout.JAVA_BYTE.withName("num_tile_rows_minus1"),
        ValueLayout.JAVA_BYTE.withName("reserved1"),
        ValueLayout.JAVA_BYTE.withName("reserved2"),
        MemoryLayout.sequenceLayout(H265_CHROMA_QP_OFFSET_TILE_COLS_LIST_SIZE, ValueLayout.JAVA_SHORT).withName("column_width_minus1"),
        MemoryLayout.sequenceLayout(H265_CHROMA_QP_OFFSET_TILE_ROWS_LIST_SIZE, ValueLayout.JAVA_SHORT).withName("row_height_minus1"),
        ValueLayout.JAVA_INT.withName("reserved3"),
        ValueLayout.ADDRESS.withTargetLayout(StdVideoH265ScalingLists.LAYOUT).withName("pScalingLists"),
        ValueLayout.ADDRESS.withTargetLayout(StdVideoH265PredictorPaletteEntries.LAYOUT).withName("pPredictorPaletteEntries")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$flags = PathElement.groupElement("flags");
    public static final PathElement PATH$pps_pic_parameter_set_id = PathElement.groupElement("pps_pic_parameter_set_id");
    public static final PathElement PATH$pps_seq_parameter_set_id = PathElement.groupElement("pps_seq_parameter_set_id");
    public static final PathElement PATH$sps_video_parameter_set_id = PathElement.groupElement("sps_video_parameter_set_id");
    public static final PathElement PATH$num_extra_slice_header_bits = PathElement.groupElement("num_extra_slice_header_bits");
    public static final PathElement PATH$num_ref_idx_l0_default_active_minus1 = PathElement.groupElement("num_ref_idx_l0_default_active_minus1");
    public static final PathElement PATH$num_ref_idx_l1_default_active_minus1 = PathElement.groupElement("num_ref_idx_l1_default_active_minus1");
    public static final PathElement PATH$init_qp_minus26 = PathElement.groupElement("init_qp_minus26");
    public static final PathElement PATH$diff_cu_qp_delta_depth = PathElement.groupElement("diff_cu_qp_delta_depth");
    public static final PathElement PATH$pps_cb_qp_offset = PathElement.groupElement("pps_cb_qp_offset");
    public static final PathElement PATH$pps_cr_qp_offset = PathElement.groupElement("pps_cr_qp_offset");
    public static final PathElement PATH$pps_beta_offset_div2 = PathElement.groupElement("pps_beta_offset_div2");
    public static final PathElement PATH$pps_tc_offset_div2 = PathElement.groupElement("pps_tc_offset_div2");
    public static final PathElement PATH$log2_parallel_merge_level_minus2 = PathElement.groupElement("log2_parallel_merge_level_minus2");
    public static final PathElement PATH$log2_max_transform_skip_block_size_minus2 = PathElement.groupElement("log2_max_transform_skip_block_size_minus2");
    public static final PathElement PATH$diff_cu_chroma_qp_offset_depth = PathElement.groupElement("diff_cu_chroma_qp_offset_depth");
    public static final PathElement PATH$chroma_qp_offset_list_len_minus1 = PathElement.groupElement("chroma_qp_offset_list_len_minus1");
    public static final PathElement PATH$cb_qp_offset_list = PathElement.groupElement("cb_qp_offset_list");
    public static final PathElement PATH$cr_qp_offset_list = PathElement.groupElement("cr_qp_offset_list");
    public static final PathElement PATH$log2_sao_offset_scale_luma = PathElement.groupElement("log2_sao_offset_scale_luma");
    public static final PathElement PATH$log2_sao_offset_scale_chroma = PathElement.groupElement("log2_sao_offset_scale_chroma");
    public static final PathElement PATH$pps_act_y_qp_offset_plus5 = PathElement.groupElement("pps_act_y_qp_offset_plus5");
    public static final PathElement PATH$pps_act_cb_qp_offset_plus5 = PathElement.groupElement("pps_act_cb_qp_offset_plus5");
    public static final PathElement PATH$pps_act_cr_qp_offset_plus3 = PathElement.groupElement("pps_act_cr_qp_offset_plus3");
    public static final PathElement PATH$pps_num_palette_predictor_initializers = PathElement.groupElement("pps_num_palette_predictor_initializers");
    public static final PathElement PATH$luma_bit_depth_entry_minus8 = PathElement.groupElement("luma_bit_depth_entry_minus8");
    public static final PathElement PATH$chroma_bit_depth_entry_minus8 = PathElement.groupElement("chroma_bit_depth_entry_minus8");
    public static final PathElement PATH$num_tile_columns_minus1 = PathElement.groupElement("num_tile_columns_minus1");
    public static final PathElement PATH$num_tile_rows_minus1 = PathElement.groupElement("num_tile_rows_minus1");
    public static final PathElement PATH$column_width_minus1 = PathElement.groupElement("column_width_minus1");
    public static final PathElement PATH$row_height_minus1 = PathElement.groupElement("row_height_minus1");
    public static final PathElement PATH$pScalingLists = PathElement.groupElement("pScalingLists");
    public static final PathElement PATH$pPredictorPaletteEntries = PathElement.groupElement("pPredictorPaletteEntries");

    public static final StructLayout LAYOUT$flags = (StructLayout) LAYOUT.select(PATH$flags);
    public static final OfByte LAYOUT$pps_pic_parameter_set_id = (OfByte) LAYOUT.select(PATH$pps_pic_parameter_set_id);
    public static final OfByte LAYOUT$pps_seq_parameter_set_id = (OfByte) LAYOUT.select(PATH$pps_seq_parameter_set_id);
    public static final OfByte LAYOUT$sps_video_parameter_set_id = (OfByte) LAYOUT.select(PATH$sps_video_parameter_set_id);
    public static final OfByte LAYOUT$num_extra_slice_header_bits = (OfByte) LAYOUT.select(PATH$num_extra_slice_header_bits);
    public static final OfByte LAYOUT$num_ref_idx_l0_default_active_minus1 = (OfByte) LAYOUT.select(PATH$num_ref_idx_l0_default_active_minus1);
    public static final OfByte LAYOUT$num_ref_idx_l1_default_active_minus1 = (OfByte) LAYOUT.select(PATH$num_ref_idx_l1_default_active_minus1);
    public static final OfByte LAYOUT$init_qp_minus26 = (OfByte) LAYOUT.select(PATH$init_qp_minus26);
    public static final OfByte LAYOUT$diff_cu_qp_delta_depth = (OfByte) LAYOUT.select(PATH$diff_cu_qp_delta_depth);
    public static final OfByte LAYOUT$pps_cb_qp_offset = (OfByte) LAYOUT.select(PATH$pps_cb_qp_offset);
    public static final OfByte LAYOUT$pps_cr_qp_offset = (OfByte) LAYOUT.select(PATH$pps_cr_qp_offset);
    public static final OfByte LAYOUT$pps_beta_offset_div2 = (OfByte) LAYOUT.select(PATH$pps_beta_offset_div2);
    public static final OfByte LAYOUT$pps_tc_offset_div2 = (OfByte) LAYOUT.select(PATH$pps_tc_offset_div2);
    public static final OfByte LAYOUT$log2_parallel_merge_level_minus2 = (OfByte) LAYOUT.select(PATH$log2_parallel_merge_level_minus2);
    public static final OfByte LAYOUT$log2_max_transform_skip_block_size_minus2 = (OfByte) LAYOUT.select(PATH$log2_max_transform_skip_block_size_minus2);
    public static final OfByte LAYOUT$diff_cu_chroma_qp_offset_depth = (OfByte) LAYOUT.select(PATH$diff_cu_chroma_qp_offset_depth);
    public static final OfByte LAYOUT$chroma_qp_offset_list_len_minus1 = (OfByte) LAYOUT.select(PATH$chroma_qp_offset_list_len_minus1);
    public static final SequenceLayout LAYOUT$cb_qp_offset_list = (SequenceLayout) LAYOUT.select(PATH$cb_qp_offset_list);
    public static final SequenceLayout LAYOUT$cr_qp_offset_list = (SequenceLayout) LAYOUT.select(PATH$cr_qp_offset_list);
    public static final OfByte LAYOUT$log2_sao_offset_scale_luma = (OfByte) LAYOUT.select(PATH$log2_sao_offset_scale_luma);
    public static final OfByte LAYOUT$log2_sao_offset_scale_chroma = (OfByte) LAYOUT.select(PATH$log2_sao_offset_scale_chroma);
    public static final OfByte LAYOUT$pps_act_y_qp_offset_plus5 = (OfByte) LAYOUT.select(PATH$pps_act_y_qp_offset_plus5);
    public static final OfByte LAYOUT$pps_act_cb_qp_offset_plus5 = (OfByte) LAYOUT.select(PATH$pps_act_cb_qp_offset_plus5);
    public static final OfByte LAYOUT$pps_act_cr_qp_offset_plus3 = (OfByte) LAYOUT.select(PATH$pps_act_cr_qp_offset_plus3);
    public static final OfByte LAYOUT$pps_num_palette_predictor_initializers = (OfByte) LAYOUT.select(PATH$pps_num_palette_predictor_initializers);
    public static final OfByte LAYOUT$luma_bit_depth_entry_minus8 = (OfByte) LAYOUT.select(PATH$luma_bit_depth_entry_minus8);
    public static final OfByte LAYOUT$chroma_bit_depth_entry_minus8 = (OfByte) LAYOUT.select(PATH$chroma_bit_depth_entry_minus8);
    public static final OfByte LAYOUT$num_tile_columns_minus1 = (OfByte) LAYOUT.select(PATH$num_tile_columns_minus1);
    public static final OfByte LAYOUT$num_tile_rows_minus1 = (OfByte) LAYOUT.select(PATH$num_tile_rows_minus1);
    public static final SequenceLayout LAYOUT$column_width_minus1 = (SequenceLayout) LAYOUT.select(PATH$column_width_minus1);
    public static final SequenceLayout LAYOUT$row_height_minus1 = (SequenceLayout) LAYOUT.select(PATH$row_height_minus1);
    public static final AddressLayout LAYOUT$pScalingLists = (AddressLayout) LAYOUT.select(PATH$pScalingLists);
    public static final AddressLayout LAYOUT$pPredictorPaletteEntries = (AddressLayout) LAYOUT.select(PATH$pPredictorPaletteEntries);

    public static final long SIZE$flags = LAYOUT$flags.byteSize();
    public static final long SIZE$pps_pic_parameter_set_id = LAYOUT$pps_pic_parameter_set_id.byteSize();
    public static final long SIZE$pps_seq_parameter_set_id = LAYOUT$pps_seq_parameter_set_id.byteSize();
    public static final long SIZE$sps_video_parameter_set_id = LAYOUT$sps_video_parameter_set_id.byteSize();
    public static final long SIZE$num_extra_slice_header_bits = LAYOUT$num_extra_slice_header_bits.byteSize();
    public static final long SIZE$num_ref_idx_l0_default_active_minus1 = LAYOUT$num_ref_idx_l0_default_active_minus1.byteSize();
    public static final long SIZE$num_ref_idx_l1_default_active_minus1 = LAYOUT$num_ref_idx_l1_default_active_minus1.byteSize();
    public static final long SIZE$init_qp_minus26 = LAYOUT$init_qp_minus26.byteSize();
    public static final long SIZE$diff_cu_qp_delta_depth = LAYOUT$diff_cu_qp_delta_depth.byteSize();
    public static final long SIZE$pps_cb_qp_offset = LAYOUT$pps_cb_qp_offset.byteSize();
    public static final long SIZE$pps_cr_qp_offset = LAYOUT$pps_cr_qp_offset.byteSize();
    public static final long SIZE$pps_beta_offset_div2 = LAYOUT$pps_beta_offset_div2.byteSize();
    public static final long SIZE$pps_tc_offset_div2 = LAYOUT$pps_tc_offset_div2.byteSize();
    public static final long SIZE$log2_parallel_merge_level_minus2 = LAYOUT$log2_parallel_merge_level_minus2.byteSize();
    public static final long SIZE$log2_max_transform_skip_block_size_minus2 = LAYOUT$log2_max_transform_skip_block_size_minus2.byteSize();
    public static final long SIZE$diff_cu_chroma_qp_offset_depth = LAYOUT$diff_cu_chroma_qp_offset_depth.byteSize();
    public static final long SIZE$chroma_qp_offset_list_len_minus1 = LAYOUT$chroma_qp_offset_list_len_minus1.byteSize();
    public static final long SIZE$cb_qp_offset_list = LAYOUT$cb_qp_offset_list.byteSize();
    public static final long SIZE$cr_qp_offset_list = LAYOUT$cr_qp_offset_list.byteSize();
    public static final long SIZE$log2_sao_offset_scale_luma = LAYOUT$log2_sao_offset_scale_luma.byteSize();
    public static final long SIZE$log2_sao_offset_scale_chroma = LAYOUT$log2_sao_offset_scale_chroma.byteSize();
    public static final long SIZE$pps_act_y_qp_offset_plus5 = LAYOUT$pps_act_y_qp_offset_plus5.byteSize();
    public static final long SIZE$pps_act_cb_qp_offset_plus5 = LAYOUT$pps_act_cb_qp_offset_plus5.byteSize();
    public static final long SIZE$pps_act_cr_qp_offset_plus3 = LAYOUT$pps_act_cr_qp_offset_plus3.byteSize();
    public static final long SIZE$pps_num_palette_predictor_initializers = LAYOUT$pps_num_palette_predictor_initializers.byteSize();
    public static final long SIZE$luma_bit_depth_entry_minus8 = LAYOUT$luma_bit_depth_entry_minus8.byteSize();
    public static final long SIZE$chroma_bit_depth_entry_minus8 = LAYOUT$chroma_bit_depth_entry_minus8.byteSize();
    public static final long SIZE$num_tile_columns_minus1 = LAYOUT$num_tile_columns_minus1.byteSize();
    public static final long SIZE$num_tile_rows_minus1 = LAYOUT$num_tile_rows_minus1.byteSize();
    public static final long SIZE$column_width_minus1 = LAYOUT$column_width_minus1.byteSize();
    public static final long SIZE$row_height_minus1 = LAYOUT$row_height_minus1.byteSize();
    public static final long SIZE$pScalingLists = LAYOUT$pScalingLists.byteSize();
    public static final long SIZE$pPredictorPaletteEntries = LAYOUT$pPredictorPaletteEntries.byteSize();

    public static final long OFFSET$flags = LAYOUT.byteOffset(PATH$flags);
    public static final long OFFSET$pps_pic_parameter_set_id = LAYOUT.byteOffset(PATH$pps_pic_parameter_set_id);
    public static final long OFFSET$pps_seq_parameter_set_id = LAYOUT.byteOffset(PATH$pps_seq_parameter_set_id);
    public static final long OFFSET$sps_video_parameter_set_id = LAYOUT.byteOffset(PATH$sps_video_parameter_set_id);
    public static final long OFFSET$num_extra_slice_header_bits = LAYOUT.byteOffset(PATH$num_extra_slice_header_bits);
    public static final long OFFSET$num_ref_idx_l0_default_active_minus1 = LAYOUT.byteOffset(PATH$num_ref_idx_l0_default_active_minus1);
    public static final long OFFSET$num_ref_idx_l1_default_active_minus1 = LAYOUT.byteOffset(PATH$num_ref_idx_l1_default_active_minus1);
    public static final long OFFSET$init_qp_minus26 = LAYOUT.byteOffset(PATH$init_qp_minus26);
    public static final long OFFSET$diff_cu_qp_delta_depth = LAYOUT.byteOffset(PATH$diff_cu_qp_delta_depth);
    public static final long OFFSET$pps_cb_qp_offset = LAYOUT.byteOffset(PATH$pps_cb_qp_offset);
    public static final long OFFSET$pps_cr_qp_offset = LAYOUT.byteOffset(PATH$pps_cr_qp_offset);
    public static final long OFFSET$pps_beta_offset_div2 = LAYOUT.byteOffset(PATH$pps_beta_offset_div2);
    public static final long OFFSET$pps_tc_offset_div2 = LAYOUT.byteOffset(PATH$pps_tc_offset_div2);
    public static final long OFFSET$log2_parallel_merge_level_minus2 = LAYOUT.byteOffset(PATH$log2_parallel_merge_level_minus2);
    public static final long OFFSET$log2_max_transform_skip_block_size_minus2 = LAYOUT.byteOffset(PATH$log2_max_transform_skip_block_size_minus2);
    public static final long OFFSET$diff_cu_chroma_qp_offset_depth = LAYOUT.byteOffset(PATH$diff_cu_chroma_qp_offset_depth);
    public static final long OFFSET$chroma_qp_offset_list_len_minus1 = LAYOUT.byteOffset(PATH$chroma_qp_offset_list_len_minus1);
    public static final long OFFSET$cb_qp_offset_list = LAYOUT.byteOffset(PATH$cb_qp_offset_list);
    public static final long OFFSET$cr_qp_offset_list = LAYOUT.byteOffset(PATH$cr_qp_offset_list);
    public static final long OFFSET$log2_sao_offset_scale_luma = LAYOUT.byteOffset(PATH$log2_sao_offset_scale_luma);
    public static final long OFFSET$log2_sao_offset_scale_chroma = LAYOUT.byteOffset(PATH$log2_sao_offset_scale_chroma);
    public static final long OFFSET$pps_act_y_qp_offset_plus5 = LAYOUT.byteOffset(PATH$pps_act_y_qp_offset_plus5);
    public static final long OFFSET$pps_act_cb_qp_offset_plus5 = LAYOUT.byteOffset(PATH$pps_act_cb_qp_offset_plus5);
    public static final long OFFSET$pps_act_cr_qp_offset_plus3 = LAYOUT.byteOffset(PATH$pps_act_cr_qp_offset_plus3);
    public static final long OFFSET$pps_num_palette_predictor_initializers = LAYOUT.byteOffset(PATH$pps_num_palette_predictor_initializers);
    public static final long OFFSET$luma_bit_depth_entry_minus8 = LAYOUT.byteOffset(PATH$luma_bit_depth_entry_minus8);
    public static final long OFFSET$chroma_bit_depth_entry_minus8 = LAYOUT.byteOffset(PATH$chroma_bit_depth_entry_minus8);
    public static final long OFFSET$num_tile_columns_minus1 = LAYOUT.byteOffset(PATH$num_tile_columns_minus1);
    public static final long OFFSET$num_tile_rows_minus1 = LAYOUT.byteOffset(PATH$num_tile_rows_minus1);
    public static final long OFFSET$column_width_minus1 = LAYOUT.byteOffset(PATH$column_width_minus1);
    public static final long OFFSET$row_height_minus1 = LAYOUT.byteOffset(PATH$row_height_minus1);
    public static final long OFFSET$pScalingLists = LAYOUT.byteOffset(PATH$pScalingLists);
    public static final long OFFSET$pPredictorPaletteEntries = LAYOUT.byteOffset(PATH$pPredictorPaletteEntries);
}
