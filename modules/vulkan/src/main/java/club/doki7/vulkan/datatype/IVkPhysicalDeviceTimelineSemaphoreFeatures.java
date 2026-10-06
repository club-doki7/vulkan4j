package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkPhysicalDeviceTimelineSemaphoreFeatures} and {@link VkPhysicalDeviceTimelineSemaphoreFeatures.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkPhysicalDeviceTimelineSemaphoreFeatures
    extends IPointer
    permits VkPhysicalDeviceTimelineSemaphoreFeatures, VkPhysicalDeviceTimelineSemaphoreFeatures.Ptr
{}
