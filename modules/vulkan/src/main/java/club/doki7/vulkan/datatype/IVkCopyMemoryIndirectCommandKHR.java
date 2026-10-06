package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkCopyMemoryIndirectCommandKHR} and {@link VkCopyMemoryIndirectCommandKHR.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkCopyMemoryIndirectCommandKHR
    extends IPointer
    permits VkCopyMemoryIndirectCommandKHR, VkCopyMemoryIndirectCommandKHR.Ptr
{}
