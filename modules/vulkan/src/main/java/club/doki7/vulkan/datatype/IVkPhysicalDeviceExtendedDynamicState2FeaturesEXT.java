package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkPhysicalDeviceExtendedDynamicState2FeaturesEXT} and {@link VkPhysicalDeviceExtendedDynamicState2FeaturesEXT.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkPhysicalDeviceExtendedDynamicState2FeaturesEXT
    extends IPointer
    permits VkPhysicalDeviceExtendedDynamicState2FeaturesEXT, VkPhysicalDeviceExtendedDynamicState2FeaturesEXT.Ptr
{}
