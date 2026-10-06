package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkBufferDeviceAddressInfo} and {@link VkBufferDeviceAddressInfo.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkBufferDeviceAddressInfo
    extends IPointer
    permits VkBufferDeviceAddressInfo, VkBufferDeviceAddressInfo.Ptr
{}
