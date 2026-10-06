package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkPhysicalDeviceExtendedDynamicStateFeaturesEXT} and {@link VkPhysicalDeviceExtendedDynamicStateFeaturesEXT.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkPhysicalDeviceExtendedDynamicStateFeaturesEXT
    extends IPointer
    permits VkPhysicalDeviceExtendedDynamicStateFeaturesEXT, VkPhysicalDeviceExtendedDynamicStateFeaturesEXT.Ptr
{}
