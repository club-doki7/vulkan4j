package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkPhysicalDeviceMultiviewFeatures} and {@link VkPhysicalDeviceMultiviewFeatures.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkPhysicalDeviceMultiviewFeatures
    extends IPointer
    permits VkPhysicalDeviceMultiviewFeatures, VkPhysicalDeviceMultiviewFeatures.Ptr
{}
