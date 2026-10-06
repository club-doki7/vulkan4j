package club.doki7.vma.datatype;

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
import club.doki7.vma.bitmask.*;
import club.doki7.vma.handle.*;
import club.doki7.vma.enumtype.*;
import club.doki7.vma.VMAFunctionTypes.*;
import club.doki7.vulkan.bitmask.*;
import club.doki7.vulkan.datatype.*;
import club.doki7.vulkan.enumtype.*;
import club.doki7.vulkan.handle.*;
import static club.doki7.vulkan.VkConstants.*;

/// Describes parameter of created {@code VmaPool}.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VmaPoolCreateInfo {
///     uint32_t memoryTypeIndex; // @link substring="memoryTypeIndex" target="#memoryTypeIndex"
///     VmaPoolCreateFlags flags; // @link substring="VmaPoolCreateFlags" target="VmaPoolCreateFlags" @link substring="flags" target="#flags"
///     VkDeviceSize blockSize; // @link substring="blockSize" target="#blockSize"
///     size_t minBlockCount; // @link substring="minBlockCount" target="#minBlockCount"
///     size_t maxBlockCount; // @link substring="maxBlockCount" target="#maxBlockCount"
///     float priority; // @link substring="priority" target="#priority"
///     VkDeviceSize minAllocationAlignment; // @link substring="minAllocationAlignment" target="#minAllocationAlignment"
///     void* pMemoryAllocateNext; // optional // @link substring="pMemoryAllocateNext" target="#pMemoryAllocateNext"
/// } VmaPoolCreateInfo;
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
/// ## Member documentation
///
/// <ul>
/// <li>{@link #memoryTypeIndex} Vulkan memory type index to allocate this pool from.</li>
/// <li>{@link #flags} Use combination of {@code VmaPoolCreateFlagBits}.</li>
/// <li>{@link #blockSize} Size of a single `VkDeviceMemory` block to be allocated as part of this pool, in bytes. Optional.
///
/// Specify nonzero to set explicit, constant size of memory blocks used by this
/// pool.
///
/// Leave 0 to use default and let the library manage block sizes automatically.
/// Sizes of particular blocks may vary.
/// In this case, the pool will also support dedicated allocations.
/// </li>
/// <li>{@link #minBlockCount} Minimum number of blocks to be always allocated in this pool, even if they stay empty.
///
/// Set to 0 to have no preallocated blocks and allow the pool be completely empty.
/// </li>
/// <li>{@link #maxBlockCount} Maximum number of blocks that can be allocated in this pool. Optional.
///
/// Set to 0 to use default, which is `SIZE_MAX`, which means no limit.
///
/// Set to same value as VmaPoolCreateInfo::minBlockCount to have fixed amount of memory allocated
/// throughout whole lifetime of this pool.
/// </li>
/// <li>{@link #priority} A floating-point value between 0 and 1, indicating the priority of the allocations in this pool relative to other memory allocations.
///
/// It is used only when {@code VMA_ALLOCATOR_CREATE_EXT_MEMORY_PRIORITY_BIT} flag was used during creation of the {@code VmaAllocator} object.
/// Otherwise, this variable is ignored.
/// </li>
/// <li>{@link #minAllocationAlignment} Additional minimum alignment to be used for all allocations created from this pool. Can be 0.
///
/// Leave 0 (default) not to impose any additional alignment. If not 0, it must be a power of two.
///
/// When creating a buffer or an image, specifying a custom alignment is not needed in most cases,
/// because Vulkan implementation inspects the `CreateInfo` structure (including intended usage flags)
/// and returns required alignment through functions like `vkGetBufferMemoryRequirements2`, which VMA automatically
/// uses and respects.
/// Extra alignment may be needed in some cases, like when using a buffer for acceleration structure scratch
/// (`VkPhysicalDeviceAccelerationStructurePropertiesKHR::minAccelerationStructureScratchOffsetAlignment`, see also issue {@code 523})
/// or when doing interop with OpenGL.
/// </li>
/// <li>{@link #pMemoryAllocateNext} Additional `pNext` chain to be attached to `VkMemoryAllocateInfo` used for every allocation made by this pool. Optional.
///
/// Optional, can be null. If not null, it must point to a `pNext` chain of structures that can be attached to `VkMemoryAllocateInfo`.
/// It can be useful for special needs such as adding `VkExportMemoryAllocateInfoKHR`.
/// Structures pointed by this member must remain alive and unchanged for the whole lifetime of the custom pool.
///
/// Please note that some structures, e.g. `VkMemoryPriorityAllocateInfoEXT`, `VkMemoryDedicatedAllocateInfoKHR`,
/// can be attached automatically by this library when using other, more convenient of its features.
/// </li>
/// </ul>
@ValueBasedCandidate
@UnsafeConstructor
public record VmaPoolCreateInfo(@NotNull MemorySegment segment) implements IVmaPoolCreateInfo {
    /// Represents a pointer to / an array of null structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VmaPoolCreateInfo}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVmaPoolCreateInfo to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VmaPoolCreateInfo.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVmaPoolCreateInfo, Iterable<VmaPoolCreateInfo> {
        public long size() {
            return segment.byteSize() / VmaPoolCreateInfo.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VmaPoolCreateInfo at(long index) {
            return new VmaPoolCreateInfo(segment.asSlice(index * VmaPoolCreateInfo.BYTES, VmaPoolCreateInfo.BYTES));
        }

        public VmaPoolCreateInfo.Ptr at(long index, @NotNull Consumer<@NotNull VmaPoolCreateInfo> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VmaPoolCreateInfo value) {
            MemorySegment s = segment.asSlice(index * VmaPoolCreateInfo.BYTES, VmaPoolCreateInfo.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VmaPoolCreateInfo.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VmaPoolCreateInfo.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VmaPoolCreateInfo.BYTES,
                (end - start) * VmaPoolCreateInfo.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VmaPoolCreateInfo.BYTES));
        }

