package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkImageCopy2} and {@link VkImageCopy2.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkImageCopy2
    extends IPointer
    permits VkImageCopy2, VkImageCopy2.Ptr
{}
