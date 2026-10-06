package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkVideoDecodeVP9PictureInfoKHR} and {@link VkVideoDecodeVP9PictureInfoKHR.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkVideoDecodeVP9PictureInfoKHR
    extends IPointer
    permits VkVideoDecodeVP9PictureInfoKHR, VkVideoDecodeVP9PictureInfoKHR.Ptr
{}
