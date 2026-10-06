package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkImageFormatProperties2} and {@link VkImageFormatProperties2.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkImageFormatProperties2
    extends IPointer
    permits VkImageFormatProperties2, VkImageFormatProperties2.Ptr
{}
