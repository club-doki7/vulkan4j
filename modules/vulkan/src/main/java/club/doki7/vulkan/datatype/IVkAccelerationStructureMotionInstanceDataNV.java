package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkAccelerationStructureMotionInstanceDataNV} and {@link VkAccelerationStructureMotionInstanceDataNV.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkAccelerationStructureMotionInstanceDataNV
    extends IPointer
    permits VkAccelerationStructureMotionInstanceDataNV, VkAccelerationStructureMotionInstanceDataNV.Ptr
{}
