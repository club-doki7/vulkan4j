package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkDescriptorImageInfo} and {@link VkDescriptorImageInfo.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkDescriptorImageInfo
    extends IPointer
    permits VkDescriptorImageInfo, VkDescriptorImageInfo.Ptr
{}
