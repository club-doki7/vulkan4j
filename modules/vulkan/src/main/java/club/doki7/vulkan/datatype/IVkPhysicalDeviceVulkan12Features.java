package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkPhysicalDeviceVulkan12Features} and {@link VkPhysicalDeviceVulkan12Features.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkPhysicalDeviceVulkan12Features
    extends IPointer
    permits VkPhysicalDeviceVulkan12Features, VkPhysicalDeviceVulkan12Features.Ptr
{}
