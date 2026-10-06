package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkDeviceImageSubresourceInfo} and {@link VkDeviceImageSubresourceInfo.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkDeviceImageSubresourceInfo
    extends IPointer
    permits VkDeviceImageSubresourceInfo, VkDeviceImageSubresourceInfo.Ptr
{}
