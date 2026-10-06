package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkClearDepthStencilValue} and {@link VkClearDepthStencilValue.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkClearDepthStencilValue
    extends IPointer
    permits VkClearDepthStencilValue, VkClearDepthStencilValue.Ptr
{}
