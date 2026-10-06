package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkDeviceFaultVendorInfoKHR} and {@link VkDeviceFaultVendorInfoKHR.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkDeviceFaultVendorInfoKHR
    extends IPointer
    permits VkDeviceFaultVendorInfoKHR, VkDeviceFaultVendorInfoKHR.Ptr
{}
