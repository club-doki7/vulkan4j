package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkDescriptorSetLayoutBinding} and {@link VkDescriptorSetLayoutBinding.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkDescriptorSetLayoutBinding
    extends IPointer
    permits VkDescriptorSetLayoutBinding, VkDescriptorSetLayoutBinding.Ptr
{}
