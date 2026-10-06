package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkVideoEncodeAV1ProfileInfoKHR} and {@link VkVideoEncodeAV1ProfileInfoKHR.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkVideoEncodeAV1ProfileInfoKHR
    extends IPointer
    permits VkVideoEncodeAV1ProfileInfoKHR, VkVideoEncodeAV1ProfileInfoKHR.Ptr
{}
