package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkPerformanceCounterDescriptionARM} and {@link VkPerformanceCounterDescriptionARM.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkPerformanceCounterDescriptionARM
    extends IPointer
    permits VkPerformanceCounterDescriptionARM, VkPerformanceCounterDescriptionARM.Ptr
{}
