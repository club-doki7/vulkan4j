package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkPhysicalDeviceMultiDrawPropertiesEXT} and {@link VkPhysicalDeviceMultiDrawPropertiesEXT.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkPhysicalDeviceMultiDrawPropertiesEXT
    extends IPointer
    permits VkPhysicalDeviceMultiDrawPropertiesEXT, VkPhysicalDeviceMultiDrawPropertiesEXT.Ptr
{}
