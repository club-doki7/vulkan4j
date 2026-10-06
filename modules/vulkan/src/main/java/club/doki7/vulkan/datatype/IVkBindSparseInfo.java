package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkBindSparseInfo} and {@link VkBindSparseInfo.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkBindSparseInfo
    extends IPointer
    permits VkBindSparseInfo, VkBindSparseInfo.Ptr
{}
