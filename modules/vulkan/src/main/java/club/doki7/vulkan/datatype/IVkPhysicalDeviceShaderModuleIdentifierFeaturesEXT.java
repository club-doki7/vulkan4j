package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkPhysicalDeviceShaderModuleIdentifierFeaturesEXT} and {@link VkPhysicalDeviceShaderModuleIdentifierFeaturesEXT.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkPhysicalDeviceShaderModuleIdentifierFeaturesEXT
    extends IPointer
    permits VkPhysicalDeviceShaderModuleIdentifierFeaturesEXT, VkPhysicalDeviceShaderModuleIdentifierFeaturesEXT.Ptr
{}
