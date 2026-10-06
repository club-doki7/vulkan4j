package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkPhysicalDeviceConditionalRenderingFeaturesEXT} and {@link VkPhysicalDeviceConditionalRenderingFeaturesEXT.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkPhysicalDeviceConditionalRenderingFeaturesEXT
    extends IPointer
    permits VkPhysicalDeviceConditionalRenderingFeaturesEXT, VkPhysicalDeviceConditionalRenderingFeaturesEXT.Ptr
{}
