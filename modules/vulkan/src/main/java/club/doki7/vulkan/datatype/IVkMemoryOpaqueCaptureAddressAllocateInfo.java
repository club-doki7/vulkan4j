package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkMemoryOpaqueCaptureAddressAllocateInfo} and {@link VkMemoryOpaqueCaptureAddressAllocateInfo.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkMemoryOpaqueCaptureAddressAllocateInfo
    extends IPointer
    permits VkMemoryOpaqueCaptureAddressAllocateInfo, VkMemoryOpaqueCaptureAddressAllocateInfo.Ptr
{}
