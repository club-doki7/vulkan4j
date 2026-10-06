package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkVideoEncodeH264PictureInfoKHR} and {@link VkVideoEncodeH264PictureInfoKHR.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkVideoEncodeH264PictureInfoKHR
    extends IPointer
    permits VkVideoEncodeH264PictureInfoKHR, VkVideoEncodeH264PictureInfoKHR.Ptr
{}
