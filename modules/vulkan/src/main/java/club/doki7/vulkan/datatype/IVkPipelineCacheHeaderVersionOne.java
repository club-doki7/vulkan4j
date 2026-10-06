package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkPipelineCacheHeaderVersionOne} and {@link VkPipelineCacheHeaderVersionOne.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkPipelineCacheHeaderVersionOne
    extends IPointer
    permits VkPipelineCacheHeaderVersionOne, VkPipelineCacheHeaderVersionOne.Ptr
{}
