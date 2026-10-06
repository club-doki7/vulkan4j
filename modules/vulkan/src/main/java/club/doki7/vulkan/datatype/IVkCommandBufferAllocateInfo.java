package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkCommandBufferAllocateInfo} and {@link VkCommandBufferAllocateInfo.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkCommandBufferAllocateInfo
    extends IPointer
    permits VkCommandBufferAllocateInfo, VkCommandBufferAllocateInfo.Ptr
{}
