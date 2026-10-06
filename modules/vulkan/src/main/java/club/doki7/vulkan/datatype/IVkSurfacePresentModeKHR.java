package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkSurfacePresentModeKHR} and {@link VkSurfacePresentModeKHR.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkSurfacePresentModeKHR
    extends IPointer
    permits VkSurfacePresentModeKHR, VkSurfacePresentModeKHR.Ptr
{}
