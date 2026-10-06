package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkCopyAccelerationStructureToMemoryInfoKHR} and {@link VkCopyAccelerationStructureToMemoryInfoKHR.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkCopyAccelerationStructureToMemoryInfoKHR
    extends IPointer
    permits VkCopyAccelerationStructureToMemoryInfoKHR, VkCopyAccelerationStructureToMemoryInfoKHR.Ptr
{}
