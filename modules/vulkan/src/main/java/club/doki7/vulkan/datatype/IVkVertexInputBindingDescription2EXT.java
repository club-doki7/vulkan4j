package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkVertexInputBindingDescription2EXT} and {@link VkVertexInputBindingDescription2EXT.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkVertexInputBindingDescription2EXT
    extends IPointer
    permits VkVertexInputBindingDescription2EXT, VkVertexInputBindingDescription2EXT.Ptr
{}
