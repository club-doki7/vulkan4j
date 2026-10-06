package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkVideoDecodeVP9CapabilitiesKHR} and {@link VkVideoDecodeVP9CapabilitiesKHR.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkVideoDecodeVP9CapabilitiesKHR
    extends IPointer
    permits VkVideoDecodeVP9CapabilitiesKHR, VkVideoDecodeVP9CapabilitiesKHR.Ptr
{}
