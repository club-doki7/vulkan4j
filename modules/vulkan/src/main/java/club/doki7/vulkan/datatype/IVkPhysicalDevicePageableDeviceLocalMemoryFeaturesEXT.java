package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkPhysicalDevicePageableDeviceLocalMemoryFeaturesEXT} and {@link VkPhysicalDevicePageableDeviceLocalMemoryFeaturesEXT.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkPhysicalDevicePageableDeviceLocalMemoryFeaturesEXT
    extends IPointer
    permits VkPhysicalDevicePageableDeviceLocalMemoryFeaturesEXT, VkPhysicalDevicePageableDeviceLocalMemoryFeaturesEXT.Ptr
{}
