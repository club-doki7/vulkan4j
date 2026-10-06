package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkExternalMemoryTensorCreateInfoARM} and {@link VkExternalMemoryTensorCreateInfoARM.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkExternalMemoryTensorCreateInfoARM
    extends IPointer
    permits VkExternalMemoryTensorCreateInfoARM, VkExternalMemoryTensorCreateInfoARM.Ptr
{}
