package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkInitializePerformanceApiInfoINTEL} and {@link VkInitializePerformanceApiInfoINTEL.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkInitializePerformanceApiInfoINTEL
    extends IPointer
    permits VkInitializePerformanceApiInfoINTEL, VkInitializePerformanceApiInfoINTEL.Ptr
{}
