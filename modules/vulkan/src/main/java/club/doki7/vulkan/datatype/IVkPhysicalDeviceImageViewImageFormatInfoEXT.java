package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkPhysicalDeviceImageViewImageFormatInfoEXT} and {@link VkPhysicalDeviceImageViewImageFormatInfoEXT.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkPhysicalDeviceImageViewImageFormatInfoEXT
    extends IPointer
    permits VkPhysicalDeviceImageViewImageFormatInfoEXT, VkPhysicalDeviceImageViewImageFormatInfoEXT.Ptr
{}
