package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkVideoEncodeQuantizationMapInfoKHR} and {@link VkVideoEncodeQuantizationMapInfoKHR.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkVideoEncodeQuantizationMapInfoKHR
    extends IPointer
    permits VkVideoEncodeQuantizationMapInfoKHR, VkVideoEncodeQuantizationMapInfoKHR.Ptr
{}
