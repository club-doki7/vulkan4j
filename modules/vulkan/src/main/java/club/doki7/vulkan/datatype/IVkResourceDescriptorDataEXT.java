package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkResourceDescriptorDataEXT} and {@link VkResourceDescriptorDataEXT.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkResourceDescriptorDataEXT
    extends IPointer
    permits VkResourceDescriptorDataEXT, VkResourceDescriptorDataEXT.Ptr
{}
