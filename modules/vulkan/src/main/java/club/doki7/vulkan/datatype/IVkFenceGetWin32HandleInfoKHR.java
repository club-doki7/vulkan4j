package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkFenceGetWin32HandleInfoKHR} and {@link VkFenceGetWin32HandleInfoKHR.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkFenceGetWin32HandleInfoKHR
    extends IPointer
    permits VkFenceGetWin32HandleInfoKHR, VkFenceGetWin32HandleInfoKHR.Ptr
{}
