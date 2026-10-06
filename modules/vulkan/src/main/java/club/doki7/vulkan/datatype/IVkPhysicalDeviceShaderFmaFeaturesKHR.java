package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkPhysicalDeviceShaderFmaFeaturesKHR} and {@link VkPhysicalDeviceShaderFmaFeaturesKHR.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkPhysicalDeviceShaderFmaFeaturesKHR
    extends IPointer
    permits VkPhysicalDeviceShaderFmaFeaturesKHR, VkPhysicalDeviceShaderFmaFeaturesKHR.Ptr
{}
