package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkPhysicalDevicePipelineBinaryFeaturesKHR} and {@link VkPhysicalDevicePipelineBinaryFeaturesKHR.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkPhysicalDevicePipelineBinaryFeaturesKHR
    extends IPointer
    permits VkPhysicalDevicePipelineBinaryFeaturesKHR, VkPhysicalDevicePipelineBinaryFeaturesKHR.Ptr
{}
