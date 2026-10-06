package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkBufferOpaqueCaptureAddressCreateInfo} and {@link VkBufferOpaqueCaptureAddressCreateInfo.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkBufferOpaqueCaptureAddressCreateInfo
    extends IPointer
    permits VkBufferOpaqueCaptureAddressCreateInfo, VkBufferOpaqueCaptureAddressCreateInfo.Ptr
{}
