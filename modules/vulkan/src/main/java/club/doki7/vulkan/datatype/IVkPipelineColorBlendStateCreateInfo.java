package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkPipelineColorBlendStateCreateInfo} and {@link VkPipelineColorBlendStateCreateInfo.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkPipelineColorBlendStateCreateInfo
    extends IPointer
    permits VkPipelineColorBlendStateCreateInfo, VkPipelineColorBlendStateCreateInfo.Ptr
{}
