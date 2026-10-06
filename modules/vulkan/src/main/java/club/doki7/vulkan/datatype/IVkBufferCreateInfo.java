package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkBufferCreateInfo} and {@link VkBufferCreateInfo.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkBufferCreateInfo
    extends IPointer
    permits VkBufferCreateInfo, VkBufferCreateInfo.Ptr
{}
