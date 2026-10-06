package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkPhysicalDeviceHostImageCopyProperties} and {@link VkPhysicalDeviceHostImageCopyProperties.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkPhysicalDeviceHostImageCopyProperties
    extends IPointer
    permits VkPhysicalDeviceHostImageCopyProperties, VkPhysicalDeviceHostImageCopyProperties.Ptr
{}
