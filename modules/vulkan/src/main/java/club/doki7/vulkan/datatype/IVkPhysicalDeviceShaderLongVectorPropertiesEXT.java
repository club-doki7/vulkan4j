package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkPhysicalDeviceShaderLongVectorPropertiesEXT} and {@link VkPhysicalDeviceShaderLongVectorPropertiesEXT.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkPhysicalDeviceShaderLongVectorPropertiesEXT
    extends IPointer
    permits VkPhysicalDeviceShaderLongVectorPropertiesEXT, VkPhysicalDeviceShaderLongVectorPropertiesEXT.Ptr
{}
