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

/// Represents a pointer to a {@code StdVideoDecodeAV1ReferenceInfo} structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct StdVideoDecodeAV1ReferenceInfo {
///     StdVideoDecodeAV1ReferenceInfoFlags flags; // @link substring="StdVideoDecodeAV1ReferenceInfoFlags" target="StdVideoDecodeAV1ReferenceInfoFlags" @link substring="flags" target="#flags"
///     uint8_t frame_type; // @link substring="frame_type" target="#frame_type"
///     uint8_t RefFrameSignBias; // @link substring="RefFrameSignBias" target="#RefFrameSignBias"
///     uint8_t OrderHint; // @link substring="OrderHint" target="#OrderHint"
///     uint8_t[STD_VIDEO_AV1_NUM_REF_FRAMES] SavedOrderHints; // @link substring="SavedOrderHints" target="#SavedOrderHints"
/// } StdVideoDecodeAV1ReferenceInfo;
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
public record StdVideoDecodeAV1ReferenceInfo(@NotNull MemorySegment segment) implements IStdVideoDecodeAV1ReferenceInfo {
    /// Represents a pointer to / an array of null structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link StdVideoDecodeAV1ReferenceInfo}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IStdVideoDecodeAV1ReferenceInfo to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code StdVideoDecodeAV1ReferenceInfo.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IStdVideoDecodeAV1ReferenceInfo, Iterable<StdVideoDecodeAV1ReferenceInfo> {
        public long size() {
            return segment.byteSize() / StdVideoDecodeAV1ReferenceInfo.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull StdVideoDecodeAV1ReferenceInfo at(long index) {
            return new StdVideoDecodeAV1ReferenceInfo(segment.asSlice(index * StdVideoDecodeAV1ReferenceInfo.BYTES, StdVideoDecodeAV1ReferenceInfo.BYTES));
        }

        public StdVideoDecodeAV1ReferenceInfo.Ptr at(long index, @NotNull Consumer<@NotNull StdVideoDecodeAV1ReferenceInfo> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull StdVideoDecodeAV1ReferenceInfo value) {
            MemorySegment s = segment.asSlice(index * StdVideoDecodeAV1ReferenceInfo.BYTES, StdVideoDecodeAV1ReferenceInfo.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * StdVideoDecodeAV1ReferenceInfo.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * StdVideoDecodeAV1ReferenceInfo.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * StdVideoDecodeAV1ReferenceInfo.BYTES,
                (end - start) * StdVideoDecodeAV1ReferenceInfo.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * StdVideoDecodeAV1ReferenceInfo.BYTES));
        }

