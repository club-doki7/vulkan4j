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

/// Represents a pointer to a {@code StdVideoDecodeVP9PictureInfoFlags} structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct StdVideoDecodeVP9PictureInfoFlags {
///     uint32_t error_resilient_mode : 1; // @link substring="error_resilient_mode" target="#error_resilient_mode"
///     uint32_t intra_only : 1; // @link substring="intra_only" target="#intra_only"
///     uint32_t allow_high_precision_mv : 1; // @link substring="allow_high_precision_mv" target="#allow_high_precision_mv"
///     uint32_t refresh_frame_context : 1; // @link substring="refresh_frame_context" target="#refresh_frame_context"
///     uint32_t frame_parallel_decoding_mode : 1; // @link substring="frame_parallel_decoding_mode" target="#frame_parallel_decoding_mode"
///     uint32_t segmentation_enabled : 1; // @link substring="segmentation_enabled" target="#segmentation_enabled"
///     uint32_t show_frame : 1; // @link substring="show_frame" target="#show_frame"
///     uint32_t UsePrevFrameMvs : 1; // @link substring="UsePrevFrameMvs" target="#UsePrevFrameMvs"
///     uint32_t reserved : 24;
/// } StdVideoDecodeVP9PictureInfoFlags;
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
public record StdVideoDecodeVP9PictureInfoFlags(@NotNull MemorySegment segment) implements IStdVideoDecodeVP9PictureInfoFlags {
    /// Represents a pointer to / an array of null structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link StdVideoDecodeVP9PictureInfoFlags}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IStdVideoDecodeVP9PictureInfoFlags to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code StdVideoDecodeVP9PictureInfoFlags.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IStdVideoDecodeVP9PictureInfoFlags, Iterable<StdVideoDecodeVP9PictureInfoFlags> {
        public long size() {
            return segment.byteSize() / StdVideoDecodeVP9PictureInfoFlags.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull StdVideoDecodeVP9PictureInfoFlags at(long index) {
            return new StdVideoDecodeVP9PictureInfoFlags(segment.asSlice(index * StdVideoDecodeVP9PictureInfoFlags.BYTES, StdVideoDecodeVP9PictureInfoFlags.BYTES));
        }

        public StdVideoDecodeVP9PictureInfoFlags.Ptr at(long index, @NotNull Consumer<@NotNull StdVideoDecodeVP9PictureInfoFlags> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull StdVideoDecodeVP9PictureInfoFlags value) {
            MemorySegment s = segment.asSlice(index * StdVideoDecodeVP9PictureInfoFlags.BYTES, StdVideoDecodeVP9PictureInfoFlags.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * StdVideoDecodeVP9PictureInfoFlags.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * StdVideoDecodeVP9PictureInfoFlags.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * StdVideoDecodeVP9PictureInfoFlags.BYTES,
                (end - start) * StdVideoDecodeVP9PictureInfoFlags.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * StdVideoDecodeVP9PictureInfoFlags.BYTES));
        }

        public StdVideoDecodeVP9PictureInfoFlags[] toArray() {
            StdVideoDecodeVP9PictureInfoFlags[] ret = new StdVideoDecodeVP9PictureInfoFlags[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<StdVideoDecodeVP9PictureInfoFlags> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<StdVideoDecodeVP9PictureInfoFlags> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= StdVideoDecodeVP9PictureInfoFlags.BYTES;
            }

            @Override
            public StdVideoDecodeVP9PictureInfoFlags next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                StdVideoDecodeVP9PictureInfoFlags ret = new StdVideoDecodeVP9PictureInfoFlags(segment.asSlice(0, StdVideoDecodeVP9PictureInfoFlags.BYTES));
                segment = segment.asSlice(StdVideoDecodeVP9PictureInfoFlags.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static StdVideoDecodeVP9PictureInfoFlags allocate(Arena arena) {
        return new StdVideoDecodeVP9PictureInfoFlags(arena.allocate(LAYOUT));
    }

    public static StdVideoDecodeVP9PictureInfoFlags.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        return new StdVideoDecodeVP9PictureInfoFlags.Ptr(segment);
    }

    public static StdVideoDecodeVP9PictureInfoFlags clone(Arena arena, StdVideoDecodeVP9PictureInfoFlags src) {
        StdVideoDecodeVP9PictureInfoFlags ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public boolean error_resilient_mode() {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$error_resilient_mode$reserved, LAYOUT$bitfield$error_resilient_mode$reserved);
        return BitfieldUtil.readBit(s, 0);
    }

    public StdVideoDecodeVP9PictureInfoFlags error_resilient_mode(boolean value) {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$error_resilient_mode$reserved, LAYOUT$bitfield$error_resilient_mode$reserved);
        BitfieldUtil.writeBit(s, 0, value);
        return this;
    }

