package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkVideoEncodeAV1PictureInfoKHR} and {@link VkVideoEncodeAV1PictureInfoKHR.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkVideoEncodeAV1PictureInfoKHR
    extends IPointer
    permits VkVideoEncodeAV1PictureInfoKHR, VkVideoEncodeAV1PictureInfoKHR.Ptr
{}
