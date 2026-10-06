package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkClusterAccelerationStructureCommandsInfoNV} and {@link VkClusterAccelerationStructureCommandsInfoNV.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkClusterAccelerationStructureCommandsInfoNV
    extends IPointer
    permits VkClusterAccelerationStructureCommandsInfoNV, VkClusterAccelerationStructureCommandsInfoNV.Ptr
{}
