package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkExportSemaphoreWin32HandleInfoKHR} and {@link VkExportSemaphoreWin32HandleInfoKHR.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkExportSemaphoreWin32HandleInfoKHR
    extends IPointer
    permits VkExportSemaphoreWin32HandleInfoKHR, VkExportSemaphoreWin32HandleInfoKHR.Ptr
{}
