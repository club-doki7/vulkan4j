package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkPhysicalDeviceDescriptorIndexingFeatures} and {@link VkPhysicalDeviceDescriptorIndexingFeatures.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkPhysicalDeviceDescriptorIndexingFeatures
    extends IPointer
    permits VkPhysicalDeviceDescriptorIndexingFeatures, VkPhysicalDeviceDescriptorIndexingFeatures.Ptr
{}
