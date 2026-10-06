package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkBindIndexBufferIndirectCommandNV} and {@link VkBindIndexBufferIndirectCommandNV.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkBindIndexBufferIndirectCommandNV
    extends IPointer
    permits VkBindIndexBufferIndirectCommandNV, VkBindIndexBufferIndirectCommandNV.Ptr
{}
