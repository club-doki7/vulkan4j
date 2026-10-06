package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkPhysicalDevicePrivateDataBaseHandleFeaturesNV} and {@link VkPhysicalDevicePrivateDataBaseHandleFeaturesNV.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkPhysicalDevicePrivateDataBaseHandleFeaturesNV
    extends IPointer
    permits VkPhysicalDevicePrivateDataBaseHandleFeaturesNV, VkPhysicalDevicePrivateDataBaseHandleFeaturesNV.Ptr
{}
