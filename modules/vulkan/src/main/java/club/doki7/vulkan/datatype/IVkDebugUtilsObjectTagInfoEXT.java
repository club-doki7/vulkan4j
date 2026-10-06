package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkDebugUtilsObjectTagInfoEXT} and {@link VkDebugUtilsObjectTagInfoEXT.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkDebugUtilsObjectTagInfoEXT
    extends IPointer
    permits VkDebugUtilsObjectTagInfoEXT, VkDebugUtilsObjectTagInfoEXT.Ptr
{}
