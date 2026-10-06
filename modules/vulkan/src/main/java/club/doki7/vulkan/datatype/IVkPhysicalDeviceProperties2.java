package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkPhysicalDeviceProperties2} and {@link VkPhysicalDeviceProperties2.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkPhysicalDeviceProperties2
    extends IPointer
    permits VkPhysicalDeviceProperties2, VkPhysicalDeviceProperties2.Ptr
{}
