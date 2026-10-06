package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkPhysicalDeviceLegacyDitheringFeaturesEXT} and {@link VkPhysicalDeviceLegacyDitheringFeaturesEXT.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkPhysicalDeviceLegacyDitheringFeaturesEXT
    extends IPointer
    permits VkPhysicalDeviceLegacyDitheringFeaturesEXT, VkPhysicalDeviceLegacyDitheringFeaturesEXT.Ptr
{}
