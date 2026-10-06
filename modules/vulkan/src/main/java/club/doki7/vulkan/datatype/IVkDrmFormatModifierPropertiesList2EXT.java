package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkDrmFormatModifierPropertiesList2EXT} and {@link VkDrmFormatModifierPropertiesList2EXT.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkDrmFormatModifierPropertiesList2EXT
    extends IPointer
    permits VkDrmFormatModifierPropertiesList2EXT, VkDrmFormatModifierPropertiesList2EXT.Ptr
{}
