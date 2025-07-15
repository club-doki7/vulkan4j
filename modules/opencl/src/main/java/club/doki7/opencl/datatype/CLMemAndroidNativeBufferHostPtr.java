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

/// Represents a pointer to a <a href="https://registry.khronos.org/OpenCL/sdk/latest/docs/man/html/cl_mem_android_native_buffer_host_ptr.html">cl_mem_android_native_buffer_host_ptr</a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct cl_mem_android_native_buffer_host_ptr {
///     cl_mem_ext_host_ptr extHostPtr; // @link substring="CLMemExtHostPtr" target="CLMemExtHostPtr" @link substring="extHostPtr" target="#extHostPtr"
///     void* anbPtr; // @link substring="anbPtr" target="#anbPtr"
/// } cl_mem_android_native_buffer_host_ptr;
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
/// @see <a href="https://registry.khronos.org/OpenCL/sdk/latest/docs/man/html/cl_mem_android_native_buffer_host_ptr.html">cl_mem_android_native_buffer_host_ptr</a>
@ValueBasedCandidate
@UnsafeConstructor
public record CLMemAndroidNativeBufferHostPtr(@NotNull MemorySegment segment) implements ICLMemAndroidNativeBufferHostPtr {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/OpenCL/sdk/latest/docs/man/html/cl_mem_android_native_buffer_host_ptr.html">cl_mem_android_native_buffer_host_ptr</a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link CLMemAndroidNativeBufferHostPtr}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// ICLMemAndroidNativeBufferHostPtr to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code CLMemAndroidNativeBufferHostPtr.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements ICLMemAndroidNativeBufferHostPtr, Iterable<CLMemAndroidNativeBufferHostPtr> {
        public long size() {
            return segment.byteSize() / CLMemAndroidNativeBufferHostPtr.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull CLMemAndroidNativeBufferHostPtr at(long index) {
            return new CLMemAndroidNativeBufferHostPtr(segment.asSlice(index * CLMemAndroidNativeBufferHostPtr.BYTES, CLMemAndroidNativeBufferHostPtr.BYTES));
        }

        public CLMemAndroidNativeBufferHostPtr.Ptr at(long index, @NotNull Consumer<@NotNull CLMemAndroidNativeBufferHostPtr> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull CLMemAndroidNativeBufferHostPtr value) {
            MemorySegment s = segment.asSlice(index * CLMemAndroidNativeBufferHostPtr.BYTES, CLMemAndroidNativeBufferHostPtr.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * CLMemAndroidNativeBufferHostPtr.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * CLMemAndroidNativeBufferHostPtr.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * CLMemAndroidNativeBufferHostPtr.BYTES,
                (end - start) * CLMemAndroidNativeBufferHostPtr.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * CLMemAndroidNativeBufferHostPtr.BYTES));
        }

        public CLMemAndroidNativeBufferHostPtr[] toArray() {
            CLMemAndroidNativeBufferHostPtr[] ret = new CLMemAndroidNativeBufferHostPtr[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<CLMemAndroidNativeBufferHostPtr> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<CLMemAndroidNativeBufferHostPtr> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= CLMemAndroidNativeBufferHostPtr.BYTES;
            }

            @Override
            public CLMemAndroidNativeBufferHostPtr next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                CLMemAndroidNativeBufferHostPtr ret = new CLMemAndroidNativeBufferHostPtr(segment.asSlice(0, CLMemAndroidNativeBufferHostPtr.BYTES));
                segment = segment.asSlice(CLMemAndroidNativeBufferHostPtr.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static CLMemAndroidNativeBufferHostPtr allocate(Arena arena) {
        return new CLMemAndroidNativeBufferHostPtr(arena.allocate(LAYOUT));
    }

    public static CLMemAndroidNativeBufferHostPtr.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        return new CLMemAndroidNativeBufferHostPtr.Ptr(segment);
    }

    public static CLMemAndroidNativeBufferHostPtr clone(Arena arena, CLMemAndroidNativeBufferHostPtr src) {
        CLMemAndroidNativeBufferHostPtr ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public @NotNull CLMemExtHostPtr extHostPtr() {
        return new CLMemExtHostPtr(segment.asSlice(OFFSET$extHostPtr, LAYOUT$extHostPtr));
    }

    public CLMemAndroidNativeBufferHostPtr extHostPtr(@NotNull CLMemExtHostPtr value) {
        MemorySegment.copy(value.segment(), 0, segment, OFFSET$extHostPtr, SIZE$extHostPtr);
        return this;
    }

    public CLMemAndroidNativeBufferHostPtr extHostPtr(Consumer<@NotNull CLMemExtHostPtr> consumer) {
        consumer.accept(extHostPtr());
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment anbPtr() {
        return segment.get(LAYOUT$anbPtr, OFFSET$anbPtr);
    }

    public CLMemAndroidNativeBufferHostPtr anbPtr(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$anbPtr, OFFSET$anbPtr, value);
        return this;
    }

    public CLMemAndroidNativeBufferHostPtr anbPtr(@Nullable IPointer pointer) {
        anbPtr(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        CLMemExtHostPtr.LAYOUT.withName("extHostPtr"),
        ValueLayout.ADDRESS.withName("anbPtr")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$extHostPtr = PathElement.groupElement("extHostPtr");
    public static final PathElement PATH$anbPtr = PathElement.groupElement("anbPtr");

    public static final StructLayout LAYOUT$extHostPtr = (StructLayout) LAYOUT.select(PATH$extHostPtr);
    public static final AddressLayout LAYOUT$anbPtr = (AddressLayout) LAYOUT.select(PATH$anbPtr);

    public static final long SIZE$extHostPtr = LAYOUT$extHostPtr.byteSize();
    public static final long SIZE$anbPtr = LAYOUT$anbPtr.byteSize();

    public static final long OFFSET$extHostPtr = LAYOUT.byteOffset(PATH$extHostPtr);
    public static final long OFFSET$anbPtr = LAYOUT.byteOffset(PATH$anbPtr);
}
