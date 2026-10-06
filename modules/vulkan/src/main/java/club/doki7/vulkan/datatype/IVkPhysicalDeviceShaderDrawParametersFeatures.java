package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkPhysicalDeviceShaderDrawParametersFeatures} and {@link VkPhysicalDeviceShaderDrawParametersFeatures.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkPhysicalDeviceShaderDrawParametersFeatures
    extends IPointer
    permits VkPhysicalDeviceShaderDrawParametersFeatures, VkPhysicalDeviceShaderDrawParametersFeatures.Ptr
{}
