package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkVideoBeginCodingInfoKHR} and {@link VkVideoBeginCodingInfoKHR.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkVideoBeginCodingInfoKHR
    extends IPointer
    permits VkVideoBeginCodingInfoKHR, VkVideoBeginCodingInfoKHR.Ptr
{}
