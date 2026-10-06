package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkPhysicalDeviceSubpassShadingPropertiesHUAWEI} and {@link VkPhysicalDeviceSubpassShadingPropertiesHUAWEI.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkPhysicalDeviceSubpassShadingPropertiesHUAWEI
    extends IPointer
    permits VkPhysicalDeviceSubpassShadingPropertiesHUAWEI, VkPhysicalDeviceSubpassShadingPropertiesHUAWEI.Ptr
{}
