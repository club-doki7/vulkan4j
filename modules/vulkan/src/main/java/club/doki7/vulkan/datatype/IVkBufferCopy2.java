package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkBufferCopy2} and {@link VkBufferCopy2.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkBufferCopy2
    extends IPointer
    permits VkBufferCopy2, VkBufferCopy2.Ptr
{}
