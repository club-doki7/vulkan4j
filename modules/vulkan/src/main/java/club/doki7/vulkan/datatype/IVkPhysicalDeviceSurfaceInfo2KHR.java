package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkPhysicalDeviceSurfaceInfo2KHR} and {@link VkPhysicalDeviceSurfaceInfo2KHR.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkPhysicalDeviceSurfaceInfo2KHR
    extends IPointer
    permits VkPhysicalDeviceSurfaceInfo2KHR, VkPhysicalDeviceSurfaceInfo2KHR.Ptr
{}
