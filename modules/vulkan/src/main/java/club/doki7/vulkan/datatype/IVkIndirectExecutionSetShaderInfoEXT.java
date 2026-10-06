package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkIndirectExecutionSetShaderInfoEXT} and {@link VkIndirectExecutionSetShaderInfoEXT.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkIndirectExecutionSetShaderInfoEXT
    extends IPointer
    permits VkIndirectExecutionSetShaderInfoEXT, VkIndirectExecutionSetShaderInfoEXT.Ptr
{}
