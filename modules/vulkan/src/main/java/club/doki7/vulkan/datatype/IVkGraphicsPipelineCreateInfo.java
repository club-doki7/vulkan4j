package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkGraphicsPipelineCreateInfo} and {@link VkGraphicsPipelineCreateInfo.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkGraphicsPipelineCreateInfo
    extends IPointer
    permits VkGraphicsPipelineCreateInfo, VkGraphicsPipelineCreateInfo.Ptr
{}
