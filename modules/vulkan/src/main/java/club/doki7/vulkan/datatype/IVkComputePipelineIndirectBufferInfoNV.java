package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkComputePipelineIndirectBufferInfoNV} and {@link VkComputePipelineIndirectBufferInfoNV.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkComputePipelineIndirectBufferInfoNV
    extends IPointer
    permits VkComputePipelineIndirectBufferInfoNV, VkComputePipelineIndirectBufferInfoNV.Ptr
{}
