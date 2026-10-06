package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkPhysicalDeviceSchedulingControlsPropertiesARM} and {@link VkPhysicalDeviceSchedulingControlsPropertiesARM.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkPhysicalDeviceSchedulingControlsPropertiesARM
    extends IPointer
    permits VkPhysicalDeviceSchedulingControlsPropertiesARM, VkPhysicalDeviceSchedulingControlsPropertiesARM.Ptr
{}
