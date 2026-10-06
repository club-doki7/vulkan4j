package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkTexelBufferDescriptorInfoEXT} and {@link VkTexelBufferDescriptorInfoEXT.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkTexelBufferDescriptorInfoEXT
    extends IPointer
    permits VkTexelBufferDescriptorInfoEXT, VkTexelBufferDescriptorInfoEXT.Ptr
{}
