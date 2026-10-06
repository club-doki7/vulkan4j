package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkPhysicalDeviceFeatures} and {@link VkPhysicalDeviceFeatures.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkPhysicalDeviceFeatures
    extends IPointer
    permits VkPhysicalDeviceFeatures, VkPhysicalDeviceFeatures.Ptr
{}
