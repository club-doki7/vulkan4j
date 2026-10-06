package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkPhysicalDeviceExternalMemorySciBufFeaturesNV} and {@link VkPhysicalDeviceExternalMemorySciBufFeaturesNV.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkPhysicalDeviceExternalMemorySciBufFeaturesNV
    extends IPointer
    permits VkPhysicalDeviceExternalMemorySciBufFeaturesNV, VkPhysicalDeviceExternalMemorySciBufFeaturesNV.Ptr
{}
