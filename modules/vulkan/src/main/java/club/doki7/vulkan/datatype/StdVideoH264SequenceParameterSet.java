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

/// Represents a pointer to a {@code StdVideoH264SequenceParameterSet} structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct StdVideoH264SequenceParameterSet {
///     StdVideoH264SpsFlags flags; // @link substring="StdVideoH264SpsFlags" target="StdVideoH264SpsFlags" @link substring="flags" target="#flags"
///     StdVideoH264ProfileIdc profile_idc; // @link substring="StdVideoH264ProfileIdc" target="StdVideoH264ProfileIdc" @link substring="profile_idc" target="#profile_idc"
///     StdVideoH264LevelIdc level_idc; // @link substring="StdVideoH264LevelIdc" target="StdVideoH264LevelIdc" @link substring="level_idc" target="#level_idc"
///     StdVideoH264ChromaFormatIdc chroma_format_idc; // @link substring="StdVideoH264ChromaFormatIdc" target="StdVideoH264ChromaFormatIdc" @link substring="chroma_format_idc" target="#chroma_format_idc"
///     uint8_t seq_parameter_set_id; // @link substring="seq_parameter_set_id" target="#seq_parameter_set_id"
///     uint8_t bit_depth_luma_minus8; // @link substring="bit_depth_luma_minus8" target="#bit_depth_luma_minus8"
///     uint8_t bit_depth_chroma_minus8; // @link substring="bit_depth_chroma_minus8" target="#bit_depth_chroma_minus8"
///     uint8_t log2_max_frame_num_minus4; // @link substring="log2_max_frame_num_minus4" target="#log2_max_frame_num_minus4"
///     StdVideoH264PocType pic_order_cnt_type; // @link substring="StdVideoH264PocType" target="StdVideoH264PocType" @link substring="pic_order_cnt_type" target="#pic_order_cnt_type"
///     int32_t offset_for_non_ref_pic; // @link substring="offset_for_non_ref_pic" target="#offset_for_non_ref_pic"
///     int32_t offset_for_top_to_bottom_field; // @link substring="offset_for_top_to_bottom_field" target="#offset_for_top_to_bottom_field"
///     uint8_t log2_max_pic_order_cnt_lsb_minus4; // @link substring="log2_max_pic_order_cnt_lsb_minus4" target="#log2_max_pic_order_cnt_lsb_minus4"
///     uint8_t num_ref_frames_in_pic_order_cnt_cycle; // @link substring="num_ref_frames_in_pic_order_cnt_cycle" target="#num_ref_frames_in_pic_order_cnt_cycle"
///     uint8_t max_num_ref_frames; // @link substring="max_num_ref_frames" target="#max_num_ref_frames"
///     uint8_t reserved1;
///     uint32_t pic_width_in_mbs_minus1; // @link substring="pic_width_in_mbs_minus1" target="#pic_width_in_mbs_minus1"
///     uint32_t pic_height_in_map_units_minus1; // @link substring="pic_height_in_map_units_minus1" target="#pic_height_in_map_units_minus1"
///     uint32_t frame_crop_left_offset; // @link substring="frame_crop_left_offset" target="#frame_crop_left_offset"
///     uint32_t frame_crop_right_offset; // @link substring="frame_crop_right_offset" target="#frame_crop_right_offset"
///     uint32_t frame_crop_top_offset; // @link substring="frame_crop_top_offset" target="#frame_crop_top_offset"
///     uint32_t frame_crop_bottom_offset; // @link substring="frame_crop_bottom_offset" target="#frame_crop_bottom_offset"
///     uint32_t reserved2;
///     int32_t const* pOffsetForRefFrame; // @link substring="pOffsetForRefFrame" target="#pOffsetForRefFrame"
///     StdVideoH264ScalingLists const* pScalingLists; // optional // @link substring="StdVideoH264ScalingLists" target="StdVideoH264ScalingLists" @link substring="pScalingLists" target="#pScalingLists"
///     StdVideoH264SequenceParameterSetVui const* pSequenceParameterSetVui; // optional // @link substring="StdVideoH264SequenceParameterSetVui" target="StdVideoH264SequenceParameterSetVui" @link substring="pSequenceParameterSetVui" target="#pSequenceParameterSetVui"
/// } StdVideoH264SequenceParameterSet;
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
public record StdVideoH264SequenceParameterSet(@NotNull MemorySegment segment) implements IStdVideoH264SequenceParameterSet {
    /// Represents a pointer to / an array of null structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link StdVideoH264SequenceParameterSet}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IStdVideoH264SequenceParameterSet to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code StdVideoH264SequenceParameterSet.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IStdVideoH264SequenceParameterSet, Iterable<StdVideoH264SequenceParameterSet> {
        public long size() {
            return segment.byteSize() / StdVideoH264SequenceParameterSet.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull StdVideoH264SequenceParameterSet at(long index) {
            return new StdVideoH264SequenceParameterSet(segment.asSlice(index * StdVideoH264SequenceParameterSet.BYTES, StdVideoH264SequenceParameterSet.BYTES));
        }

        public StdVideoH264SequenceParameterSet.Ptr at(long index, @NotNull Consumer<@NotNull StdVideoH264SequenceParameterSet> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull StdVideoH264SequenceParameterSet value) {
            MemorySegment s = segment.asSlice(index * StdVideoH264SequenceParameterSet.BYTES, StdVideoH264SequenceParameterSet.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * StdVideoH264SequenceParameterSet.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * StdVideoH264SequenceParameterSet.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * StdVideoH264SequenceParameterSet.BYTES,
                (end - start) * StdVideoH264SequenceParameterSet.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * StdVideoH264SequenceParameterSet.BYTES));
        }

