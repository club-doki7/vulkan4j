package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkDrmFormatModifierPropertiesEXT} and {@link VkDrmFormatModifierPropertiesEXT.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkDrmFormatModifierPropertiesEXT
    extends IPointer
    permits VkDrmFormatModifierPropertiesEXT, VkDrmFormatModifierPropertiesEXT.Ptr
{}
