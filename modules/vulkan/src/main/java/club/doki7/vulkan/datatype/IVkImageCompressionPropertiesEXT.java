package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkImageCompressionPropertiesEXT} and {@link VkImageCompressionPropertiesEXT.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkImageCompressionPropertiesEXT
    extends IPointer
    permits VkImageCompressionPropertiesEXT, VkImageCompressionPropertiesEXT.Ptr
{}
