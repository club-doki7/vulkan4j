package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkPhysicalDeviceMemoryDecompressionFeaturesEXT} and {@link VkPhysicalDeviceMemoryDecompressionFeaturesEXT.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkPhysicalDeviceMemoryDecompressionFeaturesEXT
    extends IPointer
    permits VkPhysicalDeviceMemoryDecompressionFeaturesEXT, VkPhysicalDeviceMemoryDecompressionFeaturesEXT.Ptr
{}
