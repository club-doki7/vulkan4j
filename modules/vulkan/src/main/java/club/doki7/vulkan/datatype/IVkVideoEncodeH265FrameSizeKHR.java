package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkVideoEncodeH265FrameSizeKHR} and {@link VkVideoEncodeH265FrameSizeKHR.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkVideoEncodeH265FrameSizeKHR
    extends IPointer
    permits VkVideoEncodeH265FrameSizeKHR, VkVideoEncodeH265FrameSizeKHR.Ptr
{}
