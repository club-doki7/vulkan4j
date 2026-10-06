package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkPhysicalDeviceImageRobustnessFeatures} and {@link VkPhysicalDeviceImageRobustnessFeatures.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkPhysicalDeviceImageRobustnessFeatures
    extends IPointer
    permits VkPhysicalDeviceImageRobustnessFeatures, VkPhysicalDeviceImageRobustnessFeatures.Ptr
{}
