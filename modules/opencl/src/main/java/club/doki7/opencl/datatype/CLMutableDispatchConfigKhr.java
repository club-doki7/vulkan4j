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

/// Represents a pointer to a <a href="https://registry.khronos.org/OpenCL/sdk/latest/docs/man/html/cl_mutable_dispatch_config_khr.html">cl_mutable_dispatch_config_khr</a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct cl_mutable_dispatch_config_khr {
///     cl_mutable_command_khr command; // @link substring="CLMutableCommandKhr" target="CLMutableCommandKhr" @link substring="command" target="#command"
///     cl_uint numArgs; // @link substring="numArgs" target="#numArgs"
///     cl_uint numSvmArgs; // @link substring="numSvmArgs" target="#numSvmArgs"
///     cl_uint numExecInfos; // @link substring="numExecInfos" target="#numExecInfos"
///     cl_uint workDim; // @link substring="workDim" target="#workDim"
///     cl_mutable_dispatch_arg_khr const* argList; // @link substring="CLMutableDispatchArgKhr" target="CLMutableDispatchArgKhr" @link substring="argList" target="#argList"
///     cl_mutable_dispatch_arg_khr const* argSvmList; // @link substring="CLMutableDispatchArgKhr" target="CLMutableDispatchArgKhr" @link substring="argSvmList" target="#argSvmList"
///     cl_mutable_dispatch_exec_info_khr const* execInfoList; // @link substring="CLMutableDispatchExecInfoKhr" target="CLMutableDispatchExecInfoKhr" @link substring="execInfoList" target="#execInfoList"
///     size_t const* globalWorkOffset; // @link substring="globalWorkOffset" target="#globalWorkOffset"
///     size_t const* globalWorkSize; // @link substring="globalWorkSize" target="#globalWorkSize"
///     size_t const* localWorkSize; // @link substring="localWorkSize" target="#localWorkSize"
/// } cl_mutable_dispatch_config_khr;
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
/// @see <a href="https://registry.khronos.org/OpenCL/sdk/latest/docs/man/html/cl_mutable_dispatch_config_khr.html">cl_mutable_dispatch_config_khr</a>
@ValueBasedCandidate
@UnsafeConstructor
public record CLMutableDispatchConfigKhr(@NotNull MemorySegment segment) implements ICLMutableDispatchConfigKhr {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/OpenCL/sdk/latest/docs/man/html/cl_mutable_dispatch_config_khr.html">cl_mutable_dispatch_config_khr</a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link CLMutableDispatchConfigKhr}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// ICLMutableDispatchConfigKhr to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code CLMutableDispatchConfigKhr.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements ICLMutableDispatchConfigKhr, Iterable<CLMutableDispatchConfigKhr> {
        public long size() {
            return segment.byteSize() / CLMutableDispatchConfigKhr.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull CLMutableDispatchConfigKhr at(long index) {
            return new CLMutableDispatchConfigKhr(segment.asSlice(index * CLMutableDispatchConfigKhr.BYTES, CLMutableDispatchConfigKhr.BYTES));
        }

        public CLMutableDispatchConfigKhr.Ptr at(long index, @NotNull Consumer<@NotNull CLMutableDispatchConfigKhr> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull CLMutableDispatchConfigKhr value) {
            MemorySegment s = segment.asSlice(index * CLMutableDispatchConfigKhr.BYTES, CLMutableDispatchConfigKhr.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * CLMutableDispatchConfigKhr.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * CLMutableDispatchConfigKhr.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * CLMutableDispatchConfigKhr.BYTES,
                (end - start) * CLMutableDispatchConfigKhr.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * CLMutableDispatchConfigKhr.BYTES));
        }

