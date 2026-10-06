package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkVideoEncodeH264ProfileInfoKHR} and {@link VkVideoEncodeH264ProfileInfoKHR.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkVideoEncodeH264ProfileInfoKHR
    extends IPointer
    permits VkVideoEncodeH264ProfileInfoKHR, VkVideoEncodeH264ProfileInfoKHR.Ptr
{}
