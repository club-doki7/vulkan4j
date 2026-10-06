package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkPhysicalDeviceProtectedMemoryProperties} and {@link VkPhysicalDeviceProtectedMemoryProperties.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkPhysicalDeviceProtectedMemoryProperties
    extends IPointer
    permits VkPhysicalDeviceProtectedMemoryProperties, VkPhysicalDeviceProtectedMemoryProperties.Ptr
{}
