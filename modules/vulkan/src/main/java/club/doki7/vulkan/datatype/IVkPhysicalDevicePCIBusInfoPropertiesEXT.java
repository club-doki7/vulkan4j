package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkPhysicalDevicePCIBusInfoPropertiesEXT} and {@link VkPhysicalDevicePCIBusInfoPropertiesEXT.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkPhysicalDevicePCIBusInfoPropertiesEXT
    extends IPointer
    permits VkPhysicalDevicePCIBusInfoPropertiesEXT, VkPhysicalDevicePCIBusInfoPropertiesEXT.Ptr
{}
