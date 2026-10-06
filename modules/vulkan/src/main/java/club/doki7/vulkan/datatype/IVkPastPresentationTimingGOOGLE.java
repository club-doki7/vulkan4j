package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkPastPresentationTimingGOOGLE} and {@link VkPastPresentationTimingGOOGLE.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkPastPresentationTimingGOOGLE
    extends IPointer
    permits VkPastPresentationTimingGOOGLE, VkPastPresentationTimingGOOGLE.Ptr
{}