        public StdVideoDecodeAV1ReferenceInfo[] toArray() {
            StdVideoDecodeAV1ReferenceInfo[] ret = new StdVideoDecodeAV1ReferenceInfo[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<StdVideoDecodeAV1ReferenceInfo> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<StdVideoDecodeAV1ReferenceInfo> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= StdVideoDecodeAV1ReferenceInfo.BYTES;
            }

            @Override
            public StdVideoDecodeAV1ReferenceInfo next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                StdVideoDecodeAV1ReferenceInfo ret = new StdVideoDecodeAV1ReferenceInfo(segment.asSlice(0, StdVideoDecodeAV1ReferenceInfo.BYTES));
                segment = segment.asSlice(StdVideoDecodeAV1ReferenceInfo.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static StdVideoDecodeAV1ReferenceInfo allocate(Arena arena) {
        return new StdVideoDecodeAV1ReferenceInfo(arena.allocate(LAYOUT));
    }

    public static StdVideoDecodeAV1ReferenceInfo.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        return new StdVideoDecodeAV1ReferenceInfo.Ptr(segment);
    }

    public static StdVideoDecodeAV1ReferenceInfo clone(Arena arena, StdVideoDecodeAV1ReferenceInfo src) {
        StdVideoDecodeAV1ReferenceInfo ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public @NotNull StdVideoDecodeAV1ReferenceInfoFlags flags() {
        return new StdVideoDecodeAV1ReferenceInfoFlags(segment.asSlice(OFFSET$flags, LAYOUT$flags));
    }

    public StdVideoDecodeAV1ReferenceInfo flags(@NotNull StdVideoDecodeAV1ReferenceInfoFlags value) {
        MemorySegment.copy(value.segment(), 0, segment, OFFSET$flags, SIZE$flags);
        return this;
    }

    public StdVideoDecodeAV1ReferenceInfo flags(Consumer<@NotNull StdVideoDecodeAV1ReferenceInfoFlags> consumer) {
        consumer.accept(flags());
        return this;
    }

    public @Unsigned byte frame_type() {
        return segment.get(LAYOUT$frame_type, OFFSET$frame_type);
    }

    public StdVideoDecodeAV1ReferenceInfo frame_type(@Unsigned byte value) {
        segment.set(LAYOUT$frame_type, OFFSET$frame_type, value);
        return this;
    }

    public @Unsigned byte RefFrameSignBias() {
        return segment.get(LAYOUT$RefFrameSignBias, OFFSET$RefFrameSignBias);
    }

    public StdVideoDecodeAV1ReferenceInfo RefFrameSignBias(@Unsigned byte value) {
        segment.set(LAYOUT$RefFrameSignBias, OFFSET$RefFrameSignBias, value);
        return this;
    }

    public @Unsigned byte OrderHint() {
        return segment.get(LAYOUT$OrderHint, OFFSET$OrderHint);
    }

    public StdVideoDecodeAV1ReferenceInfo OrderHint(@Unsigned byte value) {
        segment.set(LAYOUT$OrderHint, OFFSET$OrderHint, value);
        return this;
    }

    public @Unsigned BytePtr SavedOrderHints() {
        return new BytePtr(SavedOrderHintsRaw());
    }

    public StdVideoDecodeAV1ReferenceInfo SavedOrderHints(@NotNull Consumer<BytePtr> consumer) {
        @Unsigned BytePtr ptr = SavedOrderHints();
        consumer.accept(ptr);
        return this;
    }

    public StdVideoDecodeAV1ReferenceInfo SavedOrderHints(@Unsigned BytePtr value) {
        MemorySegment s = SavedOrderHintsRaw();
        s.copyFrom(value.segment());
        return this;
    }

    public @NotNull MemorySegment SavedOrderHintsRaw() {
        return segment.asSlice(OFFSET$SavedOrderHints, SIZE$SavedOrderHints);
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        StdVideoDecodeAV1ReferenceInfoFlags.LAYOUT.withName("flags"),
        ValueLayout.JAVA_BYTE.withName("frame_type"),
        ValueLayout.JAVA_BYTE.withName("RefFrameSignBias"),
        ValueLayout.JAVA_BYTE.withName("OrderHint"),
        MemoryLayout.sequenceLayout(AV1_NUM_REF_FRAMES, ValueLayout.JAVA_BYTE).withName("SavedOrderHints")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$flags = PathElement.groupElement("flags");
    public static final PathElement PATH$frame_type = PathElement.groupElement("frame_type");
    public static final PathElement PATH$RefFrameSignBias = PathElement.groupElement("RefFrameSignBias");
    public static final PathElement PATH$OrderHint = PathElement.groupElement("OrderHint");
    public static final PathElement PATH$SavedOrderHints = PathElement.groupElement("SavedOrderHints");

    public static final StructLayout LAYOUT$flags = (StructLayout) LAYOUT.select(PATH$flags);
    public static final OfByte LAYOUT$frame_type = (OfByte) LAYOUT.select(PATH$frame_type);
    public static final OfByte LAYOUT$RefFrameSignBias = (OfByte) LAYOUT.select(PATH$RefFrameSignBias);
    public static final OfByte LAYOUT$OrderHint = (OfByte) LAYOUT.select(PATH$OrderHint);
    public static final SequenceLayout LAYOUT$SavedOrderHints = (SequenceLayout) LAYOUT.select(PATH$SavedOrderHints);

    public static final long SIZE$flags = LAYOUT$flags.byteSize();
    public static final long SIZE$frame_type = LAYOUT$frame_type.byteSize();
    public static final long SIZE$RefFrameSignBias = LAYOUT$RefFrameSignBias.byteSize();
    public static final long SIZE$OrderHint = LAYOUT$OrderHint.byteSize();
    public static final long SIZE$SavedOrderHints = LAYOUT$SavedOrderHints.byteSize();

    public static final long OFFSET$flags = LAYOUT.byteOffset(PATH$flags);
    public static final long OFFSET$frame_type = LAYOUT.byteOffset(PATH$frame_type);
    public static final long OFFSET$RefFrameSignBias = LAYOUT.byteOffset(PATH$RefFrameSignBias);
    public static final long OFFSET$OrderHint = LAYOUT.byteOffset(PATH$OrderHint);
    public static final long OFFSET$SavedOrderHints = LAYOUT.byteOffset(PATH$SavedOrderHints);
}
