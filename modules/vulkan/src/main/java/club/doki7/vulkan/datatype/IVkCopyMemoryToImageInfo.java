package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkCopyMemoryToImageInfo} and {@link VkCopyMemoryToImageInfo.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkCopyMemoryToImageInfo
    extends IPointer
    permits VkCopyMemoryToImageInfo, VkCopyMemoryToImageInfo.Ptr
{}
