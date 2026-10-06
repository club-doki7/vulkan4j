package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkPhysicalDeviceCooperativeMatrixFeaturesNV} and {@link VkPhysicalDeviceCooperativeMatrixFeaturesNV.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkPhysicalDeviceCooperativeMatrixFeaturesNV
    extends IPointer
    permits VkPhysicalDeviceCooperativeMatrixFeaturesNV, VkPhysicalDeviceCooperativeMatrixFeaturesNV.Ptr
{}
