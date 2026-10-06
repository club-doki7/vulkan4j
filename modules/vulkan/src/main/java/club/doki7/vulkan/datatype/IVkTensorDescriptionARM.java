package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkTensorDescriptionARM} and {@link VkTensorDescriptionARM.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkTensorDescriptionARM
    extends IPointer
    permits VkTensorDescriptionARM, VkTensorDescriptionARM.Ptr
{}
