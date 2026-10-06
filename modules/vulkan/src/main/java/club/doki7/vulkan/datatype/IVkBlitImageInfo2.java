package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkBlitImageInfo2} and {@link VkBlitImageInfo2.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkBlitImageInfo2
    extends IPointer
    permits VkBlitImageInfo2, VkBlitImageInfo2.Ptr
{}