        public CLMutableDispatchConfigKhr[] toArray() {
            CLMutableDispatchConfigKhr[] ret = new CLMutableDispatchConfigKhr[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<CLMutableDispatchConfigKhr> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<CLMutableDispatchConfigKhr> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= CLMutableDispatchConfigKhr.BYTES;
            }

            @Override
            public CLMutableDispatchConfigKhr next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                CLMutableDispatchConfigKhr ret = new CLMutableDispatchConfigKhr(segment.asSlice(0, CLMutableDispatchConfigKhr.BYTES));
                segment = segment.asSlice(CLMutableDispatchConfigKhr.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static CLMutableDispatchConfigKhr allocate(Arena arena) {
        return new CLMutableDispatchConfigKhr(arena.allocate(LAYOUT));
    }

    public static CLMutableDispatchConfigKhr.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        return new CLMutableDispatchConfigKhr.Ptr(segment);
    }

    public static CLMutableDispatchConfigKhr clone(Arena arena, CLMutableDispatchConfigKhr src) {
        CLMutableDispatchConfigKhr ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public @Nullable CLMutableCommandKhr command() {
        MemorySegment s = segment.asSlice(OFFSET$command, SIZE$command);
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new CLMutableCommandKhr(s);
    }

    public CLMutableDispatchConfigKhr command(@Nullable CLMutableCommandKhr value) {
        segment.set(LAYOUT$command, OFFSET$command, value != null ? value.segment() : MemorySegment.NULL);
        return this;
    }

    public @NativeType("cl_uint") @Unsigned int numArgs() {
        return segment.get(LAYOUT$numArgs, OFFSET$numArgs);
    }

    public CLMutableDispatchConfigKhr numArgs(@NativeType("cl_uint") @Unsigned int value) {
        segment.set(LAYOUT$numArgs, OFFSET$numArgs, value);
        return this;
    }

    public @NativeType("cl_uint") @Unsigned int numSvmArgs() {
        return segment.get(LAYOUT$numSvmArgs, OFFSET$numSvmArgs);
    }

    public CLMutableDispatchConfigKhr numSvmArgs(@NativeType("cl_uint") @Unsigned int value) {
        segment.set(LAYOUT$numSvmArgs, OFFSET$numSvmArgs, value);
        return this;
    }

    public @NativeType("cl_uint") @Unsigned int numExecInfos() {
        return segment.get(LAYOUT$numExecInfos, OFFSET$numExecInfos);
    }

    public CLMutableDispatchConfigKhr numExecInfos(@NativeType("cl_uint") @Unsigned int value) {
        segment.set(LAYOUT$numExecInfos, OFFSET$numExecInfos, value);
        return this;
    }

    public @NativeType("cl_uint") @Unsigned int workDim() {
        return segment.get(LAYOUT$workDim, OFFSET$workDim);
    }

    public CLMutableDispatchConfigKhr workDim(@NativeType("cl_uint") @Unsigned int value) {
        segment.set(LAYOUT$workDim, OFFSET$workDim, value);
        return this;
    }

    public CLMutableDispatchConfigKhr argList(@Nullable ICLMutableDispatchArgKhr value) {
        MemorySegment s = value == null ? MemorySegment.NULL : value.segment();
        argListRaw(s);
        return this;
    }

    @Unsafe public @Nullable CLMutableDispatchArgKhr.Ptr argList(int assumedCount) {
        MemorySegment s = argListRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }

        s = s.reinterpret(assumedCount * CLMutableDispatchArgKhr.BYTES);
        return new CLMutableDispatchArgKhr.Ptr(s);
    }

    public @Nullable CLMutableDispatchArgKhr argList() {
        MemorySegment s = argListRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new CLMutableDispatchArgKhr(s);
    }

    public @Pointer(target=CLMutableDispatchArgKhr.class) @NotNull MemorySegment argListRaw() {
        return segment.get(LAYOUT$argList, OFFSET$argList);
    }

    public void argListRaw(@Pointer(target=CLMutableDispatchArgKhr.class) @NotNull MemorySegment value) {
        segment.set(LAYOUT$argList, OFFSET$argList, value);
    }

    public CLMutableDispatchConfigKhr argSvmList(@Nullable ICLMutableDispatchArgKhr value) {
        MemorySegment s = value == null ? MemorySegment.NULL : value.segment();
        argSvmListRaw(s);
        return this;
    }

    @Unsafe public @Nullable CLMutableDispatchArgKhr.Ptr argSvmList(int assumedCount) {
        MemorySegment s = argSvmListRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }

        s = s.reinterpret(assumedCount * CLMutableDispatchArgKhr.BYTES);
        return new CLMutableDispatchArgKhr.Ptr(s);
    }

    public @Nullable CLMutableDispatchArgKhr argSvmList() {
        MemorySegment s = argSvmListRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new CLMutableDispatchArgKhr(s);
    }

    public @Pointer(target=CLMutableDispatchArgKhr.class) @NotNull MemorySegment argSvmListRaw() {
        return segment.get(LAYOUT$argSvmList, OFFSET$argSvmList);
    }

    public void argSvmListRaw(@Pointer(target=CLMutableDispatchArgKhr.class) @NotNull MemorySegment value) {
        segment.set(LAYOUT$argSvmList, OFFSET$argSvmList, value);
    }

    public CLMutableDispatchConfigKhr execInfoList(@Nullable ICLMutableDispatchExecInfoKhr value) {
        MemorySegment s = value == null ? MemorySegment.NULL : value.segment();
        execInfoListRaw(s);
        return this;
    }

    @Unsafe public @Nullable CLMutableDispatchExecInfoKhr.Ptr execInfoList(int assumedCount) {
        MemorySegment s = execInfoListRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }

