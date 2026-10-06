package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkVideoDecodeAV1PictureInfoKHR} and {@link VkVideoDecodeAV1PictureInfoKHR.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkVideoDecodeAV1PictureInfoKHR
    extends IPointer
    permits VkVideoDecodeAV1PictureInfoKHR, VkVideoDecodeAV1PictureInfoKHR.Ptr
{}
