package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkRenderPassCreateInfo2} and {@link VkRenderPassCreateInfo2.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkRenderPassCreateInfo2
    extends IPointer
    permits VkRenderPassCreateInfo2, VkRenderPassCreateInfo2.Ptr
{}
