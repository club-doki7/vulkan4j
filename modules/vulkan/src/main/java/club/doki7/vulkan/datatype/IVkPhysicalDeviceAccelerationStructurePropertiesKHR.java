package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkPhysicalDeviceAccelerationStructurePropertiesKHR} and {@link VkPhysicalDeviceAccelerationStructurePropertiesKHR.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkPhysicalDeviceAccelerationStructurePropertiesKHR
    extends IPointer
    permits VkPhysicalDeviceAccelerationStructurePropertiesKHR, VkPhysicalDeviceAccelerationStructurePropertiesKHR.Ptr
{}
