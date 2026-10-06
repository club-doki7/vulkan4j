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

/// Represents a pointer to a {@code StdVideoAV1TileInfoFlags} structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct StdVideoAV1TileInfoFlags {
///     uint32_t uniform_tile_spacing_flag : 1; // @link substring="uniform_tile_spacing_flag" target="#uniform_tile_spacing_flag"
///     uint32_t reserved : 31;
/// } StdVideoAV1TileInfoFlags;
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
public record StdVideoAV1TileInfoFlags(@NotNull MemorySegment segment) implements IStdVideoAV1TileInfoFlags {
    /// Represents a pointer to / an array of null structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link StdVideoAV1TileInfoFlags}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IStdVideoAV1TileInfoFlags to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code StdVideoAV1TileInfoFlags.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IStdVideoAV1TileInfoFlags, Iterable<StdVideoAV1TileInfoFlags> {
        public long size() {
            return segment.byteSize() / StdVideoAV1TileInfoFlags.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull StdVideoAV1TileInfoFlags at(long index) {
            return new StdVideoAV1TileInfoFlags(segment.asSlice(index * StdVideoAV1TileInfoFlags.BYTES, StdVideoAV1TileInfoFlags.BYTES));
        }

        public StdVideoAV1TileInfoFlags.Ptr at(long index, @NotNull Consumer<@NotNull StdVideoAV1TileInfoFlags> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull StdVideoAV1TileInfoFlags value) {
            MemorySegment s = segment.asSlice(index * StdVideoAV1TileInfoFlags.BYTES, StdVideoAV1TileInfoFlags.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * StdVideoAV1TileInfoFlags.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * StdVideoAV1TileInfoFlags.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * StdVideoAV1TileInfoFlags.BYTES,
                (end - start) * StdVideoAV1TileInfoFlags.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * StdVideoAV1TileInfoFlags.BYTES));
        }

        public StdVideoAV1TileInfoFlags[] toArray() {
            StdVideoAV1TileInfoFlags[] ret = new StdVideoAV1TileInfoFlags[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<StdVideoAV1TileInfoFlags> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<StdVideoAV1TileInfoFlags> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= StdVideoAV1TileInfoFlags.BYTES;
            }

            @Override
            public StdVideoAV1TileInfoFlags next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                StdVideoAV1TileInfoFlags ret = new StdVideoAV1TileInfoFlags(segment.asSlice(0, StdVideoAV1TileInfoFlags.BYTES));
                segment = segment.asSlice(StdVideoAV1TileInfoFlags.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static StdVideoAV1TileInfoFlags allocate(Arena arena) {
        return new StdVideoAV1TileInfoFlags(arena.allocate(LAYOUT));
    }

    public static StdVideoAV1TileInfoFlags.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        return new StdVideoAV1TileInfoFlags.Ptr(segment);
    }

    public static StdVideoAV1TileInfoFlags clone(Arena arena, StdVideoAV1TileInfoFlags src) {
        StdVideoAV1TileInfoFlags ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public boolean uniform_tile_spacing_flag() {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$uniform_tile_spacing_flag$reserved, LAYOUT$bitfield$uniform_tile_spacing_flag$reserved);
        return BitfieldUtil.readBit(s, 0);
    }

    public StdVideoAV1TileInfoFlags uniform_tile_spacing_flag(boolean value) {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$uniform_tile_spacing_flag$reserved, LAYOUT$bitfield$uniform_tile_spacing_flag$reserved);
        BitfieldUtil.writeBit(s, 0, value);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("bitfield$uniform_tile_spacing_flag$reserved")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$bitfield$uniform_tile_spacing_flag$reserved = PathElement.groupElement("uniform_tile_spacing_flag$reserved");

    public static final OfInt LAYOUT$bitfield$uniform_tile_spacing_flag$reserved = (OfInt) LAYOUT.select(PATH$bitfield$uniform_tile_spacing_flag$reserved);


    public static final long OFFSET$bitfield$uniform_tile_spacing_flag$reserved = LAYOUT.byteOffset(PATH$bitfield$uniform_tile_spacing_flag$reserved);
}
