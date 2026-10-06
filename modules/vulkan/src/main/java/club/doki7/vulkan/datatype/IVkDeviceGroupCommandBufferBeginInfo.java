package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkDeviceGroupCommandBufferBeginInfo} and {@link VkDeviceGroupCommandBufferBeginInfo.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkDeviceGroupCommandBufferBeginInfo
    extends IPointer
    permits VkDeviceGroupCommandBufferBeginInfo, VkDeviceGroupCommandBufferBeginInfo.Ptr
{}
