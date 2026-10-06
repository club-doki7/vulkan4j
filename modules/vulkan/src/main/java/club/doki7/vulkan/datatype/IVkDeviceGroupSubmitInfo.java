package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkDeviceGroupSubmitInfo} and {@link VkDeviceGroupSubmitInfo.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkDeviceGroupSubmitInfo
    extends IPointer
    permits VkDeviceGroupSubmitInfo, VkDeviceGroupSubmitInfo.Ptr
{}
