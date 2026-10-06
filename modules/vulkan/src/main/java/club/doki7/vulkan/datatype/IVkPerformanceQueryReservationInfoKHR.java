package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkPerformanceQueryReservationInfoKHR} and {@link VkPerformanceQueryReservationInfoKHR.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkPerformanceQueryReservationInfoKHR
    extends IPointer
    permits VkPerformanceQueryReservationInfoKHR, VkPerformanceQueryReservationInfoKHR.Ptr
{}
