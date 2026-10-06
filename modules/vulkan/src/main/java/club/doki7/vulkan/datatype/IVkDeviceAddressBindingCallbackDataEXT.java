package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkDeviceAddressBindingCallbackDataEXT} and {@link VkDeviceAddressBindingCallbackDataEXT.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkDeviceAddressBindingCallbackDataEXT
    extends IPointer
    permits VkDeviceAddressBindingCallbackDataEXT, VkDeviceAddressBindingCallbackDataEXT.Ptr
{}
