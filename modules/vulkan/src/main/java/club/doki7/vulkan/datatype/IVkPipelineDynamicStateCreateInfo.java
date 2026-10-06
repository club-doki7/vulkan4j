package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkPipelineDynamicStateCreateInfo} and {@link VkPipelineDynamicStateCreateInfo.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkPipelineDynamicStateCreateInfo
    extends IPointer
    permits VkPipelineDynamicStateCreateInfo, VkPipelineDynamicStateCreateInfo.Ptr
{}
