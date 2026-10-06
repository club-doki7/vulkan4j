package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkPhysicalDeviceMemoryPriorityFeaturesEXT} and {@link VkPhysicalDeviceMemoryPriorityFeaturesEXT.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkPhysicalDeviceMemoryPriorityFeaturesEXT
    extends IPointer
    permits VkPhysicalDeviceMemoryPriorityFeaturesEXT, VkPhysicalDeviceMemoryPriorityFeaturesEXT.Ptr
{}
