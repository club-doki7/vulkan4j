package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkDeviceFaultAddressInfoKHR} and {@link VkDeviceFaultAddressInfoKHR.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkDeviceFaultAddressInfoKHR
    extends IPointer
    permits VkDeviceFaultAddressInfoKHR, VkDeviceFaultAddressInfoKHR.Ptr
{}
