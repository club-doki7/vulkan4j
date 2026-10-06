package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkPhysicalDeviceVertexAttributeDivisorPropertiesEXT} and {@link VkPhysicalDeviceVertexAttributeDivisorPropertiesEXT.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkPhysicalDeviceVertexAttributeDivisorPropertiesEXT
    extends IPointer
    permits VkPhysicalDeviceVertexAttributeDivisorPropertiesEXT, VkPhysicalDeviceVertexAttributeDivisorPropertiesEXT.Ptr
{}
