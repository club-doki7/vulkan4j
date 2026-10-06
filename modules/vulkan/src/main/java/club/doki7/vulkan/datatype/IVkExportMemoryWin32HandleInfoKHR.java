package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkExportMemoryWin32HandleInfoKHR} and {@link VkExportMemoryWin32HandleInfoKHR.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkExportMemoryWin32HandleInfoKHR
    extends IPointer
    permits VkExportMemoryWin32HandleInfoKHR, VkExportMemoryWin32HandleInfoKHR.Ptr
{}
