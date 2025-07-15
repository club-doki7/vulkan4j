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

/// Represents a pointer to a <a href="https://registry.khronos.org/OpenCL/sdk/latest/docs/man/html/cl_dx9_surface_info_khr.html">cl_dx9_surface_info_khr</a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct cl_dx9_surface_info_khr {
///     IDirect3DSurface9* resource; // @link substring="resource" target="#resource"
///     HANDLE sharedHandle; // @link substring="sharedHandle" target="#sharedHandle"
/// } cl_dx9_surface_info_khr;
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
/// @see <a href="https://registry.khronos.org/OpenCL/sdk/latest/docs/man/html/cl_dx9_surface_info_khr.html">cl_dx9_surface_info_khr</a>
@ValueBasedCandidate
@UnsafeConstructor
public record CLDx9SurfaceInfoKhr(@NotNull MemorySegment segment) implements ICLDx9SurfaceInfoKhr {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/OpenCL/sdk/latest/docs/man/html/cl_dx9_surface_info_khr.html">cl_dx9_surface_info_khr</a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link CLDx9SurfaceInfoKhr}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// ICLDx9SurfaceInfoKhr to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code CLDx9SurfaceInfoKhr.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements ICLDx9SurfaceInfoKhr, Iterable<CLDx9SurfaceInfoKhr> {
        public long size() {
            return segment.byteSize() / CLDx9SurfaceInfoKhr.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull CLDx9SurfaceInfoKhr at(long index) {
            return new CLDx9SurfaceInfoKhr(segment.asSlice(index * CLDx9SurfaceInfoKhr.BYTES, CLDx9SurfaceInfoKhr.BYTES));
        }

        public CLDx9SurfaceInfoKhr.Ptr at(long index, @NotNull Consumer<@NotNull CLDx9SurfaceInfoKhr> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull CLDx9SurfaceInfoKhr value) {
            MemorySegment s = segment.asSlice(index * CLDx9SurfaceInfoKhr.BYTES, CLDx9SurfaceInfoKhr.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * CLDx9SurfaceInfoKhr.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * CLDx9SurfaceInfoKhr.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * CLDx9SurfaceInfoKhr.BYTES,
                (end - start) * CLDx9SurfaceInfoKhr.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * CLDx9SurfaceInfoKhr.BYTES));
        }

        public CLDx9SurfaceInfoKhr[] toArray() {
            CLDx9SurfaceInfoKhr[] ret = new CLDx9SurfaceInfoKhr[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<CLDx9SurfaceInfoKhr> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<CLDx9SurfaceInfoKhr> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= CLDx9SurfaceInfoKhr.BYTES;
            }

            @Override
            public CLDx9SurfaceInfoKhr next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                CLDx9SurfaceInfoKhr ret = new CLDx9SurfaceInfoKhr(segment.asSlice(0, CLDx9SurfaceInfoKhr.BYTES));
                segment = segment.asSlice(CLDx9SurfaceInfoKhr.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static CLDx9SurfaceInfoKhr allocate(Arena arena) {
        return new CLDx9SurfaceInfoKhr(arena.allocate(LAYOUT));
    }

    public static CLDx9SurfaceInfoKhr.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        return new CLDx9SurfaceInfoKhr.Ptr(segment);
    }

    public static CLDx9SurfaceInfoKhr clone(Arena arena, CLDx9SurfaceInfoKhr src) {
        CLDx9SurfaceInfoKhr ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    /// Note: the returned {@link PointerPtr} does not have correct {@link PointerPtr#size} property. It's up
    /// to user to track the size of the buffer, and use {@link PointerPtr#reinterpret} to set the size before
    /// actually reading from or writing to the buffer.
    public @Nullable PointerPtr resource() {
        MemorySegment s = resourceRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new PointerPtr(s);
    }

    public CLDx9SurfaceInfoKhr resource(@Nullable PointerPtr value) {
        MemorySegment s = value == null ? MemorySegment.NULL : value.segment();
        resourceRaw(s);
        return this;
    }

    public @Pointer(comment="IDirect3DSurface9*") @NotNull MemorySegment resourceRaw() {
        return segment.get(LAYOUT$resource, OFFSET$resource);
    }

    public void resourceRaw(@Pointer(comment="IDirect3DSurface9*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$resource, OFFSET$resource, value);
    }

    public @Pointer(comment="HANDLE") @NotNull MemorySegment sharedHandle() {
        return segment.get(LAYOUT$sharedHandle, OFFSET$sharedHandle);
    }

    public CLDx9SurfaceInfoKhr sharedHandle(@Pointer(comment="HANDLE") @NotNull MemorySegment value) {
        segment.set(LAYOUT$sharedHandle, OFFSET$sharedHandle, value);
        return this;
    }

    public CLDx9SurfaceInfoKhr sharedHandle(@Nullable IPointer pointer) {
        sharedHandle(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS).withName("resource"),
        ValueLayout.ADDRESS.withName("sharedHandle")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$resource = PathElement.groupElement("resource");
    public static final PathElement PATH$sharedHandle = PathElement.groupElement("sharedHandle");

    public static final AddressLayout LAYOUT$resource = (AddressLayout) LAYOUT.select(PATH$resource);
    public static final AddressLayout LAYOUT$sharedHandle = (AddressLayout) LAYOUT.select(PATH$sharedHandle);

    public static final long SIZE$resource = LAYOUT$resource.byteSize();
    public static final long SIZE$sharedHandle = LAYOUT$sharedHandle.byteSize();

    public static final long OFFSET$resource = LAYOUT.byteOffset(PATH$resource);
    public static final long OFFSET$sharedHandle = LAYOUT.byteOffset(PATH$sharedHandle);
}
