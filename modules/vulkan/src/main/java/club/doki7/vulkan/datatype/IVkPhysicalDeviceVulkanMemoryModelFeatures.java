package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkPhysicalDeviceVulkanMemoryModelFeatures} and {@link VkPhysicalDeviceVulkanMemoryModelFeatures.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkPhysicalDeviceVulkanMemoryModelFeatures
    extends IPointer
    permits VkPhysicalDeviceVulkanMemoryModelFeatures, VkPhysicalDeviceVulkanMemoryModelFeatures.Ptr
{}
