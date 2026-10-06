package club.doki7.vma;

import java.lang.foreign.*;
import java.lang.invoke.MethodHandle;
import java.util.Objects;

import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.NotNull;
import club.doki7.ffm.NativeLayout;
import club.doki7.ffm.RawFunctionLoader;
import club.doki7.ffm.annotation.*;
import club.doki7.ffm.ptr.*;
import club.doki7.vma.bitmask.*;
import club.doki7.vma.datatype.*;
import club.doki7.vma.enumtype.*;
import club.doki7.vma.handle.*;
import static club.doki7.vma.VMAFunctionTypes.*;
import club.doki7.vulkan.bitmask.*;
import club.doki7.vulkan.datatype.*;
import club.doki7.vulkan.enumtype.*;
import club.doki7.vulkan.handle.*;

public final class VMA {
    public VMA(RawFunctionLoader loader) {
        SEGMENT$vmaImportVulkanFunctionsFromVolk = loader.apply("vmaImportVulkanFunctionsFromVolk");
        HANDLE$vmaImportVulkanFunctionsFromVolk = RawFunctionLoader.link(SEGMENT$vmaImportVulkanFunctionsFromVolk, Descriptors.DESCRIPTOR$vmaImportVulkanFunctionsFromVolk);
        SEGMENT$vmaCreateAllocator = loader.apply("vmaCreateAllocator");
        HANDLE$vmaCreateAllocator = RawFunctionLoader.link(SEGMENT$vmaCreateAllocator, Descriptors.DESCRIPTOR$vmaCreateAllocator);
        SEGMENT$vmaDestroyAllocator = loader.apply("vmaDestroyAllocator");
        HANDLE$vmaDestroyAllocator = RawFunctionLoader.link(SEGMENT$vmaDestroyAllocator, Descriptors.DESCRIPTOR$vmaDestroyAllocator);
        SEGMENT$vmaGetAllocatorInfo = loader.apply("vmaGetAllocatorInfo");
        HANDLE$vmaGetAllocatorInfo = RawFunctionLoader.link(SEGMENT$vmaGetAllocatorInfo, Descriptors.DESCRIPTOR$vmaGetAllocatorInfo);
        SEGMENT$vmaGetPhysicalDeviceProperties = loader.apply("vmaGetPhysicalDeviceProperties");
        HANDLE$vmaGetPhysicalDeviceProperties = RawFunctionLoader.link(SEGMENT$vmaGetPhysicalDeviceProperties, Descriptors.DESCRIPTOR$vmaGetPhysicalDeviceProperties);
        SEGMENT$vmaGetMemoryProperties = loader.apply("vmaGetMemoryProperties");
        HANDLE$vmaGetMemoryProperties = RawFunctionLoader.link(SEGMENT$vmaGetMemoryProperties, Descriptors.DESCRIPTOR$vmaGetMemoryProperties);
        SEGMENT$vmaGetMemoryTypeProperties = loader.apply("vmaGetMemoryTypeProperties");
        HANDLE$vmaGetMemoryTypeProperties = RawFunctionLoader.link(SEGMENT$vmaGetMemoryTypeProperties, Descriptors.DESCRIPTOR$vmaGetMemoryTypeProperties);
        SEGMENT$vmaSetCurrentFrameIndex = loader.apply("vmaSetCurrentFrameIndex");
        HANDLE$vmaSetCurrentFrameIndex = RawFunctionLoader.link(SEGMENT$vmaSetCurrentFrameIndex, Descriptors.DESCRIPTOR$vmaSetCurrentFrameIndex);
        SEGMENT$vmaCalculateStatistics = loader.apply("vmaCalculateStatistics");
        HANDLE$vmaCalculateStatistics = RawFunctionLoader.link(SEGMENT$vmaCalculateStatistics, Descriptors.DESCRIPTOR$vmaCalculateStatistics);
        SEGMENT$vmaGetHeapBudgets = loader.apply("vmaGetHeapBudgets");
        HANDLE$vmaGetHeapBudgets = RawFunctionLoader.link(SEGMENT$vmaGetHeapBudgets, Descriptors.DESCRIPTOR$vmaGetHeapBudgets);
        SEGMENT$vmaFindMemoryTypeIndex = loader.apply("vmaFindMemoryTypeIndex");
        HANDLE$vmaFindMemoryTypeIndex = RawFunctionLoader.link(SEGMENT$vmaFindMemoryTypeIndex, Descriptors.DESCRIPTOR$vmaFindMemoryTypeIndex);
        SEGMENT$vmaFindMemoryTypeIndexForBufferInfo = loader.apply("vmaFindMemoryTypeIndexForBufferInfo");
        HANDLE$vmaFindMemoryTypeIndexForBufferInfo = RawFunctionLoader.link(SEGMENT$vmaFindMemoryTypeIndexForBufferInfo, Descriptors.DESCRIPTOR$vmaFindMemoryTypeIndexForBufferInfo);
        SEGMENT$vmaFindMemoryTypeIndexForImageInfo = loader.apply("vmaFindMemoryTypeIndexForImageInfo");
        HANDLE$vmaFindMemoryTypeIndexForImageInfo = RawFunctionLoader.link(SEGMENT$vmaFindMemoryTypeIndexForImageInfo, Descriptors.DESCRIPTOR$vmaFindMemoryTypeIndexForImageInfo);
        SEGMENT$vmaCreatePool = loader.apply("vmaCreatePool");
        HANDLE$vmaCreatePool = RawFunctionLoader.link(SEGMENT$vmaCreatePool, Descriptors.DESCRIPTOR$vmaCreatePool);
        SEGMENT$vmaDestroyPool = loader.apply("vmaDestroyPool");
        HANDLE$vmaDestroyPool = RawFunctionLoader.link(SEGMENT$vmaDestroyPool, Descriptors.DESCRIPTOR$vmaDestroyPool);
        SEGMENT$vmaGetPoolStatistics = loader.apply("vmaGetPoolStatistics");
        HANDLE$vmaGetPoolStatistics = RawFunctionLoader.link(SEGMENT$vmaGetPoolStatistics, Descriptors.DESCRIPTOR$vmaGetPoolStatistics);
        SEGMENT$vmaCalculatePoolStatistics = loader.apply("vmaCalculatePoolStatistics");
        HANDLE$vmaCalculatePoolStatistics = RawFunctionLoader.link(SEGMENT$vmaCalculatePoolStatistics, Descriptors.DESCRIPTOR$vmaCalculatePoolStatistics);
        SEGMENT$vmaCheckPoolCorruption = loader.apply("vmaCheckPoolCorruption");
        HANDLE$vmaCheckPoolCorruption = RawFunctionLoader.link(SEGMENT$vmaCheckPoolCorruption, Descriptors.DESCRIPTOR$vmaCheckPoolCorruption);
        SEGMENT$vmaGetPoolName = loader.apply("vmaGetPoolName");
        HANDLE$vmaGetPoolName = RawFunctionLoader.link(SEGMENT$vmaGetPoolName, Descriptors.DESCRIPTOR$vmaGetPoolName);
        SEGMENT$vmaSetPoolName = loader.apply("vmaSetPoolName");
        HANDLE$vmaSetPoolName = RawFunctionLoader.link(SEGMENT$vmaSetPoolName, Descriptors.DESCRIPTOR$vmaSetPoolName);
        SEGMENT$vmaAllocateMemory = loader.apply("vmaAllocateMemory");
        HANDLE$vmaAllocateMemory = RawFunctionLoader.link(SEGMENT$vmaAllocateMemory, Descriptors.DESCRIPTOR$vmaAllocateMemory);
        SEGMENT$vmaAllocateDedicatedMemory = loader.apply("vmaAllocateDedicatedMemory");
        HANDLE$vmaAllocateDedicatedMemory = RawFunctionLoader.link(SEGMENT$vmaAllocateDedicatedMemory, Descriptors.DESCRIPTOR$vmaAllocateDedicatedMemory);
        SEGMENT$vmaAllocateMemoryPages = loader.apply("vmaAllocateMemoryPages");
        HANDLE$vmaAllocateMemoryPages = RawFunctionLoader.link(SEGMENT$vmaAllocateMemoryPages, Descriptors.DESCRIPTOR$vmaAllocateMemoryPages);
        SEGMENT$vmaAllocateMemoryForBuffer = loader.apply("vmaAllocateMemoryForBuffer");
        HANDLE$vmaAllocateMemoryForBuffer = RawFunctionLoader.link(SEGMENT$vmaAllocateMemoryForBuffer, Descriptors.DESCRIPTOR$vmaAllocateMemoryForBuffer);
        SEGMENT$vmaAllocateMemoryForImage = loader.apply("vmaAllocateMemoryForImage");
        HANDLE$vmaAllocateMemoryForImage = RawFunctionLoader.link(SEGMENT$vmaAllocateMemoryForImage, Descriptors.DESCRIPTOR$vmaAllocateMemoryForImage);
        SEGMENT$vmaFreeMemory = loader.apply("vmaFreeMemory");
        HANDLE$vmaFreeMemory = RawFunctionLoader.link(SEGMENT$vmaFreeMemory, Descriptors.DESCRIPTOR$vmaFreeMemory);
        SEGMENT$vmaFreeMemoryPages = loader.apply("vmaFreeMemoryPages");
        HANDLE$vmaFreeMemoryPages = RawFunctionLoader.link(SEGMENT$vmaFreeMemoryPages, Descriptors.DESCRIPTOR$vmaFreeMemoryPages);
        SEGMENT$vmaGetAllocationInfo = loader.apply("vmaGetAllocationInfo");
        HANDLE$vmaGetAllocationInfo = RawFunctionLoader.link(SEGMENT$vmaGetAllocationInfo, Descriptors.DESCRIPTOR$vmaGetAllocationInfo);
        SEGMENT$vmaGetAllocationInfo2 = loader.apply("vmaGetAllocationInfo2");
        HANDLE$vmaGetAllocationInfo2 = RawFunctionLoader.link(SEGMENT$vmaGetAllocationInfo2, Descriptors.DESCRIPTOR$vmaGetAllocationInfo2);
        SEGMENT$vmaSetAllocationUserData = loader.apply("vmaSetAllocationUserData");
        HANDLE$vmaSetAllocationUserData = RawFunctionLoader.link(SEGMENT$vmaSetAllocationUserData, Descriptors.DESCRIPTOR$vmaSetAllocationUserData);
        SEGMENT$vmaSetAllocationName = loader.apply("vmaSetAllocationName");
        HANDLE$vmaSetAllocationName = RawFunctionLoader.link(SEGMENT$vmaSetAllocationName, Descriptors.DESCRIPTOR$vmaSetAllocationName);
        SEGMENT$vmaGetAllocationMemoryProperties = loader.apply("vmaGetAllocationMemoryProperties");
        HANDLE$vmaGetAllocationMemoryProperties = RawFunctionLoader.link(SEGMENT$vmaGetAllocationMemoryProperties, Descriptors.DESCRIPTOR$vmaGetAllocationMemoryProperties);
        SEGMENT$vmaGetMemoryWin32Handle = loader.apply("vmaGetMemoryWin32Handle");
        HANDLE$vmaGetMemoryWin32Handle = RawFunctionLoader.link(SEGMENT$vmaGetMemoryWin32Handle, Descriptors.DESCRIPTOR$vmaGetMemoryWin32Handle);
        SEGMENT$vmaGetMemoryWin32Handle2 = loader.apply("vmaGetMemoryWin32Handle2");
        HANDLE$vmaGetMemoryWin32Handle2 = RawFunctionLoader.link(SEGMENT$vmaGetMemoryWin32Handle2, Descriptors.DESCRIPTOR$vmaGetMemoryWin32Handle2);
        SEGMENT$vmaMapMemory = loader.apply("vmaMapMemory");
        HANDLE$vmaMapMemory = RawFunctionLoader.link(SEGMENT$vmaMapMemory, Descriptors.DESCRIPTOR$vmaMapMemory);
        SEGMENT$vmaUnmapMemory = loader.apply("vmaUnmapMemory");
        HANDLE$vmaUnmapMemory = RawFunctionLoader.link(SEGMENT$vmaUnmapMemory, Descriptors.DESCRIPTOR$vmaUnmapMemory);
        SEGMENT$vmaFlushAllocation = loader.apply("vmaFlushAllocation");
        HANDLE$vmaFlushAllocation = RawFunctionLoader.link(SEGMENT$vmaFlushAllocation, Descriptors.DESCRIPTOR$vmaFlushAllocation);
        SEGMENT$vmaInvalidateAllocation = loader.apply("vmaInvalidateAllocation");
        HANDLE$vmaInvalidateAllocation = RawFunctionLoader.link(SEGMENT$vmaInvalidateAllocation, Descriptors.DESCRIPTOR$vmaInvalidateAllocation);
        SEGMENT$vmaFlushAllocations = loader.apply("vmaFlushAllocations");
        HANDLE$vmaFlushAllocations = RawFunctionLoader.link(SEGMENT$vmaFlushAllocations, Descriptors.DESCRIPTOR$vmaFlushAllocations);
        SEGMENT$vmaInvalidateAllocations = loader.apply("vmaInvalidateAllocations");
        HANDLE$vmaInvalidateAllocations = RawFunctionLoader.link(SEGMENT$vmaInvalidateAllocations, Descriptors.DESCRIPTOR$vmaInvalidateAllocations);
        SEGMENT$vmaCopyMemoryToAllocation = loader.apply("vmaCopyMemoryToAllocation");
        HANDLE$vmaCopyMemoryToAllocation = RawFunctionLoader.link(SEGMENT$vmaCopyMemoryToAllocation, Descriptors.DESCRIPTOR$vmaCopyMemoryToAllocation);
        SEGMENT$vmaCopyAllocationToMemory = loader.apply("vmaCopyAllocationToMemory");
        HANDLE$vmaCopyAllocationToMemory = RawFunctionLoader.link(SEGMENT$vmaCopyAllocationToMemory, Descriptors.DESCRIPTOR$vmaCopyAllocationToMemory);
        SEGMENT$vmaCheckCorruption = loader.apply("vmaCheckCorruption");
        HANDLE$vmaCheckCorruption = RawFunctionLoader.link(SEGMENT$vmaCheckCorruption, Descriptors.DESCRIPTOR$vmaCheckCorruption);
        SEGMENT$vmaBeginDefragmentation = loader.apply("vmaBeginDefragmentation");
        HANDLE$vmaBeginDefragmentation = RawFunctionLoader.link(SEGMENT$vmaBeginDefragmentation, Descriptors.DESCRIPTOR$vmaBeginDefragmentation);
        SEGMENT$vmaEndDefragmentation = loader.apply("vmaEndDefragmentation");
        HANDLE$vmaEndDefragmentation = RawFunctionLoader.link(SEGMENT$vmaEndDefragmentation, Descriptors.DESCRIPTOR$vmaEndDefragmentation);
        SEGMENT$vmaBeginDefragmentationPass = loader.apply("vmaBeginDefragmentationPass");
        HANDLE$vmaBeginDefragmentationPass = RawFunctionLoader.link(SEGMENT$vmaBeginDefragmentationPass, Descriptors.DESCRIPTOR$vmaBeginDefragmentationPass);
        SEGMENT$vmaEndDefragmentationPass = loader.apply("vmaEndDefragmentationPass");
        HANDLE$vmaEndDefragmentationPass = RawFunctionLoader.link(SEGMENT$vmaEndDefragmentationPass, Descriptors.DESCRIPTOR$vmaEndDefragmentationPass);
        SEGMENT$vmaBindBufferMemory = loader.apply("vmaBindBufferMemory");
        HANDLE$vmaBindBufferMemory = RawFunctionLoader.link(SEGMENT$vmaBindBufferMemory, Descriptors.DESCRIPTOR$vmaBindBufferMemory);
        SEGMENT$vmaBindBufferMemory2 = loader.apply("vmaBindBufferMemory2");
        HANDLE$vmaBindBufferMemory2 = RawFunctionLoader.link(SEGMENT$vmaBindBufferMemory2, Descriptors.DESCRIPTOR$vmaBindBufferMemory2);
        SEGMENT$vmaBindImageMemory = loader.apply("vmaBindImageMemory");
        HANDLE$vmaBindImageMemory = RawFunctionLoader.link(SEGMENT$vmaBindImageMemory, Descriptors.DESCRIPTOR$vmaBindImageMemory);
        SEGMENT$vmaBindImageMemory2 = loader.apply("vmaBindImageMemory2");
        HANDLE$vmaBindImageMemory2 = RawFunctionLoader.link(SEGMENT$vmaBindImageMemory2, Descriptors.DESCRIPTOR$vmaBindImageMemory2);
        SEGMENT$vmaCreateBuffer = loader.apply("vmaCreateBuffer");
        HANDLE$vmaCreateBuffer = RawFunctionLoader.link(SEGMENT$vmaCreateBuffer, Descriptors.DESCRIPTOR$vmaCreateBuffer);
        SEGMENT$vmaCreateBufferWithAlignment = loader.apply("vmaCreateBufferWithAlignment");
        HANDLE$vmaCreateBufferWithAlignment = RawFunctionLoader.link(SEGMENT$vmaCreateBufferWithAlignment, Descriptors.DESCRIPTOR$vmaCreateBufferWithAlignment);
        SEGMENT$vmaCreateDedicatedBuffer = loader.apply("vmaCreateDedicatedBuffer");
        HANDLE$vmaCreateDedicatedBuffer = RawFunctionLoader.link(SEGMENT$vmaCreateDedicatedBuffer, Descriptors.DESCRIPTOR$vmaCreateDedicatedBuffer);
        SEGMENT$vmaCreateAliasingBuffer = loader.apply("vmaCreateAliasingBuffer");
        HANDLE$vmaCreateAliasingBuffer = RawFunctionLoader.link(SEGMENT$vmaCreateAliasingBuffer, Descriptors.DESCRIPTOR$vmaCreateAliasingBuffer);
        SEGMENT$vmaCreateAliasingBuffer2 = loader.apply("vmaCreateAliasingBuffer2");
        HANDLE$vmaCreateAliasingBuffer2 = RawFunctionLoader.link(SEGMENT$vmaCreateAliasingBuffer2, Descriptors.DESCRIPTOR$vmaCreateAliasingBuffer2);
        SEGMENT$vmaDestroyBuffer = loader.apply("vmaDestroyBuffer");
        HANDLE$vmaDestroyBuffer = RawFunctionLoader.link(SEGMENT$vmaDestroyBuffer, Descriptors.DESCRIPTOR$vmaDestroyBuffer);
        SEGMENT$vmaCreateImage = loader.apply("vmaCreateImage");
        HANDLE$vmaCreateImage = RawFunctionLoader.link(SEGMENT$vmaCreateImage, Descriptors.DESCRIPTOR$vmaCreateImage);
        SEGMENT$vmaCreateDedicatedImage = loader.apply("vmaCreateDedicatedImage");
        HANDLE$vmaCreateDedicatedImage = RawFunctionLoader.link(SEGMENT$vmaCreateDedicatedImage, Descriptors.DESCRIPTOR$vmaCreateDedicatedImage);
        SEGMENT$vmaCreateAliasingImage = loader.apply("vmaCreateAliasingImage");
        HANDLE$vmaCreateAliasingImage = RawFunctionLoader.link(SEGMENT$vmaCreateAliasingImage, Descriptors.DESCRIPTOR$vmaCreateAliasingImage);
        SEGMENT$vmaCreateAliasingImage2 = loader.apply("vmaCreateAliasingImage2");
        HANDLE$vmaCreateAliasingImage2 = RawFunctionLoader.link(SEGMENT$vmaCreateAliasingImage2, Descriptors.DESCRIPTOR$vmaCreateAliasingImage2);
        SEGMENT$vmaDestroyImage = loader.apply("vmaDestroyImage");
        HANDLE$vmaDestroyImage = RawFunctionLoader.link(SEGMENT$vmaDestroyImage, Descriptors.DESCRIPTOR$vmaDestroyImage);
        SEGMENT$vmaCreateVirtualBlock = loader.apply("vmaCreateVirtualBlock");
        HANDLE$vmaCreateVirtualBlock = RawFunctionLoader.link(SEGMENT$vmaCreateVirtualBlock, Descriptors.DESCRIPTOR$vmaCreateVirtualBlock);
        SEGMENT$vmaDestroyVirtualBlock = loader.apply("vmaDestroyVirtualBlock");
        HANDLE$vmaDestroyVirtualBlock = RawFunctionLoader.link(SEGMENT$vmaDestroyVirtualBlock, Descriptors.DESCRIPTOR$vmaDestroyVirtualBlock);
        SEGMENT$vmaIsVirtualBlockEmpty = loader.apply("vmaIsVirtualBlockEmpty");
        HANDLE$vmaIsVirtualBlockEmpty = RawFunctionLoader.link(SEGMENT$vmaIsVirtualBlockEmpty, Descriptors.DESCRIPTOR$vmaIsVirtualBlockEmpty);
        SEGMENT$vmaGetVirtualAllocationInfo = loader.apply("vmaGetVirtualAllocationInfo");
        HANDLE$vmaGetVirtualAllocationInfo = RawFunctionLoader.link(SEGMENT$vmaGetVirtualAllocationInfo, Descriptors.DESCRIPTOR$vmaGetVirtualAllocationInfo);
        SEGMENT$vmaVirtualAllocate = loader.apply("vmaVirtualAllocate");
        HANDLE$vmaVirtualAllocate = RawFunctionLoader.link(SEGMENT$vmaVirtualAllocate, Descriptors.DESCRIPTOR$vmaVirtualAllocate);
        SEGMENT$vmaVirtualFree = loader.apply("vmaVirtualFree");
        HANDLE$vmaVirtualFree = RawFunctionLoader.link(SEGMENT$vmaVirtualFree, Descriptors.DESCRIPTOR$vmaVirtualFree);
        SEGMENT$vmaClearVirtualBlock = loader.apply("vmaClearVirtualBlock");
        HANDLE$vmaClearVirtualBlock = RawFunctionLoader.link(SEGMENT$vmaClearVirtualBlock, Descriptors.DESCRIPTOR$vmaClearVirtualBlock);
        SEGMENT$vmaSetVirtualAllocationUserData = loader.apply("vmaSetVirtualAllocationUserData");
        HANDLE$vmaSetVirtualAllocationUserData = RawFunctionLoader.link(SEGMENT$vmaSetVirtualAllocationUserData, Descriptors.DESCRIPTOR$vmaSetVirtualAllocationUserData);
        SEGMENT$vmaGetVirtualBlockStatistics = loader.apply("vmaGetVirtualBlockStatistics");
        HANDLE$vmaGetVirtualBlockStatistics = RawFunctionLoader.link(SEGMENT$vmaGetVirtualBlockStatistics, Descriptors.DESCRIPTOR$vmaGetVirtualBlockStatistics);
        SEGMENT$vmaCalculateVirtualBlockStatistics = loader.apply("vmaCalculateVirtualBlockStatistics");
        HANDLE$vmaCalculateVirtualBlockStatistics = RawFunctionLoader.link(SEGMENT$vmaCalculateVirtualBlockStatistics, Descriptors.DESCRIPTOR$vmaCalculateVirtualBlockStatistics);
        SEGMENT$vmaBuildVirtualBlockStatsString = loader.apply("vmaBuildVirtualBlockStatsString");
        HANDLE$vmaBuildVirtualBlockStatsString = RawFunctionLoader.link(SEGMENT$vmaBuildVirtualBlockStatsString, Descriptors.DESCRIPTOR$vmaBuildVirtualBlockStatsString);
        SEGMENT$vmaFreeVirtualBlockStatsString = loader.apply("vmaFreeVirtualBlockStatsString");
        HANDLE$vmaFreeVirtualBlockStatsString = RawFunctionLoader.link(SEGMENT$vmaFreeVirtualBlockStatsString, Descriptors.DESCRIPTOR$vmaFreeVirtualBlockStatsString);
        SEGMENT$vmaBuildStatsString = loader.apply("vmaBuildStatsString");
        HANDLE$vmaBuildStatsString = RawFunctionLoader.link(SEGMENT$vmaBuildStatsString, Descriptors.DESCRIPTOR$vmaBuildStatsString);
        SEGMENT$vmaFreeStatsString = loader.apply("vmaFreeStatsString");
        HANDLE$vmaFreeStatsString = RawFunctionLoader.link(SEGMENT$vmaFreeStatsString, Descriptors.DESCRIPTOR$vmaFreeStatsString);
    }

