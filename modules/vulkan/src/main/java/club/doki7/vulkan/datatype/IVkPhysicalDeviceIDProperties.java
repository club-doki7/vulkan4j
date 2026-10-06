package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkPhysicalDeviceIDProperties} and {@link VkPhysicalDeviceIDProperties.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkPhysicalDeviceIDProperties
    extends IPointer
    permits VkPhysicalDeviceIDProperties, VkPhysicalDeviceIDProperties.Ptr
{}
