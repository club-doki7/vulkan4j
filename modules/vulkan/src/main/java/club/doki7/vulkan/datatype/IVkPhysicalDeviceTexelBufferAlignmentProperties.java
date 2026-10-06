package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkPhysicalDeviceTexelBufferAlignmentProperties} and {@link VkPhysicalDeviceTexelBufferAlignmentProperties.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkPhysicalDeviceTexelBufferAlignmentProperties
    extends IPointer
    permits VkPhysicalDeviceTexelBufferAlignmentProperties, VkPhysicalDeviceTexelBufferAlignmentProperties.Ptr
{}
