package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkVideoDecodeAV1CapabilitiesKHR} and {@link VkVideoDecodeAV1CapabilitiesKHR.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkVideoDecodeAV1CapabilitiesKHR
    extends IPointer
    permits VkVideoDecodeAV1CapabilitiesKHR, VkVideoDecodeAV1CapabilitiesKHR.Ptr
{}
