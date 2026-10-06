package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkPhysicalDeviceGpaProperties2AMD} and {@link VkPhysicalDeviceGpaProperties2AMD.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkPhysicalDeviceGpaProperties2AMD
    extends IPointer
    permits VkPhysicalDeviceGpaProperties2AMD, VkPhysicalDeviceGpaProperties2AMD.Ptr
{}
