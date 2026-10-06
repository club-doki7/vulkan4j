package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkBindBufferMemoryInfo} and {@link VkBindBufferMemoryInfo.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkBindBufferMemoryInfo
    extends IPointer
    permits VkBindBufferMemoryInfo, VkBindBufferMemoryInfo.Ptr
{}
