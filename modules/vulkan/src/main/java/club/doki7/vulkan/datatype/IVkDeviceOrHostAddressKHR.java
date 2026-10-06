package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkDeviceOrHostAddressKHR} and {@link VkDeviceOrHostAddressKHR.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkDeviceOrHostAddressKHR
    extends IPointer
    permits VkDeviceOrHostAddressKHR, VkDeviceOrHostAddressKHR.Ptr
{}
