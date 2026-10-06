package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkPhysicalDevicePushDescriptorProperties} and {@link VkPhysicalDevicePushDescriptorProperties.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkPhysicalDevicePushDescriptorProperties
    extends IPointer
    permits VkPhysicalDevicePushDescriptorProperties, VkPhysicalDevicePushDescriptorProperties.Ptr
{}
