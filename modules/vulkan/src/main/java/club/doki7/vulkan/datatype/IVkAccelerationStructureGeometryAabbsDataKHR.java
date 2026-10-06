package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkAccelerationStructureGeometryAabbsDataKHR} and {@link VkAccelerationStructureGeometryAabbsDataKHR.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkAccelerationStructureGeometryAabbsDataKHR
    extends IPointer
    permits VkAccelerationStructureGeometryAabbsDataKHR, VkAccelerationStructureGeometryAabbsDataKHR.Ptr
{}
