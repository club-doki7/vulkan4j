package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkDrmFormatModifierProperties2EXT} and {@link VkDrmFormatModifierProperties2EXT.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkDrmFormatModifierProperties2EXT
    extends IPointer
    permits VkDrmFormatModifierProperties2EXT, VkDrmFormatModifierProperties2EXT.Ptr
{}
