package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkPhysicalDeviceMaintenance5Properties} and {@link VkPhysicalDeviceMaintenance5Properties.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkPhysicalDeviceMaintenance5Properties
    extends IPointer
    permits VkPhysicalDeviceMaintenance5Properties, VkPhysicalDeviceMaintenance5Properties.Ptr
{}
