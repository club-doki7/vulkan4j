package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkDedicatedAllocationMemoryAllocateInfoNV} and {@link VkDedicatedAllocationMemoryAllocateInfoNV.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkDedicatedAllocationMemoryAllocateInfoNV
    extends IPointer
    permits VkDedicatedAllocationMemoryAllocateInfoNV, VkDedicatedAllocationMemoryAllocateInfoNV.Ptr
{}
