package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkImageDrmFormatModifierListCreateInfoEXT} and {@link VkImageDrmFormatModifierListCreateInfoEXT.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkImageDrmFormatModifierListCreateInfoEXT
    extends IPointer
    permits VkImageDrmFormatModifierListCreateInfoEXT, VkImageDrmFormatModifierListCreateInfoEXT.Ptr
{}
