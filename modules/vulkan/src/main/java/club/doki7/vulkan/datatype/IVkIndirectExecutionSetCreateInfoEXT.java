package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkIndirectExecutionSetCreateInfoEXT} and {@link VkIndirectExecutionSetCreateInfoEXT.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkIndirectExecutionSetCreateInfoEXT
    extends IPointer
    permits VkIndirectExecutionSetCreateInfoEXT, VkIndirectExecutionSetCreateInfoEXT.Ptr
{}
