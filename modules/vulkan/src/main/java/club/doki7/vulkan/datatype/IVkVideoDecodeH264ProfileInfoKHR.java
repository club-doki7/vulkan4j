package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkVideoDecodeH264ProfileInfoKHR} and {@link VkVideoDecodeH264ProfileInfoKHR.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkVideoDecodeH264ProfileInfoKHR
    extends IPointer
    permits VkVideoDecodeH264ProfileInfoKHR, VkVideoDecodeH264ProfileInfoKHR.Ptr
{}
