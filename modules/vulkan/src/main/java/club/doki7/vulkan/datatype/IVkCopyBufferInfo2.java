package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkCopyBufferInfo2} and {@link VkCopyBufferInfo2.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkCopyBufferInfo2
    extends IPointer
    permits VkCopyBufferInfo2, VkCopyBufferInfo2.Ptr
{}
