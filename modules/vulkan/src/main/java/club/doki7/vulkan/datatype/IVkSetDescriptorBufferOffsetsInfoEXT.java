package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkSetDescriptorBufferOffsetsInfoEXT} and {@link VkSetDescriptorBufferOffsetsInfoEXT.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkSetDescriptorBufferOffsetsInfoEXT
    extends IPointer
    permits VkSetDescriptorBufferOffsetsInfoEXT, VkSetDescriptorBufferOffsetsInfoEXT.Ptr
{}
