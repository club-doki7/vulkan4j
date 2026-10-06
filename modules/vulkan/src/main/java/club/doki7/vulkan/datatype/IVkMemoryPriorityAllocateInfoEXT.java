package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkMemoryPriorityAllocateInfoEXT} and {@link VkMemoryPriorityAllocateInfoEXT.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkMemoryPriorityAllocateInfoEXT
    extends IPointer
    permits VkMemoryPriorityAllocateInfoEXT, VkMemoryPriorityAllocateInfoEXT.Ptr
{}
