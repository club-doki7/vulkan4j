package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkSubresourceLayout2} and {@link VkSubresourceLayout2.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkSubresourceLayout2
    extends IPointer
    permits VkSubresourceLayout2, VkSubresourceLayout2.Ptr
{}
