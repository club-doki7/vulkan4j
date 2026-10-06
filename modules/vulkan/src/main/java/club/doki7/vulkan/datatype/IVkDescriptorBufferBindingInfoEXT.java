package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkDescriptorBufferBindingInfoEXT} and {@link VkDescriptorBufferBindingInfoEXT.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkDescriptorBufferBindingInfoEXT
    extends IPointer
    permits VkDescriptorBufferBindingInfoEXT, VkDescriptorBufferBindingInfoEXT.Ptr
{}
