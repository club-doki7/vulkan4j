package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkPipelineBinaryKeyKHR} and {@link VkPipelineBinaryKeyKHR.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkPipelineBinaryKeyKHR
    extends IPointer
    permits VkPipelineBinaryKeyKHR, VkPipelineBinaryKeyKHR.Ptr
{}
