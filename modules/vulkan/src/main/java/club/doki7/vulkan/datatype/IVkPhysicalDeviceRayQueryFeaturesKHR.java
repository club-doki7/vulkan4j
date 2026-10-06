package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkPhysicalDeviceRayQueryFeaturesKHR} and {@link VkPhysicalDeviceRayQueryFeaturesKHR.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkPhysicalDeviceRayQueryFeaturesKHR
    extends IPointer
    permits VkPhysicalDeviceRayQueryFeaturesKHR, VkPhysicalDeviceRayQueryFeaturesKHR.Ptr
{}
