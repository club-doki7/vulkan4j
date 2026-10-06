package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkMemoryMapInfo} and {@link VkMemoryMapInfo.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkMemoryMapInfo
    extends IPointer
    permits VkMemoryMapInfo, VkMemoryMapInfo.Ptr
{}
