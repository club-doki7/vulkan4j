package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkPipelineCreateFlags2CreateInfo} and {@link VkPipelineCreateFlags2CreateInfo.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkPipelineCreateFlags2CreateInfo
    extends IPointer
    permits VkPipelineCreateFlags2CreateInfo, VkPipelineCreateFlags2CreateInfo.Ptr
{}
