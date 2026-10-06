package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkMemoryDedicatedAllocateInfoTensorARM} and {@link VkMemoryDedicatedAllocateInfoTensorARM.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkMemoryDedicatedAllocateInfoTensorARM
    extends IPointer
    permits VkMemoryDedicatedAllocateInfoTensorARM, VkMemoryDedicatedAllocateInfoTensorARM.Ptr
{}
