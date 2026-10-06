package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkGeneratedCommandsPipelineInfoEXT} and {@link VkGeneratedCommandsPipelineInfoEXT.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkGeneratedCommandsPipelineInfoEXT
    extends IPointer
    permits VkGeneratedCommandsPipelineInfoEXT, VkGeneratedCommandsPipelineInfoEXT.Ptr
{}
