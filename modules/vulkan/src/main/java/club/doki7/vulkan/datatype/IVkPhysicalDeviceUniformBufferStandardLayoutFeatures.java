package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkPhysicalDeviceUniformBufferStandardLayoutFeatures} and {@link VkPhysicalDeviceUniformBufferStandardLayoutFeatures.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkPhysicalDeviceUniformBufferStandardLayoutFeatures
    extends IPointer
    permits VkPhysicalDeviceUniformBufferStandardLayoutFeatures, VkPhysicalDeviceUniformBufferStandardLayoutFeatures.Ptr
{}
