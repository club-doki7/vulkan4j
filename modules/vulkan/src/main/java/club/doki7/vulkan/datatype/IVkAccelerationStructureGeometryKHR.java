package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkAccelerationStructureGeometryKHR} and {@link VkAccelerationStructureGeometryKHR.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkAccelerationStructureGeometryKHR
    extends IPointer
    permits VkAccelerationStructureGeometryKHR, VkAccelerationStructureGeometryKHR.Ptr
{}
