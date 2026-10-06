package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkPhysicalDeviceCustomResolveFeaturesEXT} and {@link VkPhysicalDeviceCustomResolveFeaturesEXT.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkPhysicalDeviceCustomResolveFeaturesEXT
    extends IPointer
    permits VkPhysicalDeviceCustomResolveFeaturesEXT, VkPhysicalDeviceCustomResolveFeaturesEXT.Ptr
{}
