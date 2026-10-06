package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkDescriptorSetLayoutBindingFlagsCreateInfo} and {@link VkDescriptorSetLayoutBindingFlagsCreateInfo.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkDescriptorSetLayoutBindingFlagsCreateInfo
    extends IPointer
    permits VkDescriptorSetLayoutBindingFlagsCreateInfo, VkDescriptorSetLayoutBindingFlagsCreateInfo.Ptr
{}
