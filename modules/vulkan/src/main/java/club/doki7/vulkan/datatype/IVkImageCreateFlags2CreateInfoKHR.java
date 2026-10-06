package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkImageCreateFlags2CreateInfoKHR} and {@link VkImageCreateFlags2CreateInfoKHR.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkImageCreateFlags2CreateInfoKHR
    extends IPointer
    permits VkImageCreateFlags2CreateInfoKHR, VkImageCreateFlags2CreateInfoKHR.Ptr
{}
