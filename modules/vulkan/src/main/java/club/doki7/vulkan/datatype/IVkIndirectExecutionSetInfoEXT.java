package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkIndirectExecutionSetInfoEXT} and {@link VkIndirectExecutionSetInfoEXT.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkIndirectExecutionSetInfoEXT
    extends IPointer
    permits VkIndirectExecutionSetInfoEXT, VkIndirectExecutionSetInfoEXT.Ptr
{}
