package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkPhysicalDevicePipelineRobustnessProperties} and {@link VkPhysicalDevicePipelineRobustnessProperties.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkPhysicalDevicePipelineRobustnessProperties
    extends IPointer
    permits VkPhysicalDevicePipelineRobustnessProperties, VkPhysicalDevicePipelineRobustnessProperties.Ptr
{}
