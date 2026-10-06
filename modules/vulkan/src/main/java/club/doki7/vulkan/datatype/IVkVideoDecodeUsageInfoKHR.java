package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkVideoDecodeUsageInfoKHR} and {@link VkVideoDecodeUsageInfoKHR.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkVideoDecodeUsageInfoKHR
    extends IPointer
    permits VkVideoDecodeUsageInfoKHR, VkVideoDecodeUsageInfoKHR.Ptr
{}
