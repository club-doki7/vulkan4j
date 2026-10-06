package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkRenderPassCreateInfo} and {@link VkRenderPassCreateInfo.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkRenderPassCreateInfo
    extends IPointer
    permits VkRenderPassCreateInfo, VkRenderPassCreateInfo.Ptr
{}
