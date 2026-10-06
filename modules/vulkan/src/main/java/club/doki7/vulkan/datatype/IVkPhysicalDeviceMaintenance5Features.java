package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkPhysicalDeviceMaintenance5Features} and {@link VkPhysicalDeviceMaintenance5Features.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkPhysicalDeviceMaintenance5Features
    extends IPointer
    permits VkPhysicalDeviceMaintenance5Features, VkPhysicalDeviceMaintenance5Features.Ptr
{}
