package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkVideoEncodeUsageInfoKHR} and {@link VkVideoEncodeUsageInfoKHR.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkVideoEncodeUsageInfoKHR
    extends IPointer
    permits VkVideoEncodeUsageInfoKHR, VkVideoEncodeUsageInfoKHR.Ptr
{}
