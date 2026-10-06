package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkDeviceGroupRenderPassBeginInfo} and {@link VkDeviceGroupRenderPassBeginInfo.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkDeviceGroupRenderPassBeginInfo
    extends IPointer
    permits VkDeviceGroupRenderPassBeginInfo, VkDeviceGroupRenderPassBeginInfo.Ptr
{}
