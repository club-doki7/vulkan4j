package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkPhysicalDeviceDriverProperties} and {@link VkPhysicalDeviceDriverProperties.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkPhysicalDeviceDriverProperties
    extends IPointer
    permits VkPhysicalDeviceDriverProperties, VkPhysicalDeviceDriverProperties.Ptr
{}
