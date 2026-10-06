package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkAccelerationStructureVersionInfoKHR} and {@link VkAccelerationStructureVersionInfoKHR.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkAccelerationStructureVersionInfoKHR
    extends IPointer
    permits VkAccelerationStructureVersionInfoKHR, VkAccelerationStructureVersionInfoKHR.Ptr
{}
