package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkDeviceMemoryOpaqueCaptureAddressInfo} and {@link VkDeviceMemoryOpaqueCaptureAddressInfo.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkDeviceMemoryOpaqueCaptureAddressInfo
    extends IPointer
    permits VkDeviceMemoryOpaqueCaptureAddressInfo, VkDeviceMemoryOpaqueCaptureAddressInfo.Ptr
{}
