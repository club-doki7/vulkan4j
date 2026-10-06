package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkCopyMemoryToImageIndirectInfoKHR} and {@link VkCopyMemoryToImageIndirectInfoKHR.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkCopyMemoryToImageIndirectInfoKHR
    extends IPointer
    permits VkCopyMemoryToImageIndirectInfoKHR, VkCopyMemoryToImageIndirectInfoKHR.Ptr
{}
