package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkPhysicalDeviceShaderConstantDataFeaturesKHR} and {@link VkPhysicalDeviceShaderConstantDataFeaturesKHR.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkPhysicalDeviceShaderConstantDataFeaturesKHR
    extends IPointer
    permits VkPhysicalDeviceShaderConstantDataFeaturesKHR, VkPhysicalDeviceShaderConstantDataFeaturesKHR.Ptr
{}
