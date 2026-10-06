package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkSamplerCustomBorderColorCreateInfoEXT} and {@link VkSamplerCustomBorderColorCreateInfoEXT.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkSamplerCustomBorderColorCreateInfoEXT
    extends IPointer
    permits VkSamplerCustomBorderColorCreateInfoEXT, VkSamplerCustomBorderColorCreateInfoEXT.Ptr
{}
