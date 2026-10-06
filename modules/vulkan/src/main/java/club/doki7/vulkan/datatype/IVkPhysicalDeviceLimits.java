package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkPhysicalDeviceLimits} and {@link VkPhysicalDeviceLimits.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkPhysicalDeviceLimits
    extends IPointer
    permits VkPhysicalDeviceLimits, VkPhysicalDeviceLimits.Ptr
{}
