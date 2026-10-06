package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkVideoEncodeH265QpKHR} and {@link VkVideoEncodeH265QpKHR.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkVideoEncodeH265QpKHR
    extends IPointer
    permits VkVideoEncodeH265QpKHR, VkVideoEncodeH265QpKHR.Ptr
{}
