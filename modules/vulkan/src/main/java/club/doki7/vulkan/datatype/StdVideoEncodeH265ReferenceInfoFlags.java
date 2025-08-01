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

/// Represents a pointer to a {@code StdVideoEncodeH265ReferenceInfoFlags} structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct StdVideoEncodeH265ReferenceInfoFlags {
///     uint32_t used_for_long_term_reference : 1; // @link substring="used_for_long_term_reference" target="#used_for_long_term_reference"
///     uint32_t unused_for_reference : 1; // @link substring="unused_for_reference" target="#unused_for_reference"
///     uint32_t reserved : 30;
/// } StdVideoEncodeH265ReferenceInfoFlags;
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
public record StdVideoEncodeH265ReferenceInfoFlags(@NotNull MemorySegment segment) implements IStdVideoEncodeH265ReferenceInfoFlags {
    /// Represents a pointer to / an array of null structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link StdVideoEncodeH265ReferenceInfoFlags}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IStdVideoEncodeH265ReferenceInfoFlags to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code StdVideoEncodeH265ReferenceInfoFlags.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IStdVideoEncodeH265ReferenceInfoFlags, Iterable<StdVideoEncodeH265ReferenceInfoFlags> {
        public long size() {
            return segment.byteSize() / StdVideoEncodeH265ReferenceInfoFlags.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull StdVideoEncodeH265ReferenceInfoFlags at(long index) {
            return new StdVideoEncodeH265ReferenceInfoFlags(segment.asSlice(index * StdVideoEncodeH265ReferenceInfoFlags.BYTES, StdVideoEncodeH265ReferenceInfoFlags.BYTES));
        }

        public StdVideoEncodeH265ReferenceInfoFlags.Ptr at(long index, @NotNull Consumer<@NotNull StdVideoEncodeH265ReferenceInfoFlags> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull StdVideoEncodeH265ReferenceInfoFlags value) {
            MemorySegment s = segment.asSlice(index * StdVideoEncodeH265ReferenceInfoFlags.BYTES, StdVideoEncodeH265ReferenceInfoFlags.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * StdVideoEncodeH265ReferenceInfoFlags.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * StdVideoEncodeH265ReferenceInfoFlags.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * StdVideoEncodeH265ReferenceInfoFlags.BYTES,
                (end - start) * StdVideoEncodeH265ReferenceInfoFlags.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * StdVideoEncodeH265ReferenceInfoFlags.BYTES));
        }

        public StdVideoEncodeH265ReferenceInfoFlags[] toArray() {
            StdVideoEncodeH265ReferenceInfoFlags[] ret = new StdVideoEncodeH265ReferenceInfoFlags[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<StdVideoEncodeH265ReferenceInfoFlags> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<StdVideoEncodeH265ReferenceInfoFlags> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= StdVideoEncodeH265ReferenceInfoFlags.BYTES;
            }

            @Override
            public StdVideoEncodeH265ReferenceInfoFlags next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                StdVideoEncodeH265ReferenceInfoFlags ret = new StdVideoEncodeH265ReferenceInfoFlags(segment.asSlice(0, StdVideoEncodeH265ReferenceInfoFlags.BYTES));
                segment = segment.asSlice(StdVideoEncodeH265ReferenceInfoFlags.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static StdVideoEncodeH265ReferenceInfoFlags allocate(Arena arena) {
        return new StdVideoEncodeH265ReferenceInfoFlags(arena.allocate(LAYOUT));
    }

    public static StdVideoEncodeH265ReferenceInfoFlags.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        return new StdVideoEncodeH265ReferenceInfoFlags.Ptr(segment);
    }

    public static StdVideoEncodeH265ReferenceInfoFlags clone(Arena arena, StdVideoEncodeH265ReferenceInfoFlags src) {
        StdVideoEncodeH265ReferenceInfoFlags ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public boolean used_for_long_term_reference() {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$used_for_long_term_reference$reserved, LAYOUT$bitfield$used_for_long_term_reference$reserved);
        return BitfieldUtil.readBit(s, 0);
    }

    public StdVideoEncodeH265ReferenceInfoFlags used_for_long_term_reference(boolean value) {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$used_for_long_term_reference$reserved, LAYOUT$bitfield$used_for_long_term_reference$reserved);
        BitfieldUtil.writeBit(s, 0, value);
        return this;
    }

    public boolean unused_for_reference() {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$used_for_long_term_reference$reserved, LAYOUT$bitfield$used_for_long_term_reference$reserved);
        return BitfieldUtil.readBit(s, 1);
    }

    public StdVideoEncodeH265ReferenceInfoFlags unused_for_reference(boolean value) {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$used_for_long_term_reference$reserved, LAYOUT$bitfield$used_for_long_term_reference$reserved);
        BitfieldUtil.writeBit(s, 1, value);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("bitfield$used_for_long_term_reference$reserved")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$bitfield$used_for_long_term_reference$reserved = PathElement.groupElement("used_for_long_term_reference$reserved");

    public static final OfInt LAYOUT$bitfield$used_for_long_term_reference$reserved = (OfInt) LAYOUT.select(PATH$bitfield$used_for_long_term_reference$reserved);


    public static final long OFFSET$bitfield$used_for_long_term_reference$reserved = LAYOUT.byteOffset(PATH$bitfield$used_for_long_term_reference$reserved);
}
