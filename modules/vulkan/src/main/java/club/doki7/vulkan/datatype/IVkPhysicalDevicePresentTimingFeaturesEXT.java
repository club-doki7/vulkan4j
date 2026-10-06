package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkPhysicalDevicePresentTimingFeaturesEXT} and {@link VkPhysicalDevicePresentTimingFeaturesEXT.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkPhysicalDevicePresentTimingFeaturesEXT
    extends IPointer
    permits VkPhysicalDevicePresentTimingFeaturesEXT, VkPhysicalDevicePresentTimingFeaturesEXT.Ptr
{}
