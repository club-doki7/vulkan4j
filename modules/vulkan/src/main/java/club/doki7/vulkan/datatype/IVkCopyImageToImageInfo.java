package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkCopyImageToImageInfo} and {@link VkCopyImageToImageInfo.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkCopyImageToImageInfo
    extends IPointer
    permits VkCopyImageToImageInfo, VkCopyImageToImageInfo.Ptr
{}
