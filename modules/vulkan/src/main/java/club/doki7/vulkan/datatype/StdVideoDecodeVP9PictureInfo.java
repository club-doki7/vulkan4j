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

/// Represents a pointer to a {@code StdVideoDecodeVP9PictureInfo} structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct StdVideoDecodeVP9PictureInfo {
///     StdVideoDecodeVP9PictureInfoFlags flags; // @link substring="StdVideoDecodeVP9PictureInfoFlags" target="StdVideoDecodeVP9PictureInfoFlags" @link substring="flags" target="#flags"
///     StdVideoVP9Profile profile; // @link substring="StdVideoVP9Profile" target="StdVideoVP9Profile" @link substring="profile" target="#profile"
///     StdVideoVP9FrameType frame_type; // @link substring="StdVideoVP9FrameType" target="StdVideoVP9FrameType" @link substring="frame_type" target="#frame_type"
///     uint8_t frame_context_idx; // @link substring="frame_context_idx" target="#frame_context_idx"
///     uint8_t reset_frame_context; // @link substring="reset_frame_context" target="#reset_frame_context"
///     uint8_t refresh_frame_flags; // @link substring="refresh_frame_flags" target="#refresh_frame_flags"
///     uint8_t ref_frame_sign_bias_mask; // @link substring="ref_frame_sign_bias_mask" target="#ref_frame_sign_bias_mask"
///     StdVideoVP9InterpolationFilter interpolation_filter; // @link substring="StdVideoVP9InterpolationFilter" target="StdVideoVP9InterpolationFilter" @link substring="interpolation_filter" target="#interpolation_filter"
///     uint8_t base_q_idx; // @link substring="base_q_idx" target="#base_q_idx"
///     int8_t delta_q_y_dc; // @link substring="delta_q_y_dc" target="#delta_q_y_dc"
///     int8_t delta_q_uv_dc; // @link substring="delta_q_uv_dc" target="#delta_q_uv_dc"
///     int8_t delta_q_uv_ac; // @link substring="delta_q_uv_ac" target="#delta_q_uv_ac"
///     uint8_t tile_cols_log2; // @link substring="tile_cols_log2" target="#tile_cols_log2"
///     uint8_t tile_rows_log2; // @link substring="tile_rows_log2" target="#tile_rows_log2"
///     uint16_t[3] reserved1;
///     StdVideoVP9ColorConfig const* pColorConfig; // @link substring="StdVideoVP9ColorConfig" target="StdVideoVP9ColorConfig" @link substring="pColorConfig" target="#pColorConfig"
///     StdVideoVP9LoopFilter const* pLoopFilter; // @link substring="StdVideoVP9LoopFilter" target="StdVideoVP9LoopFilter" @link substring="pLoopFilter" target="#pLoopFilter"
///     StdVideoVP9Segmentation const* pSegmentation; // optional // @link substring="StdVideoVP9Segmentation" target="StdVideoVP9Segmentation" @link substring="pSegmentation" target="#pSegmentation"
/// } StdVideoDecodeVP9PictureInfo;
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
public record StdVideoDecodeVP9PictureInfo(@NotNull MemorySegment segment) implements IStdVideoDecodeVP9PictureInfo {
    /// Represents a pointer to / an array of null structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link StdVideoDecodeVP9PictureInfo}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IStdVideoDecodeVP9PictureInfo to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code StdVideoDecodeVP9PictureInfo.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IStdVideoDecodeVP9PictureInfo, Iterable<StdVideoDecodeVP9PictureInfo> {
        public long size() {
            return segment.byteSize() / StdVideoDecodeVP9PictureInfo.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull StdVideoDecodeVP9PictureInfo at(long index) {
            return new StdVideoDecodeVP9PictureInfo(segment.asSlice(index * StdVideoDecodeVP9PictureInfo.BYTES, StdVideoDecodeVP9PictureInfo.BYTES));
        }

        public StdVideoDecodeVP9PictureInfo.Ptr at(long index, @NotNull Consumer<@NotNull StdVideoDecodeVP9PictureInfo> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull StdVideoDecodeVP9PictureInfo value) {
            MemorySegment s = segment.asSlice(index * StdVideoDecodeVP9PictureInfo.BYTES, StdVideoDecodeVP9PictureInfo.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * StdVideoDecodeVP9PictureInfo.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * StdVideoDecodeVP9PictureInfo.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * StdVideoDecodeVP9PictureInfo.BYTES,
                (end - start) * StdVideoDecodeVP9PictureInfo.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * StdVideoDecodeVP9PictureInfo.BYTES));
        }

