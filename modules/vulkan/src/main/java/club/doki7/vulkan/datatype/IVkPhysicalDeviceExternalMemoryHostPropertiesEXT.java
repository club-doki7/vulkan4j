package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkPhysicalDeviceExternalMemoryHostPropertiesEXT} and {@link VkPhysicalDeviceExternalMemoryHostPropertiesEXT.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkPhysicalDeviceExternalMemoryHostPropertiesEXT
    extends IPointer
    permits VkPhysicalDeviceExternalMemoryHostPropertiesEXT, VkPhysicalDeviceExternalMemoryHostPropertiesEXT.Ptr
{}
