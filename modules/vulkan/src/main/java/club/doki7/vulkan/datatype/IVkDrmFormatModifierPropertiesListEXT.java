package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkDrmFormatModifierPropertiesListEXT} and {@link VkDrmFormatModifierPropertiesListEXT.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkDrmFormatModifierPropertiesListEXT
    extends IPointer
    permits VkDrmFormatModifierPropertiesListEXT, VkDrmFormatModifierPropertiesListEXT.Ptr
{}
