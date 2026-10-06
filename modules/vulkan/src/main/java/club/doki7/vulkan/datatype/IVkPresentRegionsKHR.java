package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkPresentRegionsKHR} and {@link VkPresentRegionsKHR.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkPresentRegionsKHR
    extends IPointer
    permits VkPresentRegionsKHR, VkPresentRegionsKHR.Ptr
{}
