package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkDescriptorMappingSourceDataEXT} and {@link VkDescriptorMappingSourceDataEXT.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkDescriptorMappingSourceDataEXT
    extends IPointer
    permits VkDescriptorMappingSourceDataEXT, VkDescriptorMappingSourceDataEXT.Ptr
{}
