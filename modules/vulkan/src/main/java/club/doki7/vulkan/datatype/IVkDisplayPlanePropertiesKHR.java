package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkDisplayPlanePropertiesKHR} and {@link VkDisplayPlanePropertiesKHR.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkDisplayPlanePropertiesKHR
    extends IPointer
    permits VkDisplayPlanePropertiesKHR, VkDisplayPlanePropertiesKHR.Ptr
{}
