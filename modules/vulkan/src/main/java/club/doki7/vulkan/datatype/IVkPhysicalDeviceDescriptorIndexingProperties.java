package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkPhysicalDeviceDescriptorIndexingProperties} and {@link VkPhysicalDeviceDescriptorIndexingProperties.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkPhysicalDeviceDescriptorIndexingProperties
    extends IPointer
    permits VkPhysicalDeviceDescriptorIndexingProperties, VkPhysicalDeviceDescriptorIndexingProperties.Ptr
{}
