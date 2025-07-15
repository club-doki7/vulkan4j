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

/// Represents a pointer to a <a href="https://registry.khronos.org/OpenCL/sdk/latest/docs/man/html/cl_buffer_region.html">cl_buffer_region</a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct cl_buffer_region {
///     size_t origin; // @link substring="origin" target="#origin"
///     size_t size; // @link substring="size" target="#size"
/// } cl_buffer_region;
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
/// @see <a href="https://registry.khronos.org/OpenCL/sdk/latest/docs/man/html/cl_buffer_region.html">cl_buffer_region</a>
@ValueBasedCandidate
@UnsafeConstructor
public record CLBufferRegion(@NotNull MemorySegment segment) implements ICLBufferRegion {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/OpenCL/sdk/latest/docs/man/html/cl_buffer_region.html">cl_buffer_region</a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link CLBufferRegion}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// ICLBufferRegion to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code CLBufferRegion.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements ICLBufferRegion, Iterable<CLBufferRegion> {
        public long size() {
            return segment.byteSize() / CLBufferRegion.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull CLBufferRegion at(long index) {
            return new CLBufferRegion(segment.asSlice(index * CLBufferRegion.BYTES, CLBufferRegion.BYTES));
        }

        public CLBufferRegion.Ptr at(long index, @NotNull Consumer<@NotNull CLBufferRegion> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull CLBufferRegion value) {
            MemorySegment s = segment.asSlice(index * CLBufferRegion.BYTES, CLBufferRegion.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * CLBufferRegion.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * CLBufferRegion.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * CLBufferRegion.BYTES,
                (end - start) * CLBufferRegion.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * CLBufferRegion.BYTES));
        }

        public CLBufferRegion[] toArray() {
            CLBufferRegion[] ret = new CLBufferRegion[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<CLBufferRegion> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<CLBufferRegion> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= CLBufferRegion.BYTES;
            }

            @Override
            public CLBufferRegion next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                CLBufferRegion ret = new CLBufferRegion(segment.asSlice(0, CLBufferRegion.BYTES));
                segment = segment.asSlice(CLBufferRegion.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static CLBufferRegion allocate(Arena arena) {
        return new CLBufferRegion(arena.allocate(LAYOUT));
    }

    public static CLBufferRegion.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        return new CLBufferRegion.Ptr(segment);
    }

    public static CLBufferRegion clone(Arena arena, CLBufferRegion src) {
        CLBufferRegion ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public @Unsigned long origin() {
        return NativeLayout.readCSizeT(segment, OFFSET$origin);
    }

    public CLBufferRegion origin(@Unsigned long value) {
        NativeLayout.writeCSizeT(segment, OFFSET$origin, value);
        return this;
    }

    public @Unsigned long size() {
        return NativeLayout.readCSizeT(segment, OFFSET$size);
    }

    public CLBufferRegion size(@Unsigned long value) {
        NativeLayout.writeCSizeT(segment, OFFSET$size, value);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        NativeLayout.C_SIZE_T.withName("origin"),
        NativeLayout.C_SIZE_T.withName("size")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$origin = PathElement.groupElement("origin");
    public static final PathElement PATH$size = PathElement.groupElement("size");


    public static final long SIZE$origin = NativeLayout.C_SIZE_T.byteSize();
    public static final long SIZE$size = NativeLayout.C_SIZE_T.byteSize();

    public static final long OFFSET$origin = LAYOUT.byteOffset(PATH$origin);
    public static final long OFFSET$size = LAYOUT.byteOffset(PATH$size);
}
