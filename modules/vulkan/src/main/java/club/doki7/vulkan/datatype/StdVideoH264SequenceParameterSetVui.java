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

/// Represents a pointer to a {@code StdVideoH264SequenceParameterSetVui} structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct StdVideoH264SequenceParameterSetVui {
///     StdVideoH264SpsVuiFlags flags; // @link substring="StdVideoH264SpsVuiFlags" target="StdVideoH264SpsVuiFlags" @link substring="flags" target="#flags"
///     StdVideoH264AspectRatioIdc aspect_ratio_idc; // @link substring="StdVideoH264AspectRatioIdc" target="StdVideoH264AspectRatioIdc" @link substring="aspect_ratio_idc" target="#aspect_ratio_idc"
///     uint16_t sar_width; // @link substring="sar_width" target="#sar_width"
///     uint16_t sar_height; // @link substring="sar_height" target="#sar_height"
///     uint8_t video_format; // @link substring="video_format" target="#video_format"
///     uint8_t colour_primaries; // @link substring="colour_primaries" target="#colour_primaries"
///     uint8_t transfer_characteristics; // @link substring="transfer_characteristics" target="#transfer_characteristics"
///     uint8_t matrix_coefficients; // @link substring="matrix_coefficients" target="#matrix_coefficients"
///     uint32_t num_units_in_tick; // @link substring="num_units_in_tick" target="#num_units_in_tick"
///     uint32_t time_scale; // @link substring="time_scale" target="#time_scale"
///     uint8_t max_num_reorder_frames; // @link substring="max_num_reorder_frames" target="#max_num_reorder_frames"
///     uint8_t max_dec_frame_buffering; // @link substring="max_dec_frame_buffering" target="#max_dec_frame_buffering"
///     uint8_t chroma_sample_loc_type_top_field; // @link substring="chroma_sample_loc_type_top_field" target="#chroma_sample_loc_type_top_field"
///     uint8_t chroma_sample_loc_type_bottom_field; // @link substring="chroma_sample_loc_type_bottom_field" target="#chroma_sample_loc_type_bottom_field"
///     uint32_t reserved1;
///     StdVideoH264HrdParameters const* pHrdParameters; // optional // @link substring="StdVideoH264HrdParameters" target="StdVideoH264HrdParameters" @link substring="pHrdParameters" target="#pHrdParameters"
/// } StdVideoH264SequenceParameterSetVui;
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
public record StdVideoH264SequenceParameterSetVui(@NotNull MemorySegment segment) implements IStdVideoH264SequenceParameterSetVui {
    /// Represents a pointer to / an array of null structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link StdVideoH264SequenceParameterSetVui}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IStdVideoH264SequenceParameterSetVui to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code StdVideoH264SequenceParameterSetVui.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IStdVideoH264SequenceParameterSetVui, Iterable<StdVideoH264SequenceParameterSetVui> {
        public long size() {
            return segment.byteSize() / StdVideoH264SequenceParameterSetVui.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull StdVideoH264SequenceParameterSetVui at(long index) {
            return new StdVideoH264SequenceParameterSetVui(segment.asSlice(index * StdVideoH264SequenceParameterSetVui.BYTES, StdVideoH264SequenceParameterSetVui.BYTES));
        }

        public StdVideoH264SequenceParameterSetVui.Ptr at(long index, @NotNull Consumer<@NotNull StdVideoH264SequenceParameterSetVui> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull StdVideoH264SequenceParameterSetVui value) {
            MemorySegment s = segment.asSlice(index * StdVideoH264SequenceParameterSetVui.BYTES, StdVideoH264SequenceParameterSetVui.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * StdVideoH264SequenceParameterSetVui.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * StdVideoH264SequenceParameterSetVui.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * StdVideoH264SequenceParameterSetVui.BYTES,
                (end - start) * StdVideoH264SequenceParameterSetVui.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * StdVideoH264SequenceParameterSetVui.BYTES));
        }

