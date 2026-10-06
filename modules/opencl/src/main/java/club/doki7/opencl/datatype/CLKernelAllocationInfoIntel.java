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

/// Represents a pointer to a <a href="https://registry.khronos.org/OpenCL/sdk/latest/docs/man/html/cl_kernel_allocation_info_intel.html">cl_kernel_allocation_info_intel</a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct cl_kernel_allocation_info_intel {
///     void* base; // @link substring="base" target="#base"
///     size_t size; // @link substring="size" target="#size"
///     cl_unified_shared_memory_type_intel type; // @link substring="type" target="#type"
///     cl_int argIndex; // @link substring="argIndex" target="#argIndex"
/// } cl_kernel_allocation_info_intel;
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
/// @see <a href="https://registry.khronos.org/OpenCL/sdk/latest/docs/man/html/cl_kernel_allocation_info_intel.html">cl_kernel_allocation_info_intel</a>
@ValueBasedCandidate
@UnsafeConstructor
public record CLKernelAllocationInfoIntel(@NotNull MemorySegment segment) implements ICLKernelAllocationInfoIntel {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/OpenCL/sdk/latest/docs/man/html/cl_kernel_allocation_info_intel.html">cl_kernel_allocation_info_intel</a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link CLKernelAllocationInfoIntel}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// ICLKernelAllocationInfoIntel to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code CLKernelAllocationInfoIntel.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements ICLKernelAllocationInfoIntel, Iterable<CLKernelAllocationInfoIntel> {
        public long size() {
            return segment.byteSize() / CLKernelAllocationInfoIntel.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull CLKernelAllocationInfoIntel at(long index) {
            return new CLKernelAllocationInfoIntel(segment.asSlice(index * CLKernelAllocationInfoIntel.BYTES, CLKernelAllocationInfoIntel.BYTES));
        }

        public CLKernelAllocationInfoIntel.Ptr at(long index, @NotNull Consumer<@NotNull CLKernelAllocationInfoIntel> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull CLKernelAllocationInfoIntel value) {
            MemorySegment s = segment.asSlice(index * CLKernelAllocationInfoIntel.BYTES, CLKernelAllocationInfoIntel.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * CLKernelAllocationInfoIntel.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * CLKernelAllocationInfoIntel.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * CLKernelAllocationInfoIntel.BYTES,
                (end - start) * CLKernelAllocationInfoIntel.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * CLKernelAllocationInfoIntel.BYTES));
        }

        public CLKernelAllocationInfoIntel[] toArray() {
            CLKernelAllocationInfoIntel[] ret = new CLKernelAllocationInfoIntel[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<CLKernelAllocationInfoIntel> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<CLKernelAllocationInfoIntel> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= CLKernelAllocationInfoIntel.BYTES;
            }

            @Override
            public CLKernelAllocationInfoIntel next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                CLKernelAllocationInfoIntel ret = new CLKernelAllocationInfoIntel(segment.asSlice(0, CLKernelAllocationInfoIntel.BYTES));
                segment = segment.asSlice(CLKernelAllocationInfoIntel.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static CLKernelAllocationInfoIntel allocate(Arena arena) {
        return new CLKernelAllocationInfoIntel(arena.allocate(LAYOUT));
    }

    public static CLKernelAllocationInfoIntel.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        return new CLKernelAllocationInfoIntel.Ptr(segment);
    }

    public static CLKernelAllocationInfoIntel clone(Arena arena, CLKernelAllocationInfoIntel src) {
        CLKernelAllocationInfoIntel ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment base() {
        return segment.get(LAYOUT$base, OFFSET$base);
    }

    public CLKernelAllocationInfoIntel base(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$base, OFFSET$base, value);
        return this;
    }

    public CLKernelAllocationInfoIntel base(@Nullable IPointer pointer) {
        base(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @Unsigned long size() {
        return NativeLayout.readCSizeT(segment, OFFSET$size);
    }

    public CLKernelAllocationInfoIntel size(@Unsigned long value) {
        NativeLayout.writeCSizeT(segment, OFFSET$size, value);
        return this;
    }

    public @NativeType("cl_unified_shared_memory_type_intel") @Unsigned int type() {
        return segment.get(LAYOUT$type, OFFSET$type);
    }

    public CLKernelAllocationInfoIntel type(@NativeType("cl_unified_shared_memory_type_intel") @Unsigned int value) {
        segment.set(LAYOUT$type, OFFSET$type, value);
        return this;
    }

    public @NativeType("cl_int") int argIndex() {
        return segment.get(LAYOUT$argIndex, OFFSET$argIndex);
    }

    public CLKernelAllocationInfoIntel argIndex(@NativeType("cl_int") int value) {
        segment.set(LAYOUT$argIndex, OFFSET$argIndex, value);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.ADDRESS.withName("base"),
        NativeLayout.C_SIZE_T.withName("size"),
        ValueLayout.JAVA_INT.withName("type"),
        ValueLayout.JAVA_INT.withName("argIndex")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$base = PathElement.groupElement("base");
    public static final PathElement PATH$size = PathElement.groupElement("size");
    public static final PathElement PATH$type = PathElement.groupElement("type");
    public static final PathElement PATH$argIndex = PathElement.groupElement("argIndex");

    public static final AddressLayout LAYOUT$base = (AddressLayout) LAYOUT.select(PATH$base);
    public static final OfInt LAYOUT$type = (OfInt) LAYOUT.select(PATH$type);
    public static final OfInt LAYOUT$argIndex = (OfInt) LAYOUT.select(PATH$argIndex);

    public static final long SIZE$base = LAYOUT$base.byteSize();
    public static final long SIZE$size = NativeLayout.C_SIZE_T.byteSize();
    public static final long SIZE$type = LAYOUT$type.byteSize();
    public static final long SIZE$argIndex = LAYOUT$argIndex.byteSize();

    public static final long OFFSET$base = LAYOUT.byteOffset(PATH$base);
    public static final long OFFSET$size = LAYOUT.byteOffset(PATH$size);
    public static final long OFFSET$type = LAYOUT.byteOffset(PATH$type);
    public static final long OFFSET$argIndex = LAYOUT.byteOffset(PATH$argIndex);
}
