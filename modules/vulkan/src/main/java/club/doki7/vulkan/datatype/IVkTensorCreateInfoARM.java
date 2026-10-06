package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkTensorCreateInfoARM} and {@link VkTensorCreateInfoARM.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkTensorCreateInfoARM
    extends IPointer
    permits VkTensorCreateInfoARM, VkTensorCreateInfoARM.Ptr
{}
