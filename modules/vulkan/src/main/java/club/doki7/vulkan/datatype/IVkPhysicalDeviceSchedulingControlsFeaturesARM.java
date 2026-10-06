package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkPhysicalDeviceSchedulingControlsFeaturesARM} and {@link VkPhysicalDeviceSchedulingControlsFeaturesARM.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkPhysicalDeviceSchedulingControlsFeaturesARM
    extends IPointer
    permits VkPhysicalDeviceSchedulingControlsFeaturesARM, VkPhysicalDeviceSchedulingControlsFeaturesARM.Ptr
{}
