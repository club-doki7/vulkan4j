package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkPhysicalDeviceCooperativeVectorFeaturesNV} and {@link VkPhysicalDeviceCooperativeVectorFeaturesNV.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkPhysicalDeviceCooperativeVectorFeaturesNV
    extends IPointer
    permits VkPhysicalDeviceCooperativeVectorFeaturesNV, VkPhysicalDeviceCooperativeVectorFeaturesNV.Ptr
{}
