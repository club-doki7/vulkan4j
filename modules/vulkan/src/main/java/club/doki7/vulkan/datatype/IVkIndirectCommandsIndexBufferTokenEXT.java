package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkIndirectCommandsIndexBufferTokenEXT} and {@link VkIndirectCommandsIndexBufferTokenEXT.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkIndirectCommandsIndexBufferTokenEXT
    extends IPointer
    permits VkIndirectCommandsIndexBufferTokenEXT, VkIndirectCommandsIndexBufferTokenEXT.Ptr
{}
