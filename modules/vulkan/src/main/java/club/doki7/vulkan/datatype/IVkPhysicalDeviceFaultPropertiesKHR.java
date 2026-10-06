package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkPhysicalDeviceFaultPropertiesKHR} and {@link VkPhysicalDeviceFaultPropertiesKHR.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkPhysicalDeviceFaultPropertiesKHR
    extends IPointer
    permits VkPhysicalDeviceFaultPropertiesKHR, VkPhysicalDeviceFaultPropertiesKHR.Ptr
{}
