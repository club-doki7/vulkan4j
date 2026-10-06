package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkCopyImageToBufferInfo2} and {@link VkCopyImageToBufferInfo2.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkCopyImageToBufferInfo2
    extends IPointer
    permits VkCopyImageToBufferInfo2, VkCopyImageToBufferInfo2.Ptr
{}
