package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkPipelineRasterizationDepthClipStateCreateInfoEXT} and {@link VkPipelineRasterizationDepthClipStateCreateInfoEXT.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkPipelineRasterizationDepthClipStateCreateInfoEXT
    extends IPointer
    permits VkPipelineRasterizationDepthClipStateCreateInfoEXT, VkPipelineRasterizationDepthClipStateCreateInfoEXT.Ptr
{}
