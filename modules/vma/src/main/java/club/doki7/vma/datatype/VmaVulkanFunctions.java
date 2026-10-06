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

/// Pointers to some Vulkan functions - a subset used by the library.
///
/// Used in VmaAllocatorCreateInfo::pVulkanFunctions.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VmaVulkanFunctions {
///     PFN_vkGetInstanceProcAddr getInstanceProcAddr; // optional // @link substring="getInstanceProcAddr" target="#getInstanceProcAddr"
///     PFN_vkGetDeviceProcAddr getDeviceProcAddr; // optional // @link substring="getDeviceProcAddr" target="#getDeviceProcAddr"
///     PFN_vkGetPhysicalDeviceProperties getPhysicalDeviceProperties; // optional // @link substring="getPhysicalDeviceProperties" target="#getPhysicalDeviceProperties"
///     PFN_vkGetPhysicalDeviceMemoryProperties getPhysicalDeviceMemoryProperties; // optional // @link substring="getPhysicalDeviceMemoryProperties" target="#getPhysicalDeviceMemoryProperties"
///     PFN_vkAllocateMemory allocateMemory; // optional // @link substring="allocateMemory" target="#allocateMemory"
///     PFN_vkFreeMemory freeMemory; // optional // @link substring="freeMemory" target="#freeMemory"
///     PFN_vkMapMemory mapMemory; // optional // @link substring="mapMemory" target="#mapMemory"
///     PFN_vkUnmapMemory unmapMemory; // optional // @link substring="unmapMemory" target="#unmapMemory"
///     PFN_vkFlushMappedMemoryRanges flushMappedMemoryRanges; // optional // @link substring="flushMappedMemoryRanges" target="#flushMappedMemoryRanges"
///     PFN_vkInvalidateMappedMemoryRanges invalidateMappedMemoryRanges; // optional // @link substring="invalidateMappedMemoryRanges" target="#invalidateMappedMemoryRanges"
///     PFN_vkBindBufferMemory bindBufferMemory; // optional // @link substring="bindBufferMemory" target="#bindBufferMemory"
///     PFN_vkBindImageMemory bindImageMemory; // optional // @link substring="bindImageMemory" target="#bindImageMemory"
///     PFN_vkGetBufferMemoryRequirements getBufferMemoryRequirements; // optional // @link substring="getBufferMemoryRequirements" target="#getBufferMemoryRequirements"
///     PFN_vkGetImageMemoryRequirements getImageMemoryRequirements; // optional // @link substring="getImageMemoryRequirements" target="#getImageMemoryRequirements"
///     PFN_vkCreateBuffer createBuffer; // optional // @link substring="createBuffer" target="#createBuffer"
///     PFN_vkDestroyBuffer destroyBuffer; // optional // @link substring="destroyBuffer" target="#destroyBuffer"
///     PFN_vkCreateImage createImage; // optional // @link substring="createImage" target="#createImage"
///     PFN_vkDestroyImage destroyImage; // optional // @link substring="destroyImage" target="#destroyImage"
///     PFN_vkCmdCopyBuffer cmdCopyBuffer; // optional // @link substring="cmdCopyBuffer" target="#cmdCopyBuffer"
///     PFN_vkGetBufferMemoryRequirements2KHR getBufferMemoryRequirements2KHR; // optional // @link substring="getBufferMemoryRequirements2KHR" target="#getBufferMemoryRequirements2KHR"
///     PFN_vkGetImageMemoryRequirements2KHR getImageMemoryRequirements2KHR; // optional // @link substring="getImageMemoryRequirements2KHR" target="#getImageMemoryRequirements2KHR"
///     PFN_vkBindBufferMemory2KHR bindBufferMemory2KHR; // optional // @link substring="bindBufferMemory2KHR" target="#bindBufferMemory2KHR"
///     PFN_vkBindImageMemory2KHR bindImageMemory2KHR; // optional // @link substring="bindImageMemory2KHR" target="#bindImageMemory2KHR"
///     PFN_vkGetPhysicalDeviceMemoryProperties2KHR getPhysicalDeviceMemoryProperties2KHR; // optional // @link substring="getPhysicalDeviceMemoryProperties2KHR" target="#getPhysicalDeviceMemoryProperties2KHR"
///     PFN_vkGetDeviceBufferMemoryRequirementsKHR getDeviceBufferMemoryRequirements; // optional // @link substring="getDeviceBufferMemoryRequirements" target="#getDeviceBufferMemoryRequirements"
///     PFN_vkGetDeviceImageMemoryRequirementsKHR getDeviceImageMemoryRequirements; // optional // @link substring="getDeviceImageMemoryRequirements" target="#getDeviceImageMemoryRequirements"
///     PFN_vkGetMemoryWin32HandleKHR getMemoryWin32HandleKHR; // optional // @link substring="getMemoryWin32HandleKHR" target="#getMemoryWin32HandleKHR"
///     PFN_vkGetPhysicalDeviceProperties2KHR getPhysicalDeviceProperties2KHR; // optional // @link substring="getPhysicalDeviceProperties2KHR" target="#getPhysicalDeviceProperties2KHR"
///     void*[8] reserved;
/// } VmaVulkanFunctions;
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
/// <li>{@link #getInstanceProcAddr} Required when using VMA_DYNAMIC_VULKAN_FUNCTIONS.</li>
/// <li>{@link #getDeviceProcAddr} Required when using VMA_DYNAMIC_VULKAN_FUNCTIONS.</li>
/// <li>{@link #getBufferMemoryRequirements2KHR} Fetch "vkGetBufferMemoryRequirements2" on Vulkan &amp;gt;= 1.1, fetch "vkGetBufferMemoryRequirements2KHR" when using VK_KHR_dedicated_allocation extension.</li>
/// <li>{@link #getImageMemoryRequirements2KHR} Fetch "vkGetImageMemoryRequirements2" on Vulkan &amp;gt;= 1.1, fetch "vkGetImageMemoryRequirements2KHR" when using VK_KHR_dedicated_allocation extension.</li>
/// <li>{@link #bindBufferMemory2KHR} Fetch "vkBindBufferMemory2" on Vulkan &amp;gt;= 1.1, fetch "vkBindBufferMemory2KHR" when using VK_KHR_bind_memory2 extension.</li>
/// <li>{@link #bindImageMemory2KHR} Fetch "vkBindImageMemory2" on Vulkan &amp;gt;= 1.1, fetch "vkBindImageMemory2KHR" when using VK_KHR_bind_memory2 extension.</li>
/// <li>{@link #getPhysicalDeviceMemoryProperties2KHR} Fetch from "vkGetPhysicalDeviceMemoryProperties2" on Vulkan &amp;gt;= 1.1, but you can also fetch it from "vkGetPhysicalDeviceMemoryProperties2KHR" if you enabled extension VK_KHR_get_physical_device_properties2.</li>
/// <li>{@link #getDeviceBufferMemoryRequirements} Fetch from "vkGetDeviceBufferMemoryRequirements" on Vulkan &amp;gt;= 1.3, but you can also fetch it from "vkGetDeviceBufferMemoryRequirementsKHR" if you enabled extension VK_KHR_maintenance4.</li>
/// <li>{@link #getDeviceImageMemoryRequirements} Fetch from "vkGetDeviceImageMemoryRequirements" on Vulkan &amp;gt;= 1.3, but you can also fetch it from "vkGetDeviceImageMemoryRequirementsKHR" if you enabled extension VK_KHR_maintenance4.</li>
/// <li>{@link #getPhysicalDeviceProperties2KHR} Fetch from "vkGetPhysicalDeviceProperties2" on Vulkan &amp;gt;= 1.1, but you can also fetch it from "vkGetPhysicalDeviceProperties2KHR" if you enabled extension VK_KHR_get_physical_device_properties2.</li>
/// </ul>
@ValueBasedCandidate
@UnsafeConstructor
public record VmaVulkanFunctions(@NotNull MemorySegment segment) implements IVmaVulkanFunctions {
    /// Represents a pointer to / an array of null structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VmaVulkanFunctions}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVmaVulkanFunctions to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VmaVulkanFunctions.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVmaVulkanFunctions, Iterable<VmaVulkanFunctions> {
        public long size() {
            return segment.byteSize() / VmaVulkanFunctions.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VmaVulkanFunctions at(long index) {
            return new VmaVulkanFunctions(segment.asSlice(index * VmaVulkanFunctions.BYTES, VmaVulkanFunctions.BYTES));
        }

        public VmaVulkanFunctions.Ptr at(long index, @NotNull Consumer<@NotNull VmaVulkanFunctions> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VmaVulkanFunctions value) {
            MemorySegment s = segment.asSlice(index * VmaVulkanFunctions.BYTES, VmaVulkanFunctions.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VmaVulkanFunctions.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VmaVulkanFunctions.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VmaVulkanFunctions.BYTES,
                (end - start) * VmaVulkanFunctions.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VmaVulkanFunctions.BYTES));
        }

