package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkPhysicalDeviceMaintenance4Features} and {@link VkPhysicalDeviceMaintenance4Features.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkPhysicalDeviceMaintenance4Features
    extends IPointer
    permits VkPhysicalDeviceMaintenance4Features, VkPhysicalDeviceMaintenance4Features.Ptr
{}
