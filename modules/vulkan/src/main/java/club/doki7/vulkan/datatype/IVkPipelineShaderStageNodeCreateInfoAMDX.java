package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkPipelineShaderStageNodeCreateInfoAMDX} and {@link VkPipelineShaderStageNodeCreateInfoAMDX.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkPipelineShaderStageNodeCreateInfoAMDX
    extends IPointer
    permits VkPipelineShaderStageNodeCreateInfoAMDX, VkPipelineShaderStageNodeCreateInfoAMDX.Ptr
{}
