package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkIndirectCommandsLayoutTokenNV} and {@link VkIndirectCommandsLayoutTokenNV.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkIndirectCommandsLayoutTokenNV
    extends IPointer
    permits VkIndirectCommandsLayoutTokenNV, VkIndirectCommandsLayoutTokenNV.Ptr
{}
