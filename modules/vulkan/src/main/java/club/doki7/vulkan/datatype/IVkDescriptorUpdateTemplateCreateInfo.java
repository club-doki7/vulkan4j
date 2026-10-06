package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkDescriptorUpdateTemplateCreateInfo} and {@link VkDescriptorUpdateTemplateCreateInfo.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkDescriptorUpdateTemplateCreateInfo
    extends IPointer
    permits VkDescriptorUpdateTemplateCreateInfo, VkDescriptorUpdateTemplateCreateInfo.Ptr
{}
