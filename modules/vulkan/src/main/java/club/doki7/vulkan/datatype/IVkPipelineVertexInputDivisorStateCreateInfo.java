package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkPipelineVertexInputDivisorStateCreateInfo} and {@link VkPipelineVertexInputDivisorStateCreateInfo.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkPipelineVertexInputDivisorStateCreateInfo
    extends IPointer
    permits VkPipelineVertexInputDivisorStateCreateInfo, VkPipelineVertexInputDivisorStateCreateInfo.Ptr
{}
