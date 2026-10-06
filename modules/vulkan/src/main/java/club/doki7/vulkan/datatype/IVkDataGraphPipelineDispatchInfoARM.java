package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkDataGraphPipelineDispatchInfoARM} and {@link VkDataGraphPipelineDispatchInfoARM.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkDataGraphPipelineDispatchInfoARM
    extends IPointer
    permits VkDataGraphPipelineDispatchInfoARM, VkDataGraphPipelineDispatchInfoARM.Ptr
{}
