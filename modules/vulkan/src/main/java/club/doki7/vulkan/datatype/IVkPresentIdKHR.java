package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkPresentIdKHR} and {@link VkPresentIdKHR.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkPresentIdKHR
    extends IPointer
    permits VkPresentIdKHR, VkPresentIdKHR.Ptr
{}
