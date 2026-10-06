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

/// Represents a pointer to a {@code StdVideoAV1LoopFilter} structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct StdVideoAV1LoopFilter {
///     StdVideoAV1LoopFilterFlags flags; // @link substring="StdVideoAV1LoopFilterFlags" target="StdVideoAV1LoopFilterFlags" @link substring="flags" target="#flags"
///     uint8_t[STD_VIDEO_AV1_MAX_LOOP_FILTER_STRENGTHS] loop_filter_level; // @link substring="loop_filter_level" target="#loop_filter_level"
///     uint8_t loop_filter_sharpness; // @link substring="loop_filter_sharpness" target="#loop_filter_sharpness"
///     uint8_t update_ref_delta; // @link substring="update_ref_delta" target="#update_ref_delta"
///     int8_t[STD_VIDEO_AV1_TOTAL_REFS_PER_FRAME] loop_filter_ref_deltas; // @link substring="loop_filter_ref_deltas" target="#loop_filter_ref_deltas"
///     uint8_t update_mode_delta; // @link substring="update_mode_delta" target="#update_mode_delta"
///     int8_t[STD_VIDEO_AV1_LOOP_FILTER_ADJUSTMENTS] loop_filter_mode_deltas; // @link substring="loop_filter_mode_deltas" target="#loop_filter_mode_deltas"
/// } StdVideoAV1LoopFilter;
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
public record StdVideoAV1LoopFilter(@NotNull MemorySegment segment) implements IStdVideoAV1LoopFilter {
    /// Represents a pointer to / an array of null structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link StdVideoAV1LoopFilter}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IStdVideoAV1LoopFilter to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code StdVideoAV1LoopFilter.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IStdVideoAV1LoopFilter, Iterable<StdVideoAV1LoopFilter> {
        public long size() {
            return segment.byteSize() / StdVideoAV1LoopFilter.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull StdVideoAV1LoopFilter at(long index) {
            return new StdVideoAV1LoopFilter(segment.asSlice(index * StdVideoAV1LoopFilter.BYTES, StdVideoAV1LoopFilter.BYTES));
        }

        public StdVideoAV1LoopFilter.Ptr at(long index, @NotNull Consumer<@NotNull StdVideoAV1LoopFilter> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull StdVideoAV1LoopFilter value) {
            MemorySegment s = segment.asSlice(index * StdVideoAV1LoopFilter.BYTES, StdVideoAV1LoopFilter.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * StdVideoAV1LoopFilter.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * StdVideoAV1LoopFilter.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * StdVideoAV1LoopFilter.BYTES,
                (end - start) * StdVideoAV1LoopFilter.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * StdVideoAV1LoopFilter.BYTES));
        }

