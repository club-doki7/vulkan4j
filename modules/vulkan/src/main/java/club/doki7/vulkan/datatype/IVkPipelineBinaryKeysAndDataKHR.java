package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkPipelineBinaryKeysAndDataKHR} and {@link VkPipelineBinaryKeysAndDataKHR.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkPipelineBinaryKeysAndDataKHR
    extends IPointer
    permits VkPipelineBinaryKeysAndDataKHR, VkPipelineBinaryKeysAndDataKHR.Ptr
{}
