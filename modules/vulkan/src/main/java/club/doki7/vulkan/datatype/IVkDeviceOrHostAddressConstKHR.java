package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkDeviceOrHostAddressConstKHR} and {@link VkDeviceOrHostAddressConstKHR.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkDeviceOrHostAddressConstKHR
    extends IPointer
    permits VkDeviceOrHostAddressConstKHR, VkDeviceOrHostAddressConstKHR.Ptr
{}
