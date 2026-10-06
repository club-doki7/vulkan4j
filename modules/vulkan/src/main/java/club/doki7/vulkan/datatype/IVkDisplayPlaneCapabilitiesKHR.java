package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkDisplayPlaneCapabilitiesKHR} and {@link VkDisplayPlaneCapabilitiesKHR.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkDisplayPlaneCapabilitiesKHR
    extends IPointer
    permits VkDisplayPlaneCapabilitiesKHR, VkDisplayPlaneCapabilitiesKHR.Ptr
{}
