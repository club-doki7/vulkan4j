package club.doki7.stb.vorbis.datatype;

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
import club.doki7.stb.vorbis.handle.*;
import club.doki7.stb.vorbis.enumtype.*;

/// Represents a pointer to a {@code stb_vorbis_alloc} structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct stb_vorbis_alloc {
///     char* allocBuffer; // @link substring="allocBuffer" target="#allocBuffer"
///     int allocBufferLengthInBytes; // @link substring="allocBufferLengthInBytes" target="#allocBufferLengthInBytes"
/// } stb_vorbis_alloc;
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
public record STB_VorbisAlloc(@NotNull MemorySegment segment) implements ISTB_VorbisAlloc {
    /// Represents a pointer to / an array of null structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link STB_VorbisAlloc}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// ISTB_VorbisAlloc to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code STB_VorbisAlloc.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements ISTB_VorbisAlloc, Iterable<STB_VorbisAlloc> {
        public long size() {
            return segment.byteSize() / STB_VorbisAlloc.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull STB_VorbisAlloc at(long index) {
            return new STB_VorbisAlloc(segment.asSlice(index * STB_VorbisAlloc.BYTES, STB_VorbisAlloc.BYTES));
        }

        public STB_VorbisAlloc.Ptr at(long index, @NotNull Consumer<@NotNull STB_VorbisAlloc> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull STB_VorbisAlloc value) {
            MemorySegment s = segment.asSlice(index * STB_VorbisAlloc.BYTES, STB_VorbisAlloc.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * STB_VorbisAlloc.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * STB_VorbisAlloc.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * STB_VorbisAlloc.BYTES,
                (end - start) * STB_VorbisAlloc.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * STB_VorbisAlloc.BYTES));
        }

        public STB_VorbisAlloc[] toArray() {
            STB_VorbisAlloc[] ret = new STB_VorbisAlloc[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<STB_VorbisAlloc> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<STB_VorbisAlloc> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= STB_VorbisAlloc.BYTES;
            }

            @Override
            public STB_VorbisAlloc next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                STB_VorbisAlloc ret = new STB_VorbisAlloc(segment.asSlice(0, STB_VorbisAlloc.BYTES));
                segment = segment.asSlice(STB_VorbisAlloc.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static STB_VorbisAlloc allocate(Arena arena) {
        return new STB_VorbisAlloc(arena.allocate(LAYOUT));
    }

    public static STB_VorbisAlloc.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        return new STB_VorbisAlloc.Ptr(segment);
    }

    public static STB_VorbisAlloc clone(Arena arena, STB_VorbisAlloc src) {
        STB_VorbisAlloc ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    /// Note: the returned {@link BytePtr} does not have correct
    /// {@link BytePtr#size} property. It's up to user to track the size of the buffer,
    /// and use {@link BytePtr#reinterpret} to set the size before actually reading from or
    /// writing to the buffer.
    public @Nullable BytePtr allocBuffer() {
        MemorySegment s = allocBufferRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new BytePtr(s);
    }

    public STB_VorbisAlloc allocBuffer(@Nullable BytePtr value) {
        MemorySegment s = value == null ? MemorySegment.NULL : value.segment();
        allocBufferRaw(s);
        return this;
    }

    public @Pointer(comment="int8_t*") @NotNull MemorySegment allocBufferRaw() {
        return segment.get(LAYOUT$allocBuffer, OFFSET$allocBuffer);
    }

    public void allocBufferRaw(@Pointer(comment="int8_t*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$allocBuffer, OFFSET$allocBuffer, value);
    }

    public int allocBufferLengthInBytes() {
        return segment.get(LAYOUT$allocBufferLengthInBytes, OFFSET$allocBufferLengthInBytes);
    }

    public STB_VorbisAlloc allocBufferLengthInBytes(int value) {
        segment.set(LAYOUT$allocBufferLengthInBytes, OFFSET$allocBufferLengthInBytes, value);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_BYTE).withName("allocBuffer"),
        ValueLayout.JAVA_INT.withName("allocBufferLengthInBytes")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$allocBuffer = PathElement.groupElement("allocBuffer");
    public static final PathElement PATH$allocBufferLengthInBytes = PathElement.groupElement("allocBufferLengthInBytes");

    public static final AddressLayout LAYOUT$allocBuffer = (AddressLayout) LAYOUT.select(PATH$allocBuffer);
    public static final OfInt LAYOUT$allocBufferLengthInBytes = (OfInt) LAYOUT.select(PATH$allocBufferLengthInBytes);

    public static final long SIZE$allocBuffer = LAYOUT$allocBuffer.byteSize();
    public static final long SIZE$allocBufferLengthInBytes = LAYOUT$allocBufferLengthInBytes.byteSize();

    public static final long OFFSET$allocBuffer = LAYOUT.byteOffset(PATH$allocBuffer);
    public static final long OFFSET$allocBufferLengthInBytes = LAYOUT.byteOffset(PATH$allocBufferLengthInBytes);
}