        public VmaVulkanFunctions[] toArray() {
            VmaVulkanFunctions[] ret = new VmaVulkanFunctions[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VmaVulkanFunctions> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VmaVulkanFunctions> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VmaVulkanFunctions.BYTES;
            }

            @Override
            public VmaVulkanFunctions next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VmaVulkanFunctions ret = new VmaVulkanFunctions(segment.asSlice(0, VmaVulkanFunctions.BYTES));
                segment = segment.asSlice(VmaVulkanFunctions.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VmaVulkanFunctions allocate(Arena arena) {
        return new VmaVulkanFunctions(arena.allocate(LAYOUT));
    }

    public static VmaVulkanFunctions.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        return new VmaVulkanFunctions.Ptr(segment);
    }

    public static VmaVulkanFunctions clone(Arena arena, VmaVulkanFunctions src) {
        VmaVulkanFunctions ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public @Pointer(comment="PFN_vkGetInstanceProcAddr") @NotNull MemorySegment getInstanceProcAddr() {
        return segment.get(LAYOUT$getInstanceProcAddr, OFFSET$getInstanceProcAddr);
    }

    public VmaVulkanFunctions getInstanceProcAddr(@Pointer(comment="PFN_vkGetInstanceProcAddr") @NotNull MemorySegment value) {
        segment.set(LAYOUT$getInstanceProcAddr, OFFSET$getInstanceProcAddr, value);
        return this;
    }

    public VmaVulkanFunctions getInstanceProcAddr(@Nullable IPointer pointer) {
        getInstanceProcAddr(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @Pointer(comment="PFN_vkGetDeviceProcAddr") @NotNull MemorySegment getDeviceProcAddr() {
        return segment.get(LAYOUT$getDeviceProcAddr, OFFSET$getDeviceProcAddr);
    }

    public VmaVulkanFunctions getDeviceProcAddr(@Pointer(comment="PFN_vkGetDeviceProcAddr") @NotNull MemorySegment value) {
        segment.set(LAYOUT$getDeviceProcAddr, OFFSET$getDeviceProcAddr, value);
        return this;
    }

    public VmaVulkanFunctions getDeviceProcAddr(@Nullable IPointer pointer) {
        getDeviceProcAddr(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @Pointer(comment="PFN_vkGetPhysicalDeviceProperties") @NotNull MemorySegment getPhysicalDeviceProperties() {
        return segment.get(LAYOUT$getPhysicalDeviceProperties, OFFSET$getPhysicalDeviceProperties);
    }

    public VmaVulkanFunctions getPhysicalDeviceProperties(@Pointer(comment="PFN_vkGetPhysicalDeviceProperties") @NotNull MemorySegment value) {
        segment.set(LAYOUT$getPhysicalDeviceProperties, OFFSET$getPhysicalDeviceProperties, value);
        return this;
    }

    public VmaVulkanFunctions getPhysicalDeviceProperties(@Nullable IPointer pointer) {
        getPhysicalDeviceProperties(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @Pointer(comment="PFN_vkGetPhysicalDeviceMemoryProperties") @NotNull MemorySegment getPhysicalDeviceMemoryProperties() {
        return segment.get(LAYOUT$getPhysicalDeviceMemoryProperties, OFFSET$getPhysicalDeviceMemoryProperties);
    }

    public VmaVulkanFunctions getPhysicalDeviceMemoryProperties(@Pointer(comment="PFN_vkGetPhysicalDeviceMemoryProperties") @NotNull MemorySegment value) {
        segment.set(LAYOUT$getPhysicalDeviceMemoryProperties, OFFSET$getPhysicalDeviceMemoryProperties, value);
        return this;
    }

    public VmaVulkanFunctions getPhysicalDeviceMemoryProperties(@Nullable IPointer pointer) {
        getPhysicalDeviceMemoryProperties(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @Pointer(comment="PFN_vkAllocateMemory") @NotNull MemorySegment allocateMemory() {
        return segment.get(LAYOUT$allocateMemory, OFFSET$allocateMemory);
    }

    public VmaVulkanFunctions allocateMemory(@Pointer(comment="PFN_vkAllocateMemory") @NotNull MemorySegment value) {
        segment.set(LAYOUT$allocateMemory, OFFSET$allocateMemory, value);
        return this;
    }

    public VmaVulkanFunctions allocateMemory(@Nullable IPointer pointer) {
        allocateMemory(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @Pointer(comment="PFN_vkFreeMemory") @NotNull MemorySegment freeMemory() {
        return segment.get(LAYOUT$freeMemory, OFFSET$freeMemory);
    }

    public VmaVulkanFunctions freeMemory(@Pointer(comment="PFN_vkFreeMemory") @NotNull MemorySegment value) {
        segment.set(LAYOUT$freeMemory, OFFSET$freeMemory, value);
        return this;
    }

    public VmaVulkanFunctions freeMemory(@Nullable IPointer pointer) {
        freeMemory(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @Pointer(comment="PFN_vkMapMemory") @NotNull MemorySegment mapMemory() {
        return segment.get(LAYOUT$mapMemory, OFFSET$mapMemory);
    }

    public VmaVulkanFunctions mapMemory(@Pointer(comment="PFN_vkMapMemory") @NotNull MemorySegment value) {
        segment.set(LAYOUT$mapMemory, OFFSET$mapMemory, value);
        return this;
    }

    public VmaVulkanFunctions mapMemory(@Nullable IPointer pointer) {
        mapMemory(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @Pointer(comment="PFN_vkUnmapMemory") @NotNull MemorySegment unmapMemory() {
        return segment.get(LAYOUT$unmapMemory, OFFSET$unmapMemory);
    }

    public VmaVulkanFunctions unmapMemory(@Pointer(comment="PFN_vkUnmapMemory") @NotNull MemorySegment value) {
        segment.set(LAYOUT$unmapMemory, OFFSET$unmapMemory, value);
        return this;
    }

    public VmaVulkanFunctions unmapMemory(@Nullable IPointer pointer) {
        unmapMemory(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @Pointer(comment="PFN_vkFlushMappedMemoryRanges") @NotNull MemorySegment flushMappedMemoryRanges() {
        return segment.get(LAYOUT$flushMappedMemoryRanges, OFFSET$flushMappedMemoryRanges);
    }

    public VmaVulkanFunctions flushMappedMemoryRanges(@Pointer(comment="PFN_vkFlushMappedMemoryRanges") @NotNull MemorySegment value) {
        segment.set(LAYOUT$flushMappedMemoryRanges, OFFSET$flushMappedMemoryRanges, value);
        return this;
    }

    public VmaVulkanFunctions flushMappedMemoryRanges(@Nullable IPointer pointer) {
        flushMappedMemoryRanges(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @Pointer(comment="PFN_vkInvalidateMappedMemoryRanges") @NotNull MemorySegment invalidateMappedMemoryRanges() {
        return segment.get(LAYOUT$invalidateMappedMemoryRanges, OFFSET$invalidateMappedMemoryRanges);
    }

    public VmaVulkanFunctions invalidateMappedMemoryRanges(@Pointer(comment="PFN_vkInvalidateMappedMemoryRanges") @NotNull MemorySegment value) {
        segment.set(LAYOUT$invalidateMappedMemoryRanges, OFFSET$invalidateMappedMemoryRanges, value);
        return this;
    }

    public VmaVulkanFunctions invalidateMappedMemoryRanges(@Nullable IPointer pointer) {
        invalidateMappedMemoryRanges(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @Pointer(comment="PFN_vkBindBufferMemory") @NotNull MemorySegment bindBufferMemory() {
        return segment.get(LAYOUT$bindBufferMemory, OFFSET$bindBufferMemory);
    }

    public VmaVulkanFunctions bindBufferMemory(@Pointer(comment="PFN_vkBindBufferMemory") @NotNull MemorySegment value) {
        segment.set(LAYOUT$bindBufferMemory, OFFSET$bindBufferMemory, value);
        return this;
    }

    public VmaVulkanFunctions bindBufferMemory(@Nullable IPointer pointer) {
        bindBufferMemory(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @Pointer(comment="PFN_vkBindImageMemory") @NotNull MemorySegment bindImageMemory() {
        return segment.get(LAYOUT$bindImageMemory, OFFSET$bindImageMemory);
    }

    public VmaVulkanFunctions bindImageMemory(@Pointer(comment="PFN_vkBindImageMemory") @NotNull MemorySegment value) {
        segment.set(LAYOUT$bindImageMemory, OFFSET$bindImageMemory, value);
        return this;
    }

    public VmaVulkanFunctions bindImageMemory(@Nullable IPointer pointer) {
        bindImageMemory(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @Pointer(comment="PFN_vkGetBufferMemoryRequirements") @NotNull MemorySegment getBufferMemoryRequirements() {
        return segment.get(LAYOUT$getBufferMemoryRequirements, OFFSET$getBufferMemoryRequirements);
    }

    public VmaVulkanFunctions getBufferMemoryRequirements(@Pointer(comment="PFN_vkGetBufferMemoryRequirements") @NotNull MemorySegment value) {
        segment.set(LAYOUT$getBufferMemoryRequirements, OFFSET$getBufferMemoryRequirements, value);
        return this;
    }

    public VmaVulkanFunctions getBufferMemoryRequirements(@Nullable IPointer pointer) {
        getBufferMemoryRequirements(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @Pointer(comment="PFN_vkGetImageMemoryRequirements") @NotNull MemorySegment getImageMemoryRequirements() {
        return segment.get(LAYOUT$getImageMemoryRequirements, OFFSET$getImageMemoryRequirements);
    }

    public VmaVulkanFunctions getImageMemoryRequirements(@Pointer(comment="PFN_vkGetImageMemoryRequirements") @NotNull MemorySegment value) {
        segment.set(LAYOUT$getImageMemoryRequirements, OFFSET$getImageMemoryRequirements, value);
        return this;
    }

    public VmaVulkanFunctions getImageMemoryRequirements(@Nullable IPointer pointer) {
        getImageMemoryRequirements(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @Pointer(comment="PFN_vkCreateBuffer") @NotNull MemorySegment createBuffer() {
        return segment.get(LAYOUT$createBuffer, OFFSET$createBuffer);
    }

    public VmaVulkanFunctions createBuffer(@Pointer(comment="PFN_vkCreateBuffer") @NotNull MemorySegment value) {
        segment.set(LAYOUT$createBuffer, OFFSET$createBuffer, value);
        return this;
    }

    public VmaVulkanFunctions createBuffer(@Nullable IPointer pointer) {
        createBuffer(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @Pointer(comment="PFN_vkDestroyBuffer") @NotNull MemorySegment destroyBuffer() {
        return segment.get(LAYOUT$destroyBuffer, OFFSET$destroyBuffer);
    }

    public VmaVulkanFunctions destroyBuffer(@Pointer(comment="PFN_vkDestroyBuffer") @NotNull MemorySegment value) {
        segment.set(LAYOUT$destroyBuffer, OFFSET$destroyBuffer, value);
        return this;
    }

    public VmaVulkanFunctions destroyBuffer(@Nullable IPointer pointer) {
        destroyBuffer(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @Pointer(comment="PFN_vkCreateImage") @NotNull MemorySegment createImage() {
        return segment.get(LAYOUT$createImage, OFFSET$createImage);
    }

    public VmaVulkanFunctions createImage(@Pointer(comment="PFN_vkCreateImage") @NotNull MemorySegment value) {
        segment.set(LAYOUT$createImage, OFFSET$createImage, value);
        return this;
    }

    public VmaVulkanFunctions createImage(@Nullable IPointer pointer) {
        createImage(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @Pointer(comment="PFN_vkDestroyImage") @NotNull MemorySegment destroyImage() {
        return segment.get(LAYOUT$destroyImage, OFFSET$destroyImage);
    }

    public VmaVulkanFunctions destroyImage(@Pointer(comment="PFN_vkDestroyImage") @NotNull MemorySegment value) {
        segment.set(LAYOUT$destroyImage, OFFSET$destroyImage, value);
        return this;
    }

    public VmaVulkanFunctions destroyImage(@Nullable IPointer pointer) {
        destroyImage(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @Pointer(comment="PFN_vkCmdCopyBuffer") @NotNull MemorySegment cmdCopyBuffer() {
        return segment.get(LAYOUT$cmdCopyBuffer, OFFSET$cmdCopyBuffer);
    }

    public VmaVulkanFunctions cmdCopyBuffer(@Pointer(comment="PFN_vkCmdCopyBuffer") @NotNull MemorySegment value) {
        segment.set(LAYOUT$cmdCopyBuffer, OFFSET$cmdCopyBuffer, value);
        return this;
    }

    public VmaVulkanFunctions cmdCopyBuffer(@Nullable IPointer pointer) {
        cmdCopyBuffer(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @Pointer(comment="PFN_vkGetBufferMemoryRequirements2KHR") @NotNull MemorySegment getBufferMemoryRequirements2KHR() {
        return segment.get(LAYOUT$getBufferMemoryRequirements2KHR, OFFSET$getBufferMemoryRequirements2KHR);
    }

    public VmaVulkanFunctions getBufferMemoryRequirements2KHR(@Pointer(comment="PFN_vkGetBufferMemoryRequirements2KHR") @NotNull MemorySegment value) {
        segment.set(LAYOUT$getBufferMemoryRequirements2KHR, OFFSET$getBufferMemoryRequirements2KHR, value);
        return this;
    }

    public VmaVulkanFunctions getBufferMemoryRequirements2KHR(@Nullable IPointer pointer) {
        getBufferMemoryRequirements2KHR(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @Pointer(comment="PFN_vkGetImageMemoryRequirements2KHR") @NotNull MemorySegment getImageMemoryRequirements2KHR() {
        return segment.get(LAYOUT$getImageMemoryRequirements2KHR, OFFSET$getImageMemoryRequirements2KHR);
    }

    public VmaVulkanFunctions getImageMemoryRequirements2KHR(@Pointer(comment="PFN_vkGetImageMemoryRequirements2KHR") @NotNull MemorySegment value) {
        segment.set(LAYOUT$getImageMemoryRequirements2KHR, OFFSET$getImageMemoryRequirements2KHR, value);
        return this;
    }

    public VmaVulkanFunctions getImageMemoryRequirements2KHR(@Nullable IPointer pointer) {
        getImageMemoryRequirements2KHR(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @Pointer(comment="PFN_vkBindBufferMemory2KHR") @NotNull MemorySegment bindBufferMemory2KHR() {
        return segment.get(LAYOUT$bindBufferMemory2KHR, OFFSET$bindBufferMemory2KHR);
    }

    public VmaVulkanFunctions bindBufferMemory2KHR(@Pointer(comment="PFN_vkBindBufferMemory2KHR") @NotNull MemorySegment value) {
        segment.set(LAYOUT$bindBufferMemory2KHR, OFFSET$bindBufferMemory2KHR, value);
        return this;
    }

    public VmaVulkanFunctions bindBufferMemory2KHR(@Nullable IPointer pointer) {
        bindBufferMemory2KHR(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @Pointer(comment="PFN_vkBindImageMemory2KHR") @NotNull MemorySegment bindImageMemory2KHR() {
        return segment.get(LAYOUT$bindImageMemory2KHR, OFFSET$bindImageMemory2KHR);
    }

    public VmaVulkanFunctions bindImageMemory2KHR(@Pointer(comment="PFN_vkBindImageMemory2KHR") @NotNull MemorySegment value) {
        segment.set(LAYOUT$bindImageMemory2KHR, OFFSET$bindImageMemory2KHR, value);
        return this;
    }

    public VmaVulkanFunctions bindImageMemory2KHR(@Nullable IPointer pointer) {
        bindImageMemory2KHR(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @Pointer(comment="PFN_vkGetPhysicalDeviceMemoryProperties2KHR") @NotNull MemorySegment getPhysicalDeviceMemoryProperties2KHR() {
        return segment.get(LAYOUT$getPhysicalDeviceMemoryProperties2KHR, OFFSET$getPhysicalDeviceMemoryProperties2KHR);
    }

    public VmaVulkanFunctions getPhysicalDeviceMemoryProperties2KHR(@Pointer(comment="PFN_vkGetPhysicalDeviceMemoryProperties2KHR") @NotNull MemorySegment value) {
        segment.set(LAYOUT$getPhysicalDeviceMemoryProperties2KHR, OFFSET$getPhysicalDeviceMemoryProperties2KHR, value);
        return this;
    }

    public VmaVulkanFunctions getPhysicalDeviceMemoryProperties2KHR(@Nullable IPointer pointer) {
        getPhysicalDeviceMemoryProperties2KHR(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @Pointer(comment="PFN_vkGetDeviceBufferMemoryRequirementsKHR") @NotNull MemorySegment getDeviceBufferMemoryRequirements() {
        return segment.get(LAYOUT$getDeviceBufferMemoryRequirements, OFFSET$getDeviceBufferMemoryRequirements);
    }

    public VmaVulkanFunctions getDeviceBufferMemoryRequirements(@Pointer(comment="PFN_vkGetDeviceBufferMemoryRequirementsKHR") @NotNull MemorySegment value) {
        segment.set(LAYOUT$getDeviceBufferMemoryRequirements, OFFSET$getDeviceBufferMemoryRequirements, value);
        return this;
    }

    public VmaVulkanFunctions getDeviceBufferMemoryRequirements(@Nullable IPointer pointer) {
        getDeviceBufferMemoryRequirements(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @Pointer(comment="PFN_vkGetDeviceImageMemoryRequirementsKHR") @NotNull MemorySegment getDeviceImageMemoryRequirements() {
        return segment.get(LAYOUT$getDeviceImageMemoryRequirements, OFFSET$getDeviceImageMemoryRequirements);
    }

    public VmaVulkanFunctions getDeviceImageMemoryRequirements(@Pointer(comment="PFN_vkGetDeviceImageMemoryRequirementsKHR") @NotNull MemorySegment value) {
        segment.set(LAYOUT$getDeviceImageMemoryRequirements, OFFSET$getDeviceImageMemoryRequirements, value);
        return this;
    }

    public VmaVulkanFunctions getDeviceImageMemoryRequirements(@Nullable IPointer pointer) {
        getDeviceImageMemoryRequirements(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @Pointer(comment="PFN_vkGetMemoryWin32HandleKHR") @NotNull MemorySegment getMemoryWin32HandleKHR() {
        return segment.get(LAYOUT$getMemoryWin32HandleKHR, OFFSET$getMemoryWin32HandleKHR);
    }

    public VmaVulkanFunctions getMemoryWin32HandleKHR(@Pointer(comment="PFN_vkGetMemoryWin32HandleKHR") @NotNull MemorySegment value) {
        segment.set(LAYOUT$getMemoryWin32HandleKHR, OFFSET$getMemoryWin32HandleKHR, value);
        return this;
    }

    public VmaVulkanFunctions getMemoryWin32HandleKHR(@Nullable IPointer pointer) {
        getMemoryWin32HandleKHR(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @Pointer(comment="PFN_vkGetPhysicalDeviceProperties2KHR") @NotNull MemorySegment getPhysicalDeviceProperties2KHR() {
        return segment.get(LAYOUT$getPhysicalDeviceProperties2KHR, OFFSET$getPhysicalDeviceProperties2KHR);
    }

    public VmaVulkanFunctions getPhysicalDeviceProperties2KHR(@Pointer(comment="PFN_vkGetPhysicalDeviceProperties2KHR") @NotNull MemorySegment value) {
        segment.set(LAYOUT$getPhysicalDeviceProperties2KHR, OFFSET$getPhysicalDeviceProperties2KHR, value);
        return this;
    }

    public VmaVulkanFunctions getPhysicalDeviceProperties2KHR(@Nullable IPointer pointer) {
        getPhysicalDeviceProperties2KHR(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }


    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.ADDRESS.withName("getInstanceProcAddr"),
        ValueLayout.ADDRESS.withName("getDeviceProcAddr"),
        ValueLayout.ADDRESS.withName("getPhysicalDeviceProperties"),
        ValueLayout.ADDRESS.withName("getPhysicalDeviceMemoryProperties"),
        ValueLayout.ADDRESS.withName("allocateMemory"),
        ValueLayout.ADDRESS.withName("freeMemory"),
        ValueLayout.ADDRESS.withName("mapMemory"),
        ValueLayout.ADDRESS.withName("unmapMemory"),
        ValueLayout.ADDRESS.withName("flushMappedMemoryRanges"),
        ValueLayout.ADDRESS.withName("invalidateMappedMemoryRanges"),
        ValueLayout.ADDRESS.withName("bindBufferMemory"),
        ValueLayout.ADDRESS.withName("bindImageMemory"),
        ValueLayout.ADDRESS.withName("getBufferMemoryRequirements"),
        ValueLayout.ADDRESS.withName("getImageMemoryRequirements"),
        ValueLayout.ADDRESS.withName("createBuffer"),
        ValueLayout.ADDRESS.withName("destroyBuffer"),
        ValueLayout.ADDRESS.withName("createImage"),
        ValueLayout.ADDRESS.withName("destroyImage"),
        ValueLayout.ADDRESS.withName("cmdCopyBuffer"),
        ValueLayout.ADDRESS.withName("getBufferMemoryRequirements2KHR"),
        ValueLayout.ADDRESS.withName("getImageMemoryRequirements2KHR"),
        ValueLayout.ADDRESS.withName("bindBufferMemory2KHR"),
        ValueLayout.ADDRESS.withName("bindImageMemory2KHR"),
        ValueLayout.ADDRESS.withName("getPhysicalDeviceMemoryProperties2KHR"),
        ValueLayout.ADDRESS.withName("getDeviceBufferMemoryRequirements"),
        ValueLayout.ADDRESS.withName("getDeviceImageMemoryRequirements"),
        ValueLayout.ADDRESS.withName("getMemoryWin32HandleKHR"),
        ValueLayout.ADDRESS.withName("getPhysicalDeviceProperties2KHR"),
        MemoryLayout.sequenceLayout(8, ValueLayout.ADDRESS).withName("reserved")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$getInstanceProcAddr = PathElement.groupElement("getInstanceProcAddr");
    public static final PathElement PATH$getDeviceProcAddr = PathElement.groupElement("getDeviceProcAddr");
    public static final PathElement PATH$getPhysicalDeviceProperties = PathElement.groupElement("getPhysicalDeviceProperties");
    public static final PathElement PATH$getPhysicalDeviceMemoryProperties = PathElement.groupElement("getPhysicalDeviceMemoryProperties");
    public static final PathElement PATH$allocateMemory = PathElement.groupElement("allocateMemory");
    public static final PathElement PATH$freeMemory = PathElement.groupElement("freeMemory");
    public static final PathElement PATH$mapMemory = PathElement.groupElement("mapMemory");
    public static final PathElement PATH$unmapMemory = PathElement.groupElement("unmapMemory");
    public static final PathElement PATH$flushMappedMemoryRanges = PathElement.groupElement("flushMappedMemoryRanges");
    public static final PathElement PATH$invalidateMappedMemoryRanges = PathElement.groupElement("invalidateMappedMemoryRanges");
    public static final PathElement PATH$bindBufferMemory = PathElement.groupElement("bindBufferMemory");
    public static final PathElement PATH$bindImageMemory = PathElement.groupElement("bindImageMemory");
    public static final PathElement PATH$getBufferMemoryRequirements = PathElement.groupElement("getBufferMemoryRequirements");
    public static final PathElement PATH$getImageMemoryRequirements = PathElement.groupElement("getImageMemoryRequirements");
    public static final PathElement PATH$createBuffer = PathElement.groupElement("createBuffer");
    public static final PathElement PATH$destroyBuffer = PathElement.groupElement("destroyBuffer");
    public static final PathElement PATH$createImage = PathElement.groupElement("createImage");
    public static final PathElement PATH$destroyImage = PathElement.groupElement("destroyImage");
    public static final PathElement PATH$cmdCopyBuffer = PathElement.groupElement("cmdCopyBuffer");
    public static final PathElement PATH$getBufferMemoryRequirements2KHR = PathElement.groupElement("getBufferMemoryRequirements2KHR");
    public static final PathElement PATH$getImageMemoryRequirements2KHR = PathElement.groupElement("getImageMemoryRequirements2KHR");
    public static final PathElement PATH$bindBufferMemory2KHR = PathElement.groupElement("bindBufferMemory2KHR");
    public static final PathElement PATH$bindImageMemory2KHR = PathElement.groupElement("bindImageMemory2KHR");
    public static final PathElement PATH$getPhysicalDeviceMemoryProperties2KHR = PathElement.groupElement("getPhysicalDeviceMemoryProperties2KHR");
    public static final PathElement PATH$getDeviceBufferMemoryRequirements = PathElement.groupElement("getDeviceBufferMemoryRequirements");
    public static final PathElement PATH$getDeviceImageMemoryRequirements = PathElement.groupElement("getDeviceImageMemoryRequirements");
    public static final PathElement PATH$getMemoryWin32HandleKHR = PathElement.groupElement("getMemoryWin32HandleKHR");
    public static final PathElement PATH$getPhysicalDeviceProperties2KHR = PathElement.groupElement("getPhysicalDeviceProperties2KHR");

    public static final AddressLayout LAYOUT$getInstanceProcAddr = (AddressLayout) LAYOUT.select(PATH$getInstanceProcAddr);
    public static final AddressLayout LAYOUT$getDeviceProcAddr = (AddressLayout) LAYOUT.select(PATH$getDeviceProcAddr);
    public static final AddressLayout LAYOUT$getPhysicalDeviceProperties = (AddressLayout) LAYOUT.select(PATH$getPhysicalDeviceProperties);
    public static final AddressLayout LAYOUT$getPhysicalDeviceMemoryProperties = (AddressLayout) LAYOUT.select(PATH$getPhysicalDeviceMemoryProperties);
    public static final AddressLayout LAYOUT$allocateMemory = (AddressLayout) LAYOUT.select(PATH$allocateMemory);
    public static final AddressLayout LAYOUT$freeMemory = (AddressLayout) LAYOUT.select(PATH$freeMemory);
    public static final AddressLayout LAYOUT$mapMemory = (AddressLayout) LAYOUT.select(PATH$mapMemory);
    public static final AddressLayout LAYOUT$unmapMemory = (AddressLayout) LAYOUT.select(PATH$unmapMemory);
    public static final AddressLayout LAYOUT$flushMappedMemoryRanges = (AddressLayout) LAYOUT.select(PATH$flushMappedMemoryRanges);
    public static final AddressLayout LAYOUT$invalidateMappedMemoryRanges = (AddressLayout) LAYOUT.select(PATH$invalidateMappedMemoryRanges);
    public static final AddressLayout LAYOUT$bindBufferMemory = (AddressLayout) LAYOUT.select(PATH$bindBufferMemory);
    public static final AddressLayout LAYOUT$bindImageMemory = (AddressLayout) LAYOUT.select(PATH$bindImageMemory);
    public static final AddressLayout LAYOUT$getBufferMemoryRequirements = (AddressLayout) LAYOUT.select(PATH$getBufferMemoryRequirements);
    public static final AddressLayout LAYOUT$getImageMemoryRequirements = (AddressLayout) LAYOUT.select(PATH$getImageMemoryRequirements);
    public static final AddressLayout LAYOUT$createBuffer = (AddressLayout) LAYOUT.select(PATH$createBuffer);
    public static final AddressLayout LAYOUT$destroyBuffer = (AddressLayout) LAYOUT.select(PATH$destroyBuffer);
    public static final AddressLayout LAYOUT$createImage = (AddressLayout) LAYOUT.select(PATH$createImage);
    public static final AddressLayout LAYOUT$destroyImage = (AddressLayout) LAYOUT.select(PATH$destroyImage);
    public static final AddressLayout LAYOUT$cmdCopyBuffer = (AddressLayout) LAYOUT.select(PATH$cmdCopyBuffer);
    public static final AddressLayout LAYOUT$getBufferMemoryRequirements2KHR = (AddressLayout) LAYOUT.select(PATH$getBufferMemoryRequirements2KHR);
    public static final AddressLayout LAYOUT$getImageMemoryRequirements2KHR = (AddressLayout) LAYOUT.select(PATH$getImageMemoryRequirements2KHR);
    public static final AddressLayout LAYOUT$bindBufferMemory2KHR = (AddressLayout) LAYOUT.select(PATH$bindBufferMemory2KHR);
    public static final AddressLayout LAYOUT$bindImageMemory2KHR = (AddressLayout) LAYOUT.select(PATH$bindImageMemory2KHR);
    public static final AddressLayout LAYOUT$getPhysicalDeviceMemoryProperties2KHR = (AddressLayout) LAYOUT.select(PATH$getPhysicalDeviceMemoryProperties2KHR);
    public static final AddressLayout LAYOUT$getDeviceBufferMemoryRequirements = (AddressLayout) LAYOUT.select(PATH$getDeviceBufferMemoryRequirements);
    public static final AddressLayout LAYOUT$getDeviceImageMemoryRequirements = (AddressLayout) LAYOUT.select(PATH$getDeviceImageMemoryRequirements);
    public static final AddressLayout LAYOUT$getMemoryWin32HandleKHR = (AddressLayout) LAYOUT.select(PATH$getMemoryWin32HandleKHR);
    public static final AddressLayout LAYOUT$getPhysicalDeviceProperties2KHR = (AddressLayout) LAYOUT.select(PATH$getPhysicalDeviceProperties2KHR);

    public static final long SIZE$getInstanceProcAddr = LAYOUT$getInstanceProcAddr.byteSize();
    public static final long SIZE$getDeviceProcAddr = LAYOUT$getDeviceProcAddr.byteSize();
    public static final long SIZE$getPhysicalDeviceProperties = LAYOUT$getPhysicalDeviceProperties.byteSize();
    public static final long SIZE$getPhysicalDeviceMemoryProperties = LAYOUT$getPhysicalDeviceMemoryProperties.byteSize();
    public static final long SIZE$allocateMemory = LAYOUT$allocateMemory.byteSize();
    public static final long SIZE$freeMemory = LAYOUT$freeMemory.byteSize();
    public static final long SIZE$mapMemory = LAYOUT$mapMemory.byteSize();
    public static final long SIZE$unmapMemory = LAYOUT$unmapMemory.byteSize();
    public static final long SIZE$flushMappedMemoryRanges = LAYOUT$flushMappedMemoryRanges.byteSize();
    public static final long SIZE$invalidateMappedMemoryRanges = LAYOUT$invalidateMappedMemoryRanges.byteSize();
    public static final long SIZE$bindBufferMemory = LAYOUT$bindBufferMemory.byteSize();
    public static final long SIZE$bindImageMemory = LAYOUT$bindImageMemory.byteSize();
    public static final long SIZE$getBufferMemoryRequirements = LAYOUT$getBufferMemoryRequirements.byteSize();
    public static final long SIZE$getImageMemoryRequirements = LAYOUT$getImageMemoryRequirements.byteSize();
    public static final long SIZE$createBuffer = LAYOUT$createBuffer.byteSize();
    public static final long SIZE$destroyBuffer = LAYOUT$destroyBuffer.byteSize();
    public static final long SIZE$createImage = LAYOUT$createImage.byteSize();
    public static final long SIZE$destroyImage = LAYOUT$destroyImage.byteSize();
    public static final long SIZE$cmdCopyBuffer = LAYOUT$cmdCopyBuffer.byteSize();
    public static final long SIZE$getBufferMemoryRequirements2KHR = LAYOUT$getBufferMemoryRequirements2KHR.byteSize();
    public static final long SIZE$getImageMemoryRequirements2KHR = LAYOUT$getImageMemoryRequirements2KHR.byteSize();
    public static final long SIZE$bindBufferMemory2KHR = LAYOUT$bindBufferMemory2KHR.byteSize();
    public static final long SIZE$bindImageMemory2KHR = LAYOUT$bindImageMemory2KHR.byteSize();
    public static final long SIZE$getPhysicalDeviceMemoryProperties2KHR = LAYOUT$getPhysicalDeviceMemoryProperties2KHR.byteSize();
    public static final long SIZE$getDeviceBufferMemoryRequirements = LAYOUT$getDeviceBufferMemoryRequirements.byteSize();
    public static final long SIZE$getDeviceImageMemoryRequirements = LAYOUT$getDeviceImageMemoryRequirements.byteSize();
    public static final long SIZE$getMemoryWin32HandleKHR = LAYOUT$getMemoryWin32HandleKHR.byteSize();
    public static final long SIZE$getPhysicalDeviceProperties2KHR = LAYOUT$getPhysicalDeviceProperties2KHR.byteSize();

    public static final long OFFSET$getInstanceProcAddr = LAYOUT.byteOffset(PATH$getInstanceProcAddr);
    public static final long OFFSET$getDeviceProcAddr = LAYOUT.byteOffset(PATH$getDeviceProcAddr);
    public static final long OFFSET$getPhysicalDeviceProperties = LAYOUT.byteOffset(PATH$getPhysicalDeviceProperties);
    public static final long OFFSET$getPhysicalDeviceMemoryProperties = LAYOUT.byteOffset(PATH$getPhysicalDeviceMemoryProperties);
    public static final long OFFSET$allocateMemory = LAYOUT.byteOffset(PATH$allocateMemory);
    public static final long OFFSET$freeMemory = LAYOUT.byteOffset(PATH$freeMemory);
    public static final long OFFSET$mapMemory = LAYOUT.byteOffset(PATH$mapMemory);
    public static final long OFFSET$unmapMemory = LAYOUT.byteOffset(PATH$unmapMemory);
    public static final long OFFSET$flushMappedMemoryRanges = LAYOUT.byteOffset(PATH$flushMappedMemoryRanges);
    public static final long OFFSET$invalidateMappedMemoryRanges = LAYOUT.byteOffset(PATH$invalidateMappedMemoryRanges);
    public static final long OFFSET$bindBufferMemory = LAYOUT.byteOffset(PATH$bindBufferMemory);
    public static final long OFFSET$bindImageMemory = LAYOUT.byteOffset(PATH$bindImageMemory);
    public static final long OFFSET$getBufferMemoryRequirements = LAYOUT.byteOffset(PATH$getBufferMemoryRequirements);
    public static final long OFFSET$getImageMemoryRequirements = LAYOUT.byteOffset(PATH$getImageMemoryRequirements);
    public static final long OFFSET$createBuffer = LAYOUT.byteOffset(PATH$createBuffer);
    public static final long OFFSET$destroyBuffer = LAYOUT.byteOffset(PATH$destroyBuffer);
    public static final long OFFSET$createImage = LAYOUT.byteOffset(PATH$createImage);
    public static final long OFFSET$destroyImage = LAYOUT.byteOffset(PATH$destroyImage);
    public static final long OFFSET$cmdCopyBuffer = LAYOUT.byteOffset(PATH$cmdCopyBuffer);
    public static final long OFFSET$getBufferMemoryRequirements2KHR = LAYOUT.byteOffset(PATH$getBufferMemoryRequirements2KHR);
    public static final long OFFSET$getImageMemoryRequirements2KHR = LAYOUT.byteOffset(PATH$getImageMemoryRequirements2KHR);
    public static final long OFFSET$bindBufferMemory2KHR = LAYOUT.byteOffset(PATH$bindBufferMemory2KHR);
    public static final long OFFSET$bindImageMemory2KHR = LAYOUT.byteOffset(PATH$bindImageMemory2KHR);
    public static final long OFFSET$getPhysicalDeviceMemoryProperties2KHR = LAYOUT.byteOffset(PATH$getPhysicalDeviceMemoryProperties2KHR);
    public static final long OFFSET$getDeviceBufferMemoryRequirements = LAYOUT.byteOffset(PATH$getDeviceBufferMemoryRequirements);
    public static final long OFFSET$getDeviceImageMemoryRequirements = LAYOUT.byteOffset(PATH$getDeviceImageMemoryRequirements);
    public static final long OFFSET$getMemoryWin32HandleKHR = LAYOUT.byteOffset(PATH$getMemoryWin32HandleKHR);
    public static final long OFFSET$getPhysicalDeviceProperties2KHR = LAYOUT.byteOffset(PATH$getPhysicalDeviceProperties2KHR);
}
