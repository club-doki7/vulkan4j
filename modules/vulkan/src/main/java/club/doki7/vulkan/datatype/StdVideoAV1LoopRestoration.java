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

/// Represents a pointer to a {@code StdVideoAV1LoopRestoration} structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct StdVideoAV1LoopRestoration {
///     StdVideoAV1FrameRestorationType[STD_VIDEO_AV1_MAX_NUM_PLANES] FrameRestorationType; // @link substring="StdVideoAV1FrameRestorationType" target="StdVideoAV1FrameRestorationType" @link substring="FrameRestorationType" target="#FrameRestorationType"
///     uint16_t[STD_VIDEO_AV1_MAX_NUM_PLANES] LoopRestorationSize; // @link substring="LoopRestorationSize" target="#LoopRestorationSize"
/// } StdVideoAV1LoopRestoration;
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
public record StdVideoAV1LoopRestoration(@NotNull MemorySegment segment) implements IStdVideoAV1LoopRestoration {
    /// Represents a pointer to / an array of null structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link StdVideoAV1LoopRestoration}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IStdVideoAV1LoopRestoration to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code StdVideoAV1LoopRestoration.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IStdVideoAV1LoopRestoration, Iterable<StdVideoAV1LoopRestoration> {
        public long size() {
            return segment.byteSize() / StdVideoAV1LoopRestoration.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull StdVideoAV1LoopRestoration at(long index) {
            return new StdVideoAV1LoopRestoration(segment.asSlice(index * StdVideoAV1LoopRestoration.BYTES, StdVideoAV1LoopRestoration.BYTES));
        }

        public StdVideoAV1LoopRestoration.Ptr at(long index, @NotNull Consumer<@NotNull StdVideoAV1LoopRestoration> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull StdVideoAV1LoopRestoration value) {
            MemorySegment s = segment.asSlice(index * StdVideoAV1LoopRestoration.BYTES, StdVideoAV1LoopRestoration.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * StdVideoAV1LoopRestoration.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * StdVideoAV1LoopRestoration.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * StdVideoAV1LoopRestoration.BYTES,
                (end - start) * StdVideoAV1LoopRestoration.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * StdVideoAV1LoopRestoration.BYTES));
        }

        public StdVideoAV1LoopRestoration[] toArray() {
            StdVideoAV1LoopRestoration[] ret = new StdVideoAV1LoopRestoration[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<StdVideoAV1LoopRestoration> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<StdVideoAV1LoopRestoration> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= StdVideoAV1LoopRestoration.BYTES;
            }

            @Override
            public StdVideoAV1LoopRestoration next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                StdVideoAV1LoopRestoration ret = new StdVideoAV1LoopRestoration(segment.asSlice(0, StdVideoAV1LoopRestoration.BYTES));
                segment = segment.asSlice(StdVideoAV1LoopRestoration.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static StdVideoAV1LoopRestoration allocate(Arena arena) {
        return new StdVideoAV1LoopRestoration(arena.allocate(LAYOUT));
    }

    public static StdVideoAV1LoopRestoration.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        return new StdVideoAV1LoopRestoration.Ptr(segment);
    }

    public static StdVideoAV1LoopRestoration clone(Arena arena, StdVideoAV1LoopRestoration src) {
        StdVideoAV1LoopRestoration ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public @EnumType(StdVideoAV1FrameRestorationType.class) IntPtr FrameRestorationType() {
        return new IntPtr(FrameRestorationTypeRaw());
    }

    public StdVideoAV1LoopRestoration FrameRestorationType(@NotNull Consumer<IntPtr> consumer) {
        @EnumType(StdVideoAV1FrameRestorationType.class) IntPtr ptr = FrameRestorationType();
        consumer.accept(ptr);
        return this;
    }

    public StdVideoAV1LoopRestoration FrameRestorationType(@EnumType(StdVideoAV1FrameRestorationType.class) IntPtr value) {
        MemorySegment s = FrameRestorationTypeRaw();
        s.copyFrom(value.segment());
        return this;
    }

    public @NotNull MemorySegment FrameRestorationTypeRaw() {
        return segment.asSlice(OFFSET$FrameRestorationType, SIZE$FrameRestorationType);
    }

    public @Unsigned ShortPtr LoopRestorationSize() {
        return new ShortPtr(LoopRestorationSizeRaw());
    }

    public StdVideoAV1LoopRestoration LoopRestorationSize(@NotNull Consumer<ShortPtr> consumer) {
        @Unsigned ShortPtr ptr = LoopRestorationSize();
        consumer.accept(ptr);
        return this;
    }

    public StdVideoAV1LoopRestoration LoopRestorationSize(@Unsigned ShortPtr value) {
        MemorySegment s = LoopRestorationSizeRaw();
        s.copyFrom(value.segment());
        return this;
    }

    public @NotNull MemorySegment LoopRestorationSizeRaw() {
        return segment.asSlice(OFFSET$LoopRestorationSize, SIZE$LoopRestorationSize);
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        MemoryLayout.sequenceLayout(AV1_MAX_NUM_PLANES, ValueLayout.JAVA_INT).withName("FrameRestorationType"),
        MemoryLayout.sequenceLayout(AV1_MAX_NUM_PLANES, ValueLayout.JAVA_SHORT).withName("LoopRestorationSize")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$FrameRestorationType = PathElement.groupElement("FrameRestorationType");
    public static final PathElement PATH$LoopRestorationSize = PathElement.groupElement("LoopRestorationSize");

    public static final SequenceLayout LAYOUT$FrameRestorationType = (SequenceLayout) LAYOUT.select(PATH$FrameRestorationType);
    public static final SequenceLayout LAYOUT$LoopRestorationSize = (SequenceLayout) LAYOUT.select(PATH$LoopRestorationSize);

    public static final long SIZE$FrameRestorationType = LAYOUT$FrameRestorationType.byteSize();
    public static final long SIZE$LoopRestorationSize = LAYOUT$LoopRestorationSize.byteSize();

    public static final long OFFSET$FrameRestorationType = LAYOUT.byteOffset(PATH$FrameRestorationType);
    public static final long OFFSET$LoopRestorationSize = LAYOUT.byteOffset(PATH$LoopRestorationSize);
}
