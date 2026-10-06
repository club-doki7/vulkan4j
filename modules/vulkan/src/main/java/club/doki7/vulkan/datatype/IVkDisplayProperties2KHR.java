package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkDisplayProperties2KHR} and {@link VkDisplayProperties2KHR.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkDisplayProperties2KHR
    extends IPointer
    permits VkDisplayProperties2KHR, VkDisplayProperties2KHR.Ptr
{}
