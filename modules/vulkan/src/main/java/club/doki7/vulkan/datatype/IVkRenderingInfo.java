package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkRenderingInfo} and {@link VkRenderingInfo.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkRenderingInfo
    extends IPointer
    permits VkRenderingInfo, VkRenderingInfo.Ptr
{}
