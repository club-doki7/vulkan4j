package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkPhysicalDeviceShaderObjectPropertiesEXT} and {@link VkPhysicalDeviceShaderObjectPropertiesEXT.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkPhysicalDeviceShaderObjectPropertiesEXT
    extends IPointer
    permits VkPhysicalDeviceShaderObjectPropertiesEXT, VkPhysicalDeviceShaderObjectPropertiesEXT.Ptr
{}
