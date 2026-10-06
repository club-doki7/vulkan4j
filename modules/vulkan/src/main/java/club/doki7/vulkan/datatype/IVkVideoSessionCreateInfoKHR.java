package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkVideoSessionCreateInfoKHR} and {@link VkVideoSessionCreateInfoKHR.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkVideoSessionCreateInfoKHR
    extends IPointer
    permits VkVideoSessionCreateInfoKHR, VkVideoSessionCreateInfoKHR.Ptr
{}
