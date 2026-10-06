package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkBindTensorMemoryInfoARM} and {@link VkBindTensorMemoryInfoARM.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkBindTensorMemoryInfoARM
    extends IPointer
    permits VkBindTensorMemoryInfoARM, VkBindTensorMemoryInfoARM.Ptr
{}
