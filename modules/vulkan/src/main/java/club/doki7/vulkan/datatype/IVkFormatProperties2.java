package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkFormatProperties2} and {@link VkFormatProperties2.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkFormatProperties2
    extends IPointer
    permits VkFormatProperties2, VkFormatProperties2.Ptr
{}