        public StdVideoDecodeVP9PictureInfo[] toArray() {
            StdVideoDecodeVP9PictureInfo[] ret = new StdVideoDecodeVP9PictureInfo[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<StdVideoDecodeVP9PictureInfo> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<StdVideoDecodeVP9PictureInfo> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= StdVideoDecodeVP9PictureInfo.BYTES;
            }

            @Override
            public StdVideoDecodeVP9PictureInfo next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                StdVideoDecodeVP9PictureInfo ret = new StdVideoDecodeVP9PictureInfo(segment.asSlice(0, StdVideoDecodeVP9PictureInfo.BYTES));
                segment = segment.asSlice(StdVideoDecodeVP9PictureInfo.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static StdVideoDecodeVP9PictureInfo allocate(Arena arena) {
        return new StdVideoDecodeVP9PictureInfo(arena.allocate(LAYOUT));
    }

    public static StdVideoDecodeVP9PictureInfo.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        return new StdVideoDecodeVP9PictureInfo.Ptr(segment);
    }

    public static StdVideoDecodeVP9PictureInfo clone(Arena arena, StdVideoDecodeVP9PictureInfo src) {
        StdVideoDecodeVP9PictureInfo ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public @NotNull StdVideoDecodeVP9PictureInfoFlags flags() {
        return new StdVideoDecodeVP9PictureInfoFlags(segment.asSlice(OFFSET$flags, LAYOUT$flags));
    }

    public StdVideoDecodeVP9PictureInfo flags(@NotNull StdVideoDecodeVP9PictureInfoFlags value) {
        MemorySegment.copy(value.segment(), 0, segment, OFFSET$flags, SIZE$flags);
        return this;
    }

    public StdVideoDecodeVP9PictureInfo flags(Consumer<@NotNull StdVideoDecodeVP9PictureInfoFlags> consumer) {
        consumer.accept(flags());
        return this;
    }

    public @EnumType(StdVideoVP9Profile.class) int profile() {
        return segment.get(LAYOUT$profile, OFFSET$profile);
    }

    public StdVideoDecodeVP9PictureInfo profile(@EnumType(StdVideoVP9Profile.class) int value) {
        segment.set(LAYOUT$profile, OFFSET$profile, value);
        return this;
    }

    public @EnumType(StdVideoVP9FrameType.class) int frame_type() {
        return segment.get(LAYOUT$frame_type, OFFSET$frame_type);
    }

    public StdVideoDecodeVP9PictureInfo frame_type(@EnumType(StdVideoVP9FrameType.class) int value) {
        segment.set(LAYOUT$frame_type, OFFSET$frame_type, value);
        return this;
    }

    public @Unsigned byte frame_context_idx() {
        return segment.get(LAYOUT$frame_context_idx, OFFSET$frame_context_idx);
    }

    public StdVideoDecodeVP9PictureInfo frame_context_idx(@Unsigned byte value) {
        segment.set(LAYOUT$frame_context_idx, OFFSET$frame_context_idx, value);
        return this;
    }

    public @Unsigned byte reset_frame_context() {
        return segment.get(LAYOUT$reset_frame_context, OFFSET$reset_frame_context);
    }

    public StdVideoDecodeVP9PictureInfo reset_frame_context(@Unsigned byte value) {
        segment.set(LAYOUT$reset_frame_context, OFFSET$reset_frame_context, value);
        return this;
    }

    public @Unsigned byte refresh_frame_flags() {
        return segment.get(LAYOUT$refresh_frame_flags, OFFSET$refresh_frame_flags);
    }

    public StdVideoDecodeVP9PictureInfo refresh_frame_flags(@Unsigned byte value) {
        segment.set(LAYOUT$refresh_frame_flags, OFFSET$refresh_frame_flags, value);
        return this;
    }

    public @Unsigned byte ref_frame_sign_bias_mask() {
        return segment.get(LAYOUT$ref_frame_sign_bias_mask, OFFSET$ref_frame_sign_bias_mask);
    }

    public StdVideoDecodeVP9PictureInfo ref_frame_sign_bias_mask(@Unsigned byte value) {
        segment.set(LAYOUT$ref_frame_sign_bias_mask, OFFSET$ref_frame_sign_bias_mask, value);
        return this;
    }

    public @EnumType(StdVideoVP9InterpolationFilter.class) int interpolation_filter() {
        return segment.get(LAYOUT$interpolation_filter, OFFSET$interpolation_filter);
    }

    public StdVideoDecodeVP9PictureInfo interpolation_filter(@EnumType(StdVideoVP9InterpolationFilter.class) int value) {
        segment.set(LAYOUT$interpolation_filter, OFFSET$interpolation_filter, value);
        return this;
    }

    public @Unsigned byte base_q_idx() {
        return segment.get(LAYOUT$base_q_idx, OFFSET$base_q_idx);
    }

    public StdVideoDecodeVP9PictureInfo base_q_idx(@Unsigned byte value) {
        segment.set(LAYOUT$base_q_idx, OFFSET$base_q_idx, value);
        return this;
    }

    public byte delta_q_y_dc() {
        return segment.get(LAYOUT$delta_q_y_dc, OFFSET$delta_q_y_dc);
    }

    public StdVideoDecodeVP9PictureInfo delta_q_y_dc(byte value) {
        segment.set(LAYOUT$delta_q_y_dc, OFFSET$delta_q_y_dc, value);
        return this;
    }

    public byte delta_q_uv_dc() {
        return segment.get(LAYOUT$delta_q_uv_dc, OFFSET$delta_q_uv_dc);
    }

    public StdVideoDecodeVP9PictureInfo delta_q_uv_dc(byte value) {
        segment.set(LAYOUT$delta_q_uv_dc, OFFSET$delta_q_uv_dc, value);
        return this;
    }

    public byte delta_q_uv_ac() {
        return segment.get(LAYOUT$delta_q_uv_ac, OFFSET$delta_q_uv_ac);
    }

    public StdVideoDecodeVP9PictureInfo delta_q_uv_ac(byte value) {
        segment.set(LAYOUT$delta_q_uv_ac, OFFSET$delta_q_uv_ac, value);
        return this;
    }

    public @Unsigned byte tile_cols_log2() {
        return segment.get(LAYOUT$tile_cols_log2, OFFSET$tile_cols_log2);
    }

    public StdVideoDecodeVP9PictureInfo tile_cols_log2(@Unsigned byte value) {
        segment.set(LAYOUT$tile_cols_log2, OFFSET$tile_cols_log2, value);
        return this;
    }

    public @Unsigned byte tile_rows_log2() {
        return segment.get(LAYOUT$tile_rows_log2, OFFSET$tile_rows_log2);
    }

    public StdVideoDecodeVP9PictureInfo tile_rows_log2(@Unsigned byte value) {
        segment.set(LAYOUT$tile_rows_log2, OFFSET$tile_rows_log2, value);
        return this;
    }


    public StdVideoDecodeVP9PictureInfo pColorConfig(@Nullable IStdVideoVP9ColorConfig value) {
        MemorySegment s = value == null ? MemorySegment.NULL : value.segment();
        pColorConfigRaw(s);
        return this;
    }

    @Unsafe public @Nullable StdVideoVP9ColorConfig.Ptr pColorConfig(int assumedCount) {
        MemorySegment s = pColorConfigRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }

        s = s.reinterpret(assumedCount * StdVideoVP9ColorConfig.BYTES);
        return new StdVideoVP9ColorConfig.Ptr(s);
    }

    public @Nullable StdVideoVP9ColorConfig pColorConfig() {
        MemorySegment s = pColorConfigRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new StdVideoVP9ColorConfig(s);
    }

    public @Pointer(target=StdVideoVP9ColorConfig.class) @NotNull MemorySegment pColorConfigRaw() {
        return segment.get(LAYOUT$pColorConfig, OFFSET$pColorConfig);
    }

    public void pColorConfigRaw(@Pointer(target=StdVideoVP9ColorConfig.class) @NotNull MemorySegment value) {
        segment.set(LAYOUT$pColorConfig, OFFSET$pColorConfig, value);
    }

    public StdVideoDecodeVP9PictureInfo pLoopFilter(@Nullable IStdVideoVP9LoopFilter value) {
        MemorySegment s = value == null ? MemorySegment.NULL : value.segment();
        pLoopFilterRaw(s);
        return this;
    }

    @Unsafe public @Nullable StdVideoVP9LoopFilter.Ptr pLoopFilter(int assumedCount) {
        MemorySegment s = pLoopFilterRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }

        s = s.reinterpret(assumedCount * StdVideoVP9LoopFilter.BYTES);
        return new StdVideoVP9LoopFilter.Ptr(s);
    }

