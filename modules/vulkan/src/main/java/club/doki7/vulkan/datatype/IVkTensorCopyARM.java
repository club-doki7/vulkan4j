package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkTensorCopyARM} and {@link VkTensorCopyARM.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkTensorCopyARM
    extends IPointer
    permits VkTensorCopyARM, VkTensorCopyARM.Ptr
{}
