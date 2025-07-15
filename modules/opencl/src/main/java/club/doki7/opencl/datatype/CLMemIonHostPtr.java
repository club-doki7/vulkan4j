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

/// Represents a pointer to a <a href="https://registry.khronos.org/OpenCL/sdk/latest/docs/man/html/cl_mem_ion_host_ptr.html">cl_mem_ion_host_ptr</a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct cl_mem_ion_host_ptr {
///     cl_mem_ext_host_ptr extHostPtr; // @link substring="CLMemExtHostPtr" target="CLMemExtHostPtr" @link substring="extHostPtr" target="#extHostPtr"
///     int ionFiledesc; // @link substring="ionFiledesc" target="#ionFiledesc"
///     void* ionHostptr; // @link substring="ionHostptr" target="#ionHostptr"
/// } cl_mem_ion_host_ptr;
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
/// @see <a href="https://registry.khronos.org/OpenCL/sdk/latest/docs/man/html/cl_mem_ion_host_ptr.html">cl_mem_ion_host_ptr</a>
@ValueBasedCandidate
@UnsafeConstructor
public record CLMemIonHostPtr(@NotNull MemorySegment segment) implements ICLMemIonHostPtr {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/OpenCL/sdk/latest/docs/man/html/cl_mem_ion_host_ptr.html">cl_mem_ion_host_ptr</a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link CLMemIonHostPtr}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// ICLMemIonHostPtr to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code CLMemIonHostPtr.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements ICLMemIonHostPtr, Iterable<CLMemIonHostPtr> {
        public long size() {
            return segment.byteSize() / CLMemIonHostPtr.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull CLMemIonHostPtr at(long index) {
            return new CLMemIonHostPtr(segment.asSlice(index * CLMemIonHostPtr.BYTES, CLMemIonHostPtr.BYTES));
        }

        public CLMemIonHostPtr.Ptr at(long index, @NotNull Consumer<@NotNull CLMemIonHostPtr> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull CLMemIonHostPtr value) {
            MemorySegment s = segment.asSlice(index * CLMemIonHostPtr.BYTES, CLMemIonHostPtr.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * CLMemIonHostPtr.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * CLMemIonHostPtr.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * CLMemIonHostPtr.BYTES,
                (end - start) * CLMemIonHostPtr.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * CLMemIonHostPtr.BYTES));
        }

        public CLMemIonHostPtr[] toArray() {
            CLMemIonHostPtr[] ret = new CLMemIonHostPtr[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<CLMemIonHostPtr> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<CLMemIonHostPtr> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= CLMemIonHostPtr.BYTES;
            }

            @Override
            public CLMemIonHostPtr next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                CLMemIonHostPtr ret = new CLMemIonHostPtr(segment.asSlice(0, CLMemIonHostPtr.BYTES));
                segment = segment.asSlice(CLMemIonHostPtr.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static CLMemIonHostPtr allocate(Arena arena) {
        return new CLMemIonHostPtr(arena.allocate(LAYOUT));
    }

    public static CLMemIonHostPtr.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        return new CLMemIonHostPtr.Ptr(segment);
    }

    public static CLMemIonHostPtr clone(Arena arena, CLMemIonHostPtr src) {
        CLMemIonHostPtr ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public @NotNull CLMemExtHostPtr extHostPtr() {
        return new CLMemExtHostPtr(segment.asSlice(OFFSET$extHostPtr, LAYOUT$extHostPtr));
    }

    public CLMemIonHostPtr extHostPtr(@NotNull CLMemExtHostPtr value) {
        MemorySegment.copy(value.segment(), 0, segment, OFFSET$extHostPtr, SIZE$extHostPtr);
        return this;
    }

    public CLMemIonHostPtr extHostPtr(Consumer<@NotNull CLMemExtHostPtr> consumer) {
        consumer.accept(extHostPtr());
        return this;
    }

    public int ionFiledesc() {
        return segment.get(LAYOUT$ionFiledesc, OFFSET$ionFiledesc);
    }

    public CLMemIonHostPtr ionFiledesc(int value) {
        segment.set(LAYOUT$ionFiledesc, OFFSET$ionFiledesc, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment ionHostptr() {
        return segment.get(LAYOUT$ionHostptr, OFFSET$ionHostptr);
    }

    public CLMemIonHostPtr ionHostptr(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$ionHostptr, OFFSET$ionHostptr, value);
        return this;
    }

    public CLMemIonHostPtr ionHostptr(@Nullable IPointer pointer) {
        ionHostptr(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        CLMemExtHostPtr.LAYOUT.withName("extHostPtr"),
        ValueLayout.JAVA_INT.withName("ionFiledesc"),
        ValueLayout.ADDRESS.withName("ionHostptr")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$extHostPtr = PathElement.groupElement("extHostPtr");
    public static final PathElement PATH$ionFiledesc = PathElement.groupElement("ionFiledesc");
    public static final PathElement PATH$ionHostptr = PathElement.groupElement("ionHostptr");

    public static final StructLayout LAYOUT$extHostPtr = (StructLayout) LAYOUT.select(PATH$extHostPtr);
    public static final OfInt LAYOUT$ionFiledesc = (OfInt) LAYOUT.select(PATH$ionFiledesc);
    public static final AddressLayout LAYOUT$ionHostptr = (AddressLayout) LAYOUT.select(PATH$ionHostptr);

    public static final long SIZE$extHostPtr = LAYOUT$extHostPtr.byteSize();
    public static final long SIZE$ionFiledesc = LAYOUT$ionFiledesc.byteSize();
    public static final long SIZE$ionHostptr = LAYOUT$ionHostptr.byteSize();

    public static final long OFFSET$extHostPtr = LAYOUT.byteOffset(PATH$extHostPtr);
    public static final long OFFSET$ionFiledesc = LAYOUT.byteOffset(PATH$ionFiledesc);
    public static final long OFFSET$ionHostptr = LAYOUT.byteOffset(PATH$ionHostptr);
}
