package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkDeviceMemoryCopyKHR} and {@link VkDeviceMemoryCopyKHR.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkDeviceMemoryCopyKHR
    extends IPointer
    permits VkDeviceMemoryCopyKHR, VkDeviceMemoryCopyKHR.Ptr
{}
