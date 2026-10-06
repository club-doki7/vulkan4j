package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkDescriptorSetAllocateInfo} and {@link VkDescriptorSetAllocateInfo.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkDescriptorSetAllocateInfo
    extends IPointer
    permits VkDescriptorSetAllocateInfo, VkDescriptorSetAllocateInfo.Ptr
{}
