package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkRenderingAreaInfo} and {@link VkRenderingAreaInfo.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkRenderingAreaInfo
    extends IPointer
    permits VkRenderingAreaInfo, VkRenderingAreaInfo.Ptr
{}
