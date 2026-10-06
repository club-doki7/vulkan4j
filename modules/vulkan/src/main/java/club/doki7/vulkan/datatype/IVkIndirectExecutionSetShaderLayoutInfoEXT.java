package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkIndirectExecutionSetShaderLayoutInfoEXT} and {@link VkIndirectExecutionSetShaderLayoutInfoEXT.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkIndirectExecutionSetShaderLayoutInfoEXT
    extends IPointer
    permits VkIndirectExecutionSetShaderLayoutInfoEXT, VkIndirectExecutionSetShaderLayoutInfoEXT.Ptr
{}
