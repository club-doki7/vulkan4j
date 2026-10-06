package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkBindIndexBufferIndirectCommandEXT} and {@link VkBindIndexBufferIndirectCommandEXT.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkBindIndexBufferIndirectCommandEXT
    extends IPointer
    permits VkBindIndexBufferIndirectCommandEXT, VkBindIndexBufferIndirectCommandEXT.Ptr
{}
