package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkAccelerationStructureGeometryDataKHR} and {@link VkAccelerationStructureGeometryDataKHR.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkAccelerationStructureGeometryDataKHR
    extends IPointer
    permits VkAccelerationStructureGeometryDataKHR, VkAccelerationStructureGeometryDataKHR.Ptr
{}
