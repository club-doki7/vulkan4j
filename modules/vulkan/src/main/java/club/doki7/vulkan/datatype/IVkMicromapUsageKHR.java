package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkMicromapUsageKHR} and {@link VkMicromapUsageKHR.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkMicromapUsageKHR
    extends IPointer
    permits VkMicromapUsageKHR, VkMicromapUsageKHR.Ptr
{}
