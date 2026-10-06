package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkVideoEndCodingInfoKHR} and {@link VkVideoEndCodingInfoKHR.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkVideoEndCodingInfoKHR
    extends IPointer
    permits VkVideoEndCodingInfoKHR, VkVideoEndCodingInfoKHR.Ptr
{}
