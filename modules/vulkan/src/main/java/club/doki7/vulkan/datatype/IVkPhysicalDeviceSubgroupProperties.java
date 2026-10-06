package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkPhysicalDeviceSubgroupProperties} and {@link VkPhysicalDeviceSubgroupProperties.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkPhysicalDeviceSubgroupProperties
    extends IPointer
    permits VkPhysicalDeviceSubgroupProperties, VkPhysicalDeviceSubgroupProperties.Ptr
{}
