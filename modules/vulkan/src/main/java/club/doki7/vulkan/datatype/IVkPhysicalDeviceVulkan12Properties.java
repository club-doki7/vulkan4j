package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkPhysicalDeviceVulkan12Properties} and {@link VkPhysicalDeviceVulkan12Properties.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkPhysicalDeviceVulkan12Properties
    extends IPointer
    permits VkPhysicalDeviceVulkan12Properties, VkPhysicalDeviceVulkan12Properties.Ptr
{}
