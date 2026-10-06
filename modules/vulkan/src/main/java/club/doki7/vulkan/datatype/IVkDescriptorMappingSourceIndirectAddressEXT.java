package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkDescriptorMappingSourceIndirectAddressEXT} and {@link VkDescriptorMappingSourceIndirectAddressEXT.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkDescriptorMappingSourceIndirectAddressEXT
    extends IPointer
    permits VkDescriptorMappingSourceIndirectAddressEXT, VkDescriptorMappingSourceIndirectAddressEXT.Ptr
{}
