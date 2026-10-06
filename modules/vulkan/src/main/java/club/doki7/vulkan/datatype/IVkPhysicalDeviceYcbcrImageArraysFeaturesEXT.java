package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkPhysicalDeviceYcbcrImageArraysFeaturesEXT} and {@link VkPhysicalDeviceYcbcrImageArraysFeaturesEXT.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkPhysicalDeviceYcbcrImageArraysFeaturesEXT
    extends IPointer
    permits VkPhysicalDeviceYcbcrImageArraysFeaturesEXT, VkPhysicalDeviceYcbcrImageArraysFeaturesEXT.Ptr
{}
