package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkImageCompressionControlEXT} and {@link VkImageCompressionControlEXT.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkImageCompressionControlEXT
    extends IPointer
    permits VkImageCompressionControlEXT, VkImageCompressionControlEXT.Ptr
{}
