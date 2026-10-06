package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkPhysicalDeviceGpaFeaturesAMD} and {@link VkPhysicalDeviceGpaFeaturesAMD.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkPhysicalDeviceGpaFeaturesAMD
    extends IPointer
    permits VkPhysicalDeviceGpaFeaturesAMD, VkPhysicalDeviceGpaFeaturesAMD.Ptr
{}
