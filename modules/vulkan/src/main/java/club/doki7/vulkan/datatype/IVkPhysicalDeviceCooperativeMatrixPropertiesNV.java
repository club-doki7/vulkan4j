package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkPhysicalDeviceCooperativeMatrixPropertiesNV} and {@link VkPhysicalDeviceCooperativeMatrixPropertiesNV.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkPhysicalDeviceCooperativeMatrixPropertiesNV
    extends IPointer
    permits VkPhysicalDeviceCooperativeMatrixPropertiesNV, VkPhysicalDeviceCooperativeMatrixPropertiesNV.Ptr
{}
