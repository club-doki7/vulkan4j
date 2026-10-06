package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkDescriptorSetVariableDescriptorCountLayoutSupport} and {@link VkDescriptorSetVariableDescriptorCountLayoutSupport.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkDescriptorSetVariableDescriptorCountLayoutSupport
    extends IPointer
    permits VkDescriptorSetVariableDescriptorCountLayoutSupport, VkDescriptorSetVariableDescriptorCountLayoutSupport.Ptr
{}
