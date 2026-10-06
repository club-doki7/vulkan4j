package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkBufferImageCopy2} and {@link VkBufferImageCopy2.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkBufferImageCopy2
    extends IPointer
    permits VkBufferImageCopy2, VkBufferImageCopy2.Ptr
{}
