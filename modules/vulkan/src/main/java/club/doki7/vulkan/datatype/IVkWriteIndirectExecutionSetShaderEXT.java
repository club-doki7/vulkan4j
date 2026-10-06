package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkWriteIndirectExecutionSetShaderEXT} and {@link VkWriteIndirectExecutionSetShaderEXT.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkWriteIndirectExecutionSetShaderEXT
    extends IPointer
    permits VkWriteIndirectExecutionSetShaderEXT, VkWriteIndirectExecutionSetShaderEXT.Ptr
{}
