package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkAccelerationStructureCreateInfoNV} and {@link VkAccelerationStructureCreateInfoNV.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkAccelerationStructureCreateInfoNV
    extends IPointer
    permits VkAccelerationStructureCreateInfoNV, VkAccelerationStructureCreateInfoNV.Ptr
{}
