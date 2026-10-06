package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkPipelineShaderStageCreateInfo} and {@link VkPipelineShaderStageCreateInfo.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkPipelineShaderStageCreateInfo
    extends IPointer
    permits VkPipelineShaderStageCreateInfo, VkPipelineShaderStageCreateInfo.Ptr
{}
