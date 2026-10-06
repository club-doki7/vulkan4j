package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkPhysicalDeviceDescriptorBufferPropertiesEXT} and {@link VkPhysicalDeviceDescriptorBufferPropertiesEXT.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkPhysicalDeviceDescriptorBufferPropertiesEXT
    extends IPointer
    permits VkPhysicalDeviceDescriptorBufferPropertiesEXT, VkPhysicalDeviceDescriptorBufferPropertiesEXT.Ptr
{}
