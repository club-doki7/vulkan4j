package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkPhysicalDeviceImageFormatInfo2} and {@link VkPhysicalDeviceImageFormatInfo2.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkPhysicalDeviceImageFormatInfo2
    extends IPointer
    permits VkPhysicalDeviceImageFormatInfo2, VkPhysicalDeviceImageFormatInfo2.Ptr
{}
