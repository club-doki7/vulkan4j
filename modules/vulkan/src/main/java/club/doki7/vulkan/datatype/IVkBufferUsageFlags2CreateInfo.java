package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkBufferUsageFlags2CreateInfo} and {@link VkBufferUsageFlags2CreateInfo.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkBufferUsageFlags2CreateInfo
    extends IPointer
    permits VkBufferUsageFlags2CreateInfo, VkBufferUsageFlags2CreateInfo.Ptr
{}
