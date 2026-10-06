package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkPhysicalDeviceShadingRateImagePropertiesNV} and {@link VkPhysicalDeviceShadingRateImagePropertiesNV.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkPhysicalDeviceShadingRateImagePropertiesNV
    extends IPointer
    permits VkPhysicalDeviceShadingRateImagePropertiesNV, VkPhysicalDeviceShadingRateImagePropertiesNV.Ptr
{}
