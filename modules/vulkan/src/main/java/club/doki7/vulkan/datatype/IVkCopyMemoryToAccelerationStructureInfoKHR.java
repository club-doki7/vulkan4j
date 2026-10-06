package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkCopyMemoryToAccelerationStructureInfoKHR} and {@link VkCopyMemoryToAccelerationStructureInfoKHR.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkCopyMemoryToAccelerationStructureInfoKHR
    extends IPointer
    permits VkCopyMemoryToAccelerationStructureInfoKHR, VkCopyMemoryToAccelerationStructureInfoKHR.Ptr
{}
