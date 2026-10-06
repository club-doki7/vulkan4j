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

/// Represents a pointer to a {@code StdVideoVP9Segmentation} structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct StdVideoVP9Segmentation {
///     StdVideoVP9SegmentationFlags flags; // @link substring="StdVideoVP9SegmentationFlags" target="StdVideoVP9SegmentationFlags" @link substring="flags" target="#flags"
///     uint8_t[STD_VIDEO_VP9_MAX_SEGMENTATION_TREE_PROBS] segmentation_tree_probs; // @link substring="segmentation_tree_probs" target="#segmentation_tree_probs"
///     uint8_t[STD_VIDEO_VP9_MAX_SEGMENTATION_PRED_PROB] segmentation_pred_prob; // @link substring="segmentation_pred_prob" target="#segmentation_pred_prob"
///     uint8_t[STD_VIDEO_VP9_MAX_SEGMENTS] FeatureEnabled; // @link substring="FeatureEnabled" target="#FeatureEnabled"
///     int16_t[STD_VIDEO_VP9_SEG_LVL_MAX][STD_VIDEO_VP9_MAX_SEGMENTS] FeatureData; // @link substring="FeatureData" target="#FeatureData"
/// } StdVideoVP9Segmentation;
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
public record StdVideoVP9Segmentation(@NotNull MemorySegment segment) implements IStdVideoVP9Segmentation {
    /// Represents a pointer to / an array of null structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link StdVideoVP9Segmentation}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IStdVideoVP9Segmentation to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code StdVideoVP9Segmentation.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IStdVideoVP9Segmentation, Iterable<StdVideoVP9Segmentation> {
        public long size() {
            return segment.byteSize() / StdVideoVP9Segmentation.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull StdVideoVP9Segmentation at(long index) {
            return new StdVideoVP9Segmentation(segment.asSlice(index * StdVideoVP9Segmentation.BYTES, StdVideoVP9Segmentation.BYTES));
        }

        public StdVideoVP9Segmentation.Ptr at(long index, @NotNull Consumer<@NotNull StdVideoVP9Segmentation> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull StdVideoVP9Segmentation value) {
            MemorySegment s = segment.asSlice(index * StdVideoVP9Segmentation.BYTES, StdVideoVP9Segmentation.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * StdVideoVP9Segmentation.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * StdVideoVP9Segmentation.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * StdVideoVP9Segmentation.BYTES,
                (end - start) * StdVideoVP9Segmentation.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * StdVideoVP9Segmentation.BYTES));
        }