        s = s.reinterpret(assumedCount * CLMutableDispatchExecInfoKhr.BYTES);
        return new CLMutableDispatchExecInfoKhr.Ptr(s);
    }

    public @Nullable CLMutableDispatchExecInfoKhr execInfoList() {
        MemorySegment s = execInfoListRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new CLMutableDispatchExecInfoKhr(s);
    }

    public @Pointer(target=CLMutableDispatchExecInfoKhr.class) @NotNull MemorySegment execInfoListRaw() {
        return segment.get(LAYOUT$execInfoList, OFFSET$execInfoList);
    }

    public void execInfoListRaw(@Pointer(target=CLMutableDispatchExecInfoKhr.class) @NotNull MemorySegment value) {
        segment.set(LAYOUT$execInfoList, OFFSET$execInfoList, value);
    }

    /// Note: the returned {@link PointerPtr} does not have correct
    /// {@link PointerPtr#size} property. It's up to user to track the size of the buffer,
    /// and use {@link PointerPtr#reinterpret} to set the size before actually reading from or
    /// writing to the buffer.
    public @Nullable PointerPtr globalWorkOffset() {
        MemorySegment s = globalWorkOffsetRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new PointerPtr(s);
    }

    public CLMutableDispatchConfigKhr globalWorkOffset(@Nullable PointerPtr value) {
        MemorySegment s = value == null ? MemorySegment.NULL : value.segment();
        globalWorkOffsetRaw(s);
        return this;
    }

    public @Pointer(comment="size_t*") @NotNull MemorySegment globalWorkOffsetRaw() {
        return segment.get(LAYOUT$globalWorkOffset, OFFSET$globalWorkOffset);
    }

    public void globalWorkOffsetRaw(@Pointer(comment="size_t*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$globalWorkOffset, OFFSET$globalWorkOffset, value);
    }

    /// Note: the returned {@link PointerPtr} does not have correct
    /// {@link PointerPtr#size} property. It's up to user to track the size of the buffer,
    /// and use {@link PointerPtr#reinterpret} to set the size before actually reading from or
    /// writing to the buffer.
    public @Nullable PointerPtr globalWorkSize() {
        MemorySegment s = globalWorkSizeRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new PointerPtr(s);
    }

    public CLMutableDispatchConfigKhr globalWorkSize(@Nullable PointerPtr value) {
        MemorySegment s = value == null ? MemorySegment.NULL : value.segment();
        globalWorkSizeRaw(s);
        return this;
    }

    public @Pointer(comment="size_t*") @NotNull MemorySegment globalWorkSizeRaw() {
        return segment.get(LAYOUT$globalWorkSize, OFFSET$globalWorkSize);
    }

    public void globalWorkSizeRaw(@Pointer(comment="size_t*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$globalWorkSize, OFFSET$globalWorkSize, value);
    }

    /// Note: the returned {@link PointerPtr} does not have correct
    /// {@link PointerPtr#size} property. It's up to user to track the size of the buffer,
    /// and use {@link PointerPtr#reinterpret} to set the size before actually reading from or
    /// writing to the buffer.
    public @Nullable PointerPtr localWorkSize() {
        MemorySegment s = localWorkSizeRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new PointerPtr(s);
    }

    public CLMutableDispatchConfigKhr localWorkSize(@Nullable PointerPtr value) {
        MemorySegment s = value == null ? MemorySegment.NULL : value.segment();
        localWorkSizeRaw(s);
        return this;
    }

    public @Pointer(comment="size_t*") @NotNull MemorySegment localWorkSizeRaw() {
        return segment.get(LAYOUT$localWorkSize, OFFSET$localWorkSize);
    }

    public void localWorkSizeRaw(@Pointer(comment="size_t*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$localWorkSize, OFFSET$localWorkSize, value);
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.ADDRESS.withName("command"),
        ValueLayout.JAVA_INT.withName("numArgs"),
        ValueLayout.JAVA_INT.withName("numSvmArgs"),
        ValueLayout.JAVA_INT.withName("numExecInfos"),
        ValueLayout.JAVA_INT.withName("workDim"),
        ValueLayout.ADDRESS.withTargetLayout(CLMutableDispatchArgKhr.LAYOUT).withName("argList"),
        ValueLayout.ADDRESS.withTargetLayout(CLMutableDispatchArgKhr.LAYOUT).withName("argSvmList"),
        ValueLayout.ADDRESS.withTargetLayout(CLMutableDispatchExecInfoKhr.LAYOUT).withName("execInfoList"),
        ValueLayout.ADDRESS.withTargetLayout(NativeLayout.C_SIZE_T).withName("globalWorkOffset"),
        ValueLayout.ADDRESS.withTargetLayout(NativeLayout.C_SIZE_T).withName("globalWorkSize"),
        ValueLayout.ADDRESS.withTargetLayout(NativeLayout.C_SIZE_T).withName("localWorkSize")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$command = PathElement.groupElement("command");
    public static final PathElement PATH$numArgs = PathElement.groupElement("numArgs");
    public static final PathElement PATH$numSvmArgs = PathElement.groupElement("numSvmArgs");
    public static final PathElement PATH$numExecInfos = PathElement.groupElement("numExecInfos");
    public static final PathElement PATH$workDim = PathElement.groupElement("workDim");
    public static final PathElement PATH$argList = PathElement.groupElement("argList");
    public static final PathElement PATH$argSvmList = PathElement.groupElement("argSvmList");
    public static final PathElement PATH$execInfoList = PathElement.groupElement("execInfoList");
    public static final PathElement PATH$globalWorkOffset = PathElement.groupElement("globalWorkOffset");
    public static final PathElement PATH$globalWorkSize = PathElement.groupElement("globalWorkSize");
    public static final PathElement PATH$localWorkSize = PathElement.groupElement("localWorkSize");

    public static final AddressLayout LAYOUT$command = (AddressLayout) LAYOUT.select(PATH$command);
    public static final OfInt LAYOUT$numArgs = (OfInt) LAYOUT.select(PATH$numArgs);
    public static final OfInt LAYOUT$numSvmArgs = (OfInt) LAYOUT.select(PATH$numSvmArgs);
    public static final OfInt LAYOUT$numExecInfos = (OfInt) LAYOUT.select(PATH$numExecInfos);
    public static final OfInt LAYOUT$workDim = (OfInt) LAYOUT.select(PATH$workDim);
    public static final AddressLayout LAYOUT$argList = (AddressLayout) LAYOUT.select(PATH$argList);
    public static final AddressLayout LAYOUT$argSvmList = (AddressLayout) LAYOUT.select(PATH$argSvmList);
    public static final AddressLayout LAYOUT$execInfoList = (AddressLayout) LAYOUT.select(PATH$execInfoList);
    public static final AddressLayout LAYOUT$globalWorkOffset = (AddressLayout) LAYOUT.select(PATH$globalWorkOffset);
    public static final AddressLayout LAYOUT$globalWorkSize = (AddressLayout) LAYOUT.select(PATH$globalWorkSize);
    public static final AddressLayout LAYOUT$localWorkSize = (AddressLayout) LAYOUT.select(PATH$localWorkSize);

    public static final long SIZE$command = LAYOUT$command.byteSize();
    public static final long SIZE$numArgs = LAYOUT$numArgs.byteSize();
    public static final long SIZE$numSvmArgs = LAYOUT$numSvmArgs.byteSize();
    public static final long SIZE$numExecInfos = LAYOUT$numExecInfos.byteSize();
    public static final long SIZE$workDim = LAYOUT$workDim.byteSize();
    public static final long SIZE$argList = LAYOUT$argList.byteSize();
    public static final long SIZE$argSvmList = LAYOUT$argSvmList.byteSize();
    public static final long SIZE$execInfoList = LAYOUT$execInfoList.byteSize();
    public static final long SIZE$globalWorkOffset = LAYOUT$globalWorkOffset.byteSize();
    public static final long SIZE$globalWorkSize = LAYOUT$globalWorkSize.byteSize();
    public static final long SIZE$localWorkSize = LAYOUT$localWorkSize.byteSize();

    public static final long OFFSET$command = LAYOUT.byteOffset(PATH$command);
    public static final long OFFSET$numArgs = LAYOUT.byteOffset(PATH$numArgs);
    public static final long OFFSET$numSvmArgs = LAYOUT.byteOffset(PATH$numSvmArgs);
    public static final long OFFSET$numExecInfos = LAYOUT.byteOffset(PATH$numExecInfos);
    public static final long OFFSET$workDim = LAYOUT.byteOffset(PATH$workDim);
    public static final long OFFSET$argList = LAYOUT.byteOffset(PATH$argList);
    public static final long OFFSET$argSvmList = LAYOUT.byteOffset(PATH$argSvmList);
    public static final long OFFSET$execInfoList = LAYOUT.byteOffset(PATH$execInfoList);
    public static final long OFFSET$globalWorkOffset = LAYOUT.byteOffset(PATH$globalWorkOffset);
    public static final long OFFSET$globalWorkSize = LAYOUT.byteOffset(PATH$globalWorkSize);
    public static final long OFFSET$localWorkSize = LAYOUT.byteOffset(PATH$localWorkSize);
}
