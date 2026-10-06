package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkBufferViewCreateInfo} and {@link VkBufferViewCreateInfo.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkBufferViewCreateInfo
    extends IPointer
    permits VkBufferViewCreateInfo, VkBufferViewCreateInfo.Ptr
{}
