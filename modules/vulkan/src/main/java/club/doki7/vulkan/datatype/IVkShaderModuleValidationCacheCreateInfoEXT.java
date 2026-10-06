package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkShaderModuleValidationCacheCreateInfoEXT} and {@link VkShaderModuleValidationCacheCreateInfoEXT.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkShaderModuleValidationCacheCreateInfoEXT
    extends IPointer
    permits VkShaderModuleValidationCacheCreateInfoEXT, VkShaderModuleValidationCacheCreateInfoEXT.Ptr
{}
