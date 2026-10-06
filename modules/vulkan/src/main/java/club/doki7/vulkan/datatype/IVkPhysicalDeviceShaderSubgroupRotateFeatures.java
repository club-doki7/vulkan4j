package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkPhysicalDeviceShaderSubgroupRotateFeatures} and {@link VkPhysicalDeviceShaderSubgroupRotateFeatures.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkPhysicalDeviceShaderSubgroupRotateFeatures
    extends IPointer
    permits VkPhysicalDeviceShaderSubgroupRotateFeatures, VkPhysicalDeviceShaderSubgroupRotateFeatures.Ptr
{}
