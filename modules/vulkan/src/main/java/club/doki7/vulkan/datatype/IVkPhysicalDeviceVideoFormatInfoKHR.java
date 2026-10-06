package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkPhysicalDeviceVideoFormatInfoKHR} and {@link VkPhysicalDeviceVideoFormatInfoKHR.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkPhysicalDeviceVideoFormatInfoKHR
    extends IPointer
    permits VkPhysicalDeviceVideoFormatInfoKHR, VkPhysicalDeviceVideoFormatInfoKHR.Ptr
{}
