package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkImageViewUsageCreateInfo} and {@link VkImageViewUsageCreateInfo.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkImageViewUsageCreateInfo
    extends IPointer
    permits VkImageViewUsageCreateInfo, VkImageViewUsageCreateInfo.Ptr
{}
