package club.doki7.vulkan.datatype;

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
import club.doki7.vulkan.bitmask.*;
import club.doki7.vulkan.handle.*;
import club.doki7.vulkan.enumtype.*;
import static club.doki7.vulkan.VkConstants.*;
import club.doki7.vulkan.VkFunctionTypes.*;

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPartitionedAccelerationStructureInstancesInputNV.html"><code>VkPartitionedAccelerationStructureInstancesInputNV</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkPartitionedAccelerationStructureInstancesInputNV {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void* pNext; // optional // @link substring="pNext" target="#pNext"
///     VkBuildAccelerationStructureFlagsKHR flags; // optional // @link substring="VkBuildAccelerationStructureFlagsKHR" target="VkBuildAccelerationStructureFlagsKHR" @link substring="flags" target="#flags"
///     uint32_t instanceCount; // @link substring="instanceCount" target="#instanceCount"
///     uint32_t maxInstancePerPartitionCount; // @link substring="maxInstancePerPartitionCount" target="#maxInstancePerPartitionCount"
///     uint32_t partitionCount; // @link substring="partitionCount" target="#partitionCount"
///     uint32_t maxInstanceInGlobalPartitionCount; // @link substring="maxInstanceInGlobalPartitionCount" target="#maxInstanceInGlobalPartitionCount"
/// } VkPartitionedAccelerationStructureInstancesInputNV;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_PARTITIONED_ACCELERATION_STRUCTURE_INSTANCES_INPUT_NV`
///
/// The {@code allocate} ({@link VkPartitionedAccelerationStructureInstancesInputNV#allocate(Arena)}, {@link VkPartitionedAccelerationStructureInstancesInputNV#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkPartitionedAccelerationStructureInstancesInputNV#autoInit}
/// to initialize these fields manually for non-allocated instances.
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPartitionedAccelerationStructureInstancesInputNV.html"><code>VkPartitionedAccelerationStructureInstancesInputNV</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkPartitionedAccelerationStructureInstancesInputNV(@NotNull MemorySegment segment) implements IVkPartitionedAccelerationStructureInstancesInputNV {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPartitionedAccelerationStructureInstancesInputNV.html"><code>VkPartitionedAccelerationStructureInstancesInputNV</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkPartitionedAccelerationStructureInstancesInputNV}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkPartitionedAccelerationStructureInstancesInputNV to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkPartitionedAccelerationStructureInstancesInputNV.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkPartitionedAccelerationStructureInstancesInputNV, Iterable<VkPartitionedAccelerationStructureInstancesInputNV> {
        public long size() {
            return segment.byteSize() / VkPartitionedAccelerationStructureInstancesInputNV.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkPartitionedAccelerationStructureInstancesInputNV at(long index) {
            return new VkPartitionedAccelerationStructureInstancesInputNV(segment.asSlice(index * VkPartitionedAccelerationStructureInstancesInputNV.BYTES, VkPartitionedAccelerationStructureInstancesInputNV.BYTES));
        }

        public VkPartitionedAccelerationStructureInstancesInputNV.Ptr at(long index, @NotNull Consumer<@NotNull VkPartitionedAccelerationStructureInstancesInputNV> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkPartitionedAccelerationStructureInstancesInputNV value) {
            MemorySegment s = segment.asSlice(index * VkPartitionedAccelerationStructureInstancesInputNV.BYTES, VkPartitionedAccelerationStructureInstancesInputNV.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkPartitionedAccelerationStructureInstancesInputNV.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkPartitionedAccelerationStructureInstancesInputNV.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkPartitionedAccelerationStructureInstancesInputNV.BYTES,
                (end - start) * VkPartitionedAccelerationStructureInstancesInputNV.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkPartitionedAccelerationStructureInstancesInputNV.BYTES));
        }

        public VkPartitionedAccelerationStructureInstancesInputNV[] toArray() {
            VkPartitionedAccelerationStructureInstancesInputNV[] ret = new VkPartitionedAccelerationStructureInstancesInputNV[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkPartitionedAccelerationStructureInstancesInputNV> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkPartitionedAccelerationStructureInstancesInputNV> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkPartitionedAccelerationStructureInstancesInputNV.BYTES;
            }

            @Override
            public VkPartitionedAccelerationStructureInstancesInputNV next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkPartitionedAccelerationStructureInstancesInputNV ret = new VkPartitionedAccelerationStructureInstancesInputNV(segment.asSlice(0, VkPartitionedAccelerationStructureInstancesInputNV.BYTES));
                segment = segment.asSlice(VkPartitionedAccelerationStructureInstancesInputNV.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkPartitionedAccelerationStructureInstancesInputNV allocate(Arena arena) {
        VkPartitionedAccelerationStructureInstancesInputNV ret = new VkPartitionedAccelerationStructureInstancesInputNV(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.PARTITIONED_ACCELERATION_STRUCTURE_INSTANCES_INPUT_NV);
        return ret;
    }

    public static VkPartitionedAccelerationStructureInstancesInputNV.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkPartitionedAccelerationStructureInstancesInputNV.Ptr ret = new VkPartitionedAccelerationStructureInstancesInputNV.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.PARTITIONED_ACCELERATION_STRUCTURE_INSTANCES_INPUT_NV);
        }
        return ret;
    }

    public static VkPartitionedAccelerationStructureInstancesInputNV clone(Arena arena, VkPartitionedAccelerationStructureInstancesInputNV src) {
        VkPartitionedAccelerationStructureInstancesInputNV ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.PARTITIONED_ACCELERATION_STRUCTURE_INSTANCES_INPUT_NV);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkPartitionedAccelerationStructureInstancesInputNV sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkPartitionedAccelerationStructureInstancesInputNV pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkPartitionedAccelerationStructureInstancesInputNV pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @Bitmask(VkBuildAccelerationStructureFlagsKHR.class) int flags() {
        return segment.get(LAYOUT$flags, OFFSET$flags);
    }

    public VkPartitionedAccelerationStructureInstancesInputNV flags(@Bitmask(VkBuildAccelerationStructureFlagsKHR.class) int value) {
        segment.set(LAYOUT$flags, OFFSET$flags, value);
        return this;
    }

    public @Unsigned int instanceCount() {
        return segment.get(LAYOUT$instanceCount, OFFSET$instanceCount);
    }

    public VkPartitionedAccelerationStructureInstancesInputNV instanceCount(@Unsigned int value) {
        segment.set(LAYOUT$instanceCount, OFFSET$instanceCount, value);
        return this;
    }

    public @Unsigned int maxInstancePerPartitionCount() {
        return segment.get(LAYOUT$maxInstancePerPartitionCount, OFFSET$maxInstancePerPartitionCount);
    }

    public VkPartitionedAccelerationStructureInstancesInputNV maxInstancePerPartitionCount(@Unsigned int value) {
        segment.set(LAYOUT$maxInstancePerPartitionCount, OFFSET$maxInstancePerPartitionCount, value);
        return this;
    }

    public @Unsigned int partitionCount() {
        return segment.get(LAYOUT$partitionCount, OFFSET$partitionCount);
    }

    public VkPartitionedAccelerationStructureInstancesInputNV partitionCount(@Unsigned int value) {
        segment.set(LAYOUT$partitionCount, OFFSET$partitionCount, value);
        return this;
    }

    public @Unsigned int maxInstanceInGlobalPartitionCount() {
        return segment.get(LAYOUT$maxInstanceInGlobalPartitionCount, OFFSET$maxInstanceInGlobalPartitionCount);
    }

    public VkPartitionedAccelerationStructureInstancesInputNV maxInstanceInGlobalPartitionCount(@Unsigned int value) {
        segment.set(LAYOUT$maxInstanceInGlobalPartitionCount, OFFSET$maxInstanceInGlobalPartitionCount, value);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        ValueLayout.JAVA_INT.withName("flags"),
        ValueLayout.JAVA_INT.withName("instanceCount"),
        ValueLayout.JAVA_INT.withName("maxInstancePerPartitionCount"),
        ValueLayout.JAVA_INT.withName("partitionCount"),
        ValueLayout.JAVA_INT.withName("maxInstanceInGlobalPartitionCount")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$flags = PathElement.groupElement("flags");
    public static final PathElement PATH$instanceCount = PathElement.groupElement("instanceCount");
    public static final PathElement PATH$maxInstancePerPartitionCount = PathElement.groupElement("maxInstancePerPartitionCount");
    public static final PathElement PATH$partitionCount = PathElement.groupElement("partitionCount");
    public static final PathElement PATH$maxInstanceInGlobalPartitionCount = PathElement.groupElement("maxInstanceInGlobalPartitionCount");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final OfInt LAYOUT$flags = (OfInt) LAYOUT.select(PATH$flags);
    public static final OfInt LAYOUT$instanceCount = (OfInt) LAYOUT.select(PATH$instanceCount);
    public static final OfInt LAYOUT$maxInstancePerPartitionCount = (OfInt) LAYOUT.select(PATH$maxInstancePerPartitionCount);
    public static final OfInt LAYOUT$partitionCount = (OfInt) LAYOUT.select(PATH$partitionCount);
    public static final OfInt LAYOUT$maxInstanceInGlobalPartitionCount = (OfInt) LAYOUT.select(PATH$maxInstanceInGlobalPartitionCount);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$flags = LAYOUT$flags.byteSize();
    public static final long SIZE$instanceCount = LAYOUT$instanceCount.byteSize();
    public static final long SIZE$maxInstancePerPartitionCount = LAYOUT$maxInstancePerPartitionCount.byteSize();
    public static final long SIZE$partitionCount = LAYOUT$partitionCount.byteSize();
    public static final long SIZE$maxInstanceInGlobalPartitionCount = LAYOUT$maxInstanceInGlobalPartitionCount.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$flags = LAYOUT.byteOffset(PATH$flags);
    public static final long OFFSET$instanceCount = LAYOUT.byteOffset(PATH$instanceCount);
    public static final long OFFSET$maxInstancePerPartitionCount = LAYOUT.byteOffset(PATH$maxInstancePerPartitionCount);
    public static final long OFFSET$partitionCount = LAYOUT.byteOffset(PATH$partitionCount);
    public static final long OFFSET$maxInstanceInGlobalPartitionCount = LAYOUT.byteOffset(PATH$maxInstanceInGlobalPartitionCount);
}
