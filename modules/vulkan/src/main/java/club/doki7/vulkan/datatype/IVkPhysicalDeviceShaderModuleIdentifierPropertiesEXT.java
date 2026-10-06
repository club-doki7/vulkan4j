package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkPhysicalDeviceShaderModuleIdentifierPropertiesEXT} and {@link VkPhysicalDeviceShaderModuleIdentifierPropertiesEXT.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkPhysicalDeviceShaderModuleIdentifierPropertiesEXT
    extends IPointer
    permits VkPhysicalDeviceShaderModuleIdentifierPropertiesEXT, VkPhysicalDeviceShaderModuleIdentifierPropertiesEXT.Ptr
{}
