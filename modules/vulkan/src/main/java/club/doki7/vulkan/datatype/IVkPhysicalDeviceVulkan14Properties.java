package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkPhysicalDeviceVulkan14Properties} and {@link VkPhysicalDeviceVulkan14Properties.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkPhysicalDeviceVulkan14Properties
    extends IPointer
    permits VkPhysicalDeviceVulkan14Properties, VkPhysicalDeviceVulkan14Properties.Ptr
{}
