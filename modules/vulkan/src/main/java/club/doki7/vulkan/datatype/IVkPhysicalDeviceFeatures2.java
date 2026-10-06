package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkPhysicalDeviceFeatures2} and {@link VkPhysicalDeviceFeatures2.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkPhysicalDeviceFeatures2
    extends IPointer
    permits VkPhysicalDeviceFeatures2, VkPhysicalDeviceFeatures2.Ptr
{}
