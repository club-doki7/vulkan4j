package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkPhysicalDeviceShaderInstrumentationPropertiesARM} and {@link VkPhysicalDeviceShaderInstrumentationPropertiesARM.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkPhysicalDeviceShaderInstrumentationPropertiesARM
    extends IPointer
    permits VkPhysicalDeviceShaderInstrumentationPropertiesARM, VkPhysicalDeviceShaderInstrumentationPropertiesARM.Ptr
{}
