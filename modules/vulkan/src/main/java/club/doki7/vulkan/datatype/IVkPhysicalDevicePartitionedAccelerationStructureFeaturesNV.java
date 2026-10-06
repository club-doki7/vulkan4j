package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkPhysicalDevicePartitionedAccelerationStructureFeaturesNV} and {@link VkPhysicalDevicePartitionedAccelerationStructureFeaturesNV.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkPhysicalDevicePartitionedAccelerationStructureFeaturesNV
    extends IPointer
    permits VkPhysicalDevicePartitionedAccelerationStructureFeaturesNV, VkPhysicalDevicePartitionedAccelerationStructureFeaturesNV.Ptr
{}
