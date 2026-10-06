package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkPerformanceConfigurationAcquireInfoINTEL} and {@link VkPerformanceConfigurationAcquireInfoINTEL.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkPerformanceConfigurationAcquireInfoINTEL
    extends IPointer
    permits VkPerformanceConfigurationAcquireInfoINTEL, VkPerformanceConfigurationAcquireInfoINTEL.Ptr
{}
