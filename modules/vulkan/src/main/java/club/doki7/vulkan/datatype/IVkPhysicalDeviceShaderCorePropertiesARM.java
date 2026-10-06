package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkPhysicalDeviceShaderCorePropertiesARM} and {@link VkPhysicalDeviceShaderCorePropertiesARM.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkPhysicalDeviceShaderCorePropertiesARM
    extends IPointer
    permits VkPhysicalDeviceShaderCorePropertiesARM, VkPhysicalDeviceShaderCorePropertiesARM.Ptr
{}
