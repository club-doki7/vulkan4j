package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkDescriptorUpdateTemplateEntry} and {@link VkDescriptorUpdateTemplateEntry.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkDescriptorUpdateTemplateEntry
    extends IPointer
    permits VkDescriptorUpdateTemplateEntry, VkDescriptorUpdateTemplateEntry.Ptr
{}
