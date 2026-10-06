package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkPhysicalDeviceMultiDrawFeaturesEXT} and {@link VkPhysicalDeviceMultiDrawFeaturesEXT.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkPhysicalDeviceMultiDrawFeaturesEXT
    extends IPointer
    permits VkPhysicalDeviceMultiDrawFeaturesEXT, VkPhysicalDeviceMultiDrawFeaturesEXT.Ptr
{}
