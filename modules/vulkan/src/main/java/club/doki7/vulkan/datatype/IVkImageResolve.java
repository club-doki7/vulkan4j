package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkImageResolve} and {@link VkImageResolve.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkImageResolve
    extends IPointer
    permits VkImageResolve, VkImageResolve.Ptr
{}
