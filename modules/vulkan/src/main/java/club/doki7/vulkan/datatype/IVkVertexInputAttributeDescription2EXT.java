package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkVertexInputAttributeDescription2EXT} and {@link VkVertexInputAttributeDescription2EXT.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkVertexInputAttributeDescription2EXT
    extends IPointer
    permits VkVertexInputAttributeDescription2EXT, VkVertexInputAttributeDescription2EXT.Ptr
{}
