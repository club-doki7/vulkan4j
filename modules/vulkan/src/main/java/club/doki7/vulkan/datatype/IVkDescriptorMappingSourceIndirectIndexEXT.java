package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkDescriptorMappingSourceIndirectIndexEXT} and {@link VkDescriptorMappingSourceIndirectIndexEXT.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkDescriptorMappingSourceIndirectIndexEXT
    extends IPointer
    permits VkDescriptorMappingSourceIndirectIndexEXT, VkDescriptorMappingSourceIndirectIndexEXT.Ptr
{}
