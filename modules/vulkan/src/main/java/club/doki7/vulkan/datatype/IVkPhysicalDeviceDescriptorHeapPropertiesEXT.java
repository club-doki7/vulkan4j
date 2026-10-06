package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkPhysicalDeviceDescriptorHeapPropertiesEXT} and {@link VkPhysicalDeviceDescriptorHeapPropertiesEXT.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkPhysicalDeviceDescriptorHeapPropertiesEXT
    extends IPointer
    permits VkPhysicalDeviceDescriptorHeapPropertiesEXT, VkPhysicalDeviceDescriptorHeapPropertiesEXT.Ptr
{}
