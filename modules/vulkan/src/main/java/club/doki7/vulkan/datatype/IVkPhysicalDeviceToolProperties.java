package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkPhysicalDeviceToolProperties} and {@link VkPhysicalDeviceToolProperties.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkPhysicalDeviceToolProperties
    extends IPointer
    permits VkPhysicalDeviceToolProperties, VkPhysicalDeviceToolProperties.Ptr
{}
