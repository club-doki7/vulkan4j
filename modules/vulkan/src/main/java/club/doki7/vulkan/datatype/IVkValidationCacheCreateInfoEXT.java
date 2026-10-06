package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkValidationCacheCreateInfoEXT} and {@link VkValidationCacheCreateInfoEXT.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkValidationCacheCreateInfoEXT
    extends IPointer
    permits VkValidationCacheCreateInfoEXT, VkValidationCacheCreateInfoEXT.Ptr
{}
