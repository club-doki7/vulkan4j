package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkPhysicalDeviceGroupProperties} and {@link VkPhysicalDeviceGroupProperties.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkPhysicalDeviceGroupProperties
    extends IPointer
    permits VkPhysicalDeviceGroupProperties, VkPhysicalDeviceGroupProperties.Ptr
{}
