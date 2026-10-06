package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkPhysicalDeviceShaderIntegerDotProductProperties} and {@link VkPhysicalDeviceShaderIntegerDotProductProperties.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkPhysicalDeviceShaderIntegerDotProductProperties
    extends IPointer
    permits VkPhysicalDeviceShaderIntegerDotProductProperties, VkPhysicalDeviceShaderIntegerDotProductProperties.Ptr
{}
