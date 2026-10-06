package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkDataGraphPipelineResourceInfoARM} and {@link VkDataGraphPipelineResourceInfoARM.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkDataGraphPipelineResourceInfoARM
    extends IPointer
    permits VkDataGraphPipelineResourceInfoARM, VkDataGraphPipelineResourceInfoARM.Ptr
{}
