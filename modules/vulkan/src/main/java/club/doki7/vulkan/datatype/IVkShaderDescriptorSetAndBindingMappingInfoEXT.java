package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkShaderDescriptorSetAndBindingMappingInfoEXT} and {@link VkShaderDescriptorSetAndBindingMappingInfoEXT.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkShaderDescriptorSetAndBindingMappingInfoEXT
    extends IPointer
    permits VkShaderDescriptorSetAndBindingMappingInfoEXT, VkShaderDescriptorSetAndBindingMappingInfoEXT.Ptr
{}
