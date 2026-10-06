package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkDescriptorMappingSourcePushIndexEXT} and {@link VkDescriptorMappingSourcePushIndexEXT.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkDescriptorMappingSourcePushIndexEXT
    extends IPointer
    permits VkDescriptorMappingSourcePushIndexEXT, VkDescriptorMappingSourcePushIndexEXT.Ptr
{}
