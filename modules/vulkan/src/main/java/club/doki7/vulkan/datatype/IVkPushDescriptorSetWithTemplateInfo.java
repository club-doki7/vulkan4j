package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkPushDescriptorSetWithTemplateInfo} and {@link VkPushDescriptorSetWithTemplateInfo.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkPushDescriptorSetWithTemplateInfo
    extends IPointer
    permits VkPushDescriptorSetWithTemplateInfo, VkPushDescriptorSetWithTemplateInfo.Ptr
{}
