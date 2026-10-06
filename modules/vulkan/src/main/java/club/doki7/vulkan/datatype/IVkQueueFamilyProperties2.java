package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkQueueFamilyProperties2} and {@link VkQueueFamilyProperties2.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkQueueFamilyProperties2
    extends IPointer
    permits VkQueueFamilyProperties2, VkQueueFamilyProperties2.Ptr
{}
