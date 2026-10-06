package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkPhysicalDevicePipelineProtectedAccessFeatures} and {@link VkPhysicalDevicePipelineProtectedAccessFeatures.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkPhysicalDevicePipelineProtectedAccessFeatures
    extends IPointer
    permits VkPhysicalDevicePipelineProtectedAccessFeatures, VkPhysicalDevicePipelineProtectedAccessFeatures.Ptr
{}
