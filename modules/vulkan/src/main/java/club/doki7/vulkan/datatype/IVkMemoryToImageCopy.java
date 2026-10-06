package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkMemoryToImageCopy} and {@link VkMemoryToImageCopy.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkMemoryToImageCopy
    extends IPointer
    permits VkMemoryToImageCopy, VkMemoryToImageCopy.Ptr
{}
