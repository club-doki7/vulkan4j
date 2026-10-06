package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkPhysicalDeviceMemoryProperties} and {@link VkPhysicalDeviceMemoryProperties.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkPhysicalDeviceMemoryProperties
    extends IPointer
    permits VkPhysicalDeviceMemoryProperties, VkPhysicalDeviceMemoryProperties.Ptr
{}
