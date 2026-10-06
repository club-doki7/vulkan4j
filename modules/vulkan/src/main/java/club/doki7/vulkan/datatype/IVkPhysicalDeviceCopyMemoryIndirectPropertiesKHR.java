package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkPhysicalDeviceCopyMemoryIndirectPropertiesKHR} and {@link VkPhysicalDeviceCopyMemoryIndirectPropertiesKHR.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkPhysicalDeviceCopyMemoryIndirectPropertiesKHR
    extends IPointer
    permits VkPhysicalDeviceCopyMemoryIndirectPropertiesKHR, VkPhysicalDeviceCopyMemoryIndirectPropertiesKHR.Ptr
{}
