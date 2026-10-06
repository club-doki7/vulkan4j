package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkMemoryHeap} and {@link VkMemoryHeap.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkMemoryHeap
    extends IPointer
    permits VkMemoryHeap, VkMemoryHeap.Ptr
{}
