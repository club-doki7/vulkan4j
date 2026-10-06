package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkDescriptorBufferInfo} and {@link VkDescriptorBufferInfo.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkDescriptorBufferInfo
    extends IPointer
    permits VkDescriptorBufferInfo, VkDescriptorBufferInfo.Ptr
{}
