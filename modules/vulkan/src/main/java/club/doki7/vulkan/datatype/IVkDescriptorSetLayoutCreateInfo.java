package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkDescriptorSetLayoutCreateInfo} and {@link VkDescriptorSetLayoutCreateInfo.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkDescriptorSetLayoutCreateInfo
    extends IPointer
    permits VkDescriptorSetLayoutCreateInfo, VkDescriptorSetLayoutCreateInfo.Ptr
{}
