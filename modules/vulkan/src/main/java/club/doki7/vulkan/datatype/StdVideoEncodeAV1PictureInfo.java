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

/// Represents a pointer to a {@code StdVideoEncodeAV1PictureInfo} structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct StdVideoEncodeAV1PictureInfo {
///     StdVideoEncodeAV1PictureInfoFlags flags; // @link substring="StdVideoEncodeAV1PictureInfoFlags" target="StdVideoEncodeAV1PictureInfoFlags" @link substring="flags" target="#flags"
///     StdVideoAV1FrameType frame_type; // @link substring="StdVideoAV1FrameType" target="StdVideoAV1FrameType" @link substring="frame_type" target="#frame_type"
///     uint32_t frame_presentation_time; // @link substring="frame_presentation_time" target="#frame_presentation_time"
///     uint32_t current_frame_id; // @link substring="current_frame_id" target="#current_frame_id"
///     uint8_t order_hint; // @link substring="order_hint" target="#order_hint"
///     uint8_t primary_ref_frame; // @link substring="primary_ref_frame" target="#primary_ref_frame"
///     uint8_t refresh_frame_flags; // @link substring="refresh_frame_flags" target="#refresh_frame_flags"
///     uint8_t coded_denom; // @link substring="coded_denom" target="#coded_denom"
///     uint16_t render_width_minus_1; // @link substring="render_width_minus_1" target="#render_width_minus_1"
///     uint16_t render_height_minus_1; // @link substring="render_height_minus_1" target="#render_height_minus_1"
///     StdVideoAV1InterpolationFilter interpolation_filter; // @link substring="StdVideoAV1InterpolationFilter" target="StdVideoAV1InterpolationFilter" @link substring="interpolation_filter" target="#interpolation_filter"
///     StdVideoAV1TxMode TxMode; // @link substring="StdVideoAV1TxMode" target="StdVideoAV1TxMode" @link substring="TxMode" target="#TxMode"
///     uint8_t delta_q_res; // @link substring="delta_q_res" target="#delta_q_res"
///     uint8_t delta_lf_res; // @link substring="delta_lf_res" target="#delta_lf_res"
///     uint8_t[STD_VIDEO_AV1_NUM_REF_FRAMES] ref_order_hint; // @link substring="ref_order_hint" target="#ref_order_hint"
///     int8_t[STD_VIDEO_AV1_REFS_PER_FRAME] ref_frame_idx; // @link substring="ref_frame_idx" target="#ref_frame_idx"
///     uint8_t[3] reserved1;
///     uint32_t[STD_VIDEO_AV1_REFS_PER_FRAME] delta_frame_id_minus_1; // @link substring="delta_frame_id_minus_1" target="#delta_frame_id_minus_1"
///     StdVideoAV1TileInfo const* pTileInfo; // optional // @link substring="StdVideoAV1TileInfo" target="StdVideoAV1TileInfo" @link substring="pTileInfo" target="#pTileInfo"
///     StdVideoAV1Quantization const* pQuantization; // @link substring="StdVideoAV1Quantization" target="StdVideoAV1Quantization" @link substring="pQuantization" target="#pQuantization"
///     StdVideoAV1Segmentation const* pSegmentation; // optional // @link substring="StdVideoAV1Segmentation" target="StdVideoAV1Segmentation" @link substring="pSegmentation" target="#pSegmentation"
///     StdVideoAV1LoopFilter const* pLoopFilter; // @link substring="StdVideoAV1LoopFilter" target="StdVideoAV1LoopFilter" @link substring="pLoopFilter" target="#pLoopFilter"
///     StdVideoAV1CDEF const* pCDEF; // optional // @link substring="StdVideoAV1CDEF" target="StdVideoAV1CDEF" @link substring="pCDEF" target="#pCDEF"
///     StdVideoAV1LoopRestoration const* pLoopRestoration; // optional // @link substring="StdVideoAV1LoopRestoration" target="StdVideoAV1LoopRestoration" @link substring="pLoopRestoration" target="#pLoopRestoration"
///     StdVideoAV1GlobalMotion const* pGlobalMotion; // @link substring="StdVideoAV1GlobalMotion" target="StdVideoAV1GlobalMotion" @link substring="pGlobalMotion" target="#pGlobalMotion"
///     StdVideoEncodeAV1ExtensionHeader const* pExtensionHeader; // optional // @link substring="StdVideoEncodeAV1ExtensionHeader" target="StdVideoEncodeAV1ExtensionHeader" @link substring="pExtensionHeader" target="#pExtensionHeader"
///     uint32_t const* pBufferRemovalTimes; // optional // @link substring="pBufferRemovalTimes" target="#pBufferRemovalTimes"
/// } StdVideoEncodeAV1PictureInfo;
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
public record StdVideoEncodeAV1PictureInfo(@NotNull MemorySegment segment) implements IStdVideoEncodeAV1PictureInfo {
    /// Represents a pointer to / an array of null structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link StdVideoEncodeAV1PictureInfo}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IStdVideoEncodeAV1PictureInfo to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code StdVideoEncodeAV1PictureInfo.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IStdVideoEncodeAV1PictureInfo, Iterable<StdVideoEncodeAV1PictureInfo> {
        public long size() {
            return segment.byteSize() / StdVideoEncodeAV1PictureInfo.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull StdVideoEncodeAV1PictureInfo at(long index) {
            return new StdVideoEncodeAV1PictureInfo(segment.asSlice(index * StdVideoEncodeAV1PictureInfo.BYTES, StdVideoEncodeAV1PictureInfo.BYTES));
        }

        public StdVideoEncodeAV1PictureInfo.Ptr at(long index, @NotNull Consumer<@NotNull StdVideoEncodeAV1PictureInfo> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull StdVideoEncodeAV1PictureInfo value) {
            MemorySegment s = segment.asSlice(index * StdVideoEncodeAV1PictureInfo.BYTES, StdVideoEncodeAV1PictureInfo.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * StdVideoEncodeAV1PictureInfo.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * StdVideoEncodeAV1PictureInfo.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * StdVideoEncodeAV1PictureInfo.BYTES,
                (end - start) * StdVideoEncodeAV1PictureInfo.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * StdVideoEncodeAV1PictureInfo.BYTES));
        }

