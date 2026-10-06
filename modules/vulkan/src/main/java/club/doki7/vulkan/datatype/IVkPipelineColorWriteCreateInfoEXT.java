package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkPipelineColorWriteCreateInfoEXT} and {@link VkPipelineColorWriteCreateInfoEXT.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkPipelineColorWriteCreateInfoEXT
    extends IPointer
    permits VkPipelineColorWriteCreateInfoEXT, VkPipelineColorWriteCreateInfoEXT.Ptr
{}
