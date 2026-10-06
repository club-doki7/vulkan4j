package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkVideoDecodeH264CapabilitiesKHR} and {@link VkVideoDecodeH264CapabilitiesKHR.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkVideoDecodeH264CapabilitiesKHR
    extends IPointer
    permits VkVideoDecodeH264CapabilitiesKHR, VkVideoDecodeH264CapabilitiesKHR.Ptr
{}
