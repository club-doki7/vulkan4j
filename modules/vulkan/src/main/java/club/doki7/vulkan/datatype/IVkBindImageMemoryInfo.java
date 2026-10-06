package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkBindImageMemoryInfo} and {@link VkBindImageMemoryInfo.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkBindImageMemoryInfo
    extends IPointer
    permits VkBindImageMemoryInfo, VkBindImageMemoryInfo.Ptr
{}
