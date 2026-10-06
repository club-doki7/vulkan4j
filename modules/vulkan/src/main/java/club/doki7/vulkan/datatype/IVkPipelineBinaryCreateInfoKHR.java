package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkPipelineBinaryCreateInfoKHR} and {@link VkPipelineBinaryCreateInfoKHR.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkPipelineBinaryCreateInfoKHR
    extends IPointer
    permits VkPipelineBinaryCreateInfoKHR, VkPipelineBinaryCreateInfoKHR.Ptr
{}
