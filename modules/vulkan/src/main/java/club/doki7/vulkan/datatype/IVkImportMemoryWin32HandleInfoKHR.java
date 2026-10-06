package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkImportMemoryWin32HandleInfoKHR} and {@link VkImportMemoryWin32HandleInfoKHR.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkImportMemoryWin32HandleInfoKHR
    extends IPointer
    permits VkImportMemoryWin32HandleInfoKHR, VkImportMemoryWin32HandleInfoKHR.Ptr
{}
