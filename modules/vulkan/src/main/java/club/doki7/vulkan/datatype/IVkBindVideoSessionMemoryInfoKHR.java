package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkBindVideoSessionMemoryInfoKHR} and {@link VkBindVideoSessionMemoryInfoKHR.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkBindVideoSessionMemoryInfoKHR
    extends IPointer
    permits VkBindVideoSessionMemoryInfoKHR, VkBindVideoSessionMemoryInfoKHR.Ptr
{}
