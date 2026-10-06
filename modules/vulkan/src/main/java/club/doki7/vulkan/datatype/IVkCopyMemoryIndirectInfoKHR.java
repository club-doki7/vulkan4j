package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkCopyMemoryIndirectInfoKHR} and {@link VkCopyMemoryIndirectInfoKHR.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkCopyMemoryIndirectInfoKHR
    extends IPointer
    permits VkCopyMemoryIndirectInfoKHR, VkCopyMemoryIndirectInfoKHR.Ptr
{}
