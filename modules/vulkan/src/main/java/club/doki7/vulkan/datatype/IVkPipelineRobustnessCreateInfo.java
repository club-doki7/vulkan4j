package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkPipelineRobustnessCreateInfo} and {@link VkPipelineRobustnessCreateInfo.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkPipelineRobustnessCreateInfo
    extends IPointer
    permits VkPipelineRobustnessCreateInfo, VkPipelineRobustnessCreateInfo.Ptr
{}
