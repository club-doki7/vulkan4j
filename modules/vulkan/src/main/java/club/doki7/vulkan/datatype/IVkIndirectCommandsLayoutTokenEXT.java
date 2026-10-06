package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkIndirectCommandsLayoutTokenEXT} and {@link VkIndirectCommandsLayoutTokenEXT.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkIndirectCommandsLayoutTokenEXT
    extends IPointer
    permits VkIndirectCommandsLayoutTokenEXT, VkIndirectCommandsLayoutTokenEXT.Ptr
{}
