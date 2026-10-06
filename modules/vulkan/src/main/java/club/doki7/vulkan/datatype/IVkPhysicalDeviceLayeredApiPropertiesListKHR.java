package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkPhysicalDeviceLayeredApiPropertiesListKHR} and {@link VkPhysicalDeviceLayeredApiPropertiesListKHR.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkPhysicalDeviceLayeredApiPropertiesListKHR
    extends IPointer
    permits VkPhysicalDeviceLayeredApiPropertiesListKHR, VkPhysicalDeviceLayeredApiPropertiesListKHR.Ptr
{}
