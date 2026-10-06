package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkPhysicalDeviceLayeredApiPropertiesKHR} and {@link VkPhysicalDeviceLayeredApiPropertiesKHR.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkPhysicalDeviceLayeredApiPropertiesKHR
    extends IPointer
    permits VkPhysicalDeviceLayeredApiPropertiesKHR, VkPhysicalDeviceLayeredApiPropertiesKHR.Ptr
{}
