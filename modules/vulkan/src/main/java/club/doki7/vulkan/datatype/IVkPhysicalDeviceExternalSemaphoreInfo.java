package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkPhysicalDeviceExternalSemaphoreInfo} and {@link VkPhysicalDeviceExternalSemaphoreInfo.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkPhysicalDeviceExternalSemaphoreInfo
    extends IPointer
    permits VkPhysicalDeviceExternalSemaphoreInfo, VkPhysicalDeviceExternalSemaphoreInfo.Ptr
{}
