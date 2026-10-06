package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkPhysicalDevicePointClippingProperties} and {@link VkPhysicalDevicePointClippingProperties.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkPhysicalDevicePointClippingProperties
    extends IPointer
    permits VkPhysicalDevicePointClippingProperties, VkPhysicalDevicePointClippingProperties.Ptr
{}
