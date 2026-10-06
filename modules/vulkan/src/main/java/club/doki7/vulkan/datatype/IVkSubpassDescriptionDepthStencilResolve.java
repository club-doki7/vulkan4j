package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkSubpassDescriptionDepthStencilResolve} and {@link VkSubpassDescriptionDepthStencilResolve.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkSubpassDescriptionDepthStencilResolve
    extends IPointer
    permits VkSubpassDescriptionDepthStencilResolve, VkSubpassDescriptionDepthStencilResolve.Ptr
{}
