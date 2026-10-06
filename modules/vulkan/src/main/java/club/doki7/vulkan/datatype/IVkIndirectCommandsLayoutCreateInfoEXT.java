package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkIndirectCommandsLayoutCreateInfoEXT} and {@link VkIndirectCommandsLayoutCreateInfoEXT.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkIndirectCommandsLayoutCreateInfoEXT
    extends IPointer
    permits VkIndirectCommandsLayoutCreateInfoEXT, VkIndirectCommandsLayoutCreateInfoEXT.Ptr
{}
