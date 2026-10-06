package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkVideoDecodeH265PictureInfoKHR} and {@link VkVideoDecodeH265PictureInfoKHR.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkVideoDecodeH265PictureInfoKHR
    extends IPointer
    permits VkVideoDecodeH265PictureInfoKHR, VkVideoDecodeH265PictureInfoKHR.Ptr
{}
