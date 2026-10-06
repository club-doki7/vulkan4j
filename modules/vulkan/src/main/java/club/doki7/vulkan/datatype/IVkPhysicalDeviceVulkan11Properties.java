package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkPhysicalDeviceVulkan11Properties} and {@link VkPhysicalDeviceVulkan11Properties.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkPhysicalDeviceVulkan11Properties
    extends IPointer
    permits VkPhysicalDeviceVulkan11Properties, VkPhysicalDeviceVulkan11Properties.Ptr
{}
