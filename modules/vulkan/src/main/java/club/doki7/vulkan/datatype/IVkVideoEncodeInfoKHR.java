package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkVideoEncodeInfoKHR} and {@link VkVideoEncodeInfoKHR.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkVideoEncodeInfoKHR
    extends IPointer
    permits VkVideoEncodeInfoKHR, VkVideoEncodeInfoKHR.Ptr
{}
