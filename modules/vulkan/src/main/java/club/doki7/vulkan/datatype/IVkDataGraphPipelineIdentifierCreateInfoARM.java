package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkDataGraphPipelineIdentifierCreateInfoARM} and {@link VkDataGraphPipelineIdentifierCreateInfoARM.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkDataGraphPipelineIdentifierCreateInfoARM
    extends IPointer
    permits VkDataGraphPipelineIdentifierCreateInfoARM, VkDataGraphPipelineIdentifierCreateInfoARM.Ptr
{}
