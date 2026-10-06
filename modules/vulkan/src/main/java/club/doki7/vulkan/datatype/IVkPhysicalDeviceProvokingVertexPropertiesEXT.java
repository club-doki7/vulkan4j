package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkPhysicalDeviceProvokingVertexPropertiesEXT} and {@link VkPhysicalDeviceProvokingVertexPropertiesEXT.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkPhysicalDeviceProvokingVertexPropertiesEXT
    extends IPointer
    permits VkPhysicalDeviceProvokingVertexPropertiesEXT, VkPhysicalDeviceProvokingVertexPropertiesEXT.Ptr
{}
