package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkDeviceFaultInfoKHR} and {@link VkDeviceFaultInfoKHR.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkDeviceFaultInfoKHR
    extends IPointer
    permits VkDeviceFaultInfoKHR, VkDeviceFaultInfoKHR.Ptr
{}
