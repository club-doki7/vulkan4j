package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkPresentRegionKHR} and {@link VkPresentRegionKHR.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkPresentRegionKHR
    extends IPointer
    permits VkPresentRegionKHR, VkPresentRegionKHR.Ptr
{}
