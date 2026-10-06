package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkVideoEncodeH265PictureInfoKHR} and {@link VkVideoEncodeH265PictureInfoKHR.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkVideoEncodeH265PictureInfoKHR
    extends IPointer
    permits VkVideoEncodeH265PictureInfoKHR, VkVideoEncodeH265PictureInfoKHR.Ptr
{}
