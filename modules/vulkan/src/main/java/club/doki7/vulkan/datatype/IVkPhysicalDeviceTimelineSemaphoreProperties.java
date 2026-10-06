package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkPhysicalDeviceTimelineSemaphoreProperties} and {@link VkPhysicalDeviceTimelineSemaphoreProperties.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkPhysicalDeviceTimelineSemaphoreProperties
    extends IPointer
    permits VkPhysicalDeviceTimelineSemaphoreProperties, VkPhysicalDeviceTimelineSemaphoreProperties.Ptr
{}
