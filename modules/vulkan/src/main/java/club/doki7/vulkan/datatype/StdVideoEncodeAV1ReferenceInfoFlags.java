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

/// Represents a pointer to a {@code StdVideoEncodeAV1ReferenceInfoFlags} structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct StdVideoEncodeAV1ReferenceInfoFlags {
///     uint32_t disable_frame_end_update_cdf : 1; // @link substring="disable_frame_end_update_cdf" target="#disable_frame_end_update_cdf"
///     uint32_t segmentation_enabled : 1; // @link substring="segmentation_enabled" target="#segmentation_enabled"
///     uint32_t reserved : 30;
/// } StdVideoEncodeAV1ReferenceInfoFlags;
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
public record StdVideoEncodeAV1ReferenceInfoFlags(@NotNull MemorySegment segment) implements IStdVideoEncodeAV1ReferenceInfoFlags {
    /// Represents a pointer to / an array of null structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link StdVideoEncodeAV1ReferenceInfoFlags}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IStdVideoEncodeAV1ReferenceInfoFlags to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code StdVideoEncodeAV1ReferenceInfoFlags.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IStdVideoEncodeAV1ReferenceInfoFlags, Iterable<StdVideoEncodeAV1ReferenceInfoFlags> {
        public long size() {
            return segment.byteSize() / StdVideoEncodeAV1ReferenceInfoFlags.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull StdVideoEncodeAV1ReferenceInfoFlags at(long index) {
            return new StdVideoEncodeAV1ReferenceInfoFlags(segment.asSlice(index * StdVideoEncodeAV1ReferenceInfoFlags.BYTES, StdVideoEncodeAV1ReferenceInfoFlags.BYTES));
        }

        public StdVideoEncodeAV1ReferenceInfoFlags.Ptr at(long index, @NotNull Consumer<@NotNull StdVideoEncodeAV1ReferenceInfoFlags> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull StdVideoEncodeAV1ReferenceInfoFlags value) {
            MemorySegment s = segment.asSlice(index * StdVideoEncodeAV1ReferenceInfoFlags.BYTES, StdVideoEncodeAV1ReferenceInfoFlags.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * StdVideoEncodeAV1ReferenceInfoFlags.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * StdVideoEncodeAV1ReferenceInfoFlags.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * StdVideoEncodeAV1ReferenceInfoFlags.BYTES,
                (end - start) * StdVideoEncodeAV1ReferenceInfoFlags.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * StdVideoEncodeAV1ReferenceInfoFlags.BYTES));
        }

        public StdVideoEncodeAV1ReferenceInfoFlags[] toArray() {
            StdVideoEncodeAV1ReferenceInfoFlags[] ret = new StdVideoEncodeAV1ReferenceInfoFlags[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<StdVideoEncodeAV1ReferenceInfoFlags> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<StdVideoEncodeAV1ReferenceInfoFlags> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= StdVideoEncodeAV1ReferenceInfoFlags.BYTES;
            }

            @Override
            public StdVideoEncodeAV1ReferenceInfoFlags next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                StdVideoEncodeAV1ReferenceInfoFlags ret = new StdVideoEncodeAV1ReferenceInfoFlags(segment.asSlice(0, StdVideoEncodeAV1ReferenceInfoFlags.BYTES));
                segment = segment.asSlice(StdVideoEncodeAV1ReferenceInfoFlags.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static StdVideoEncodeAV1ReferenceInfoFlags allocate(Arena arena) {
        return new StdVideoEncodeAV1ReferenceInfoFlags(arena.allocate(LAYOUT));
    }

    public static StdVideoEncodeAV1ReferenceInfoFlags.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        return new StdVideoEncodeAV1ReferenceInfoFlags.Ptr(segment);
    }

    public static StdVideoEncodeAV1ReferenceInfoFlags clone(Arena arena, StdVideoEncodeAV1ReferenceInfoFlags src) {
        StdVideoEncodeAV1ReferenceInfoFlags ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public boolean disable_frame_end_update_cdf() {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$disable_frame_end_update_cdf$reserved, LAYOUT$bitfield$disable_frame_end_update_cdf$reserved);
        return BitfieldUtil.readBit(s, 0);
    }

    public StdVideoEncodeAV1ReferenceInfoFlags disable_frame_end_update_cdf(boolean value) {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$disable_frame_end_update_cdf$reserved, LAYOUT$bitfield$disable_frame_end_update_cdf$reserved);
        BitfieldUtil.writeBit(s, 0, value);
        return this;
    }

    public boolean segmentation_enabled() {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$disable_frame_end_update_cdf$reserved, LAYOUT$bitfield$disable_frame_end_update_cdf$reserved);
        return BitfieldUtil.readBit(s, 1);
    }

    public StdVideoEncodeAV1ReferenceInfoFlags segmentation_enabled(boolean value) {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$disable_frame_end_update_cdf$reserved, LAYOUT$bitfield$disable_frame_end_update_cdf$reserved);
        BitfieldUtil.writeBit(s, 1, value);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("bitfield$disable_frame_end_update_cdf$reserved")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$bitfield$disable_frame_end_update_cdf$reserved = PathElement.groupElement("disable_frame_end_update_cdf$reserved");

    public static final OfInt LAYOUT$bitfield$disable_frame_end_update_cdf$reserved = (OfInt) LAYOUT.select(PATH$bitfield$disable_frame_end_update_cdf$reserved);


    public static final long OFFSET$bitfield$disable_frame_end_update_cdf$reserved = LAYOUT.byteOffset(PATH$bitfield$disable_frame_end_update_cdf$reserved);
}
