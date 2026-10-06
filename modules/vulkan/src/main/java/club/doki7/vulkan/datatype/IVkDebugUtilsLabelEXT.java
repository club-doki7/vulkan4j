package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkDebugUtilsLabelEXT} and {@link VkDebugUtilsLabelEXT.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkDebugUtilsLabelEXT
    extends IPointer
    permits VkDebugUtilsLabelEXT, VkDebugUtilsLabelEXT.Ptr
{}