        public StdVideoVP9Segmentation[] toArray() {
            StdVideoVP9Segmentation[] ret = new StdVideoVP9Segmentation[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<StdVideoVP9Segmentation> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<StdVideoVP9Segmentation> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= StdVideoVP9Segmentation.BYTES;
            }

            @Override
            public StdVideoVP9Segmentation next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                StdVideoVP9Segmentation ret = new StdVideoVP9Segmentation(segment.asSlice(0, StdVideoVP9Segmentation.BYTES));
                segment = segment.asSlice(StdVideoVP9Segmentation.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static StdVideoVP9Segmentation allocate(Arena arena) {
        return new StdVideoVP9Segmentation(arena.allocate(LAYOUT));
    }

    public static StdVideoVP9Segmentation.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        return new StdVideoVP9Segmentation.Ptr(segment);
    }

    public static StdVideoVP9Segmentation clone(Arena arena, StdVideoVP9Segmentation src) {
        StdVideoVP9Segmentation ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public @NotNull StdVideoVP9SegmentationFlags flags() {
        return new StdVideoVP9SegmentationFlags(segment.asSlice(OFFSET$flags, LAYOUT$flags));
    }

    public StdVideoVP9Segmentation flags(@NotNull StdVideoVP9SegmentationFlags value) {
        MemorySegment.copy(value.segment(), 0, segment, OFFSET$flags, SIZE$flags);
        return this;
    }

    public StdVideoVP9Segmentation flags(Consumer<@NotNull StdVideoVP9SegmentationFlags> consumer) {
        consumer.accept(flags());
        return this;
    }

    public @Unsigned BytePtr segmentation_tree_probs() {
        return new BytePtr(segmentation_tree_probsRaw());
    }

    public StdVideoVP9Segmentation segmentation_tree_probs(@NotNull Consumer<BytePtr> consumer) {
        @Unsigned BytePtr ptr = segmentation_tree_probs();
        consumer.accept(ptr);
        return this;
    }

    public StdVideoVP9Segmentation segmentation_tree_probs(@Unsigned BytePtr value) {
        MemorySegment s = segmentation_tree_probsRaw();
        s.copyFrom(value.segment());
        return this;
    }

    public @NotNull MemorySegment segmentation_tree_probsRaw() {
        return segment.asSlice(OFFSET$segmentation_tree_probs, SIZE$segmentation_tree_probs);
    }

    public @Unsigned BytePtr segmentation_pred_prob() {
        return new BytePtr(segmentation_pred_probRaw());
    }

    public StdVideoVP9Segmentation segmentation_pred_prob(@NotNull Consumer<BytePtr> consumer) {
        @Unsigned BytePtr ptr = segmentation_pred_prob();
        consumer.accept(ptr);
        return this;
    }

    public StdVideoVP9Segmentation segmentation_pred_prob(@Unsigned BytePtr value) {
        MemorySegment s = segmentation_pred_probRaw();
        s.copyFrom(value.segment());
        return this;
    }

    public @NotNull MemorySegment segmentation_pred_probRaw() {
        return segment.asSlice(OFFSET$segmentation_pred_prob, SIZE$segmentation_pred_prob);
    }

    public @Unsigned BytePtr FeatureEnabled() {
        return new BytePtr(FeatureEnabledRaw());
    }

    public StdVideoVP9Segmentation FeatureEnabled(@NotNull Consumer<BytePtr> consumer) {
        @Unsigned BytePtr ptr = FeatureEnabled();
        consumer.accept(ptr);
        return this;
    }

    public StdVideoVP9Segmentation FeatureEnabled(@Unsigned BytePtr value) {
        MemorySegment s = FeatureEnabledRaw();
        s.copyFrom(value.segment());
        return this;
    }

    public @NotNull MemorySegment FeatureEnabledRaw() {
        return segment.asSlice(OFFSET$FeatureEnabled, SIZE$FeatureEnabled);
    }

    public ShortPtr FeatureData() {
        return new ShortPtr(FeatureDataRaw());
    }

    public StdVideoVP9Segmentation FeatureData(@NotNull Consumer<ShortPtr> consumer) {
        ShortPtr ptr = FeatureData();
        consumer.accept(ptr);
        return this;
    }

    public StdVideoVP9Segmentation FeatureData(ShortPtr value) {
        MemorySegment s = FeatureDataRaw();
        s.copyFrom(value.segment());
        return this;
    }

    public @NotNull MemorySegment FeatureDataRaw() {
        return segment.asSlice(OFFSET$FeatureData, SIZE$FeatureData);
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        StdVideoVP9SegmentationFlags.LAYOUT.withName("flags"),
        MemoryLayout.sequenceLayout(VP9_MAX_SEGMENTATION_TREE_PROBS, ValueLayout.JAVA_BYTE).withName("segmentation_tree_probs"),
        MemoryLayout.sequenceLayout(VP9_MAX_SEGMENTATION_PRED_PROB, ValueLayout.JAVA_BYTE).withName("segmentation_pred_prob"),
        MemoryLayout.sequenceLayout(VP9_MAX_SEGMENTS, ValueLayout.JAVA_BYTE).withName("FeatureEnabled"),
        MemoryLayout.sequenceLayout(VP9_MAX_SEGMENTS, MemoryLayout.sequenceLayout(VP9_SEG_LVL_MAX, ValueLayout.JAVA_SHORT)).withName("FeatureData")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$flags = PathElement.groupElement("flags");
    public static final PathElement PATH$segmentation_tree_probs = PathElement.groupElement("segmentation_tree_probs");
    public static final PathElement PATH$segmentation_pred_prob = PathElement.groupElement("segmentation_pred_prob");
    public static final PathElement PATH$FeatureEnabled = PathElement.groupElement("FeatureEnabled");
    public static final PathElement PATH$FeatureData = PathElement.groupElement("FeatureData");

    public static final StructLayout LAYOUT$flags = (StructLayout) LAYOUT.select(PATH$flags);
    public static final SequenceLayout LAYOUT$segmentation_tree_probs = (SequenceLayout) LAYOUT.select(PATH$segmentation_tree_probs);
    public static final SequenceLayout LAYOUT$segmentation_pred_prob = (SequenceLayout) LAYOUT.select(PATH$segmentation_pred_prob);
    public static final SequenceLayout LAYOUT$FeatureEnabled = (SequenceLayout) LAYOUT.select(PATH$FeatureEnabled);
    public static final SequenceLayout LAYOUT$FeatureData = (SequenceLayout) LAYOUT.select(PATH$FeatureData);

    public static final long SIZE$flags = LAYOUT$flags.byteSize();
    public static final long SIZE$segmentation_tree_probs = LAYOUT$segmentation_tree_probs.byteSize();
    public static final long SIZE$segmentation_pred_prob = LAYOUT$segmentation_pred_prob.byteSize();
    public static final long SIZE$FeatureEnabled = LAYOUT$FeatureEnabled.byteSize();
    public static final long SIZE$FeatureData = LAYOUT$FeatureData.byteSize();

    public static final long OFFSET$flags = LAYOUT.byteOffset(PATH$flags);
    public static final long OFFSET$segmentation_tree_probs = LAYOUT.byteOffset(PATH$segmentation_tree_probs);
    public static final long OFFSET$segmentation_pred_prob = LAYOUT.byteOffset(PATH$segmentation_pred_prob);
    public static final long OFFSET$FeatureEnabled = LAYOUT.byteOffset(PATH$FeatureEnabled);
    public static final long OFFSET$FeatureData = LAYOUT.byteOffset(PATH$FeatureData);
}
