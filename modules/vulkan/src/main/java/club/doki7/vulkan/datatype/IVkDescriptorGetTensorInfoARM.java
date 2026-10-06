package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkDescriptorGetTensorInfoARM} and {@link VkDescriptorGetTensorInfoARM.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkDescriptorGetTensorInfoARM
    extends IPointer
    permits VkDescriptorGetTensorInfoARM, VkDescriptorGetTensorInfoARM.Ptr
{}
