package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkPhysicalDeviceMemoryDecompressionPropertiesEXT} and {@link VkPhysicalDeviceMemoryDecompressionPropertiesEXT.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkPhysicalDeviceMemoryDecompressionPropertiesEXT
    extends IPointer
    permits VkPhysicalDeviceMemoryDecompressionPropertiesEXT, VkPhysicalDeviceMemoryDecompressionPropertiesEXT.Ptr
{}
