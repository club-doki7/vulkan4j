package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkStridedDeviceAddressRegionKHR} and {@link VkStridedDeviceAddressRegionKHR.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkStridedDeviceAddressRegionKHR
    extends IPointer
    permits VkStridedDeviceAddressRegionKHR, VkStridedDeviceAddressRegionKHR.Ptr
{}
