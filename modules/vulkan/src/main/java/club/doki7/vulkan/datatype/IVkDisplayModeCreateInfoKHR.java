package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkDisplayModeCreateInfoKHR} and {@link VkDisplayModeCreateInfoKHR.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkDisplayModeCreateInfoKHR
    extends IPointer
    permits VkDisplayModeCreateInfoKHR, VkDisplayModeCreateInfoKHR.Ptr
{}
