package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkPhysicalDeviceShaderTileImageFeaturesEXT} and {@link VkPhysicalDeviceShaderTileImageFeaturesEXT.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkPhysicalDeviceShaderTileImageFeaturesEXT
    extends IPointer
    permits VkPhysicalDeviceShaderTileImageFeaturesEXT, VkPhysicalDeviceShaderTileImageFeaturesEXT.Ptr
{}
