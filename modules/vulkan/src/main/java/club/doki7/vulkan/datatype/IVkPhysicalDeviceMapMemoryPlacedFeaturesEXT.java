package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkPhysicalDeviceMapMemoryPlacedFeaturesEXT} and {@link VkPhysicalDeviceMapMemoryPlacedFeaturesEXT.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkPhysicalDeviceMapMemoryPlacedFeaturesEXT
    extends IPointer
    permits VkPhysicalDeviceMapMemoryPlacedFeaturesEXT, VkPhysicalDeviceMapMemoryPlacedFeaturesEXT.Ptr
{}
