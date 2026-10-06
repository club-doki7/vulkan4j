package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkIndirectCommandsLayoutCreateInfoNV} and {@link VkIndirectCommandsLayoutCreateInfoNV.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkIndirectCommandsLayoutCreateInfoNV
    extends IPointer
    permits VkIndirectCommandsLayoutCreateInfoNV, VkIndirectCommandsLayoutCreateInfoNV.Ptr
{}
