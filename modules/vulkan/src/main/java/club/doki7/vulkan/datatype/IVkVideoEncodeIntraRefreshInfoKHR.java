package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkVideoEncodeIntraRefreshInfoKHR} and {@link VkVideoEncodeIntraRefreshInfoKHR.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkVideoEncodeIntraRefreshInfoKHR
    extends IPointer
    permits VkVideoEncodeIntraRefreshInfoKHR, VkVideoEncodeIntraRefreshInfoKHR.Ptr
{}
