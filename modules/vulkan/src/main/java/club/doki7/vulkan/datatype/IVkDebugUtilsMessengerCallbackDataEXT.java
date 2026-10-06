package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkDebugUtilsMessengerCallbackDataEXT} and {@link VkDebugUtilsMessengerCallbackDataEXT.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkDebugUtilsMessengerCallbackDataEXT
    extends IPointer
    permits VkDebugUtilsMessengerCallbackDataEXT, VkDebugUtilsMessengerCallbackDataEXT.Ptr
{}
