package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkVideoProfileListInfoKHR} and {@link VkVideoProfileListInfoKHR.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkVideoProfileListInfoKHR
    extends IPointer
    permits VkVideoProfileListInfoKHR, VkVideoProfileListInfoKHR.Ptr
{}
