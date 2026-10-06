package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkPhysicalDeviceVulkan14Features} and {@link VkPhysicalDeviceVulkan14Features.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkPhysicalDeviceVulkan14Features
    extends IPointer
    permits VkPhysicalDeviceVulkan14Features, VkPhysicalDeviceVulkan14Features.Ptr
{}
