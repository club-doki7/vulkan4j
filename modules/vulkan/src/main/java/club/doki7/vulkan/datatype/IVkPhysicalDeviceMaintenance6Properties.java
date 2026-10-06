package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkPhysicalDeviceMaintenance6Properties} and {@link VkPhysicalDeviceMaintenance6Properties.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkPhysicalDeviceMaintenance6Properties
    extends IPointer
    permits VkPhysicalDeviceMaintenance6Properties, VkPhysicalDeviceMaintenance6Properties.Ptr
{}
