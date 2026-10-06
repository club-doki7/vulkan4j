package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkDescriptorMappingSourceIndirectIndexArrayEXT} and {@link VkDescriptorMappingSourceIndirectIndexArrayEXT.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkDescriptorMappingSourceIndirectIndexArrayEXT
    extends IPointer
    permits VkDescriptorMappingSourceIndirectIndexArrayEXT, VkDescriptorMappingSourceIndirectIndexArrayEXT.Ptr
{}
