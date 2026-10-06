package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkBufferCopy} and {@link VkBufferCopy.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkBufferCopy
    extends IPointer
    permits VkBufferCopy, VkBufferCopy.Ptr
{}
