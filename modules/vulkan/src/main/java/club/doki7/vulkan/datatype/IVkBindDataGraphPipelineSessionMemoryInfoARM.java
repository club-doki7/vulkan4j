package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkBindDataGraphPipelineSessionMemoryInfoARM} and {@link VkBindDataGraphPipelineSessionMemoryInfoARM.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkBindDataGraphPipelineSessionMemoryInfoARM
    extends IPointer
    permits VkBindDataGraphPipelineSessionMemoryInfoARM, VkBindDataGraphPipelineSessionMemoryInfoARM.Ptr
{}
