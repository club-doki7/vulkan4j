package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkPipelineRasterizationLineStateCreateInfo} and {@link VkPipelineRasterizationLineStateCreateInfo.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkPipelineRasterizationLineStateCreateInfo
    extends IPointer
    permits VkPipelineRasterizationLineStateCreateInfo, VkPipelineRasterizationLineStateCreateInfo.Ptr
{}
