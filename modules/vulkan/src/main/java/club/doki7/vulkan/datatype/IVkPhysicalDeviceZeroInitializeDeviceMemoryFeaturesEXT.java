package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkPhysicalDeviceZeroInitializeDeviceMemoryFeaturesEXT} and {@link VkPhysicalDeviceZeroInitializeDeviceMemoryFeaturesEXT.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkPhysicalDeviceZeroInitializeDeviceMemoryFeaturesEXT
    extends IPointer
    permits VkPhysicalDeviceZeroInitializeDeviceMemoryFeaturesEXT, VkPhysicalDeviceZeroInitializeDeviceMemoryFeaturesEXT.Ptr
{}
