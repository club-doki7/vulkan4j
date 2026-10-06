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

/// Represents a pointer to a {@code StdVideoH265SequenceParameterSetVui} structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct StdVideoH265SequenceParameterSetVui {
///     StdVideoH265SpsVuiFlags flags; // @link substring="StdVideoH265SpsVuiFlags" target="StdVideoH265SpsVuiFlags" @link substring="flags" target="#flags"
///     StdVideoH265AspectRatioIdc aspect_ratio_idc; // @link substring="StdVideoH265AspectRatioIdc" target="StdVideoH265AspectRatioIdc" @link substring="aspect_ratio_idc" target="#aspect_ratio_idc"
///     uint16_t sar_width; // @link substring="sar_width" target="#sar_width"
///     uint16_t sar_height; // @link substring="sar_height" target="#sar_height"
///     uint8_t video_format; // @link substring="video_format" target="#video_format"
///     uint8_t colour_primaries; // @link substring="colour_primaries" target="#colour_primaries"
///     uint8_t transfer_characteristics; // @link substring="transfer_characteristics" target="#transfer_characteristics"
///     uint8_t matrix_coeffs; // @link substring="matrix_coeffs" target="#matrix_coeffs"
///     uint8_t chroma_sample_loc_type_top_field; // @link substring="chroma_sample_loc_type_top_field" target="#chroma_sample_loc_type_top_field"
///     uint8_t chroma_sample_loc_type_bottom_field; // @link substring="chroma_sample_loc_type_bottom_field" target="#chroma_sample_loc_type_bottom_field"
///     uint8_t reserved1;
///     uint8_t reserved2;
///     uint16_t def_disp_win_left_offset; // @link substring="def_disp_win_left_offset" target="#def_disp_win_left_offset"
///     uint16_t def_disp_win_right_offset; // @link substring="def_disp_win_right_offset" target="#def_disp_win_right_offset"
///     uint16_t def_disp_win_top_offset; // @link substring="def_disp_win_top_offset" target="#def_disp_win_top_offset"
///     uint16_t def_disp_win_bottom_offset; // @link substring="def_disp_win_bottom_offset" target="#def_disp_win_bottom_offset"
///     uint32_t vui_num_units_in_tick; // @link substring="vui_num_units_in_tick" target="#vui_num_units_in_tick"
///     uint32_t vui_time_scale; // @link substring="vui_time_scale" target="#vui_time_scale"
///     uint32_t vui_num_ticks_poc_diff_one_minus1; // @link substring="vui_num_ticks_poc_diff_one_minus1" target="#vui_num_ticks_poc_diff_one_minus1"
///     uint16_t min_spatial_segmentation_idc; // @link substring="min_spatial_segmentation_idc" target="#min_spatial_segmentation_idc"
///     uint16_t reserved3;
///     uint8_t max_bytes_per_pic_denom; // @link substring="max_bytes_per_pic_denom" target="#max_bytes_per_pic_denom"
///     uint8_t max_bits_per_min_cu_denom; // @link substring="max_bits_per_min_cu_denom" target="#max_bits_per_min_cu_denom"
///     uint8_t log2_max_mv_length_horizontal; // @link substring="log2_max_mv_length_horizontal" target="#log2_max_mv_length_horizontal"
///     uint8_t log2_max_mv_length_vertical; // @link substring="log2_max_mv_length_vertical" target="#log2_max_mv_length_vertical"
///     StdVideoH265HrdParameters const* pHrdParameters; // optional // @link substring="StdVideoH265HrdParameters" target="StdVideoH265HrdParameters" @link substring="pHrdParameters" target="#pHrdParameters"
/// } StdVideoH265SequenceParameterSetVui;
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
public record StdVideoH265SequenceParameterSetVui(@NotNull MemorySegment segment) implements IStdVideoH265SequenceParameterSetVui {
    /// Represents a pointer to / an array of null structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link StdVideoH265SequenceParameterSetVui}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IStdVideoH265SequenceParameterSetVui to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code StdVideoH265SequenceParameterSetVui.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IStdVideoH265SequenceParameterSetVui, Iterable<StdVideoH265SequenceParameterSetVui> {
        public long size() {
            return segment.byteSize() / StdVideoH265SequenceParameterSetVui.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull StdVideoH265SequenceParameterSetVui at(long index) {
            return new StdVideoH265SequenceParameterSetVui(segment.asSlice(index * StdVideoH265SequenceParameterSetVui.BYTES, StdVideoH265SequenceParameterSetVui.BYTES));
        }

        public StdVideoH265SequenceParameterSetVui.Ptr at(long index, @NotNull Consumer<@NotNull StdVideoH265SequenceParameterSetVui> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull StdVideoH265SequenceParameterSetVui value) {
            MemorySegment s = segment.asSlice(index * StdVideoH265SequenceParameterSetVui.BYTES, StdVideoH265SequenceParameterSetVui.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * StdVideoH265SequenceParameterSetVui.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * StdVideoH265SequenceParameterSetVui.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * StdVideoH265SequenceParameterSetVui.BYTES,
                (end - start) * StdVideoH265SequenceParameterSetVui.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * StdVideoH265SequenceParameterSetVui.BYTES));
        }