        public StdVideoEncodeAV1PictureInfo[] toArray() {
            StdVideoEncodeAV1PictureInfo[] ret = new StdVideoEncodeAV1PictureInfo[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<StdVideoEncodeAV1PictureInfo> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<StdVideoEncodeAV1PictureInfo> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= StdVideoEncodeAV1PictureInfo.BYTES;
            }

            @Override
            public StdVideoEncodeAV1PictureInfo next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                StdVideoEncodeAV1PictureInfo ret = new StdVideoEncodeAV1PictureInfo(segment.asSlice(0, StdVideoEncodeAV1PictureInfo.BYTES));
                segment = segment.asSlice(StdVideoEncodeAV1PictureInfo.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static StdVideoEncodeAV1PictureInfo allocate(Arena arena) {
        return new StdVideoEncodeAV1PictureInfo(arena.allocate(LAYOUT));
    }

    public static StdVideoEncodeAV1PictureInfo.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        return new StdVideoEncodeAV1PictureInfo.Ptr(segment);
    }

    public static StdVideoEncodeAV1PictureInfo clone(Arena arena, StdVideoEncodeAV1PictureInfo src) {
        StdVideoEncodeAV1PictureInfo ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public @NotNull StdVideoEncodeAV1PictureInfoFlags flags() {
        return new StdVideoEncodeAV1PictureInfoFlags(segment.asSlice(OFFSET$flags, LAYOUT$flags));
    }

    public StdVideoEncodeAV1PictureInfo flags(@NotNull StdVideoEncodeAV1PictureInfoFlags value) {
        MemorySegment.copy(value.segment(), 0, segment, OFFSET$flags, SIZE$flags);
        return this;
    }

    public StdVideoEncodeAV1PictureInfo flags(Consumer<@NotNull StdVideoEncodeAV1PictureInfoFlags> consumer) {
        consumer.accept(flags());
        return this;
    }

    public @EnumType(StdVideoAV1FrameType.class) int frame_type() {
        return segment.get(LAYOUT$frame_type, OFFSET$frame_type);
    }

    public StdVideoEncodeAV1PictureInfo frame_type(@EnumType(StdVideoAV1FrameType.class) int value) {
        segment.set(LAYOUT$frame_type, OFFSET$frame_type, value);
        return this;
    }

    public @Unsigned int frame_presentation_time() {
        return segment.get(LAYOUT$frame_presentation_time, OFFSET$frame_presentation_time);
    }

    public StdVideoEncodeAV1PictureInfo frame_presentation_time(@Unsigned int value) {
        segment.set(LAYOUT$frame_presentation_time, OFFSET$frame_presentation_time, value);
        return this;
    }

    public @Unsigned int current_frame_id() {
        return segment.get(LAYOUT$current_frame_id, OFFSET$current_frame_id);
    }

    public StdVideoEncodeAV1PictureInfo current_frame_id(@Unsigned int value) {
        segment.set(LAYOUT$current_frame_id, OFFSET$current_frame_id, value);
        return this;
    }

    public @Unsigned byte order_hint() {
        return segment.get(LAYOUT$order_hint, OFFSET$order_hint);
    }

    public StdVideoEncodeAV1PictureInfo order_hint(@Unsigned byte value) {
        segment.set(LAYOUT$order_hint, OFFSET$order_hint, value);
        return this;
    }

    public @Unsigned byte primary_ref_frame() {
        return segment.get(LAYOUT$primary_ref_frame, OFFSET$primary_ref_frame);
    }

    public StdVideoEncodeAV1PictureInfo primary_ref_frame(@Unsigned byte value) {
        segment.set(LAYOUT$primary_ref_frame, OFFSET$primary_ref_frame, value);
        return this;
    }

    public @Unsigned byte refresh_frame_flags() {
        return segment.get(LAYOUT$refresh_frame_flags, OFFSET$refresh_frame_flags);
    }

    public StdVideoEncodeAV1PictureInfo refresh_frame_flags(@Unsigned byte value) {
        segment.set(LAYOUT$refresh_frame_flags, OFFSET$refresh_frame_flags, value);
        return this;
    }

    public @Unsigned byte coded_denom() {
        return segment.get(LAYOUT$coded_denom, OFFSET$coded_denom);
    }

    public StdVideoEncodeAV1PictureInfo coded_denom(@Unsigned byte value) {
        segment.set(LAYOUT$coded_denom, OFFSET$coded_denom, value);
        return this;
    }

    public @Unsigned short render_width_minus_1() {
        return segment.get(LAYOUT$render_width_minus_1, OFFSET$render_width_minus_1);
    }

    public StdVideoEncodeAV1PictureInfo render_width_minus_1(@Unsigned short value) {
        segment.set(LAYOUT$render_width_minus_1, OFFSET$render_width_minus_1, value);
        return this;
    }

    public @Unsigned short render_height_minus_1() {
        return segment.get(LAYOUT$render_height_minus_1, OFFSET$render_height_minus_1);
    }

    public StdVideoEncodeAV1PictureInfo render_height_minus_1(@Unsigned short value) {
        segment.set(LAYOUT$render_height_minus_1, OFFSET$render_height_minus_1, value);
        return this;
    }

    public @EnumType(StdVideoAV1InterpolationFilter.class) int interpolation_filter() {
        return segment.get(LAYOUT$interpolation_filter, OFFSET$interpolation_filter);
    }

    public StdVideoEncodeAV1PictureInfo interpolation_filter(@EnumType(StdVideoAV1InterpolationFilter.class) int value) {
        segment.set(LAYOUT$interpolation_filter, OFFSET$interpolation_filter, value);
        return this;
    }

    public @EnumType(StdVideoAV1TxMode.class) int TxMode() {
        return segment.get(LAYOUT$TxMode, OFFSET$TxMode);
    }

    public StdVideoEncodeAV1PictureInfo TxMode(@EnumType(StdVideoAV1TxMode.class) int value) {
        segment.set(LAYOUT$TxMode, OFFSET$TxMode, value);
        return this;
    }

    public @Unsigned byte delta_q_res() {
        return segment.get(LAYOUT$delta_q_res, OFFSET$delta_q_res);
    }

    public StdVideoEncodeAV1PictureInfo delta_q_res(@Unsigned byte value) {
        segment.set(LAYOUT$delta_q_res, OFFSET$delta_q_res, value);
        return this;
    }

    public @Unsigned byte delta_lf_res() {
        return segment.get(LAYOUT$delta_lf_res, OFFSET$delta_lf_res);
    }

    public StdVideoEncodeAV1PictureInfo delta_lf_res(@Unsigned byte value) {
        segment.set(LAYOUT$delta_lf_res, OFFSET$delta_lf_res, value);
        return this;
    }

    public @Unsigned BytePtr ref_order_hint() {
        return new BytePtr(ref_order_hintRaw());
    }

    public StdVideoEncodeAV1PictureInfo ref_order_hint(@NotNull Consumer<BytePtr> consumer) {
        @Unsigned BytePtr ptr = ref_order_hint();
        consumer.accept(ptr);
        return this;
    }

    public StdVideoEncodeAV1PictureInfo ref_order_hint(@Unsigned BytePtr value) {
        MemorySegment s = ref_order_hintRaw();
        s.copyFrom(value.segment());
        return this;
    }

    public @NotNull MemorySegment ref_order_hintRaw() {
        return segment.asSlice(OFFSET$ref_order_hint, SIZE$ref_order_hint);
    }

    public BytePtr ref_frame_idx() {
        return new BytePtr(ref_frame_idxRaw());
    }

    public StdVideoEncodeAV1PictureInfo ref_frame_idx(@NotNull Consumer<BytePtr> consumer) {
        BytePtr ptr = ref_frame_idx();
        consumer.accept(ptr);
        return this;
    }

    public StdVideoEncodeAV1PictureInfo ref_frame_idx(BytePtr value) {
        MemorySegment s = ref_frame_idxRaw();
        s.copyFrom(value.segment());
        return this;
    }

    public @NotNull MemorySegment ref_frame_idxRaw() {
        return segment.asSlice(OFFSET$ref_frame_idx, SIZE$ref_frame_idx);
    }


    public @Unsigned IntPtr delta_frame_id_minus_1() {
        return new IntPtr(delta_frame_id_minus_1Raw());
    }

    public StdVideoEncodeAV1PictureInfo delta_frame_id_minus_1(@NotNull Consumer<IntPtr> consumer) {
        @Unsigned IntPtr ptr = delta_frame_id_minus_1();
        consumer.accept(ptr);
        return this;
    }

    public StdVideoEncodeAV1PictureInfo delta_frame_id_minus_1(@Unsigned IntPtr value) {
        MemorySegment s = delta_frame_id_minus_1Raw();
        s.copyFrom(value.segment());
        return this;
    }

    public @NotNull MemorySegment delta_frame_id_minus_1Raw() {
        return segment.asSlice(OFFSET$delta_frame_id_minus_1, SIZE$delta_frame_id_minus_1);
    }

    public StdVideoEncodeAV1PictureInfo pTileInfo(@Nullable IStdVideoAV1TileInfo value) {
        MemorySegment s = value == null ? MemorySegment.NULL : value.segment();
        pTileInfoRaw(s);
        return this;
    }

    @Unsafe public @Nullable StdVideoAV1TileInfo.Ptr pTileInfo(int assumedCount) {
        MemorySegment s = pTileInfoRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }

        s = s.reinterpret(assumedCount * StdVideoAV1TileInfo.BYTES);
        return new StdVideoAV1TileInfo.Ptr(s);
    }

    public @Nullable StdVideoAV1TileInfo pTileInfo() {
        MemorySegment s = pTileInfoRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new StdVideoAV1TileInfo(s);
    }

    public @Pointer(target=StdVideoAV1TileInfo.class) @NotNull MemorySegment pTileInfoRaw() {
        return segment.get(LAYOUT$pTileInfo, OFFSET$pTileInfo);
    }

    public void pTileInfoRaw(@Pointer(target=StdVideoAV1TileInfo.class) @NotNull MemorySegment value) {
        segment.set(LAYOUT$pTileInfo, OFFSET$pTileInfo, value);
    }

    public StdVideoEncodeAV1PictureInfo pQuantization(@Nullable IStdVideoAV1Quantization value) {
        MemorySegment s = value == null ? MemorySegment.NULL : value.segment();
        pQuantizationRaw(s);
        return this;
    }

    @Unsafe public @Nullable StdVideoAV1Quantization.Ptr pQuantization(int assumedCount) {
        MemorySegment s = pQuantizationRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }

        s = s.reinterpret(assumedCount * StdVideoAV1Quantization.BYTES);
        return new StdVideoAV1Quantization.Ptr(s);
    }

