package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkImageDrmFormatModifierPropertiesEXT} and {@link VkImageDrmFormatModifierPropertiesEXT.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkImageDrmFormatModifierPropertiesEXT
    extends IPointer
    permits VkImageDrmFormatModifierPropertiesEXT, VkImageDrmFormatModifierPropertiesEXT.Ptr
{}
