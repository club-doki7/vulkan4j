package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkResolveImageModeInfoKHR} and {@link VkResolveImageModeInfoKHR.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkResolveImageModeInfoKHR
    extends IPointer
    permits VkResolveImageModeInfoKHR, VkResolveImageModeInfoKHR.Ptr
{}
