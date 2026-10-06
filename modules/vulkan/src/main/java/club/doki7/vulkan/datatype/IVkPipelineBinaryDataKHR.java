package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkPipelineBinaryDataKHR} and {@link VkPipelineBinaryDataKHR.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkPipelineBinaryDataKHR
    extends IPointer
    permits VkPipelineBinaryDataKHR, VkPipelineBinaryDataKHR.Ptr
{}