        public StdVideoAV1LoopFilter[] toArray() {
            StdVideoAV1LoopFilter[] ret = new StdVideoAV1LoopFilter[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<StdVideoAV1LoopFilter> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<StdVideoAV1LoopFilter> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= StdVideoAV1LoopFilter.BYTES;
            }

            @Override
            public StdVideoAV1LoopFilter next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                StdVideoAV1LoopFilter ret = new StdVideoAV1LoopFilter(segment.asSlice(0, StdVideoAV1LoopFilter.BYTES));
                segment = segment.asSlice(StdVideoAV1LoopFilter.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static StdVideoAV1LoopFilter allocate(Arena arena) {
        return new StdVideoAV1LoopFilter(arena.allocate(LAYOUT));
    }

    public static StdVideoAV1LoopFilter.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        return new StdVideoAV1LoopFilter.Ptr(segment);
    }

    public static StdVideoAV1LoopFilter clone(Arena arena, StdVideoAV1LoopFilter src) {
        StdVideoAV1LoopFilter ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public @NotNull StdVideoAV1LoopFilterFlags flags() {
        return new StdVideoAV1LoopFilterFlags(segment.asSlice(OFFSET$flags, LAYOUT$flags));
    }

    public StdVideoAV1LoopFilter flags(@NotNull StdVideoAV1LoopFilterFlags value) {
        MemorySegment.copy(value.segment(), 0, segment, OFFSET$flags, SIZE$flags);
        return this;
    }

    public StdVideoAV1LoopFilter flags(Consumer<@NotNull StdVideoAV1LoopFilterFlags> consumer) {
        consumer.accept(flags());
        return this;
    }

    public @Unsigned BytePtr loop_filter_level() {
        return new BytePtr(loop_filter_levelRaw());
    }

    public StdVideoAV1LoopFilter loop_filter_level(@NotNull Consumer<BytePtr> consumer) {
        @Unsigned BytePtr ptr = loop_filter_level();
        consumer.accept(ptr);
        return this;
    }

    public StdVideoAV1LoopFilter loop_filter_level(@Unsigned BytePtr value) {
        MemorySegment s = loop_filter_levelRaw();
        s.copyFrom(value.segment());
        return this;
    }

    public @NotNull MemorySegment loop_filter_levelRaw() {
        return segment.asSlice(OFFSET$loop_filter_level, SIZE$loop_filter_level);
    }

    public @Unsigned byte loop_filter_sharpness() {
        return segment.get(LAYOUT$loop_filter_sharpness, OFFSET$loop_filter_sharpness);
    }

    public StdVideoAV1LoopFilter loop_filter_sharpness(@Unsigned byte value) {
        segment.set(LAYOUT$loop_filter_sharpness, OFFSET$loop_filter_sharpness, value);
        return this;
    }

    public @Unsigned byte update_ref_delta() {
        return segment.get(LAYOUT$update_ref_delta, OFFSET$update_ref_delta);
    }

    public StdVideoAV1LoopFilter update_ref_delta(@Unsigned byte value) {
        segment.set(LAYOUT$update_ref_delta, OFFSET$update_ref_delta, value);
        return this;
    }

    public BytePtr loop_filter_ref_deltas() {
        return new BytePtr(loop_filter_ref_deltasRaw());
    }

    public StdVideoAV1LoopFilter loop_filter_ref_deltas(@NotNull Consumer<BytePtr> consumer) {
        BytePtr ptr = loop_filter_ref_deltas();
        consumer.accept(ptr);
        return this;
    }

    public StdVideoAV1LoopFilter loop_filter_ref_deltas(BytePtr value) {
        MemorySegment s = loop_filter_ref_deltasRaw();
        s.copyFrom(value.segment());
        return this;
    }

    public @NotNull MemorySegment loop_filter_ref_deltasRaw() {
        return segment.asSlice(OFFSET$loop_filter_ref_deltas, SIZE$loop_filter_ref_deltas);
    }

    public @Unsigned byte update_mode_delta() {
        return segment.get(LAYOUT$update_mode_delta, OFFSET$update_mode_delta);
    }

    public StdVideoAV1LoopFilter update_mode_delta(@Unsigned byte value) {
        segment.set(LAYOUT$update_mode_delta, OFFSET$update_mode_delta, value);
        return this;
    }

    public BytePtr loop_filter_mode_deltas() {
        return new BytePtr(loop_filter_mode_deltasRaw());
    }

    public StdVideoAV1LoopFilter loop_filter_mode_deltas(@NotNull Consumer<BytePtr> consumer) {
        BytePtr ptr = loop_filter_mode_deltas();
        consumer.accept(ptr);
        return this;
    }

    public StdVideoAV1LoopFilter loop_filter_mode_deltas(BytePtr value) {
        MemorySegment s = loop_filter_mode_deltasRaw();
        s.copyFrom(value.segment());
        return this;
    }

    public @NotNull MemorySegment loop_filter_mode_deltasRaw() {
        return segment.asSlice(OFFSET$loop_filter_mode_deltas, SIZE$loop_filter_mode_deltas);
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        StdVideoAV1LoopFilterFlags.LAYOUT.withName("flags"),
        MemoryLayout.sequenceLayout(AV1_MAX_LOOP_FILTER_STRENGTHS, ValueLayout.JAVA_BYTE).withName("loop_filter_level"),
        ValueLayout.JAVA_BYTE.withName("loop_filter_sharpness"),
        ValueLayout.JAVA_BYTE.withName("update_ref_delta"),
        MemoryLayout.sequenceLayout(AV1_TOTAL_REFS_PER_FRAME, ValueLayout.JAVA_BYTE).withName("loop_filter_ref_deltas"),
        ValueLayout.JAVA_BYTE.withName("update_mode_delta"),
        MemoryLayout.sequenceLayout(AV1_LOOP_FILTER_ADJUSTMENTS, ValueLayout.JAVA_BYTE).withName("loop_filter_mode_deltas")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$flags = PathElement.groupElement("flags");
    public static final PathElement PATH$loop_filter_level = PathElement.groupElement("loop_filter_level");
    public static final PathElement PATH$loop_filter_sharpness = PathElement.groupElement("loop_filter_sharpness");
    public static final PathElement PATH$update_ref_delta = PathElement.groupElement("update_ref_delta");
    public static final PathElement PATH$loop_filter_ref_deltas = PathElement.groupElement("loop_filter_ref_deltas");
    public static final PathElement PATH$update_mode_delta = PathElement.groupElement("update_mode_delta");
    public static final PathElement PATH$loop_filter_mode_deltas = PathElement.groupElement("loop_filter_mode_deltas");

    public static final StructLayout LAYOUT$flags = (StructLayout) LAYOUT.select(PATH$flags);
    public static final SequenceLayout LAYOUT$loop_filter_level = (SequenceLayout) LAYOUT.select(PATH$loop_filter_level);
    public static final OfByte LAYOUT$loop_filter_sharpness = (OfByte) LAYOUT.select(PATH$loop_filter_sharpness);
    public static final OfByte LAYOUT$update_ref_delta = (OfByte) LAYOUT.select(PATH$update_ref_delta);
    public static final SequenceLayout LAYOUT$loop_filter_ref_deltas = (SequenceLayout) LAYOUT.select(PATH$loop_filter_ref_deltas);
    public static final OfByte LAYOUT$update_mode_delta = (OfByte) LAYOUT.select(PATH$update_mode_delta);
    public static final SequenceLayout LAYOUT$loop_filter_mode_deltas = (SequenceLayout) LAYOUT.select(PATH$loop_filter_mode_deltas);

    public static final long SIZE$flags = LAYOUT$flags.byteSize();
    public static final long SIZE$loop_filter_level = LAYOUT$loop_filter_level.byteSize();
    public static final long SIZE$loop_filter_sharpness = LAYOUT$loop_filter_sharpness.byteSize();
    public static final long SIZE$update_ref_delta = LAYOUT$update_ref_delta.byteSize();
    public static final long SIZE$loop_filter_ref_deltas = LAYOUT$loop_filter_ref_deltas.byteSize();
    public static final long SIZE$update_mode_delta = LAYOUT$update_mode_delta.byteSize();
    public static final long SIZE$loop_filter_mode_deltas = LAYOUT$loop_filter_mode_deltas.byteSize();

    public static final long OFFSET$flags = LAYOUT.byteOffset(PATH$flags);
    public static final long OFFSET$loop_filter_level = LAYOUT.byteOffset(PATH$loop_filter_level);
    public static final long OFFSET$loop_filter_sharpness = LAYOUT.byteOffset(PATH$loop_filter_sharpness);
    public static final long OFFSET$update_ref_delta = LAYOUT.byteOffset(PATH$update_ref_delta);
    public static final long OFFSET$loop_filter_ref_deltas = LAYOUT.byteOffset(PATH$loop_filter_ref_deltas);
    public static final long OFFSET$update_mode_delta = LAYOUT.byteOffset(PATH$update_mode_delta);
    public static final long OFFSET$loop_filter_mode_deltas = LAYOUT.byteOffset(PATH$loop_filter_mode_deltas);
}
