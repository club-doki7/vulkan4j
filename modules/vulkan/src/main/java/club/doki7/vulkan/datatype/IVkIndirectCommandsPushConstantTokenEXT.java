package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkIndirectCommandsPushConstantTokenEXT} and {@link VkIndirectCommandsPushConstantTokenEXT.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkIndirectCommandsPushConstantTokenEXT
    extends IPointer
    permits VkIndirectCommandsPushConstantTokenEXT, VkIndirectCommandsPushConstantTokenEXT.Ptr
{}
