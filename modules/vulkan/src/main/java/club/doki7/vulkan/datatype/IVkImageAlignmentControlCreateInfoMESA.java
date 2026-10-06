package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkImageAlignmentControlCreateInfoMESA} and {@link VkImageAlignmentControlCreateInfoMESA.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkImageAlignmentControlCreateInfoMESA
    extends IPointer
    permits VkImageAlignmentControlCreateInfoMESA, VkImageAlignmentControlCreateInfoMESA.Ptr
{}
