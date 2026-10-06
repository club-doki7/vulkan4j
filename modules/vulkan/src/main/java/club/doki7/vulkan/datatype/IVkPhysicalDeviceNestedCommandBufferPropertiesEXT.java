package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkPhysicalDeviceNestedCommandBufferPropertiesEXT} and {@link VkPhysicalDeviceNestedCommandBufferPropertiesEXT.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkPhysicalDeviceNestedCommandBufferPropertiesEXT
    extends IPointer
    permits VkPhysicalDeviceNestedCommandBufferPropertiesEXT, VkPhysicalDeviceNestedCommandBufferPropertiesEXT.Ptr
{}
