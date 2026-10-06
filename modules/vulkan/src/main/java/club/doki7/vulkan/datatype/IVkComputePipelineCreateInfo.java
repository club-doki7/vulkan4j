package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkComputePipelineCreateInfo} and {@link VkComputePipelineCreateInfo.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkComputePipelineCreateInfo
    extends IPointer
    permits VkComputePipelineCreateInfo, VkComputePipelineCreateInfo.Ptr
{}