    public @Nullable StdVideoAV1Quantization pQuantization() {
        MemorySegment s = pQuantizationRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new StdVideoAV1Quantization(s);
    }

    public @Pointer(target=StdVideoAV1Quantization.class) @NotNull MemorySegment pQuantizationRaw() {
        return segment.get(LAYOUT$pQuantization, OFFSET$pQuantization);
    }

    public void pQuantizationRaw(@Pointer(target=StdVideoAV1Quantization.class) @NotNull MemorySegment value) {
        segment.set(LAYOUT$pQuantization, OFFSET$pQuantization, value);
    }

    public StdVideoEncodeAV1PictureInfo pSegmentation(@Nullable IStdVideoAV1Segmentation value) {
        MemorySegment s = value == null ? MemorySegment.NULL : value.segment();
        pSegmentationRaw(s);
        return this;
    }

    @Unsafe public @Nullable StdVideoAV1Segmentation.Ptr pSegmentation(int assumedCount) {
        MemorySegment s = pSegmentationRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }

        s = s.reinterpret(assumedCount * StdVideoAV1Segmentation.BYTES);
        return new StdVideoAV1Segmentation.Ptr(s);
    }

    public @Nullable StdVideoAV1Segmentation pSegmentation() {
        MemorySegment s = pSegmentationRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new StdVideoAV1Segmentation(s);
    }

    public @Pointer(target=StdVideoAV1Segmentation.class) @NotNull MemorySegment pSegmentationRaw() {
        return segment.get(LAYOUT$pSegmentation, OFFSET$pSegmentation);
    }

    public void pSegmentationRaw(@Pointer(target=StdVideoAV1Segmentation.class) @NotNull MemorySegment value) {
        segment.set(LAYOUT$pSegmentation, OFFSET$pSegmentation, value);
    }

    public StdVideoEncodeAV1PictureInfo pLoopFilter(@Nullable IStdVideoAV1LoopFilter value) {
        MemorySegment s = value == null ? MemorySegment.NULL : value.segment();
        pLoopFilterRaw(s);
        return this;
    }

    @Unsafe public @Nullable StdVideoAV1LoopFilter.Ptr pLoopFilter(int assumedCount) {
        MemorySegment s = pLoopFilterRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }

        s = s.reinterpret(assumedCount * StdVideoAV1LoopFilter.BYTES);
        return new StdVideoAV1LoopFilter.Ptr(s);
    }

    public @Nullable StdVideoAV1LoopFilter pLoopFilter() {
        MemorySegment s = pLoopFilterRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new StdVideoAV1LoopFilter(s);
    }

    public @Pointer(target=StdVideoAV1LoopFilter.class) @NotNull MemorySegment pLoopFilterRaw() {
        return segment.get(LAYOUT$pLoopFilter, OFFSET$pLoopFilter);
    }

    public void pLoopFilterRaw(@Pointer(target=StdVideoAV1LoopFilter.class) @NotNull MemorySegment value) {
        segment.set(LAYOUT$pLoopFilter, OFFSET$pLoopFilter, value);
    }

    public StdVideoEncodeAV1PictureInfo pCDEF(@Nullable IStdVideoAV1CDEF value) {
        MemorySegment s = value == null ? MemorySegment.NULL : value.segment();
        pCDEFRaw(s);
        return this;
    }

    @Unsafe public @Nullable StdVideoAV1CDEF.Ptr pCDEF(int assumedCount) {
        MemorySegment s = pCDEFRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }

        s = s.reinterpret(assumedCount * StdVideoAV1CDEF.BYTES);
        return new StdVideoAV1CDEF.Ptr(s);
    }

    public @Nullable StdVideoAV1CDEF pCDEF() {
        MemorySegment s = pCDEFRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new StdVideoAV1CDEF(s);
    }

    public @Pointer(target=StdVideoAV1CDEF.class) @NotNull MemorySegment pCDEFRaw() {
        return segment.get(LAYOUT$pCDEF, OFFSET$pCDEF);
    }

    public void pCDEFRaw(@Pointer(target=StdVideoAV1CDEF.class) @NotNull MemorySegment value) {
        segment.set(LAYOUT$pCDEF, OFFSET$pCDEF, value);
    }

    public StdVideoEncodeAV1PictureInfo pLoopRestoration(@Nullable IStdVideoAV1LoopRestoration value) {
        MemorySegment s = value == null ? MemorySegment.NULL : value.segment();
        pLoopRestorationRaw(s);
        return this;
    }

    @Unsafe public @Nullable StdVideoAV1LoopRestoration.Ptr pLoopRestoration(int assumedCount) {
        MemorySegment s = pLoopRestorationRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }

        s = s.reinterpret(assumedCount * StdVideoAV1LoopRestoration.BYTES);
        return new StdVideoAV1LoopRestoration.Ptr(s);
    }

    public @Nullable StdVideoAV1LoopRestoration pLoopRestoration() {
        MemorySegment s = pLoopRestorationRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new StdVideoAV1LoopRestoration(s);
    }

    public @Pointer(target=StdVideoAV1LoopRestoration.class) @NotNull MemorySegment pLoopRestorationRaw() {
        return segment.get(LAYOUT$pLoopRestoration, OFFSET$pLoopRestoration);
    }

    public void pLoopRestorationRaw(@Pointer(target=StdVideoAV1LoopRestoration.class) @NotNull MemorySegment value) {
        segment.set(LAYOUT$pLoopRestoration, OFFSET$pLoopRestoration, value);
    }

    public StdVideoEncodeAV1PictureInfo pGlobalMotion(@Nullable IStdVideoAV1GlobalMotion value) {
        MemorySegment s = value == null ? MemorySegment.NULL : value.segment();
        pGlobalMotionRaw(s);
        return this;
    }

    @Unsafe public @Nullable StdVideoAV1GlobalMotion.Ptr pGlobalMotion(int assumedCount) {
        MemorySegment s = pGlobalMotionRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }

        s = s.reinterpret(assumedCount * StdVideoAV1GlobalMotion.BYTES);
        return new StdVideoAV1GlobalMotion.Ptr(s);
    }

    public @Nullable StdVideoAV1GlobalMotion pGlobalMotion() {
        MemorySegment s = pGlobalMotionRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new StdVideoAV1GlobalMotion(s);
    }

    public @Pointer(target=StdVideoAV1GlobalMotion.class) @NotNull MemorySegment pGlobalMotionRaw() {
        return segment.get(LAYOUT$pGlobalMotion, OFFSET$pGlobalMotion);
    }

    public void pGlobalMotionRaw(@Pointer(target=StdVideoAV1GlobalMotion.class) @NotNull MemorySegment value) {
        segment.set(LAYOUT$pGlobalMotion, OFFSET$pGlobalMotion, value);
    }

    public StdVideoEncodeAV1PictureInfo pExtensionHeader(@Nullable IStdVideoEncodeAV1ExtensionHeader value) {
        MemorySegment s = value == null ? MemorySegment.NULL : value.segment();
        pExtensionHeaderRaw(s);
        return this;
    }

    @Unsafe public @Nullable StdVideoEncodeAV1ExtensionHeader.Ptr pExtensionHeader(int assumedCount) {
        MemorySegment s = pExtensionHeaderRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }

        s = s.reinterpret(assumedCount * StdVideoEncodeAV1ExtensionHeader.BYTES);
        return new StdVideoEncodeAV1ExtensionHeader.Ptr(s);
    }

    public @Nullable StdVideoEncodeAV1ExtensionHeader pExtensionHeader() {
        MemorySegment s = pExtensionHeaderRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new StdVideoEncodeAV1ExtensionHeader(s);
    }

    public @Pointer(target=StdVideoEncodeAV1ExtensionHeader.class) @NotNull MemorySegment pExtensionHeaderRaw() {
        return segment.get(LAYOUT$pExtensionHeader, OFFSET$pExtensionHeader);
    }

    public void pExtensionHeaderRaw(@Pointer(target=StdVideoEncodeAV1ExtensionHeader.class) @NotNull MemorySegment value) {
        segment.set(LAYOUT$pExtensionHeader, OFFSET$pExtensionHeader, value);
    }

    /// Note: the returned {@link IntPtr} does not have correct
    /// {@link IntPtr#size} property. It's up to user to track the size of the buffer,
    /// and use {@link IntPtr#reinterpret} to set the size before actually reading from or
    /// writing to the buffer.
    public @Nullable @Unsigned IntPtr pBufferRemovalTimes() {
        MemorySegment s = pBufferRemovalTimesRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new IntPtr(s);
    }

    public StdVideoEncodeAV1PictureInfo pBufferRemovalTimes(@Nullable @Unsigned IntPtr value) {
        MemorySegment s = value == null ? MemorySegment.NULL : value.segment();
        pBufferRemovalTimesRaw(s);
        return this;
    }

    public @Pointer(comment="uint32_t*") @NotNull MemorySegment pBufferRemovalTimesRaw() {
        return segment.get(LAYOUT$pBufferRemovalTimes, OFFSET$pBufferRemovalTimes);
    }

    public void pBufferRemovalTimesRaw(@Pointer(comment="uint32_t*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pBufferRemovalTimes, OFFSET$pBufferRemovalTimes, value);
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        StdVideoEncodeAV1PictureInfoFlags.LAYOUT.withName("flags"),
        ValueLayout.JAVA_INT.withName("frame_type"),
        ValueLayout.JAVA_INT.withName("frame_presentation_time"),
        ValueLayout.JAVA_INT.withName("current_frame_id"),
        ValueLayout.JAVA_BYTE.withName("order_hint"),
        ValueLayout.JAVA_BYTE.withName("primary_ref_frame"),
        ValueLayout.JAVA_BYTE.withName("refresh_frame_flags"),
        ValueLayout.JAVA_BYTE.withName("coded_denom"),
        ValueLayout.JAVA_SHORT.withName("render_width_minus_1"),
        ValueLayout.JAVA_SHORT.withName("render_height_minus_1"),
        ValueLayout.JAVA_INT.withName("interpolation_filter"),
        ValueLayout.JAVA_INT.withName("TxMode"),
        ValueLayout.JAVA_BYTE.withName("delta_q_res"),
        ValueLayout.JAVA_BYTE.withName("delta_lf_res"),
        MemoryLayout.sequenceLayout(AV1_NUM_REF_FRAMES, ValueLayout.JAVA_BYTE).withName("ref_order_hint"),
        MemoryLayout.sequenceLayout(AV1_REFS_PER_FRAME, ValueLayout.JAVA_BYTE).withName("ref_frame_idx"),
        MemoryLayout.sequenceLayout(3, ValueLayout.JAVA_BYTE).withName("reserved1"),
        MemoryLayout.sequenceLayout(AV1_REFS_PER_FRAME, ValueLayout.JAVA_INT).withName("delta_frame_id_minus_1"),
        ValueLayout.ADDRESS.withTargetLayout(StdVideoAV1TileInfo.LAYOUT).withName("pTileInfo"),
        ValueLayout.ADDRESS.withTargetLayout(StdVideoAV1Quantization.LAYOUT).withName("pQuantization"),
        ValueLayout.ADDRESS.withTargetLayout(StdVideoAV1Segmentation.LAYOUT).withName("pSegmentation"),
        ValueLayout.ADDRESS.withTargetLayout(StdVideoAV1LoopFilter.LAYOUT).withName("pLoopFilter"),
        ValueLayout.ADDRESS.withTargetLayout(StdVideoAV1CDEF.LAYOUT).withName("pCDEF"),
        ValueLayout.ADDRESS.withTargetLayout(StdVideoAV1LoopRestoration.LAYOUT).withName("pLoopRestoration"),
        ValueLayout.ADDRESS.withTargetLayout(StdVideoAV1GlobalMotion.LAYOUT).withName("pGlobalMotion"),
        ValueLayout.ADDRESS.withTargetLayout(StdVideoEncodeAV1ExtensionHeader.LAYOUT).withName("pExtensionHeader"),
        ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT).withName("pBufferRemovalTimes")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$flags = PathElement.groupElement("flags");
    public static final PathElement PATH$frame_type = PathElement.groupElement("frame_type");
    public static final PathElement PATH$frame_presentation_time = PathElement.groupElement("frame_presentation_time");
    public static final PathElement PATH$current_frame_id = PathElement.groupElement("current_frame_id");
    public static final PathElement PATH$order_hint = PathElement.groupElement("order_hint");
    public static final PathElement PATH$primary_ref_frame = PathElement.groupElement("primary_ref_frame");
    public static final PathElement PATH$refresh_frame_flags = PathElement.groupElement("refresh_frame_flags");
    public static final PathElement PATH$coded_denom = PathElement.groupElement("coded_denom");
    public static final PathElement PATH$render_width_minus_1 = PathElement.groupElement("render_width_minus_1");
    public static final PathElement PATH$render_height_minus_1 = PathElement.groupElement("render_height_minus_1");
    public static final PathElement PATH$interpolation_filter = PathElement.groupElement("interpolation_filter");
    public static final PathElement PATH$TxMode = PathElement.groupElement("TxMode");
    public static final PathElement PATH$delta_q_res = PathElement.groupElement("delta_q_res");
    public static final PathElement PATH$delta_lf_res = PathElement.groupElement("delta_lf_res");
    public static final PathElement PATH$ref_order_hint = PathElement.groupElement("ref_order_hint");
    public static final PathElement PATH$ref_frame_idx = PathElement.groupElement("ref_frame_idx");
    public static final PathElement PATH$delta_frame_id_minus_1 = PathElement.groupElement("delta_frame_id_minus_1");
    public static final PathElement PATH$pTileInfo = PathElement.groupElement("pTileInfo");
    public static final PathElement PATH$pQuantization = PathElement.groupElement("pQuantization");
    public static final PathElement PATH$pSegmentation = PathElement.groupElement("pSegmentation");
    public static final PathElement PATH$pLoopFilter = PathElement.groupElement("pLoopFilter");
    public static final PathElement PATH$pCDEF = PathElement.groupElement("pCDEF");
    public static final PathElement PATH$pLoopRestoration = PathElement.groupElement("pLoopRestoration");
    public static final PathElement PATH$pGlobalMotion = PathElement.groupElement("pGlobalMotion");
    public static final PathElement PATH$pExtensionHeader = PathElement.groupElement("pExtensionHeader");
    public static final PathElement PATH$pBufferRemovalTimes = PathElement.groupElement("pBufferRemovalTimes");

    public static final StructLayout LAYOUT$flags = (StructLayout) LAYOUT.select(PATH$flags);
    public static final OfInt LAYOUT$frame_type = (OfInt) LAYOUT.select(PATH$frame_type);
    public static final OfInt LAYOUT$frame_presentation_time = (OfInt) LAYOUT.select(PATH$frame_presentation_time);
    public static final OfInt LAYOUT$current_frame_id = (OfInt) LAYOUT.select(PATH$current_frame_id);
    public static final OfByte LAYOUT$order_hint = (OfByte) LAYOUT.select(PATH$order_hint);
    public static final OfByte LAYOUT$primary_ref_frame = (OfByte) LAYOUT.select(PATH$primary_ref_frame);
    public static final OfByte LAYOUT$refresh_frame_flags = (OfByte) LAYOUT.select(PATH$refresh_frame_flags);
    public static final OfByte LAYOUT$coded_denom = (OfByte) LAYOUT.select(PATH$coded_denom);
    public static final OfShort LAYOUT$render_width_minus_1 = (OfShort) LAYOUT.select(PATH$render_width_minus_1);
    public static final OfShort LAYOUT$render_height_minus_1 = (OfShort) LAYOUT.select(PATH$render_height_minus_1);
    public static final OfInt LAYOUT$interpolation_filter = (OfInt) LAYOUT.select(PATH$interpolation_filter);
    public static final OfInt LAYOUT$TxMode = (OfInt) LAYOUT.select(PATH$TxMode);
    public static final OfByte LAYOUT$delta_q_res = (OfByte) LAYOUT.select(PATH$delta_q_res);
    public static final OfByte LAYOUT$delta_lf_res = (OfByte) LAYOUT.select(PATH$delta_lf_res);
    public static final SequenceLayout LAYOUT$ref_order_hint = (SequenceLayout) LAYOUT.select(PATH$ref_order_hint);
    public static final SequenceLayout LAYOUT$ref_frame_idx = (SequenceLayout) LAYOUT.select(PATH$ref_frame_idx);
    public static final SequenceLayout LAYOUT$delta_frame_id_minus_1 = (SequenceLayout) LAYOUT.select(PATH$delta_frame_id_minus_1);
    public static final AddressLayout LAYOUT$pTileInfo = (AddressLayout) LAYOUT.select(PATH$pTileInfo);
    public static final AddressLayout LAYOUT$pQuantization = (AddressLayout) LAYOUT.select(PATH$pQuantization);
    public static final AddressLayout LAYOUT$pSegmentation = (AddressLayout) LAYOUT.select(PATH$pSegmentation);
    public static final AddressLayout LAYOUT$pLoopFilter = (AddressLayout) LAYOUT.select(PATH$pLoopFilter);
    public static final AddressLayout LAYOUT$pCDEF = (AddressLayout) LAYOUT.select(PATH$pCDEF);
    public static final AddressLayout LAYOUT$pLoopRestoration = (AddressLayout) LAYOUT.select(PATH$pLoopRestoration);
    public static final AddressLayout LAYOUT$pGlobalMotion = (AddressLayout) LAYOUT.select(PATH$pGlobalMotion);
    public static final AddressLayout LAYOUT$pExtensionHeader = (AddressLayout) LAYOUT.select(PATH$pExtensionHeader);
    public static final AddressLayout LAYOUT$pBufferRemovalTimes = (AddressLayout) LAYOUT.select(PATH$pBufferRemovalTimes);

    public static final long SIZE$flags = LAYOUT$flags.byteSize();
    public static final long SIZE$frame_type = LAYOUT$frame_type.byteSize();
    public static final long SIZE$frame_presentation_time = LAYOUT$frame_presentation_time.byteSize();
    public static final long SIZE$current_frame_id = LAYOUT$current_frame_id.byteSize();
    public static final long SIZE$order_hint = LAYOUT$order_hint.byteSize();
    public static final long SIZE$primary_ref_frame = LAYOUT$primary_ref_frame.byteSize();
    public static final long SIZE$refresh_frame_flags = LAYOUT$refresh_frame_flags.byteSize();
    public static final long SIZE$coded_denom = LAYOUT$coded_denom.byteSize();
    public static final long SIZE$render_width_minus_1 = LAYOUT$render_width_minus_1.byteSize();
    public static final long SIZE$render_height_minus_1 = LAYOUT$render_height_minus_1.byteSize();
    public static final long SIZE$interpolation_filter = LAYOUT$interpolation_filter.byteSize();
    public static final long SIZE$TxMode = LAYOUT$TxMode.byteSize();
    public static final long SIZE$delta_q_res = LAYOUT$delta_q_res.byteSize();
    public static final long SIZE$delta_lf_res = LAYOUT$delta_lf_res.byteSize();
    public static final long SIZE$ref_order_hint = LAYOUT$ref_order_hint.byteSize();
    public static final long SIZE$ref_frame_idx = LAYOUT$ref_frame_idx.byteSize();
    public static final long SIZE$delta_frame_id_minus_1 = LAYOUT$delta_frame_id_minus_1.byteSize();
    public static final long SIZE$pTileInfo = LAYOUT$pTileInfo.byteSize();
    public static final long SIZE$pQuantization = LAYOUT$pQuantization.byteSize();
    public static final long SIZE$pSegmentation = LAYOUT$pSegmentation.byteSize();
    public static final long SIZE$pLoopFilter = LAYOUT$pLoopFilter.byteSize();
    public static final long SIZE$pCDEF = LAYOUT$pCDEF.byteSize();
    public static final long SIZE$pLoopRestoration = LAYOUT$pLoopRestoration.byteSize();
    public static final long SIZE$pGlobalMotion = LAYOUT$pGlobalMotion.byteSize();
    public static final long SIZE$pExtensionHeader = LAYOUT$pExtensionHeader.byteSize();
    public static final long SIZE$pBufferRemovalTimes = LAYOUT$pBufferRemovalTimes.byteSize();

    public static final long OFFSET$flags = LAYOUT.byteOffset(PATH$flags);
    public static final long OFFSET$frame_type = LAYOUT.byteOffset(PATH$frame_type);
    public static final long OFFSET$frame_presentation_time = LAYOUT.byteOffset(PATH$frame_presentation_time);
    public static final long OFFSET$current_frame_id = LAYOUT.byteOffset(PATH$current_frame_id);
    public static final long OFFSET$order_hint = LAYOUT.byteOffset(PATH$order_hint);
    public static final long OFFSET$primary_ref_frame = LAYOUT.byteOffset(PATH$primary_ref_frame);
    public static final long OFFSET$refresh_frame_flags = LAYOUT.byteOffset(PATH$refresh_frame_flags);
    public static final long OFFSET$coded_denom = LAYOUT.byteOffset(PATH$coded_denom);
    public static final long OFFSET$render_width_minus_1 = LAYOUT.byteOffset(PATH$render_width_minus_1);
    public static final long OFFSET$render_height_minus_1 = LAYOUT.byteOffset(PATH$render_height_minus_1);
    public static final long OFFSET$interpolation_filter = LAYOUT.byteOffset(PATH$interpolation_filter);
    public static final long OFFSET$TxMode = LAYOUT.byteOffset(PATH$TxMode);
    public static final long OFFSET$delta_q_res = LAYOUT.byteOffset(PATH$delta_q_res);
    public static final long OFFSET$delta_lf_res = LAYOUT.byteOffset(PATH$delta_lf_res);
    public static final long OFFSET$ref_order_hint = LAYOUT.byteOffset(PATH$ref_order_hint);
    public static final long OFFSET$ref_frame_idx = LAYOUT.byteOffset(PATH$ref_frame_idx);
    public static final long OFFSET$delta_frame_id_minus_1 = LAYOUT.byteOffset(PATH$delta_frame_id_minus_1);
    public static final long OFFSET$pTileInfo = LAYOUT.byteOffset(PATH$pTileInfo);
    public static final long OFFSET$pQuantization = LAYOUT.byteOffset(PATH$pQuantization);
    public static final long OFFSET$pSegmentation = LAYOUT.byteOffset(PATH$pSegmentation);
    public static final long OFFSET$pLoopFilter = LAYOUT.byteOffset(PATH$pLoopFilter);
    public static final long OFFSET$pCDEF = LAYOUT.byteOffset(PATH$pCDEF);
    public static final long OFFSET$pLoopRestoration = LAYOUT.byteOffset(PATH$pLoopRestoration);
    public static final long OFFSET$pGlobalMotion = LAYOUT.byteOffset(PATH$pGlobalMotion);
    public static final long OFFSET$pExtensionHeader = LAYOUT.byteOffset(PATH$pExtensionHeader);
    public static final long OFFSET$pBufferRemovalTimes = LAYOUT.byteOffset(PATH$pBufferRemovalTimes);
}
