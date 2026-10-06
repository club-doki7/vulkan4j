package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkAccelerationStructureCreateInfo2KHR} and {@link VkAccelerationStructureCreateInfo2KHR.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkAccelerationStructureCreateInfo2KHR
    extends IPointer
    permits VkAccelerationStructureCreateInfo2KHR, VkAccelerationStructureCreateInfo2KHR.Ptr
{}
