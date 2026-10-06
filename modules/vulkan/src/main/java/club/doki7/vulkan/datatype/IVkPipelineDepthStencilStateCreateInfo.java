package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkPipelineDepthStencilStateCreateInfo} and {@link VkPipelineDepthStencilStateCreateInfo.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkPipelineDepthStencilStateCreateInfo
    extends IPointer
    permits VkPipelineDepthStencilStateCreateInfo, VkPipelineDepthStencilStateCreateInfo.Ptr
{}
