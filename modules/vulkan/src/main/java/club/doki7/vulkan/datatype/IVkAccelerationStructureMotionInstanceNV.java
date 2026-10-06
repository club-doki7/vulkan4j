package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkAccelerationStructureMotionInstanceNV} and {@link VkAccelerationStructureMotionInstanceNV.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkAccelerationStructureMotionInstanceNV
    extends IPointer
    permits VkAccelerationStructureMotionInstanceNV, VkAccelerationStructureMotionInstanceNV.Ptr
{}
