package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkMemoryAllocateFlagsInfo} and {@link VkMemoryAllocateFlagsInfo.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkMemoryAllocateFlagsInfo
    extends IPointer
    permits VkMemoryAllocateFlagsInfo, VkMemoryAllocateFlagsInfo.Ptr
{}
