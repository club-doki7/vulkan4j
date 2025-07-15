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

/// Represents a pointer to a <a href="https://registry.khronos.org/OpenCL/sdk/latest/docs/man/html/cl_mem_ext_host_ptr.html">cl_mem_ext_host_ptr</a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct cl_mem_ext_host_ptr {
///     cl_uint allocationType; // @link substring="allocationType" target="#allocationType"
///     cl_uint hostCachePolicy; // @link substring="hostCachePolicy" target="#hostCachePolicy"
/// } cl_mem_ext_host_ptr;
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
/// @see <a href="https://registry.khronos.org/OpenCL/sdk/latest/docs/man/html/cl_mem_ext_host_ptr.html">cl_mem_ext_host_ptr</a>
@ValueBasedCandidate
@UnsafeConstructor
public record CLMemExtHostPtr(@NotNull MemorySegment segment) implements ICLMemExtHostPtr {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/OpenCL/sdk/latest/docs/man/html/cl_mem_ext_host_ptr.html">cl_mem_ext_host_ptr</a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link CLMemExtHostPtr}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// ICLMemExtHostPtr to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code CLMemExtHostPtr.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements ICLMemExtHostPtr, Iterable<CLMemExtHostPtr> {
        public long size() {
            return segment.byteSize() / CLMemExtHostPtr.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull CLMemExtHostPtr at(long index) {
            return new CLMemExtHostPtr(segment.asSlice(index * CLMemExtHostPtr.BYTES, CLMemExtHostPtr.BYTES));
        }

        public CLMemExtHostPtr.Ptr at(long index, @NotNull Consumer<@NotNull CLMemExtHostPtr> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull CLMemExtHostPtr value) {
            MemorySegment s = segment.asSlice(index * CLMemExtHostPtr.BYTES, CLMemExtHostPtr.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * CLMemExtHostPtr.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * CLMemExtHostPtr.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * CLMemExtHostPtr.BYTES,
                (end - start) * CLMemExtHostPtr.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * CLMemExtHostPtr.BYTES));
        }

        public CLMemExtHostPtr[] toArray() {
            CLMemExtHostPtr[] ret = new CLMemExtHostPtr[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<CLMemExtHostPtr> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<CLMemExtHostPtr> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= CLMemExtHostPtr.BYTES;
            }

            @Override
            public CLMemExtHostPtr next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                CLMemExtHostPtr ret = new CLMemExtHostPtr(segment.asSlice(0, CLMemExtHostPtr.BYTES));
                segment = segment.asSlice(CLMemExtHostPtr.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static CLMemExtHostPtr allocate(Arena arena) {
        return new CLMemExtHostPtr(arena.allocate(LAYOUT));
    }

    public static CLMemExtHostPtr.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        return new CLMemExtHostPtr.Ptr(segment);
    }

    public static CLMemExtHostPtr clone(Arena arena, CLMemExtHostPtr src) {
        CLMemExtHostPtr ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public @NativeType("cl_uint") @Unsigned int allocationType() {
        return segment.get(LAYOUT$allocationType, OFFSET$allocationType);
    }

    public CLMemExtHostPtr allocationType(@NativeType("cl_uint") @Unsigned int value) {
        segment.set(LAYOUT$allocationType, OFFSET$allocationType, value);
        return this;
    }

    public @NativeType("cl_uint") @Unsigned int hostCachePolicy() {
        return segment.get(LAYOUT$hostCachePolicy, OFFSET$hostCachePolicy);
    }

    public CLMemExtHostPtr hostCachePolicy(@NativeType("cl_uint") @Unsigned int value) {
        segment.set(LAYOUT$hostCachePolicy, OFFSET$hostCachePolicy, value);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("allocationType"),
        ValueLayout.JAVA_INT.withName("hostCachePolicy")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$allocationType = PathElement.groupElement("allocationType");
    public static final PathElement PATH$hostCachePolicy = PathElement.groupElement("hostCachePolicy");

    public static final OfInt LAYOUT$allocationType = (OfInt) LAYOUT.select(PATH$allocationType);
    public static final OfInt LAYOUT$hostCachePolicy = (OfInt) LAYOUT.select(PATH$hostCachePolicy);

    public static final long SIZE$allocationType = LAYOUT$allocationType.byteSize();
    public static final long SIZE$hostCachePolicy = LAYOUT$hostCachePolicy.byteSize();

    public static final long OFFSET$allocationType = LAYOUT.byteOffset(PATH$allocationType);
    public static final long OFFSET$hostCachePolicy = LAYOUT.byteOffset(PATH$hostCachePolicy);
}
