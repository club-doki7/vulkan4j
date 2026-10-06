package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkDebugUtilsObjectNameInfoEXT} and {@link VkDebugUtilsObjectNameInfoEXT.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkDebugUtilsObjectNameInfoEXT
    extends IPointer
    permits VkDebugUtilsObjectNameInfoEXT, VkDebugUtilsObjectNameInfoEXT.Ptr
{}
