package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkPhysicalDeviceRayTracingPropertiesNV} and {@link VkPhysicalDeviceRayTracingPropertiesNV.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkPhysicalDeviceRayTracingPropertiesNV
    extends IPointer
    permits VkPhysicalDeviceRayTracingPropertiesNV, VkPhysicalDeviceRayTracingPropertiesNV.Ptr
{}
