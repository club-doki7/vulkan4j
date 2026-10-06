package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkVideoProfileInfoKHR} and {@link VkVideoProfileInfoKHR.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkVideoProfileInfoKHR
    extends IPointer
    permits VkVideoProfileInfoKHR, VkVideoProfileInfoKHR.Ptr
{}
