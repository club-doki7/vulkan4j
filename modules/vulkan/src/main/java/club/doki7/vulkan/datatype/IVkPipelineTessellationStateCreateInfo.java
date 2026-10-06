package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkPipelineTessellationStateCreateInfo} and {@link VkPipelineTessellationStateCreateInfo.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkPipelineTessellationStateCreateInfo
    extends IPointer
    permits VkPipelineTessellationStateCreateInfo, VkPipelineTessellationStateCreateInfo.Ptr
{}
