package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkVideoEncodeH265CapabilitiesKHR} and {@link VkVideoEncodeH265CapabilitiesKHR.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkVideoEncodeH265CapabilitiesKHR
    extends IPointer
    permits VkVideoEncodeH265CapabilitiesKHR, VkVideoEncodeH265CapabilitiesKHR.Ptr
{}
