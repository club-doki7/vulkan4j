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

/// Represents a pointer to a <a href="https://registry.khronos.org/OpenCL/sdk/latest/docs/man/html/cl_mutable_dispatch_exec_info_khr.html">cl_mutable_dispatch_exec_info_khr</a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct cl_mutable_dispatch_exec_info_khr {
///     cl_uint paramName; // @link substring="paramName" target="#paramName"
///     size_t paramValueSize; // @link substring="paramValueSize" target="#paramValueSize"
///     void const* paramValue; // @link substring="paramValue" target="#paramValue"
/// } cl_mutable_dispatch_exec_info_khr;
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
/// @see <a href="https://registry.khronos.org/OpenCL/sdk/latest/docs/man/html/cl_mutable_dispatch_exec_info_khr.html">cl_mutable_dispatch_exec_info_khr</a>
@ValueBasedCandidate
@UnsafeConstructor
public record CLMutableDispatchExecInfoKhr(@NotNull MemorySegment segment) implements ICLMutableDispatchExecInfoKhr {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/OpenCL/sdk/latest/docs/man/html/cl_mutable_dispatch_exec_info_khr.html">cl_mutable_dispatch_exec_info_khr</a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link CLMutableDispatchExecInfoKhr}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// ICLMutableDispatchExecInfoKhr to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code CLMutableDispatchExecInfoKhr.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements ICLMutableDispatchExecInfoKhr, Iterable<CLMutableDispatchExecInfoKhr> {
        public long size() {
            return segment.byteSize() / CLMutableDispatchExecInfoKhr.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull CLMutableDispatchExecInfoKhr at(long index) {
            return new CLMutableDispatchExecInfoKhr(segment.asSlice(index * CLMutableDispatchExecInfoKhr.BYTES, CLMutableDispatchExecInfoKhr.BYTES));
        }

        public CLMutableDispatchExecInfoKhr.Ptr at(long index, @NotNull Consumer<@NotNull CLMutableDispatchExecInfoKhr> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull CLMutableDispatchExecInfoKhr value) {
            MemorySegment s = segment.asSlice(index * CLMutableDispatchExecInfoKhr.BYTES, CLMutableDispatchExecInfoKhr.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * CLMutableDispatchExecInfoKhr.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * CLMutableDispatchExecInfoKhr.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * CLMutableDispatchExecInfoKhr.BYTES,
                (end - start) * CLMutableDispatchExecInfoKhr.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * CLMutableDispatchExecInfoKhr.BYTES));
        }

        public CLMutableDispatchExecInfoKhr[] toArray() {
            CLMutableDispatchExecInfoKhr[] ret = new CLMutableDispatchExecInfoKhr[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<CLMutableDispatchExecInfoKhr> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<CLMutableDispatchExecInfoKhr> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= CLMutableDispatchExecInfoKhr.BYTES;
            }

            @Override
            public CLMutableDispatchExecInfoKhr next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                CLMutableDispatchExecInfoKhr ret = new CLMutableDispatchExecInfoKhr(segment.asSlice(0, CLMutableDispatchExecInfoKhr.BYTES));
                segment = segment.asSlice(CLMutableDispatchExecInfoKhr.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static CLMutableDispatchExecInfoKhr allocate(Arena arena) {
        return new CLMutableDispatchExecInfoKhr(arena.allocate(LAYOUT));
    }

    public static CLMutableDispatchExecInfoKhr.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        return new CLMutableDispatchExecInfoKhr.Ptr(segment);
    }

    public static CLMutableDispatchExecInfoKhr clone(Arena arena, CLMutableDispatchExecInfoKhr src) {
        CLMutableDispatchExecInfoKhr ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public @NativeType("cl_uint") @Unsigned int paramName() {
        return segment.get(LAYOUT$paramName, OFFSET$paramName);
    }

    public CLMutableDispatchExecInfoKhr paramName(@NativeType("cl_uint") @Unsigned int value) {
        segment.set(LAYOUT$paramName, OFFSET$paramName, value);
        return this;
    }

    public @Unsigned long paramValueSize() {
        return NativeLayout.readCSizeT(segment, OFFSET$paramValueSize);
    }

    public CLMutableDispatchExecInfoKhr paramValueSize(@Unsigned long value) {
        NativeLayout.writeCSizeT(segment, OFFSET$paramValueSize, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment paramValue() {
        return segment.get(LAYOUT$paramValue, OFFSET$paramValue);
    }

    public CLMutableDispatchExecInfoKhr paramValue(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$paramValue, OFFSET$paramValue, value);
        return this;
    }

    public CLMutableDispatchExecInfoKhr paramValue(@Nullable IPointer pointer) {
        paramValue(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("paramName"),
        NativeLayout.C_SIZE_T.withName("paramValueSize"),
        ValueLayout.ADDRESS.withName("paramValue")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$paramName = PathElement.groupElement("paramName");
    public static final PathElement PATH$paramValueSize = PathElement.groupElement("paramValueSize");
    public static final PathElement PATH$paramValue = PathElement.groupElement("paramValue");

    public static final OfInt LAYOUT$paramName = (OfInt) LAYOUT.select(PATH$paramName);
    public static final AddressLayout LAYOUT$paramValue = (AddressLayout) LAYOUT.select(PATH$paramValue);

    public static final long SIZE$paramName = LAYOUT$paramName.byteSize();
    public static final long SIZE$paramValueSize = NativeLayout.C_SIZE_T.byteSize();
    public static final long SIZE$paramValue = LAYOUT$paramValue.byteSize();

    public static final long OFFSET$paramName = LAYOUT.byteOffset(PATH$paramName);
    public static final long OFFSET$paramValueSize = LAYOUT.byteOffset(PATH$paramValueSize);
    public static final long OFFSET$paramValue = LAYOUT.byteOffset(PATH$paramValue);
}
