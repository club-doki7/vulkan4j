package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkVideoDecodeH264PictureInfoKHR} and {@link VkVideoDecodeH264PictureInfoKHR.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkVideoDecodeH264PictureInfoKHR
    extends IPointer
    permits VkVideoDecodeH264PictureInfoKHR, VkVideoDecodeH264PictureInfoKHR.Ptr
{}
