package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkSamplerCreateInfo} and {@link VkSamplerCreateInfo.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkSamplerCreateInfo
    extends IPointer
    permits VkSamplerCreateInfo, VkSamplerCreateInfo.Ptr
{}
