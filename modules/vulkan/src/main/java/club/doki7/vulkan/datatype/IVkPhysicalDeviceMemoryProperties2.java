package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkPhysicalDeviceMemoryProperties2} and {@link VkPhysicalDeviceMemoryProperties2.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkPhysicalDeviceMemoryProperties2
    extends IPointer
    permits VkPhysicalDeviceMemoryProperties2, VkPhysicalDeviceMemoryProperties2.Ptr
{}
