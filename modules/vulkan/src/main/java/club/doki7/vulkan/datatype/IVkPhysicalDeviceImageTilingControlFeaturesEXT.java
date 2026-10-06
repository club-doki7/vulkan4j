package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkPhysicalDeviceImageTilingControlFeaturesEXT} and {@link VkPhysicalDeviceImageTilingControlFeaturesEXT.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkPhysicalDeviceImageTilingControlFeaturesEXT
    extends IPointer
    permits VkPhysicalDeviceImageTilingControlFeaturesEXT, VkPhysicalDeviceImageTilingControlFeaturesEXT.Ptr
{}
