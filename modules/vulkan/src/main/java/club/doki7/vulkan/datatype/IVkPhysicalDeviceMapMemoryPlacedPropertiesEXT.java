package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkPhysicalDeviceMapMemoryPlacedPropertiesEXT} and {@link VkPhysicalDeviceMapMemoryPlacedPropertiesEXT.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkPhysicalDeviceMapMemoryPlacedPropertiesEXT
    extends IPointer
    permits VkPhysicalDeviceMapMemoryPlacedPropertiesEXT, VkPhysicalDeviceMapMemoryPlacedPropertiesEXT.Ptr
{}