        public StdVideoH265SequenceParameterSetVui[] toArray() {
            StdVideoH265SequenceParameterSetVui[] ret = new StdVideoH265SequenceParameterSetVui[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<StdVideoH265SequenceParameterSetVui> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<StdVideoH265SequenceParameterSetVui> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= StdVideoH265SequenceParameterSetVui.BYTES;
            }

            @Override
            public StdVideoH265SequenceParameterSetVui next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                StdVideoH265SequenceParameterSetVui ret = new StdVideoH265SequenceParameterSetVui(segment.asSlice(0, StdVideoH265SequenceParameterSetVui.BYTES));
                segment = segment.asSlice(StdVideoH265SequenceParameterSetVui.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static StdVideoH265SequenceParameterSetVui allocate(Arena arena) {
        return new StdVideoH265SequenceParameterSetVui(arena.allocate(LAYOUT));
    }

    public static StdVideoH265SequenceParameterSetVui.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        return new StdVideoH265SequenceParameterSetVui.Ptr(segment);
    }

    public static StdVideoH265SequenceParameterSetVui clone(Arena arena, StdVideoH265SequenceParameterSetVui src) {
        StdVideoH265SequenceParameterSetVui ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public @NotNull StdVideoH265SpsVuiFlags flags() {
        return new StdVideoH265SpsVuiFlags(segment.asSlice(OFFSET$flags, LAYOUT$flags));
    }

    public StdVideoH265SequenceParameterSetVui flags(@NotNull StdVideoH265SpsVuiFlags value) {
        MemorySegment.copy(value.segment(), 0, segment, OFFSET$flags, SIZE$flags);
        return this;
    }

    public StdVideoH265SequenceParameterSetVui flags(Consumer<@NotNull StdVideoH265SpsVuiFlags> consumer) {
        consumer.accept(flags());
        return this;
    }

    public @EnumType(StdVideoH265AspectRatioIdc.class) int aspect_ratio_idc() {
        return segment.get(LAYOUT$aspect_ratio_idc, OFFSET$aspect_ratio_idc);
    }

    public StdVideoH265SequenceParameterSetVui aspect_ratio_idc(@EnumType(StdVideoH265AspectRatioIdc.class) int value) {
        segment.set(LAYOUT$aspect_ratio_idc, OFFSET$aspect_ratio_idc, value);
        return this;
    }

    public @Unsigned short sar_width() {
        return segment.get(LAYOUT$sar_width, OFFSET$sar_width);
    }

    public StdVideoH265SequenceParameterSetVui sar_width(@Unsigned short value) {
        segment.set(LAYOUT$sar_width, OFFSET$sar_width, value);
        return this;
    }

    public @Unsigned short sar_height() {
        return segment.get(LAYOUT$sar_height, OFFSET$sar_height);
    }

    public StdVideoH265SequenceParameterSetVui sar_height(@Unsigned short value) {
        segment.set(LAYOUT$sar_height, OFFSET$sar_height, value);
        return this;
    }

    public @Unsigned byte video_format() {
        return segment.get(LAYOUT$video_format, OFFSET$video_format);
    }

    public StdVideoH265SequenceParameterSetVui video_format(@Unsigned byte value) {
        segment.set(LAYOUT$video_format, OFFSET$video_format, value);
        return this;
    }

    public @Unsigned byte colour_primaries() {
        return segment.get(LAYOUT$colour_primaries, OFFSET$colour_primaries);
    }

    public StdVideoH265SequenceParameterSetVui colour_primaries(@Unsigned byte value) {
        segment.set(LAYOUT$colour_primaries, OFFSET$colour_primaries, value);
        return this;
    }

    public @Unsigned byte transfer_characteristics() {
        return segment.get(LAYOUT$transfer_characteristics, OFFSET$transfer_characteristics);
    }

    public StdVideoH265SequenceParameterSetVui transfer_characteristics(@Unsigned byte value) {
        segment.set(LAYOUT$transfer_characteristics, OFFSET$transfer_characteristics, value);
        return this;
    }

    public @Unsigned byte matrix_coeffs() {
        return segment.get(LAYOUT$matrix_coeffs, OFFSET$matrix_coeffs);
    }

    public StdVideoH265SequenceParameterSetVui matrix_coeffs(@Unsigned byte value) {
        segment.set(LAYOUT$matrix_coeffs, OFFSET$matrix_coeffs, value);
        return this;
    }

    public @Unsigned byte chroma_sample_loc_type_top_field() {
        return segment.get(LAYOUT$chroma_sample_loc_type_top_field, OFFSET$chroma_sample_loc_type_top_field);
    }

    public StdVideoH265SequenceParameterSetVui chroma_sample_loc_type_top_field(@Unsigned byte value) {
        segment.set(LAYOUT$chroma_sample_loc_type_top_field, OFFSET$chroma_sample_loc_type_top_field, value);
        return this;
    }

    public @Unsigned byte chroma_sample_loc_type_bottom_field() {
        return segment.get(LAYOUT$chroma_sample_loc_type_bottom_field, OFFSET$chroma_sample_loc_type_bottom_field);
    }

    public StdVideoH265SequenceParameterSetVui chroma_sample_loc_type_bottom_field(@Unsigned byte value) {
        segment.set(LAYOUT$chroma_sample_loc_type_bottom_field, OFFSET$chroma_sample_loc_type_bottom_field, value);
        return this;
    }



    public @Unsigned short def_disp_win_left_offset() {
        return segment.get(LAYOUT$def_disp_win_left_offset, OFFSET$def_disp_win_left_offset);
    }

    public StdVideoH265SequenceParameterSetVui def_disp_win_left_offset(@Unsigned short value) {
        segment.set(LAYOUT$def_disp_win_left_offset, OFFSET$def_disp_win_left_offset, value);
        return this;
    }

    public @Unsigned short def_disp_win_right_offset() {
        return segment.get(LAYOUT$def_disp_win_right_offset, OFFSET$def_disp_win_right_offset);
    }

    public StdVideoH265SequenceParameterSetVui def_disp_win_right_offset(@Unsigned short value) {
        segment.set(LAYOUT$def_disp_win_right_offset, OFFSET$def_disp_win_right_offset, value);
        return this;
    }

    public @Unsigned short def_disp_win_top_offset() {
        return segment.get(LAYOUT$def_disp_win_top_offset, OFFSET$def_disp_win_top_offset);
    }

    public StdVideoH265SequenceParameterSetVui def_disp_win_top_offset(@Unsigned short value) {
        segment.set(LAYOUT$def_disp_win_top_offset, OFFSET$def_disp_win_top_offset, value);
        return this;
    }

    public @Unsigned short def_disp_win_bottom_offset() {
        return segment.get(LAYOUT$def_disp_win_bottom_offset, OFFSET$def_disp_win_bottom_offset);
    }

    public StdVideoH265SequenceParameterSetVui def_disp_win_bottom_offset(@Unsigned short value) {
        segment.set(LAYOUT$def_disp_win_bottom_offset, OFFSET$def_disp_win_bottom_offset, value);
        return this;
    }

    public @Unsigned int vui_num_units_in_tick() {
        return segment.get(LAYOUT$vui_num_units_in_tick, OFFSET$vui_num_units_in_tick);
    }

    public StdVideoH265SequenceParameterSetVui vui_num_units_in_tick(@Unsigned int value) {
        segment.set(LAYOUT$vui_num_units_in_tick, OFFSET$vui_num_units_in_tick, value);
        return this;
    }

    public @Unsigned int vui_time_scale() {
        return segment.get(LAYOUT$vui_time_scale, OFFSET$vui_time_scale);
    }

    public StdVideoH265SequenceParameterSetVui vui_time_scale(@Unsigned int value) {
        segment.set(LAYOUT$vui_time_scale, OFFSET$vui_time_scale, value);
        return this;
    }

    public @Unsigned int vui_num_ticks_poc_diff_one_minus1() {
        return segment.get(LAYOUT$vui_num_ticks_poc_diff_one_minus1, OFFSET$vui_num_ticks_poc_diff_one_minus1);
    }

    public StdVideoH265SequenceParameterSetVui vui_num_ticks_poc_diff_one_minus1(@Unsigned int value) {
        segment.set(LAYOUT$vui_num_ticks_poc_diff_one_minus1, OFFSET$vui_num_ticks_poc_diff_one_minus1, value);
        return this;
    }

    public @Unsigned short min_spatial_segmentation_idc() {
        return segment.get(LAYOUT$min_spatial_segmentation_idc, OFFSET$min_spatial_segmentation_idc);
    }

    public StdVideoH265SequenceParameterSetVui min_spatial_segmentation_idc(@Unsigned short value) {
        segment.set(LAYOUT$min_spatial_segmentation_idc, OFFSET$min_spatial_segmentation_idc, value);
        return this;
    }


    public @Unsigned byte max_bytes_per_pic_denom() {
        return segment.get(LAYOUT$max_bytes_per_pic_denom, OFFSET$max_bytes_per_pic_denom);
    }

    public StdVideoH265SequenceParameterSetVui max_bytes_per_pic_denom(@Unsigned byte value) {
        segment.set(LAYOUT$max_bytes_per_pic_denom, OFFSET$max_bytes_per_pic_denom, value);
        return this;
    }

    public @Unsigned byte max_bits_per_min_cu_denom() {
        return segment.get(LAYOUT$max_bits_per_min_cu_denom, OFFSET$max_bits_per_min_cu_denom);
    }

    public StdVideoH265SequenceParameterSetVui max_bits_per_min_cu_denom(@Unsigned byte value) {
        segment.set(LAYOUT$max_bits_per_min_cu_denom, OFFSET$max_bits_per_min_cu_denom, value);
        return this;
    }

    public @Unsigned byte log2_max_mv_length_horizontal() {
        return segment.get(LAYOUT$log2_max_mv_length_horizontal, OFFSET$log2_max_mv_length_horizontal);
    }

    public StdVideoH265SequenceParameterSetVui log2_max_mv_length_horizontal(@Unsigned byte value) {
        segment.set(LAYOUT$log2_max_mv_length_horizontal, OFFSET$log2_max_mv_length_horizontal, value);
        return this;
    }

    public @Unsigned byte log2_max_mv_length_vertical() {
        return segment.get(LAYOUT$log2_max_mv_length_vertical, OFFSET$log2_max_mv_length_vertical);
    }

    public StdVideoH265SequenceParameterSetVui log2_max_mv_length_vertical(@Unsigned byte value) {
        segment.set(LAYOUT$log2_max_mv_length_vertical, OFFSET$log2_max_mv_length_vertical, value);
        return this;
    }

    public StdVideoH265SequenceParameterSetVui pHrdParameters(@Nullable IStdVideoH265HrdParameters value) {
        MemorySegment s = value == null ? MemorySegment.NULL : value.segment();
        pHrdParametersRaw(s);
        return this;
    }

    @Unsafe public @Nullable StdVideoH265HrdParameters.Ptr pHrdParameters(int assumedCount) {
        MemorySegment s = pHrdParametersRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }

        s = s.reinterpret(assumedCount * StdVideoH265HrdParameters.BYTES);
        return new StdVideoH265HrdParameters.Ptr(s);
    }

    public @Nullable StdVideoH265HrdParameters pHrdParameters() {
        MemorySegment s = pHrdParametersRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new StdVideoH265HrdParameters(s);
    }

    public @Pointer(target=StdVideoH265HrdParameters.class) @NotNull MemorySegment pHrdParametersRaw() {
        return segment.get(LAYOUT$pHrdParameters, OFFSET$pHrdParameters);
    }

    public void pHrdParametersRaw(@Pointer(target=StdVideoH265HrdParameters.class) @NotNull MemorySegment value) {
        segment.set(LAYOUT$pHrdParameters, OFFSET$pHrdParameters, value);
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        StdVideoH265SpsVuiFlags.LAYOUT.withName("flags"),
        ValueLayout.JAVA_INT.withName("aspect_ratio_idc"),
        ValueLayout.JAVA_SHORT.withName("sar_width"),
        ValueLayout.JAVA_SHORT.withName("sar_height"),
        ValueLayout.JAVA_BYTE.withName("video_format"),
        ValueLayout.JAVA_BYTE.withName("colour_primaries"),
        ValueLayout.JAVA_BYTE.withName("transfer_characteristics"),
        ValueLayout.JAVA_BYTE.withName("matrix_coeffs"),
        ValueLayout.JAVA_BYTE.withName("chroma_sample_loc_type_top_field"),
        ValueLayout.JAVA_BYTE.withName("chroma_sample_loc_type_bottom_field"),
        ValueLayout.JAVA_BYTE.withName("reserved1"),
        ValueLayout.JAVA_BYTE.withName("reserved2"),
        ValueLayout.JAVA_SHORT.withName("def_disp_win_left_offset"),
        ValueLayout.JAVA_SHORT.withName("def_disp_win_right_offset"),
        ValueLayout.JAVA_SHORT.withName("def_disp_win_top_offset"),
        ValueLayout.JAVA_SHORT.withName("def_disp_win_bottom_offset"),
        ValueLayout.JAVA_INT.withName("vui_num_units_in_tick"),
        ValueLayout.JAVA_INT.withName("vui_time_scale"),
        ValueLayout.JAVA_INT.withName("vui_num_ticks_poc_diff_one_minus1"),
        ValueLayout.JAVA_SHORT.withName("min_spatial_segmentation_idc"),
        ValueLayout.JAVA_SHORT.withName("reserved3"),
        ValueLayout.JAVA_BYTE.withName("max_bytes_per_pic_denom"),
        ValueLayout.JAVA_BYTE.withName("max_bits_per_min_cu_denom"),
        ValueLayout.JAVA_BYTE.withName("log2_max_mv_length_horizontal"),
        ValueLayout.JAVA_BYTE.withName("log2_max_mv_length_vertical"),
        ValueLayout.ADDRESS.withTargetLayout(StdVideoH265HrdParameters.LAYOUT).withName("pHrdParameters")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$flags = PathElement.groupElement("flags");
    public static final PathElement PATH$aspect_ratio_idc = PathElement.groupElement("aspect_ratio_idc");
    public static final PathElement PATH$sar_width = PathElement.groupElement("sar_width");
    public static final PathElement PATH$sar_height = PathElement.groupElement("sar_height");
    public static final PathElement PATH$video_format = PathElement.groupElement("video_format");
    public static final PathElement PATH$colour_primaries = PathElement.groupElement("colour_primaries");
    public static final PathElement PATH$transfer_characteristics = PathElement.groupElement("transfer_characteristics");
    public static final PathElement PATH$matrix_coeffs = PathElement.groupElement("matrix_coeffs");
    public static final PathElement PATH$chroma_sample_loc_type_top_field = PathElement.groupElement("chroma_sample_loc_type_top_field");
    public static final PathElement PATH$chroma_sample_loc_type_bottom_field = PathElement.groupElement("chroma_sample_loc_type_bottom_field");
    public static final PathElement PATH$def_disp_win_left_offset = PathElement.groupElement("def_disp_win_left_offset");
    public static final PathElement PATH$def_disp_win_right_offset = PathElement.groupElement("def_disp_win_right_offset");
    public static final PathElement PATH$def_disp_win_top_offset = PathElement.groupElement("def_disp_win_top_offset");
    public static final PathElement PATH$def_disp_win_bottom_offset = PathElement.groupElement("def_disp_win_bottom_offset");
    public static final PathElement PATH$vui_num_units_in_tick = PathElement.groupElement("vui_num_units_in_tick");
    public static final PathElement PATH$vui_time_scale = PathElement.groupElement("vui_time_scale");
    public static final PathElement PATH$vui_num_ticks_poc_diff_one_minus1 = PathElement.groupElement("vui_num_ticks_poc_diff_one_minus1");
    public static final PathElement PATH$min_spatial_segmentation_idc = PathElement.groupElement("min_spatial_segmentation_idc");
    public static final PathElement PATH$max_bytes_per_pic_denom = PathElement.groupElement("max_bytes_per_pic_denom");
    public static final PathElement PATH$max_bits_per_min_cu_denom = PathElement.groupElement("max_bits_per_min_cu_denom");
    public static final PathElement PATH$log2_max_mv_length_horizontal = PathElement.groupElement("log2_max_mv_length_horizontal");
    public static final PathElement PATH$log2_max_mv_length_vertical = PathElement.groupElement("log2_max_mv_length_vertical");
    public static final PathElement PATH$pHrdParameters = PathElement.groupElement("pHrdParameters");

    public static final StructLayout LAYOUT$flags = (StructLayout) LAYOUT.select(PATH$flags);
    public static final OfInt LAYOUT$aspect_ratio_idc = (OfInt) LAYOUT.select(PATH$aspect_ratio_idc);
    public static final OfShort LAYOUT$sar_width = (OfShort) LAYOUT.select(PATH$sar_width);
    public static final OfShort LAYOUT$sar_height = (OfShort) LAYOUT.select(PATH$sar_height);
    public static final OfByte LAYOUT$video_format = (OfByte) LAYOUT.select(PATH$video_format);
    public static final OfByte LAYOUT$colour_primaries = (OfByte) LAYOUT.select(PATH$colour_primaries);
    public static final OfByte LAYOUT$transfer_characteristics = (OfByte) LAYOUT.select(PATH$transfer_characteristics);
    public static final OfByte LAYOUT$matrix_coeffs = (OfByte) LAYOUT.select(PATH$matrix_coeffs);
    public static final OfByte LAYOUT$chroma_sample_loc_type_top_field = (OfByte) LAYOUT.select(PATH$chroma_sample_loc_type_top_field);
    public static final OfByte LAYOUT$chroma_sample_loc_type_bottom_field = (OfByte) LAYOUT.select(PATH$chroma_sample_loc_type_bottom_field);
    public static final OfShort LAYOUT$def_disp_win_left_offset = (OfShort) LAYOUT.select(PATH$def_disp_win_left_offset);
    public static final OfShort LAYOUT$def_disp_win_right_offset = (OfShort) LAYOUT.select(PATH$def_disp_win_right_offset);
    public static final OfShort LAYOUT$def_disp_win_top_offset = (OfShort) LAYOUT.select(PATH$def_disp_win_top_offset);
    public static final OfShort LAYOUT$def_disp_win_bottom_offset = (OfShort) LAYOUT.select(PATH$def_disp_win_bottom_offset);
    public static final OfInt LAYOUT$vui_num_units_in_tick = (OfInt) LAYOUT.select(PATH$vui_num_units_in_tick);
    public static final OfInt LAYOUT$vui_time_scale = (OfInt) LAYOUT.select(PATH$vui_time_scale);
    public static final OfInt LAYOUT$vui_num_ticks_poc_diff_one_minus1 = (OfInt) LAYOUT.select(PATH$vui_num_ticks_poc_diff_one_minus1);
    public static final OfShort LAYOUT$min_spatial_segmentation_idc = (OfShort) LAYOUT.select(PATH$min_spatial_segmentation_idc);
    public static final OfByte LAYOUT$max_bytes_per_pic_denom = (OfByte) LAYOUT.select(PATH$max_bytes_per_pic_denom);
    public static final OfByte LAYOUT$max_bits_per_min_cu_denom = (OfByte) LAYOUT.select(PATH$max_bits_per_min_cu_denom);
    public static final OfByte LAYOUT$log2_max_mv_length_horizontal = (OfByte) LAYOUT.select(PATH$log2_max_mv_length_horizontal);
    public static final OfByte LAYOUT$log2_max_mv_length_vertical = (OfByte) LAYOUT.select(PATH$log2_max_mv_length_vertical);
    public static final AddressLayout LAYOUT$pHrdParameters = (AddressLayout) LAYOUT.select(PATH$pHrdParameters);

    public static final long SIZE$flags = LAYOUT$flags.byteSize();
    public static final long SIZE$aspect_ratio_idc = LAYOUT$aspect_ratio_idc.byteSize();
    public static final long SIZE$sar_width = LAYOUT$sar_width.byteSize();
    public static final long SIZE$sar_height = LAYOUT$sar_height.byteSize();
    public static final long SIZE$video_format = LAYOUT$video_format.byteSize();
    public static final long SIZE$colour_primaries = LAYOUT$colour_primaries.byteSize();
    public static final long SIZE$transfer_characteristics = LAYOUT$transfer_characteristics.byteSize();
    public static final long SIZE$matrix_coeffs = LAYOUT$matrix_coeffs.byteSize();
    public static final long SIZE$chroma_sample_loc_type_top_field = LAYOUT$chroma_sample_loc_type_top_field.byteSize();
    public static final long SIZE$chroma_sample_loc_type_bottom_field = LAYOUT$chroma_sample_loc_type_bottom_field.byteSize();
    public static final long SIZE$def_disp_win_left_offset = LAYOUT$def_disp_win_left_offset.byteSize();
    public static final long SIZE$def_disp_win_right_offset = LAYOUT$def_disp_win_right_offset.byteSize();
    public static final long SIZE$def_disp_win_top_offset = LAYOUT$def_disp_win_top_offset.byteSize();
    public static final long SIZE$def_disp_win_bottom_offset = LAYOUT$def_disp_win_bottom_offset.byteSize();
    public static final long SIZE$vui_num_units_in_tick = LAYOUT$vui_num_units_in_tick.byteSize();
    public static final long SIZE$vui_time_scale = LAYOUT$vui_time_scale.byteSize();
    public static final long SIZE$vui_num_ticks_poc_diff_one_minus1 = LAYOUT$vui_num_ticks_poc_diff_one_minus1.byteSize();
    public static final long SIZE$min_spatial_segmentation_idc = LAYOUT$min_spatial_segmentation_idc.byteSize();
    public static final long SIZE$max_bytes_per_pic_denom = LAYOUT$max_bytes_per_pic_denom.byteSize();
    public static final long SIZE$max_bits_per_min_cu_denom = LAYOUT$max_bits_per_min_cu_denom.byteSize();
    public static final long SIZE$log2_max_mv_length_horizontal = LAYOUT$log2_max_mv_length_horizontal.byteSize();
    public static final long SIZE$log2_max_mv_length_vertical = LAYOUT$log2_max_mv_length_vertical.byteSize();
    public static final long SIZE$pHrdParameters = LAYOUT$pHrdParameters.byteSize();

    public static final long OFFSET$flags = LAYOUT.byteOffset(PATH$flags);
    public static final long OFFSET$aspect_ratio_idc = LAYOUT.byteOffset(PATH$aspect_ratio_idc);
    public static final long OFFSET$sar_width = LAYOUT.byteOffset(PATH$sar_width);
    public static final long OFFSET$sar_height = LAYOUT.byteOffset(PATH$sar_height);
    public static final long OFFSET$video_format = LAYOUT.byteOffset(PATH$video_format);
    public static final long OFFSET$colour_primaries = LAYOUT.byteOffset(PATH$colour_primaries);
    public static final long OFFSET$transfer_characteristics = LAYOUT.byteOffset(PATH$transfer_characteristics);
    public static final long OFFSET$matrix_coeffs = LAYOUT.byteOffset(PATH$matrix_coeffs);
    public static final long OFFSET$chroma_sample_loc_type_top_field = LAYOUT.byteOffset(PATH$chroma_sample_loc_type_top_field);
    public static final long OFFSET$chroma_sample_loc_type_bottom_field = LAYOUT.byteOffset(PATH$chroma_sample_loc_type_bottom_field);
    public static final long OFFSET$def_disp_win_left_offset = LAYOUT.byteOffset(PATH$def_disp_win_left_offset);
    public static final long OFFSET$def_disp_win_right_offset = LAYOUT.byteOffset(PATH$def_disp_win_right_offset);
    public static final long OFFSET$def_disp_win_top_offset = LAYOUT.byteOffset(PATH$def_disp_win_top_offset);
    public static final long OFFSET$def_disp_win_bottom_offset = LAYOUT.byteOffset(PATH$def_disp_win_bottom_offset);
    public static final long OFFSET$vui_num_units_in_tick = LAYOUT.byteOffset(PATH$vui_num_units_in_tick);
    public static final long OFFSET$vui_time_scale = LAYOUT.byteOffset(PATH$vui_time_scale);
    public static final long OFFSET$vui_num_ticks_poc_diff_one_minus1 = LAYOUT.byteOffset(PATH$vui_num_ticks_poc_diff_one_minus1);
    public static final long OFFSET$min_spatial_segmentation_idc = LAYOUT.byteOffset(PATH$min_spatial_segmentation_idc);
    public static final long OFFSET$max_bytes_per_pic_denom = LAYOUT.byteOffset(PATH$max_bytes_per_pic_denom);
    public static final long OFFSET$max_bits_per_min_cu_denom = LAYOUT.byteOffset(PATH$max_bits_per_min_cu_denom);
    public static final long OFFSET$log2_max_mv_length_horizontal = LAYOUT.byteOffset(PATH$log2_max_mv_length_horizontal);
    public static final long OFFSET$log2_max_mv_length_vertical = LAYOUT.byteOffset(PATH$log2_max_mv_length_vertical);
    public static final long OFFSET$pHrdParameters = LAYOUT.byteOffset(PATH$pHrdParameters);
}
