package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkPhysicalDeviceSubgroupSizeControlFeatures} and {@link VkPhysicalDeviceSubgroupSizeControlFeatures.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkPhysicalDeviceSubgroupSizeControlFeatures
    extends IPointer
    permits VkPhysicalDeviceSubgroupSizeControlFeatures, VkPhysicalDeviceSubgroupSizeControlFeatures.Ptr
{}
