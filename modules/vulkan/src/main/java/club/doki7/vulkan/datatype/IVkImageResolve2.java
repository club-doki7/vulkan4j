package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkImageResolve2} and {@link VkImageResolve2.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkImageResolve2
    extends IPointer
    permits VkImageResolve2, VkImageResolve2.Ptr
{}
