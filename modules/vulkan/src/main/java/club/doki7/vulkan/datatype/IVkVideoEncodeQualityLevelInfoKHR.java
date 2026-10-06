package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkVideoEncodeQualityLevelInfoKHR} and {@link VkVideoEncodeQualityLevelInfoKHR.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkVideoEncodeQualityLevelInfoKHR
    extends IPointer
    permits VkVideoEncodeQualityLevelInfoKHR, VkVideoEncodeQualityLevelInfoKHR.Ptr
{}
