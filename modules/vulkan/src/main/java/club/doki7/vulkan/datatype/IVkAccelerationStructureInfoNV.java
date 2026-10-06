package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkAccelerationStructureInfoNV} and {@link VkAccelerationStructureInfoNV.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkAccelerationStructureInfoNV
    extends IPointer
    permits VkAccelerationStructureInfoNV, VkAccelerationStructureInfoNV.Ptr
{}
