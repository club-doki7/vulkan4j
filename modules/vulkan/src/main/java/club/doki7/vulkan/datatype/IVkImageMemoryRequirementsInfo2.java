package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkImageMemoryRequirementsInfo2} and {@link VkImageMemoryRequirementsInfo2.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkImageMemoryRequirementsInfo2
    extends IPointer
    permits VkImageMemoryRequirementsInfo2, VkImageMemoryRequirementsInfo2.Ptr
{}
