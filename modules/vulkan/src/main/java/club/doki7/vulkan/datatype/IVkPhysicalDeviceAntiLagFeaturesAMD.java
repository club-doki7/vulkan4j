package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkPhysicalDeviceAntiLagFeaturesAMD} and {@link VkPhysicalDeviceAntiLagFeaturesAMD.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkPhysicalDeviceAntiLagFeaturesAMD
    extends IPointer
    permits VkPhysicalDeviceAntiLagFeaturesAMD, VkPhysicalDeviceAntiLagFeaturesAMD.Ptr
{}
