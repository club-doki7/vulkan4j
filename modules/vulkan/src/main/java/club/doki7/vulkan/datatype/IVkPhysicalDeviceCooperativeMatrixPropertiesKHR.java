package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkPhysicalDeviceCooperativeMatrixPropertiesKHR} and {@link VkPhysicalDeviceCooperativeMatrixPropertiesKHR.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkPhysicalDeviceCooperativeMatrixPropertiesKHR
    extends IPointer
    permits VkPhysicalDeviceCooperativeMatrixPropertiesKHR, VkPhysicalDeviceCooperativeMatrixPropertiesKHR.Ptr
{}
