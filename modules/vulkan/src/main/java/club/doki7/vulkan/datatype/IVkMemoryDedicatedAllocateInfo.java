package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkMemoryDedicatedAllocateInfo} and {@link VkMemoryDedicatedAllocateInfo.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkMemoryDedicatedAllocateInfo
    extends IPointer
    permits VkMemoryDedicatedAllocateInfo, VkMemoryDedicatedAllocateInfo.Ptr
{}
