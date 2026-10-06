package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkStridedDeviceAddressRangeKHR} and {@link VkStridedDeviceAddressRangeKHR.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkStridedDeviceAddressRangeKHR
    extends IPointer
    permits VkStridedDeviceAddressRangeKHR, VkStridedDeviceAddressRangeKHR.Ptr
{}
