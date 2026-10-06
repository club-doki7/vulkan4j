package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkDescriptorSetVariableDescriptorCountAllocateInfo} and {@link VkDescriptorSetVariableDescriptorCountAllocateInfo.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkDescriptorSetVariableDescriptorCountAllocateInfo
    extends IPointer
    permits VkDescriptorSetVariableDescriptorCountAllocateInfo, VkDescriptorSetVariableDescriptorCountAllocateInfo.Ptr
{}
