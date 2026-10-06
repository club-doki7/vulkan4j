package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkPhysicalDeviceLineRasterizationFeatures} and {@link VkPhysicalDeviceLineRasterizationFeatures.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkPhysicalDeviceLineRasterizationFeatures
    extends IPointer
    permits VkPhysicalDeviceLineRasterizationFeatures, VkPhysicalDeviceLineRasterizationFeatures.Ptr
{}
