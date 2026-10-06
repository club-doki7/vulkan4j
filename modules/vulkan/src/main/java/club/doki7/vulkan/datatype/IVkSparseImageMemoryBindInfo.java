package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkSparseImageMemoryBindInfo} and {@link VkSparseImageMemoryBindInfo.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkSparseImageMemoryBindInfo
    extends IPointer
    permits VkSparseImageMemoryBindInfo, VkSparseImageMemoryBindInfo.Ptr
{}
