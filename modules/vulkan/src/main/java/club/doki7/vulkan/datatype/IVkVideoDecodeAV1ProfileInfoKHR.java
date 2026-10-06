package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkVideoDecodeAV1ProfileInfoKHR} and {@link VkVideoDecodeAV1ProfileInfoKHR.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkVideoDecodeAV1ProfileInfoKHR
    extends IPointer
    permits VkVideoDecodeAV1ProfileInfoKHR, VkVideoDecodeAV1ProfileInfoKHR.Ptr
{}
