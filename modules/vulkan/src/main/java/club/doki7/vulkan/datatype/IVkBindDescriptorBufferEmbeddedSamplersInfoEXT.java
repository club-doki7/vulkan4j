package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkBindDescriptorBufferEmbeddedSamplersInfoEXT} and {@link VkBindDescriptorBufferEmbeddedSamplersInfoEXT.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkBindDescriptorBufferEmbeddedSamplersInfoEXT
    extends IPointer
    permits VkBindDescriptorBufferEmbeddedSamplersInfoEXT, VkBindDescriptorBufferEmbeddedSamplersInfoEXT.Ptr
{}
