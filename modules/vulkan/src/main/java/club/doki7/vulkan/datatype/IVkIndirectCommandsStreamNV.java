package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkIndirectCommandsStreamNV} and {@link VkIndirectCommandsStreamNV.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkIndirectCommandsStreamNV
    extends IPointer
    permits VkIndirectCommandsStreamNV, VkIndirectCommandsStreamNV.Ptr
{}
