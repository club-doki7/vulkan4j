package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkPhysicalDeviceLayeredApiVulkanPropertiesKHR} and {@link VkPhysicalDeviceLayeredApiVulkanPropertiesKHR.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkPhysicalDeviceLayeredApiVulkanPropertiesKHR
    extends IPointer
    permits VkPhysicalDeviceLayeredApiVulkanPropertiesKHR, VkPhysicalDeviceLayeredApiVulkanPropertiesKHR.Ptr
{}