        public StdVideoH264SequenceParameterSetVui[] toArray() {
            StdVideoH264SequenceParameterSetVui[] ret = new StdVideoH264SequenceParameterSetVui[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<StdVideoH264SequenceParameterSetVui> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<StdVideoH264SequenceParameterSetVui> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= StdVideoH264SequenceParameterSetVui.BYTES;
            }

            @Override
            public StdVideoH264SequenceParameterSetVui next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                StdVideoH264SequenceParameterSetVui ret = new StdVideoH264SequenceParameterSetVui(segment.asSlice(0, StdVideoH264SequenceParameterSetVui.BYTES));
                segment = segment.asSlice(StdVideoH264SequenceParameterSetVui.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static StdVideoH264SequenceParameterSetVui allocate(Arena arena) {
        return new StdVideoH264SequenceParameterSetVui(arena.allocate(LAYOUT));
    }

    public static StdVideoH264SequenceParameterSetVui.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        return new StdVideoH264SequenceParameterSetVui.Ptr(segment);
    }

    public static StdVideoH264SequenceParameterSetVui clone(Arena arena, StdVideoH264SequenceParameterSetVui src) {
        StdVideoH264SequenceParameterSetVui ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public @NotNull StdVideoH264SpsVuiFlags flags() {
        return new StdVideoH264SpsVuiFlags(segment.asSlice(OFFSET$flags, LAYOUT$flags));
    }

    public StdVideoH264SequenceParameterSetVui flags(@NotNull StdVideoH264SpsVuiFlags value) {
        MemorySegment.copy(value.segment(), 0, segment, OFFSET$flags, SIZE$flags);
        return this;
    }

    public StdVideoH264SequenceParameterSetVui flags(Consumer<@NotNull StdVideoH264SpsVuiFlags> consumer) {
        consumer.accept(flags());
        return this;
    }

    public @EnumType(StdVideoH264AspectRatioIdc.class) int aspect_ratio_idc() {
        return segment.get(LAYOUT$aspect_ratio_idc, OFFSET$aspect_ratio_idc);
    }

    public StdVideoH264SequenceParameterSetVui aspect_ratio_idc(@EnumType(StdVideoH264AspectRatioIdc.class) int value) {
        segment.set(LAYOUT$aspect_ratio_idc, OFFSET$aspect_ratio_idc, value);
        return this;
    }

    public @Unsigned short sar_width() {
        return segment.get(LAYOUT$sar_width, OFFSET$sar_width);
    }

    public StdVideoH264SequenceParameterSetVui sar_width(@Unsigned short value) {
        segment.set(LAYOUT$sar_width, OFFSET$sar_width, value);
        return this;
    }

    public @Unsigned short sar_height() {
        return segment.get(LAYOUT$sar_height, OFFSET$sar_height);
    }

    public StdVideoH264SequenceParameterSetVui sar_height(@Unsigned short value) {
        segment.set(LAYOUT$sar_height, OFFSET$sar_height, value);
        return this;
    }

    public @Unsigned byte video_format() {
        return segment.get(LAYOUT$video_format, OFFSET$video_format);
    }

    public StdVideoH264SequenceParameterSetVui video_format(@Unsigned byte value) {
        segment.set(LAYOUT$video_format, OFFSET$video_format, value);
        return this;
    }

    public @Unsigned byte colour_primaries() {
        return segment.get(LAYOUT$colour_primaries, OFFSET$colour_primaries);
    }

    public StdVideoH264SequenceParameterSetVui colour_primaries(@Unsigned byte value) {
        segment.set(LAYOUT$colour_primaries, OFFSET$colour_primaries, value);
        return this;
    }

    public @Unsigned byte transfer_characteristics() {
        return segment.get(LAYOUT$transfer_characteristics, OFFSET$transfer_characteristics);
    }

    public StdVideoH264SequenceParameterSetVui transfer_characteristics(@Unsigned byte value) {
        segment.set(LAYOUT$transfer_characteristics, OFFSET$transfer_characteristics, value);
        return this;
    }

    public @Unsigned byte matrix_coefficients() {
        return segment.get(LAYOUT$matrix_coefficients, OFFSET$matrix_coefficients);
    }

    public StdVideoH264SequenceParameterSetVui matrix_coefficients(@Unsigned byte value) {
        segment.set(LAYOUT$matrix_coefficients, OFFSET$matrix_coefficients, value);
        return this;
    }

    public @Unsigned int num_units_in_tick() {
        return segment.get(LAYOUT$num_units_in_tick, OFFSET$num_units_in_tick);
    }

    public StdVideoH264SequenceParameterSetVui num_units_in_tick(@Unsigned int value) {
        segment.set(LAYOUT$num_units_in_tick, OFFSET$num_units_in_tick, value);
        return this;
    }

    public @Unsigned int time_scale() {
        return segment.get(LAYOUT$time_scale, OFFSET$time_scale);
    }

    public StdVideoH264SequenceParameterSetVui time_scale(@Unsigned int value) {
        segment.set(LAYOUT$time_scale, OFFSET$time_scale, value);
        return this;
    }

    public @Unsigned byte max_num_reorder_frames() {
        return segment.get(LAYOUT$max_num_reorder_frames, OFFSET$max_num_reorder_frames);
    }

    public StdVideoH264SequenceParameterSetVui max_num_reorder_frames(@Unsigned byte value) {
        segment.set(LAYOUT$max_num_reorder_frames, OFFSET$max_num_reorder_frames, value);
        return this;
    }

    public @Unsigned byte max_dec_frame_buffering() {
        return segment.get(LAYOUT$max_dec_frame_buffering, OFFSET$max_dec_frame_buffering);
    }

    public StdVideoH264SequenceParameterSetVui max_dec_frame_buffering(@Unsigned byte value) {
        segment.set(LAYOUT$max_dec_frame_buffering, OFFSET$max_dec_frame_buffering, value);
        return this;
    }

    public @Unsigned byte chroma_sample_loc_type_top_field() {
        return segment.get(LAYOUT$chroma_sample_loc_type_top_field, OFFSET$chroma_sample_loc_type_top_field);
    }

    public StdVideoH264SequenceParameterSetVui chroma_sample_loc_type_top_field(@Unsigned byte value) {
        segment.set(LAYOUT$chroma_sample_loc_type_top_field, OFFSET$chroma_sample_loc_type_top_field, value);
        return this;
    }

    public @Unsigned byte chroma_sample_loc_type_bottom_field() {
        return segment.get(LAYOUT$chroma_sample_loc_type_bottom_field, OFFSET$chroma_sample_loc_type_bottom_field);
    }

    public StdVideoH264SequenceParameterSetVui chroma_sample_loc_type_bottom_field(@Unsigned byte value) {
        segment.set(LAYOUT$chroma_sample_loc_type_bottom_field, OFFSET$chroma_sample_loc_type_bottom_field, value);
        return this;
    }


    public StdVideoH264SequenceParameterSetVui pHrdParameters(@Nullable IStdVideoH264HrdParameters value) {
        MemorySegment s = value == null ? MemorySegment.NULL : value.segment();
        pHrdParametersRaw(s);
        return this;
    }

    @Unsafe public @Nullable StdVideoH264HrdParameters.Ptr pHrdParameters(int assumedCount) {
        MemorySegment s = pHrdParametersRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }

        s = s.reinterpret(assumedCount * StdVideoH264HrdParameters.BYTES);
        return new StdVideoH264HrdParameters.Ptr(s);
    }

    public @Nullable StdVideoH264HrdParameters pHrdParameters() {
        MemorySegment s = pHrdParametersRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new StdVideoH264HrdParameters(s);
    }

    public @Pointer(target=StdVideoH264HrdParameters.class) @NotNull MemorySegment pHrdParametersRaw() {
        return segment.get(LAYOUT$pHrdParameters, OFFSET$pHrdParameters);
    }

    public void pHrdParametersRaw(@Pointer(target=StdVideoH264HrdParameters.class) @NotNull MemorySegment value) {
        segment.set(LAYOUT$pHrdParameters, OFFSET$pHrdParameters, value);
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        StdVideoH264SpsVuiFlags.LAYOUT.withName("flags"),
        ValueLayout.JAVA_INT.withName("aspect_ratio_idc"),
        ValueLayout.JAVA_SHORT.withName("sar_width"),
        ValueLayout.JAVA_SHORT.withName("sar_height"),
        ValueLayout.JAVA_BYTE.withName("video_format"),
        ValueLayout.JAVA_BYTE.withName("colour_primaries"),
        ValueLayout.JAVA_BYTE.withName("transfer_characteristics"),
        ValueLayout.JAVA_BYTE.withName("matrix_coefficients"),
        ValueLayout.JAVA_INT.withName("num_units_in_tick"),
        ValueLayout.JAVA_INT.withName("time_scale"),
        ValueLayout.JAVA_BYTE.withName("max_num_reorder_frames"),
        ValueLayout.JAVA_BYTE.withName("max_dec_frame_buffering"),
        ValueLayout.JAVA_BYTE.withName("chroma_sample_loc_type_top_field"),
        ValueLayout.JAVA_BYTE.withName("chroma_sample_loc_type_bottom_field"),
        ValueLayout.JAVA_INT.withName("reserved1"),
        ValueLayout.ADDRESS.withTargetLayout(StdVideoH264HrdParameters.LAYOUT).withName("pHrdParameters")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$flags = PathElement.groupElement("flags");
    public static final PathElement PATH$aspect_ratio_idc = PathElement.groupElement("aspect_ratio_idc");
    public static final PathElement PATH$sar_width = PathElement.groupElement("sar_width");
    public static final PathElement PATH$sar_height = PathElement.groupElement("sar_height");
    public static final PathElement PATH$video_format = PathElement.groupElement("video_format");
    public static final PathElement PATH$colour_primaries = PathElement.groupElement("colour_primaries");
    public static final PathElement PATH$transfer_characteristics = PathElement.groupElement("transfer_characteristics");
    public static final PathElement PATH$matrix_coefficients = PathElement.groupElement("matrix_coefficients");
    public static final PathElement PATH$num_units_in_tick = PathElement.groupElement("num_units_in_tick");
    public static final PathElement PATH$time_scale = PathElement.groupElement("time_scale");
    public static final PathElement PATH$max_num_reorder_frames = PathElement.groupElement("max_num_reorder_frames");
    public static final PathElement PATH$max_dec_frame_buffering = PathElement.groupElement("max_dec_frame_buffering");
    public static final PathElement PATH$chroma_sample_loc_type_top_field = PathElement.groupElement("chroma_sample_loc_type_top_field");
    public static final PathElement PATH$chroma_sample_loc_type_bottom_field = PathElement.groupElement("chroma_sample_loc_type_bottom_field");
    public static final PathElement PATH$pHrdParameters = PathElement.groupElement("pHrdParameters");

    public static final StructLayout LAYOUT$flags = (StructLayout) LAYOUT.select(PATH$flags);
    public static final OfInt LAYOUT$aspect_ratio_idc = (OfInt) LAYOUT.select(PATH$aspect_ratio_idc);
    public static final OfShort LAYOUT$sar_width = (OfShort) LAYOUT.select(PATH$sar_width);
    public static final OfShort LAYOUT$sar_height = (OfShort) LAYOUT.select(PATH$sar_height);
    public static final OfByte LAYOUT$video_format = (OfByte) LAYOUT.select(PATH$video_format);
    public static final OfByte LAYOUT$colour_primaries = (OfByte) LAYOUT.select(PATH$colour_primaries);
    public static final OfByte LAYOUT$transfer_characteristics = (OfByte) LAYOUT.select(PATH$transfer_characteristics);
    public static final OfByte LAYOUT$matrix_coefficients = (OfByte) LAYOUT.select(PATH$matrix_coefficients);
    public static final OfInt LAYOUT$num_units_in_tick = (OfInt) LAYOUT.select(PATH$num_units_in_tick);
    public static final OfInt LAYOUT$time_scale = (OfInt) LAYOUT.select(PATH$time_scale);
    public static final OfByte LAYOUT$max_num_reorder_frames = (OfByte) LAYOUT.select(PATH$max_num_reorder_frames);
    public static final OfByte LAYOUT$max_dec_frame_buffering = (OfByte) LAYOUT.select(PATH$max_dec_frame_buffering);
    public static final OfByte LAYOUT$chroma_sample_loc_type_top_field = (OfByte) LAYOUT.select(PATH$chroma_sample_loc_type_top_field);
    public static final OfByte LAYOUT$chroma_sample_loc_type_bottom_field = (OfByte) LAYOUT.select(PATH$chroma_sample_loc_type_bottom_field);
    public static final AddressLayout LAYOUT$pHrdParameters = (AddressLayout) LAYOUT.select(PATH$pHrdParameters);

    public static final long SIZE$flags = LAYOUT$flags.byteSize();
    public static final long SIZE$aspect_ratio_idc = LAYOUT$aspect_ratio_idc.byteSize();
    public static final long SIZE$sar_width = LAYOUT$sar_width.byteSize();
    public static final long SIZE$sar_height = LAYOUT$sar_height.byteSize();
    public static final long SIZE$video_format = LAYOUT$video_format.byteSize();
    public static final long SIZE$colour_primaries = LAYOUT$colour_primaries.byteSize();
    public static final long SIZE$transfer_characteristics = LAYOUT$transfer_characteristics.byteSize();
    public static final long SIZE$matrix_coefficients = LAYOUT$matrix_coefficients.byteSize();
    public static final long SIZE$num_units_in_tick = LAYOUT$num_units_in_tick.byteSize();
    public static final long SIZE$time_scale = LAYOUT$time_scale.byteSize();
    public static final long SIZE$max_num_reorder_frames = LAYOUT$max_num_reorder_frames.byteSize();
    public static final long SIZE$max_dec_frame_buffering = LAYOUT$max_dec_frame_buffering.byteSize();
    public static final long SIZE$chroma_sample_loc_type_top_field = LAYOUT$chroma_sample_loc_type_top_field.byteSize();
    public static final long SIZE$chroma_sample_loc_type_bottom_field = LAYOUT$chroma_sample_loc_type_bottom_field.byteSize();
    public static final long SIZE$pHrdParameters = LAYOUT$pHrdParameters.byteSize();

    public static final long OFFSET$flags = LAYOUT.byteOffset(PATH$flags);
    public static final long OFFSET$aspect_ratio_idc = LAYOUT.byteOffset(PATH$aspect_ratio_idc);
    public static final long OFFSET$sar_width = LAYOUT.byteOffset(PATH$sar_width);
    public static final long OFFSET$sar_height = LAYOUT.byteOffset(PATH$sar_height);
    public static final long OFFSET$video_format = LAYOUT.byteOffset(PATH$video_format);
    public static final long OFFSET$colour_primaries = LAYOUT.byteOffset(PATH$colour_primaries);
    public static final long OFFSET$transfer_characteristics = LAYOUT.byteOffset(PATH$transfer_characteristics);
    public static final long OFFSET$matrix_coefficients = LAYOUT.byteOffset(PATH$matrix_coefficients);
    public static final long OFFSET$num_units_in_tick = LAYOUT.byteOffset(PATH$num_units_in_tick);
    public static final long OFFSET$time_scale = LAYOUT.byteOffset(PATH$time_scale);
    public static final long OFFSET$max_num_reorder_frames = LAYOUT.byteOffset(PATH$max_num_reorder_frames);
    public static final long OFFSET$max_dec_frame_buffering = LAYOUT.byteOffset(PATH$max_dec_frame_buffering);
    public static final long OFFSET$chroma_sample_loc_type_top_field = LAYOUT.byteOffset(PATH$chroma_sample_loc_type_top_field);
    public static final long OFFSET$chroma_sample_loc_type_bottom_field = LAYOUT.byteOffset(PATH$chroma_sample_loc_type_bottom_field);
    public static final long OFFSET$pHrdParameters = LAYOUT.byteOffset(PATH$pHrdParameters);
}
