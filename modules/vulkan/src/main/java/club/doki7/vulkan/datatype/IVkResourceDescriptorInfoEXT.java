package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkResourceDescriptorInfoEXT} and {@link VkResourceDescriptorInfoEXT.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkResourceDescriptorInfoEXT
    extends IPointer
    permits VkResourceDescriptorInfoEXT, VkResourceDescriptorInfoEXT.Ptr
{}
