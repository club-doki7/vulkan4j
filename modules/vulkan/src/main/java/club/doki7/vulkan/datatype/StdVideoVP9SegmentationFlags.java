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

/// Represents a pointer to a {@code StdVideoVP9SegmentationFlags} structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct StdVideoVP9SegmentationFlags {
///     uint32_t segmentation_update_map : 1; // @link substring="segmentation_update_map" target="#segmentation_update_map"
///     uint32_t segmentation_temporal_update : 1; // @link substring="segmentation_temporal_update" target="#segmentation_temporal_update"
///     uint32_t segmentation_update_data : 1; // @link substring="segmentation_update_data" target="#segmentation_update_data"
///     uint32_t segmentation_abs_or_delta_update : 1; // @link substring="segmentation_abs_or_delta_update" target="#segmentation_abs_or_delta_update"
///     uint32_t reserved : 28;
/// } StdVideoVP9SegmentationFlags;
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
public record StdVideoVP9SegmentationFlags(@NotNull MemorySegment segment) implements IStdVideoVP9SegmentationFlags {
    /// Represents a pointer to / an array of null structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link StdVideoVP9SegmentationFlags}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IStdVideoVP9SegmentationFlags to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code StdVideoVP9SegmentationFlags.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IStdVideoVP9SegmentationFlags, Iterable<StdVideoVP9SegmentationFlags> {
        public long size() {
            return segment.byteSize() / StdVideoVP9SegmentationFlags.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull StdVideoVP9SegmentationFlags at(long index) {
            return new StdVideoVP9SegmentationFlags(segment.asSlice(index * StdVideoVP9SegmentationFlags.BYTES, StdVideoVP9SegmentationFlags.BYTES));
        }

        public StdVideoVP9SegmentationFlags.Ptr at(long index, @NotNull Consumer<@NotNull StdVideoVP9SegmentationFlags> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull StdVideoVP9SegmentationFlags value) {
            MemorySegment s = segment.asSlice(index * StdVideoVP9SegmentationFlags.BYTES, StdVideoVP9SegmentationFlags.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * StdVideoVP9SegmentationFlags.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * StdVideoVP9SegmentationFlags.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * StdVideoVP9SegmentationFlags.BYTES,
                (end - start) * StdVideoVP9SegmentationFlags.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * StdVideoVP9SegmentationFlags.BYTES));
        }

        public StdVideoVP9SegmentationFlags[] toArray() {
            StdVideoVP9SegmentationFlags[] ret = new StdVideoVP9SegmentationFlags[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<StdVideoVP9SegmentationFlags> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<StdVideoVP9SegmentationFlags> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= StdVideoVP9SegmentationFlags.BYTES;
            }

            @Override
            public StdVideoVP9SegmentationFlags next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                StdVideoVP9SegmentationFlags ret = new StdVideoVP9SegmentationFlags(segment.asSlice(0, StdVideoVP9SegmentationFlags.BYTES));
                segment = segment.asSlice(StdVideoVP9SegmentationFlags.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static StdVideoVP9SegmentationFlags allocate(Arena arena) {
        return new StdVideoVP9SegmentationFlags(arena.allocate(LAYOUT));
    }

    public static StdVideoVP9SegmentationFlags.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        return new StdVideoVP9SegmentationFlags.Ptr(segment);
    }

    public static StdVideoVP9SegmentationFlags clone(Arena arena, StdVideoVP9SegmentationFlags src) {
        StdVideoVP9SegmentationFlags ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public boolean segmentation_update_map() {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$segmentation_update_map$reserved, LAYOUT$bitfield$segmentation_update_map$reserved);
        return BitfieldUtil.readBit(s, 0);
    }

    public StdVideoVP9SegmentationFlags segmentation_update_map(boolean value) {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$segmentation_update_map$reserved, LAYOUT$bitfield$segmentation_update_map$reserved);
        BitfieldUtil.writeBit(s, 0, value);
        return this;
    }

    public boolean segmentation_temporal_update() {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$segmentation_update_map$reserved, LAYOUT$bitfield$segmentation_update_map$reserved);
        return BitfieldUtil.readBit(s, 1);
    }

    public StdVideoVP9SegmentationFlags segmentation_temporal_update(boolean value) {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$segmentation_update_map$reserved, LAYOUT$bitfield$segmentation_update_map$reserved);
        BitfieldUtil.writeBit(s, 1, value);
        return this;
    }

    public boolean segmentation_update_data() {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$segmentation_update_map$reserved, LAYOUT$bitfield$segmentation_update_map$reserved);
        return BitfieldUtil.readBit(s, 2);
    }

    public StdVideoVP9SegmentationFlags segmentation_update_data(boolean value) {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$segmentation_update_map$reserved, LAYOUT$bitfield$segmentation_update_map$reserved);
        BitfieldUtil.writeBit(s, 2, value);
        return this;
    }

    public boolean segmentation_abs_or_delta_update() {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$segmentation_update_map$reserved, LAYOUT$bitfield$segmentation_update_map$reserved);
        return BitfieldUtil.readBit(s, 3);
    }

    public StdVideoVP9SegmentationFlags segmentation_abs_or_delta_update(boolean value) {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$segmentation_update_map$reserved, LAYOUT$bitfield$segmentation_update_map$reserved);
        BitfieldUtil.writeBit(s, 3, value);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("bitfield$segmentation_update_map$reserved")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$bitfield$segmentation_update_map$reserved = PathElement.groupElement("segmentation_update_map$reserved");

    public static final OfInt LAYOUT$bitfield$segmentation_update_map$reserved = (OfInt) LAYOUT.select(PATH$bitfield$segmentation_update_map$reserved);


    public static final long OFFSET$bitfield$segmentation_update_map$reserved = LAYOUT.byteOffset(PATH$bitfield$segmentation_update_map$reserved);
}
