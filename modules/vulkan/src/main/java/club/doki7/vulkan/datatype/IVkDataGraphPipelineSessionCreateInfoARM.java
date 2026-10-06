package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkDataGraphPipelineSessionCreateInfoARM} and {@link VkDataGraphPipelineSessionCreateInfoARM.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkDataGraphPipelineSessionCreateInfoARM
    extends IPointer
    permits VkDataGraphPipelineSessionCreateInfoARM, VkDataGraphPipelineSessionCreateInfoARM.Ptr
{}
