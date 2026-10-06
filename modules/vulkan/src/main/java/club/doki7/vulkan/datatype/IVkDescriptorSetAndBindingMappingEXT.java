package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkDescriptorSetAndBindingMappingEXT} and {@link VkDescriptorSetAndBindingMappingEXT.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkDescriptorSetAndBindingMappingEXT
    extends IPointer
    permits VkDescriptorSetAndBindingMappingEXT, VkDescriptorSetAndBindingMappingEXT.Ptr
{}
