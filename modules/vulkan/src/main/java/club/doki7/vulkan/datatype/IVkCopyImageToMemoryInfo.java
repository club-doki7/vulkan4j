package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkCopyImageToMemoryInfo} and {@link VkCopyImageToMemoryInfo.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkCopyImageToMemoryInfo
    extends IPointer
    permits VkCopyImageToMemoryInfo, VkCopyImageToMemoryInfo.Ptr
{}
