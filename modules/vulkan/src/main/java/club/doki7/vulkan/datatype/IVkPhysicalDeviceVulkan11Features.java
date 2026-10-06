package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkPhysicalDeviceVulkan11Features} and {@link VkPhysicalDeviceVulkan11Features.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkPhysicalDeviceVulkan11Features
    extends IPointer
    permits VkPhysicalDeviceVulkan11Features, VkPhysicalDeviceVulkan11Features.Ptr
{}
