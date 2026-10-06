package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkBindPipelineIndirectCommandNV} and {@link VkBindPipelineIndirectCommandNV.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkBindPipelineIndirectCommandNV
    extends IPointer
    permits VkBindPipelineIndirectCommandNV, VkBindPipelineIndirectCommandNV.Ptr
{}
