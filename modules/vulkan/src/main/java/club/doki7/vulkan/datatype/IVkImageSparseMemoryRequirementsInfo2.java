package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkImageSparseMemoryRequirementsInfo2} and {@link VkImageSparseMemoryRequirementsInfo2.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkImageSparseMemoryRequirementsInfo2
    extends IPointer
    permits VkImageSparseMemoryRequirementsInfo2, VkImageSparseMemoryRequirementsInfo2.Ptr
{}
