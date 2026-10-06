package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkPhysicalDeviceDiscardRectanglePropertiesEXT} and {@link VkPhysicalDeviceDiscardRectanglePropertiesEXT.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkPhysicalDeviceDiscardRectanglePropertiesEXT
    extends IPointer
    permits VkPhysicalDeviceDiscardRectanglePropertiesEXT, VkPhysicalDeviceDiscardRectanglePropertiesEXT.Ptr
{}
