package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkPipelineMultisampleStateCreateInfo} and {@link VkPipelineMultisampleStateCreateInfo.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkPipelineMultisampleStateCreateInfo
    extends IPointer
    permits VkPipelineMultisampleStateCreateInfo, VkPipelineMultisampleStateCreateInfo.Ptr
{}
