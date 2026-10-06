package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkDataGraphPipelineConstantARM} and {@link VkDataGraphPipelineConstantARM.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkDataGraphPipelineConstantARM
    extends IPointer
    permits VkDataGraphPipelineConstantARM, VkDataGraphPipelineConstantARM.Ptr
{}
