package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkExportFenceWin32HandleInfoKHR} and {@link VkExportFenceWin32HandleInfoKHR.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkExportFenceWin32HandleInfoKHR
    extends IPointer
    permits VkExportFenceWin32HandleInfoKHR, VkExportFenceWin32HandleInfoKHR.Ptr
{}
