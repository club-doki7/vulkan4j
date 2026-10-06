package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkSamplerReductionModeCreateInfo} and {@link VkSamplerReductionModeCreateInfo.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkSamplerReductionModeCreateInfo
    extends IPointer
    permits VkSamplerReductionModeCreateInfo, VkSamplerReductionModeCreateInfo.Ptr
{}
