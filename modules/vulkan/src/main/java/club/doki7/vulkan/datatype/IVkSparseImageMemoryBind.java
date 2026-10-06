package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkSparseImageMemoryBind} and {@link VkSparseImageMemoryBind.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkSparseImageMemoryBind
    extends IPointer
    permits VkSparseImageMemoryBind, VkSparseImageMemoryBind.Ptr
{}
