package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkDataGraphPipelineInfoARM} and {@link VkDataGraphPipelineInfoARM.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkDataGraphPipelineInfoARM
    extends IPointer
    permits VkDataGraphPipelineInfoARM, VkDataGraphPipelineInfoARM.Ptr
{}
