package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkPastPresentationTimingInfoEXT} and {@link VkPastPresentationTimingInfoEXT.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkPastPresentationTimingInfoEXT
    extends IPointer
    permits VkPastPresentationTimingInfoEXT, VkPastPresentationTimingInfoEXT.Ptr
{}