    // region command wrappers

    /// Fully initializes `pDstVulkanFunctions` structure with Vulkan functions needed by VMA
    /// using [volk library](https://github.com/zeux/volk).
    ///
    /// This function is defined in VMA header only if "volk.h" was included before it.
    ///
    /// To use this function properly:
    ///
    /// -# Initialize volk and Vulkan:
    /// -# Call `volkInitialize()`
    /// -# Create `VkInstance` object
    /// -# Call `volkLoadInstance()`
    /// -# Create `VkDevice` object
    /// -# Call `volkLoadDevice()`
    /// -# Fill in structure #VmaAllocatorCreateInfo, especially members:
    /// - VmaAllocatorCreateInfo::device
    /// - VmaAllocatorCreateInfo::vulkanApiVersion
    /// - VmaAllocatorCreateInfo::flags - set appropriate flags for the Vulkan extensions you enabled
    /// -# Create an instance of the #VmaVulkanFunctions structure.
    /// -# Call vmaImportVulkanFunctionsFromVolk().
    /// Parameter `pAllocatorCreateInfo` is read to find out which functions should be fetched for
    /// appropriate Vulkan version and extensions.
    /// Parameter `pDstVulkanFunctions` is filled with those function pointers, or null if not applicable.
    /// -# Attach the #VmaVulkanFunctions structure to VmaAllocatorCreateInfo::pVulkanFunctions.
    /// -# Call vmaCreateAllocator() to create the #VmaAllocator object.
    ///
    /// Example:
    ///
    /// {@snippet lang=c:
    /// VmaAllocatorCreateInfo allocatorCreateInfo = {};
    /// allocatorCreateInfo.physicalDevice = myPhysicalDevice;
    /// allocatorCreateInfo.device = myDevice;
    /// allocatorCreateInfo.instance = myInstance;
    /// allocatorCreateInfo.vulkanApiVersion = VK_API_VERSION_1_3;
    /// allocatorCreateInfo.flags = VMA_ALLOCATOR_CREATE_EXT_MEMORY_BUDGET_BIT |
    /// VMA_ALLOCATOR_CREATE_EXT_MEMORY_PRIORITY_BIT |
    /// VMA_ALLOCATOR_CREATE_KHR_EXTERNAL_MEMORY_WIN32_BIT;
    ///
    /// VmaVulkanFunctions vulkanFunctions;
    /// VkResult res = vmaImportVulkanFunctionsFromVolk(&amp;allocatorCreateInfo, &amp;vulkanFunctions);
    /// // Check res...
    /// allocatorCreateInfo.pVulkanFunctions = &amp;vulkanFunctions;
    ///
    /// VmaAllocator allocator;
    /// res = vmaCreateAllocator(&amp;allocatorCreateInfo, &amp;allocator);
    /// // Check res...
    /// }
    ///
    /// Internally in this function, pointers to functions related to the entire Vulkan instance are fetched using global function definitions,
    /// while pointers to functions related to the Vulkan device are fetched using `volkLoadDeviceTable()` for given `pAllocatorCreateInfo-&amp;gt;device`.
    ///
    public @EnumType(VkResult.class) int importVulkanFunctionsFromVolk(
        @Pointer IVmaAllocatorCreateInfo pAllocatorCreateInfo,
        @Pointer IVmaVulkanFunctions pDstVulkanFunctions
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$vmaImportVulkanFunctionsFromVolk);
        try {
            return (int) hFunction.invokeExact(
                pAllocatorCreateInfo.segment(),
                pDstVulkanFunctions.segment()
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// Creates {@code VmaAllocator} object.
    ///
    public @EnumType(VkResult.class) int createAllocator(
        @Pointer IVmaAllocatorCreateInfo pCreateInfo,
        @Pointer VmaAllocator.Ptr pAllocator
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$vmaCreateAllocator);
        try {
            return (int) hFunction.invokeExact(
                pCreateInfo.segment(),
                pAllocator.segment()
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// Destroys allocator object.
    ///
    public void destroyAllocator(
        @Nullable VmaAllocator allocator
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$vmaDestroyAllocator);
        try {
            hFunction.invokeExact(
                (MemorySegment) (allocator != null ? allocator.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// Returns information about existing {@code VmaAllocator} object - handle to Vulkan device etc.
    ///
    /// It might be useful if you want to keep just the {@code VmaAllocator} handle and fetch other required handles to
    /// `VkPhysicalDevice`, `VkDevice` etc. every time using this function.
    ///
    public void getAllocatorInfo(
        VmaAllocator allocator,
        @Pointer IVmaAllocatorInfo pAllocatorInfo
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$vmaGetAllocatorInfo);
        try {
            hFunction.invokeExact(
                allocator.segment(),
                pAllocatorInfo.segment()
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// PhysicalDeviceProperties are fetched from physicalDevice by the allocator.
    /// You can access it here, without fetching it again on your own.
    ///
    public void getPhysicalDeviceProperties(
        VmaAllocator allocator,
        PointerPtr ppPhysicalDeviceProperties
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$vmaGetPhysicalDeviceProperties);
        try {
            hFunction.invokeExact(
                allocator.segment(),
                ppPhysicalDeviceProperties.segment()
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// PhysicalDeviceMemoryProperties are fetched from physicalDevice by the allocator.
    /// You can access it here, without fetching it again on your own.
    ///
    public void getMemoryProperties(
        VmaAllocator allocator,
        PointerPtr ppPhysicalDeviceMemoryProperties
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$vmaGetMemoryProperties);
        try {
            hFunction.invokeExact(
                allocator.segment(),
                ppPhysicalDeviceMemoryProperties.segment()
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// Given Memory Type Index, returns Property Flags of this memory type.
    ///
    /// This is just a convenience function. Same information can be obtained using
    /// vmaGetMemoryProperties().
    ///
    public void getMemoryTypeProperties(
        VmaAllocator allocator,
        @Unsigned int memoryTypeIndex,
        @Bitmask(VkMemoryPropertyFlags.class) IntPtr pFlags
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$vmaGetMemoryTypeProperties);
        try {
            hFunction.invokeExact(
                allocator.segment(),
                memoryTypeIndex,
                pFlags.segment()
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// Sets index of the current frame.
    ///
    public void setCurrentFrameIndex(
        VmaAllocator allocator,
        @Unsigned int frameIndex
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$vmaSetCurrentFrameIndex);
        try {
            hFunction.invokeExact(
                allocator.segment(),
                frameIndex
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// Retrieves statistics from current state of the Allocator.
    ///
    /// This function is called "calculate" not "get" because it has to traverse all
    /// internal data structures, so it may be quite slow. Use it for debugging purposes.
    /// For faster but more brief statistics suitable to be called every frame or every allocation,
    /// use vmaGetHeapBudgets().
    ///
    /// Note that when using allocator from multiple threads, returned information may immediately
    /// become outdated.
    ///
    public void calculateStatistics(
        VmaAllocator allocator,
        @Pointer IVmaTotalStatistics pStats
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$vmaCalculateStatistics);
        try {
            hFunction.invokeExact(
                allocator.segment(),
                pStats.segment()
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// Retrieves information about current memory usage and budget for all memory heaps.
    ///
    /// This function is called "get" not "calculate" because it is very fast, suitable to be called
    /// every frame or every allocation. For more detailed statistics use vmaCalculateStatistics().
    ///
    /// Note that when using allocator from multiple threads, returned information may immediately
    /// become outdated.
    ///
    /// @param allocator
    /// @param pBudgets Must point to array with number of elements at least equal to number of memory heaps in physical device used.
    public void getHeapBudgets(
        VmaAllocator allocator,
        @Pointer IVmaBudget pBudgets
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$vmaGetHeapBudgets);
        try {
            hFunction.invokeExact(
                allocator.segment(),
                pBudgets.segment()
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// Helps to find `memoryTypeIndex`, given `memoryTypeBits` and {@code VmaAllocationCreateInfo}.
    ///
    /// This algorithm tries to find a memory type that:
    ///
    /// - Is allowed by `memoryTypeBits`.
    /// - Contains all the flags from `pAllocationCreateInfo-&amp;gt;requiredFlags`.
    /// - Matches intended usage.
    /// - Has as many flags from `pAllocationCreateInfo-&amp;gt;preferredFlags` as possible.
    ///
    /// from this function or any other allocating function probably means that your
    /// device doesn't support any memory type with requested features for the specific
    /// type of resource you want to use it for. Please check parameters of your
    /// resource, like image layout (`OPTIMAL` versus `LINEAR`) or mip level count.
    ///
    /// @return Returns `VK_ERROR_FEATURE_NOT_PRESENT` if not found. Receiving such result
    public @EnumType(VkResult.class) int findMemoryTypeIndex(
        VmaAllocator allocator,
        @Unsigned int memoryTypeBits,
        @Pointer IVmaAllocationCreateInfo pAllocationCreateInfo,
        @Unsigned IntPtr pMemoryTypeIndex
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$vmaFindMemoryTypeIndex);
        try {
            return (int) hFunction.invokeExact(
                allocator.segment(),
                memoryTypeBits,
                pAllocationCreateInfo.segment(),
                pMemoryTypeIndex.segment()
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// Helps to find `memoryTypeIndex`, given `VkBufferCreateInfo` and {@code VmaAllocationCreateInfo}.
    ///
    /// It can be useful e.g. to determine value to be used as VmaPoolCreateInfo::memoryTypeIndex.
    /// It may need to internally create a temporary, dummy buffer that never has memory bound.
    ///
    public @EnumType(VkResult.class) int findMemoryTypeIndexForBufferInfo(
        VmaAllocator allocator,
        @Pointer IVkBufferCreateInfo pBufferCreateInfo,
        @Pointer IVmaAllocationCreateInfo pAllocationCreateInfo,
        @Unsigned IntPtr pMemoryTypeIndex
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$vmaFindMemoryTypeIndexForBufferInfo);
        try {
            return (int) hFunction.invokeExact(
                allocator.segment(),
                pBufferCreateInfo.segment(),
                pAllocationCreateInfo.segment(),
                pMemoryTypeIndex.segment()
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// Helps to find `memoryTypeIndex`, given `VkImageCreateInfo` and {@code VmaAllocationCreateInfo}.
    ///
    /// It can be useful e.g. to determine value to be used as VmaPoolCreateInfo::memoryTypeIndex.
    /// It may need to internally create a temporary, dummy image that never has memory bound.
    ///
    public @EnumType(VkResult.class) int findMemoryTypeIndexForImageInfo(
        VmaAllocator allocator,
        @Pointer IVkImageCreateInfo pImageCreateInfo,
        @Pointer IVmaAllocationCreateInfo pAllocationCreateInfo,
        @Unsigned IntPtr pMemoryTypeIndex
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$vmaFindMemoryTypeIndexForImageInfo);
        try {
            return (int) hFunction.invokeExact(
                allocator.segment(),
                pImageCreateInfo.segment(),
                pAllocationCreateInfo.segment(),
                pMemoryTypeIndex.segment()
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// Allocates Vulkan device memory and creates {@code VmaPool} object.
    ///
    /// @param allocator Allocator object.
    /// @param pCreateInfo Parameters of pool to create.
    /// @param pPool Handle to created pool.
    public @EnumType(VkResult.class) int createPool(
        VmaAllocator allocator,
        @Pointer IVmaPoolCreateInfo pCreateInfo,
        @Pointer VmaPool.Ptr pPool
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$vmaCreatePool);
        try {
            return (int) hFunction.invokeExact(
                allocator.segment(),
                pCreateInfo.segment(),
                pPool.segment()
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// Destroys {@code VmaPool} object and frees Vulkan device memory.
    ///
    public void destroyPool(
        VmaAllocator allocator,
        @Nullable VmaPool pool
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$vmaDestroyPool);
        try {
            hFunction.invokeExact(
                allocator.segment(),
                (MemorySegment) (pool != null ? pool.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// Retrieves statistics of existing {@code VmaPool} object.
    ///
    /// Note that when using the pool from multiple threads, returned information may immediately
    /// become outdated.
    ///
    /// @param allocator Allocator object.
    /// @param pool Pool object.
    /// @param pPoolStats Statistics of specified pool.
    public void getPoolStatistics(
        VmaAllocator allocator,
        VmaPool pool,
        @Pointer IVmaStatistics pPoolStats
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$vmaGetPoolStatistics);
        try {
            hFunction.invokeExact(
                allocator.segment(),
                pool.segment(),
                pPoolStats.segment()
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// Retrieves detailed statistics of existing {@code VmaPool} object.
    ///
    /// @param allocator Allocator object.
    /// @param pool Pool object.
    /// @param pPoolStats Statistics of specified pool.
    public void calculatePoolStatistics(
        VmaAllocator allocator,
        VmaPool pool,
        @Pointer IVmaDetailedStatistics pPoolStats
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$vmaCalculatePoolStatistics);
        try {
            hFunction.invokeExact(
                allocator.segment(),
                pool.segment(),
                pPoolStats.segment()
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// Checks magic number in margins around all allocations in given memory pool in search for corruptions.
    ///
    /// Corruption detection is enabled only when `VMA_DEBUG_DETECT_CORRUPTION` macro is defined to nonzero,
    /// `VMA_DEBUG_MARGIN` is defined to nonzero and the pool is created in memory type that is
    /// `HOST_VISIBLE` and `HOST_COHERENT`. For more information, see [Corruption detection](@ref debugging_memory_usage_corruption_detection).
    ///
    /// Possible return values:
    ///
    /// - `VK_ERROR_FEATURE_NOT_PRESENT` - corruption detection is not enabled for specified pool.
    /// - `VK_SUCCESS` - corruption detection has been performed and succeeded.
    /// - `VK_ERROR_UNKNOWN` - corruption detection has been performed and found memory corruptions around one of the allocations.
    /// `VMA_ASSERT` is also fired in that case.
    /// - Other value: Error returned by Vulkan, e.g. memory mapping failure.
    ///
    public @EnumType(VkResult.class) int checkPoolCorruption(
        VmaAllocator allocator,
        VmaPool pool
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$vmaCheckPoolCorruption);
        try {
            return (int) hFunction.invokeExact(
                allocator.segment(),
                pool.segment()
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// Retrieves name of a custom pool.
    ///
    /// After the call `ppName` is either null or points to an internally-owned null-terminated string
    /// containing name of the pool that was previously set. The pointer becomes invalid when the pool is
    /// destroyed or its name is changed using vmaSetPoolName().
    ///
    public void getPoolName(
        VmaAllocator allocator,
        VmaPool pool,
        PointerPtr ppName
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$vmaGetPoolName);
        try {
            hFunction.invokeExact(
                allocator.segment(),
                pool.segment(),
                ppName.segment()
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// Sets name of a custom pool.
    ///
    /// `pName` can be either null or pointer to a null-terminated string with new name for the pool.
    /// Function makes internal copy of the string, so it can be changed or freed immediately after this call.
    ///
    public void setPoolName(
        VmaAllocator allocator,
        VmaPool pool,
        @Nullable BytePtr pName
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$vmaSetPoolName);
        try {
            hFunction.invokeExact(
                allocator.segment(),
                pool.segment(),
                (MemorySegment) (pName != null ? pName.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// General purpose memory allocation.
    ///
    /// The function creates a {@code VmaAllocation} object without creating a buffer or an image together with it.
    ///
    /// - It is recommended to use vmaAllocateMemoryForBuffer(), vmaAllocateMemoryForImage(),
    /// vmaCreateBuffer(), vmaCreateImage() instead whenever possible.
    /// - You can also create a buffer or an image later in an existing allocation using
    /// vmaCreateAliasingBuffer2(), vmaCreateAliasingImage2().
    /// - You can also create a buffer or an image on your own and bind it to an existing allocation
    /// using vmaBindBufferMemory2(), vmaBindImageMemory2().
    ///
    /// You must free the returned allocation object using vmaFreeMemory() or vmaFreeMemoryPages().
    ///
    /// There is also extended version of this function: vmaAllocateDedicatedMemory()
    /// that offers additional parameter `pMemoryAllocateNext`.
    ///
    /// @param allocator The main allocator object.
    /// @param pVkMemoryRequirements Requirements for the allocated memory.
    /// @param pCreateInfo Allocation creation parameters.
    /// @param pAllocation Handle to allocated memory.
    /// @param pAllocationInfo Optional, can be null. Information about allocated memory. It can be also fetched later using vmaGetAllocationInfo().
    public @EnumType(VkResult.class) int allocateMemory(
        VmaAllocator allocator,
        @Pointer IVkMemoryRequirements pVkMemoryRequirements,
        @Pointer IVmaAllocationCreateInfo pCreateInfo,
        @Pointer VmaAllocation.Ptr pAllocation,
        @Nullable @Pointer IVmaAllocationInfo pAllocationInfo
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$vmaAllocateMemory);
        try {
            return (int) hFunction.invokeExact(
                allocator.segment(),
                pVkMemoryRequirements.segment(),
                pCreateInfo.segment(),
                pAllocation.segment(),
                (MemorySegment) (pAllocationInfo != null ? pAllocationInfo.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// General purpose allocation of a dedicated memory.
    ///
    /// This function is similar vmaAllocateMemory(), but
    /// it always allocates dedicated memory - flag {@code VMA_ALLOCATION_CREATE_DEDICATED_MEMORY_BIT} is implied.
    /// It offers additional parameter `pMemoryAllocateNext`,
    /// which can be used to attach `pNext` chain to the `VkMemoryAllocateInfo` structure.
    /// It can be useful for importing external memory. For more information, see  other_api_interop.
    ///
    public @EnumType(VkResult.class) int allocateDedicatedMemory(
        VmaAllocator allocator,
        @Pointer IVkMemoryRequirements pVkMemoryRequirements,
        @Pointer IVmaAllocationCreateInfo pCreateInfo,
        @Pointer(comment="void*") @NotNull MemorySegment pMemoryAllocateNext,
        @Pointer VmaAllocation.Ptr pAllocation,
        @Nullable @Pointer IVmaAllocationInfo pAllocationInfo
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$vmaAllocateDedicatedMemory);
        try {
            return (int) hFunction.invokeExact(
                allocator.segment(),
                pVkMemoryRequirements.segment(),
                pCreateInfo.segment(),
                pMemoryAllocateNext,
                pAllocation.segment(),
                (MemorySegment) (pAllocationInfo != null ? pAllocationInfo.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// General purpose memory allocation for multiple allocation objects at once.
    ///
    /// You should free the memory using vmaFreeMemory() or vmaFreeMemoryPages().
    ///
    /// Word "pages" is just a suggestion to use this function to allocate pieces of memory needed for sparse binding.
    /// It is just a general purpose allocation function able to make multiple allocations at once.
    /// It may be internally optimized to be more efficient than calling vmaAllocateMemory() `allocationCount` times.
    ///
    /// All allocations are made using same parameters. All of them are created out of the same memory pool and type.
    /// If any allocation fails, all allocations already made within this function call are also freed, so that when
    /// returned result is not `VK_SUCCESS`, `pAllocation` array is always entirely filled with `VK_NULL_HANDLE`.
    ///
    /// @param allocator Allocator object.
    /// @param pVkMemoryRequirements Memory requirements for each allocation.
    /// @param pCreateInfo Creation parameters for each allocation.
    /// @param allocationCount Number of allocations to make.
    /// @param pAllocations Pointer to array that will be filled with handles to created allocations.
    /// @param pAllocationInfo Optional. Pointer to array that will be filled with parameters of created allocations.
    public @EnumType(VkResult.class) int allocateMemoryPages(
        VmaAllocator allocator,
        @Pointer IVkMemoryRequirements pVkMemoryRequirements,
        @Pointer IVmaAllocationCreateInfo pCreateInfo,
        long allocationCount,
        @Pointer VmaAllocation.Ptr pAllocations,
        @Nullable @Pointer IVmaAllocationInfo pAllocationInfo
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$vmaAllocateMemoryPages);
        try {
            return (int) hFunction.invokeExact(
                allocator.segment(),
                pVkMemoryRequirements.segment(),
                pCreateInfo.segment(),
                MemorySegment.ofAddress(allocationCount),
                pAllocations.segment(),
                (MemorySegment) (pAllocationInfo != null ? pAllocationInfo.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// Allocates memory suitable for given `VkBuffer`.
    ///
    /// It only creates {@code VmaAllocation}. To bind the memory to the buffer, use vmaBindBufferMemory().
    ///
    /// This is a special-purpose function. In most cases you should use vmaCreateBuffer().
    ///
    /// You must free the allocation using vmaFreeMemory() when no longer needed.
    ///
    /// @param allocator
    /// @param buffer
    /// @param pCreateInfo
    /// @param pAllocation Handle to allocated memory.
    /// @param pAllocationInfo Optional. Information about allocated memory. It can be later fetched using function vmaGetAllocationInfo().
    public @EnumType(VkResult.class) int allocateMemoryForBuffer(
        VmaAllocator allocator,
        VkBuffer buffer,
        @Pointer IVmaAllocationCreateInfo pCreateInfo,
        @Pointer VmaAllocation.Ptr pAllocation,
        @Nullable @Pointer IVmaAllocationInfo pAllocationInfo
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$vmaAllocateMemoryForBuffer);
        try {
            return (int) hFunction.invokeExact(
                allocator.segment(),
                buffer.segment(),
                pCreateInfo.segment(),
                pAllocation.segment(),
                (MemorySegment) (pAllocationInfo != null ? pAllocationInfo.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// Allocates memory suitable for given `VkImage`.
    ///
    /// It only creates {@code VmaAllocation}. To bind the memory to the buffer, use vmaBindImageMemory().
    ///
    /// This is a special-purpose function. In most cases you should use vmaCreateImage().
    ///
    /// You must free the allocation using vmaFreeMemory() when no longer needed.
    ///
    /// @param allocator
    /// @param image
    /// @param pCreateInfo
    /// @param pAllocation Handle to allocated memory.
    /// @param pAllocationInfo Optional. Information about allocated memory. It can be later fetched using function vmaGetAllocationInfo().
    public @EnumType(VkResult.class) int allocateMemoryForImage(
        VmaAllocator allocator,
        VkImage image,
        @Pointer IVmaAllocationCreateInfo pCreateInfo,
        @Pointer VmaAllocation.Ptr pAllocation,
        @Nullable @Pointer IVmaAllocationInfo pAllocationInfo
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$vmaAllocateMemoryForImage);
        try {
            return (int) hFunction.invokeExact(
                allocator.segment(),
                image.segment(),
                pCreateInfo.segment(),
                pAllocation.segment(),
                (MemorySegment) (pAllocationInfo != null ? pAllocationInfo.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// Frees memory previously allocated using vmaAllocateMemory(), vmaAllocateMemoryForBuffer(), or vmaAllocateMemoryForImage().
    ///
    /// Passing `VK_NULL_HANDLE` as `allocation` is valid. Such function call is just skipped.
    ///
    public void freeMemory(
        VmaAllocator allocator,
        @Nullable VmaAllocation allocation
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$vmaFreeMemory);
        try {
            hFunction.invokeExact(
                allocator.segment(),
                (MemorySegment) (allocation != null ? allocation.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// Frees memory and destroys multiple allocations.
    ///
    /// Word "pages" is just a suggestion to use this function to free pieces of memory used for sparse binding.
    /// It is just a general purpose function to free memory and destroy allocations made using e.g. vmaAllocateMemory(),
    /// vmaAllocateMemoryPages() and other functions.
    /// It may be internally optimized to be more efficient than calling vmaFreeMemory() `allocationCount` times.
    ///
    /// Allocations in `pAllocations` array can come from any memory pools and types.
    /// Passing `VK_NULL_HANDLE` as elements of `pAllocations` array is valid. Such entries are just skipped.
    ///
    public void freeMemoryPages(
        VmaAllocator allocator,
        long allocationCount,
        @Pointer VmaAllocation.Ptr pAllocations
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$vmaFreeMemoryPages);
        try {
            hFunction.invokeExact(
                allocator.segment(),
                MemorySegment.ofAddress(allocationCount),
                pAllocations.segment()
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// Returns current information about specified allocation.
    ///
    /// Current parameters of given allocation are returned in `pAllocationInfo`.
    ///
    /// Although this function doesn't lock any mutex, so it should be quite efficient,
    /// you should avoid calling it too often.
    /// You can retrieve same VmaAllocationInfo structure while creating your resource, from function
    /// vmaCreateBuffer(), vmaCreateImage(). You can remember it if you are sure parameters don't change
    /// (e.g. due to defragmentation).
    ///
    /// There is also a new function vmaGetAllocationInfo2() that offers extended information
    /// about the allocation, returned using new structure {@code VmaAllocationInfo2}.
    ///
    public void getAllocationInfo(
        VmaAllocator allocator,
        VmaAllocation allocation,
        @Pointer IVmaAllocationInfo pAllocationInfo
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$vmaGetAllocationInfo);
        try {
            hFunction.invokeExact(
                allocator.segment(),
                allocation.segment(),
                pAllocationInfo.segment()
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// Returns extended information about specified allocation.
    ///
    /// Current parameters of given allocation are returned in `pAllocationInfo`.
    /// Extended parameters in structure {@code VmaAllocationInfo2} include memory block size
    /// and a flag telling whether the allocation has dedicated memory.
    /// It can be useful e.g. for interop with OpenGL.
    ///
    public void getAllocationInfo2(
        VmaAllocator allocator,
        VmaAllocation allocation,
        @Pointer IVmaAllocationInfo2 pAllocationInfo
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$vmaGetAllocationInfo2);
        try {
            hFunction.invokeExact(
                allocator.segment(),
                allocation.segment(),
                pAllocationInfo.segment()
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// Sets pUserData in given allocation to new value.
    ///
    /// The value of pointer `pUserData` is copied to allocation's `pUserData`.
    /// It is opaque, so you can use it however you want - e.g.
    /// as a pointer, ordinal number or some handle to you own data.
    ///
    public void setAllocationUserData(
        VmaAllocator allocator,
        VmaAllocation allocation,
        @Pointer(comment="void*") @NotNull MemorySegment pUserData
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$vmaSetAllocationUserData);
        try {
            hFunction.invokeExact(
                allocator.segment(),
                allocation.segment(),
                pUserData
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// Sets pName in given allocation to new value.
    ///
    /// `pName` must be either null, or pointer to a null-terminated string. The function
    /// makes local copy of the string and sets it as allocation's `pName`. String
    /// passed as pName doesn't need to be valid for whole lifetime of the allocation -
    /// you can free it after this call. String previously pointed by allocation's
    /// `pName` is freed from memory.
    ///
    public void setAllocationName(
        VmaAllocator allocator,
        VmaAllocation allocation,
        @Nullable BytePtr pName
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$vmaSetAllocationName);
        try {
            hFunction.invokeExact(
                allocator.segment(),
                allocation.segment(),
                (MemorySegment) (pName != null ? pName.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// Given an allocation, returns Property Flags of its memory type.
    ///
    /// This is just a convenience function. Same information can be obtained using
    /// vmaGetAllocationInfo() + vmaGetMemoryProperties().
    ///
    public void getAllocationMemoryProperties(
        VmaAllocator allocator,
        VmaAllocation allocation,
        @Bitmask(VkMemoryPropertyFlags.class) IntPtr pFlags
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$vmaGetAllocationMemoryProperties);
        try {
            hFunction.invokeExact(
                allocator.segment(),
                allocation.segment(),
                pFlags.segment()
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// Given an allocation, returns Win32 handle that may be imported by other processes or APIs.
    ///
    /// handle for the current process.
    ///
    /// The function fills `pHandle` with handle that can be used in target process.
    /// The handle is fetched using function `vkGetMemoryWin32HandleKHR`.
    ///
    /// Each call to this function creates a new handle that must be closed using:
    ///
    /// {@snippet lang=c:
    /// CloseHandle(handle);
    /// }
    ///
    /// You can close it any time, before or after destroying the allocation object.
    /// It is reference-counted internally by Windows.
    ///
    /// Note the handle is returned for the entire `VkDeviceMemory` block that the allocation belongs to.
    /// If the allocation is sub-allocated from a larger block, you may need to consider the offset of the allocation
    /// (VmaAllocationInfo::offset).
    ///
    /// This function always uses `VK_EXTERNAL_MEMORY_HANDLE_TYPE_OPAQUE_WIN32_BIT`.
    /// An extended version of this function is available as vmaGetMemoryWin32Handle2()
    /// that allows using other handle type.
    ///
    /// This function is available compile-time only when VK_KHR_external_memory_win32 extension is available.
    /// It can be manually disabled by predefining `VMA_EXTERNAL_MEMORY_WIN32=0` macro.
    ///
    /// If the function fails with `VK_ERROR_FEATURE_NOT_PRESENT` error code, please double-check
    /// that VmaVulkanFunctions::vkGetMemoryWin32HandleKHR function pointer is set, e.g.
    /// either by using macro `VMA_DYNAMIC_VULKAN_FUNCTIONS`
    /// or by manually passing it through VmaAllocatorCreateInfo::pVulkanFunctions.
    ///
    /// For more information, see chapter  other_api_interop.
    ///
    /// @param allocator The main allocator object.
    /// @param allocation Allocation.
    /// @param hTargetProcess A valid handle to target process or null. If it's null, the function returns
    /// @param pHandle Output parameter that returns the handle.
    public @EnumType(VkResult.class) int getMemoryWin32Handle(
        VmaAllocator allocator,
        VmaAllocation allocation,
        @Pointer(comment="HANDLE") @NotNull MemorySegment hTargetProcess,
        PointerPtr pHandle
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$vmaGetMemoryWin32Handle);
        try {
            return (int) hFunction.invokeExact(
                allocator.segment(),
                allocation.segment(),
                hTargetProcess,
                pHandle.segment()
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// Given an allocation, returns Win32 handle that may be imported by other processes or APIs.
    ///
    /// - `VK_EXTERNAL_MEMORY_HANDLE_TYPE_OPAQUE_WIN32_BIT_KHR`
    /// - `VK_EXTERNAL_MEMORY_HANDLE_TYPE_OPAQUE_WIN32_KMT_BIT_KHR`
    /// - `VK_EXTERNAL_MEMORY_HANDLE_TYPE_D3D11_TEXTURE_BIT_KHR`
    /// - `VK_EXTERNAL_MEMORY_HANDLE_TYPE_D3D11_TEXTURE_KMT_BIT_KHR`
    /// - `VK_EXTERNAL_MEMORY_HANDLE_TYPE_D3D12_HEAP_BIT_KHR`
    /// - `VK_EXTERNAL_MEMORY_HANDLE_TYPE_D3D12_RESOURCE_BIT_KHR`
    /// handle for the current process.
    ///
    /// The function fills `pHandle` with handle that can be used in target process.
    /// The handle is fetched using function `vkGetMemoryWin32HandleKHR`.
    ///
    /// If `handleType == VK_EXTERNAL_MEMORY_HANDLE_TYPE_OPAQUE_WIN32_BIT_KHR`,
    /// or other NT handle types,
    /// each call to this function creates a new handle that must be closed using:
    ///
    /// {@snippet lang=c:
    /// CloseHandle(handle);
    /// }
    ///
    /// You can close it any time, before or after destroying the allocation object.
    /// It is reference-counted internally by Windows.
    ///
    /// Note the handle is returned for the entire `VkDeviceMemory` block that the allocation belongs to.
    /// If the allocation is sub-allocated from a larger block, you may need to consider the offset of the allocation
    /// (VmaAllocationInfo::offset).
    ///
    /// This function is available compile-time only when VK_KHR_external_memory_win32 extension is available.
    /// It can be manually disabled by predefining `VMA_EXTERNAL_MEMORY_WIN32=0` macro.
    ///
    /// If the function fails with `VK_ERROR_FEATURE_NOT_PRESENT` error code, please double-check
    /// that VmaVulkanFunctions::vkGetMemoryWin32HandleKHR function pointer is set, e.g.
    /// either by using macro `VMA_DYNAMIC_VULKAN_FUNCTIONS`
    /// or by manually passing it through VmaAllocatorCreateInfo::pVulkanFunctions.
    ///
    /// For more information, see chapter  other_api_interop.
    ///
    /// @param allocator The main allocator object.
    /// @param allocation Allocation.
    /// @param handleType Type of handle to be exported. It should be one of:
    /// @param hTargetProcess A valid handle to target process or null. If it's null, the function returns
    /// @param pHandle Output parameter that returns the handle.
    public @EnumType(VkResult.class) int getMemoryWin32Handle2(
        VmaAllocator allocator,
        VmaAllocation allocation,
        @Bitmask(VkExternalMemoryHandleTypeFlags.class) int handleType,
        @Pointer(comment="HANDLE") @NotNull MemorySegment hTargetProcess,
        PointerPtr pHandle
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$vmaGetMemoryWin32Handle2);
        try {
            return (int) hFunction.invokeExact(
                allocator.segment(),
                allocation.segment(),
                handleType,
                hTargetProcess,
                pHandle.segment()
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// Maps memory represented by given allocation and returns pointer to it.
    ///
    /// Maps memory represented by given allocation to make it accessible to CPU code.
    /// When succeeded, `*ppData` contains pointer to first byte of this memory.
    ///
    /// <b>Warning: </b>
    /// If the allocation is part of a bigger `VkDeviceMemory` block, returned pointer is
    /// correctly offsetted to the beginning of region assigned to this particular allocation.
    /// Unlike the result of `vkMapMemory`, it points to the allocation, not to the beginning of the whole block.
    /// You should not add VmaAllocationInfo::offset to it!
    ///
    /// Mapping is internally reference-counted and synchronized, so despite raw Vulkan
    /// function `vkMapMemory()` cannot be used to map same block of `VkDeviceMemory`
    /// multiple times simultaneously, it is safe to call this function on allocations
    /// assigned to the same memory block. Actual Vulkan memory will be mapped on first
    /// mapping and unmapped on last unmapping.
    ///
    /// If the function succeeded, you must call vmaUnmapMemory() to unmap the
    /// allocation when mapping is no longer needed or before freeing the allocation, at
    /// the latest.
    ///
    /// It also safe to call this function multiple times on the same allocation. You
    /// must call vmaUnmapMemory() same number of times as you called vmaMapMemory().
    ///
    /// It is also safe to call this function on allocation created with
    /// {@code VMA_ALLOCATION_CREATE_MAPPED_BIT} flag. Its memory stays mapped all the time.
    /// You must still call vmaUnmapMemory() same number of times as you called
    /// vmaMapMemory(). You must not call vmaUnmapMemory() additional time to free the
    /// "0-th" mapping made automatically due to {@code VMA_ALLOCATION_CREATE_MAPPED_BIT} flag.
    ///
    /// This function fails when used on allocation made in memory type that is not
    /// `HOST_VISIBLE`.
    ///
    /// This function doesn't automatically flush or invalidate caches.
    /// If the allocation is made from a memory types that is not `HOST_COHERENT`,
    /// you also need to use vmaInvalidateAllocation() / vmaFlushAllocation(), as required by Vulkan specification.
    ///
    public @EnumType(VkResult.class) int mapMemory(
        VmaAllocator allocator,
        VmaAllocation allocation,
        PointerPtr ppData
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$vmaMapMemory);
        try {
            return (int) hFunction.invokeExact(
                allocator.segment(),
                allocation.segment(),
                ppData.segment()
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// Unmaps memory represented by given allocation, mapped previously using vmaMapMemory().
    ///
    /// For details, see description of vmaMapMemory().
    ///
    /// This function doesn't automatically flush or invalidate caches.
    /// If the allocation is made from a memory types that is not `HOST_COHERENT`,
    /// you also need to use vmaInvalidateAllocation() / vmaFlushAllocation(), as required by Vulkan specification.
    ///
    public void unmapMemory(
        VmaAllocator allocator,
        VmaAllocation allocation
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$vmaUnmapMemory);
        try {
            hFunction.invokeExact(
                allocator.segment(),
                allocation.segment()
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// Flushes memory of given allocation.
    ///
    /// Calls `vkFlushMappedMemoryRanges()` for memory associated with given range of given allocation.
    /// It needs to be called after writing to a mapped memory for memory types that are not `HOST_COHERENT`.
    /// Unmap operation doesn't do that automatically.
    ///
    /// - `offset` must be relative to the beginning of allocation.
    /// - `size` can be `VK_WHOLE_SIZE`. It means all memory from `offset` the the end of given allocation.
    /// - `offset` and `size` don't have to be aligned.
    /// They are internally rounded down/up to multiply of `nonCoherentAtomSize`.
    /// - If `size` is 0, this call is ignored.
    /// - If memory type that the `allocation` belongs to is not `HOST_VISIBLE` or it is `HOST_COHERENT`,
    /// this call is ignored.
    ///
    /// Warning! `offset` and `size` are relative to the contents of given `allocation`.
    /// If you mean whole allocation, you can pass 0 and `VK_WHOLE_SIZE`, respectively.
    /// Do not pass allocation's offset as `offset`!!!
    ///
    /// This function returns the `VkResult` from `vkFlushMappedMemoryRanges` if it is
    /// called, otherwise `VK_SUCCESS`.
    ///
    public @EnumType(VkResult.class) int flushAllocation(
        VmaAllocator allocator,
        VmaAllocation allocation,
        @NativeType("VkDeviceSize") @Unsigned long offset,
        @NativeType("VkDeviceSize") @Unsigned long size
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$vmaFlushAllocation);
        try {
            return (int) hFunction.invokeExact(
                allocator.segment(),
                allocation.segment(),
                offset,
                size
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// Invalidates memory of given allocation.
    ///
    /// Calls `vkInvalidateMappedMemoryRanges()` for memory associated with given range of given allocation.
    /// It needs to be called before reading from a mapped memory for memory types that are not `HOST_COHERENT`.
    /// Map operation doesn't do that automatically.
    ///
    /// - `offset` must be relative to the beginning of allocation.
    /// - `size` can be `VK_WHOLE_SIZE`. It means all memory from `offset` the the end of given allocation.
    /// - `offset` and `size` don't have to be aligned.
    /// They are internally rounded down/up to multiply of `nonCoherentAtomSize`.
    /// - If `size` is 0, this call is ignored.
    /// - If memory type that the `allocation` belongs to is not `HOST_VISIBLE` or it is `HOST_COHERENT`,
    /// this call is ignored.
    ///
    /// Warning! `offset` and `size` are relative to the contents of given `allocation`.
    /// If you mean whole allocation, you can pass 0 and `VK_WHOLE_SIZE`, respectively.
    /// Do not pass allocation's offset as `offset`!!!
    ///
    /// This function returns the `VkResult` from `vkInvalidateMappedMemoryRanges` if
    /// it is called, otherwise `VK_SUCCESS`.
    ///
    public @EnumType(VkResult.class) int invalidateAllocation(
        VmaAllocator allocator,
        VmaAllocation allocation,
        @NativeType("VkDeviceSize") @Unsigned long offset,
        @NativeType("VkDeviceSize") @Unsigned long size
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$vmaInvalidateAllocation);
        try {
            return (int) hFunction.invokeExact(
                allocator.segment(),
                allocation.segment(),
                offset,
                size
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// Flushes memory of given set of allocations.
    ///
    /// Calls `vkFlushMappedMemoryRanges()` for memory associated with given ranges of given allocations.
    /// For more information, see documentation of vmaFlushAllocation().
    ///
    /// This function returns the `VkResult` from `vkFlushMappedMemoryRanges` if it is
    /// called, otherwise `VK_SUCCESS`.
    ///
    /// @param allocator
    /// @param allocationCount
    /// @param allocations
    /// @param offsets If not null, it must point to an array of offsets of regions to flush, relative to the beginning of respective allocations. Null means all offsets are zero.
    /// @param sizes If not null, it must point to an array of sizes of regions to flush in respective allocations. Null means `VK_WHOLE_SIZE` for all allocations.
    public @EnumType(VkResult.class) int flushAllocations(
        VmaAllocator allocator,
        @Unsigned int allocationCount,
        @Nullable @Pointer VmaAllocation.Ptr allocations,
        @Nullable @Pointer(comment="VkDeviceSize") @Unsigned LongPtr offsets,
        @Nullable @Pointer(comment="VkDeviceSize") @Unsigned LongPtr sizes
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$vmaFlushAllocations);
        try {
            return (int) hFunction.invokeExact(
                allocator.segment(),
                allocationCount,
                (MemorySegment) (allocations != null ? allocations.segment() : MemorySegment.NULL),
                (MemorySegment) (offsets != null ? offsets.segment() : MemorySegment.NULL),
                (MemorySegment) (sizes != null ? sizes.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// Invalidates memory of given set of allocations.
    ///
    /// Calls `vkInvalidateMappedMemoryRanges()` for memory associated with given ranges of given allocations.
    /// For more information, see documentation of vmaInvalidateAllocation().
    ///
    /// This function returns the `VkResult` from `vkInvalidateMappedMemoryRanges` if it is
    /// called, otherwise `VK_SUCCESS`.
    ///
    /// @param allocator
    /// @param allocationCount
    /// @param allocations
    /// @param offsets If not null, it must point to an array of offsets of regions to flush, relative to the beginning of respective allocations. Null means all offsets are zero.
    /// @param sizes If not null, it must point to an array of sizes of regions to flush in respective allocations. Null means `VK_WHOLE_SIZE` for all allocations.
    public @EnumType(VkResult.class) int invalidateAllocations(
        VmaAllocator allocator,
        @Unsigned int allocationCount,
        @Nullable @Pointer VmaAllocation.Ptr allocations,
        @Nullable @Pointer(comment="VkDeviceSize") @Unsigned LongPtr offsets,
        @Nullable @Pointer(comment="VkDeviceSize") @Unsigned LongPtr sizes
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$vmaInvalidateAllocations);
        try {
            return (int) hFunction.invokeExact(
                allocator.segment(),
                allocationCount,
                (MemorySegment) (allocations != null ? allocations.segment() : MemorySegment.NULL),
                (MemorySegment) (offsets != null ? offsets.segment() : MemorySegment.NULL),
                (MemorySegment) (sizes != null ? sizes.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// Maps the allocation temporarily if needed, copies data from specified host pointer to it, and flushes the memory from the host caches if needed.
    ///
    /// This is a convenience function that allows to copy data from a host pointer to an allocation easily.
    /// Same behavior can be achieved by calling vmaMapMemory(), `memcpy()`, vmaUnmapMemory(), vmaFlushAllocation().
    ///
    /// This function can be called only for allocations created in a memory type that has `VK_MEMORY_PROPERTY_HOST_VISIBLE_BIT` flag.
    /// It can be ensured e.g. by using {@code VMA_MEMORY_USAGE_AUTO} and {@code VMA_ALLOCATION_CREATE_HOST_ACCESS_SEQUENTIAL_WRITE_BIT} or
    /// {@code VMA_ALLOCATION_CREATE_HOST_ACCESS_RANDOM_BIT}.
    /// Otherwise, the function will fail and generate a Validation Layers error.
    ///
    /// `dstAllocationLocalOffset` is relative to the contents of given `dstAllocation`.
    /// If you mean whole allocation, you should pass 0.
    /// Do not pass allocation's offset within device memory block this parameter!
    ///
    /// @param allocator
    /// @param pSrcHostPointer Pointer to the host data that become source of the copy.
    /// @param dstAllocation   Handle to the allocation that becomes destination of the copy.
    /// @param dstAllocationLocalOffset  Offset within `dstAllocation` where to write copied data, in bytes.
    /// @param size            Number of bytes to copy.
    public @EnumType(VkResult.class) int copyMemoryToAllocation(
        VmaAllocator allocator,
        @Pointer(comment="void*") @NotNull MemorySegment pSrcHostPointer,
        VmaAllocation dstAllocation,
        @NativeType("VkDeviceSize") @Unsigned long dstAllocationLocalOffset,
        @NativeType("VkDeviceSize") @Unsigned long size
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$vmaCopyMemoryToAllocation);
        try {
            return (int) hFunction.invokeExact(
                allocator.segment(),
                pSrcHostPointer,
                dstAllocation.segment(),
                dstAllocationLocalOffset,
                size
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// Invalidates memory in the host caches if needed, maps the allocation temporarily if needed, and copies data from it to a specified host pointer.
    ///
    /// This is a convenience function that allows to copy data from an allocation to a host pointer easily.
    /// Same behavior can be achieved by calling vmaInvalidateAllocation(), vmaMapMemory(), `memcpy()`, vmaUnmapMemory().
    ///
    /// This function should be called only for allocations created in a memory type that has `VK_MEMORY_PROPERTY_HOST_VISIBLE_BIT`
    /// and `VK_MEMORY_PROPERTY_HOST_CACHED_BIT` flag.
    /// It can be ensured e.g. by using {@code VMA_MEMORY_USAGE_AUTO} and {@code VMA_ALLOCATION_CREATE_HOST_ACCESS_RANDOM_BIT}.
    /// Otherwise, the function may fail and generate a Validation Layers error.
    /// It may also work very slowly when reading from an uncached memory.
    ///
    /// `srcAllocationLocalOffset` is relative to the contents of given `srcAllocation`.
    /// If you mean whole allocation, you should pass 0.
    /// Do not pass allocation's offset within device memory block as this parameter!
    ///
    /// @param allocator
    /// @param srcAllocation   Handle to the allocation that becomes source of the copy.
    /// @param srcAllocationLocalOffset  Offset within `srcAllocation` where to read copied data, in bytes.
    /// @param pDstHostPointer Pointer to the host memory that become destination of the copy.
    /// @param size            Number of bytes to copy.
    public @EnumType(VkResult.class) int copyAllocationToMemory(
        VmaAllocator allocator,
        VmaAllocation srcAllocation,
        @NativeType("VkDeviceSize") @Unsigned long srcAllocationLocalOffset,
        @Pointer(comment="void*") @NotNull MemorySegment pDstHostPointer,
        @NativeType("VkDeviceSize") @Unsigned long size
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$vmaCopyAllocationToMemory);
        try {
            return (int) hFunction.invokeExact(
                allocator.segment(),
                srcAllocation.segment(),
                srcAllocationLocalOffset,
                pDstHostPointer,
                size
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// Checks magic number in margins around all allocations in given memory types (in both default and custom pools) in search for corruptions.
    ///
    /// Corruption detection is enabled only when `VMA_DEBUG_DETECT_CORRUPTION` macro is defined to nonzero,
    /// `VMA_DEBUG_MARGIN` is defined to nonzero and only for memory types that are
    /// `HOST_VISIBLE` and `HOST_COHERENT`. For more information, see [Corruption detection](@ref debugging_memory_usage_corruption_detection).
    ///
    /// Possible return values:
    ///
    /// - `VK_ERROR_FEATURE_NOT_PRESENT` - corruption detection is not enabled for any of specified memory types.
    /// - `VK_SUCCESS` - corruption detection has been performed and succeeded.
    /// - `VK_ERROR_UNKNOWN` - corruption detection has been performed and found memory corruptions around one of the allocations.
    /// `VMA_ASSERT` is also fired in that case.
    /// - Other value: Error returned by Vulkan, e.g. memory mapping failure.
    ///
    /// @param allocator
    /// @param memoryTypeBits Bit mask, where each bit set means that a memory type with that index should be checked.
    public @EnumType(VkResult.class) int checkCorruption(
        VmaAllocator allocator,
        @Unsigned int memoryTypeBits
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$vmaCheckCorruption);
        try {
            return (int) hFunction.invokeExact(
                allocator.segment(),
                memoryTypeBits
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// Begins defragmentation process.
    ///
    /// For more information about defragmentation, see documentation chapter:
    /// [Defragmentation](@ref defragmentation).
    ///
    /// @param allocator Allocator object.
    /// @param pInfo Structure filled with parameters of defragmentation.
    /// @param pContext Context object that must be passed to vmaEndDefragmentation() to finish defragmentation.
    /// @return
    /// <li>`VK_SUCCESS` if defragmentation can begin.</li>
    /// <li>`VK_ERROR_FEATURE_NOT_PRESENT` if defragmentation is not supported.</li>
    public @EnumType(VkResult.class) int beginDefragmentation(
        VmaAllocator allocator,
        @Pointer IVmaDefragmentationInfo pInfo,
        @Pointer VmaDefragmentationContext.Ptr pContext
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$vmaBeginDefragmentation);
        try {
            return (int) hFunction.invokeExact(
                allocator.segment(),
                pInfo.segment(),
                pContext.segment()
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// Ends defragmentation process.
    ///
    /// Use this function to finish defragmentation started by vmaBeginDefragmentation().
    ///
    /// @param allocator Allocator object.
    /// @param context Context object that has been created by vmaBeginDefragmentation().
    /// @param pStats Optional stats for the defragmentation. Can be null.
    public void endDefragmentation(
        VmaAllocator allocator,
        VmaDefragmentationContext context,
        @Nullable @Pointer IVmaDefragmentationStats pStats
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$vmaEndDefragmentation);
        try {
            hFunction.invokeExact(
                allocator.segment(),
                context.segment(),
                (MemorySegment) (pStats != null ? pStats.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// Starts single defragmentation pass.
    ///
    /// @param allocator Allocator object.
    /// @param context Context object that has been created by vmaBeginDefragmentation().
    /// @param pPassInfo Computed information for current pass.
    /// @return
    /// <li>`VK_SUCCESS` if no more moves are possible. Then you can omit call to vmaEndDefragmentationPass() and simply end whole defragmentation.</li>
    /// <li>`VK_INCOMPLETE` if there are pending moves returned in `pPassInfo`. You need to perform them, call vmaEndDefragmentationPass(),</li>
    public @EnumType(VkResult.class) int beginDefragmentationPass(
        VmaAllocator allocator,
        VmaDefragmentationContext context,
        @Pointer IVmaDefragmentationPassMoveInfo pPassInfo
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$vmaBeginDefragmentationPass);
        try {
            return (int) hFunction.invokeExact(
                allocator.segment(),
                context.segment(),
                pPassInfo.segment()
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// Ends single defragmentation pass.
    ///
    /// Returns `VK_SUCCESS` if no more moves are possible or `VK_INCOMPLETE` if more defragmentations are possible.
    ///
    /// Ends incremental defragmentation pass and commits all defragmentation moves from `pPassInfo`.
    /// After this call:
    ///
    /// - Allocations at `pPassInfo[i].srcAllocation` that had `pPassInfo[i].operation ==` {@code VMA_DEFRAGMENTATION_MOVE_OPERATION_COPY}
    /// (which is the default) will be pointing to the new destination place.
    /// - Allocation at `pPassInfo[i].srcAllocation` that had `pPassInfo[i].operation ==` {@code VMA_DEFRAGMENTATION_MOVE_OPERATION_DESTROY}
    /// will be freed.
    ///
    /// If no more moves are possible you can end whole defragmentation.
    ///
    /// @param allocator Allocator object.
    /// @param context Context object that has been created by vmaBeginDefragmentation().
    /// @param pPassInfo Computed information for current pass filled by vmaBeginDefragmentationPass() and possibly modified by you.
    public @EnumType(VkResult.class) int endDefragmentationPass(
        VmaAllocator allocator,
        VmaDefragmentationContext context,
        @Pointer IVmaDefragmentationPassMoveInfo pPassInfo
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$vmaEndDefragmentationPass);
        try {
            return (int) hFunction.invokeExact(
                allocator.segment(),
                context.segment(),
                pPassInfo.segment()
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// Binds buffer to allocation.
    ///
    /// Binds specified buffer to region of memory represented by specified allocation.
    /// Gets `VkDeviceMemory` handle and offset from the allocation.
    /// If you want to create a buffer, allocate memory for it and bind them together separately,
    /// you should use this function for binding instead of standard `vkBindBufferMemory()`,
    /// because it ensures proper synchronization so that when a `VkDeviceMemory` object is used by multiple
    /// allocations, calls to `vkBind*Memory()` or `vkMapMemory()` won't happen from multiple threads simultaneously
    /// (which is illegal in Vulkan).
    ///
    /// It is recommended to use function vmaCreateBuffer() instead of this one.
    ///
    public @EnumType(VkResult.class) int bindBufferMemory(
        VmaAllocator allocator,
        VmaAllocation allocation,
        VkBuffer buffer
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$vmaBindBufferMemory);
        try {
            return (int) hFunction.invokeExact(
                allocator.segment(),
                allocation.segment(),
                buffer.segment()
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// Binds buffer to allocation with additional parameters.
    ///
    /// This function is similar to vmaBindBufferMemory(), but it provides additional parameters.
    ///
    /// If `pNext` is not null, {@code VmaAllocator} object must have been created with {@code VMA_ALLOCATOR_CREATE_KHR_BIND_MEMORY2_BIT} flag
    /// or with VmaAllocatorCreateInfo::vulkanApiVersion `&amp;gt;= VK_API_VERSION_1_1`. Otherwise the call fails.
    ///
    /// @param allocator
    /// @param allocation
    /// @param allocationLocalOffset Additional offset to be added while binding, relative to the beginning of the `allocation`. Normally it should be 0.
    /// @param buffer
    /// @param pNext A chain of structures to be attached to `VkBindBufferMemoryInfoKHR` structure used internally. Normally it should be null.
    public @EnumType(VkResult.class) int bindBufferMemory2(
        VmaAllocator allocator,
        VmaAllocation allocation,
        @NativeType("VkDeviceSize") @Unsigned long allocationLocalOffset,
        VkBuffer buffer,
        @Pointer(comment="void*") @NotNull MemorySegment pNext
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$vmaBindBufferMemory2);
        try {
            return (int) hFunction.invokeExact(
                allocator.segment(),
                allocation.segment(),
                allocationLocalOffset,
                buffer.segment(),
                pNext
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// Binds image to allocation.
    ///
    /// Binds specified image to region of memory represented by specified allocation.
    /// Gets `VkDeviceMemory` handle and offset from the allocation.
    /// If you want to create an image, allocate memory for it and bind them together separately,
    /// you should use this function for binding instead of standard `vkBindImageMemory()`,
    /// because it ensures proper synchronization so that when a `VkDeviceMemory` object is used by multiple
    /// allocations, calls to `vkBind*Memory()` or `vkMapMemory()` won't happen from multiple threads simultaneously
    /// (which is illegal in Vulkan).
    ///
    /// It is recommended to use function vmaCreateImage() instead of this one.
    ///
    public @EnumType(VkResult.class) int bindImageMemory(
        VmaAllocator allocator,
        VmaAllocation allocation,
        VkImage image
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$vmaBindImageMemory);
        try {
            return (int) hFunction.invokeExact(
                allocator.segment(),
                allocation.segment(),
                image.segment()
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// Binds image to allocation with additional parameters.
    ///
    /// This function is similar to vmaBindImageMemory(), but it provides additional parameters.
    ///
    /// If `pNext` is not null, {@code VmaAllocator} object must have been created with {@code VMA_ALLOCATOR_CREATE_KHR_BIND_MEMORY2_BIT} flag
    /// or with VmaAllocatorCreateInfo::vulkanApiVersion `&amp;gt;= VK_API_VERSION_1_1`. Otherwise the call fails.
    ///
    /// @param allocator
    /// @param allocation
    /// @param allocationLocalOffset Additional offset to be added while binding, relative to the beginning of the `allocation`. Normally it should be 0.
    /// @param image
    /// @param pNext A chain of structures to be attached to `VkBindImageMemoryInfoKHR` structure used internally. Normally it should be null.
    public @EnumType(VkResult.class) int bindImageMemory2(
        VmaAllocator allocator,
        VmaAllocation allocation,
        @NativeType("VkDeviceSize") @Unsigned long allocationLocalOffset,
        VkImage image,
        @Pointer(comment="void*") @NotNull MemorySegment pNext
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$vmaBindImageMemory2);
        try {
            return (int) hFunction.invokeExact(
                allocator.segment(),
                allocation.segment(),
                allocationLocalOffset,
                image.segment(),
                pNext
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// Creates a new `VkBuffer`, allocates and binds memory for it.
    ///
    /// It can be also fetched later using vmaGetAllocationInfo().
    ///
    /// This function automatically:
    ///
    /// -# Creates buffer.
    /// -# Allocates appropriate memory for it.
    /// -# Binds the buffer with the memory.
    ///
    /// If any of these operations fail, buffer and allocation are not created,
    /// returned value is negative error code, `*pBuffer` and `*pAllocation` are returned as null.
    ///
    /// If the function succeeded, you must destroy both buffer and allocation when you
    /// no longer need them using either convenience function vmaDestroyBuffer() or
    /// separately, using `vkDestroyBuffer()` and vmaFreeMemory().
    ///
    /// If VK_KHR_dedicated_allocation extenion or Vulkan version &amp;gt;= 1.1 is used,
    /// the function queries the driver whether
    /// it requires or prefers the new buffer to have dedicated allocation. If yes,
    /// and if dedicated allocation is possible
    /// ({@code VMA_ALLOCATION_CREATE_NEVER_ALLOCATE_BIT} is not used), it creates dedicated
    /// allocation for this buffer, just like when using
    /// {@code VMA_ALLOCATION_CREATE_DEDICATED_MEMORY_BIT}.
    ///
    /// ote This function creates a new `VkBuffer`. Sub-allocation of parts of one large buffer,
    /// although recommended as a good practice, is out of scope of this library and could be implemented
    /// by the user as a higher-level logic on top of VMA.
    ///
    /// There is also an extended versions of this function available with additional parameter `pMemoryAllocateNext` -
    /// see vmaCreateDedicatedBuffer().
    ///
    /// @param allocator The main allocator object.
    /// @param pBufferCreateInfo Buffer creation parameters.
    /// @param pAllocationCreateInfo Allocation creation parameters.
    /// @param pBuffer Buffer that was created.
    /// @param pAllocation Allocation that was created.
    /// @param pAllocationInfo Optional, can be null. Information about allocated memory.
    public @EnumType(VkResult.class) int createBuffer(
        VmaAllocator allocator,
        @Pointer IVkBufferCreateInfo pBufferCreateInfo,
        @Pointer IVmaAllocationCreateInfo pAllocationCreateInfo,
        @Pointer VkBuffer.Ptr pBuffer,
        @Pointer VmaAllocation.Ptr pAllocation,
        @Nullable @Pointer IVmaAllocationInfo pAllocationInfo
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$vmaCreateBuffer);
        try {
            return (int) hFunction.invokeExact(
                allocator.segment(),
                pBufferCreateInfo.segment(),
                pAllocationCreateInfo.segment(),
                pBuffer.segment(),
                pAllocation.segment(),
                (MemorySegment) (pAllocationInfo != null ? pAllocationInfo.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// Creates a buffer with additional minimum alignment.
    ///
    /// Similar to vmaCreateBuffer() but provides additional parameter `minAlignment` which allows to specify custom,
    /// minimum alignment to be used when placing the buffer inside a larger memory block, which may be needed e.g.
    /// for interop with OpenGL.
    ///
    /// This function in obsolete since new VmaAllocationCreateInfo::minAlignment member allows specifying custom
    /// alignment while using any allocation function, like the standard vmaCreateBuffer().
    ///
    /// @deprecated
    public @EnumType(VkResult.class) int createBufferWithAlignment(
        VmaAllocator allocator,
        @Pointer IVkBufferCreateInfo pBufferCreateInfo,
        @Pointer IVmaAllocationCreateInfo pAllocationCreateInfo,
        @NativeType("VkDeviceSize") @Unsigned long minAlignment,
        @Pointer VkBuffer.Ptr pBuffer,
        @Pointer VmaAllocation.Ptr pAllocation,
        @Nullable @Pointer IVmaAllocationInfo pAllocationInfo
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$vmaCreateBufferWithAlignment);
        try {
            return (int) hFunction.invokeExact(
                allocator.segment(),
                pBufferCreateInfo.segment(),
                pAllocationCreateInfo.segment(),
                minAlignment,
                pBuffer.segment(),
                pAllocation.segment(),
                (MemorySegment) (pAllocationInfo != null ? pAllocationInfo.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// Creates a dedicated buffer while offering extra parameter `pMemoryAllocateNext`.
    ///
    /// This function is similar vmaCreateBuffer(), but
    /// it always allocates dedicated memory for the buffer - flag {@code VMA_ALLOCATION_CREATE_DEDICATED_MEMORY_BIT} is implied.
    /// It offers additional parameter `pMemoryAllocateNext`,
    /// which can be used to attach `pNext` chain to the `VkMemoryAllocateInfo` structure.
    /// It can be useful for importing external memory. For more information, see  other_api_interop.
    ///
    public @EnumType(VkResult.class) int createDedicatedBuffer(
        VmaAllocator allocator,
        @Pointer IVkBufferCreateInfo pBufferCreateInfo,
        @Pointer IVmaAllocationCreateInfo pAllocationCreateInfo,
        @Pointer(comment="void*") @NotNull MemorySegment pMemoryAllocateNext,
        @Pointer VkBuffer.Ptr pBuffer,
        @Pointer VmaAllocation.Ptr pAllocation,
        @Nullable @Pointer IVmaAllocationInfo pAllocationInfo
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$vmaCreateDedicatedBuffer);
        try {
            return (int) hFunction.invokeExact(
                allocator.segment(),
                pBufferCreateInfo.segment(),
                pAllocationCreateInfo.segment(),
                pMemoryAllocateNext,
                pBuffer.segment(),
                pAllocation.segment(),
                (MemorySegment) (pAllocationInfo != null ? pAllocationInfo.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// Creates a new `VkBuffer`, binds already created memory for it.
    ///
    /// This function automatically:
    ///
    /// -# Creates buffer.
    /// -# Binds the buffer with the supplied memory.
    ///
    /// If any of these operations fail, buffer is not created,
    /// returned value is negative error code and `*pBuffer` is null.
    ///
    /// If the function succeeded, you must destroy the buffer when you
    /// no longer need it using `vkDestroyBuffer()`. If you want to also destroy the corresponding
    /// allocation you can use convenience function vmaDestroyBuffer().
    ///
    /// ote There is a new version of this function augmented with parameter `allocationLocalOffset` - see vmaCreateAliasingBuffer2().
    ///
    /// @param allocator
    /// @param allocation Allocation that provides memory to be used for binding new buffer to it.
    /// @param pBufferCreateInfo
    /// @param pBuffer Buffer that was created.
    public @EnumType(VkResult.class) int createAliasingBuffer(
        VmaAllocator allocator,
        VmaAllocation allocation,
        @Pointer IVkBufferCreateInfo pBufferCreateInfo,
        @Pointer VkBuffer.Ptr pBuffer
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$vmaCreateAliasingBuffer);
        try {
            return (int) hFunction.invokeExact(
                allocator.segment(),
                allocation.segment(),
                pBufferCreateInfo.segment(),
                pBuffer.segment()
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// Creates a new `VkBuffer`, binds already created memory for it.
    ///
    /// This function automatically:
    ///
    /// -# Creates buffer.
    /// -# Binds the buffer with the supplied memory.
    ///
    /// If any of these operations fail, buffer is not created,
    /// returned value is negative error code and `*pBuffer` is null.
    ///
    /// If the function succeeded, you must destroy the buffer when you
    /// no longer need it using `vkDestroyBuffer()`. If you want to also destroy the corresponding
    /// allocation you can use convenience function vmaDestroyBuffer().
    ///
    /// ote This is a new version of the function augmented with parameter `allocationLocalOffset`.
    ///
    /// @param allocator
    /// @param allocation Allocation that provides memory to be used for binding new buffer to it.
    /// @param allocationLocalOffset Additional offset to be added while binding, relative to the beginning of the allocation. Normally it should be 0.
    /// @param pBufferCreateInfo
    /// @param pBuffer Buffer that was created.
    public @EnumType(VkResult.class) int createAliasingBuffer2(
        VmaAllocator allocator,
        VmaAllocation allocation,
        @NativeType("VkDeviceSize") @Unsigned long allocationLocalOffset,
        @Pointer IVkBufferCreateInfo pBufferCreateInfo,
        @Pointer VkBuffer.Ptr pBuffer
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$vmaCreateAliasingBuffer2);
        try {
            return (int) hFunction.invokeExact(
                allocator.segment(),
                allocation.segment(),
                allocationLocalOffset,
                pBufferCreateInfo.segment(),
                pBuffer.segment()
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// Destroys Vulkan buffer and frees allocated memory.
    ///
    /// This is just a convenience function equivalent to:
    ///
    /// {@snippet lang=c:
    /// vkDestroyBuffer(device, buffer, allocationCallbacks);
    /// vmaFreeMemory(allocator, allocation);
    /// }
    ///
    /// It is safe to pass null as buffer and/or allocation.
    ///
    public void destroyBuffer(
        VmaAllocator allocator,
        @Nullable VkBuffer buffer,
        @Nullable VmaAllocation allocation
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$vmaDestroyBuffer);
        try {
            hFunction.invokeExact(
                allocator.segment(),
                (MemorySegment) (buffer != null ? buffer.segment() : MemorySegment.NULL),
                (MemorySegment) (allocation != null ? allocation.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// Function similar to vmaCreateBuffer() but for images.
    ///
    /// There is also an extended version of this function available: vmaCreateDedicatedImage()
    /// which offers additional parameter `pMemoryAllocateNext`.
    ///
    public @EnumType(VkResult.class) int createImage(
        VmaAllocator allocator,
        @Pointer IVkImageCreateInfo pImageCreateInfo,
        @Pointer IVmaAllocationCreateInfo pAllocationCreateInfo,
        @Pointer VkImage.Ptr pImage,
        @Pointer VmaAllocation.Ptr pAllocation,
        @Nullable @Pointer IVmaAllocationInfo pAllocationInfo
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$vmaCreateImage);
        try {
            return (int) hFunction.invokeExact(
                allocator.segment(),
                pImageCreateInfo.segment(),
                pAllocationCreateInfo.segment(),
                pImage.segment(),
                pAllocation.segment(),
                (MemorySegment) (pAllocationInfo != null ? pAllocationInfo.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// Function similar to vmaCreateDedicatedBuffer() but for images.
    ///
    /// This function is similar vmaCreateImage(), but
    /// it always allocates dedicated memory for the image - flag {@code VMA_ALLOCATION_CREATE_DEDICATED_MEMORY_BIT} is implied.
    /// It offers additional parameter `pMemoryAllocateNext`,
    /// which can be used to attach `pNext` chain to the `VkMemoryAllocateInfo` structure.
    /// It can be useful for importing external memory. For more information, see  other_api_interop.
    ///
    public @EnumType(VkResult.class) int createDedicatedImage(
        VmaAllocator allocator,
        @Pointer IVkImageCreateInfo pImageCreateInfo,
        @Pointer IVmaAllocationCreateInfo pAllocationCreateInfo,
        @Pointer(comment="void*") @NotNull MemorySegment pMemoryAllocateNext,
        @Pointer VkImage.Ptr pImage,
        @Pointer VmaAllocation.Ptr pAllocation,
        @Nullable @Pointer IVmaAllocationInfo pAllocationInfo
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$vmaCreateDedicatedImage);
        try {
            return (int) hFunction.invokeExact(
                allocator.segment(),
                pImageCreateInfo.segment(),
                pAllocationCreateInfo.segment(),
                pMemoryAllocateNext,
                pImage.segment(),
                pAllocation.segment(),
                (MemorySegment) (pAllocationInfo != null ? pAllocationInfo.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// Function similar to vmaCreateAliasingBuffer() but for images.
    ///
    public @EnumType(VkResult.class) int createAliasingImage(
        VmaAllocator allocator,
        VmaAllocation allocation,
        @Pointer IVkImageCreateInfo pImageCreateInfo,
        @Pointer VkImage.Ptr pImage
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$vmaCreateAliasingImage);
        try {
            return (int) hFunction.invokeExact(
                allocator.segment(),
                allocation.segment(),
                pImageCreateInfo.segment(),
                pImage.segment()
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// Function similar to vmaCreateAliasingBuffer2() but for images.
    ///
    public @EnumType(VkResult.class) int createAliasingImage2(
        VmaAllocator allocator,
        VmaAllocation allocation,
        @NativeType("VkDeviceSize") @Unsigned long allocationLocalOffset,
        @Pointer IVkImageCreateInfo pImageCreateInfo,
        @Pointer VkImage.Ptr pImage
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$vmaCreateAliasingImage2);
        try {
            return (int) hFunction.invokeExact(
                allocator.segment(),
                allocation.segment(),
                allocationLocalOffset,
                pImageCreateInfo.segment(),
                pImage.segment()
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// Destroys Vulkan image and frees allocated memory.
    ///
    /// This is just a convenience function equivalent to:
    ///
    /// {@snippet lang=c:
    /// vkDestroyImage(device, image, allocationCallbacks);
    /// vmaFreeMemory(allocator, allocation);
    /// }
    ///
    /// It is safe to pass null as image and/or allocation.
    ///
    public void destroyImage(
        VmaAllocator allocator,
        @Nullable VkImage image,
        @Nullable VmaAllocation allocation
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$vmaDestroyImage);
        try {
            hFunction.invokeExact(
                allocator.segment(),
                (MemorySegment) (image != null ? image.segment() : MemorySegment.NULL),
                (MemorySegment) (allocation != null ? allocation.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// Creates new {@code VmaVirtualBlock} object.
    ///
    /// @param pCreateInfo Parameters for creation.
    /// @param pVirtualBlock Returned virtual block object or `VMA_NULL` if creation failed.
    public @EnumType(VkResult.class) int createVirtualBlock(
        @Pointer IVmaVirtualBlockCreateInfo pCreateInfo,
        @Pointer VmaVirtualBlock.Ptr pVirtualBlock
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$vmaCreateVirtualBlock);
        try {
            return (int) hFunction.invokeExact(
                pCreateInfo.segment(),
                pVirtualBlock.segment()
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// Destroys {@code VmaVirtualBlock} object.
    ///
    /// Please note that you should consciously handle virtual allocations that could remain unfreed in the block.
    /// You should either free them individually using vmaVirtualFree() or call vmaClearVirtualBlock()
    /// if you are sure this is what you want. If you do neither, an assert is called.
    ///
    /// If you keep pointers to some additional metadata associated with your virtual allocations in their `pUserData`,
    /// don't forget to free them.
    ///
    public void destroyVirtualBlock(
        @Nullable VmaVirtualBlock virtualBlock
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$vmaDestroyVirtualBlock);
        try {
            hFunction.invokeExact(
                (MemorySegment) (virtualBlock != null ? virtualBlock.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// Returns true of the {@code VmaVirtualBlock} is empty - contains 0 virtual allocations and has all its space available for new allocations.
    ///
    public @NativeType("VkBool32") @Unsigned int isVirtualBlockEmpty(
        VmaVirtualBlock virtualBlock
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$vmaIsVirtualBlockEmpty);
        try {
            return (int) hFunction.invokeExact(
                virtualBlock.segment()
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// Returns information about a specific virtual allocation within a virtual block, like its size and `pUserData` pointer.
    ///
    public void getVirtualAllocationInfo(
        VmaVirtualBlock virtualBlock,
        VmaVirtualAllocation allocation,
        @Pointer IVmaVirtualAllocationInfo pVirtualAllocInfo
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$vmaGetVirtualAllocationInfo);
        try {
            hFunction.invokeExact(
                virtualBlock.segment(),
                allocation.segment(),
                pVirtualAllocInfo.segment()
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// Allocates new virtual allocation inside given {@code VmaVirtualBlock}.
    ///
    /// If the allocation fails due to not enough free space available, `VK_ERROR_OUT_OF_DEVICE_MEMORY` is returned
    /// (despite the function doesn't ever allocate actual GPU memory).
    /// `pAllocation` is then set to `VK_NULL_HANDLE` and `pOffset`, if not null, it set to `UINT64_MAX`.
    ///
    /// @param virtualBlock Virtual block
    /// @param pCreateInfo Parameters for the allocation
    /// @param pAllocation Returned handle of the new allocation
    /// @param pOffset Returned offset of the new allocation. Optional, can be null.
    public @EnumType(VkResult.class) int virtualAllocate(
        VmaVirtualBlock virtualBlock,
        @Pointer IVmaVirtualAllocationCreateInfo pCreateInfo,
        @Pointer VmaVirtualAllocation.Ptr pAllocation,
        @Nullable @Pointer(comment="VkDeviceSize") @Unsigned LongPtr pOffset
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$vmaVirtualAllocate);
        try {
            return (int) hFunction.invokeExact(
                virtualBlock.segment(),
                pCreateInfo.segment(),
                pAllocation.segment(),
                (MemorySegment) (pOffset != null ? pOffset.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// Frees virtual allocation inside given {@code VmaVirtualBlock}.
    ///
    /// It is correct to call this function with `allocation == VK_NULL_HANDLE` - it does nothing.
    ///
    public void virtualFree(
        VmaVirtualBlock virtualBlock,
        @Nullable VmaVirtualAllocation allocation
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$vmaVirtualFree);
        try {
            hFunction.invokeExact(
                virtualBlock.segment(),
                (MemorySegment) (allocation != null ? allocation.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// Frees all virtual allocations inside given {@code VmaVirtualBlock}.
    ///
    /// You must either call this function or free each virtual allocation individually with vmaVirtualFree()
    /// before destroying a virtual block. Otherwise, an assert is called.
    ///
    /// If you keep pointer to some additional metadata associated with your virtual allocation in its `pUserData`,
    /// don't forget to free it as well.
    ///
    public void clearVirtualBlock(
        VmaVirtualBlock virtualBlock
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$vmaClearVirtualBlock);
        try {
            hFunction.invokeExact(
                virtualBlock.segment()
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// Changes custom pointer associated with given virtual allocation.
    ///
    public void setVirtualAllocationUserData(
        VmaVirtualBlock virtualBlock,
        VmaVirtualAllocation allocation,
        @Pointer(comment="void*") @NotNull MemorySegment pUserData
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$vmaSetVirtualAllocationUserData);
        try {
            hFunction.invokeExact(
                virtualBlock.segment(),
                allocation.segment(),
                pUserData
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// Calculates and returns statistics about virtual allocations and memory usage in given {@code VmaVirtualBlock}.
    ///
    /// This function is fast to call. For more detailed statistics, see vmaCalculateVirtualBlockStatistics().
    ///
    public void getVirtualBlockStatistics(
        VmaVirtualBlock virtualBlock,
        @Pointer IVmaStatistics pStats
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$vmaGetVirtualBlockStatistics);
        try {
            hFunction.invokeExact(
                virtualBlock.segment(),
                pStats.segment()
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// Calculates and returns detailed statistics about virtual allocations and memory usage in given {@code VmaVirtualBlock}.
    ///
    /// This function is slow to call. Use for debugging purposes.
    /// For less detailed statistics, see vmaGetVirtualBlockStatistics().
    ///
    public void calculateVirtualBlockStatistics(
        VmaVirtualBlock virtualBlock,
        @Pointer IVmaDetailedStatistics pStats
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$vmaCalculateVirtualBlockStatistics);
        try {
            hFunction.invokeExact(
                virtualBlock.segment(),
                pStats.segment()
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// Builds and returns a null-terminated string in JSON format with information about given {@code VmaVirtualBlock}.
    ///
    /// Returned string must be freed using vmaFreeVirtualBlockStatsString().
    ///
    /// @param virtualBlock Virtual block.
    /// @param ppStatsString Returned string.
    /// @param detailedMap Pass `VK_FALSE` to only obtain statistics as returned by vmaCalculateVirtualBlockStatistics(). Pass `VK_TRUE` to also obtain full list of allocations and free spaces.
    public void buildVirtualBlockStatsString(
        VmaVirtualBlock virtualBlock,
        PointerPtr ppStatsString,
        @NativeType("VkBool32") @Unsigned int detailedMap
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$vmaBuildVirtualBlockStatsString);
        try {
            hFunction.invokeExact(
                virtualBlock.segment(),
                ppStatsString.segment(),
                detailedMap
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// Frees a string returned by vmaBuildVirtualBlockStatsString().
    ///
    public void freeVirtualBlockStatsString(
        VmaVirtualBlock virtualBlock,
        @Nullable BytePtr pStatsString
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$vmaFreeVirtualBlockStatsString);
        try {
            hFunction.invokeExact(
                virtualBlock.segment(),
                (MemorySegment) (pStatsString != null ? pStatsString.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// Builds and returns statistics as a null-terminated string in JSON format.
    ///
    /// @param allocator
    /// @param ppStatsString Must be freed using vmaFreeStatsString() function.
    /// @param detailedMap
    public void buildStatsString(
        VmaAllocator allocator,
        PointerPtr ppStatsString,
        @NativeType("VkBool32") @Unsigned int detailedMap
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$vmaBuildStatsString);
        try {
            hFunction.invokeExact(
                allocator.segment(),
                ppStatsString.segment(),
                detailedMap
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void freeStatsString(
        VmaAllocator allocator,
        @Nullable BytePtr pStatsString
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$vmaFreeStatsString);
        try {
            hFunction.invokeExact(
                allocator.segment(),
                (MemorySegment) (pStatsString != null ? pStatsString.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
    // endregion

    // region segments and handles
    public final @Nullable MemorySegment SEGMENT$vmaImportVulkanFunctionsFromVolk;
    public final @Nullable MemorySegment SEGMENT$vmaCreateAllocator;
    public final @Nullable MemorySegment SEGMENT$vmaDestroyAllocator;
    public final @Nullable MemorySegment SEGMENT$vmaGetAllocatorInfo;
    public final @Nullable MemorySegment SEGMENT$vmaGetPhysicalDeviceProperties;
    public final @Nullable MemorySegment SEGMENT$vmaGetMemoryProperties;
    public final @Nullable MemorySegment SEGMENT$vmaGetMemoryTypeProperties;
    public final @Nullable MemorySegment SEGMENT$vmaSetCurrentFrameIndex;
    public final @Nullable MemorySegment SEGMENT$vmaCalculateStatistics;
    public final @Nullable MemorySegment SEGMENT$vmaGetHeapBudgets;
    public final @Nullable MemorySegment SEGMENT$vmaFindMemoryTypeIndex;
    public final @Nullable MemorySegment SEGMENT$vmaFindMemoryTypeIndexForBufferInfo;
    public final @Nullable MemorySegment SEGMENT$vmaFindMemoryTypeIndexForImageInfo;
    public final @Nullable MemorySegment SEGMENT$vmaCreatePool;
    public final @Nullable MemorySegment SEGMENT$vmaDestroyPool;
    public final @Nullable MemorySegment SEGMENT$vmaGetPoolStatistics;
    public final @Nullable MemorySegment SEGMENT$vmaCalculatePoolStatistics;
    public final @Nullable MemorySegment SEGMENT$vmaCheckPoolCorruption;
    public final @Nullable MemorySegment SEGMENT$vmaGetPoolName;
    public final @Nullable MemorySegment SEGMENT$vmaSetPoolName;
    public final @Nullable MemorySegment SEGMENT$vmaAllocateMemory;
    public final @Nullable MemorySegment SEGMENT$vmaAllocateDedicatedMemory;
    public final @Nullable MemorySegment SEGMENT$vmaAllocateMemoryPages;
    public final @Nullable MemorySegment SEGMENT$vmaAllocateMemoryForBuffer;
    public final @Nullable MemorySegment SEGMENT$vmaAllocateMemoryForImage;
    public final @Nullable MemorySegment SEGMENT$vmaFreeMemory;
    public final @Nullable MemorySegment SEGMENT$vmaFreeMemoryPages;
    public final @Nullable MemorySegment SEGMENT$vmaGetAllocationInfo;
    public final @Nullable MemorySegment SEGMENT$vmaGetAllocationInfo2;
    public final @Nullable MemorySegment SEGMENT$vmaSetAllocationUserData;
    public final @Nullable MemorySegment SEGMENT$vmaSetAllocationName;
    public final @Nullable MemorySegment SEGMENT$vmaGetAllocationMemoryProperties;
    public final @Nullable MemorySegment SEGMENT$vmaGetMemoryWin32Handle;
    public final @Nullable MemorySegment SEGMENT$vmaGetMemoryWin32Handle2;
    public final @Nullable MemorySegment SEGMENT$vmaMapMemory;
    public final @Nullable MemorySegment SEGMENT$vmaUnmapMemory;
    public final @Nullable MemorySegment SEGMENT$vmaFlushAllocation;
    public final @Nullable MemorySegment SEGMENT$vmaInvalidateAllocation;
    public final @Nullable MemorySegment SEGMENT$vmaFlushAllocations;
    public final @Nullable MemorySegment SEGMENT$vmaInvalidateAllocations;
    public final @Nullable MemorySegment SEGMENT$vmaCopyMemoryToAllocation;
    public final @Nullable MemorySegment SEGMENT$vmaCopyAllocationToMemory;
    public final @Nullable MemorySegment SEGMENT$vmaCheckCorruption;
    public final @Nullable MemorySegment SEGMENT$vmaBeginDefragmentation;
    public final @Nullable MemorySegment SEGMENT$vmaEndDefragmentation;
    public final @Nullable MemorySegment SEGMENT$vmaBeginDefragmentationPass;
    public final @Nullable MemorySegment SEGMENT$vmaEndDefragmentationPass;
    public final @Nullable MemorySegment SEGMENT$vmaBindBufferMemory;
    public final @Nullable MemorySegment SEGMENT$vmaBindBufferMemory2;
    public final @Nullable MemorySegment SEGMENT$vmaBindImageMemory;
    public final @Nullable MemorySegment SEGMENT$vmaBindImageMemory2;
    public final @Nullable MemorySegment SEGMENT$vmaCreateBuffer;
    public final @Nullable MemorySegment SEGMENT$vmaCreateBufferWithAlignment;
    public final @Nullable MemorySegment SEGMENT$vmaCreateDedicatedBuffer;
    public final @Nullable MemorySegment SEGMENT$vmaCreateAliasingBuffer;
    public final @Nullable MemorySegment SEGMENT$vmaCreateAliasingBuffer2;
    public final @Nullable MemorySegment SEGMENT$vmaDestroyBuffer;
    public final @Nullable MemorySegment SEGMENT$vmaCreateImage;
    public final @Nullable MemorySegment SEGMENT$vmaCreateDedicatedImage;
    public final @Nullable MemorySegment SEGMENT$vmaCreateAliasingImage;
    public final @Nullable MemorySegment SEGMENT$vmaCreateAliasingImage2;
    public final @Nullable MemorySegment SEGMENT$vmaDestroyImage;
    public final @Nullable MemorySegment SEGMENT$vmaCreateVirtualBlock;
    public final @Nullable MemorySegment SEGMENT$vmaDestroyVirtualBlock;
    public final @Nullable MemorySegment SEGMENT$vmaIsVirtualBlockEmpty;
    public final @Nullable MemorySegment SEGMENT$vmaGetVirtualAllocationInfo;
    public final @Nullable MemorySegment SEGMENT$vmaVirtualAllocate;
    public final @Nullable MemorySegment SEGMENT$vmaVirtualFree;
    public final @Nullable MemorySegment SEGMENT$vmaClearVirtualBlock;
    public final @Nullable MemorySegment SEGMENT$vmaSetVirtualAllocationUserData;
    public final @Nullable MemorySegment SEGMENT$vmaGetVirtualBlockStatistics;
    public final @Nullable MemorySegment SEGMENT$vmaCalculateVirtualBlockStatistics;
    public final @Nullable MemorySegment SEGMENT$vmaBuildVirtualBlockStatsString;
    public final @Nullable MemorySegment SEGMENT$vmaFreeVirtualBlockStatsString;
    public final @Nullable MemorySegment SEGMENT$vmaBuildStatsString;
    public final @Nullable MemorySegment SEGMENT$vmaFreeStatsString;
    public final @Nullable MethodHandle HANDLE$vmaImportVulkanFunctionsFromVolk;
    public final @Nullable MethodHandle HANDLE$vmaCreateAllocator;
    public final @Nullable MethodHandle HANDLE$vmaDestroyAllocator;
    public final @Nullable MethodHandle HANDLE$vmaGetAllocatorInfo;
    public final @Nullable MethodHandle HANDLE$vmaGetPhysicalDeviceProperties;
    public final @Nullable MethodHandle HANDLE$vmaGetMemoryProperties;
    public final @Nullable MethodHandle HANDLE$vmaGetMemoryTypeProperties;
    public final @Nullable MethodHandle HANDLE$vmaSetCurrentFrameIndex;
    public final @Nullable MethodHandle HANDLE$vmaCalculateStatistics;
    public final @Nullable MethodHandle HANDLE$vmaGetHeapBudgets;
    public final @Nullable MethodHandle HANDLE$vmaFindMemoryTypeIndex;
    public final @Nullable MethodHandle HANDLE$vmaFindMemoryTypeIndexForBufferInfo;
    public final @Nullable MethodHandle HANDLE$vmaFindMemoryTypeIndexForImageInfo;
    public final @Nullable MethodHandle HANDLE$vmaCreatePool;
    public final @Nullable MethodHandle HANDLE$vmaDestroyPool;
    public final @Nullable MethodHandle HANDLE$vmaGetPoolStatistics;
    public final @Nullable MethodHandle HANDLE$vmaCalculatePoolStatistics;
    public final @Nullable MethodHandle HANDLE$vmaCheckPoolCorruption;
    public final @Nullable MethodHandle HANDLE$vmaGetPoolName;
    public final @Nullable MethodHandle HANDLE$vmaSetPoolName;
    public final @Nullable MethodHandle HANDLE$vmaAllocateMemory;
    public final @Nullable MethodHandle HANDLE$vmaAllocateDedicatedMemory;
    public final @Nullable MethodHandle HANDLE$vmaAllocateMemoryPages;
    public final @Nullable MethodHandle HANDLE$vmaAllocateMemoryForBuffer;
    public final @Nullable MethodHandle HANDLE$vmaAllocateMemoryForImage;
    public final @Nullable MethodHandle HANDLE$vmaFreeMemory;
    public final @Nullable MethodHandle HANDLE$vmaFreeMemoryPages;
    public final @Nullable MethodHandle HANDLE$vmaGetAllocationInfo;
    public final @Nullable MethodHandle HANDLE$vmaGetAllocationInfo2;
    public final @Nullable MethodHandle HANDLE$vmaSetAllocationUserData;
    public final @Nullable MethodHandle HANDLE$vmaSetAllocationName;
    public final @Nullable MethodHandle HANDLE$vmaGetAllocationMemoryProperties;
    public final @Nullable MethodHandle HANDLE$vmaGetMemoryWin32Handle;
    public final @Nullable MethodHandle HANDLE$vmaGetMemoryWin32Handle2;
    public final @Nullable MethodHandle HANDLE$vmaMapMemory;
    public final @Nullable MethodHandle HANDLE$vmaUnmapMemory;
    public final @Nullable MethodHandle HANDLE$vmaFlushAllocation;
    public final @Nullable MethodHandle HANDLE$vmaInvalidateAllocation;
    public final @Nullable MethodHandle HANDLE$vmaFlushAllocations;
    public final @Nullable MethodHandle HANDLE$vmaInvalidateAllocations;
    public final @Nullable MethodHandle HANDLE$vmaCopyMemoryToAllocation;
    public final @Nullable MethodHandle HANDLE$vmaCopyAllocationToMemory;
    public final @Nullable MethodHandle HANDLE$vmaCheckCorruption;
    public final @Nullable MethodHandle HANDLE$vmaBeginDefragmentation;
    public final @Nullable MethodHandle HANDLE$vmaEndDefragmentation;
    public final @Nullable MethodHandle HANDLE$vmaBeginDefragmentationPass;
    public final @Nullable MethodHandle HANDLE$vmaEndDefragmentationPass;
    public final @Nullable MethodHandle HANDLE$vmaBindBufferMemory;
    public final @Nullable MethodHandle HANDLE$vmaBindBufferMemory2;
    public final @Nullable MethodHandle HANDLE$vmaBindImageMemory;
    public final @Nullable MethodHandle HANDLE$vmaBindImageMemory2;
    public final @Nullable MethodHandle HANDLE$vmaCreateBuffer;
    public final @Nullable MethodHandle HANDLE$vmaCreateBufferWithAlignment;
    public final @Nullable MethodHandle HANDLE$vmaCreateDedicatedBuffer;
    public final @Nullable MethodHandle HANDLE$vmaCreateAliasingBuffer;
    public final @Nullable MethodHandle HANDLE$vmaCreateAliasingBuffer2;
    public final @Nullable MethodHandle HANDLE$vmaDestroyBuffer;
    public final @Nullable MethodHandle HANDLE$vmaCreateImage;
    public final @Nullable MethodHandle HANDLE$vmaCreateDedicatedImage;
    public final @Nullable MethodHandle HANDLE$vmaCreateAliasingImage;
    public final @Nullable MethodHandle HANDLE$vmaCreateAliasingImage2;
    public final @Nullable MethodHandle HANDLE$vmaDestroyImage;
    public final @Nullable MethodHandle HANDLE$vmaCreateVirtualBlock;
    public final @Nullable MethodHandle HANDLE$vmaDestroyVirtualBlock;
    public final @Nullable MethodHandle HANDLE$vmaIsVirtualBlockEmpty;
    public final @Nullable MethodHandle HANDLE$vmaGetVirtualAllocationInfo;
    public final @Nullable MethodHandle HANDLE$vmaVirtualAllocate;
    public final @Nullable MethodHandle HANDLE$vmaVirtualFree;
    public final @Nullable MethodHandle HANDLE$vmaClearVirtualBlock;
    public final @Nullable MethodHandle HANDLE$vmaSetVirtualAllocationUserData;
    public final @Nullable MethodHandle HANDLE$vmaGetVirtualBlockStatistics;
    public final @Nullable MethodHandle HANDLE$vmaCalculateVirtualBlockStatistics;
    public final @Nullable MethodHandle HANDLE$vmaBuildVirtualBlockStatsString;
    public final @Nullable MethodHandle HANDLE$vmaFreeVirtualBlockStatsString;
    public final @Nullable MethodHandle HANDLE$vmaBuildStatsString;
    public final @Nullable MethodHandle HANDLE$vmaFreeStatsString;
    // endregion

    public static final class Descriptors {
        public static final FunctionDescriptor DESCRIPTOR$vmaImportVulkanFunctionsFromVolk = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(VmaAllocatorCreateInfo.LAYOUT),
            ValueLayout.ADDRESS.withTargetLayout(VmaVulkanFunctions.LAYOUT)
        );

        public static final FunctionDescriptor DESCRIPTOR$vmaCreateAllocator = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(VmaAllocatorCreateInfo.LAYOUT),
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS)
        );

        public static final FunctionDescriptor DESCRIPTOR$vmaDestroyAllocator = FunctionDescriptor.ofVoid(
            ValueLayout.ADDRESS
        );

        public static final FunctionDescriptor DESCRIPTOR$vmaGetAllocatorInfo = FunctionDescriptor.ofVoid(
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS.withTargetLayout(VmaAllocatorInfo.LAYOUT)
        );

        public static final FunctionDescriptor DESCRIPTOR$vmaGetPhysicalDeviceProperties = FunctionDescriptor.ofVoid(
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS.withTargetLayout(VkPhysicalDeviceProperties.LAYOUT))
        );

        public static final FunctionDescriptor DESCRIPTOR$vmaGetMemoryProperties = FunctionDescriptor.ofVoid(
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS.withTargetLayout(VkPhysicalDeviceMemoryProperties.LAYOUT))
        );

        public static final FunctionDescriptor DESCRIPTOR$vmaGetMemoryTypeProperties = FunctionDescriptor.ofVoid(
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT)
        );

        public static final FunctionDescriptor DESCRIPTOR$vmaSetCurrentFrameIndex = FunctionDescriptor.ofVoid(
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT
        );

        public static final FunctionDescriptor DESCRIPTOR$vmaCalculateStatistics = FunctionDescriptor.ofVoid(
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS.withTargetLayout(VmaTotalStatistics.LAYOUT)
        );

        public static final FunctionDescriptor DESCRIPTOR$vmaGetHeapBudgets = FunctionDescriptor.ofVoid(
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS.withTargetLayout(VmaBudget.LAYOUT)
        );

        public static final FunctionDescriptor DESCRIPTOR$vmaFindMemoryTypeIndex = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(VmaAllocationCreateInfo.LAYOUT),
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT)
        );

        public static final FunctionDescriptor DESCRIPTOR$vmaFindMemoryTypeIndexForBufferInfo = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS.withTargetLayout(VkBufferCreateInfo.LAYOUT),
            ValueLayout.ADDRESS.withTargetLayout(VmaAllocationCreateInfo.LAYOUT),
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT)
        );

        public static final FunctionDescriptor DESCRIPTOR$vmaFindMemoryTypeIndexForImageInfo = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS.withTargetLayout(VkImageCreateInfo.LAYOUT),
            ValueLayout.ADDRESS.withTargetLayout(VmaAllocationCreateInfo.LAYOUT),
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT)
        );

        public static final FunctionDescriptor DESCRIPTOR$vmaCreatePool = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS.withTargetLayout(VmaPoolCreateInfo.LAYOUT),
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS)
        );

        public static final FunctionDescriptor DESCRIPTOR$vmaDestroyPool = FunctionDescriptor.ofVoid(
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS
        );

        public static final FunctionDescriptor DESCRIPTOR$vmaGetPoolStatistics = FunctionDescriptor.ofVoid(
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS.withTargetLayout(VmaStatistics.LAYOUT)
        );

        public static final FunctionDescriptor DESCRIPTOR$vmaCalculatePoolStatistics = FunctionDescriptor.ofVoid(
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS.withTargetLayout(VmaDetailedStatistics.LAYOUT)
        );

        public static final FunctionDescriptor DESCRIPTOR$vmaCheckPoolCorruption = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS
        );

        public static final FunctionDescriptor DESCRIPTOR$vmaGetPoolName = FunctionDescriptor.ofVoid(
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_BYTE))
        );

        public static final FunctionDescriptor DESCRIPTOR$vmaSetPoolName = FunctionDescriptor.ofVoid(
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_BYTE)
        );

        public static final FunctionDescriptor DESCRIPTOR$vmaAllocateMemory = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS.withTargetLayout(VkMemoryRequirements.LAYOUT),
            ValueLayout.ADDRESS.withTargetLayout(VmaAllocationCreateInfo.LAYOUT),
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS),
            ValueLayout.ADDRESS.withTargetLayout(VmaAllocationInfo.LAYOUT)
        );

        public static final FunctionDescriptor DESCRIPTOR$vmaAllocateDedicatedMemory = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS.withTargetLayout(VkMemoryRequirements.LAYOUT),
            ValueLayout.ADDRESS.withTargetLayout(VmaAllocationCreateInfo.LAYOUT),
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS),
            ValueLayout.ADDRESS.withTargetLayout(VmaAllocationInfo.LAYOUT)
        );

        public static final FunctionDescriptor DESCRIPTOR$vmaAllocateMemoryPages = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS.withTargetLayout(VkMemoryRequirements.LAYOUT),
            ValueLayout.ADDRESS.withTargetLayout(VmaAllocationCreateInfo.LAYOUT),
            NativeLayout.C_SIZE_T,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS),
            ValueLayout.ADDRESS.withTargetLayout(VmaAllocationInfo.LAYOUT)
        );

        public static final FunctionDescriptor DESCRIPTOR$vmaAllocateMemoryForBuffer = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS.withTargetLayout(VmaAllocationCreateInfo.LAYOUT),
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS),
            ValueLayout.ADDRESS.withTargetLayout(VmaAllocationInfo.LAYOUT)
        );

        public static final FunctionDescriptor DESCRIPTOR$vmaAllocateMemoryForImage = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS.withTargetLayout(VmaAllocationCreateInfo.LAYOUT),
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS),
            ValueLayout.ADDRESS.withTargetLayout(VmaAllocationInfo.LAYOUT)
        );

        public static final FunctionDescriptor DESCRIPTOR$vmaFreeMemory = FunctionDescriptor.ofVoid(
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS
        );

        public static final FunctionDescriptor DESCRIPTOR$vmaFreeMemoryPages = FunctionDescriptor.ofVoid(
            ValueLayout.ADDRESS,
            NativeLayout.C_SIZE_T,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS)
        );

        public static final FunctionDescriptor DESCRIPTOR$vmaGetAllocationInfo = FunctionDescriptor.ofVoid(
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS.withTargetLayout(VmaAllocationInfo.LAYOUT)
        );

        public static final FunctionDescriptor DESCRIPTOR$vmaGetAllocationInfo2 = FunctionDescriptor.ofVoid(
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS.withTargetLayout(VmaAllocationInfo2.LAYOUT)
        );

        public static final FunctionDescriptor DESCRIPTOR$vmaSetAllocationUserData = FunctionDescriptor.ofVoid(
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS
        );

        public static final FunctionDescriptor DESCRIPTOR$vmaSetAllocationName = FunctionDescriptor.ofVoid(
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_BYTE)
        );

        public static final FunctionDescriptor DESCRIPTOR$vmaGetAllocationMemoryProperties = FunctionDescriptor.ofVoid(
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT)
        );

        public static final FunctionDescriptor DESCRIPTOR$vmaGetMemoryWin32Handle = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS)
        );

        public static final FunctionDescriptor DESCRIPTOR$vmaGetMemoryWin32Handle2 = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS)
        );

        public static final FunctionDescriptor DESCRIPTOR$vmaMapMemory = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS)
        );

        public static final FunctionDescriptor DESCRIPTOR$vmaUnmapMemory = FunctionDescriptor.ofVoid(
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS
        );

        public static final FunctionDescriptor DESCRIPTOR$vmaFlushAllocation = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_LONG,
            ValueLayout.JAVA_LONG
        );

        public static final FunctionDescriptor DESCRIPTOR$vmaInvalidateAllocation = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_LONG,
            ValueLayout.JAVA_LONG
        );

        public static final FunctionDescriptor DESCRIPTOR$vmaFlushAllocations = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS),
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_LONG),
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_LONG)
        );

        public static final FunctionDescriptor DESCRIPTOR$vmaInvalidateAllocations = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS),
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_LONG),
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_LONG)
        );

        public static final FunctionDescriptor DESCRIPTOR$vmaCopyMemoryToAllocation = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_LONG,
            ValueLayout.JAVA_LONG
        );

        public static final FunctionDescriptor DESCRIPTOR$vmaCopyAllocationToMemory = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_LONG,
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_LONG
        );

        public static final FunctionDescriptor DESCRIPTOR$vmaCheckCorruption = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT
        );

        public static final FunctionDescriptor DESCRIPTOR$vmaBeginDefragmentation = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS.withTargetLayout(VmaDefragmentationInfo.LAYOUT),
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS)
        );

        public static final FunctionDescriptor DESCRIPTOR$vmaEndDefragmentation = FunctionDescriptor.ofVoid(
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS.withTargetLayout(VmaDefragmentationStats.LAYOUT)
        );

        public static final FunctionDescriptor DESCRIPTOR$vmaBeginDefragmentationPass = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS.withTargetLayout(VmaDefragmentationPassMoveInfo.LAYOUT)
        );

        public static final FunctionDescriptor DESCRIPTOR$vmaEndDefragmentationPass = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS.withTargetLayout(VmaDefragmentationPassMoveInfo.LAYOUT)
        );

        public static final FunctionDescriptor DESCRIPTOR$vmaBindBufferMemory = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS
        );

        public static final FunctionDescriptor DESCRIPTOR$vmaBindBufferMemory2 = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_LONG,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS
        );

        public static final FunctionDescriptor DESCRIPTOR$vmaBindImageMemory = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS
        );

        public static final FunctionDescriptor DESCRIPTOR$vmaBindImageMemory2 = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_LONG,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS
        );

        public static final FunctionDescriptor DESCRIPTOR$vmaCreateBuffer = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS.withTargetLayout(VkBufferCreateInfo.LAYOUT),
            ValueLayout.ADDRESS.withTargetLayout(VmaAllocationCreateInfo.LAYOUT),
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS),
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS),
            ValueLayout.ADDRESS.withTargetLayout(VmaAllocationInfo.LAYOUT)
        );

        public static final FunctionDescriptor DESCRIPTOR$vmaCreateBufferWithAlignment = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS.withTargetLayout(VkBufferCreateInfo.LAYOUT),
            ValueLayout.ADDRESS.withTargetLayout(VmaAllocationCreateInfo.LAYOUT),
            ValueLayout.JAVA_LONG,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS),
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS),
            ValueLayout.ADDRESS.withTargetLayout(VmaAllocationInfo.LAYOUT)
        );

        public static final FunctionDescriptor DESCRIPTOR$vmaCreateDedicatedBuffer = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS.withTargetLayout(VkBufferCreateInfo.LAYOUT),
            ValueLayout.ADDRESS.withTargetLayout(VmaAllocationCreateInfo.LAYOUT),
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS),
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS),
            ValueLayout.ADDRESS.withTargetLayout(VmaAllocationInfo.LAYOUT)
        );

        public static final FunctionDescriptor DESCRIPTOR$vmaCreateAliasingBuffer = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS.withTargetLayout(VkBufferCreateInfo.LAYOUT),
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS)
        );

        public static final FunctionDescriptor DESCRIPTOR$vmaCreateAliasingBuffer2 = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_LONG,
            ValueLayout.ADDRESS.withTargetLayout(VkBufferCreateInfo.LAYOUT),
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS)
        );

        public static final FunctionDescriptor DESCRIPTOR$vmaDestroyBuffer = FunctionDescriptor.ofVoid(
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS
        );

        public static final FunctionDescriptor DESCRIPTOR$vmaCreateImage = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS.withTargetLayout(VkImageCreateInfo.LAYOUT),
            ValueLayout.ADDRESS.withTargetLayout(VmaAllocationCreateInfo.LAYOUT),
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS),
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS),
            ValueLayout.ADDRESS.withTargetLayout(VmaAllocationInfo.LAYOUT)
        );

        public static final FunctionDescriptor DESCRIPTOR$vmaCreateDedicatedImage = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS.withTargetLayout(VkImageCreateInfo.LAYOUT),
            ValueLayout.ADDRESS.withTargetLayout(VmaAllocationCreateInfo.LAYOUT),
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS),
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS),
            ValueLayout.ADDRESS.withTargetLayout(VmaAllocationInfo.LAYOUT)
        );

        public static final FunctionDescriptor DESCRIPTOR$vmaCreateAliasingImage = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS.withTargetLayout(VkImageCreateInfo.LAYOUT),
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS)
        );

        public static final FunctionDescriptor DESCRIPTOR$vmaCreateAliasingImage2 = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_LONG,
            ValueLayout.ADDRESS.withTargetLayout(VkImageCreateInfo.LAYOUT),
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS)
        );

        public static final FunctionDescriptor DESCRIPTOR$vmaDestroyImage = FunctionDescriptor.ofVoid(
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS
        );

        public static final FunctionDescriptor DESCRIPTOR$vmaCreateVirtualBlock = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(VmaVirtualBlockCreateInfo.LAYOUT),
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS)
        );

        public static final FunctionDescriptor DESCRIPTOR$vmaDestroyVirtualBlock = FunctionDescriptor.ofVoid(
            ValueLayout.ADDRESS
        );

        public static final FunctionDescriptor DESCRIPTOR$vmaIsVirtualBlockEmpty = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS
        );

        public static final FunctionDescriptor DESCRIPTOR$vmaGetVirtualAllocationInfo = FunctionDescriptor.ofVoid(
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS.withTargetLayout(VmaVirtualAllocationInfo.LAYOUT)
        );

        public static final FunctionDescriptor DESCRIPTOR$vmaVirtualAllocate = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS.withTargetLayout(VmaVirtualAllocationCreateInfo.LAYOUT),
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS),
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_LONG)
        );

        public static final FunctionDescriptor DESCRIPTOR$vmaVirtualFree = FunctionDescriptor.ofVoid(
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS
        );

        public static final FunctionDescriptor DESCRIPTOR$vmaClearVirtualBlock = FunctionDescriptor.ofVoid(
            ValueLayout.ADDRESS
        );

        public static final FunctionDescriptor DESCRIPTOR$vmaSetVirtualAllocationUserData = FunctionDescriptor.ofVoid(
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS
        );

        public static final FunctionDescriptor DESCRIPTOR$vmaGetVirtualBlockStatistics = FunctionDescriptor.ofVoid(
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS.withTargetLayout(VmaStatistics.LAYOUT)
        );

        public static final FunctionDescriptor DESCRIPTOR$vmaCalculateVirtualBlockStatistics = FunctionDescriptor.ofVoid(
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS.withTargetLayout(VmaDetailedStatistics.LAYOUT)
        );

        public static final FunctionDescriptor DESCRIPTOR$vmaBuildVirtualBlockStatsString = FunctionDescriptor.ofVoid(
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_BYTE)),
            ValueLayout.JAVA_INT
        );

        public static final FunctionDescriptor DESCRIPTOR$vmaFreeVirtualBlockStatsString = FunctionDescriptor.ofVoid(
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_BYTE)
        );

        public static final FunctionDescriptor DESCRIPTOR$vmaBuildStatsString = FunctionDescriptor.ofVoid(
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_BYTE)),
            ValueLayout.JAVA_INT
        );

        public static final FunctionDescriptor DESCRIPTOR$vmaFreeStatsString = FunctionDescriptor.ofVoid(
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_BYTE)
        );

        /// Constructing this class is nonsense so the constructor is made private.
        private Descriptors() {}
    }
}
