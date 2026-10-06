package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkDescriptorSetLayoutHostMappingInfoVALVE} and {@link VkDescriptorSetLayoutHostMappingInfoVALVE.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkDescriptorSetLayoutHostMappingInfoVALVE
    extends IPointer
    permits VkDescriptorSetLayoutHostMappingInfoVALVE, VkDescriptorSetLayoutHostMappingInfoVALVE.Ptr
{}
