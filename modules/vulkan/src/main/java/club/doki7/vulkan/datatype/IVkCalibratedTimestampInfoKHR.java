package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkCalibratedTimestampInfoKHR} and {@link VkCalibratedTimestampInfoKHR.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkCalibratedTimestampInfoKHR
    extends IPointer
    permits VkCalibratedTimestampInfoKHR, VkCalibratedTimestampInfoKHR.Ptr
{}
