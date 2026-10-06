package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkSparseBufferMemoryBindInfo} and {@link VkSparseBufferMemoryBindInfo.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkSparseBufferMemoryBindInfo
    extends IPointer
    permits VkSparseBufferMemoryBindInfo, VkSparseBufferMemoryBindInfo.Ptr
{}
