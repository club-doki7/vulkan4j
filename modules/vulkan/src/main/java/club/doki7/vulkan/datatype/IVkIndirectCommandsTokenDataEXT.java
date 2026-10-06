package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkIndirectCommandsTokenDataEXT} and {@link VkIndirectCommandsTokenDataEXT.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkIndirectCommandsTokenDataEXT
    extends IPointer
    permits VkIndirectCommandsTokenDataEXT, VkIndirectCommandsTokenDataEXT.Ptr
{}
