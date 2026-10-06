package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkVideoEncodeRateControlInfoKHR} and {@link VkVideoEncodeRateControlInfoKHR.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkVideoEncodeRateControlInfoKHR
    extends IPointer
    permits VkVideoEncodeRateControlInfoKHR, VkVideoEncodeRateControlInfoKHR.Ptr
{}
