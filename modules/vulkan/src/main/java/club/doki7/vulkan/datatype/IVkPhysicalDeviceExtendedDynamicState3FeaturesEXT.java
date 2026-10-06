package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkPhysicalDeviceExtendedDynamicState3FeaturesEXT} and {@link VkPhysicalDeviceExtendedDynamicState3FeaturesEXT.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkPhysicalDeviceExtendedDynamicState3FeaturesEXT
    extends IPointer
    permits VkPhysicalDeviceExtendedDynamicState3FeaturesEXT, VkPhysicalDeviceExtendedDynamicState3FeaturesEXT.Ptr
{}
