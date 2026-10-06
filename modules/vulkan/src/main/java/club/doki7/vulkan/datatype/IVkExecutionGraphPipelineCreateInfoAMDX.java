package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkExecutionGraphPipelineCreateInfoAMDX} and {@link VkExecutionGraphPipelineCreateInfoAMDX.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkExecutionGraphPipelineCreateInfoAMDX
    extends IPointer
    permits VkExecutionGraphPipelineCreateInfoAMDX, VkExecutionGraphPipelineCreateInfoAMDX.Ptr
{}
