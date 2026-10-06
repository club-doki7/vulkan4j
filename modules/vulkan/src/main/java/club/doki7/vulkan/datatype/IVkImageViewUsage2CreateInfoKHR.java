package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkImageViewUsage2CreateInfoKHR} and {@link VkImageViewUsage2CreateInfoKHR.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkImageViewUsage2CreateInfoKHR
    extends IPointer
    permits VkImageViewUsage2CreateInfoKHR, VkImageViewUsage2CreateInfoKHR.Ptr
{}
