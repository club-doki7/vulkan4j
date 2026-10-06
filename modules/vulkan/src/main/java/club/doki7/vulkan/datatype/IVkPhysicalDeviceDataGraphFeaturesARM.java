package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkPhysicalDeviceDataGraphFeaturesARM} and {@link VkPhysicalDeviceDataGraphFeaturesARM.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkPhysicalDeviceDataGraphFeaturesARM
    extends IPointer
    permits VkPhysicalDeviceDataGraphFeaturesARM, VkPhysicalDeviceDataGraphFeaturesARM.Ptr
{}
