package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkSparseMemoryBind} and {@link VkSparseMemoryBind.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkSparseMemoryBind
    extends IPointer
    permits VkSparseMemoryBind, VkSparseMemoryBind.Ptr
{}
