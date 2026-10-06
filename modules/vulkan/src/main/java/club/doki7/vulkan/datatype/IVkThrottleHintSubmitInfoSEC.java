package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkThrottleHintSubmitInfoSEC} and {@link VkThrottleHintSubmitInfoSEC.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkThrottleHintSubmitInfoSEC
    extends IPointer
    permits VkThrottleHintSubmitInfoSEC, VkThrottleHintSubmitInfoSEC.Ptr
{}
