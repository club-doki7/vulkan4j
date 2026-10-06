package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkCopyAccelerationStructureInfoKHR} and {@link VkCopyAccelerationStructureInfoKHR.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkCopyAccelerationStructureInfoKHR
    extends IPointer
    permits VkCopyAccelerationStructureInfoKHR, VkCopyAccelerationStructureInfoKHR.Ptr
{}
