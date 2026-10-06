package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkVideoEncodeCapabilitiesKHR} and {@link VkVideoEncodeCapabilitiesKHR.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkVideoEncodeCapabilitiesKHR
    extends IPointer
    permits VkVideoEncodeCapabilitiesKHR, VkVideoEncodeCapabilitiesKHR.Ptr
{}
