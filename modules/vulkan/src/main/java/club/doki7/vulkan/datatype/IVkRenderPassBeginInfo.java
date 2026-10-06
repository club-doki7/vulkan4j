package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkRenderPassBeginInfo} and {@link VkRenderPassBeginInfo.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkRenderPassBeginInfo
    extends IPointer
    permits VkRenderPassBeginInfo, VkRenderPassBeginInfo.Ptr
{}