    public @Nullable StdVideoVP9LoopFilter pLoopFilter() {
        MemorySegment s = pLoopFilterRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new StdVideoVP9LoopFilter(s);
    }

    public @Pointer(target=StdVideoVP9LoopFilter.class) @NotNull MemorySegment pLoopFilterRaw() {
        return segment.get(LAYOUT$pLoopFilter, OFFSET$pLoopFilter);
    }

    public void pLoopFilterRaw(@Pointer(target=StdVideoVP9LoopFilter.class) @NotNull MemorySegment value) {
        segment.set(LAYOUT$pLoopFilter, OFFSET$pLoopFilter, value);
    }

    public StdVideoDecodeVP9PictureInfo pSegmentation(@Nullable IStdVideoVP9Segmentation value) {
        MemorySegment s = value == null ? MemorySegment.NULL : value.segment();
        pSegmentationRaw(s);
        return this;
    }

    @Unsafe public @Nullable StdVideoVP9Segmentation.Ptr pSegmentation(int assumedCount) {
        MemorySegment s = pSegmentationRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }

        s = s.reinterpret(assumedCount * StdVideoVP9Segmentation.BYTES);
        return new StdVideoVP9Segmentation.Ptr(s);
    }

    public @Nullable StdVideoVP9Segmentation pSegmentation() {
        MemorySegment s = pSegmentationRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new StdVideoVP9Segmentation(s);
    }

    public @Pointer(target=StdVideoVP9Segmentation.class) @NotNull MemorySegment pSegmentationRaw() {
        return segment.get(LAYOUT$pSegmentation, OFFSET$pSegmentation);
    }

    public void pSegmentationRaw(@Pointer(target=StdVideoVP9Segmentation.class) @NotNull MemorySegment value) {
        segment.set(LAYOUT$pSegmentation, OFFSET$pSegmentation, value);
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        StdVideoDecodeVP9PictureInfoFlags.LAYOUT.withName("flags"),
        ValueLayout.JAVA_INT.withName("profile"),
        ValueLayout.JAVA_INT.withName("frame_type"),
        ValueLayout.JAVA_BYTE.withName("frame_context_idx"),
        ValueLayout.JAVA_BYTE.withName("reset_frame_context"),
        ValueLayout.JAVA_BYTE.withName("refresh_frame_flags"),
        ValueLayout.JAVA_BYTE.withName("ref_frame_sign_bias_mask"),
        ValueLayout.JAVA_INT.withName("interpolation_filter"),
        ValueLayout.JAVA_BYTE.withName("base_q_idx"),
        ValueLayout.JAVA_BYTE.withName("delta_q_y_dc"),
        ValueLayout.JAVA_BYTE.withName("delta_q_uv_dc"),
        ValueLayout.JAVA_BYTE.withName("delta_q_uv_ac"),
        ValueLayout.JAVA_BYTE.withName("tile_cols_log2"),
        ValueLayout.JAVA_BYTE.withName("tile_rows_log2"),
        MemoryLayout.sequenceLayout(3, ValueLayout.JAVA_SHORT).withName("reserved1"),
        ValueLayout.ADDRESS.withTargetLayout(StdVideoVP9ColorConfig.LAYOUT).withName("pColorConfig"),
        ValueLayout.ADDRESS.withTargetLayout(StdVideoVP9LoopFilter.LAYOUT).withName("pLoopFilter"),
        ValueLayout.ADDRESS.withTargetLayout(StdVideoVP9Segmentation.LAYOUT).withName("pSegmentation")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$flags = PathElement.groupElement("flags");
    public static final PathElement PATH$profile = PathElement.groupElement("profile");
    public static final PathElement PATH$frame_type = PathElement.groupElement("frame_type");
    public static final PathElement PATH$frame_context_idx = PathElement.groupElement("frame_context_idx");
    public static final PathElement PATH$reset_frame_context = PathElement.groupElement("reset_frame_context");
    public static final PathElement PATH$refresh_frame_flags = PathElement.groupElement("refresh_frame_flags");
    public static final PathElement PATH$ref_frame_sign_bias_mask = PathElement.groupElement("ref_frame_sign_bias_mask");
    public static final PathElement PATH$interpolation_filter = PathElement.groupElement("interpolation_filter");
    public static final PathElement PATH$base_q_idx = PathElement.groupElement("base_q_idx");
    public static final PathElement PATH$delta_q_y_dc = PathElement.groupElement("delta_q_y_dc");
    public static final PathElement PATH$delta_q_uv_dc = PathElement.groupElement("delta_q_uv_dc");
    public static final PathElement PATH$delta_q_uv_ac = PathElement.groupElement("delta_q_uv_ac");
    public static final PathElement PATH$tile_cols_log2 = PathElement.groupElement("tile_cols_log2");
    public static final PathElement PATH$tile_rows_log2 = PathElement.groupElement("tile_rows_log2");
    public static final PathElement PATH$pColorConfig = PathElement.groupElement("pColorConfig");
    public static final PathElement PATH$pLoopFilter = PathElement.groupElement("pLoopFilter");
    public static final PathElement PATH$pSegmentation = PathElement.groupElement("pSegmentation");

    public static final StructLayout LAYOUT$flags = (StructLayout) LAYOUT.select(PATH$flags);
    public static final OfInt LAYOUT$profile = (OfInt) LAYOUT.select(PATH$profile);
    public static final OfInt LAYOUT$frame_type = (OfInt) LAYOUT.select(PATH$frame_type);
    public static final OfByte LAYOUT$frame_context_idx = (OfByte) LAYOUT.select(PATH$frame_context_idx);
    public static final OfByte LAYOUT$reset_frame_context = (OfByte) LAYOUT.select(PATH$reset_frame_context);
    public static final OfByte LAYOUT$refresh_frame_flags = (OfByte) LAYOUT.select(PATH$refresh_frame_flags);
    public static final OfByte LAYOUT$ref_frame_sign_bias_mask = (OfByte) LAYOUT.select(PATH$ref_frame_sign_bias_mask);
    public static final OfInt LAYOUT$interpolation_filter = (OfInt) LAYOUT.select(PATH$interpolation_filter);
    public static final OfByte LAYOUT$base_q_idx = (OfByte) LAYOUT.select(PATH$base_q_idx);
    public static final OfByte LAYOUT$delta_q_y_dc = (OfByte) LAYOUT.select(PATH$delta_q_y_dc);
    public static final OfByte LAYOUT$delta_q_uv_dc = (OfByte) LAYOUT.select(PATH$delta_q_uv_dc);
    public static final OfByte LAYOUT$delta_q_uv_ac = (OfByte) LAYOUT.select(PATH$delta_q_uv_ac);
    public static final OfByte LAYOUT$tile_cols_log2 = (OfByte) LAYOUT.select(PATH$tile_cols_log2);
    public static final OfByte LAYOUT$tile_rows_log2 = (OfByte) LAYOUT.select(PATH$tile_rows_log2);
    public static final AddressLayout LAYOUT$pColorConfig = (AddressLayout) LAYOUT.select(PATH$pColorConfig);
    public static final AddressLayout LAYOUT$pLoopFilter = (AddressLayout) LAYOUT.select(PATH$pLoopFilter);
    public static final AddressLayout LAYOUT$pSegmentation = (AddressLayout) LAYOUT.select(PATH$pSegmentation);

    public static final long SIZE$flags = LAYOUT$flags.byteSize();
    public static final long SIZE$profile = LAYOUT$profile.byteSize();
    public static final long SIZE$frame_type = LAYOUT$frame_type.byteSize();
    public static final long SIZE$frame_context_idx = LAYOUT$frame_context_idx.byteSize();
    public static final long SIZE$reset_frame_context = LAYOUT$reset_frame_context.byteSize();
    public static final long SIZE$refresh_frame_flags = LAYOUT$refresh_frame_flags.byteSize();
    public static final long SIZE$ref_frame_sign_bias_mask = LAYOUT$ref_frame_sign_bias_mask.byteSize();
    public static final long SIZE$interpolation_filter = LAYOUT$interpolation_filter.byteSize();
    public static final long SIZE$base_q_idx = LAYOUT$base_q_idx.byteSize();
    public static final long SIZE$delta_q_y_dc = LAYOUT$delta_q_y_dc.byteSize();
    public static final long SIZE$delta_q_uv_dc = LAYOUT$delta_q_uv_dc.byteSize();
    public static final long SIZE$delta_q_uv_ac = LAYOUT$delta_q_uv_ac.byteSize();
    public static final long SIZE$tile_cols_log2 = LAYOUT$tile_cols_log2.byteSize();
    public static final long SIZE$tile_rows_log2 = LAYOUT$tile_rows_log2.byteSize();
    public static final long SIZE$pColorConfig = LAYOUT$pColorConfig.byteSize();
    public static final long SIZE$pLoopFilter = LAYOUT$pLoopFilter.byteSize();
    public static final long SIZE$pSegmentation = LAYOUT$pSegmentation.byteSize();

    public static final long OFFSET$flags = LAYOUT.byteOffset(PATH$flags);
    public static final long OFFSET$profile = LAYOUT.byteOffset(PATH$profile);
    public static final long OFFSET$frame_type = LAYOUT.byteOffset(PATH$frame_type);
    public static final long OFFSET$frame_context_idx = LAYOUT.byteOffset(PATH$frame_context_idx);
    public static final long OFFSET$reset_frame_context = LAYOUT.byteOffset(PATH$reset_frame_context);
    public static final long OFFSET$refresh_frame_flags = LAYOUT.byteOffset(PATH$refresh_frame_flags);
    public static final long OFFSET$ref_frame_sign_bias_mask = LAYOUT.byteOffset(PATH$ref_frame_sign_bias_mask);
    public static final long OFFSET$interpolation_filter = LAYOUT.byteOffset(PATH$interpolation_filter);
    public static final long OFFSET$base_q_idx = LAYOUT.byteOffset(PATH$base_q_idx);
    public static final long OFFSET$delta_q_y_dc = LAYOUT.byteOffset(PATH$delta_q_y_dc);
    public static final long OFFSET$delta_q_uv_dc = LAYOUT.byteOffset(PATH$delta_q_uv_dc);
    public static final long OFFSET$delta_q_uv_ac = LAYOUT.byteOffset(PATH$delta_q_uv_ac);
    public static final long OFFSET$tile_cols_log2 = LAYOUT.byteOffset(PATH$tile_cols_log2);
    public static final long OFFSET$tile_rows_log2 = LAYOUT.byteOffset(PATH$tile_rows_log2);
    public static final long OFFSET$pColorConfig = LAYOUT.byteOffset(PATH$pColorConfig);
    public static final long OFFSET$pLoopFilter = LAYOUT.byteOffset(PATH$pLoopFilter);
    public static final long OFFSET$pSegmentation = LAYOUT.byteOffset(PATH$pSegmentation);
}
