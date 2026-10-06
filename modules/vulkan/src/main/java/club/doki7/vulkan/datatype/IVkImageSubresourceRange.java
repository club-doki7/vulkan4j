package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkImageSubresourceRange} and {@link VkImageSubresourceRange.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkImageSubresourceRange
    extends IPointer
    permits VkImageSubresourceRange, VkImageSubresourceRange.Ptr
{}
