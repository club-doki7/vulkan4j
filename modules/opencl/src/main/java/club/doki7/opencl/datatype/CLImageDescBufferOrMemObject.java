package club.doki7.opencl.datatype;

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
import club.doki7.opencl.handle.*;
import static club.doki7.opencl.CLConstants.*;
import club.doki7.opencl.CLFunctionTypes.*;

/// Represents a pointer to a <a href="https://registry.khronos.org/OpenCL/sdk/latest/docs/man/html/cl_image_desc_buffer_or_mem_object.html">cl_image_desc_buffer_or_mem_object</a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef union cl_image_desc_buffer_or_mem_object {
///     cl_mem buffer; // @link substring="CLMem" target="CLMem" @link substring="buffer" target="#buffer"
///     cl_mem memObject; // @link substring="CLMem" target="CLMem" @link substring="memObject" target="#memObject"
/// } cl_image_desc_buffer_or_mem_object;
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
/// @see <a href="https://registry.khronos.org/OpenCL/sdk/latest/docs/man/html/cl_image_desc_buffer_or_mem_object.html">cl_image_desc_buffer_or_mem_object</a>
@ValueBasedCandidate
@UnsafeConstructor
public record CLImageDescBufferOrMemObject(@NotNull MemorySegment segment) implements ICLImageDescBufferOrMemObject {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/OpenCL/sdk/latest/docs/man/html/cl_image_desc_buffer_or_mem_object.html">cl_image_desc_buffer_or_mem_object</a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link CLImageDescBufferOrMemObject}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// ICLImageDescBufferOrMemObject to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code CLImageDescBufferOrMemObject.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements ICLImageDescBufferOrMemObject, Iterable<CLImageDescBufferOrMemObject> {
        public long size() {
            return segment.byteSize() / CLImageDescBufferOrMemObject.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull CLImageDescBufferOrMemObject at(long index) {
            return new CLImageDescBufferOrMemObject(segment.asSlice(index * CLImageDescBufferOrMemObject.BYTES, CLImageDescBufferOrMemObject.BYTES));
        }

        public CLImageDescBufferOrMemObject.Ptr at(long index, @NotNull Consumer<@NotNull CLImageDescBufferOrMemObject> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull CLImageDescBufferOrMemObject value) {
            MemorySegment s = segment.asSlice(index * CLImageDescBufferOrMemObject.BYTES, CLImageDescBufferOrMemObject.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * CLImageDescBufferOrMemObject.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * CLImageDescBufferOrMemObject.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * CLImageDescBufferOrMemObject.BYTES,
                (end - start) * CLImageDescBufferOrMemObject.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * CLImageDescBufferOrMemObject.BYTES));
        }

        public CLImageDescBufferOrMemObject[] toArray() {
            CLImageDescBufferOrMemObject[] ret = new CLImageDescBufferOrMemObject[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<CLImageDescBufferOrMemObject> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<CLImageDescBufferOrMemObject> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= CLImageDescBufferOrMemObject.BYTES;
            }

            @Override
            public CLImageDescBufferOrMemObject next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                CLImageDescBufferOrMemObject ret = new CLImageDescBufferOrMemObject(segment.asSlice(0, CLImageDescBufferOrMemObject.BYTES));
                segment = segment.asSlice(CLImageDescBufferOrMemObject.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static CLImageDescBufferOrMemObject allocate(Arena arena) {
        return new CLImageDescBufferOrMemObject(arena.allocate(LAYOUT));
    }

    public static CLImageDescBufferOrMemObject.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        return new CLImageDescBufferOrMemObject.Ptr(segment);
    }

    public static CLImageDescBufferOrMemObject clone(Arena arena, CLImageDescBufferOrMemObject src) {
        CLImageDescBufferOrMemObject ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public @Nullable CLMem buffer() {
        MemorySegment s = segment.asSlice(OFFSET$buffer, SIZE$buffer);
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new CLMem(s);
    }

    public CLImageDescBufferOrMemObject buffer(@Nullable CLMem value) {
        segment.set(LAYOUT$buffer, OFFSET$buffer, value != null ? value.segment() : MemorySegment.NULL);
        return this;
    }

    public @Nullable CLMem memObject() {
        MemorySegment s = segment.asSlice(OFFSET$memObject, SIZE$memObject);
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new CLMem(s);
    }

    public CLImageDescBufferOrMemObject memObject(@Nullable CLMem value) {
        segment.set(LAYOUT$memObject, OFFSET$memObject, value != null ? value.segment() : MemorySegment.NULL);
        return this;
    }

    public static final UnionLayout LAYOUT = NativeLayout.unionLayout(
        ValueLayout.ADDRESS.withName("buffer"),
        ValueLayout.ADDRESS.withName("memObject")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$buffer = PathElement.groupElement("buffer");
    public static final PathElement PATH$memObject = PathElement.groupElement("memObject");

    public static final AddressLayout LAYOUT$buffer = (AddressLayout) LAYOUT.select(PATH$buffer);
    public static final AddressLayout LAYOUT$memObject = (AddressLayout) LAYOUT.select(PATH$memObject);

    public static final long SIZE$buffer = LAYOUT$buffer.byteSize();
    public static final long SIZE$memObject = LAYOUT$memObject.byteSize();

    public static final long OFFSET$buffer = LAYOUT.byteOffset(PATH$buffer);
    public static final long OFFSET$memObject = LAYOUT.byteOffset(PATH$memObject);
}
