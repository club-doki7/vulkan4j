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

/// Represents a pointer to a {@code StdVideoVP9ColorConfigFlags} structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct StdVideoVP9ColorConfigFlags {
///     uint32_t color_range : 1; // @link substring="color_range" target="#color_range"
///     uint32_t reserved : 31;
/// } StdVideoVP9ColorConfigFlags;
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
public record StdVideoVP9ColorConfigFlags(@NotNull MemorySegment segment) implements IStdVideoVP9ColorConfigFlags {
    /// Represents a pointer to / an array of null structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link StdVideoVP9ColorConfigFlags}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IStdVideoVP9ColorConfigFlags to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code StdVideoVP9ColorConfigFlags.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IStdVideoVP9ColorConfigFlags, Iterable<StdVideoVP9ColorConfigFlags> {
        public long size() {
            return segment.byteSize() / StdVideoVP9ColorConfigFlags.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull StdVideoVP9ColorConfigFlags at(long index) {
            return new StdVideoVP9ColorConfigFlags(segment.asSlice(index * StdVideoVP9ColorConfigFlags.BYTES, StdVideoVP9ColorConfigFlags.BYTES));
        }

        public StdVideoVP9ColorConfigFlags.Ptr at(long index, @NotNull Consumer<@NotNull StdVideoVP9ColorConfigFlags> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull StdVideoVP9ColorConfigFlags value) {
            MemorySegment s = segment.asSlice(index * StdVideoVP9ColorConfigFlags.BYTES, StdVideoVP9ColorConfigFlags.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * StdVideoVP9ColorConfigFlags.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * StdVideoVP9ColorConfigFlags.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * StdVideoVP9ColorConfigFlags.BYTES,
                (end - start) * StdVideoVP9ColorConfigFlags.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * StdVideoVP9ColorConfigFlags.BYTES));
        }

        public StdVideoVP9ColorConfigFlags[] toArray() {
            StdVideoVP9ColorConfigFlags[] ret = new StdVideoVP9ColorConfigFlags[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<StdVideoVP9ColorConfigFlags> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<StdVideoVP9ColorConfigFlags> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= StdVideoVP9ColorConfigFlags.BYTES;
            }

            @Override
            public StdVideoVP9ColorConfigFlags next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                StdVideoVP9ColorConfigFlags ret = new StdVideoVP9ColorConfigFlags(segment.asSlice(0, StdVideoVP9ColorConfigFlags.BYTES));
                segment = segment.asSlice(StdVideoVP9ColorConfigFlags.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static StdVideoVP9ColorConfigFlags allocate(Arena arena) {
        return new StdVideoVP9ColorConfigFlags(arena.allocate(LAYOUT));
    }

    public static StdVideoVP9ColorConfigFlags.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        return new StdVideoVP9ColorConfigFlags.Ptr(segment);
    }

    public static StdVideoVP9ColorConfigFlags clone(Arena arena, StdVideoVP9ColorConfigFlags src) {
        StdVideoVP9ColorConfigFlags ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public boolean color_range() {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$color_range$reserved, LAYOUT$bitfield$color_range$reserved);
        return BitfieldUtil.readBit(s, 0);
    }

    public StdVideoVP9ColorConfigFlags color_range(boolean value) {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$color_range$reserved, LAYOUT$bitfield$color_range$reserved);
        BitfieldUtil.writeBit(s, 0, value);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("bitfield$color_range$reserved")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$bitfield$color_range$reserved = PathElement.groupElement("color_range$reserved");

    public static final OfInt LAYOUT$bitfield$color_range$reserved = (OfInt) LAYOUT.select(PATH$bitfield$color_range$reserved);


    public static final long OFFSET$bitfield$color_range$reserved = LAYOUT.byteOffset(PATH$bitfield$color_range$reserved);
}
