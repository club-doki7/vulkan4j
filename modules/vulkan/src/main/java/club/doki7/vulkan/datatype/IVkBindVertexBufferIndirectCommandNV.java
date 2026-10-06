package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkBindVertexBufferIndirectCommandNV} and {@link VkBindVertexBufferIndirectCommandNV.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkBindVertexBufferIndirectCommandNV
    extends IPointer
    permits VkBindVertexBufferIndirectCommandNV, VkBindVertexBufferIndirectCommandNV.Ptr
{}
