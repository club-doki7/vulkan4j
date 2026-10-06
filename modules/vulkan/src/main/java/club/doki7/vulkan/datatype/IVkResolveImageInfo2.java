package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkResolveImageInfo2} and {@link VkResolveImageInfo2.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkResolveImageInfo2
    extends IPointer
    permits VkResolveImageInfo2, VkResolveImageInfo2.Ptr
{}
