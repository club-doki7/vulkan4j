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

/// Represents a pointer to a {@code stb_vorbis_comment} structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct stb_vorbis_comment {
///     char* vendor; // @link substring="vendor" target="#vendor"
///     int commentListLength; // @link substring="commentListLength" target="#commentListLength"
///     char** commentList; // @link substring="commentList" target="#commentList"
/// } stb_vorbis_comment;
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
public record STB_VorbisComment(@NotNull MemorySegment segment) implements ISTB_VorbisComment {
    /// Represents a pointer to / an array of null structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link STB_VorbisComment}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// ISTB_VorbisComment to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code STB_VorbisComment.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements ISTB_VorbisComment, Iterable<STB_VorbisComment> {
        public long size() {
            return segment.byteSize() / STB_VorbisComment.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull STB_VorbisComment at(long index) {
            return new STB_VorbisComment(segment.asSlice(index * STB_VorbisComment.BYTES, STB_VorbisComment.BYTES));
        }

        public STB_VorbisComment.Ptr at(long index, @NotNull Consumer<@NotNull STB_VorbisComment> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull STB_VorbisComment value) {
            MemorySegment s = segment.asSlice(index * STB_VorbisComment.BYTES, STB_VorbisComment.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * STB_VorbisComment.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * STB_VorbisComment.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * STB_VorbisComment.BYTES,
                (end - start) * STB_VorbisComment.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * STB_VorbisComment.BYTES));
        }

        public STB_VorbisComment[] toArray() {
            STB_VorbisComment[] ret = new STB_VorbisComment[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<STB_VorbisComment> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<STB_VorbisComment> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= STB_VorbisComment.BYTES;
            }

            @Override
            public STB_VorbisComment next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                STB_VorbisComment ret = new STB_VorbisComment(segment.asSlice(0, STB_VorbisComment.BYTES));
                segment = segment.asSlice(STB_VorbisComment.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static STB_VorbisComment allocate(Arena arena) {
        return new STB_VorbisComment(arena.allocate(LAYOUT));
    }

    public static STB_VorbisComment.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        return new STB_VorbisComment.Ptr(segment);
    }

    public static STB_VorbisComment clone(Arena arena, STB_VorbisComment src) {
        STB_VorbisComment ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    /// Note: the returned {@link BytePtr} does not have correct
    /// {@link BytePtr#size} property. It's up to user to track the size of the buffer,
    /// and use {@link BytePtr#reinterpret} to set the size before actually reading from or
    /// writing to the buffer.
    public @Nullable BytePtr vendor() {
        MemorySegment s = vendorRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new BytePtr(s);
    }

    public STB_VorbisComment vendor(@Nullable BytePtr value) {
        MemorySegment s = value == null ? MemorySegment.NULL : value.segment();
        vendorRaw(s);
        return this;
    }

    public @Pointer(comment="int8_t*") @NotNull MemorySegment vendorRaw() {
        return segment.get(LAYOUT$vendor, OFFSET$vendor);
    }

    public void vendorRaw(@Pointer(comment="int8_t*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$vendor, OFFSET$vendor, value);
    }

    public int commentListLength() {
        return segment.get(LAYOUT$commentListLength, OFFSET$commentListLength);
    }

    public STB_VorbisComment commentListLength(int value) {
        segment.set(LAYOUT$commentListLength, OFFSET$commentListLength, value);
        return this;
    }

    /// Note: the returned {@link PointerPtr} does not have correct {@link PointerPtr#size} property. It's up
    /// to user to track the size of the buffer, and use {@link PointerPtr#reinterpret} to set the size before
    /// actually reading from or writing to the buffer.
    public @Nullable PointerPtr commentList() {
        MemorySegment s = commentListRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new PointerPtr(s);
    }

    public STB_VorbisComment commentList(@Nullable PointerPtr value) {
        MemorySegment s = value == null ? MemorySegment.NULL : value.segment();
        commentListRaw(s);
        return this;
    }

    public @Pointer(comment="void**") @NotNull MemorySegment commentListRaw() {
        return segment.get(LAYOUT$commentList, OFFSET$commentList);
    }

    public void commentListRaw(@Pointer(comment="void**") @NotNull MemorySegment value) {
        segment.set(LAYOUT$commentList, OFFSET$commentList, value);
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_BYTE).withName("vendor"),
        ValueLayout.JAVA_INT.withName("commentListLength"),
        ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_BYTE)).withName("commentList")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$vendor = PathElement.groupElement("vendor");
    public static final PathElement PATH$commentListLength = PathElement.groupElement("commentListLength");
    public static final PathElement PATH$commentList = PathElement.groupElement("commentList");

    public static final AddressLayout LAYOUT$vendor = (AddressLayout) LAYOUT.select(PATH$vendor);
    public static final OfInt LAYOUT$commentListLength = (OfInt) LAYOUT.select(PATH$commentListLength);
    public static final AddressLayout LAYOUT$commentList = (AddressLayout) LAYOUT.select(PATH$commentList);

    public static final long SIZE$vendor = LAYOUT$vendor.byteSize();
    public static final long SIZE$commentListLength = LAYOUT$commentListLength.byteSize();
    public static final long SIZE$commentList = LAYOUT$commentList.byteSize();

    public static final long OFFSET$vendor = LAYOUT.byteOffset(PATH$vendor);
    public static final long OFFSET$commentListLength = LAYOUT.byteOffset(PATH$commentListLength);
    public static final long OFFSET$commentList = LAYOUT.byteOffset(PATH$commentList);
}
