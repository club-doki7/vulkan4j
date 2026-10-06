package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkImportSemaphoreWin32HandleInfoKHR} and {@link VkImportSemaphoreWin32HandleInfoKHR.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkImportSemaphoreWin32HandleInfoKHR
    extends IPointer
    permits VkImportSemaphoreWin32HandleInfoKHR, VkImportSemaphoreWin32HandleInfoKHR.Ptr
{}
