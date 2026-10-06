package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkAccelerationStructureMotionInfoNV} and {@link VkAccelerationStructureMotionInfoNV.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkAccelerationStructureMotionInfoNV
    extends IPointer
    permits VkAccelerationStructureMotionInfoNV, VkAccelerationStructureMotionInfoNV.Ptr
{}
