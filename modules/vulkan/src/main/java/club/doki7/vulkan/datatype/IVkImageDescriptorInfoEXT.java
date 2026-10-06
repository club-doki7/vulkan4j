package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkImageDescriptorInfoEXT} and {@link VkImageDescriptorInfoEXT.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkImageDescriptorInfoEXT
    extends IPointer
    permits VkImageDescriptorInfoEXT, VkImageDescriptorInfoEXT.Ptr
{}
