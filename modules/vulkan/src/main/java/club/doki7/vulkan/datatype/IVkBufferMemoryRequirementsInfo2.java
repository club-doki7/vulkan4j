package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkBufferMemoryRequirementsInfo2} and {@link VkBufferMemoryRequirementsInfo2.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkBufferMemoryRequirementsInfo2
    extends IPointer
    permits VkBufferMemoryRequirementsInfo2, VkBufferMemoryRequirementsInfo2.Ptr
{}
