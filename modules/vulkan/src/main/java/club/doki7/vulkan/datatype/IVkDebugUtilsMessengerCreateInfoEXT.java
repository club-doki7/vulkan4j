package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkDebugUtilsMessengerCreateInfoEXT} and {@link VkDebugUtilsMessengerCreateInfoEXT.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkDebugUtilsMessengerCreateInfoEXT
    extends IPointer
    permits VkDebugUtilsMessengerCreateInfoEXT, VkDebugUtilsMessengerCreateInfoEXT.Ptr
{}
