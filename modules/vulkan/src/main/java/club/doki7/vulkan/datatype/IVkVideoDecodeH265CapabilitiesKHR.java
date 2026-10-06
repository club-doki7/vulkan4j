package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkVideoDecodeH265CapabilitiesKHR} and {@link VkVideoDecodeH265CapabilitiesKHR.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkVideoDecodeH265CapabilitiesKHR
    extends IPointer
    permits VkVideoDecodeH265CapabilitiesKHR, VkVideoDecodeH265CapabilitiesKHR.Ptr
{}
