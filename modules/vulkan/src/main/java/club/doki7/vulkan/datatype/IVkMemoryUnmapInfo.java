package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkMemoryUnmapInfo} and {@link VkMemoryUnmapInfo.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkMemoryUnmapInfo
    extends IPointer
    permits VkMemoryUnmapInfo, VkMemoryUnmapInfo.Ptr
{}