        public VmaPoolCreateInfo[] toArray() {
            VmaPoolCreateInfo[] ret = new VmaPoolCreateInfo[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VmaPoolCreateInfo> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VmaPoolCreateInfo> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VmaPoolCreateInfo.BYTES;
            }

            @Override
            public VmaPoolCreateInfo next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VmaPoolCreateInfo ret = new VmaPoolCreateInfo(segment.asSlice(0, VmaPoolCreateInfo.BYTES));
                segment = segment.asSlice(VmaPoolCreateInfo.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VmaPoolCreateInfo allocate(Arena arena) {
        return new VmaPoolCreateInfo(arena.allocate(LAYOUT));
    }

    public static VmaPoolCreateInfo.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        return new VmaPoolCreateInfo.Ptr(segment);
    }

    public static VmaPoolCreateInfo clone(Arena arena, VmaPoolCreateInfo src) {
        VmaPoolCreateInfo ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public @Unsigned int memoryTypeIndex() {
        return segment.get(LAYOUT$memoryTypeIndex, OFFSET$memoryTypeIndex);
    }

    public VmaPoolCreateInfo memoryTypeIndex(@Unsigned int value) {
        segment.set(LAYOUT$memoryTypeIndex, OFFSET$memoryTypeIndex, value);
        return this;
    }

    public @Bitmask(VmaPoolCreateFlags.class) int flags() {
        return segment.get(LAYOUT$flags, OFFSET$flags);
    }

    public VmaPoolCreateInfo flags(@Bitmask(VmaPoolCreateFlags.class) int value) {
        segment.set(LAYOUT$flags, OFFSET$flags, value);
        return this;
    }

    public @NativeType("VkDeviceSize") @Unsigned long blockSize() {
        return segment.get(LAYOUT$blockSize, OFFSET$blockSize);
    }

    public VmaPoolCreateInfo blockSize(@NativeType("VkDeviceSize") @Unsigned long value) {
        segment.set(LAYOUT$blockSize, OFFSET$blockSize, value);
        return this;
    }

    public @Unsigned long minBlockCount() {
        return NativeLayout.readCSizeT(segment, OFFSET$minBlockCount);
    }

    public VmaPoolCreateInfo minBlockCount(@Unsigned long value) {
        NativeLayout.writeCSizeT(segment, OFFSET$minBlockCount, value);
        return this;
    }

    public @Unsigned long maxBlockCount() {
        return NativeLayout.readCSizeT(segment, OFFSET$maxBlockCount);
    }

    public VmaPoolCreateInfo maxBlockCount(@Unsigned long value) {
        NativeLayout.writeCSizeT(segment, OFFSET$maxBlockCount, value);
        return this;
    }

    public float priority() {
        return segment.get(LAYOUT$priority, OFFSET$priority);
    }

    public VmaPoolCreateInfo priority(float value) {
        segment.set(LAYOUT$priority, OFFSET$priority, value);
        return this;
    }

    public @NativeType("VkDeviceSize") @Unsigned long minAllocationAlignment() {
        return segment.get(LAYOUT$minAllocationAlignment, OFFSET$minAllocationAlignment);
    }

    public VmaPoolCreateInfo minAllocationAlignment(@NativeType("VkDeviceSize") @Unsigned long value) {
        segment.set(LAYOUT$minAllocationAlignment, OFFSET$minAllocationAlignment, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pMemoryAllocateNext() {
        return segment.get(LAYOUT$pMemoryAllocateNext, OFFSET$pMemoryAllocateNext);
    }

    public VmaPoolCreateInfo pMemoryAllocateNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pMemoryAllocateNext, OFFSET$pMemoryAllocateNext, value);
        return this;
    }

    public VmaPoolCreateInfo pMemoryAllocateNext(@Nullable IPointer pointer) {
        pMemoryAllocateNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("memoryTypeIndex"),
        ValueLayout.JAVA_INT.withName("flags"),
        ValueLayout.JAVA_LONG.withName("blockSize"),
        NativeLayout.C_SIZE_T.withName("minBlockCount"),
        NativeLayout.C_SIZE_T.withName("maxBlockCount"),
        ValueLayout.JAVA_FLOAT.withName("priority"),
        ValueLayout.JAVA_LONG.withName("minAllocationAlignment"),
        ValueLayout.ADDRESS.withName("pMemoryAllocateNext")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$memoryTypeIndex = PathElement.groupElement("memoryTypeIndex");
    public static final PathElement PATH$flags = PathElement.groupElement("flags");
    public static final PathElement PATH$blockSize = PathElement.groupElement("blockSize");
    public static final PathElement PATH$minBlockCount = PathElement.groupElement("minBlockCount");
    public static final PathElement PATH$maxBlockCount = PathElement.groupElement("maxBlockCount");
    public static final PathElement PATH$priority = PathElement.groupElement("priority");
    public static final PathElement PATH$minAllocationAlignment = PathElement.groupElement("minAllocationAlignment");
    public static final PathElement PATH$pMemoryAllocateNext = PathElement.groupElement("pMemoryAllocateNext");

    public static final OfInt LAYOUT$memoryTypeIndex = (OfInt) LAYOUT.select(PATH$memoryTypeIndex);
    public static final OfInt LAYOUT$flags = (OfInt) LAYOUT.select(PATH$flags);
    public static final OfLong LAYOUT$blockSize = (OfLong) LAYOUT.select(PATH$blockSize);
    public static final OfFloat LAYOUT$priority = (OfFloat) LAYOUT.select(PATH$priority);
    public static final OfLong LAYOUT$minAllocationAlignment = (OfLong) LAYOUT.select(PATH$minAllocationAlignment);
    public static final AddressLayout LAYOUT$pMemoryAllocateNext = (AddressLayout) LAYOUT.select(PATH$pMemoryAllocateNext);

    public static final long SIZE$memoryTypeIndex = LAYOUT$memoryTypeIndex.byteSize();
    public static final long SIZE$flags = LAYOUT$flags.byteSize();
    public static final long SIZE$blockSize = LAYOUT$blockSize.byteSize();
    public static final long SIZE$minBlockCount = NativeLayout.C_SIZE_T.byteSize();
    public static final long SIZE$maxBlockCount = NativeLayout.C_SIZE_T.byteSize();
    public static final long SIZE$priority = LAYOUT$priority.byteSize();
    public static final long SIZE$minAllocationAlignment = LAYOUT$minAllocationAlignment.byteSize();
    public static final long SIZE$pMemoryAllocateNext = LAYOUT$pMemoryAllocateNext.byteSize();

    public static final long OFFSET$memoryTypeIndex = LAYOUT.byteOffset(PATH$memoryTypeIndex);
    public static final long OFFSET$flags = LAYOUT.byteOffset(PATH$flags);
    public static final long OFFSET$blockSize = LAYOUT.byteOffset(PATH$blockSize);
    public static final long OFFSET$minBlockCount = LAYOUT.byteOffset(PATH$minBlockCount);
    public static final long OFFSET$maxBlockCount = LAYOUT.byteOffset(PATH$maxBlockCount);
    public static final long OFFSET$priority = LAYOUT.byteOffset(PATH$priority);
    public static final long OFFSET$minAllocationAlignment = LAYOUT.byteOffset(PATH$minAllocationAlignment);
    public static final long OFFSET$pMemoryAllocateNext = LAYOUT.byteOffset(PATH$pMemoryAllocateNext);
}
