package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkSubresourceLayout} and {@link VkSubresourceLayout.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkSubresourceLayout
    extends IPointer
    permits VkSubresourceLayout, VkSubresourceLayout.Ptr
{}
