package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkShaderCreateInfoEXT} and {@link VkShaderCreateInfoEXT.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkShaderCreateInfoEXT
    extends IPointer
    permits VkShaderCreateInfoEXT, VkShaderCreateInfoEXT.Ptr
{}
