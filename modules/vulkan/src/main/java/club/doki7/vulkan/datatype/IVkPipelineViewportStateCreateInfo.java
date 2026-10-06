package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkPipelineViewportStateCreateInfo} and {@link VkPipelineViewportStateCreateInfo.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkPipelineViewportStateCreateInfo
    extends IPointer
    permits VkPipelineViewportStateCreateInfo, VkPipelineViewportStateCreateInfo.Ptr
{}
