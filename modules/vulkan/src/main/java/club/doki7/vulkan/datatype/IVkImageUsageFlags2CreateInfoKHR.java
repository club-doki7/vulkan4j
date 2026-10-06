package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkImageUsageFlags2CreateInfoKHR} and {@link VkImageUsageFlags2CreateInfoKHR.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkImageUsageFlags2CreateInfoKHR
    extends IPointer
    permits VkImageUsageFlags2CreateInfoKHR, VkImageUsageFlags2CreateInfoKHR.Ptr
{}
