package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkPartitionedAccelerationStructureFlagsNV} and {@link VkPartitionedAccelerationStructureFlagsNV.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkPartitionedAccelerationStructureFlagsNV
    extends IPointer
    permits VkPartitionedAccelerationStructureFlagsNV, VkPartitionedAccelerationStructureFlagsNV.Ptr
{}
