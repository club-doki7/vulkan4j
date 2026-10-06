package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkImageCopy} and {@link VkImageCopy.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkImageCopy
    extends IPointer
    permits VkImageCopy, VkImageCopy.Ptr
{}
