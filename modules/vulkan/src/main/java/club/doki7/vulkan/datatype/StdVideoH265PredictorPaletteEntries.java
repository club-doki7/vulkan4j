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

/// Represents a pointer to a {@code StdVideoH265PredictorPaletteEntries} structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct StdVideoH265PredictorPaletteEntries {
///     uint16_t[STD_VIDEO_H265_PREDICTOR_PALETTE_COMP_ENTRIES_LIST_SIZE][STD_VIDEO_H265_PREDICTOR_PALETTE_COMPONENTS_LIST_SIZE] PredictorPaletteEntries; // @link substring="PredictorPaletteEntries" target="#PredictorPaletteEntries"
/// } StdVideoH265PredictorPaletteEntries;
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
public record StdVideoH265PredictorPaletteEntries(@NotNull MemorySegment segment) implements IStdVideoH265PredictorPaletteEntries {
    /// Represents a pointer to / an array of null structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link StdVideoH265PredictorPaletteEntries}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IStdVideoH265PredictorPaletteEntries to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code StdVideoH265PredictorPaletteEntries.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IStdVideoH265PredictorPaletteEntries, Iterable<StdVideoH265PredictorPaletteEntries> {
        public long size() {
            return segment.byteSize() / StdVideoH265PredictorPaletteEntries.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull StdVideoH265PredictorPaletteEntries at(long index) {
            return new StdVideoH265PredictorPaletteEntries(segment.asSlice(index * StdVideoH265PredictorPaletteEntries.BYTES, StdVideoH265PredictorPaletteEntries.BYTES));
        }

        public StdVideoH265PredictorPaletteEntries.Ptr at(long index, @NotNull Consumer<@NotNull StdVideoH265PredictorPaletteEntries> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull StdVideoH265PredictorPaletteEntries value) {
            MemorySegment s = segment.asSlice(index * StdVideoH265PredictorPaletteEntries.BYTES, StdVideoH265PredictorPaletteEntries.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * StdVideoH265PredictorPaletteEntries.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * StdVideoH265PredictorPaletteEntries.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * StdVideoH265PredictorPaletteEntries.BYTES,
                (end - start) * StdVideoH265PredictorPaletteEntries.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * StdVideoH265PredictorPaletteEntries.BYTES));
        }

        public StdVideoH265PredictorPaletteEntries[] toArray() {
            StdVideoH265PredictorPaletteEntries[] ret = new StdVideoH265PredictorPaletteEntries[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<StdVideoH265PredictorPaletteEntries> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<StdVideoH265PredictorPaletteEntries> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= StdVideoH265PredictorPaletteEntries.BYTES;
            }

            @Override
            public StdVideoH265PredictorPaletteEntries next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                StdVideoH265PredictorPaletteEntries ret = new StdVideoH265PredictorPaletteEntries(segment.asSlice(0, StdVideoH265PredictorPaletteEntries.BYTES));
                segment = segment.asSlice(StdVideoH265PredictorPaletteEntries.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static StdVideoH265PredictorPaletteEntries allocate(Arena arena) {
        return new StdVideoH265PredictorPaletteEntries(arena.allocate(LAYOUT));
    }

    public static StdVideoH265PredictorPaletteEntries.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        return new StdVideoH265PredictorPaletteEntries.Ptr(segment);
    }

    public static StdVideoH265PredictorPaletteEntries clone(Arena arena, StdVideoH265PredictorPaletteEntries src) {
        StdVideoH265PredictorPaletteEntries ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public @Unsigned ShortPtr PredictorPaletteEntries() {
        return new ShortPtr(PredictorPaletteEntriesRaw());
    }

    public StdVideoH265PredictorPaletteEntries PredictorPaletteEntries(@NotNull Consumer<ShortPtr> consumer) {
        @Unsigned ShortPtr ptr = PredictorPaletteEntries();
        consumer.accept(ptr);
        return this;
    }

    public StdVideoH265PredictorPaletteEntries PredictorPaletteEntries(@Unsigned ShortPtr value) {
        MemorySegment s = PredictorPaletteEntriesRaw();
        s.copyFrom(value.segment());
        return this;
    }

    public @NotNull MemorySegment PredictorPaletteEntriesRaw() {
        return segment.asSlice(OFFSET$PredictorPaletteEntries, SIZE$PredictorPaletteEntries);
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        MemoryLayout.sequenceLayout(H265_PREDICTOR_PALETTE_COMPONENTS_LIST_SIZE, MemoryLayout.sequenceLayout(H265_PREDICTOR_PALETTE_COMP_ENTRIES_LIST_SIZE, ValueLayout.JAVA_SHORT)).withName("PredictorPaletteEntries")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$PredictorPaletteEntries = PathElement.groupElement("PredictorPaletteEntries");

    public static final SequenceLayout LAYOUT$PredictorPaletteEntries = (SequenceLayout) LAYOUT.select(PATH$PredictorPaletteEntries);

    public static final long SIZE$PredictorPaletteEntries = LAYOUT$PredictorPaletteEntries.byteSize();

    public static final long OFFSET$PredictorPaletteEntries = LAYOUT.byteOffset(PATH$PredictorPaletteEntries);
}
