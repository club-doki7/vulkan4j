package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkDeviceMemoryImageCopyKHR} and {@link VkDeviceMemoryImageCopyKHR.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkDeviceMemoryImageCopyKHR
    extends IPointer
    permits VkDeviceMemoryImageCopyKHR, VkDeviceMemoryImageCopyKHR.Ptr
{}
