package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkVideoEncodeH264CapabilitiesKHR} and {@link VkVideoEncodeH264CapabilitiesKHR.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkVideoEncodeH264CapabilitiesKHR
    extends IPointer
    permits VkVideoEncodeH264CapabilitiesKHR, VkVideoEncodeH264CapabilitiesKHR.Ptr
{}
