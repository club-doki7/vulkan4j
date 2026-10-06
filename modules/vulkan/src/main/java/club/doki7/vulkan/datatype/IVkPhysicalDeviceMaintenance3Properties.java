package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkPhysicalDeviceMaintenance3Properties} and {@link VkPhysicalDeviceMaintenance3Properties.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkPhysicalDeviceMaintenance3Properties
    extends IPointer
    permits VkPhysicalDeviceMaintenance3Properties, VkPhysicalDeviceMaintenance3Properties.Ptr
{}
