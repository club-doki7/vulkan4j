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

/// Represents a pointer to a {@code StdVideoAV1TileInfo} structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct StdVideoAV1TileInfo {
///     StdVideoAV1TileInfoFlags flags; // @link substring="StdVideoAV1TileInfoFlags" target="StdVideoAV1TileInfoFlags" @link substring="flags" target="#flags"
///     uint8_t TileCols; // @link substring="TileCols" target="#TileCols"
///     uint8_t TileRows; // @link substring="TileRows" target="#TileRows"
///     uint16_t context_update_tile_id; // @link substring="context_update_tile_id" target="#context_update_tile_id"
///     uint8_t tile_size_bytes_minus_1; // @link substring="tile_size_bytes_minus_1" target="#tile_size_bytes_minus_1"
///     uint8_t[7] reserved1;
///     uint16_t const* pMiColStarts; // @link substring="pMiColStarts" target="#pMiColStarts"
///     uint16_t const* pMiRowStarts; // @link substring="pMiRowStarts" target="#pMiRowStarts"
///     uint16_t const* pWidthInSbsMinus1; // @link substring="pWidthInSbsMinus1" target="#pWidthInSbsMinus1"
///     uint16_t const* pHeightInSbsMinus1; // @link substring="pHeightInSbsMinus1" target="#pHeightInSbsMinus1"
/// } StdVideoAV1TileInfo;
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
public record StdVideoAV1TileInfo(@NotNull MemorySegment segment) implements IStdVideoAV1TileInfo {
    /// Represents a pointer to / an array of null structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link StdVideoAV1TileInfo}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IStdVideoAV1TileInfo to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code StdVideoAV1TileInfo.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IStdVideoAV1TileInfo, Iterable<StdVideoAV1TileInfo> {
        public long size() {
            return segment.byteSize() / StdVideoAV1TileInfo.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull StdVideoAV1TileInfo at(long index) {
            return new StdVideoAV1TileInfo(segment.asSlice(index * StdVideoAV1TileInfo.BYTES, StdVideoAV1TileInfo.BYTES));
        }

        public StdVideoAV1TileInfo.Ptr at(long index, @NotNull Consumer<@NotNull StdVideoAV1TileInfo> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull StdVideoAV1TileInfo value) {
            MemorySegment s = segment.asSlice(index * StdVideoAV1TileInfo.BYTES, StdVideoAV1TileInfo.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * StdVideoAV1TileInfo.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * StdVideoAV1TileInfo.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * StdVideoAV1TileInfo.BYTES,
                (end - start) * StdVideoAV1TileInfo.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * StdVideoAV1TileInfo.BYTES));
        }

