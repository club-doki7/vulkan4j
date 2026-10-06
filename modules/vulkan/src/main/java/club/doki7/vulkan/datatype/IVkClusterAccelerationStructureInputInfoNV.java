package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkClusterAccelerationStructureInputInfoNV} and {@link VkClusterAccelerationStructureInputInfoNV.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkClusterAccelerationStructureInputInfoNV
    extends IPointer
    permits VkClusterAccelerationStructureInputInfoNV, VkClusterAccelerationStructureInputInfoNV.Ptr
{}
