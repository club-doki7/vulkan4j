package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkPhysicalDeviceCoherentMemoryFeaturesAMD} and {@link VkPhysicalDeviceCoherentMemoryFeaturesAMD.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkPhysicalDeviceCoherentMemoryFeaturesAMD
    extends IPointer
    permits VkPhysicalDeviceCoherentMemoryFeaturesAMD, VkPhysicalDeviceCoherentMemoryFeaturesAMD.Ptr
{}
