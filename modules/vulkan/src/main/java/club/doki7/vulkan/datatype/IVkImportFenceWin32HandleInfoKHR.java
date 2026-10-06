package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkImportFenceWin32HandleInfoKHR} and {@link VkImportFenceWin32HandleInfoKHR.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkImportFenceWin32HandleInfoKHR
    extends IPointer
    permits VkImportFenceWin32HandleInfoKHR, VkImportFenceWin32HandleInfoKHR.Ptr
{}
