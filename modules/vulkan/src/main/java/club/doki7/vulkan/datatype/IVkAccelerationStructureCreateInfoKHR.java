package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkAccelerationStructureCreateInfoKHR} and {@link VkAccelerationStructureCreateInfoKHR.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkAccelerationStructureCreateInfoKHR
    extends IPointer
    permits VkAccelerationStructureCreateInfoKHR, VkAccelerationStructureCreateInfoKHR.Ptr
{}
