package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkPhysicalDeviceSampleLocationsPropertiesEXT} and {@link VkPhysicalDeviceSampleLocationsPropertiesEXT.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkPhysicalDeviceSampleLocationsPropertiesEXT
    extends IPointer
    permits VkPhysicalDeviceSampleLocationsPropertiesEXT, VkPhysicalDeviceSampleLocationsPropertiesEXT.Ptr
{}
