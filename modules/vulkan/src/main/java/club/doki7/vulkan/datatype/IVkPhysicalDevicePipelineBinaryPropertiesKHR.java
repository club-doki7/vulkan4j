package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkPhysicalDevicePipelineBinaryPropertiesKHR} and {@link VkPhysicalDevicePipelineBinaryPropertiesKHR.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkPhysicalDevicePipelineBinaryPropertiesKHR
    extends IPointer
    permits VkPhysicalDevicePipelineBinaryPropertiesKHR, VkPhysicalDevicePipelineBinaryPropertiesKHR.Ptr
{}
