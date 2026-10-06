package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkVideoDecodeH265ProfileInfoKHR} and {@link VkVideoDecodeH265ProfileInfoKHR.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkVideoDecodeH265ProfileInfoKHR
    extends IPointer
    permits VkVideoDecodeH265ProfileInfoKHR, VkVideoDecodeH265ProfileInfoKHR.Ptr
{}
