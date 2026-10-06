package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkPhysicalDeviceSamplerFilterMinmaxProperties} and {@link VkPhysicalDeviceSamplerFilterMinmaxProperties.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkPhysicalDeviceSamplerFilterMinmaxProperties
    extends IPointer
    permits VkPhysicalDeviceSamplerFilterMinmaxProperties, VkPhysicalDeviceSamplerFilterMinmaxProperties.Ptr
{}
