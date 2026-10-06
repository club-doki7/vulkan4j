package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkBindMemoryStatus} and {@link VkBindMemoryStatus.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkBindMemoryStatus
    extends IPointer
    permits VkBindMemoryStatus, VkBindMemoryStatus.Ptr
{}
