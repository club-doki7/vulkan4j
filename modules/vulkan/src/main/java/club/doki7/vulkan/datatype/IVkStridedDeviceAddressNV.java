package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkStridedDeviceAddressNV} and {@link VkStridedDeviceAddressNV.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkStridedDeviceAddressNV
    extends IPointer
    permits VkStridedDeviceAddressNV, VkStridedDeviceAddressNV.Ptr
{}
