package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkPipelineLayoutCreateInfo} and {@link VkPipelineLayoutCreateInfo.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkPipelineLayoutCreateInfo
    extends IPointer
    permits VkPipelineLayoutCreateInfo, VkPipelineLayoutCreateInfo.Ptr
{}
