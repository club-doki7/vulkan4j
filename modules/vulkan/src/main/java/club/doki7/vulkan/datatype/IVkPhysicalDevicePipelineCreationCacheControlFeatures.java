package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkPhysicalDevicePipelineCreationCacheControlFeatures} and {@link VkPhysicalDevicePipelineCreationCacheControlFeatures.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkPhysicalDevicePipelineCreationCacheControlFeatures
    extends IPointer
    permits VkPhysicalDevicePipelineCreationCacheControlFeatures, VkPhysicalDevicePipelineCreationCacheControlFeatures.Ptr
{}
