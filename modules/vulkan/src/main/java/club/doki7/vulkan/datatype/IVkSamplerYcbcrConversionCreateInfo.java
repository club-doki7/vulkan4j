package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkSamplerYcbcrConversionCreateInfo} and {@link VkSamplerYcbcrConversionCreateInfo.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkSamplerYcbcrConversionCreateInfo
    extends IPointer
    permits VkSamplerYcbcrConversionCreateInfo, VkSamplerYcbcrConversionCreateInfo.Ptr
{}
