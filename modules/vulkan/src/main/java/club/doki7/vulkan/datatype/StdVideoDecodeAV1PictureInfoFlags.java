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

/// Represents a pointer to a {@code StdVideoDecodeAV1PictureInfoFlags} structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct StdVideoDecodeAV1PictureInfoFlags {
///     uint32_t error_resilient_mode : 1; // @link substring="error_resilient_mode" target="#error_resilient_mode"
///     uint32_t disable_cdf_update : 1; // @link substring="disable_cdf_update" target="#disable_cdf_update"
///     uint32_t use_superres : 1; // @link substring="use_superres" target="#use_superres"
///     uint32_t render_and_frame_size_different : 1; // @link substring="render_and_frame_size_different" target="#render_and_frame_size_different"
///     uint32_t allow_screen_content_tools : 1; // @link substring="allow_screen_content_tools" target="#allow_screen_content_tools"
///     uint32_t is_filter_switchable : 1; // @link substring="is_filter_switchable" target="#is_filter_switchable"
///     uint32_t force_integer_mv : 1; // @link substring="force_integer_mv" target="#force_integer_mv"
///     uint32_t frame_size_override_flag : 1; // @link substring="frame_size_override_flag" target="#frame_size_override_flag"
///     uint32_t buffer_removal_time_present_flag : 1; // @link substring="buffer_removal_time_present_flag" target="#buffer_removal_time_present_flag"
///     uint32_t allow_intrabc : 1; // @link substring="allow_intrabc" target="#allow_intrabc"
///     uint32_t frame_refs_short_signaling : 1; // @link substring="frame_refs_short_signaling" target="#frame_refs_short_signaling"
///     uint32_t allow_high_precision_mv : 1; // @link substring="allow_high_precision_mv" target="#allow_high_precision_mv"
///     uint32_t is_motion_mode_switchable : 1; // @link substring="is_motion_mode_switchable" target="#is_motion_mode_switchable"
///     uint32_t use_ref_frame_mvs : 1; // @link substring="use_ref_frame_mvs" target="#use_ref_frame_mvs"
///     uint32_t disable_frame_end_update_cdf : 1; // @link substring="disable_frame_end_update_cdf" target="#disable_frame_end_update_cdf"
///     uint32_t allow_warped_motion : 1; // @link substring="allow_warped_motion" target="#allow_warped_motion"
///     uint32_t reduced_tx_set : 1; // @link substring="reduced_tx_set" target="#reduced_tx_set"
///     uint32_t reference_select : 1; // @link substring="reference_select" target="#reference_select"
///     uint32_t skip_mode_present : 1; // @link substring="skip_mode_present" target="#skip_mode_present"
///     uint32_t delta_q_present : 1; // @link substring="delta_q_present" target="#delta_q_present"
///     uint32_t delta_lf_present : 1; // @link substring="delta_lf_present" target="#delta_lf_present"
///     uint32_t delta_lf_multi : 1; // @link substring="delta_lf_multi" target="#delta_lf_multi"
///     uint32_t segmentation_enabled : 1; // @link substring="segmentation_enabled" target="#segmentation_enabled"
///     uint32_t segmentation_update_map : 1; // @link substring="segmentation_update_map" target="#segmentation_update_map"
///     uint32_t segmentation_temporal_update : 1; // @link substring="segmentation_temporal_update" target="#segmentation_temporal_update"
///     uint32_t segmentation_update_data : 1; // @link substring="segmentation_update_data" target="#segmentation_update_data"
///     uint32_t UsesLr : 1; // @link substring="UsesLr" target="#UsesLr"
///     uint32_t usesChromaLr : 1; // @link substring="usesChromaLr" target="#usesChromaLr"
///     uint32_t apply_grain : 1; // @link substring="apply_grain" target="#apply_grain"
///     uint32_t reserved : 3;
/// } StdVideoDecodeAV1PictureInfoFlags;
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
public record StdVideoDecodeAV1PictureInfoFlags(@NotNull MemorySegment segment) implements IStdVideoDecodeAV1PictureInfoFlags {
    /// Represents a pointer to / an array of null structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link StdVideoDecodeAV1PictureInfoFlags}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IStdVideoDecodeAV1PictureInfoFlags to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code StdVideoDecodeAV1PictureInfoFlags.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IStdVideoDecodeAV1PictureInfoFlags, Iterable<StdVideoDecodeAV1PictureInfoFlags> {
        public long size() {
            return segment.byteSize() / StdVideoDecodeAV1PictureInfoFlags.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull StdVideoDecodeAV1PictureInfoFlags at(long index) {
            return new StdVideoDecodeAV1PictureInfoFlags(segment.asSlice(index * StdVideoDecodeAV1PictureInfoFlags.BYTES, StdVideoDecodeAV1PictureInfoFlags.BYTES));
        }

        public StdVideoDecodeAV1PictureInfoFlags.Ptr at(long index, @NotNull Consumer<@NotNull StdVideoDecodeAV1PictureInfoFlags> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull StdVideoDecodeAV1PictureInfoFlags value) {
            MemorySegment s = segment.asSlice(index * StdVideoDecodeAV1PictureInfoFlags.BYTES, StdVideoDecodeAV1PictureInfoFlags.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * StdVideoDecodeAV1PictureInfoFlags.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * StdVideoDecodeAV1PictureInfoFlags.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * StdVideoDecodeAV1PictureInfoFlags.BYTES,
                (end - start) * StdVideoDecodeAV1PictureInfoFlags.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * StdVideoDecodeAV1PictureInfoFlags.BYTES));
        }

