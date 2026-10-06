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

/// Parameters of new {@code VmaAllocation}.
///
/// To be used with functions like vmaCreateBuffer(), vmaCreateImage(), and many others.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VmaAllocationCreateInfo {
///     VmaAllocationCreateFlags flags; // @link substring="VmaAllocationCreateFlags" target="VmaAllocationCreateFlags" @link substring="flags" target="#flags"
///     VmaMemoryUsage usage; // @link substring="VmaMemoryUsage" target="VmaMemoryUsage" @link substring="usage" target="#usage"
///     VkMemoryPropertyFlags requiredFlags; // @link substring="VkMemoryPropertyFlags" target="VkMemoryPropertyFlags" @link substring="requiredFlags" target="#requiredFlags"
///     VkMemoryPropertyFlags preferredFlags; // @link substring="VkMemoryPropertyFlags" target="VkMemoryPropertyFlags" @link substring="preferredFlags" target="#preferredFlags"
///     uint32_t memoryTypeBits; // @link substring="memoryTypeBits" target="#memoryTypeBits"
///     VmaPool pool; // optional // @link substring="VmaPool" target="VmaPool" @link substring="pool" target="#pool"
///     void* pUserData; // optional // @link substring="pUserData" target="#pUserData"
///     float priority; // @link substring="priority" target="#priority"
///     VkDeviceSize minAlignment; // @link substring="minAlignment" target="#minAlignment"
/// } VmaAllocationCreateInfo;
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
/// <li>{@link #flags} Use {@code VmaAllocationCreateFlagBits} enum.</li>
/// <li>{@link #usage} Intended usage of memory.
///
/// You can leave {@code VMA_MEMORY_USAGE_UNKNOWN} if you specify memory requirements in other way.
///
/// If `pool` is not null, this member is ignored.
/// </li>
/// <li>{@link #requiredFlags} Flags that must be set in a Memory Type chosen for an allocation.
///
/// Leave 0 if you specify memory requirements in other way.
///
/// If `pool` is not null, this member is ignored.
/// </li>
/// <li>{@link #preferredFlags} Flags that preferably should be set in a memory type chosen for an allocation.
///
/// Set to 0 if no additional flags are preferred.
///
/// If `pool` is not null, this member is ignored.
/// </li>
/// <li>{@link #memoryTypeBits} Bitmask containing one bit set for every memory type acceptable for this allocation.
///
/// Value 0 is equivalent to `UINT32_MAX` - it means any memory type is accepted if
/// it meets other requirements specified by this structure, with no further
/// restrictions on memory type index.
///
/// If `pool` is not null, this member is ignored.
/// </li>
/// <li>{@link #pool} Pool that this allocation should be created in.
///
/// Leave `VK_NULL_HANDLE` to allocate from default pool. If not null, members:
/// `usage`, `requiredFlags`, `preferredFlags`, `memoryTypeBits` are ignored.
/// </li>
/// <li>{@link #pUserData} Custom general-purpose pointer that will be stored in {@code VmaAllocation}, can be read as VmaAllocationInfo::pUserData and changed using vmaSetAllocationUserData().
///
/// If {@code VMA_ALLOCATION_CREATE_USER_DATA_COPY_STRING_BIT} is used, it must be either
/// null or pointer to a null-terminated string. The string will be then copied to
/// internal buffer, so it doesn't need to be valid after allocation call.
/// </li>
/// <li>{@link #priority} A floating-point value between 0 and 1, indicating the priority of the allocation relative to other memory allocations.
///
/// It is used only when {@code VMA_ALLOCATOR_CREATE_EXT_MEMORY_PRIORITY_BIT} flag was used during creation of the {@code VmaAllocator} object
/// and this allocation ends up as dedicated or is explicitly forced as dedicated using {@code VMA_ALLOCATION_CREATE_DEDICATED_MEMORY_BIT}.
/// Otherwise, it has the priority of a memory block where it is placed and this variable is ignored.
/// </li>
/// <li>{@link #minAlignment} Additional minimum alignment to be used for this allocation. Can be 0.
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
/// </ul>
@ValueBasedCandidate
@UnsafeConstructor
public record VmaAllocationCreateInfo(@NotNull MemorySegment segment) implements IVmaAllocationCreateInfo {
    /// Represents a pointer to / an array of null structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VmaAllocationCreateInfo}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVmaAllocationCreateInfo to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VmaAllocationCreateInfo.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVmaAllocationCreateInfo, Iterable<VmaAllocationCreateInfo> {
        public long size() {
            return segment.byteSize() / VmaAllocationCreateInfo.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VmaAllocationCreateInfo at(long index) {
            return new VmaAllocationCreateInfo(segment.asSlice(index * VmaAllocationCreateInfo.BYTES, VmaAllocationCreateInfo.BYTES));
        }

        public VmaAllocationCreateInfo.Ptr at(long index, @NotNull Consumer<@NotNull VmaAllocationCreateInfo> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VmaAllocationCreateInfo value) {
            MemorySegment s = segment.asSlice(index * VmaAllocationCreateInfo.BYTES, VmaAllocationCreateInfo.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VmaAllocationCreateInfo.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VmaAllocationCreateInfo.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VmaAllocationCreateInfo.BYTES,
                (end - start) * VmaAllocationCreateInfo.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VmaAllocationCreateInfo.BYTES));
        }

