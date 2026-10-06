package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkAccelerationStructureBuildSizesInfoKHR} and {@link VkAccelerationStructureBuildSizesInfoKHR.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkAccelerationStructureBuildSizesInfoKHR
    extends IPointer
    permits VkAccelerationStructureBuildSizesInfoKHR, VkAccelerationStructureBuildSizesInfoKHR.Ptr
{}