        public StdVideoDecodeAV1PictureInfoFlags[] toArray() {
            StdVideoDecodeAV1PictureInfoFlags[] ret = new StdVideoDecodeAV1PictureInfoFlags[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<StdVideoDecodeAV1PictureInfoFlags> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<StdVideoDecodeAV1PictureInfoFlags> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= StdVideoDecodeAV1PictureInfoFlags.BYTES;
            }

            @Override
            public StdVideoDecodeAV1PictureInfoFlags next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                StdVideoDecodeAV1PictureInfoFlags ret = new StdVideoDecodeAV1PictureInfoFlags(segment.asSlice(0, StdVideoDecodeAV1PictureInfoFlags.BYTES));
                segment = segment.asSlice(StdVideoDecodeAV1PictureInfoFlags.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static StdVideoDecodeAV1PictureInfoFlags allocate(Arena arena) {
        return new StdVideoDecodeAV1PictureInfoFlags(arena.allocate(LAYOUT));
    }

    public static StdVideoDecodeAV1PictureInfoFlags.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        return new StdVideoDecodeAV1PictureInfoFlags.Ptr(segment);
    }

    public static StdVideoDecodeAV1PictureInfoFlags clone(Arena arena, StdVideoDecodeAV1PictureInfoFlags src) {
        StdVideoDecodeAV1PictureInfoFlags ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public boolean error_resilient_mode() {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$error_resilient_mode$reserved, LAYOUT$bitfield$error_resilient_mode$reserved);
        return BitfieldUtil.readBit(s, 0);
    }

    public StdVideoDecodeAV1PictureInfoFlags error_resilient_mode(boolean value) {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$error_resilient_mode$reserved, LAYOUT$bitfield$error_resilient_mode$reserved);
        BitfieldUtil.writeBit(s, 0, value);
        return this;
    }

