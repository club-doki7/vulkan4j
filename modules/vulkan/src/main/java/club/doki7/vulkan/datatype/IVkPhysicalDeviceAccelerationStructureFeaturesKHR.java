package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkPhysicalDeviceAccelerationStructureFeaturesKHR} and {@link VkPhysicalDeviceAccelerationStructureFeaturesKHR.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkPhysicalDeviceAccelerationStructureFeaturesKHR
    extends IPointer
    permits VkPhysicalDeviceAccelerationStructureFeaturesKHR, VkPhysicalDeviceAccelerationStructureFeaturesKHR.Ptr
{}
