package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkDataGraphPipelineSessionBindPointRequirementARM} and {@link VkDataGraphPipelineSessionBindPointRequirementARM.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkDataGraphPipelineSessionBindPointRequirementARM
    extends IPointer
    permits VkDataGraphPipelineSessionBindPointRequirementARM, VkDataGraphPipelineSessionBindPointRequirementARM.Ptr
{}
