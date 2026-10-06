package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkPhysicalDeviceShaderCorePropertiesAMD} and {@link VkPhysicalDeviceShaderCorePropertiesAMD.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkPhysicalDeviceShaderCorePropertiesAMD
    extends IPointer
    permits VkPhysicalDeviceShaderCorePropertiesAMD, VkPhysicalDeviceShaderCorePropertiesAMD.Ptr
{}
