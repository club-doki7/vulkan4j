package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkVideoEncodeH264FrameSizeKHR} and {@link VkVideoEncodeH264FrameSizeKHR.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkVideoEncodeH264FrameSizeKHR
    extends IPointer
    permits VkVideoEncodeH264FrameSizeKHR, VkVideoEncodeH264FrameSizeKHR.Ptr
{}
