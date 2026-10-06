package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkPresentTimingsInfoEXT} and {@link VkPresentTimingsInfoEXT.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkPresentTimingsInfoEXT
    extends IPointer
    permits VkPresentTimingsInfoEXT, VkPresentTimingsInfoEXT.Ptr
{}
