package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkDescriptorPoolCreateInfo} and {@link VkDescriptorPoolCreateInfo.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkDescriptorPoolCreateInfo
    extends IPointer
    permits VkDescriptorPoolCreateInfo, VkDescriptorPoolCreateInfo.Ptr
{}
