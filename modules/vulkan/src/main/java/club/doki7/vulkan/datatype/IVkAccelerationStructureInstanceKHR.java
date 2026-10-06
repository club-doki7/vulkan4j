package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkAccelerationStructureInstanceKHR} and {@link VkAccelerationStructureInstanceKHR.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkAccelerationStructureInstanceKHR
    extends IPointer
    permits VkAccelerationStructureInstanceKHR, VkAccelerationStructureInstanceKHR.Ptr
{}
