package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkDataGraphPipelinePropertyQueryResultARM} and {@link VkDataGraphPipelinePropertyQueryResultARM.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkDataGraphPipelinePropertyQueryResultARM
    extends IPointer
    permits VkDataGraphPipelinePropertyQueryResultARM, VkDataGraphPipelinePropertyQueryResultARM.Ptr
{}