    public boolean disable_cdf_update() {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$error_resilient_mode$reserved, LAYOUT$bitfield$error_resilient_mode$reserved);
        return BitfieldUtil.readBit(s, 1);
    }

    public StdVideoDecodeAV1PictureInfoFlags disable_cdf_update(boolean value) {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$error_resilient_mode$reserved, LAYOUT$bitfield$error_resilient_mode$reserved);
        BitfieldUtil.writeBit(s, 1, value);
        return this;
    }

    public boolean use_superres() {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$error_resilient_mode$reserved, LAYOUT$bitfield$error_resilient_mode$reserved);
        return BitfieldUtil.readBit(s, 2);
    }

    public StdVideoDecodeAV1PictureInfoFlags use_superres(boolean value) {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$error_resilient_mode$reserved, LAYOUT$bitfield$error_resilient_mode$reserved);
        BitfieldUtil.writeBit(s, 2, value);
        return this;
    }

    public boolean render_and_frame_size_different() {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$error_resilient_mode$reserved, LAYOUT$bitfield$error_resilient_mode$reserved);
        return BitfieldUtil.readBit(s, 3);
    }

    public StdVideoDecodeAV1PictureInfoFlags render_and_frame_size_different(boolean value) {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$error_resilient_mode$reserved, LAYOUT$bitfield$error_resilient_mode$reserved);
        BitfieldUtil.writeBit(s, 3, value);
        return this;
    }

    public boolean allow_screen_content_tools() {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$error_resilient_mode$reserved, LAYOUT$bitfield$error_resilient_mode$reserved);
        return BitfieldUtil.readBit(s, 4);
    }

    public StdVideoDecodeAV1PictureInfoFlags allow_screen_content_tools(boolean value) {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$error_resilient_mode$reserved, LAYOUT$bitfield$error_resilient_mode$reserved);
        BitfieldUtil.writeBit(s, 4, value);
        return this;
    }

    public boolean is_filter_switchable() {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$error_resilient_mode$reserved, LAYOUT$bitfield$error_resilient_mode$reserved);
        return BitfieldUtil.readBit(s, 5);
    }

    public StdVideoDecodeAV1PictureInfoFlags is_filter_switchable(boolean value) {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$error_resilient_mode$reserved, LAYOUT$bitfield$error_resilient_mode$reserved);
        BitfieldUtil.writeBit(s, 5, value);
        return this;
    }

    public boolean force_integer_mv() {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$error_resilient_mode$reserved, LAYOUT$bitfield$error_resilient_mode$reserved);
        return BitfieldUtil.readBit(s, 6);
    }

    public StdVideoDecodeAV1PictureInfoFlags force_integer_mv(boolean value) {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$error_resilient_mode$reserved, LAYOUT$bitfield$error_resilient_mode$reserved);
        BitfieldUtil.writeBit(s, 6, value);
        return this;
    }

    public boolean frame_size_override_flag() {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$error_resilient_mode$reserved, LAYOUT$bitfield$error_resilient_mode$reserved);
        return BitfieldUtil.readBit(s, 7);
    }

    public StdVideoDecodeAV1PictureInfoFlags frame_size_override_flag(boolean value) {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$error_resilient_mode$reserved, LAYOUT$bitfield$error_resilient_mode$reserved);
        BitfieldUtil.writeBit(s, 7, value);
        return this;
    }

    public boolean buffer_removal_time_present_flag() {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$error_resilient_mode$reserved, LAYOUT$bitfield$error_resilient_mode$reserved);
        return BitfieldUtil.readBit(s, 8);
    }

    public StdVideoDecodeAV1PictureInfoFlags buffer_removal_time_present_flag(boolean value) {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$error_resilient_mode$reserved, LAYOUT$bitfield$error_resilient_mode$reserved);
        BitfieldUtil.writeBit(s, 8, value);
        return this;
    }

    public boolean allow_intrabc() {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$error_resilient_mode$reserved, LAYOUT$bitfield$error_resilient_mode$reserved);
        return BitfieldUtil.readBit(s, 9);
    }

    public StdVideoDecodeAV1PictureInfoFlags allow_intrabc(boolean value) {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$error_resilient_mode$reserved, LAYOUT$bitfield$error_resilient_mode$reserved);
        BitfieldUtil.writeBit(s, 9, value);
        return this;
    }

    public boolean frame_refs_short_signaling() {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$error_resilient_mode$reserved, LAYOUT$bitfield$error_resilient_mode$reserved);
        return BitfieldUtil.readBit(s, 10);
    }

    public StdVideoDecodeAV1PictureInfoFlags frame_refs_short_signaling(boolean value) {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$error_resilient_mode$reserved, LAYOUT$bitfield$error_resilient_mode$reserved);
        BitfieldUtil.writeBit(s, 10, value);
        return this;
    }

    public boolean allow_high_precision_mv() {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$error_resilient_mode$reserved, LAYOUT$bitfield$error_resilient_mode$reserved);
        return BitfieldUtil.readBit(s, 11);
    }

    public StdVideoDecodeAV1PictureInfoFlags allow_high_precision_mv(boolean value) {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$error_resilient_mode$reserved, LAYOUT$bitfield$error_resilient_mode$reserved);
        BitfieldUtil.writeBit(s, 11, value);
        return this;
    }

    public boolean is_motion_mode_switchable() {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$error_resilient_mode$reserved, LAYOUT$bitfield$error_resilient_mode$reserved);
        return BitfieldUtil.readBit(s, 12);
    }

    public StdVideoDecodeAV1PictureInfoFlags is_motion_mode_switchable(boolean value) {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$error_resilient_mode$reserved, LAYOUT$bitfield$error_resilient_mode$reserved);
        BitfieldUtil.writeBit(s, 12, value);
        return this;
    }

    public boolean use_ref_frame_mvs() {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$error_resilient_mode$reserved, LAYOUT$bitfield$error_resilient_mode$reserved);
        return BitfieldUtil.readBit(s, 13);
    }

    public StdVideoDecodeAV1PictureInfoFlags use_ref_frame_mvs(boolean value) {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$error_resilient_mode$reserved, LAYOUT$bitfield$error_resilient_mode$reserved);
        BitfieldUtil.writeBit(s, 13, value);
        return this;
    }

    public boolean disable_frame_end_update_cdf() {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$error_resilient_mode$reserved, LAYOUT$bitfield$error_resilient_mode$reserved);
        return BitfieldUtil.readBit(s, 14);
    }

    public StdVideoDecodeAV1PictureInfoFlags disable_frame_end_update_cdf(boolean value) {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$error_resilient_mode$reserved, LAYOUT$bitfield$error_resilient_mode$reserved);
        BitfieldUtil.writeBit(s, 14, value);
        return this;
    }

    public boolean allow_warped_motion() {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$error_resilient_mode$reserved, LAYOUT$bitfield$error_resilient_mode$reserved);
        return BitfieldUtil.readBit(s, 15);
    }

    public StdVideoDecodeAV1PictureInfoFlags allow_warped_motion(boolean value) {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$error_resilient_mode$reserved, LAYOUT$bitfield$error_resilient_mode$reserved);
        BitfieldUtil.writeBit(s, 15, value);
        return this;
    }

    public boolean reduced_tx_set() {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$error_resilient_mode$reserved, LAYOUT$bitfield$error_resilient_mode$reserved);
        return BitfieldUtil.readBit(s, 16);
    }

    public StdVideoDecodeAV1PictureInfoFlags reduced_tx_set(boolean value) {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$error_resilient_mode$reserved, LAYOUT$bitfield$error_resilient_mode$reserved);
        BitfieldUtil.writeBit(s, 16, value);
        return this;
    }

    public boolean reference_select() {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$error_resilient_mode$reserved, LAYOUT$bitfield$error_resilient_mode$reserved);
        return BitfieldUtil.readBit(s, 17);
    }

    public StdVideoDecodeAV1PictureInfoFlags reference_select(boolean value) {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$error_resilient_mode$reserved, LAYOUT$bitfield$error_resilient_mode$reserved);
        BitfieldUtil.writeBit(s, 17, value);
        return this;
    }

    public boolean skip_mode_present() {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$error_resilient_mode$reserved, LAYOUT$bitfield$error_resilient_mode$reserved);
        return BitfieldUtil.readBit(s, 18);
    }

    public StdVideoDecodeAV1PictureInfoFlags skip_mode_present(boolean value) {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$error_resilient_mode$reserved, LAYOUT$bitfield$error_resilient_mode$reserved);
        BitfieldUtil.writeBit(s, 18, value);
        return this;
    }

    public boolean delta_q_present() {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$error_resilient_mode$reserved, LAYOUT$bitfield$error_resilient_mode$reserved);
        return BitfieldUtil.readBit(s, 19);
    }

    public StdVideoDecodeAV1PictureInfoFlags delta_q_present(boolean value) {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$error_resilient_mode$reserved, LAYOUT$bitfield$error_resilient_mode$reserved);
        BitfieldUtil.writeBit(s, 19, value);
        return this;
    }

    public boolean delta_lf_present() {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$error_resilient_mode$reserved, LAYOUT$bitfield$error_resilient_mode$reserved);
        return BitfieldUtil.readBit(s, 20);
    }

    public StdVideoDecodeAV1PictureInfoFlags delta_lf_present(boolean value) {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$error_resilient_mode$reserved, LAYOUT$bitfield$error_resilient_mode$reserved);
        BitfieldUtil.writeBit(s, 20, value);
        return this;
    }

    public boolean delta_lf_multi() {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$error_resilient_mode$reserved, LAYOUT$bitfield$error_resilient_mode$reserved);
        return BitfieldUtil.readBit(s, 21);
    }

    public StdVideoDecodeAV1PictureInfoFlags delta_lf_multi(boolean value) {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$error_resilient_mode$reserved, LAYOUT$bitfield$error_resilient_mode$reserved);
        BitfieldUtil.writeBit(s, 21, value);
        return this;
    }

    public boolean segmentation_enabled() {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$error_resilient_mode$reserved, LAYOUT$bitfield$error_resilient_mode$reserved);
        return BitfieldUtil.readBit(s, 22);
    }

    public StdVideoDecodeAV1PictureInfoFlags segmentation_enabled(boolean value) {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$error_resilient_mode$reserved, LAYOUT$bitfield$error_resilient_mode$reserved);
        BitfieldUtil.writeBit(s, 22, value);
        return this;
    }

    public boolean segmentation_update_map() {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$error_resilient_mode$reserved, LAYOUT$bitfield$error_resilient_mode$reserved);
        return BitfieldUtil.readBit(s, 23);
    }

    public StdVideoDecodeAV1PictureInfoFlags segmentation_update_map(boolean value) {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$error_resilient_mode$reserved, LAYOUT$bitfield$error_resilient_mode$reserved);
        BitfieldUtil.writeBit(s, 23, value);
        return this;
    }

    public boolean segmentation_temporal_update() {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$error_resilient_mode$reserved, LAYOUT$bitfield$error_resilient_mode$reserved);
        return BitfieldUtil.readBit(s, 24);
    }

    public StdVideoDecodeAV1PictureInfoFlags segmentation_temporal_update(boolean value) {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$error_resilient_mode$reserved, LAYOUT$bitfield$error_resilient_mode$reserved);
        BitfieldUtil.writeBit(s, 24, value);
        return this;
    }

    public boolean segmentation_update_data() {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$error_resilient_mode$reserved, LAYOUT$bitfield$error_resilient_mode$reserved);
        return BitfieldUtil.readBit(s, 25);
    }

    public StdVideoDecodeAV1PictureInfoFlags segmentation_update_data(boolean value) {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$error_resilient_mode$reserved, LAYOUT$bitfield$error_resilient_mode$reserved);
        BitfieldUtil.writeBit(s, 25, value);
        return this;
    }

    public boolean UsesLr() {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$error_resilient_mode$reserved, LAYOUT$bitfield$error_resilient_mode$reserved);
        return BitfieldUtil.readBit(s, 26);
    }

    public StdVideoDecodeAV1PictureInfoFlags UsesLr(boolean value) {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$error_resilient_mode$reserved, LAYOUT$bitfield$error_resilient_mode$reserved);
        BitfieldUtil.writeBit(s, 26, value);
        return this;
    }

    public boolean usesChromaLr() {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$error_resilient_mode$reserved, LAYOUT$bitfield$error_resilient_mode$reserved);
        return BitfieldUtil.readBit(s, 27);
    }

    public StdVideoDecodeAV1PictureInfoFlags usesChromaLr(boolean value) {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$error_resilient_mode$reserved, LAYOUT$bitfield$error_resilient_mode$reserved);
        BitfieldUtil.writeBit(s, 27, value);
        return this;
    }

    public boolean apply_grain() {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$error_resilient_mode$reserved, LAYOUT$bitfield$error_resilient_mode$reserved);
        return BitfieldUtil.readBit(s, 28);
    }

    public StdVideoDecodeAV1PictureInfoFlags apply_grain(boolean value) {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$error_resilient_mode$reserved, LAYOUT$bitfield$error_resilient_mode$reserved);
        BitfieldUtil.writeBit(s, 28, value);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("bitfield$error_resilient_mode$reserved")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$bitfield$error_resilient_mode$reserved = PathElement.groupElement("error_resilient_mode$reserved");

    public static final OfInt LAYOUT$bitfield$error_resilient_mode$reserved = (OfInt) LAYOUT.select(PATH$bitfield$error_resilient_mode$reserved);


    public static final long OFFSET$bitfield$error_resilient_mode$reserved = LAYOUT.byteOffset(PATH$bitfield$error_resilient_mode$reserved);
}
