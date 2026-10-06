package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkSurfaceFormatKHR} and {@link VkSurfaceFormatKHR.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkSurfaceFormatKHR
    extends IPointer
    permits VkSurfaceFormatKHR, VkSurfaceFormatKHR.Ptr
{}
