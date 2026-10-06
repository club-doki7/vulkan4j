package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkMultisamplePropertiesEXT} and {@link VkMultisamplePropertiesEXT.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkMultisamplePropertiesEXT
    extends IPointer
    permits VkMultisamplePropertiesEXT, VkMultisamplePropertiesEXT.Ptr
{}
