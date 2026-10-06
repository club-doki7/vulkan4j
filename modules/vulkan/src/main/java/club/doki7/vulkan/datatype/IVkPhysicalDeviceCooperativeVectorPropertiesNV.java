package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkPhysicalDeviceCooperativeVectorPropertiesNV} and {@link VkPhysicalDeviceCooperativeVectorPropertiesNV.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkPhysicalDeviceCooperativeVectorPropertiesNV
    extends IPointer
    permits VkPhysicalDeviceCooperativeVectorPropertiesNV, VkPhysicalDeviceCooperativeVectorPropertiesNV.Ptr
{}
