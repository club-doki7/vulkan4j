package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkIndirectCommandsExecutionSetTokenEXT} and {@link VkIndirectCommandsExecutionSetTokenEXT.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkIndirectCommandsExecutionSetTokenEXT
    extends IPointer
    permits VkIndirectCommandsExecutionSetTokenEXT, VkIndirectCommandsExecutionSetTokenEXT.Ptr
{}
