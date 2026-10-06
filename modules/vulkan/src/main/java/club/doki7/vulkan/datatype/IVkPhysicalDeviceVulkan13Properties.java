package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkPhysicalDeviceVulkan13Properties} and {@link VkPhysicalDeviceVulkan13Properties.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkPhysicalDeviceVulkan13Properties
    extends IPointer
    permits VkPhysicalDeviceVulkan13Properties, VkPhysicalDeviceVulkan13Properties.Ptr
{}