    public boolean intra_only() {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$error_resilient_mode$reserved, LAYOUT$bitfield$error_resilient_mode$reserved);
        return BitfieldUtil.readBit(s, 1);
    }

    public StdVideoDecodeVP9PictureInfoFlags intra_only(boolean value) {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$error_resilient_mode$reserved, LAYOUT$bitfield$error_resilient_mode$reserved);
        BitfieldUtil.writeBit(s, 1, value);
        return this;
    }

    public boolean allow_high_precision_mv() {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$error_resilient_mode$reserved, LAYOUT$bitfield$error_resilient_mode$reserved);
        return BitfieldUtil.readBit(s, 2);
    }

    public StdVideoDecodeVP9PictureInfoFlags allow_high_precision_mv(boolean value) {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$error_resilient_mode$reserved, LAYOUT$bitfield$error_resilient_mode$reserved);
        BitfieldUtil.writeBit(s, 2, value);
        return this;
    }

    public boolean refresh_frame_context() {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$error_resilient_mode$reserved, LAYOUT$bitfield$error_resilient_mode$reserved);
        return BitfieldUtil.readBit(s, 3);
    }

    public StdVideoDecodeVP9PictureInfoFlags refresh_frame_context(boolean value) {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$error_resilient_mode$reserved, LAYOUT$bitfield$error_resilient_mode$reserved);
        BitfieldUtil.writeBit(s, 3, value);
        return this;
    }

    public boolean frame_parallel_decoding_mode() {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$error_resilient_mode$reserved, LAYOUT$bitfield$error_resilient_mode$reserved);
        return BitfieldUtil.readBit(s, 4);
    }

    public StdVideoDecodeVP9PictureInfoFlags frame_parallel_decoding_mode(boolean value) {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$error_resilient_mode$reserved, LAYOUT$bitfield$error_resilient_mode$reserved);
        BitfieldUtil.writeBit(s, 4, value);
        return this;
    }

    public boolean segmentation_enabled() {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$error_resilient_mode$reserved, LAYOUT$bitfield$error_resilient_mode$reserved);
        return BitfieldUtil.readBit(s, 5);
    }

    public StdVideoDecodeVP9PictureInfoFlags segmentation_enabled(boolean value) {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$error_resilient_mode$reserved, LAYOUT$bitfield$error_resilient_mode$reserved);
        BitfieldUtil.writeBit(s, 5, value);
        return this;
    }

    public boolean show_frame() {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$error_resilient_mode$reserved, LAYOUT$bitfield$error_resilient_mode$reserved);
        return BitfieldUtil.readBit(s, 6);
    }

    public StdVideoDecodeVP9PictureInfoFlags show_frame(boolean value) {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$error_resilient_mode$reserved, LAYOUT$bitfield$error_resilient_mode$reserved);
        BitfieldUtil.writeBit(s, 6, value);
        return this;
    }

    public boolean UsePrevFrameMvs() {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$error_resilient_mode$reserved, LAYOUT$bitfield$error_resilient_mode$reserved);
        return BitfieldUtil.readBit(s, 7);
    }

    public StdVideoDecodeVP9PictureInfoFlags UsePrevFrameMvs(boolean value) {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$error_resilient_mode$reserved, LAYOUT$bitfield$error_resilient_mode$reserved);
        BitfieldUtil.writeBit(s, 7, value);
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
