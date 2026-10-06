package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkDisplayPresentInfoKHR} and {@link VkDisplayPresentInfoKHR.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkDisplayPresentInfoKHR
    extends IPointer
    permits VkDisplayPresentInfoKHR, VkDisplayPresentInfoKHR.Ptr
{}
