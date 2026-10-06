package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkPhysicalDeviceShaderTileImagePropertiesEXT} and {@link VkPhysicalDeviceShaderTileImagePropertiesEXT.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkPhysicalDeviceShaderTileImagePropertiesEXT
    extends IPointer
    permits VkPhysicalDeviceShaderTileImagePropertiesEXT, VkPhysicalDeviceShaderTileImagePropertiesEXT.Ptr
{}
