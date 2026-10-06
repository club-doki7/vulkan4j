package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkBuildPartitionedAccelerationStructureInfoNV} and {@link VkBuildPartitionedAccelerationStructureInfoNV.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkBuildPartitionedAccelerationStructureInfoNV
    extends IPointer
    permits VkBuildPartitionedAccelerationStructureInfoNV, VkBuildPartitionedAccelerationStructureInfoNV.Ptr
{}
