package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkDescriptorMappingSourceHeapDataEXT} and {@link VkDescriptorMappingSourceHeapDataEXT.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkDescriptorMappingSourceHeapDataEXT
    extends IPointer
    permits VkDescriptorMappingSourceHeapDataEXT, VkDescriptorMappingSourceHeapDataEXT.Ptr
{}
