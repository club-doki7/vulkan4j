package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkPhysicalDeviceExternalComputeQueuePropertiesNV} and {@link VkPhysicalDeviceExternalComputeQueuePropertiesNV.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkPhysicalDeviceExternalComputeQueuePropertiesNV
    extends IPointer
    permits VkPhysicalDeviceExternalComputeQueuePropertiesNV, VkPhysicalDeviceExternalComputeQueuePropertiesNV.Ptr
{}
