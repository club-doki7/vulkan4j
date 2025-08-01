package club.doki7.openxr.datatype;

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
import club.doki7.openxr.bitmask.*;
import club.doki7.openxr.handle.*;
import club.doki7.openxr.enumtype.*;
import static club.doki7.openxr.XRConstants.*;
import club.doki7.openxr.XRFunctionTypes.*;
import club.doki7.vulkan.bitmask.*;
import club.doki7.vulkan.datatype.*;
import club.doki7.vulkan.enumtype.*;
import club.doki7.vulkan.handle.*;

/// Represents a pointer to a <a href="https://registry.khronos.org/OpenXR/specs/1.1/man/html/MLCoordinateFrameUID.html"><code>MLCoordinateFrameUID</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct MLCoordinateFrameUID {
///     uint64_t[2] data; // @link substring="data" target="#data"
/// } MLCoordinateFrameUID;
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
///
/// @see <a href="https://registry.khronos.org/OpenXR/specs/1.1/man/html/MLCoordinateFrameUID.html"><code>MLCoordinateFrameUID</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record MLCoordinateFrameUID(@NotNull MemorySegment segment) implements IMLCoordinateFrameUID {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/OpenXR/specs/1.1/man/html/MLCoordinateFrameUID.html"><code>MLCoordinateFrameUID</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link MLCoordinateFrameUID}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IMLCoordinateFrameUID to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code MLCoordinateFrameUID.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IMLCoordinateFrameUID, Iterable<MLCoordinateFrameUID> {
        public long size() {
            return segment.byteSize() / MLCoordinateFrameUID.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull MLCoordinateFrameUID at(long index) {
            return new MLCoordinateFrameUID(segment.asSlice(index * MLCoordinateFrameUID.BYTES, MLCoordinateFrameUID.BYTES));
        }

        public MLCoordinateFrameUID.Ptr at(long index, @NotNull Consumer<@NotNull MLCoordinateFrameUID> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull MLCoordinateFrameUID value) {
            MemorySegment s = segment.asSlice(index * MLCoordinateFrameUID.BYTES, MLCoordinateFrameUID.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * MLCoordinateFrameUID.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * MLCoordinateFrameUID.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * MLCoordinateFrameUID.BYTES,
                (end - start) * MLCoordinateFrameUID.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * MLCoordinateFrameUID.BYTES));
        }

        public MLCoordinateFrameUID[] toArray() {
            MLCoordinateFrameUID[] ret = new MLCoordinateFrameUID[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<MLCoordinateFrameUID> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<MLCoordinateFrameUID> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= MLCoordinateFrameUID.BYTES;
            }

            @Override
            public MLCoordinateFrameUID next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                MLCoordinateFrameUID ret = new MLCoordinateFrameUID(segment.asSlice(0, MLCoordinateFrameUID.BYTES));
                segment = segment.asSlice(MLCoordinateFrameUID.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static MLCoordinateFrameUID allocate(Arena arena) {
        return new MLCoordinateFrameUID(arena.allocate(LAYOUT));
    }

    public static MLCoordinateFrameUID.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        return new MLCoordinateFrameUID.Ptr(segment);
    }

    public static MLCoordinateFrameUID clone(Arena arena, MLCoordinateFrameUID src) {
        MLCoordinateFrameUID ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public @Unsigned LongPtr data() {
        return new LongPtr(dataRaw());
    }

    public MLCoordinateFrameUID data(@NotNull Consumer<LongPtr> consumer) {
        @Unsigned LongPtr ptr = data();
        consumer.accept(ptr);
        return this;
    }

    public MLCoordinateFrameUID data(@Unsigned LongPtr value) {
        MemorySegment s = dataRaw();
        s.copyFrom(value.segment());
        return this;
    }

    public @NotNull MemorySegment dataRaw() {
        return segment.asSlice(OFFSET$data, SIZE$data);
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        MemoryLayout.sequenceLayout(2, ValueLayout.JAVA_LONG).withName("data")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$data = PathElement.groupElement("data");

    public static final SequenceLayout LAYOUT$data = (SequenceLayout) LAYOUT.select(PATH$data);

    public static final long SIZE$data = LAYOUT$data.byteSize();

    public static final long OFFSET$data = LAYOUT.byteOffset(PATH$data);
}