        public StdVideoH264SequenceParameterSet[] toArray() {
            StdVideoH264SequenceParameterSet[] ret = new StdVideoH264SequenceParameterSet[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<StdVideoH264SequenceParameterSet> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<StdVideoH264SequenceParameterSet> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= StdVideoH264SequenceParameterSet.BYTES;
            }

            @Override
            public StdVideoH264SequenceParameterSet next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                StdVideoH264SequenceParameterSet ret = new StdVideoH264SequenceParameterSet(segment.asSlice(0, StdVideoH264SequenceParameterSet.BYTES));
                segment = segment.asSlice(StdVideoH264SequenceParameterSet.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static StdVideoH264SequenceParameterSet allocate(Arena arena) {
        return new StdVideoH264SequenceParameterSet(arena.allocate(LAYOUT));
    }

    public static StdVideoH264SequenceParameterSet.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        return new StdVideoH264SequenceParameterSet.Ptr(segment);
    }

    public static StdVideoH264SequenceParameterSet clone(Arena arena, StdVideoH264SequenceParameterSet src) {
        StdVideoH264SequenceParameterSet ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public @NotNull StdVideoH264SpsFlags flags() {
        return new StdVideoH264SpsFlags(segment.asSlice(OFFSET$flags, LAYOUT$flags));
    }

    public StdVideoH264SequenceParameterSet flags(@NotNull StdVideoH264SpsFlags value) {
        MemorySegment.copy(value.segment(), 0, segment, OFFSET$flags, SIZE$flags);
        return this;
    }

    public StdVideoH264SequenceParameterSet flags(Consumer<@NotNull StdVideoH264SpsFlags> consumer) {
        consumer.accept(flags());
        return this;
    }

    public @EnumType(StdVideoH264ProfileIdc.class) int profile_idc() {
        return segment.get(LAYOUT$profile_idc, OFFSET$profile_idc);
    }

    public StdVideoH264SequenceParameterSet profile_idc(@EnumType(StdVideoH264ProfileIdc.class) int value) {
        segment.set(LAYOUT$profile_idc, OFFSET$profile_idc, value);
        return this;
    }

    public @EnumType(StdVideoH264LevelIdc.class) int level_idc() {
        return segment.get(LAYOUT$level_idc, OFFSET$level_idc);
    }

    public StdVideoH264SequenceParameterSet level_idc(@EnumType(StdVideoH264LevelIdc.class) int value) {
        segment.set(LAYOUT$level_idc, OFFSET$level_idc, value);
        return this;
    }

    public @EnumType(StdVideoH264ChromaFormatIdc.class) int chroma_format_idc() {
        return segment.get(LAYOUT$chroma_format_idc, OFFSET$chroma_format_idc);
    }

    public StdVideoH264SequenceParameterSet chroma_format_idc(@EnumType(StdVideoH264ChromaFormatIdc.class) int value) {
        segment.set(LAYOUT$chroma_format_idc, OFFSET$chroma_format_idc, value);
        return this;
    }

    public @Unsigned byte seq_parameter_set_id() {
        return segment.get(LAYOUT$seq_parameter_set_id, OFFSET$seq_parameter_set_id);
    }

    public StdVideoH264SequenceParameterSet seq_parameter_set_id(@Unsigned byte value) {
        segment.set(LAYOUT$seq_parameter_set_id, OFFSET$seq_parameter_set_id, value);
        return this;
    }

    public @Unsigned byte bit_depth_luma_minus8() {
        return segment.get(LAYOUT$bit_depth_luma_minus8, OFFSET$bit_depth_luma_minus8);
    }

    public StdVideoH264SequenceParameterSet bit_depth_luma_minus8(@Unsigned byte value) {
        segment.set(LAYOUT$bit_depth_luma_minus8, OFFSET$bit_depth_luma_minus8, value);
        return this;
    }

    public @Unsigned byte bit_depth_chroma_minus8() {
        return segment.get(LAYOUT$bit_depth_chroma_minus8, OFFSET$bit_depth_chroma_minus8);
    }

    public StdVideoH264SequenceParameterSet bit_depth_chroma_minus8(@Unsigned byte value) {
        segment.set(LAYOUT$bit_depth_chroma_minus8, OFFSET$bit_depth_chroma_minus8, value);
        return this;
    }

    public @Unsigned byte log2_max_frame_num_minus4() {
        return segment.get(LAYOUT$log2_max_frame_num_minus4, OFFSET$log2_max_frame_num_minus4);
    }

    public StdVideoH264SequenceParameterSet log2_max_frame_num_minus4(@Unsigned byte value) {
        segment.set(LAYOUT$log2_max_frame_num_minus4, OFFSET$log2_max_frame_num_minus4, value);
        return this;
    }

    public @EnumType(StdVideoH264PocType.class) int pic_order_cnt_type() {
        return segment.get(LAYOUT$pic_order_cnt_type, OFFSET$pic_order_cnt_type);
    }

    public StdVideoH264SequenceParameterSet pic_order_cnt_type(@EnumType(StdVideoH264PocType.class) int value) {
        segment.set(LAYOUT$pic_order_cnt_type, OFFSET$pic_order_cnt_type, value);
        return this;
    }

    public int offset_for_non_ref_pic() {
        return segment.get(LAYOUT$offset_for_non_ref_pic, OFFSET$offset_for_non_ref_pic);
    }

    public StdVideoH264SequenceParameterSet offset_for_non_ref_pic(int value) {
        segment.set(LAYOUT$offset_for_non_ref_pic, OFFSET$offset_for_non_ref_pic, value);
        return this;
    }

    public int offset_for_top_to_bottom_field() {
        return segment.get(LAYOUT$offset_for_top_to_bottom_field, OFFSET$offset_for_top_to_bottom_field);
    }

    public StdVideoH264SequenceParameterSet offset_for_top_to_bottom_field(int value) {
        segment.set(LAYOUT$offset_for_top_to_bottom_field, OFFSET$offset_for_top_to_bottom_field, value);
        return this;
    }

    public @Unsigned byte log2_max_pic_order_cnt_lsb_minus4() {
        return segment.get(LAYOUT$log2_max_pic_order_cnt_lsb_minus4, OFFSET$log2_max_pic_order_cnt_lsb_minus4);
    }

    public StdVideoH264SequenceParameterSet log2_max_pic_order_cnt_lsb_minus4(@Unsigned byte value) {
        segment.set(LAYOUT$log2_max_pic_order_cnt_lsb_minus4, OFFSET$log2_max_pic_order_cnt_lsb_minus4, value);
        return this;
    }

    public @Unsigned byte num_ref_frames_in_pic_order_cnt_cycle() {
        return segment.get(LAYOUT$num_ref_frames_in_pic_order_cnt_cycle, OFFSET$num_ref_frames_in_pic_order_cnt_cycle);
    }

    public StdVideoH264SequenceParameterSet num_ref_frames_in_pic_order_cnt_cycle(@Unsigned byte value) {
        segment.set(LAYOUT$num_ref_frames_in_pic_order_cnt_cycle, OFFSET$num_ref_frames_in_pic_order_cnt_cycle, value);
        return this;
    }

    public @Unsigned byte max_num_ref_frames() {
        return segment.get(LAYOUT$max_num_ref_frames, OFFSET$max_num_ref_frames);
    }

    public StdVideoH264SequenceParameterSet max_num_ref_frames(@Unsigned byte value) {
        segment.set(LAYOUT$max_num_ref_frames, OFFSET$max_num_ref_frames, value);
        return this;
    }


    public @Unsigned int pic_width_in_mbs_minus1() {
        return segment.get(LAYOUT$pic_width_in_mbs_minus1, OFFSET$pic_width_in_mbs_minus1);
    }

    public StdVideoH264SequenceParameterSet pic_width_in_mbs_minus1(@Unsigned int value) {
        segment.set(LAYOUT$pic_width_in_mbs_minus1, OFFSET$pic_width_in_mbs_minus1, value);
        return this;
    }

    public @Unsigned int pic_height_in_map_units_minus1() {
        return segment.get(LAYOUT$pic_height_in_map_units_minus1, OFFSET$pic_height_in_map_units_minus1);
    }

    public StdVideoH264SequenceParameterSet pic_height_in_map_units_minus1(@Unsigned int value) {
        segment.set(LAYOUT$pic_height_in_map_units_minus1, OFFSET$pic_height_in_map_units_minus1, value);
        return this;
    }

    public @Unsigned int frame_crop_left_offset() {
        return segment.get(LAYOUT$frame_crop_left_offset, OFFSET$frame_crop_left_offset);
    }

    public StdVideoH264SequenceParameterSet frame_crop_left_offset(@Unsigned int value) {
        segment.set(LAYOUT$frame_crop_left_offset, OFFSET$frame_crop_left_offset, value);
        return this;
    }

    public @Unsigned int frame_crop_right_offset() {
        return segment.get(LAYOUT$frame_crop_right_offset, OFFSET$frame_crop_right_offset);
    }

    public StdVideoH264SequenceParameterSet frame_crop_right_offset(@Unsigned int value) {
        segment.set(LAYOUT$frame_crop_right_offset, OFFSET$frame_crop_right_offset, value);
        return this;
    }

    public @Unsigned int frame_crop_top_offset() {
        return segment.get(LAYOUT$frame_crop_top_offset, OFFSET$frame_crop_top_offset);
    }

    public StdVideoH264SequenceParameterSet frame_crop_top_offset(@Unsigned int value) {
        segment.set(LAYOUT$frame_crop_top_offset, OFFSET$frame_crop_top_offset, value);
        return this;
    }

    public @Unsigned int frame_crop_bottom_offset() {
        return segment.get(LAYOUT$frame_crop_bottom_offset, OFFSET$frame_crop_bottom_offset);
    }

    public StdVideoH264SequenceParameterSet frame_crop_bottom_offset(@Unsigned int value) {
        segment.set(LAYOUT$frame_crop_bottom_offset, OFFSET$frame_crop_bottom_offset, value);
        return this;
    }


    /// Note: the returned {@link IntPtr} does not have correct
    /// {@link IntPtr#size} property. It's up to user to track the size of the buffer,
    /// and use {@link IntPtr#reinterpret} to set the size before actually reading from or
    /// writing to the buffer.
    public @Nullable IntPtr pOffsetForRefFrame() {
        MemorySegment s = pOffsetForRefFrameRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new IntPtr(s);
    }

    public StdVideoH264SequenceParameterSet pOffsetForRefFrame(@Nullable IntPtr value) {
        MemorySegment s = value == null ? MemorySegment.NULL : value.segment();
        pOffsetForRefFrameRaw(s);
        return this;
    }

    public @Pointer(comment="int32_t*") @NotNull MemorySegment pOffsetForRefFrameRaw() {
        return segment.get(LAYOUT$pOffsetForRefFrame, OFFSET$pOffsetForRefFrame);
    }

    public void pOffsetForRefFrameRaw(@Pointer(comment="int32_t*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pOffsetForRefFrame, OFFSET$pOffsetForRefFrame, value);
    }

    public StdVideoH264SequenceParameterSet pScalingLists(@Nullable IStdVideoH264ScalingLists value) {
        MemorySegment s = value == null ? MemorySegment.NULL : value.segment();
        pScalingListsRaw(s);
        return this;
    }

    @Unsafe public @Nullable StdVideoH264ScalingLists.Ptr pScalingLists(int assumedCount) {
        MemorySegment s = pScalingListsRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }

        s = s.reinterpret(assumedCount * StdVideoH264ScalingLists.BYTES);
        return new StdVideoH264ScalingLists.Ptr(s);
    }

    public @Nullable StdVideoH264ScalingLists pScalingLists() {
        MemorySegment s = pScalingListsRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new StdVideoH264ScalingLists(s);
    }

    public @Pointer(target=StdVideoH264ScalingLists.class) @NotNull MemorySegment pScalingListsRaw() {
        return segment.get(LAYOUT$pScalingLists, OFFSET$pScalingLists);
    }

    public void pScalingListsRaw(@Pointer(target=StdVideoH264ScalingLists.class) @NotNull MemorySegment value) {
        segment.set(LAYOUT$pScalingLists, OFFSET$pScalingLists, value);
    }

    public StdVideoH264SequenceParameterSet pSequenceParameterSetVui(@Nullable IStdVideoH264SequenceParameterSetVui value) {
        MemorySegment s = value == null ? MemorySegment.NULL : value.segment();
        pSequenceParameterSetVuiRaw(s);
        return this;
    }

    @Unsafe public @Nullable StdVideoH264SequenceParameterSetVui.Ptr pSequenceParameterSetVui(int assumedCount) {
        MemorySegment s = pSequenceParameterSetVuiRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }

        s = s.reinterpret(assumedCount * StdVideoH264SequenceParameterSetVui.BYTES);
        return new StdVideoH264SequenceParameterSetVui.Ptr(s);
    }

    public @Nullable StdVideoH264SequenceParameterSetVui pSequenceParameterSetVui() {
        MemorySegment s = pSequenceParameterSetVuiRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new StdVideoH264SequenceParameterSetVui(s);
    }

    public @Pointer(target=StdVideoH264SequenceParameterSetVui.class) @NotNull MemorySegment pSequenceParameterSetVuiRaw() {
        return segment.get(LAYOUT$pSequenceParameterSetVui, OFFSET$pSequenceParameterSetVui);
    }

    public void pSequenceParameterSetVuiRaw(@Pointer(target=StdVideoH264SequenceParameterSetVui.class) @NotNull MemorySegment value) {
        segment.set(LAYOUT$pSequenceParameterSetVui, OFFSET$pSequenceParameterSetVui, value);
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        StdVideoH264SpsFlags.LAYOUT.withName("flags"),
        ValueLayout.JAVA_INT.withName("profile_idc"),
        ValueLayout.JAVA_INT.withName("level_idc"),
        ValueLayout.JAVA_INT.withName("chroma_format_idc"),
        ValueLayout.JAVA_BYTE.withName("seq_parameter_set_id"),
        ValueLayout.JAVA_BYTE.withName("bit_depth_luma_minus8"),
        ValueLayout.JAVA_BYTE.withName("bit_depth_chroma_minus8"),
        ValueLayout.JAVA_BYTE.withName("log2_max_frame_num_minus4"),
        ValueLayout.JAVA_INT.withName("pic_order_cnt_type"),
        ValueLayout.JAVA_INT.withName("offset_for_non_ref_pic"),
        ValueLayout.JAVA_INT.withName("offset_for_top_to_bottom_field"),
        ValueLayout.JAVA_BYTE.withName("log2_max_pic_order_cnt_lsb_minus4"),
        ValueLayout.JAVA_BYTE.withName("num_ref_frames_in_pic_order_cnt_cycle"),
        ValueLayout.JAVA_BYTE.withName("max_num_ref_frames"),
        ValueLayout.JAVA_BYTE.withName("reserved1"),
        ValueLayout.JAVA_INT.withName("pic_width_in_mbs_minus1"),
        ValueLayout.JAVA_INT.withName("pic_height_in_map_units_minus1"),
        ValueLayout.JAVA_INT.withName("frame_crop_left_offset"),
        ValueLayout.JAVA_INT.withName("frame_crop_right_offset"),
        ValueLayout.JAVA_INT.withName("frame_crop_top_offset"),
        ValueLayout.JAVA_INT.withName("frame_crop_bottom_offset"),
        ValueLayout.JAVA_INT.withName("reserved2"),
        ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT).withName("pOffsetForRefFrame"),
        ValueLayout.ADDRESS.withTargetLayout(StdVideoH264ScalingLists.LAYOUT).withName("pScalingLists"),
        ValueLayout.ADDRESS.withTargetLayout(StdVideoH264SequenceParameterSetVui.LAYOUT).withName("pSequenceParameterSetVui")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$flags = PathElement.groupElement("flags");
    public static final PathElement PATH$profile_idc = PathElement.groupElement("profile_idc");
    public static final PathElement PATH$level_idc = PathElement.groupElement("level_idc");
    public static final PathElement PATH$chroma_format_idc = PathElement.groupElement("chroma_format_idc");
    public static final PathElement PATH$seq_parameter_set_id = PathElement.groupElement("seq_parameter_set_id");
    public static final PathElement PATH$bit_depth_luma_minus8 = PathElement.groupElement("bit_depth_luma_minus8");
    public static final PathElement PATH$bit_depth_chroma_minus8 = PathElement.groupElement("bit_depth_chroma_minus8");
    public static final PathElement PATH$log2_max_frame_num_minus4 = PathElement.groupElement("log2_max_frame_num_minus4");
    public static final PathElement PATH$pic_order_cnt_type = PathElement.groupElement("pic_order_cnt_type");
    public static final PathElement PATH$offset_for_non_ref_pic = PathElement.groupElement("offset_for_non_ref_pic");
    public static final PathElement PATH$offset_for_top_to_bottom_field = PathElement.groupElement("offset_for_top_to_bottom_field");
    public static final PathElement PATH$log2_max_pic_order_cnt_lsb_minus4 = PathElement.groupElement("log2_max_pic_order_cnt_lsb_minus4");
    public static final PathElement PATH$num_ref_frames_in_pic_order_cnt_cycle = PathElement.groupElement("num_ref_frames_in_pic_order_cnt_cycle");
    public static final PathElement PATH$max_num_ref_frames = PathElement.groupElement("max_num_ref_frames");
    public static final PathElement PATH$pic_width_in_mbs_minus1 = PathElement.groupElement("pic_width_in_mbs_minus1");
    public static final PathElement PATH$pic_height_in_map_units_minus1 = PathElement.groupElement("pic_height_in_map_units_minus1");
    public static final PathElement PATH$frame_crop_left_offset = PathElement.groupElement("frame_crop_left_offset");
    public static final PathElement PATH$frame_crop_right_offset = PathElement.groupElement("frame_crop_right_offset");
    public static final PathElement PATH$frame_crop_top_offset = PathElement.groupElement("frame_crop_top_offset");
    public static final PathElement PATH$frame_crop_bottom_offset = PathElement.groupElement("frame_crop_bottom_offset");
    public static final PathElement PATH$pOffsetForRefFrame = PathElement.groupElement("pOffsetForRefFrame");
    public static final PathElement PATH$pScalingLists = PathElement.groupElement("pScalingLists");
    public static final PathElement PATH$pSequenceParameterSetVui = PathElement.groupElement("pSequenceParameterSetVui");

    public static final StructLayout LAYOUT$flags = (StructLayout) LAYOUT.select(PATH$flags);
    public static final OfInt LAYOUT$profile_idc = (OfInt) LAYOUT.select(PATH$profile_idc);
    public static final OfInt LAYOUT$level_idc = (OfInt) LAYOUT.select(PATH$level_idc);
    public static final OfInt LAYOUT$chroma_format_idc = (OfInt) LAYOUT.select(PATH$chroma_format_idc);
    public static final OfByte LAYOUT$seq_parameter_set_id = (OfByte) LAYOUT.select(PATH$seq_parameter_set_id);
    public static final OfByte LAYOUT$bit_depth_luma_minus8 = (OfByte) LAYOUT.select(PATH$bit_depth_luma_minus8);
    public static final OfByte LAYOUT$bit_depth_chroma_minus8 = (OfByte) LAYOUT.select(PATH$bit_depth_chroma_minus8);
    public static final OfByte LAYOUT$log2_max_frame_num_minus4 = (OfByte) LAYOUT.select(PATH$log2_max_frame_num_minus4);
    public static final OfInt LAYOUT$pic_order_cnt_type = (OfInt) LAYOUT.select(PATH$pic_order_cnt_type);
    public static final OfInt LAYOUT$offset_for_non_ref_pic = (OfInt) LAYOUT.select(PATH$offset_for_non_ref_pic);
    public static final OfInt LAYOUT$offset_for_top_to_bottom_field = (OfInt) LAYOUT.select(PATH$offset_for_top_to_bottom_field);
    public static final OfByte LAYOUT$log2_max_pic_order_cnt_lsb_minus4 = (OfByte) LAYOUT.select(PATH$log2_max_pic_order_cnt_lsb_minus4);
    public static final OfByte LAYOUT$num_ref_frames_in_pic_order_cnt_cycle = (OfByte) LAYOUT.select(PATH$num_ref_frames_in_pic_order_cnt_cycle);
    public static final OfByte LAYOUT$max_num_ref_frames = (OfByte) LAYOUT.select(PATH$max_num_ref_frames);
    public static final OfInt LAYOUT$pic_width_in_mbs_minus1 = (OfInt) LAYOUT.select(PATH$pic_width_in_mbs_minus1);
    public static final OfInt LAYOUT$pic_height_in_map_units_minus1 = (OfInt) LAYOUT.select(PATH$pic_height_in_map_units_minus1);
    public static final OfInt LAYOUT$frame_crop_left_offset = (OfInt) LAYOUT.select(PATH$frame_crop_left_offset);
    public static final OfInt LAYOUT$frame_crop_right_offset = (OfInt) LAYOUT.select(PATH$frame_crop_right_offset);
    public static final OfInt LAYOUT$frame_crop_top_offset = (OfInt) LAYOUT.select(PATH$frame_crop_top_offset);
    public static final OfInt LAYOUT$frame_crop_bottom_offset = (OfInt) LAYOUT.select(PATH$frame_crop_bottom_offset);
    public static final AddressLayout LAYOUT$pOffsetForRefFrame = (AddressLayout) LAYOUT.select(PATH$pOffsetForRefFrame);
    public static final AddressLayout LAYOUT$pScalingLists = (AddressLayout) LAYOUT.select(PATH$pScalingLists);
    public static final AddressLayout LAYOUT$pSequenceParameterSetVui = (AddressLayout) LAYOUT.select(PATH$pSequenceParameterSetVui);

    public static final long SIZE$flags = LAYOUT$flags.byteSize();
    public static final long SIZE$profile_idc = LAYOUT$profile_idc.byteSize();
    public static final long SIZE$level_idc = LAYOUT$level_idc.byteSize();
    public static final long SIZE$chroma_format_idc = LAYOUT$chroma_format_idc.byteSize();
    public static final long SIZE$seq_parameter_set_id = LAYOUT$seq_parameter_set_id.byteSize();
    public static final long SIZE$bit_depth_luma_minus8 = LAYOUT$bit_depth_luma_minus8.byteSize();
    public static final long SIZE$bit_depth_chroma_minus8 = LAYOUT$bit_depth_chroma_minus8.byteSize();
    public static final long SIZE$log2_max_frame_num_minus4 = LAYOUT$log2_max_frame_num_minus4.byteSize();
    public static final long SIZE$pic_order_cnt_type = LAYOUT$pic_order_cnt_type.byteSize();
    public static final long SIZE$offset_for_non_ref_pic = LAYOUT$offset_for_non_ref_pic.byteSize();
    public static final long SIZE$offset_for_top_to_bottom_field = LAYOUT$offset_for_top_to_bottom_field.byteSize();
    public static final long SIZE$log2_max_pic_order_cnt_lsb_minus4 = LAYOUT$log2_max_pic_order_cnt_lsb_minus4.byteSize();
    public static final long SIZE$num_ref_frames_in_pic_order_cnt_cycle = LAYOUT$num_ref_frames_in_pic_order_cnt_cycle.byteSize();
    public static final long SIZE$max_num_ref_frames = LAYOUT$max_num_ref_frames.byteSize();
    public static final long SIZE$pic_width_in_mbs_minus1 = LAYOUT$pic_width_in_mbs_minus1.byteSize();
    public static final long SIZE$pic_height_in_map_units_minus1 = LAYOUT$pic_height_in_map_units_minus1.byteSize();
    public static final long SIZE$frame_crop_left_offset = LAYOUT$frame_crop_left_offset.byteSize();
    public static final long SIZE$frame_crop_right_offset = LAYOUT$frame_crop_right_offset.byteSize();
    public static final long SIZE$frame_crop_top_offset = LAYOUT$frame_crop_top_offset.byteSize();
    public static final long SIZE$frame_crop_bottom_offset = LAYOUT$frame_crop_bottom_offset.byteSize();
    public static final long SIZE$pOffsetForRefFrame = LAYOUT$pOffsetForRefFrame.byteSize();
    public static final long SIZE$pScalingLists = LAYOUT$pScalingLists.byteSize();
    public static final long SIZE$pSequenceParameterSetVui = LAYOUT$pSequenceParameterSetVui.byteSize();

    public static final long OFFSET$flags = LAYOUT.byteOffset(PATH$flags);
    public static final long OFFSET$profile_idc = LAYOUT.byteOffset(PATH$profile_idc);
    public static final long OFFSET$level_idc = LAYOUT.byteOffset(PATH$level_idc);
    public static final long OFFSET$chroma_format_idc = LAYOUT.byteOffset(PATH$chroma_format_idc);
    public static final long OFFSET$seq_parameter_set_id = LAYOUT.byteOffset(PATH$seq_parameter_set_id);
    public static final long OFFSET$bit_depth_luma_minus8 = LAYOUT.byteOffset(PATH$bit_depth_luma_minus8);
    public static final long OFFSET$bit_depth_chroma_minus8 = LAYOUT.byteOffset(PATH$bit_depth_chroma_minus8);
    public static final long OFFSET$log2_max_frame_num_minus4 = LAYOUT.byteOffset(PATH$log2_max_frame_num_minus4);
    public static final long OFFSET$pic_order_cnt_type = LAYOUT.byteOffset(PATH$pic_order_cnt_type);
    public static final long OFFSET$offset_for_non_ref_pic = LAYOUT.byteOffset(PATH$offset_for_non_ref_pic);
    public static final long OFFSET$offset_for_top_to_bottom_field = LAYOUT.byteOffset(PATH$offset_for_top_to_bottom_field);
    public static final long OFFSET$log2_max_pic_order_cnt_lsb_minus4 = LAYOUT.byteOffset(PATH$log2_max_pic_order_cnt_lsb_minus4);
    public static final long OFFSET$num_ref_frames_in_pic_order_cnt_cycle = LAYOUT.byteOffset(PATH$num_ref_frames_in_pic_order_cnt_cycle);
    public static final long OFFSET$max_num_ref_frames = LAYOUT.byteOffset(PATH$max_num_ref_frames);
    public static final long OFFSET$pic_width_in_mbs_minus1 = LAYOUT.byteOffset(PATH$pic_width_in_mbs_minus1);
    public static final long OFFSET$pic_height_in_map_units_minus1 = LAYOUT.byteOffset(PATH$pic_height_in_map_units_minus1);
    public static final long OFFSET$frame_crop_left_offset = LAYOUT.byteOffset(PATH$frame_crop_left_offset);
    public static final long OFFSET$frame_crop_right_offset = LAYOUT.byteOffset(PATH$frame_crop_right_offset);
    public static final long OFFSET$frame_crop_top_offset = LAYOUT.byteOffset(PATH$frame_crop_top_offset);
    public static final long OFFSET$frame_crop_bottom_offset = LAYOUT.byteOffset(PATH$frame_crop_bottom_offset);
    public static final long OFFSET$pOffsetForRefFrame = LAYOUT.byteOffset(PATH$pOffsetForRefFrame);
    public static final long OFFSET$pScalingLists = LAYOUT.byteOffset(PATH$pScalingLists);
    public static final long OFFSET$pSequenceParameterSetVui = LAYOUT.byteOffset(PATH$pSequenceParameterSetVui);
}
