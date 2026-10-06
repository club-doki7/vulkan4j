package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkPhysicalDeviceMaintenance4Properties} and {@link VkPhysicalDeviceMaintenance4Properties.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkPhysicalDeviceMaintenance4Properties
    extends IPointer
    permits VkPhysicalDeviceMaintenance4Properties, VkPhysicalDeviceMaintenance4Properties.Ptr
{}
