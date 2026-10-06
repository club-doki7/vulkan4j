package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkCopyImageInfo2} and {@link VkCopyImageInfo2.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkCopyImageInfo2
    extends IPointer
    permits VkCopyImageInfo2, VkCopyImageInfo2.Ptr
{}
