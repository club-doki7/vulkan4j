package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkPipelineBinaryDataInfoKHR} and {@link VkPipelineBinaryDataInfoKHR.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkPipelineBinaryDataInfoKHR
    extends IPointer
    permits VkPipelineBinaryDataInfoKHR, VkPipelineBinaryDataInfoKHR.Ptr
{}
