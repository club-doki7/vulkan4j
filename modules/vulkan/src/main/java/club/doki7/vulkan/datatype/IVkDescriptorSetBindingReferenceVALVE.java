package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkDescriptorSetBindingReferenceVALVE} and {@link VkDescriptorSetBindingReferenceVALVE.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkDescriptorSetBindingReferenceVALVE
    extends IPointer
    permits VkDescriptorSetBindingReferenceVALVE, VkDescriptorSetBindingReferenceVALVE.Ptr
{}
