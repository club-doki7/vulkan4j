package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkPhysicalDeviceInfoPropertiesINTEL} and {@link VkPhysicalDeviceInfoPropertiesINTEL.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkPhysicalDeviceInfoPropertiesINTEL
    extends IPointer
    permits VkPhysicalDeviceInfoPropertiesINTEL, VkPhysicalDeviceInfoPropertiesINTEL.Ptr
{}
