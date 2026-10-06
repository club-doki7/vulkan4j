package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkMemoryRangeBarrierKHR} and {@link VkMemoryRangeBarrierKHR.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkMemoryRangeBarrierKHR
    extends IPointer
    permits VkMemoryRangeBarrierKHR, VkMemoryRangeBarrierKHR.Ptr
{}
