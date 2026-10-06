package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkImageSubresourceLayers} and {@link VkImageSubresourceLayers.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkImageSubresourceLayers
    extends IPointer
    permits VkImageSubresourceLayers, VkImageSubresourceLayers.Ptr
{}
