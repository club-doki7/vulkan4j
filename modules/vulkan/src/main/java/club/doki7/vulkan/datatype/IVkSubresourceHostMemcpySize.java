package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkSubresourceHostMemcpySize} and {@link VkSubresourceHostMemcpySize.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkSubresourceHostMemcpySize
    extends IPointer
    permits VkSubresourceHostMemcpySize, VkSubresourceHostMemcpySize.Ptr
{}
