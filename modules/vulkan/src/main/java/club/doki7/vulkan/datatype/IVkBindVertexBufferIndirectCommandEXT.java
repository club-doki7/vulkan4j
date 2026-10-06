package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkBindVertexBufferIndirectCommandEXT} and {@link VkBindVertexBufferIndirectCommandEXT.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkBindVertexBufferIndirectCommandEXT
    extends IPointer
    permits VkBindVertexBufferIndirectCommandEXT, VkBindVertexBufferIndirectCommandEXT.Ptr
{}
