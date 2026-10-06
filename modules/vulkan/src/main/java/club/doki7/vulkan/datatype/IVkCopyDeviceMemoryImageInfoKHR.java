package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkCopyDeviceMemoryImageInfoKHR} and {@link VkCopyDeviceMemoryImageInfoKHR.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkCopyDeviceMemoryImageInfoKHR
    extends IPointer
    permits VkCopyDeviceMemoryImageInfoKHR, VkCopyDeviceMemoryImageInfoKHR.Ptr
{}
