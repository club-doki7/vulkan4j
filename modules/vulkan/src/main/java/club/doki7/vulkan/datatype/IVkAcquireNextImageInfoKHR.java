package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkAcquireNextImageInfoKHR} and {@link VkAcquireNextImageInfoKHR.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkAcquireNextImageInfoKHR
    extends IPointer
    permits VkAcquireNextImageInfoKHR, VkAcquireNextImageInfoKHR.Ptr
{}
