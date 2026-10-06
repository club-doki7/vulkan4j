package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkPhysicalDeviceTexelBufferAlignmentFeaturesEXT} and {@link VkPhysicalDeviceTexelBufferAlignmentFeaturesEXT.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkPhysicalDeviceTexelBufferAlignmentFeaturesEXT
    extends IPointer
    permits VkPhysicalDeviceTexelBufferAlignmentFeaturesEXT, VkPhysicalDeviceTexelBufferAlignmentFeaturesEXT.Ptr
{}
