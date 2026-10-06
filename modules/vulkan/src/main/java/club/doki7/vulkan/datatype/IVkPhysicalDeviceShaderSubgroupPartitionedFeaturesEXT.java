package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkPhysicalDeviceShaderSubgroupPartitionedFeaturesEXT} and {@link VkPhysicalDeviceShaderSubgroupPartitionedFeaturesEXT.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkPhysicalDeviceShaderSubgroupPartitionedFeaturesEXT
    extends IPointer
    permits VkPhysicalDeviceShaderSubgroupPartitionedFeaturesEXT, VkPhysicalDeviceShaderSubgroupPartitionedFeaturesEXT.Ptr
{}
