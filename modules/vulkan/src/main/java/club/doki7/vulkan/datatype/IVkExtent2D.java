package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkExtent2D} and {@link VkExtent2D.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkExtent2D
    extends IPointer
    permits VkExtent2D, VkExtent2D.Ptr
{}
