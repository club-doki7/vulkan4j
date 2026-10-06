package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkPhysicalDeviceMaintenance6Features} and {@link VkPhysicalDeviceMaintenance6Features.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkPhysicalDeviceMaintenance6Features
    extends IPointer
    permits VkPhysicalDeviceMaintenance6Features, VkPhysicalDeviceMaintenance6Features.Ptr
{}
