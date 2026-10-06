package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkBindAccelerationStructureMemoryInfoNV} and {@link VkBindAccelerationStructureMemoryInfoNV.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkBindAccelerationStructureMemoryInfoNV
    extends IPointer
    permits VkBindAccelerationStructureMemoryInfoNV, VkBindAccelerationStructureMemoryInfoNV.Ptr
{}
