package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkDescriptorDataEXT} and {@link VkDescriptorDataEXT.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkDescriptorDataEXT
    extends IPointer
    permits VkDescriptorDataEXT, VkDescriptorDataEXT.Ptr
{}
