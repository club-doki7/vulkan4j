package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkPhysicalDeviceZeroInitializeWorkgroupMemoryFeatures} and {@link VkPhysicalDeviceZeroInitializeWorkgroupMemoryFeatures.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkPhysicalDeviceZeroInitializeWorkgroupMemoryFeatures
    extends IPointer
    permits VkPhysicalDeviceZeroInitializeWorkgroupMemoryFeatures, VkPhysicalDeviceZeroInitializeWorkgroupMemoryFeatures.Ptr
{}
