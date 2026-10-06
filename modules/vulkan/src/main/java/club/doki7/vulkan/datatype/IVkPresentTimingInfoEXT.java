package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkPresentTimingInfoEXT} and {@link VkPresentTimingInfoEXT.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkPresentTimingInfoEXT
    extends IPointer
    permits VkPresentTimingInfoEXT, VkPresentTimingInfoEXT.Ptr
{}
