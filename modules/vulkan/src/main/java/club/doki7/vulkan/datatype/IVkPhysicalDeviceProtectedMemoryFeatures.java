package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkPhysicalDeviceProtectedMemoryFeatures} and {@link VkPhysicalDeviceProtectedMemoryFeatures.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkPhysicalDeviceProtectedMemoryFeatures
    extends IPointer
    permits VkPhysicalDeviceProtectedMemoryFeatures, VkPhysicalDeviceProtectedMemoryFeatures.Ptr
{}
