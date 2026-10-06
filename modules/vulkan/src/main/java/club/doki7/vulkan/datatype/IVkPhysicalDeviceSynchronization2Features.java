package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkPhysicalDeviceSynchronization2Features} and {@link VkPhysicalDeviceSynchronization2Features.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkPhysicalDeviceSynchronization2Features
    extends IPointer
    permits VkPhysicalDeviceSynchronization2Features, VkPhysicalDeviceSynchronization2Features.Ptr
{}
