package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkImageSubresource} and {@link VkImageSubresource.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkImageSubresource
    extends IPointer
    permits VkImageSubresource, VkImageSubresource.Ptr
{}
