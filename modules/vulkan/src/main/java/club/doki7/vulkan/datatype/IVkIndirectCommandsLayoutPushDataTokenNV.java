package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkIndirectCommandsLayoutPushDataTokenNV} and {@link VkIndirectCommandsLayoutPushDataTokenNV.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkIndirectCommandsLayoutPushDataTokenNV
    extends IPointer
    permits VkIndirectCommandsLayoutPushDataTokenNV, VkIndirectCommandsLayoutPushDataTokenNV.Ptr
{}
