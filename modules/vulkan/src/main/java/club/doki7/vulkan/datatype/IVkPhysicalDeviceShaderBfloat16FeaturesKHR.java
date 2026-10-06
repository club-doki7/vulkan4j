package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkPhysicalDeviceShaderBfloat16FeaturesKHR} and {@link VkPhysicalDeviceShaderBfloat16FeaturesKHR.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkPhysicalDeviceShaderBfloat16FeaturesKHR
    extends IPointer
    permits VkPhysicalDeviceShaderBfloat16FeaturesKHR, VkPhysicalDeviceShaderBfloat16FeaturesKHR.Ptr
{}
