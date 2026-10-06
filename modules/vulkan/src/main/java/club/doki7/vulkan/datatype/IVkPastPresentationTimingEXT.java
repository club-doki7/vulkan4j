package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkPastPresentationTimingEXT} and {@link VkPastPresentationTimingEXT.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkPastPresentationTimingEXT
    extends IPointer
    permits VkPastPresentationTimingEXT, VkPastPresentationTimingEXT.Ptr
{}
