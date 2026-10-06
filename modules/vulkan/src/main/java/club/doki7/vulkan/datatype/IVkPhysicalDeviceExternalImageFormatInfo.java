package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkPhysicalDeviceExternalImageFormatInfo} and {@link VkPhysicalDeviceExternalImageFormatInfo.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkPhysicalDeviceExternalImageFormatInfo
    extends IPointer
    permits VkPhysicalDeviceExternalImageFormatInfo, VkPhysicalDeviceExternalImageFormatInfo.Ptr
{}
