package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkPushDescriptorSetInfo} and {@link VkPushDescriptorSetInfo.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkPushDescriptorSetInfo
    extends IPointer
    permits VkPushDescriptorSetInfo, VkPushDescriptorSetInfo.Ptr
{}
