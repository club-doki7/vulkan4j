package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkDataGraphPipelineCreateInfoARM} and {@link VkDataGraphPipelineCreateInfoARM.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkDataGraphPipelineCreateInfoARM
    extends IPointer
    permits VkDataGraphPipelineCreateInfoARM, VkDataGraphPipelineCreateInfoARM.Ptr
{}
