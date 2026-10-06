package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkSparseImageOpaqueMemoryBindInfo} and {@link VkSparseImageOpaqueMemoryBindInfo.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkSparseImageOpaqueMemoryBindInfo
    extends IPointer
    permits VkSparseImageOpaqueMemoryBindInfo, VkSparseImageOpaqueMemoryBindInfo.Ptr
{}
