package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkVideoEncodeAV1CapabilitiesKHR} and {@link VkVideoEncodeAV1CapabilitiesKHR.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkVideoEncodeAV1CapabilitiesKHR
    extends IPointer
    permits VkVideoEncodeAV1CapabilitiesKHR, VkVideoEncodeAV1CapabilitiesKHR.Ptr
{}
