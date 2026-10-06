package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkImageViewAddressPropertiesNVX} and {@link VkImageViewAddressPropertiesNVX.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkImageViewAddressPropertiesNVX
    extends IPointer
    permits VkImageViewAddressPropertiesNVX, VkImageViewAddressPropertiesNVX.Ptr
{}
