package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkBufferDeviceAddressAlignmentAllocateInfoVALVE} and {@link VkBufferDeviceAddressAlignmentAllocateInfoVALVE.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkBufferDeviceAddressAlignmentAllocateInfoVALVE
    extends IPointer
    permits VkBufferDeviceAddressAlignmentAllocateInfoVALVE, VkBufferDeviceAddressAlignmentAllocateInfoVALVE.Ptr
{}