        public StdVideoAV1TileInfo[] toArray() {
            StdVideoAV1TileInfo[] ret = new StdVideoAV1TileInfo[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<StdVideoAV1TileInfo> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<StdVideoAV1TileInfo> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= StdVideoAV1TileInfo.BYTES;
            }

            @Override
            public StdVideoAV1TileInfo next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                StdVideoAV1TileInfo ret = new StdVideoAV1TileInfo(segment.asSlice(0, StdVideoAV1TileInfo.BYTES));
                segment = segment.asSlice(StdVideoAV1TileInfo.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static StdVideoAV1TileInfo allocate(Arena arena) {
        return new StdVideoAV1TileInfo(arena.allocate(LAYOUT));
    }

    public static StdVideoAV1TileInfo.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        return new StdVideoAV1TileInfo.Ptr(segment);
    }

    public static StdVideoAV1TileInfo clone(Arena arena, StdVideoAV1TileInfo src) {
        StdVideoAV1TileInfo ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public @NotNull StdVideoAV1TileInfoFlags flags() {
        return new StdVideoAV1TileInfoFlags(segment.asSlice(OFFSET$flags, LAYOUT$flags));
    }

    public StdVideoAV1TileInfo flags(@NotNull StdVideoAV1TileInfoFlags value) {
        MemorySegment.copy(value.segment(), 0, segment, OFFSET$flags, SIZE$flags);
        return this;
    }

    public StdVideoAV1TileInfo flags(Consumer<@NotNull StdVideoAV1TileInfoFlags> consumer) {
        consumer.accept(flags());
        return this;
    }

    public @Unsigned byte TileCols() {
        return segment.get(LAYOUT$TileCols, OFFSET$TileCols);
    }

    public StdVideoAV1TileInfo TileCols(@Unsigned byte value) {
        segment.set(LAYOUT$TileCols, OFFSET$TileCols, value);
        return this;
    }

    public @Unsigned byte TileRows() {
        return segment.get(LAYOUT$TileRows, OFFSET$TileRows);
    }

    public StdVideoAV1TileInfo TileRows(@Unsigned byte value) {
        segment.set(LAYOUT$TileRows, OFFSET$TileRows, value);
        return this;
    }

    public @Unsigned short context_update_tile_id() {
        return segment.get(LAYOUT$context_update_tile_id, OFFSET$context_update_tile_id);
    }

    public StdVideoAV1TileInfo context_update_tile_id(@Unsigned short value) {
        segment.set(LAYOUT$context_update_tile_id, OFFSET$context_update_tile_id, value);
        return this;
    }

    public @Unsigned byte tile_size_bytes_minus_1() {
        return segment.get(LAYOUT$tile_size_bytes_minus_1, OFFSET$tile_size_bytes_minus_1);
    }

    public StdVideoAV1TileInfo tile_size_bytes_minus_1(@Unsigned byte value) {
        segment.set(LAYOUT$tile_size_bytes_minus_1, OFFSET$tile_size_bytes_minus_1, value);
        return this;
    }


    /// Note: the returned {@link ShortPtr} does not have correct
    /// {@link ShortPtr#size} property. It's up to user to track the size of the buffer,
    /// and use {@link ShortPtr#reinterpret} to set the size before actually reading from or
    /// writing to the buffer.
    public @Nullable @Unsigned ShortPtr pMiColStarts() {
        MemorySegment s = pMiColStartsRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new ShortPtr(s);
    }

    public StdVideoAV1TileInfo pMiColStarts(@Nullable @Unsigned ShortPtr value) {
        MemorySegment s = value == null ? MemorySegment.NULL : value.segment();
        pMiColStartsRaw(s);
        return this;
    }

    public @Pointer(comment="uint16_t*") @NotNull MemorySegment pMiColStartsRaw() {
        return segment.get(LAYOUT$pMiColStarts, OFFSET$pMiColStarts);
    }

    public void pMiColStartsRaw(@Pointer(comment="uint16_t*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pMiColStarts, OFFSET$pMiColStarts, value);
    }

    /// Note: the returned {@link ShortPtr} does not have correct
    /// {@link ShortPtr#size} property. It's up to user to track the size of the buffer,
    /// and use {@link ShortPtr#reinterpret} to set the size before actually reading from or
    /// writing to the buffer.
    public @Nullable @Unsigned ShortPtr pMiRowStarts() {
        MemorySegment s = pMiRowStartsRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new ShortPtr(s);
    }

    public StdVideoAV1TileInfo pMiRowStarts(@Nullable @Unsigned ShortPtr value) {
        MemorySegment s = value == null ? MemorySegment.NULL : value.segment();
        pMiRowStartsRaw(s);
        return this;
    }

    public @Pointer(comment="uint16_t*") @NotNull MemorySegment pMiRowStartsRaw() {
        return segment.get(LAYOUT$pMiRowStarts, OFFSET$pMiRowStarts);
    }

    public void pMiRowStartsRaw(@Pointer(comment="uint16_t*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pMiRowStarts, OFFSET$pMiRowStarts, value);
    }

    /// Note: the returned {@link ShortPtr} does not have correct
    /// {@link ShortPtr#size} property. It's up to user to track the size of the buffer,
    /// and use {@link ShortPtr#reinterpret} to set the size before actually reading from or
    /// writing to the buffer.
    public @Nullable @Unsigned ShortPtr pWidthInSbsMinus1() {
        MemorySegment s = pWidthInSbsMinus1Raw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new ShortPtr(s);
    }

    public StdVideoAV1TileInfo pWidthInSbsMinus1(@Nullable @Unsigned ShortPtr value) {
        MemorySegment s = value == null ? MemorySegment.NULL : value.segment();
        pWidthInSbsMinus1Raw(s);
        return this;
    }

    public @Pointer(comment="uint16_t*") @NotNull MemorySegment pWidthInSbsMinus1Raw() {
        return segment.get(LAYOUT$pWidthInSbsMinus1, OFFSET$pWidthInSbsMinus1);
    }

    public void pWidthInSbsMinus1Raw(@Pointer(comment="uint16_t*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pWidthInSbsMinus1, OFFSET$pWidthInSbsMinus1, value);
    }

    /// Note: the returned {@link ShortPtr} does not have correct
    /// {@link ShortPtr#size} property. It's up to user to track the size of the buffer,
    /// and use {@link ShortPtr#reinterpret} to set the size before actually reading from or
    /// writing to the buffer.
    public @Nullable @Unsigned ShortPtr pHeightInSbsMinus1() {
        MemorySegment s = pHeightInSbsMinus1Raw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new ShortPtr(s);
    }

    public StdVideoAV1TileInfo pHeightInSbsMinus1(@Nullable @Unsigned ShortPtr value) {
        MemorySegment s = value == null ? MemorySegment.NULL : value.segment();
        pHeightInSbsMinus1Raw(s);
        return this;
    }

    public @Pointer(comment="uint16_t*") @NotNull MemorySegment pHeightInSbsMinus1Raw() {
        return segment.get(LAYOUT$pHeightInSbsMinus1, OFFSET$pHeightInSbsMinus1);
    }

    public void pHeightInSbsMinus1Raw(@Pointer(comment="uint16_t*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pHeightInSbsMinus1, OFFSET$pHeightInSbsMinus1, value);
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        StdVideoAV1TileInfoFlags.LAYOUT.withName("flags"),
        ValueLayout.JAVA_BYTE.withName("TileCols"),
        ValueLayout.JAVA_BYTE.withName("TileRows"),
        ValueLayout.JAVA_SHORT.withName("context_update_tile_id"),
        ValueLayout.JAVA_BYTE.withName("tile_size_bytes_minus_1"),
        MemoryLayout.sequenceLayout(7, ValueLayout.JAVA_BYTE).withName("reserved1"),
        ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_SHORT).withName("pMiColStarts"),
        ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_SHORT).withName("pMiRowStarts"),
        ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_SHORT).withName("pWidthInSbsMinus1"),
        ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_SHORT).withName("pHeightInSbsMinus1")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$flags = PathElement.groupElement("flags");
    public static final PathElement PATH$TileCols = PathElement.groupElement("TileCols");
    public static final PathElement PATH$TileRows = PathElement.groupElement("TileRows");
    public static final PathElement PATH$context_update_tile_id = PathElement.groupElement("context_update_tile_id");
    public static final PathElement PATH$tile_size_bytes_minus_1 = PathElement.groupElement("tile_size_bytes_minus_1");
    public static final PathElement PATH$pMiColStarts = PathElement.groupElement("pMiColStarts");
    public static final PathElement PATH$pMiRowStarts = PathElement.groupElement("pMiRowStarts");
    public static final PathElement PATH$pWidthInSbsMinus1 = PathElement.groupElement("pWidthInSbsMinus1");
    public static final PathElement PATH$pHeightInSbsMinus1 = PathElement.groupElement("pHeightInSbsMinus1");

    public static final StructLayout LAYOUT$flags = (StructLayout) LAYOUT.select(PATH$flags);
    public static final OfByte LAYOUT$TileCols = (OfByte) LAYOUT.select(PATH$TileCols);
    public static final OfByte LAYOUT$TileRows = (OfByte) LAYOUT.select(PATH$TileRows);
    public static final OfShort LAYOUT$context_update_tile_id = (OfShort) LAYOUT.select(PATH$context_update_tile_id);
    public static final OfByte LAYOUT$tile_size_bytes_minus_1 = (OfByte) LAYOUT.select(PATH$tile_size_bytes_minus_1);
    public static final AddressLayout LAYOUT$pMiColStarts = (AddressLayout) LAYOUT.select(PATH$pMiColStarts);
    public static final AddressLayout LAYOUT$pMiRowStarts = (AddressLayout) LAYOUT.select(PATH$pMiRowStarts);
    public static final AddressLayout LAYOUT$pWidthInSbsMinus1 = (AddressLayout) LAYOUT.select(PATH$pWidthInSbsMinus1);
    public static final AddressLayout LAYOUT$pHeightInSbsMinus1 = (AddressLayout) LAYOUT.select(PATH$pHeightInSbsMinus1);

    public static final long SIZE$flags = LAYOUT$flags.byteSize();
    public static final long SIZE$TileCols = LAYOUT$TileCols.byteSize();
    public static final long SIZE$TileRows = LAYOUT$TileRows.byteSize();
    public static final long SIZE$context_update_tile_id = LAYOUT$context_update_tile_id.byteSize();
    public static final long SIZE$tile_size_bytes_minus_1 = LAYOUT$tile_size_bytes_minus_1.byteSize();
    public static final long SIZE$pMiColStarts = LAYOUT$pMiColStarts.byteSize();
    public static final long SIZE$pMiRowStarts = LAYOUT$pMiRowStarts.byteSize();
    public static final long SIZE$pWidthInSbsMinus1 = LAYOUT$pWidthInSbsMinus1.byteSize();
    public static final long SIZE$pHeightInSbsMinus1 = LAYOUT$pHeightInSbsMinus1.byteSize();

    public static final long OFFSET$flags = LAYOUT.byteOffset(PATH$flags);
    public static final long OFFSET$TileCols = LAYOUT.byteOffset(PATH$TileCols);
    public static final long OFFSET$TileRows = LAYOUT.byteOffset(PATH$TileRows);
    public static final long OFFSET$context_update_tile_id = LAYOUT.byteOffset(PATH$context_update_tile_id);
    public static final long OFFSET$tile_size_bytes_minus_1 = LAYOUT.byteOffset(PATH$tile_size_bytes_minus_1);
    public static final long OFFSET$pMiColStarts = LAYOUT.byteOffset(PATH$pMiColStarts);
    public static final long OFFSET$pMiRowStarts = LAYOUT.byteOffset(PATH$pMiRowStarts);
    public static final long OFFSET$pWidthInSbsMinus1 = LAYOUT.byteOffset(PATH$pWidthInSbsMinus1);
    public static final long OFFSET$pHeightInSbsMinus1 = LAYOUT.byteOffset(PATH$pHeightInSbsMinus1);
}
