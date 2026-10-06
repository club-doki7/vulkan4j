package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkPipelineVertexInputStateCreateInfo} and {@link VkPipelineVertexInputStateCreateInfo.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkPipelineVertexInputStateCreateInfo
    extends IPointer
    permits VkPipelineVertexInputStateCreateInfo, VkPipelineVertexInputStateCreateInfo.Ptr
{}
