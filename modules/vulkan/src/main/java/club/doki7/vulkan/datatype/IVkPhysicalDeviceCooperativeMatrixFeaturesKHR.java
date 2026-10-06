package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkPhysicalDeviceCooperativeMatrixFeaturesKHR} and {@link VkPhysicalDeviceCooperativeMatrixFeaturesKHR.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkPhysicalDeviceCooperativeMatrixFeaturesKHR
    extends IPointer
    permits VkPhysicalDeviceCooperativeMatrixFeaturesKHR, VkPhysicalDeviceCooperativeMatrixFeaturesKHR.Ptr
{}
