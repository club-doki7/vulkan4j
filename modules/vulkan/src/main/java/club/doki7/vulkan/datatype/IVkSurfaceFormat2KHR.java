package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkSurfaceFormat2KHR} and {@link VkSurfaceFormat2KHR.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkSurfaceFormat2KHR
    extends IPointer
    permits VkSurfaceFormat2KHR, VkSurfaceFormat2KHR.Ptr
{}
