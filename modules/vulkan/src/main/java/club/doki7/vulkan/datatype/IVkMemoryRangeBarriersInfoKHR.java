package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkMemoryRangeBarriersInfoKHR} and {@link VkMemoryRangeBarriersInfoKHR.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkMemoryRangeBarriersInfoKHR
    extends IPointer
    permits VkMemoryRangeBarriersInfoKHR, VkMemoryRangeBarriersInfoKHR.Ptr
{}
