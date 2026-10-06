package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkExtensionProperties} and {@link VkExtensionProperties.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkExtensionProperties
    extends IPointer
    permits VkExtensionProperties, VkExtensionProperties.Ptr
{}
