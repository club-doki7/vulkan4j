package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkPhysicalDeviceExternalMemoryRDMAFeaturesNV} and {@link VkPhysicalDeviceExternalMemoryRDMAFeaturesNV.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkPhysicalDeviceExternalMemoryRDMAFeaturesNV
    extends IPointer
    permits VkPhysicalDeviceExternalMemoryRDMAFeaturesNV, VkPhysicalDeviceExternalMemoryRDMAFeaturesNV.Ptr
{}
