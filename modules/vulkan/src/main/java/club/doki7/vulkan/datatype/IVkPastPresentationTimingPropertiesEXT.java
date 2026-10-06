package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkPastPresentationTimingPropertiesEXT} and {@link VkPastPresentationTimingPropertiesEXT.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkPastPresentationTimingPropertiesEXT
    extends IPointer
    permits VkPastPresentationTimingPropertiesEXT, VkPastPresentationTimingPropertiesEXT.Ptr
{}