        public VmaAllocationCreateInfo[] toArray() {
            VmaAllocationCreateInfo[] ret = new VmaAllocationCreateInfo[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VmaAllocationCreateInfo> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VmaAllocationCreateInfo> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VmaAllocationCreateInfo.BYTES;
            }

            @Override
            public VmaAllocationCreateInfo next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VmaAllocationCreateInfo ret = new VmaAllocationCreateInfo(segment.asSlice(0, VmaAllocationCreateInfo.BYTES));
                segment = segment.asSlice(VmaAllocationCreateInfo.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VmaAllocationCreateInfo allocate(Arena arena) {
        return new VmaAllocationCreateInfo(arena.allocate(LAYOUT));
    }

    public static VmaAllocationCreateInfo.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        return new VmaAllocationCreateInfo.Ptr(segment);
    }

    public static VmaAllocationCreateInfo clone(Arena arena, VmaAllocationCreateInfo src) {
        VmaAllocationCreateInfo ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public @Bitmask(VmaAllocationCreateFlags.class) int flags() {
        return segment.get(LAYOUT$flags, OFFSET$flags);
    }

    public VmaAllocationCreateInfo flags(@Bitmask(VmaAllocationCreateFlags.class) int value) {
        segment.set(LAYOUT$flags, OFFSET$flags, value);
        return this;
    }

    public @EnumType(VmaMemoryUsage.class) int usage() {
        return segment.get(LAYOUT$usage, OFFSET$usage);
    }

    public VmaAllocationCreateInfo usage(@EnumType(VmaMemoryUsage.class) int value) {
        segment.set(LAYOUT$usage, OFFSET$usage, value);
        return this;
    }

    public @Bitmask(VkMemoryPropertyFlags.class) int requiredFlags() {
        return segment.get(LAYOUT$requiredFlags, OFFSET$requiredFlags);
    }

    public VmaAllocationCreateInfo requiredFlags(@Bitmask(VkMemoryPropertyFlags.class) int value) {
        segment.set(LAYOUT$requiredFlags, OFFSET$requiredFlags, value);
        return this;
    }

    public @Bitmask(VkMemoryPropertyFlags.class) int preferredFlags() {
        return segment.get(LAYOUT$preferredFlags, OFFSET$preferredFlags);
    }

    public VmaAllocationCreateInfo preferredFlags(@Bitmask(VkMemoryPropertyFlags.class) int value) {
        segment.set(LAYOUT$preferredFlags, OFFSET$preferredFlags, value);
        return this;
    }

    public @Unsigned int memoryTypeBits() {
        return segment.get(LAYOUT$memoryTypeBits, OFFSET$memoryTypeBits);
    }

    public VmaAllocationCreateInfo memoryTypeBits(@Unsigned int value) {
        segment.set(LAYOUT$memoryTypeBits, OFFSET$memoryTypeBits, value);
        return this;
    }

    public @Nullable VmaPool pool() {
        MemorySegment s = segment.asSlice(OFFSET$pool, SIZE$pool);
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new VmaPool(s);
    }

    public VmaAllocationCreateInfo pool(@Nullable VmaPool value) {
        segment.set(LAYOUT$pool, OFFSET$pool, value != null ? value.segment() : MemorySegment.NULL);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pUserData() {
        return segment.get(LAYOUT$pUserData, OFFSET$pUserData);
    }

    public VmaAllocationCreateInfo pUserData(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pUserData, OFFSET$pUserData, value);
        return this;
    }

    public VmaAllocationCreateInfo pUserData(@Nullable IPointer pointer) {
        pUserData(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public float priority() {
        return segment.get(LAYOUT$priority, OFFSET$priority);
    }

    public VmaAllocationCreateInfo priority(float value) {
        segment.set(LAYOUT$priority, OFFSET$priority, value);
        return this;
    }

    public @NativeType("VkDeviceSize") @Unsigned long minAlignment() {
        return segment.get(LAYOUT$minAlignment, OFFSET$minAlignment);
    }

    public VmaAllocationCreateInfo minAlignment(@NativeType("VkDeviceSize") @Unsigned long value) {
        segment.set(LAYOUT$minAlignment, OFFSET$minAlignment, value);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("flags"),
        ValueLayout.JAVA_INT.withName("usage"),
        ValueLayout.JAVA_INT.withName("requiredFlags"),
        ValueLayout.JAVA_INT.withName("preferredFlags"),
        ValueLayout.JAVA_INT.withName("memoryTypeBits"),
        ValueLayout.ADDRESS.withName("pool"),
        ValueLayout.ADDRESS.withName("pUserData"),
        ValueLayout.JAVA_FLOAT.withName("priority"),
        ValueLayout.JAVA_LONG.withName("minAlignment")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$flags = PathElement.groupElement("flags");
    public static final PathElement PATH$usage = PathElement.groupElement("usage");
    public static final PathElement PATH$requiredFlags = PathElement.groupElement("requiredFlags");
    public static final PathElement PATH$preferredFlags = PathElement.groupElement("preferredFlags");
    public static final PathElement PATH$memoryTypeBits = PathElement.groupElement("memoryTypeBits");
    public static final PathElement PATH$pool = PathElement.groupElement("pool");
    public static final PathElement PATH$pUserData = PathElement.groupElement("pUserData");
    public static final PathElement PATH$priority = PathElement.groupElement("priority");
    public static final PathElement PATH$minAlignment = PathElement.groupElement("minAlignment");

    public static final OfInt LAYOUT$flags = (OfInt) LAYOUT.select(PATH$flags);
    public static final OfInt LAYOUT$usage = (OfInt) LAYOUT.select(PATH$usage);
    public static final OfInt LAYOUT$requiredFlags = (OfInt) LAYOUT.select(PATH$requiredFlags);
    public static final OfInt LAYOUT$preferredFlags = (OfInt) LAYOUT.select(PATH$preferredFlags);
    public static final OfInt LAYOUT$memoryTypeBits = (OfInt) LAYOUT.select(PATH$memoryTypeBits);
    public static final AddressLayout LAYOUT$pool = (AddressLayout) LAYOUT.select(PATH$pool);
    public static final AddressLayout LAYOUT$pUserData = (AddressLayout) LAYOUT.select(PATH$pUserData);
    public static final OfFloat LAYOUT$priority = (OfFloat) LAYOUT.select(PATH$priority);
    public static final OfLong LAYOUT$minAlignment = (OfLong) LAYOUT.select(PATH$minAlignment);

    public static final long SIZE$flags = LAYOUT$flags.byteSize();
    public static final long SIZE$usage = LAYOUT$usage.byteSize();
    public static final long SIZE$requiredFlags = LAYOUT$requiredFlags.byteSize();
    public static final long SIZE$preferredFlags = LAYOUT$preferredFlags.byteSize();
    public static final long SIZE$memoryTypeBits = LAYOUT$memoryTypeBits.byteSize();
    public static final long SIZE$pool = LAYOUT$pool.byteSize();
    public static final long SIZE$pUserData = LAYOUT$pUserData.byteSize();
    public static final long SIZE$priority = LAYOUT$priority.byteSize();
    public static final long SIZE$minAlignment = LAYOUT$minAlignment.byteSize();

    public static final long OFFSET$flags = LAYOUT.byteOffset(PATH$flags);
    public static final long OFFSET$usage = LAYOUT.byteOffset(PATH$usage);
    public static final long OFFSET$requiredFlags = LAYOUT.byteOffset(PATH$requiredFlags);
    public static final long OFFSET$preferredFlags = LAYOUT.byteOffset(PATH$preferredFlags);
    public static final long OFFSET$memoryTypeBits = LAYOUT.byteOffset(PATH$memoryTypeBits);
    public static final long OFFSET$pool = LAYOUT.byteOffset(PATH$pool);
    public static final long OFFSET$pUserData = LAYOUT.byteOffset(PATH$pUserData);
    public static final long OFFSET$priority = LAYOUT.byteOffset(PATH$priority);
    public static final long OFFSET$minAlignment = LAYOUT.byteOffset(PATH$minAlignment);
}
