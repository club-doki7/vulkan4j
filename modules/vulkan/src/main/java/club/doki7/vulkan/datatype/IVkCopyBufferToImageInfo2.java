package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkCopyBufferToImageInfo2} and {@link VkCopyBufferToImageInfo2.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkCopyBufferToImageInfo2
    extends IPointer
    permits VkCopyBufferToImageInfo2, VkCopyBufferToImageInfo2.Ptr
{}
