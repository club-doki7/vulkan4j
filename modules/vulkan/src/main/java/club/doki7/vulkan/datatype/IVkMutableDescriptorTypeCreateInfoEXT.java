package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkMutableDescriptorTypeCreateInfoEXT} and {@link VkMutableDescriptorTypeCreateInfoEXT.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkMutableDescriptorTypeCreateInfoEXT
    extends IPointer
    permits VkMutableDescriptorTypeCreateInfoEXT, VkMutableDescriptorTypeCreateInfoEXT.Ptr
{}
