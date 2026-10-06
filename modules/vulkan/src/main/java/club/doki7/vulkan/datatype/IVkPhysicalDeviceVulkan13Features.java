package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkPhysicalDeviceVulkan13Features} and {@link VkPhysicalDeviceVulkan13Features.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkPhysicalDeviceVulkan13Features
    extends IPointer
    permits VkPhysicalDeviceVulkan13Features, VkPhysicalDeviceVulkan13Features.Ptr
{}
