package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkDescriptorAddressInfoEXT} and {@link VkDescriptorAddressInfoEXT.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkDescriptorAddressInfoEXT
    extends IPointer
    permits VkDescriptorAddressInfoEXT, VkDescriptorAddressInfoEXT.Ptr
{}
