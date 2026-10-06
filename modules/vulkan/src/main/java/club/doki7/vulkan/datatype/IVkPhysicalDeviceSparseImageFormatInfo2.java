package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkPhysicalDeviceSparseImageFormatInfo2} and {@link VkPhysicalDeviceSparseImageFormatInfo2.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkPhysicalDeviceSparseImageFormatInfo2
    extends IPointer
    permits VkPhysicalDeviceSparseImageFormatInfo2, VkPhysicalDeviceSparseImageFormatInfo2.Ptr
{}
